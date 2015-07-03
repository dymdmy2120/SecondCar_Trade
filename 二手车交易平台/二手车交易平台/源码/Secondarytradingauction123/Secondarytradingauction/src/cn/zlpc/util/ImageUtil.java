package cn.zlpc.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class ImageUtil {
	public static String GET_PATH = null;
	public static String SHOW_PATH = null;
	
	/**
	 *@Author linhao007
	 *@Decration 获取单个车牌号下面的多个图片，并返回一个List集合
	 * @param path
	 * @param path1
	 * @return
	 */
	public static List<String> getImage(String path,String path1){
		 
        List<String> ImgList = new ArrayList<String>();
        String names = null; 
        //          读取图片信息
        try { 
        File f = new File(path); 
        if (f.isDirectory()){ 
          File[] fList = f.listFiles(); 
          for (int j = 0; j < fList.length; j++) { 
                  File file = fList[j]; 
                  if (file.isFile()) { 
                  	ImgList.add(path1+file.getName());
                  	if(ImgList.size() >= 7) {
                  		break;
                  	}
                  } 
              } 
          } 
        } catch (Exception e){
      	  e.printStackTrace();
      	  System.out.println("读取错误");
        } 
       return ImgList;
	}
	
	
	public static void setPath(HttpServletRequest request) {
		
		if(ImageUtil.GET_PATH == null || ImageUtil.SHOW_PATH == null) {
			ImageUtil.GET_PATH = request.getSession().getServletContext()
	  				.getRealPath("/")+"VehiclePicture\\"; //获得图片的路径
			ImageUtil.SHOW_PATH = "VehiclePicture/"; //显示图片路径
		}
	}
	
	public static boolean deleteFile(String imageUrl) {
		String path = ImageUtil.GET_PATH.substring(0,ImageUtil.GET_PATH.length()-15);
		imageUrl = path + imageUrl;
		File file = new File(imageUrl);
		if(file.exists()) {
			return file.delete();
		}
		return false;
	}
	
}
