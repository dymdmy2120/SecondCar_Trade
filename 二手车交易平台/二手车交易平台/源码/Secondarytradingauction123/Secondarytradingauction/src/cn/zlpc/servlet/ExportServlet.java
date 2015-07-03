package cn.zlpc.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import tool.mastery.exception.DBException;
import cn.zlpc.dao.impl.BusinessBooksDaoImpl;
import cn.zlpc.exception.ErrorException;
import cn.zlpc.util.DbToExcel;
import cn.zlpc.util.GetMoth;
import cn.zlpc.vo.Page;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class ExportServlet extends HttpServlet {

	private ServletConfig config;
	final public void init(ServletConfig config) throws ServletException {
		super.init(config);  //只有调用了父类的init方法把tomact传过来的config传过去下面的getServletContext()方法才起作用
		this.config=config;
	}

	final public ServletConfig getServletConfig() {
	return config;
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/x-msdownload");
		String path = this.getServletContext().getRealPath("/");
		PageContext pageContext = pageContext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null,  true, 8192, true);
		String  fileName = GetMoth.getMoth()+"M-BusinessRecords.xls";
		String filepath = path+"temp"+File.separator+fileName;
		BusinessBooksDaoImpl bbDao = new BusinessBooksDaoImpl();
		List<Object> content = null;
		try {
			content = bbDao.listVo(new Page(), null, null);
		} catch (DBException e1) {
			e1.printStackTrace();
		}
		DbToExcel.exportBusinessBooks(filepath, content);
		
		response.setHeader("Content-Disposition",
				"attachment; filename=" +fileName);
		FileInputStream in = null;
		ServletOutputStream out = null;
		try{
			System.out.println(fileName+"fileName");
		in = new FileInputStream(filepath);
		out = response.getOutputStream();
		out.flush();
		int aRead = 0;
		while ((aRead = in.read()) != -1 & in != null) {
			out.write(aRead);
		}
		out.flush();
		}catch(ErrorException e){
			
			
		} finally {
			
				in.close();
				out.close();
			
		}
		
		
		
	}
}
