/**
 * 
 */
package cn.zlpc.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.mastery.exception.DBException;
import cn.zlpc.dao.BaseDao;
import cn.zlpc.dwr.InitManagerServlet;
import cn.zlpc.exception.ErrorException;
import cn.zlpc.po.Bid;
import cn.zlpc.service.StarStoAucService;

/**
 * @author ASUS
 *
 */
public class StartStopAuctionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public StartStopAuctionServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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
       	response.setContentType("text/xml;charset=utf-8"); 
		  response.setHeader("Cache-Control","no-cache");
		  String operate=request.getParameter("param");//得到从页面传来的值是启动拍卖还终止拍卖
		  //String vname=new String(request.getParameter("vname").getBytes("ISO-8859-1"),"utf-8");
		  String bid_id=request.getParameter("bid_id");
		  System.out.println(bid_id+"bid_id");
		  StarStoAucService starStoAucService=new StarStoAucService(operate,bid_id);
      	try {
      		if (operate.equals("start")) {
      			long intervalTime = ((Bid) new BaseDao().queryForSingle(
						Bid.class, 0, 1, null, "bid_id", bid_id, false).get(0))
						.getBidEndTime().getTime() - new Date().getTime();
				intervalTime = intervalTime / 1000;
				InitManagerServlet.setTotalTime(intervalTime);
				InitManagerServlet.ThreadInstance(intervalTime).start();
			} else if (operate.equals("stop")) {
				InitManagerServlet.setCurrentTime(0);
			}
      	  Boolean flag= starStoAucService.executeOperate();
      	  StringBuffer content=new StringBuffer(""); 
   		  content.append("<?xml version=\"1.0\"   encoding=\"UTF-8\" ?>");
   		  content.append("<contents>");
		  content.append("<content>");
		  content.append("<flag>"+flag.toString()+"</flag>");
		  content.append("</content>");
		  content.append("<content>");
		  content.append("<operate>"+operate+"</operate>");
		  content.append("</content>");
          content.append("</contents>");
		   System.out.println(content+" content");
		   response.getWriter().print(content.toString());
			
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
    
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
