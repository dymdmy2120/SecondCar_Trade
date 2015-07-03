package cn.zlpc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.mastery.core.CollectionFormUtil;
import cn.zlpc.exception.ErrorException;
import cn.zlpc.po.User;
import cn.zlpc.service.UserService;

/**
 * 用于针对会员中心所有的用户操作的Servlet
 * 
 * @author mastery
 * 
 */
public class UserServlet extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		User user = null;
		List<String> info = new ArrayList<String>();
		String[] operate = request.getParameter("operate").split("\\.");
		List<Object> beans = (List<Object>) CollectionFormUtil.parseRequest(
				request, operate[0]);
		UserService service = new UserService();
		try {
			user = service.execute(beans, operate[1]);
			System.out.println("u_id为" + user.getU_id());
		} catch (ErrorException e) {
			info.add(e.getMessage());
		}
		if (info.size() == 0) {
			info.add("恭喜您！操作成功！");
		}
		if (user != null) {
			session.setAttribute("user", user);
		}
		request.setAttribute("info", info);
		String dispatcherPath = "";
		if (operate[0].equalsIgnoreCase("User")) {
			dispatcherPath = "QueryServlet?view=User&queryCondition=u_id&queryValue=" + user.getU_id();
		} else {
			dispatcherPath = "user_file/UserInfo/User_password.jsp";
		}
		request.getRequestDispatcher(dispatcherPath).forward(request, response);
	}

}
