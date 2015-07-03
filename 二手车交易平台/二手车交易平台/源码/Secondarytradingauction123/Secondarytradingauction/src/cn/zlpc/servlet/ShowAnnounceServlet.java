/**
 * 
 */
package cn.zlpc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zlpc.po.Notice;
import cn.zlpc.service.QueryService;

/**
 * @author ASUS
 *
 */
public class ShowAnnounceServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShowAnnounceServlet() {
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

		String n_id=request.getParameter("n_id");
		QueryService queryService=new QueryService("Notice");
		
		List<Object> list=null,listAllInfo=null;
		if(n_id!=null){
			List<String> list1=new ArrayList<String>();
			list1.add("n_id");
			list1.add(n_id);
			list=queryService.getResult(list1, null);
	
		}
		listAllInfo=queryService.getResult(null, null);
		for(Object list1:list){
			Notice no=(Notice)list1;
			
			System.out.println(no.getContent()+" "+no.getN_time());
		}
		request.setAttribute("list1",list);
		request.setAttribute("list",listAllInfo);
		request.getRequestDispatcher("user_file/help/news.jsp").forward(request, response);
		
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
