package cn.zlpc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.mastery.exception.DBException;
import cn.zlpc.dao.impl.AuctionDaoImpl;
import cn.zlpc.po.User;
import cn.zlpc.vo.CurrContest;

public class AutionForListServlet extends HttpServlet {

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
		List<CurrContest> auctionInfo = null;

		try {
			if (request.getSession().getAttribute("user") == null) {
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			} else {
				auctionInfo = new AuctionDaoImpl().getAuctionVehicle(
						((User) request.getSession().getAttribute("user"))
								.getU_id(), 1, "state");
				if (auctionInfo.size() != 0) {
					request.setAttribute("auctionInfo", auctionInfo);
				} else {
					request.setAttribute("message", "暂无登记车辆，请先登记车辆并缴纳保证金！");
				}
				request.getRequestDispatcher(
						"user_file/NetworkAuction/AuctionForList.jsp").forward(
						request, response);
			}
		} catch (DBException e) {

			e.printStackTrace();
		}

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
