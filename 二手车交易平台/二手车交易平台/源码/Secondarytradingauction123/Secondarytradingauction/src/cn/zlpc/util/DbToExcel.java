package cn.zlpc.util;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cn.zlpc.dao.impl.BusinessBooksDaoImpl;
import cn.zlpc.vo.BusinessBooks;
import cn.zlpc.vo.Page;


public class DbToExcel {
	/*
	 * 获取类的变量名称；
	 */
	public static List getProperty(Class<?> demo){
		List list=new ArrayList();
		Field[] fields=demo.getDeclaredFields();
		for(int i=0;i<fields.length;i++){
			String name=fields[i].getName();
			list.add(name);
		}
		return list;
	}
	/*
	 * 获取类的变量内容；
	 */
	public static List getVariableValue(Object o,Field[] fields) throws Exception{
		List list=new ArrayList();
		Class<?> demo=o.getClass();
		for(int i=0;i<fields.length;i++){
			Object value;
			Method m= (Method) o.getClass().getMethod(  
			        "get" + DbToExcel.getMethodName(fields[i].getName()));
			value=m.invoke(o);
			list.add(value);
		}
		return list;
	}
	/*
	 * 将变量名首写字母变大写；
	 */
	private static String getMethodName(String fildeName) throws Exception{  
        byte[] items = fildeName.getBytes();  
        items[0] = (byte) ((char) items[0] - 'a' + 'A');  
        return new String(items);  
    }  
	/*
	 * 创建excel
	 */
	public static void createExcel(List<Object> result,Class<?> demo,String fileName,List<String> titleContent) throws Exception{
		HSSFWorkbook excel=new HSSFWorkbook();
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		String strT = year+"年"+month;
		HSSFSheet sheet=excel.createSheet(strT+"月车辆竞拍业务记录");
		List classProperty=DbToExcel.getProperty(demo);
		int cols=classProperty.size();
		HSSFRow row=sheet.createRow((short)0);
		for(int j=0;j<cols;j++){
			String val=titleContent.get(j);
			DbToExcel.createCell(excel,row,(short)j,HSSFCellStyle.ALIGN_CENTER_SELECTION, val);
		}
		for(int i=0;i<result.size();i++){
			BusinessBooks bbs=(BusinessBooks)result.get(i);
			row=sheet.createRow((short)(i+1));
			Field[] fields=demo.getDeclaredFields();
			List r=DbToExcel.getVariableValue(bbs, fields);//获得所有
			for(int col=0;col<cols;col++){
				String val=String.valueOf(r.get(col));
				DbToExcel.createCell(excel,row,(short)col,HSSFCellStyle.ALIGN_CENTER_SELECTION, val);
			}
		}
		FileOutputStream fileOut=new FileOutputStream(fileName);
		excel.write(fileOut);
		fileOut.close();
	}
	/*
	 * 创建列；
	 */
	private static void createCell(HSSFWorkbook wb,HSSFRow row,short col,short align,String val){
		HSSFCell cell=row.createCell(col);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue(val);
		HSSFCellStyle cellstyle=wb.createCellStyle();
		cellstyle.setAlignment(align);
		cell.setCellStyle(cellstyle);
	}
	
	public static void exportBusinessBooks(String fileName,List<Object> content){
		Class<?> clazz;
		List<String> titleContent = new ArrayList<String>();
		titleContent.add("日期");
		titleContent.add("竞拍车辆编号");
		titleContent.add("车辆来源");
		titleContent.add("竞拍底价");
		titleContent.add("竞拍是否成功");
		titleContent.add("成交价格");
		titleContent.add("竞拍成功会员");
		titleContent.add("竞拍人数");
		String fileTitle = null;
		try {
			clazz = Class.forName("cn.zlpc.vo.BusinessBooks");
			DbToExcel.createExcel(content, clazz, fileName,titleContent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) throws Exception{
//		String fileName="d:\\test.xls";
//		BusinessBooksDaoImpl bbDao = new BusinessBooksDaoImpl();
//		List<Object> result = bbDao.listVo(new Page(), null, null);
//		DbToExcel.exportBusinessBooks(fileName,result);
//	}
}
