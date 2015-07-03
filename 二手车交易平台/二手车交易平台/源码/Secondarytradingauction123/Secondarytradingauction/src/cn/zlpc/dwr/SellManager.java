package cn.zlpc.dwr;

import java.util.Collection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;

import cn.zlpc.po.User;

public class SellManager {

	/**
	 * 发送消息
	 * 
	 * @param msg
	 *            消息内容
	 * @param request
	 * @param text
	 *            出价历史内容
	 */
	public void send(String msg, String text, HttpServletRequest request) {
		Collection<ScriptSession> sessions = getScriptSessionForCollection();// //这里解决可以不再轮询
		User user = (User) request.getSession().getAttribute("user"); // 得到出价的user对象
		long msgValue = Long.parseLong(msg);
		ScriptBuffer buffer = new ScriptBuffer();
		if (msgValue > InitManagerServlet.getValue()
				&& InitManagerServlet.getFlag()) { // 如果比当前最高值要大&&当前允许竞拍
			String textArea = user.getU_id().substring(0, 2)
					+ "****"
					+ user.getU_id().substring(user.getU_id().length() - 2,
							user.getU_id().length()) + " 出价: " + msgValue
					+ "\n" + InitManagerServlet.getTextArea();
			synchronized (this) {
				InitManagerServlet.setCurrDate(new Date());
				InitManagerServlet.setValue(msgValue);
				InitManagerServlet.setCurrentTime(300);
				InitManagerServlet.setUser(user);
				InitManagerServlet.setTextArea(textArea);
			}
			buffer.appendScript("setTime(")
					.appendData(InitManagerServlet.getCurrentTime())
					.appendScript(");");
			for (ScriptSession session : sessions) { // 给每个session设值
				Util util = new Util(session); // util.setValue是第一个参数是前台id属性,第二个参数是对应的值
				// util.setStyle("showMessage", "display", "");
				util.setValue("dqj", msgValue);
				util.setValue("show", InitManagerServlet.getCurrentTime());
				// util.setValue("textarea", text + "\n" + user.getU_id()
				// + " 出价: " + msgValue);
				util.setValue("textarea", InitManagerServlet.getTextArea());
				util.setValue("user", user.getU_id());
				session.addScript(buffer);
			}
		} else {
			sendMessageForRefresh(sessions,request);
		}
	}

	/**
	 * 新用户加入或者用户刷新页面时，客户端调用； 主要是得到当前正在拍卖时的最高价和倒计时时间
	 * 
	 * @param text
	 * @param request
	 */
	public void CalculTimeAndMaxPrice(HttpServletRequest request) {
		Collection<ScriptSession> sessions = getScriptSessionForCollection();
		sendMessageForRefresh(sessions, request);
	}

	public void sendMessageForRefresh(Collection<ScriptSession> sessions,
			HttpServletRequest request) {
		if (InitManagerServlet.getValue() != 0) {
			ScriptBuffer buffer = new ScriptBuffer();
			buffer.appendScript("setTime(")
					.appendData(InitManagerServlet.getCurrentTime())
					.appendScript(");");
			for (ScriptSession session : sessions) {
				Util util = new Util(session);
				util.setValue("dqj", InitManagerServlet.getValue());
				util.setValue("textarea", InitManagerServlet.getTextArea());
				util.setValue("user", InitManagerServlet.getUser().getU_id());
				session.addScript(buffer);
			}
		} else {
		}
	}

	public void getUserAuction(HttpServletRequest request) {
		Collection<ScriptSession> sessions = getScriptSessionForCollection();
		User user = (User) request.getSession().getAttribute("user"); // 得到出价的user对象
		String textArea2 = "用户：" + this.getOtherName(user) + " 进入拍卖 " + "\n"
				+ InitManagerServlet.getTextArea2();
		for (ScriptSession session : sessions) {
			Util util = new Util(session);
			InitManagerServlet.setTextArea2(textArea2);
			util.setValue("textarea2", InitManagerServlet.getTextArea2());
			util.setValue("user", this.getOtherName(user));
		}

	}

	/**
	 * 拿到拍卖页面上ScriptSession集合
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Collection<ScriptSession> getScriptSessionForCollection() {
		WebContext context = WebContextFactory.get();
		String currentPage = context.getCurrentPage();
		return context.getScriptSessionsByPage(currentPage);
	}

	public void InitManagerOper() {
		InitManagerServlet.setTextArea("");
		InitManagerServlet.setTextArea2("");
		InitManagerServlet.setCurrDate(new Date());
		InitManagerServlet.setCurrentTime(0);
		InitManagerServlet.setValue(0);
		InitManagerServlet.setUser(null);
	}

	public long getTotalTime() {
		return InitManagerServlet.getTotalTime();
	}
	
	public String getOtherName(User user) {
		String textArea = user.getU_id().substring(0, 2)
				+ "****"
				+ user.getU_id().substring(user.getU_id().length() - 2,
						user.getU_id().length());
		return textArea;
	}
	 
}
