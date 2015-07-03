package tool.mastery.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC操作的工具类,加载数据库驱动,获取数据库连接
 * 
 * @author AntsMarch
 * 
 */
public class DBUtil {
	private static Connection conn = null;
	private static String databaseName = null;
	private static String username = null;
	private static String password = null;

	private DBUtil() {
	}

	/**
	 * 加载数据库连接驱动
	 */
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		InputStream is = DBUtil.class.getClassLoader().getResourceAsStream(
				"db.properties");
		Properties prop = new Properties();
		try {
			prop.load(is);

			databaseName = prop.getProperty("DATABASENAME");
			username = prop.getProperty("USERNAME");
			password = prop.getProperty("PASSWORD");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return Connection conn
	 */
	public static Connection getConnection() {
		// String url =
		// "jdbc:mysql://localhost:3306/food_quarantine?useUnicode=true&characterEncoding=utf8";
		String url = "jdbc:mysql://localhost:3306/" + databaseName
				+ "?useUnicode=true&characterEncoding=utf8";
		try {
			// conn = DriverManager.getConnection(url, "root", "root");
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
	
	public static void close(ResultSet rs,PreparedStatement pst,Connection con){
		try{
			if(rs!=null){
				rs.close();
			}
			if(pst!=null){
				pst.close();
			}
			if(con!=null){
				con.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public static void close() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: getPstmt
	 * 
	 * @Description: TODO 获取数据库的预处理命令类PreparedStatement
	 * 
	 * @param conn
	 *            数据库的连接
	 * @param sql
	 *            需要执行的sql语句
	 * @param
	 * 
	 * @return PreparedStatement 返回类型
	 * 
	 * @throws
	 */
	public static PreparedStatement getPstmt(Connection conn, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	}

	/**
	 * @Title getPstmt
	 * @param conn
	 * @param sql
	 * @Discription 获取数据库处理对象
	 * @return PreparedStatement
	 */
	public static PreparedStatement getPstmt(Connection conn, String sql,
			int autoGenerateKeys) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql, autoGenerateKeys);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	}

	/**
	 * 
	 * @Title: getRs
	 * 
	 * @Description: TODO 获取结果集
	 * 
	 * @param pstmt
	 *            PreparedStatement对象
	 * @param
	 * 
	 * @return ResultSet 返回类型
	 * 
	 * @throws
	 */
	public static ResultSet getRs(PreparedStatement pstmt) {
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 
	 * @Title: close
	 * 
	 * @Description: TODO 关闭结果集的连接
	 * 
	 * @param rs
	 *            结果集
	 * 
	 * @return void 返回类型
	 * 
	 * @throws
	 */
	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}
	}

	/**
	 * 
	 * @Title: close
	 * 
	 * @Description: TODO 关闭PreparedStatement的连接
	 * 
	 * @param pstmt
	 * 
	 * @return void 返回类型
	 * 
	 * @throws
	 */
	public static void close(PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pstmt = null;
		}
	}

	/**
	 * 
	 * @Title: closeDatabase
	 * 
	 * @Description: TODO 关闭所有连接
	 * 
	 * @param rs
	 * @param pstmt
	 * 
	 * @return void 返回类型
	 * 
	 * @throws
	 */
	public static void closeDatabase(ResultSet rs, PreparedStatement pstmt) {
		DBUtil.close(rs);
		DBUtil.close(pstmt);
	}

}
