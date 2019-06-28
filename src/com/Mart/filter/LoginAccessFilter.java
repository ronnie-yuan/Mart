package com.Mart.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Mart.po.User;

/**
 * 非法访问拦截、自动登录
 * 
 * 
 */
@WebFilter("/*")
public class LoginAccessFilter implements Filter {

    
    public LoginAccessFilter() {
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		
		// 基于Http
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		// 得到请求的路径
		String url = request.getRequestURI(); // 站点名/资源路径
		
		
		// 1、静态资源，放行 （js、css、iamge等；statics目录下的资源都放行）
		if (url.contains("/OneStatic")) {
			// 放行
			chain.doFilter(request, response);
			return;
		}
		
		// 2、指定页面，放行 （登录login.jsp或注册register.jsp等；不需要登录即可访问的页面）
		if (url.contains("/forgotPassword.jsp")) {
			// 放行
			chain.doFilter(request, response);
			return;
		}
		if (url.contains("/signIn.jsp")) {
			// 放行
			chain.doFilter(request, response);
			return;
		}
		if (url.contains("/signUp.jsp")) {
			// 放行
			chain.doFilter(request, response);
			return;
		}
		if (url.contains("/TextSignInServlet")) {
			// 放行
			chain.doFilter(request, response);
			return;
		}
		if (url.contains("/Text")) {
			// 放行
			chain.doFilter(request, response);
			return;
		}
		if (url.contains("/IndexServlet")) {
			// 放行
			chain.doFilter(request, response);
			return;
		}
		if (url.contains("/MartUserServlet")) {
			// 放行
			chain.doFilter(request, response);
			return;
		}
		if (url.contains("MyStatic/js/MartQiu")) {
			// 放行
			chain.doFilter(request, response);
			return;
		}
		
		
		
		// 3、指定操作，放行 （登录操作、注册操作等；不需要登录即可执行执行的操作）
		// 得到用户行为
		String actionName = request.getParameter("actionName");
		if (url.contains("/userServlet")) {
			if ("login".equals(actionName)) {
				// 放行
				chain.doFilter(request, response);
				return;
			}
		}
		
		
		// 4、登录状态，放行 （判断session域对象中是否存在user对象，如果不为空，登录状态；为空，非登录状态）
		User user = (User) request.getSession().getAttribute("user");
		// 如果不为空，登录状态
		if (user != null) {
			// 放行
			chain.doFilter(request, response);
			return;
		}
		
		/* 自动登录 */
		// 1、非登录状态 （session作用域中user对象为空）  2、cookie对象有值
		// 1、获取Cookie数组 request.getCookies()
		Cookie[] cookies = request.getCookies();
		// 2、判断cookie数组是否为空
//		if (cookies != null && cookies.length > 0) {
//			// 3、遍历cookie数组，得到指定cookie对象
//			for (Cookie cookie : cookies) {
//				if ("user".equals(cookie.getName())) {
//					// 4、得到cookie对象的vlaue，通过字符串分割分别得到用户名和密码
//					String value = cookie.getValue();  // admin-123456
//					String[] strs = value.split("-");
//					// 得到用户名和密码
//					String uname = strs[0];
//					String upwd = strs[1];
//					// 5、请求登录接口（请求转发跳转到登录操作）
//					// 设置请求的路径
//					String path = "userServlet?actionName=login&uname="+uname+"&upwd="+upwd;
//					// 请求转发跳转到登录操作
//					request.getRequestDispatcher(path).forward(request, response);
//					return;
//				}
//			}
//			
//		}
		
		
		// chain.doFilter(request, response);
		
		// 若以上条件都未满足，则跳转到登录页面
		response.sendRedirect("signIn.jsp");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
