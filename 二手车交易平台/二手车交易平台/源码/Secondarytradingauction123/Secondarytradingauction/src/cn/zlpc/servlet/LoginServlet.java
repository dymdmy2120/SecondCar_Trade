package cn.zlpc.servlet;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zlpc.po.Admin;
import cn.zlpc.po.User;
import cn.zlpc.service.LoginService;
import cn.zlpc.servlet.filter.OnlineUser;
import cn.zlpc.util.ImageUtil;

public class LoginServlet extends HttpServlet {
	public LoginServlet() {
		super();
	}

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
		ImageUtil.setPath(request);
		HttpSession session = request.getSession();
		List<String> info = new ArrayList<String>();// 返回提示信息的容器

		String operate = request.getParameter("operater");
		String isbackFalg = null;
		String fogetFalg = null;
		// 管理人员登入
		if ("adminlogin".equalsIgnoreCase(operate)) {
			String admin1 = request.getParameter("admin");
			String psd1 = request.getParameter("pasword");
			Admin admin = new Admin();
			admin.setAdmin(admin1);
			admin.setPasword(psd1);
			LoginService loginService = new LoginService(operate, admin);
			Admin result = null;
			result = loginService.getAdminResult();
			if (result == null) {
				info.add("账号或密码错误");
				request.setAttribute("info", info);
				request.getRequestDispatcher("admin_login.jsp").forward(
						request, response);
			} else {
				session.setAttribute("admin", result);
				response.sendRedirect("admin.html");
				/*request.getRequestDispatcher("backstage.jsp").forward(request,
						response);*/
			}

		} else {
			if (operate.split("\\.").length == 2) {
				isbackFalg = operate.split("\\.")[1];
				fogetFalg = operate.split("\\.")[1];
				operate = operate.split("\\.")[0];
			}
			Map<String, String> formContent = new HashMap<String, String>();
			Enumeration<?> enu = request.getParameterNames();
			while (enu.hasMoreElements()) {
				String keyValue = (String) enu.nextElement();
				String value = request.getParameter(keyValue);
				formContent.put(keyValue, value);
			}
			User user = this.getUser(formContent);
			if (operate.equals("forgetPws")
					&& "frist".equals(fogetFalg) == false) {
				String uid = (String) session.getAttribute("UID");
				if (uid != null && "ajax".equals(isbackFalg) == false) {
					user.setU_id(uid);
				}
			}

			if (operate.equals("answer")) {
				String uid = (String) session.getAttribute("UID");
				if (uid != null) {
					user.setU_id(uid);
				}
			}
			if (operate.equals("findBack")) {
				String uid = (String) session.getAttribute("UID");
				if (uid != null) {
					user.setU_id(uid);
				}
			}

			LoginService loginService = new LoginService(operate, user);
			User result = null;
			result = loginService.getUserResult();

			if (operate.equals("login")) {
				if (result == null) {
					info.add("账号或密码错误，登录失败！");
				} else {
					//如果这个用户不在线的话
		    		if(!OnlineUser.STORE.containsKey(result.getU_id())) {
		    			OnlineUser.STORE.put(result.getU_id(), session.getId());
		    			info.add("恭喜您登录成功！");
		    			request.setAttribute("info", info);
		    			session.setAttribute("user", result);
		    		}else {
		    			//如果这个用户在线的话
		    			info.add("您的账号在别处登入，如非本人操作请修改密码！");
		    		}
				}
			}else if (operate.equals("enrol")) {
				if (result == null) {
					info.add("请认真填写信息，注册失败！");
				} else {
					info.add("注册成功！");
				}
			}else if (operate.equals("forgetPws")) {
				if (result == null) {
					info.add("不存在此用户！");
				} else {
					session.setAttribute("UID", result.getU_id());
				}
			}else if (operate.equals("alterPas")) {
				if (result == null) {
					info.add("修改失败！您可以联系客服");
				} else {
					info.add("修改成功！");
				}
			}else if (operate.equals("answer")) {
				if (result == null) {
					info.add("电话号码或保留信息回答错误！");
				}
			}else if (operate.equals("findBack")) {
				if (result == null) {
					info.add("修改密码失败！");
				} else {
					info.add("修改成功！快去登录吧~");
				}
			}

			request.setAttribute("info", info);

			if ("ajax".equals(isbackFalg)) {
				if (result == null) {
					response.getWriter().print("false");
				} else {
					response.getWriter().print("true");
				}
			} else {
				/*
				 * if(result.getU_id().equals("linhao666")){ isbackFalg =
				 * "linhao666"; }
				 */
				String jspNameString = this.getSkipDestion(operate, isbackFalg,
						result);
				if (jspNameString == null) {
					jspNameString = "enrol.jsp";
				}
				request.getRequestDispatcher(jspNameString).forward(request,
						response);
				// }
			}
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

	private User getUser(Map<String, String> formContent) {
		User user = new User();
		Class<?> cls = user.getClass();
		Set<Entry<String, String>> set = formContent.entrySet();
		Iterator<?> it = set.iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = (Entry<String, String>) it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			if (key.equals("operater") == false
					&& key.equals("firstPas") == false) {
				try {
					Field getField = cls.getDeclaredField(key);
					getField.setAccessible(true);
					getField.set(user, value);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	private String getSkipDestion(String operate, String isbackFalg, User user) {
		String jspName = null;
		if (operate.equals("login")) {
			if (user != null) {
				if (isbackFalg == null) {
					jspName = "index.jsp";
				} else {
					jspName = "backstage.jsp";
				}
			} else {
				if (isbackFalg == null) {
					jspName = "login.jsp";
				} else {
					jspName = "admin.jsp";
				}
			}
		}

		if (operate.equals("forgetPws")) {
			if (user != null) {
				jspName = "anwserQuestion.jsp";
			} else {
				jspName = "forgetPassword.jsp";
			}
		}

		if (operate.equals("enrol")) {
			if (user != null) {
				jspName = "login.jsp";
			} else {
				jspName = "enrol.jsp";
			}
		}

		if (operate.equals("answer")) {
			if (user != null) {
				jspName = "findBack.jsp";
			} else {
				jspName = "anwserQuestion.jsp";
			}
		}

		if (operate.equals("findBack")) {
			if (user != null) {
				jspName = "login.jsp";
			} else {
				jspName = "findBack.jsp";
			}
		}
		return jspName;
	}

}
