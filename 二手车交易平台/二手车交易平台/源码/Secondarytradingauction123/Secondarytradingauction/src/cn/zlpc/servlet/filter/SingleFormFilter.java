package cn.zlpc.servlet.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;

import tool.mastery.core.CollectionFormUtil;
import cn.zlpc.util.SaveFile;
import cn.zlpc.util.WebUtils;

/**
 * Servlet Filter implementation class SingleFormFilter
 */
public class SingleFormFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SingleFormFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		// 设置文字编码
		request.setCharacterEncoding("utf-8");
		HttpServletRequest req = (HttpServletRequest)request;
		String form = req.getParameter("operate");
		String voName = form.split("\\.")[0];
		
		List<Object> beans = null;
		if(form.equals("Vehicle.add")||form.equals("Vehicle.update")) {  //带有上传的表单封装封装数据 
			
			beans = WebUtils.request2Bean(req, "Vehicle");
			new SaveFile("", req, "VehiclePicture").save(); 
		} else {
			beans = CollectionFormUtil.parseRequest(req, voName);
		}
		
		request.setAttribute("beans", beans);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
