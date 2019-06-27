package com.Mart.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Mart.po.BigType;
import com.Mart.po.Cart;
import com.Mart.po.Product;
import com.Mart.po.User;
import com.Mart.po.vo.ResultInfo;
import com.Mart.service.MartIndexService;

/**
 * Servlet implementation class MartIndexServlet
 */
@WebServlet("/MartIndexServlet")
public class MartIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MartIndexService martIndexService=new MartIndexService();

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取actionName属性值
		String actionName=request.getParameter("actionName");
		
		//判断操作
		if(actionName.equals("delectBigTypes")){
			
			//进入分类查询页面
			delectBigTypes(request,response);
		}else if(actionName.equals("addCart")){
			
			//商品分类页面商品添加到购物车操作
			addCart(request,response);
		}else{
			
			//进入主页,循环出商品分类中的数据
			selectBigType(request,response);
		}
		
		
	}
	
	//添加购物车时查询当前用户是否已经添加该商品
	private int addCartSelect(Integer userId,Integer proId) {
		//调用service层进行查询
		Cart cart=martIndexService.addCartSelect(userId,proId);
		if(cart == null){
			return 0;
		}
		return 1;
	}

	//商品分类页面商品添加到购物车操作
	private void addCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取当前登录用户状态id
		User user=(User) request.getSession().getAttribute("user");
		Integer userId=user.getUserId();
		
		//获取需要添加的商品id
		String p=request.getParameter("proId");
		Integer proId=Integer.parseInt(p);
		
		//创建字符串输出流
		PrintWriter out =response.getWriter();
		
		//调用addCartSelect()方法查询当前用户是否已经添加该商品,如果添加了,则在购物车表上修改该商品数量 1有  0无
		int i=addCartSelect(userId,proId);
		if(i==1){
			
			//调用MartIndexService层方法进行商品分类页面商品数量增加操作
			int row=martIndexService.addCartNum(userId,proId);
			
			if(row>0){
				out.write(row+"");
			}else{
				out.write("0");
			}
			
		}else if(i==0){
			
			//调用MartIndexService层方法进行商品分类页面商品添加到购物车操作
			int row=martIndexService.addCart(userId,proId);
			if(row>0){
				out.write(row+"");
			}else{
				out.write("0");
			}
		}
		
	}

	//进入分类查询页面
	private void delectBigTypes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取到前台传来的要查询的分类类型id
		String bigId=request.getParameter("bigId");
		
		//调用MartIndexService层方法进行商品分类查询
		ResultInfo<List<Product>> resultInfo=martIndexService.delectBigTypes(bigId);
		
		if(resultInfo.getCode() == 0){
			request.setAttribute("resultInfo", resultInfo);
			
			request.setAttribute("changePage", "MartIndexAndSidebar/shop-left-sidebar.jsp");
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		request.setAttribute("resultInfo", resultInfo);
		
		request.setAttribute("changePage", "MartIndexAndSidebar/shop-left-sidebar.jsp");
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

	//进入主页,循环出商品分类中的数据
	private void selectBigType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//调用MartIndexService层方法进行商品分类查询
		ResultInfo<List<BigType>> resultInfo=martIndexService.selectBigType();

		
		//判断是否查询到数据
		if(resultInfo.getCode()==0){
			resultInfo.setResult(null);
			resultInfo.setMsg("暂未查询到数据");
			request.setAttribute("resultInfo", resultInfo);
			
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		
		request.getSession().setAttribute("resultInfos", resultInfo);
		
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

}
