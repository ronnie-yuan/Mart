package com.Mart.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Mart.po.User;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getParameter("actionName");
		//判断操作
		if(actionName.equals("changePage")){
			
			//进入动态包含页面
			IndexChangePage(request,response);
		}else if(actionName.equals("zhuxiao")){
			
			//登出当前账号
			zhuxiao(request,response);
		}
		else if(actionName.equals("houtai")){
			
			//进入后台页面
			HouTai(request,response);
		}
	}

	private void zhuxiao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().setAttribute("user", null);
		response.sendRedirect("signln.jsp");
		
	}

	private void HouTai(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//用户状态等级为2时才是管理员用户
		
		//获取当前登录用户的用户状态
		User user=(User) request.getSession().getAttribute("user");
		int userStatus= user.getUserStatus();
		System.out.println(userStatus);
		
		//判断用户等级是否为2,不是取消当前登录状态并回到登录页面
		if(userStatus==2){
			response.sendRedirect("martBackstageServlet?actionName=search");
		}else{
			request.getSession().setAttribute("user", null);
			response.sendRedirect("signln.jsp");
		}
		
	}

	private void IndexChangePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取前台传来的changePage属性值
		String changePage= request.getParameter("changePage");
		// 设置首页动态包含的页面值
		request.setAttribute("changePage", changePage);
		// 跳转到index.jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
