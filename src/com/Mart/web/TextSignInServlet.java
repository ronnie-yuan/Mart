package com.Mart.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Mart.Dao.BaseDao;
import com.Mart.po.User;
import com.Mart.util.StringUtil;
import com.sun.org.apache.xpath.internal.compiler.PsuedoNames;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/TextSignInServlet")
public class TextSignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BaseDao dao=new BaseDao();
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname= request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		System.out.println(uname);
		System.out.println(upwd);
		
		if(StringUtil.isEmpty(uname)|| StringUtil.isEmpty(upwd)){
			System.out.println("不能为空");
			return;
		}
		
		
		
		
		String sql="select * from c_user where userName=? and userPwd=?";
		List list =new ArrayList();
		list.add(uname);
		list.add(upwd);
		User user=(User) dao.queryRow(sql, list, User.class);
		if(user != null){
			System.out.println(user);
			request.getSession().setAttribute("user", user);
			response.sendRedirect("index.jsp");
		}else{
			System.out.println("账号或密码错误");
			System.out.println(user);
			response.sendRedirect("signIn.jsp");
			return;
		}
		
		
	}

}
