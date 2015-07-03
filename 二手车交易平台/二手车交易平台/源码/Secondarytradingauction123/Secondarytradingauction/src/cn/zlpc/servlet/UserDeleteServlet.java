package cn.zlpc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zlpc.exception.ErrorException;
import cn.zlpc.service.UserManagerService;

public class UserDeleteServlet extends HttpServlet {

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
		String voName = request.getParameter("operate").split("\\.")[0];
		//判断是否批准
		String state = request.getParameter("state");
		String[] ids = request.getParameterValues("u_id");
		UserManagerService service = new UserManagerService(voName);
		List<String> info = new ArrayList<String>();
		try {
			service.delete(ids , state);
		} catch (ErrorException e) {
			info.add(e.getMessage());
		}
		if(info.size() == 0) {
			info.add("恭喜您,操作成功！");
		}
		request.setAttribute("info", info);
		String dispatcherPath = "QueryServlet?view=" + voName;
		request.getRequestDispatcher(dispatcherPath).forward(request, response);
	}

}
