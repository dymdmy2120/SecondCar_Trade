package cn.zlpc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zlpc.util.SaveFile;

public class UploadPictureServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request,response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String v_id = request.getParameter("albumName"); //得到车牌号
		System.out.println("v_id" + v_id);
		HttpServletRequest req = (HttpServletRequest) request;
		if (new SaveFile(v_id, req, "VehiclePicture").save()== true) { //保存文件 
		
			System.out.println("文件上传成功！！");
		}
	}

}
