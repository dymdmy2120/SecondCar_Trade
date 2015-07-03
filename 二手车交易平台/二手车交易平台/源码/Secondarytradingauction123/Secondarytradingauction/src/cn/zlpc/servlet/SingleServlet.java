package cn.zlpc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zlpc.exception.ErrorException;
import cn.zlpc.service.SingleService;

/**
 * 用于针对由单个po组成统一提交的Servlet
 * 
 * @author mastery
 * 
 */
public class SingleServlet extends HttpServlet {

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
		// 获得表单中的元素
		List<Object> beans = (List<Object>) request.getAttribute("beans");
		// 接收完成后移除
		request.removeAttribute("beans");
		String[] operate = request.getParameter("operate").split("\\.");
		SingleService service = new SingleService(beans);
		try {
			service.execute(operate[1]);
		} catch (ErrorException e) {
			info.add(e.getMessage());
		}
		if (info.size() == 0) {
			info.add("恭喜您,操作成功!");
		}

		String dispatcherPath = null;
		if (operate[1].equalsIgnoreCase("add")) {
			dispatcherPath = "backstage/" + operate[0] + "/"
					+ request.getParameter("operate").replace(".", "_")
					+ ".jsp";
		} else {
			dispatcherPath = "QueryServlet?view=" + operate[0];
		}
		request.setAttribute("info", info);
		request.getRequestDispatcher(dispatcherPath).forward(request, response);
	}

}
