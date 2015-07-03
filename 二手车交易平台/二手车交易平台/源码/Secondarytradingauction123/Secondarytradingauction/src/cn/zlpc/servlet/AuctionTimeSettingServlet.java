/**
 * 
 */
package cn.zlpc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.mastery.core.CharacterUtil;
import tool.mastery.core.CollectionFormUtil;
import tool.mastery.exception.DBException;
import cn.zlpc.po.Bid;
import cn.zlpc.service.AucTimSetService;

/**
 * @author ASUS
 *
 */
public class AuctionTimeSettingServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AuctionTimeSettingServlet() {
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
		  
    	try {
    		request.getParameter("utf-8");
		response.setContentType("text/xml;charset=utf-8"); 
		  response.setHeader("Cache-Control","no-cache");
		  Bid bid=(Bid)CollectionFormUtil.parseObjectRequest(request,"Bid");
		 // String v_id = new String(request.getParameter("v_id").getBytes("ISO-8859-1"),"utf-8");
		  String v_id =request.getParameter("v_id");
		  bid.setV_id(Integer.parseInt(v_id));
		 // System.out.println(bid.getBidTime()+" bidTime");
		  AucTimSetService auctionService=new AucTimSetService(bid);
    	  Boolean flag= auctionService.executeSetTime();
    	  StringBuffer content=new StringBuffer(""); 
 		  content.append("<?xml version=\"1.0\"   encoding=\"UTF-8\" ?>");
 		  content.append("<contents>");
		  content.append("<content>");
		  content.append("<flag>"+flag.toString()+"</flag>");
		  content.append("</content>");
        content.append("</contents>");
		 
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
