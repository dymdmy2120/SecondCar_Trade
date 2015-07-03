package cn.zlpc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.mastery.core.CharacterUtil;

import cn.zlpc.dao.impl.AuctionDaoImpl;

public class SaveAuctionServlet extends HttpServlet {

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
		System.out.println("start AuctionSevlet");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String user = request.getParameter("user");
		String finalPrice = request.getParameter("finalPrice");
		String v_id = request.getParameter("v_id");
		
		Boolean updateFlag = new AuctionDaoImpl().saveForAuction(user, Integer.parseInt(v_id),
				finalPrice);
		if (updateFlag) {
			
		} else {

		}
	}

	public void init() throws ServletException {
	}

}
