/**
 * 
 */
package cn.zlpc.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tool.mastery.core.ConvertUtil;
import tool.mastery.db.DBUtil;
import tool.mastery.exception.DBException;

/**
 * @author ASUS
 * 
 */
public class VoConvertObj {

	/**
	 * 根据查询的值通过set方法将vo字节码转换成vo对象
	 * 
	 * @param voClass
	 *            传入的vo字节码
	 * @param rs
	 *            经过多表查询后的结果集
	 * @return 得到所有查询后的对象集合
	 * @throws DBException
	 */
	public List<Object> convertVoObj(Class<?> voClass, ResultSet rs)
			throws DBException {
		try {
			List<Object> listVoObj = new ArrayList<Object>();
			while (rs.next()) {
				Object t = voClass.newInstance();
				// 获取实体类的所有属性，返回Field数组
				Field[] fields = voClass.getDeclaredFields();
				for (Field field : fields) {// --for() begin
					PropertyDescriptor pd = new PropertyDescriptor(
							field.getName(), voClass);
					Method wM = pd.getWriteMethod();// 获得写方法
					Object fieldValue = null;
					// 如果类型是String
					if (field.getGenericType().toString()
							.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
						if (field.getName().equals("bidTime")
								|| field.getName().equals("bidEndTime")) {
							Date date = (Date) rs.getObject(field.getName());
							fieldValue = ConvertUtil.getFormalDate(date);
						} else {
							fieldValue = rs.getString(field.getName());
						}
					} else if (field.getGenericType().toString()
							.equals("class java.lang.Integer")) {// 如果类型是Integer
						// 拿到该属性的settet方法
						Integer value = null;
						String sql = null;
						if (field.getName().equals("attCou")) {// 若字段名为关注人数
							sql = "select count(*) attCou from t_userpart where attention=1 and v_id="
									+ rs.getInt(5);
						} else if (field.getName().equals("allowCou")) {// 若字段名为关注人数
							sql = "select count(*) allowCou from t_userpart where v_id="
									+ rs.getInt(5) + " and state = 1";
							
						} else if(field.getName().equals("applyCou")){
							sql = "select count(*) applyCou from t_userpart where state in (0,1) and v_id="
									+ rs.getInt(5);
						}
						if(sql != null) {
							Connection conn = DBUtil.getConnection();
							PreparedStatement preparedStatment = DBUtil
									.getPstmt(conn, sql);
							ResultSet rs1 = DBUtil.getRs(preparedStatment);
							while (rs1.next()) {
								value = rs1.getInt(1);
							}
							//System.out.println(value+"value");
							DBUtil.closeDatabase(rs1, preparedStatment);
							try {
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								new DBException("连接关闭异常!");
							}
						}else {
							value = rs.getInt(field.getName());
						}
						fieldValue = value;
					}else {
						fieldValue = rs.getObject(field.getName());
					}
					wM.invoke(t, fieldValue);// 调用settet方法获取属性值
					// 如果还需要其他的类型请自己做扩展
				}// for() --end
				listVoObj.add(t);
			}
			return listVoObj;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("查询异常!");
		}

	}

	private static String getMethodName(String fildeName) throws Exception {
		byte[] items = fildeName.getBytes();
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}

}
