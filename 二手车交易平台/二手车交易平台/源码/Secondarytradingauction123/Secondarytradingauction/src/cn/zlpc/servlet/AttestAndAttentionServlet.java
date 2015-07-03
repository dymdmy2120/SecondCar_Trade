package cn.zlpc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zlpc.dao.impl.UserPartDaoImpl;

import tool.mastery.core.CollectionFormUtil;
import tool.mastery.exception.DBException;

public class AttestAndAttentionServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=utf-8"); 
		PrintWriter out = response.getWriter();
		Object bean = CollectionFormUtil.parseObjectRequest(request, "Userpart");
		UserPartDaoImpl updi = new UserPartDaoImpl();
		String info = null;
		try {
			updi.insert(bean);
		} catch (DBException e) {
			info = e.getMessage();
		}
		if(info != null) {
			out.print(info);
		}else {
			out.print("恭喜您！操作成功！请及时与客服联系完成拍卖流程！");
		}
	}

}
