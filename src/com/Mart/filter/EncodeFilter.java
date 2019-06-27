package com.Mart.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求乱码问题
 * 		
 * 				Tomcat8及以上版本									Tomcat7及以下版本
 * 	POST请求		会乱码，request.setCharacterEncoding("UTF-8");		会乱码，request.setCharacterEncoding("UTF-8");	
 * 				
 * 	GET请求 		不会乱码，不处理										会乱码，new String(request.getParameter(name).getBytes("ISO-8859-1"),"UTF-8");
 */
@WebFilter("/*")
public class EncodeFilter implements Filter {

  
    public EncodeFilter() {
        
    }

	
	public void destroy() {
	}

	
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		
		// 基于HTTP
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		// 处理POST请求乱码 （无论什么版本服务器）
		request.setCharacterEncoding("UTF-8");
		
		// 处理GET请求乱码
		// 1、得到请求类型
		String method = request.getMethod();
		// 2、判断是否是GET请求
		if ("GET".equalsIgnoreCase(method)) {
			// 3、如果是GET请求，则获取服务器版本信息
			String serverInfo = request.getServletContext().getServerInfo();
			//System.out.println(serverInfo);
			// 4、得到服务器的版本号
			String versionStr = serverInfo.substring(serverInfo.lastIndexOf("/")+1,serverInfo.lastIndexOf("/")+2);
			// 5、判断是否是Tomcat8以下版本服务器
			if (Integer.parseInt(versionStr) < 8) {
				// new String(request.getParameter(name).getBytes("ISO-8859-1"),"UTF-8");
				// 定义类，继承HttpServletRequestWrapper封装类，重写getParameter()方法，返回的类的本质是request对象
				HttpServletRequest req = new MyWapper(request);
				// 放行指定request对象  （Ttomcat7及以下版本的GET请求）
				chain.doFilter(req, response);
				return;
			}
		}
		
		// POST请求和Ttomcat8及以上版本的GET请求放行
		chain.doFilter(request, response);
	}
	


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

/**
 * 1、定义类
 * 2、继承HttpServletRequestWrapper封装类
 * 3、重写getParameter()方法
 * 
 * @author Lisa Li
 *
 */
class MyWapper extends HttpServletRequestWrapper {
	
	// 定义属性。提升作用域
	private HttpServletRequest request;

	/**
	 * 带参构造器
	 * @param request
	 */
	public MyWapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	/**
	 * 重写getParameter()方法，处理乱码问题
	 */
	@Override
	public String getParameter(String name) { // name代表的是前台传递的参数名，即键
		
		// 获取参数的值
		String value = request.getParameter(name);
		
		// 判断值是否为空，不为空处理乱码问题
		if (value == null || "".equals(value.trim())) {
			return value;
		}
		try {
			// 处理乱码问题
			value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	
}
