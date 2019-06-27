package com.Mart.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Mart.po.Cartproduct;
import com.Mart.po.User;
import com.Mart.po.vo.ResultInfo;
import com.Mart.service.MartCarService;

/**
 * Servlet implementation class MartCarServlet
 */
@WebServlet("/martCarServlet")
public class MartCarServlet extends HttpServlet {
	MartCarService martcarservice=new MartCarService();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收用户行为
		String actionName=request.getParameter("actionName");
		
		//判断用户行为
		if("delete".equals(actionName)){
			
			//查询商品列表
			
			
		}else if("minusPro".equals(actionName)){
			//将购物车中的商品数减一
			minusPro(request,response);
		}else if("addPro".equals(actionName)){
			//将购物车商品数加一
			plusPro(request,response);
		}else{
			productList(request,response);
			//判断用户行为
			
		}
		
		
		
		
	}
	
	//给购物车中的指定商品做加一操作
	private void plusPro(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1.从session作用域中获取用户ID
		User user=(User)request.getSession().getAttribute("user");
		Integer userId=user.getUserId();
		//2.获取需要增加的商品Id
		String pId=request.getParameter("proId");
		System.out.println(pId);
		Integer proId=Integer.parseInt(pId);
		System.out.println(proId);
		int i=martcarservice.plusPro(userId,proId);
		System.out.println(i);
		
		PrintWriter out=response.getWriter();
		out.write(i+"");
	}

	private void minusPro(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1.从session作用域中获取用户ID
		User user=(User)request.getSession().getAttribute("user");
		Integer userId=user.getUserId();
		//2.获取需要增加的商品Id
		String pId=request.getParameter("proId");
		System.out.println(pId);
		Integer proId=Integer.parseInt(pId);
		System.out.println(proId);
		//3.
		int j=martcarservice.minusPro(userId,proId);
		System.out.println(j);
		
		PrintWriter out=response.getWriter();
		out.write(j+"");
	}

	/**
	 * 删除用户购物车中的指定商品
	 * @param request
	 * @param response
	 */
	/*private void deleteList(HttpServletRequest request, HttpServletResponse response) {
		//1.接收参数(proId)
		String proId=request.getParameter("typeId");
		//2.调用Service层，通过TypeId删除指定记录，返回resultInfo对象
		ResultInfo<Cartproduct>resultInfo=martcarservice.deleteProduct();
		
	}*/

	//查询当前登录用户购物车的商品集合
	private void productList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.从session作用域中获取用户ID
		User user=(User)request.getSession().getAttribute("user");
		Integer userId=user.getUserId();
		
		//2.调用Service层的方法，返回resultInfo对象
		ResultInfo<List<Cartproduct>> resultInfo=martcarservice.findProduct(userId);
		
		//3.将resultInfo对象存到request作用域中
		request.setAttribute("resultInfo", resultInfo);
		
		
		//4.设置首页动态包含的页面值
		request.setAttribute("changePage","MartCartAndOrder/cart.jsp");
		//4.请求转发到cart.jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
