package cn.zlpc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.mastery.exception.DBException;
import cn.zlpc.dao.BaseDao;
import cn.zlpc.po.Admin;

public class AdminUpdatePass extends HttpServlet {

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
		HttpSession session = request.getSession();
		String oldPassword = request.getParameter("password");
		String newPassword = request.getParameter("password1");
		String superWord = request.getParameter("superword");
		List<String> info = new ArrayList<String>();
		Admin admin = (Admin) session.getAttribute("admin");
		if (!admin.getPasword().equals(oldPassword)) {
			info.add("原始密码错误！无法修改");
		} else {
			if (!BaseDao.superword.equals(superWord)) {
				info.add("超级管理员密码错误！无法修改");
			} else {
				admin.setPasword(newPassword);
				try {
					new BaseDao().update(admin);
					info.add("修改成功");
				} catch (DBException e) {
					info.add("修改失败！" + e.getMessage());
				}
				session.setAttribute("admin", admin);
			}
		}
		request.setAttribute("info", info);
		request.getRequestDispatcher("backstage/update_pass.jsp").forward(request, response);
	}

}
