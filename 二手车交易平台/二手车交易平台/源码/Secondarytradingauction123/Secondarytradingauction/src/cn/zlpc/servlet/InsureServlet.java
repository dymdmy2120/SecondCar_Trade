package cn.zlpc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.mastery.core.CharacterUtil;
import tool.mastery.exception.DBException;
import cn.zlpc.dao.BaseDao;
import cn.zlpc.exception.ErrorException;
import cn.zlpc.po.SourceImg;
import cn.zlpc.po.Vehicle;
import cn.zlpc.service.SingleService;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class InsureServlet extends HttpServlet {
	ServletConfig config = null;

	/*
	 * (非 Javadoc)
	 * 
	 * <p>Title: init</p>
	 * 
	 * <p>Description: 获取JSP页面的配置config </p>
	 * 
	 * @param config
	 * 
	 * @throws ServletException
	 * 
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> info = new ArrayList<String>();
		/*********** 图片上传处理 ***************/
		String simg_path = "";
		// 新建一个SmartUpload对象
		SmartUpload su = new SmartUpload();

		// 上传初始化
		su.initialize(config, request, response);

		// 上传文件
		try {
			su.upload();
			// 将上传文件全部保存到指定目录
			com.jspsmart.upload.File file = su.getFiles().getFile(0); // 获得上传的文件
			if (file.getFileExt() == "") {
				simg_path = "";
			} else {
				String fileName = "";
				try {
					
					List<Object> list = new BaseDao().queryForSingle(
							SourceImg.class, 0, 0, null, null, null, false);
					int simg_id = 1;
					if(list.size() != 0) {
						simg_id = ((SourceImg)list.get(0)).getSimg_id() + 1;
					}
					fileName = simg_id + "." + file.getFileExt();
				} catch (DBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				file.saveAs("/VehiclePicture/Insure/" + fileName, SmartUpload.SAVE_AUTO); // 将文件保存在
																			// 服务器端的upload文件夹中
				simg_path = "VehiclePicture/Insure/" + fileName; // 得到文件名 ,设置文件名用来保存在数据库中
			}
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}

		/************** 数据定义区 *****************/
		
		String name = su.getRequest().getParameter("simg_name");
		SourceImg si = new SourceImg();
		si.setSimg_name(name);
		si.setSimg_path(simg_path);
		List<Object> beans = new ArrayList<Object>();
		beans.add(si);
		SingleService service = new SingleService(beans);
		try {
			service.execute("add");
		} catch (ErrorException e) {
			info.add(e.getMessage());
		}
		if(info.size() == 0) {
			info.add("恭喜您！操作成功！");
		}
		request.setAttribute("info", info);
		request.getRequestDispatcher("QueryServlet?view=SourceImg").forward(request, response);
		
	}

}
