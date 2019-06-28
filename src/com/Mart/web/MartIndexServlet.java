package com.Mart.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Mart.po.BigType;
import com.Mart.po.Cart;
import com.Mart.po.Order;
import com.Mart.po.OrderProDetails;
import com.Mart.po.Product;
import com.Mart.po.User;
import com.Mart.po.vo.ResultInfo;
import com.Mart.service.MartIndexService;
import com.Mart.util.DBUtil;

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
		}else if(actionName.equals("insertOrder")){
			
			//购物车传来用户需要购买的所有商品信息
			insertOrder(request,response);
		}else if(actionName.equals("allChecked")){
			
			//购物车全选全不选修改购物车表内商品选择信息
			allChecked(request,response);
		}else if(actionName.equals("addWishlist")){
			
			//添加心愿单操作
			addWishlist(request,response);
		}else if(actionName.equals("singleClick")){
			
			//购物车页面 单选事件
			singleClick(request,response);
		}
		else{
			
			//进入主页,循环出商品分类中的数据
			selectBigType(request,response);
		}
		
		
	}
	
	//购物车页面 单选事件
	private void singleClick(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取当前登录用户状态id
		User user=(User) request.getSession().getAttribute("user");
		Integer userId=user.getUserId();
		
		//获取前台传来的用户id以及所点击的商品id
		String s=request.getParameter("Status");
		Integer Status=Integer.parseInt(s);
		String p=request.getParameter("proId");
		Integer proId=Integer.parseInt(p);
		
		//调用martIndexService层方法,进行修改购物侧表中,对应的商品的选种状态
		int row=martIndexService.singleClick(Status,userId,proId);
		Integer mo=0;
		//查询到所有选中状态的购物车商品总价
		if(row == 1){
			//判断当前购物车中是否有选中的商品
			int sizeee=martIndexService.selectProCheck(userId);
			
			if(sizeee == 1){
				mo=(martIndexService.selectAllCkmMo(userId)).intValue();
			}

		}
		
		
		PrintWriter out =response.getWriter();
		out.write(mo+"");
	}

	//添加商品至心愿单
	private void addWishlist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取当前登录用户状态id
		User user=(User) request.getSession().getAttribute("user");
		Integer userId=user.getUserId();
		
		//获取前台传来的商品id
		String id=request.getParameter("proId");
		Integer proId=Integer.parseInt(id);
		
		//创建字符串输出流
		PrintWriter out =response.getWriter();
		
		//调用addWishlist()方法查询当前用户是否已经添加该商品,如果添加了,则在心愿表表上修改该商品数量 1有  0无
		int i=martIndexService.addWishlist(userId,proId);
		if(i==0){
			
			//添加
			martIndexService.addWishlistOne(userId,proId);
			out.write("1");
		}
		out.write("1");
		
	}
	
	//购物车全选全不选修改购物车表内商品选择信息
	private void allChecked(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取当前登录用户状态id
		User user=(User) request.getSession().getAttribute("user");
		Integer userId=user.getUserId();
		
		//获取前台传来的参数 1为全选中,0为全不选
		String str= request.getParameter("Status");
		Integer Status=Integer.parseInt(str);
		
		//进入后台修改购物内当前登录用户的商品选中状态
		martIndexService.allChecked(userId,Status);
		Integer mo=0;
		//查询到所有选中状态的购物车商品总价
		if(Status == 1){
			mo=(martIndexService.selectAllCkmMo(userId)).intValue();
		}
		
		PrintWriter out =response.getWriter();
		out.write(mo+"");
		
	}

	//购物车传来用户需要购买的所有商品信息.进行订单创建
	private void insertOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取当前购买用户id
		User user=(User) request.getSession().getAttribute("user");
		Integer userId=user.getUserId();

		//获取到购物车中当前登录用户购物车中选中商品的id集合
		List<Product> lists=martIndexService.selectProIdList(userId);
		List<Integer> list=new ArrayList();
		for(int i=0;i<lists.size();i++){
			Integer ie=lists.get(i).getProId();
			list.add(ie);
		}

		//获取当前购物车中选中状态的所有商品的总价
		Integer orderMoney=(martIndexService.selectAllCkmMo(userId)).intValue();
		
		
		//创建当前时间进行订单表数据
		Date date=new Date();
		
		//准备格式化时间格式,作为用户创建订单时间
		DateFormat df2 = DateFormat.getDateTimeInstance();
		String orderCreate=df2.format(date);
		
		//创建当前时间作为拼接订单编号
		String orderNumber="N"+date.getTime();
		
		//测试
//		Integer	userId=1;
//		String orderNumber="N1561549624129";
//		String orderCreate="2019-6-26 19:47:04";
//		Integer orderMoney=2345;
		//测试,记得关闭;
		
		//调用service层进行订单表的添加
		int addOrder=martIndexService.insertOrder(userId,orderNumber,orderCreate,orderMoney);
		
		//判断是否创建成功
		if(addOrder==0){
			
			//为0创建失败
			System.out.println("创建失败");
			return;
		}
		
		//通过创建了的订单编号去数据库查询返回一个当前创建订单的订单对象
		Order order=martIndexService.cjOrder(orderNumber);
		
		//通过获取到的需要购买的商品id 来进行查询当前购买用户购物车中对应的商品数量
		List<Integer> socount=martIndexService.selectSocount(userId,list);
		
		//判断获取到的商品数量集合长度是否与商品id集合长度相同
		if(list.size() != socount.size()){
			
			System.out.println("数据不匹配");
			return;
		}
		
		//订单创建成功后进行订单子表的添加操作
		int addSorder=martIndexService.insertSorder(order.getOrderId(),list,socount);
		
		//判断订单子表添加次数是否与商品Id集合长度相同
		if(addSorder != list.size()){
			
			System.out.println("数据不匹配");
			return;
		}
		
		//删除购物车中对应的当前用户所选择购买的商品信息
		int delectCarpro=martIndexService.delectCarPro(userId,list);
		
		//查询订单子表,将该订单编号的所有商品存入到当前订单对象中显示
		List<OrderProDetails> selectOrPro=martIndexService.selsectOrderProDetails(orderNumber);
		
		//给创建的订单对象补全内部商品信息
		order.setList(selectOrPro);
		
		//将当前创建的订单对象存入域对象中,请求转发到支付页面
		request.setAttribute("OrderProDetails", order);
		request.getRequestDispatcher("aliIndex/index.jsp").forward(request, response);
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
