package cn.zlpc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zlpc.service.QueryService;
import cn.zlpc.util.ImageUtil;
import cn.zlpc.vo.Page;
import cn.zlpc.vo.PrTaNotice;

public class PrTaNoticeServlet<E> extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PrTaNoticeServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
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
		response.setCharacterEncoding("utf-8");
		ImageUtil.setPath(request);
		String viewname = request.getParameter("view");
		Page page = new Page();
		page.setMaxSize(8);
		if(viewname.equalsIgnoreCase("PrTaNotice")){
	        //   公告显示
			QueryService queryService =new QueryService("Notice");
			List<Object> list=queryService.getResult(null, null);
			request.setAttribute("list", list);
		//   预拍公告
			QueryService PrTaNoticeService =new QueryService(viewname);
			
			List<Object> PrTaNoticeList1=PrTaNoticeService.getResult(null, page);
			List<String> imageList =null;//存取不同车牌号下文件夹的图片
//		    Map<String,List<String>> map = new HashMap();//一个车牌号对应多个图片
		    List<PrTaNotice> PrTaNoticeList = new ArrayList<PrTaNotice>();
			for(int i = 0;i<PrTaNoticeList1.size();i++){
				PrTaNotice prtanotice = (PrTaNotice) PrTaNoticeList1.get(i);
				imageList = ImageUtil.getImage(ImageUtil.GET_PATH+prtanotice.getV_id()+"\\", ImageUtil.SHOW_PATH+prtanotice.getV_id()+"/");
				//map.put(prtanotice.getV_id(), imageList);
				if(imageList.size() != 0) {
					prtanotice.setImageName(imageList.get(0));
				}else {
					prtanotice.setImageName("img/nophoto.jpg");
				}
				PrTaNoticeList.add(prtanotice);
			}
			request.setAttribute("page", page);
			request.setAttribute("PrTaNoticeList", PrTaNoticeList);
			request.getRequestDispatcher("index1.jsp").forward(request, response);
		}
		if(viewname.equalsIgnoreCase("PrTaNoticePage")){
			List<String> imageList =null;
			QueryService PrTaNoticeService1 =new QueryService("PrTaNotice");
			/*Page page = new Page();
			page.setMaxSize(5);*/
			// 获得从页面中传递过来的数据
			String firstIndex = request.getParameter("firstIndex");
			if (firstIndex != null) {
				int temp = Integer.parseInt(firstIndex);
				page.setPage(temp);
			}
			//此处是为了遍历出竞拍的车子
			List<String> query = new ArrayList<String>();
			query.add("all");
			query.add("all");
			
			List<Object> PrTaNoticeList1=PrTaNoticeService1.getResult(query, page);
			 List<PrTaNotice> PrTaNoticeList = new ArrayList<PrTaNotice>();
			for(int i = 0;i<PrTaNoticeList1.size();i++){
				PrTaNotice prtanotice = (PrTaNotice) PrTaNoticeList1.get(i);
				imageList = ImageUtil.getImage(ImageUtil.GET_PATH+prtanotice.getV_id()+"\\", ImageUtil.SHOW_PATH+prtanotice.getV_id()+"/");
				//map.put(prtanotice.getV_id(), imageList);
				if(imageList.size() != 0) {
					prtanotice.setImageName(imageList.get(0));
				}else {
					prtanotice.setImageName("img/nophoto.jpg");
				}
				PrTaNoticeList.add(prtanotice);
			}
			//System.out.println();
			request.setAttribute("page", page);
			request.setAttribute("PrTaNoticeList", PrTaNoticeList);
			request.getRequestDispatcher("user_file/AdvanceCar/AdvanceCar.jsp").forward(request, response);
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
