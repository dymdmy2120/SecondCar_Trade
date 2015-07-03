package cn.zlpc.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;

import cn.zlpc.dao.impl.VehicleVoDaoImpl;

/**
 * 保存文件 使用Fileupload插件
 * 
 * @author Administrator
 * 
 */
public class SaveFile {

	private String extName = null;
	private String savePath = null; // 保存的文件路径
	private String folderName = null; // 保存的文件文件夹名称
	private List<FileItem> fileList = null; // 得到上传的文件集合
	private HttpServletRequest req = null;

	/**
	 * 对外提供的保存方法
	 * 
	 * @return
	 * @throws IOException
	 */
	public Boolean save() throws IOException {

		Boolean flag = false;
		int temp = 0; // 用于组合文件名称

		savePath = savePath + File.separator + folderName;
		File f1 = new File(savePath);
		System.out.println(savePath);

		if (!f1.exists()) {
			f1.mkdirs(); // 创建一系列文件路径文件夹
		}

		Iterator<FileItem> iter = fileList.iterator();
		while (iter.hasNext()) {

			FileItem item = iter.next();

			if (!item.isFormField()&&!item.getString().equals("")) { // 判断是否是上传文件

				InputStream input = null;
				OutputStream output = null;
				input = item.getInputStream();

				File file = null;
				
				do {
					temp = temp + 1;
					String fileName = temp + "."
							+ item.getName().split("\\.")[1]; // 拼接上传文件的名称
					file = new File(savePath + File.separator + fileName);
				} while (file.exists()); // 判断文件是否存在

				System.out.println("上传的文件名称:" + file);
				output = new FileOutputStream(file);

				byte data[] = new byte[512];
				while ((input.read(data, 0, 512)) != -1) {
					output.write(data);
				}
				input.close();
				output.close();
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 根据传入的HttpServletRequest 得到项目路径,同时根据HttpServletRequest和 folderName 得到文件夹名称
	 * 通常folderName都是HttpServletRequest对象中的一个控件名称。 通常出现该方法调用多是需要根据前台表单的控件值
	 * 来命名文件夹,同时保存路径是项目下
	 * 
	 * @param folderName
	 * @param req
	 * @param
	 * @throws UnsupportedEncodingException 
	 */
	public SaveFile(String folderName, HttpServletRequest req, String extName) throws UnsupportedEncodingException {
		super();
		this.req = req;
		this.fileList = WebUtils.list; //list赋值
		 String savePath = req.getServletContext() .getRealPath(""); //文件保存的路径
		//String savePath = "E:";
		this.folderName = findNo();
		this.savePath = savePath + File.separator + extName;
		
		if (folderName == null) {
			new RuntimeException("存放上传文件的文件夹名称不存在，系统将采用默认的文件夹名称:upload");
		}

		
	}


	/**
	 * 得到车牌号 作为文件夹名称
	 * 
	 * @param iter
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private String findNo() throws UnsupportedEncodingException {
		Iterator<FileItem> iter = fileList.iterator(); // 得到所有的属性项
		String temp = null;
		while (iter.hasNext()) {
			FileItem item = iter.next();
			if (item.isFormField() && item.getFieldName().equals("v_id")) {
				temp = item.getString();
				break;
			}
		}
		if(temp == null) {
			temp = new VehicleVoDaoImpl().getNewVid().toString();
		}
		return temp;
	}
}
