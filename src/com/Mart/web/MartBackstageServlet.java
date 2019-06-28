package com.Mart.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Mart.po.Order;
import com.Mart.po.Product;
import com.Mart.po.User;
import com.Mart.po.vo.ResultInfo;
import com.Mart.service.MartBackstageService;
import com.Mart.util.JsonUtil;

/**
 * 后台Servlet层
 * 用户管理平台及商品分类管理平台
 * @author MSI-PC
 *
 */
@WebServlet("/martBackstageServlet")
public class MartBackstageServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private MartBackstageService martBackstageService = new MartBackstageService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收后台行为
		String actionName = request.getParameter("actionName");
		
		// 判断后台行为, 调用指定方法
		if("search".equals(actionName)){
			
			// 查询用户列表
			searchUser(request, response);
			
		} else if("searchProductAndStock".equals(actionName)) {	
			
			// 查询商品及商品库存
			searchProductAndStock(request, response);
			
		} else if("searchOrders".equals(actionName)){
			// 查询用户订单类
			searchUserOrders(request, response);
			
		} else if("delete".equals(actionName)){
			
			// 删除用户信息
			deleteUser(request, response);
			
		} else if("addOrUpdate".equals(actionName)){
			
			// 添加或修改用户信息
			addOrUpdateUser(request, response);
			
		} else if ("addOrUpdateProductStock".equals(actionName)){
			
			// 添加或修改商品库存等信息
			addOrUpdateProductStock(request, response);
			
		} else if("addOrUpdateOrder".equals(actionName)){
			
			// 添加或修改订单信息
			addOrUpdateOrder(request, response);
			
		} else if ("logout".equals(actionName)){
			
			// 用户退出
			userLogout(request, response);	
			
		} else if("setUserStatus".equals(actionName)){
			
			// 修改用户状态
			setUserStatus(request, response);
			
		} else if("setProStatus".equals(actionName)){
			// 删除商品(后台将商品状态设置为0)
			setProStatus(request, response);
			
		} else if("setOrderStatus".equals(actionName)){
			
			// 删除订单(后台将订单状态设置为0)
			setOrderStatus(request, response);
		} else if("substractUserBalance".equals(actionName)){
			
			// 用户余额-订单总额
			substractUserBalance(request, response);
			
		} else if("substractOrderProductStock".equals(actionName)){
			
			// 商品库存-订单商品数量
			substractOrderProductStock(request, response);
			
		} else {
		response.sendRedirect("MartBackstage/manipulate.jsp");
		}
	}
	
	/**
	 * 商品库存-订单商品数量
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void substractOrderProductStock(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取信息
		Integer orderId = Integer.parseInt(request.getParameter("orderId"));	
		Integer orderStatus = Integer.parseInt(request.getParameter("orderStatus"));
		
		// 调用service层, 查找当前商品库存, 当前订单商品数量, 并将库存修改为当前库存-该订单商品数量
		ResultInfo<Object> resultInfo = martBackstageService.substractOrderProductStock(orderId, orderStatus);
		
		System.out.println(resultInfo.getCode());
		
		// 将resultInfo对象 转换成JSON格式的字符串，响应给ajax的回调函数
		JsonUtil.toJson(response, resultInfo);
	}

	/**
	 * 用户余额-订单总额
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void substractUserBalance(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取信息
		Integer orderId = Integer.parseInt(request.getParameter("orderId"));
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		Integer orderStatus = Integer.parseInt(request.getParameter("orderStatus"));
		Integer orderMoney = Integer.parseInt(request.getParameter("orderMoney"));
		
		// 调用service层, 通过商品ID修改order状态, 返回resultInfo对象
		ResultInfo<Order> resultInfo = martBackstageService.substractUserBalance(orderId, userId, orderStatus, orderMoney);
		
		System.out.println(resultInfo.getCode());
		
		// 将resultInfo对象 转换成JSON格式的字符串，响应给ajax的回调函数
		JsonUtil.toJson(response, resultInfo);
		
	}

	private void setUserStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取信息
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		Integer userStatus = Integer.parseInt(request.getParameter("userStatus"));
		
		// 调用service层, 通过商品ID修改order状态, 返回resultInfo对象
		ResultInfo<User> resultInfo = martBackstageService.setUserStatus(userId, userStatus);
		
		System.out.println(resultInfo.getCode());
		
		// 将resultInfo对象 转换成JSON格式的字符串，响应给ajax的回调函数
		JsonUtil.toJson(response, resultInfo);
	}

	/**
	 * 将商品状态设置为0
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void setProStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取信息
		Integer proId = Integer.parseInt(request.getParameter("proId"));
		Integer proStatus = Integer.parseInt(request.getParameter("proStatus"));
		
		// 调用service层, 通过商品ID修改order状态, 返回resultInfo对象
		ResultInfo<Product> resultInfo = martBackstageService.setProductStatus(proId, proStatus);
		
		System.out.println(resultInfo.getCode());
		
		// 将resultInfo对象 转换成JSON格式的字符串，响应给ajax的回调函数
		JsonUtil.toJson(response, resultInfo);
	}
	/**
	 * 将订单状态设置为0
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void setOrderStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取信息
		Integer orderId = Integer.parseInt(request.getParameter("orderId"));
		Integer orderStatus = Integer.parseInt(request.getParameter("orderStatus"));
		
		// 调用service层, 通过订单ID修改order状态, 返回resultInfo对象
		ResultInfo<Order> resultInfo = martBackstageService.setOrderStatus(orderId, orderStatus);
		
		System.out.println(resultInfo.getCode());
		
		// 将resultInfo对象 转换成JSON格式的字符串，响应给ajax的回调函数
		JsonUtil.toJson(response, resultInfo);
	}
	/**
	 * 添加或修改订单信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void addOrUpdateOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取信息
		String orderId = request.getParameter("orderId");
		String orderStatus = request.getParameter("orderStatus");
		String orderUpdate = request.getParameter("orderUpdate");
		String orderMoney = request.getParameter("orderMoney");
		String orderisIn = request.getParameter("orderisIn");
		
		System.out.println(orderId);
		System.out.println(orderStatus);
		System.out.println(orderUpdate);
		System.out.println(orderMoney);
		System.out.println(orderisIn);
		// TODO 设置其他属性
		
		// 封装成Order对象
		Order order = new Order();
		order.setOrderId(Integer.parseInt(orderId));
		order.setOrderStatus(Integer.parseInt(orderStatus));
		order.setOrderUpdate(orderUpdate);
		order.setOrderMoney(Integer.parseInt(orderMoney));
		order.setOrderisIn(Integer.parseInt(orderisIn));
		
		// 调用service层, 通过订单ID修改指定信息, 返回resultInfo对象
		ResultInfo<Order> resultInfo = martBackstageService.addOrUpdateOrder(order);
		
		// 将resultInfo对象 转换成JSON格式的字符串，响应给ajax的回调函数
		JsonUtil.toJson(response, resultInfo);
	}

	/**
	 * 查询用户订单信息(连表查询)
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void searchUserOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResultInfo<List<Order>> resultInfo = martBackstageService.searchUserOrders();
		// 将resultInfo对象存到request作用域中
		request.setAttribute("resultInfo", resultInfo);
	// 请求转发跳转到manipulate.jsp
		request.getRequestDispatcher("MartBackstage/orderPanel.jsp").forward(request, response);
		
	}

	/**
	 * 修改或添加商品及库存等
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void addOrUpdateProductStock(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取信息
		String proId = request.getParameter("proId");
		String proPrice = request.getParameter("proPrice");
		String proStock = request.getParameter("proStock");
		String proStatus = request.getParameter("proStatus");
		String proName = request.getParameter("proName");
		String proBrand = request.getParameter("proBrand");
		String proImg = request.getParameter("proImg");
		String proDescription = request.getParameter("proDescription");
		// String smId = request.getParameter("smId");
		// String bigId = request.getParameter("bigId");
		
		// 封装成product对象(残缺的)
		Product product = new Product();
		System.out.println(proId);
		System.out.println(proPrice);
		System.out.println(proStock);
		System.out.println(proStatus);
		product.setProId(Integer.parseInt(proId));
		product.setProPrice(Integer.parseInt(proPrice));
		product.setProStock(Integer.parseInt(proStock));
		product.setProStatus(Integer.parseInt(proStatus));
		product.setProName(proName);
		product.setProBrand(proBrand);
		product.setProImg(proImg);
		product.setProDescription(proDescription);
		// product.setSmId(Integer.parseInt(smId));
		// product.setBigId(Integer.parseInt(bigId));
		
		// 调用service层, 通过用户Id, 姓名修改指定信息, 返回resultInfo对象
				ResultInfo<Product> resultInfo = martBackstageService.addOrUpdateProductStock(product);
				
				// 将resultInfo对象 转换成JSON格式的字符串，响应给ajax的回调函数
				JsonUtil.toJson(response, resultInfo);
	}
	/**
	 * 查询商品及其库存
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
private void searchProductAndStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取session域对象中的productId
	// Product product = (Product) request.getSession().getAttribute("product");
	
	
	// 调用Service的方法，查询用户列表，返回resultInfo对象
	ResultInfo<List<Product>> resultInfo = martBackstageService.searchAllProductAndStock();
	// System.out.println(resultInfo.getResult());
	
// 将resultInfo对象存到request作用域中
	request.setAttribute("resultInfo", resultInfo);
// 请求转发跳转到manipulate.jsp
	request.getRequestDispatcher("MartBackstage/productStock.jsp").forward(request, response);
	}
/**
 * 用户退出
 * @param request
 * @param response
 * @throws IOException 
 */
	private void userLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1.销毁session对象
		request.getSession().invalidate();
		
		// TODO 2.删除cookie对象
		
		// 3. 跳转到登录页面
		response.sendRedirect("Mart/signIn.jsp");
		
	}

	private void addOrUpdateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取参数
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId"); // 修改操作有值, 添加操作无值
		String userPwd = request.getParameter("userPwd");
		String userSex = request.getParameter("userSex");  // 前台传过来的得是1或2的字符串
		String userMail = request.getParameter("userMail");
		String userMobile = request.getParameter("userMobile");
		String userHead = request.getParameter("userHead");
		String userBalance = request.getParameter("userBalance");
		String userStatus = request.getParameter("userStatus");
		String userCreateTime = request.getParameter("userCreateTime");
		String userAnswer = request.getParameter("userAnswer");
		String userQuestion = request.getParameter("userQuestion");
		
		// 封装成User对象
		User user = new User();
		System.out.println(userId);
		System.out.println(userSex);
		System.out.println(userBalance);
		System.out.println(userStatus);
		user.setUserId(Integer.parseInt(userId));
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		user.setUserSex(Integer.parseInt(userSex));
		user.setUserMail(userMail);
		user.setUserMobile(userMobile);
		user.setUserHead(userHead);
		user.setUserBalance(Integer.parseInt(userBalance));
		user.setUserStatus(Integer.parseInt(userStatus));
		user.setUserCreateTime(userCreateTime);
		user.setUserAnswer(userAnswer);
		user.setUserQuestion(userQuestion);
		
		// 调用service层, 通过用户Id, 姓名修改指定信息, 返回resultInfo对象
		ResultInfo<User> resultInfo = martBackstageService.addOrUpdateUser(user);
		
		// 将resultInfo对象 转换成JSON格式的字符串，响应给ajax的回调函数
		JsonUtil.toJson(response, resultInfo);
		
	}


	
	/**
	 * 删除用户
	 * 1、接收参数 （typeId）
		2、调用Service层，通过typeId删除指定记录，返回resultInfo对象 
		3、将resultInfo对象 转换成JSON格式的字符串，响应给ajax的回调函数
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取参数
		String userId = request.getParameter("userId");
		
		System.out.println(userId);
		
		// 调用service层, 通过用户Id删除指定记录, 返回resultInfo对象
		ResultInfo<User> resultInfo = martBackstageService.deleteUser(Integer.parseInt(userId));
		
		// 3、将resultInfo对象 转换成JSON格式的字符串，响应给ajax的回调函数
		JsonUtil.toJson(response, resultInfo);
	}
/**
 * 查找用户
 * 1、从session作用域中获取用户ID
	2、调用Service的方法，查询类型列表，返回resultInfo对象
	3、将resultInfo对象存到request作用域中
	4、请求转发跳转到manipulate.jsp
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException
 */
	private void searchUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取session域对象中的userId
				User user = (User) request.getSession().getAttribute("user");
				Integer userId = user.getUserId();
				
		// 调用Service的方法，查询用户列表，返回resultInfo对象
				ResultInfo<List<User>> resultInfo = martBackstageService.searchUser(userId);
			
		// 将resultInfo对象存到request作用域中
				request.setAttribute("resultInfo", resultInfo);
		// 请求转发跳转到manipulate.jsp
				request.getRequestDispatcher("MartBackstage/manipulate.jsp").forward(request, response);
	}



}
