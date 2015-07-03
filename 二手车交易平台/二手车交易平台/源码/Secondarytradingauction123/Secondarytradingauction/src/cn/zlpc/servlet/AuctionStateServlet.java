package cn.zlpc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.zlpc.po.User;

public class AuctionStateServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String user = request.getParameter("user");
		if (request.getSession().getAttribute("user") == null) {
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		} else if (((User) request.getSession().getAttribute("user")).getU_id()
				.equals(user)) {
			request.getRequestDispatcher(
					"user_file/NetworkAuction/NetworkAuction.jsp?auction=1")
					.forward(request, response);
		} else {
			request.getRequestDispatcher(
					"user_file/NetworkAuction/NetworkAuction.jsp?auction=0")
					.forward(request, response);
		}

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
