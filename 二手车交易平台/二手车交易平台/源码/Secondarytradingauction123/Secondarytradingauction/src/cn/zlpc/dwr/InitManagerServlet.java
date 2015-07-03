package cn.zlpc.dwr;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import cn.zlpc.po.User;

public class InitManagerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static long value = 0; // 当前最高价格

	private static User user = null; // 当前出价最高的用户

	private static int currentTime = 0; // 当前出价剩余时间

	private static long totalTime = 99999; // 剩余总时间 假设为99999，应该是到最后结束的总时间
	
	private static String textArea = "";  //竞价日志
	
	private static String textArea2 = ""; //当前进入的用户
	
	private static boolean flag = false;

	private static Date currDate;
	
	public static String getTextArea2() {
		return InitManagerServlet.textArea2;
	}
	
	public static void setTextArea2(String textArea2) {
		InitManagerServlet.textArea2 = textArea2;
	}
	
	public static String getTextArea() {
		return InitManagerServlet.textArea;
	}
	
	public static void setTextArea(String textArea) {
		InitManagerServlet.textArea = textArea;
	}
	
	public static void setFlag(boolean flag) {
		InitManagerServlet.flag = flag;
	}
	
	public static boolean getFlag() {
		return InitManagerServlet.flag;
	}

	public static long getValue() {
		return value;
	}

	public static int getCurrentTime() {
		return InitManagerServlet.currentTime;
	}

	public static synchronized void setCurrentTime(int currentTime) {
		InitManagerServlet.currentTime = currentTime;
	}

	public static long getTotalTime() {
		return InitManagerServlet.totalTime;
	}

	public static synchronized void setTotalTime(long totalTime) {
		InitManagerServlet.totalTime = totalTime;
	}

	public static synchronized void setValue(long value) {
		InitManagerServlet.value = value;
	}

	public static User getUser() {
		return user;
	}

	public static synchronized void setUser(User user) {
		InitManagerServlet.user = user;
	}

	public static Thread ThreadInstance(long totalTime) {
		Thread thread = new Thread(new OutputValue(totalTime));
		thread.setDaemon(true);
		return thread;
	}
	
	private static class OutputValue implements Runnable {	
		
		
		public OutputValue(long totalTime) {
			InitManagerServlet.totalTime = totalTime;
			InitManagerServlet.currentTime = (int)totalTime;
		}
		@Override
		public void run() {
			while (totalTime > 0) {
				try {
					TimeUnit.MILLISECONDS.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				if(currentTime >0) {
					currentTime --;
				} else {
					break;
				}
				totalTime--;
				InitManagerServlet.flag = true;
			}
			InitManagerServlet.flag = false;
			InitManagerServlet.textArea = "";
		}

	}
	

	public static Date getCurrDate() {
		return currDate;
	}

	public static synchronized void setCurrDate(Date currDate) {
		InitManagerServlet.currDate = currDate;
	}

	public static int CalculCurrDate() {
		Date nowDate = new Date();
		@SuppressWarnings("deprecation")
		int currMin = nowDate.getMinutes() - currDate.getMinutes();
		@SuppressWarnings("deprecation")
		int currSecond = nowDate.getSeconds() - currDate.getSeconds();

		int remainTime = 300 - (currMin * 60 + currSecond);
		return remainTime;
	}
}
