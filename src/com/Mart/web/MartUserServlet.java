package com.Mart.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Mart.po.vo.ResultInfo;
import com.Mart.po.Order;
import com.Mart.po.User;
import com.Mart.service.MartUserService;
import com.Mart.util.JsonUtil;
import com.Mart.util.SmsDemo;
import com.Mart.util.StringUtil;
import com.alibaba.fastjson.JSON;
import com.aliyuncs.exceptions.ClientException;


@WebServlet("/MartUserServlet")
public class MartUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MartUserService service=new MartUserService();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收参数 
		String actionName=request.getParameter("actionName");
		//对参数进行判断,进入相对应的操作
		System.out.println("1111111"+actionName);
		if("userLogin".equals(actionName)){
			
			//用户登录
			userLogin(request,response);
		}else if("checkName".equals(actionName)){
			
			//检查用户名是否重复	
			checkName(request,response);
		}else if("checkEmail".equals(actionName)){
			
			//检查邮箱是否重复
			checkEmail(request,response);
		}else if("userSignUp".equals(actionName)){
			
			//用户注册
			userSignUp(request,response);
		}else if("getCode".equals(actionName)){
			
			//短信验证
			getCode(request,response);
		}else if("StoragePwd".equals(actionName)){
			
			//储存模态框中的密码
			StoragePwd(request,response);
		}else if("updateUserAccount".equals(actionName)){
			
			//修改个人中心信息操作
			updateUserAccount(request,response);
		}else if("checkPwd".equals(actionName)){
			
			//修改密码功能中查询旧密码是否正确
			checkPwd(request,response);
		}else if("updateUserPwd".equals(actionName)){
			
			//修改个人密码
			updateUserPwd(request,response);
		}else if("gouPersonalCenter".equals(actionName)){
			System.out.println(actionName);
			//进入个人中心
			gouPersonalCenter(request,response);
		}else if("deleteUserOrder".equals(actionName)){
			
			//删除个人订单
			deleteUserOrder(request,response);
		}else if("getCode1".equals(actionName)){
			
			//手机注册获取手机验证码
			getCode1(request,response);
		}else if("mobileSignUp".equals(actionName)){
			
			//手机注册提交
			mobileSignUp(request,response);
		}
		
		else {
			
			// 如果未传递actionName的值，拦截到登录页面
			response.sendRedirect("signIn.jsp");
		}
	}
	
	/**
	 * //手机注册提交
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void mobileSignUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 调用service层的方法,返回查询结果（返回封装类ResultInfo：状态码code、提示信息msg、返回的对象
		ResultInfo<User> resultInfo=service.mobileSignUp(request);
		//判断
		if(resultInfo.getCode()!=1){
			//注册失败,把对象存request作用域中,跳转到注册页面
			request.setAttribute("resultInfo11", resultInfo);
			//跳转到注册页面
			request.getRequestDispatcher("Mobile_signUp.jsp").forward(request, response);
			return;
		}
		//自动登录
		
		User user=service.huoquUser(request);
		if(user!=null){
			//将user对象存到session域中
			request.getSession().setAttribute("user", user);
			
			//注册成功将返回的resultInfo存到session域对象中
			request.getSession().setAttribute("checkOrderCenter", resultInfo);
			//登录成功首页MartIndexServlet
			response.sendRedirect("MartIndexServlet?actionName=null");
		}
		
		
	}


	/**
	 * //手机注册获取手机验证码
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void getCode1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//接收参数
		String uphone=request.getParameter("uphone");
		//设置相应编码格式
		response.setContentType("text/html;charset=UTF-8");
		//得到输出流
		PrintWriter out =response.getWriter();
		//获取短信验证码
		String num="1212";
		/*try {
			num=SmsDemo.sendSms(uphone);
		} catch (ClientException e) {
			e.printStackTrace();
		}*/
		System.out.println(num);
		//输出数据,前台ajax接收
		out.write(num);
		out.close();
				
				
		
	}

	/**
	 * 进入个人中心
	 * //删除个人订单
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void deleteUserOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 调用service层的方法,返回查询结果（返回row)
		int row=service.deleteUserOrder(request);
		//设置相应编码格式
		response.setContentType("text/html;charset=UTF-8");
		//得到输出流
		PrintWriter out =response.getWriter();
		
		if(row>0){
			//修改成功
			out.write(row+"");
			out.close();
		}
		
	
	}


	/**
	 * 进入个人中心
	 * 查看个人订单
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void gouPersonalCenter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 调用service层的方法,返回查询结果（返回封装类ResultInfo：状态码code、提示信息msg、返回的对象
		ResultInfo<List<Order>> resultInfo=service.checkOrder(request);
		System.out.println(resultInfo.getCode());
		System.out.println(resultInfo.getResult());

		//将返回的resultInfo存到session域对象中
		request.getSession().setAttribute("checkOrderCenter", resultInfo);
		
		
		request.setAttribute("changePage","MartUserAndSignin/my-account.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	
	/**
	 * 个人中心
	 * 修改个人密码
	 * @param request
	 * @param response
	 */
	private void updateUserPwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 调用service层的方法,返回查询结果（返回封装类ResultInfo：状态码code、提示信息msg、返回的对象
		ResultInfo<User> resultInfo=service.updateUserPwd(request);
		//设置相应编码格式
		response.setContentType("text/html;charset=UTF-8");
		//得到输出流
		PrintWriter out =response.getWriter();
		//对更新结果进行判断
		if(resultInfo.getCode()!=0){//更新成功
			//输出到页面,ajax接收
			out.write(resultInfo.getCode()+"");
			out.close();
			return;
		}
		//失败
		out.write(resultInfo.getCode()+"");
		out.close();
	}

	/**
	 * 个人中心
	 * 修改密码功能中查询旧密码是否正确
	 * @param request
	 * @param response
	 */
	private void checkPwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 调用service层的方法,返回查询结果（返回封装类ResultInfo：状态码code、提示信息msg、返回的对象
		ResultInfo<User> resultInfo=service.checkPwd(request);
		//将resultInfo对象转换成json格式的字符串，响应给ajax的回调函数
		// 设置响应类型及编码
		response.setContentType("application/json;charset=UTF-8");
		// 得到输出流
		PrintWriter out = response.getWriter();
		// 将对象转换成json格式的字符串
		String json = JSON.toJSONString(resultInfo);
		// 将json字符串响应给ajax饿回调函数
		out.write(json);
		out.close();
		
	}

	/**
	 * 个人中心
	 * 修改个人中心信息
	 * @param request
	 * @param response
	 */
	private void updateUserAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 调用service层的方法,返回查询结果（返回封装类ResultInfo：状态码code、提示信息msg、返回的对象
		ResultInfo<User> resultInfo=service.updateUserAccount(request);
		//设置相应编码格式
		response.setContentType("text/html;charset=UTF-8");
		//得到输出流
		PrintWriter out =response.getWriter();
		//对更新结果进行判断
		if(resultInfo.getCode()!=0){//更新成功
			//输出到页面,ajax接收
			out.write(resultInfo.getCode()+"");
			out.close();
			return;
		}
		//失败
		out.write(resultInfo.getCode()+"");
		out.close();
	}

	
	/**
	 * 储存模态框中的密码
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void StoragePwd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		//调用service层的方法,返回查询结果（返回封装类ResultInfo：状态码code、提示信息msg、返回的对象
		ResultInfo<User> resultInfo=service.StoragePwd(request);
		//设置相应编码格式
		response.setContentType("text/html;charset=UTF-8");
		//得到输出流
		PrintWriter out =response.getWriter();
		//跟据更新的结果,进行不同的操作
		if(resultInfo.getCode()!=1){//修改失败
			out.write(resultInfo.getCode()+"");
			out.close();
			return;
		}
		//修改成功
		System.out.println(resultInfo.getCode());
		//将用户对象存到session作用域中
		request.getSession().setAttribute("user", resultInfo.getResult());
		//输出数据,ajax接收
		out.write(resultInfo.getCode()+"");
		out.close();
		
	}

	/**
	 * 通过手机号获取短信验证并查询手机号是否存在
	 * @param request
	 * @param response
	 */
	private void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		// 接收手机信息参数
		String phone=request.getParameter("uphone");
		
		//调用service层的方法,返回查询结果（返回封装类ResultInfo：状态码code、提示信息msg、返回的对象
		ResultInfo<User> resultInfo=service.getCode(phone);
		
		//设置相应编码格式
		response.setContentType("text/html;charset=UTF-8");
		//得到输出流
		PrintWriter out =response.getWriter();
		
		//通过resultInfo对象的code值，判断是否查询成功
		String code1=null;
		
		if(resultInfo.getCode()==0){
			
			//输出数据到ajax接收
			out.write(resultInfo.getCode()+"");
			out.close();
			return;
		}
		//将用户对象存入session作用域中
		request.getSession().setAttribute("user", resultInfo.getResult());
		code1="1233";
		//查询成功,调用Mart.util中的方法得到验证信息
//		try {
//			//code=SmsDemo.sendSms(phone);
//			
//			
//		} catch (ClientException e) {
//			e.printStackTrace();
//		}
		
		//输出数据到ajax接收
		out.write(code1);
		out.close();
		
	}
	
	/**
	 * 用户注册
	 * @param request
	 * @param response
	 */
	private void userSignUp(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 接收用户信息
		String uname=request.getParameter("uname");
		String uemail=request.getParameter("email");
		String upwd=request.getParameter("upwd");
		String uphone=request.getParameter("uphone");
		//调用service层的userSignUp方法,返回登录结果（返回封装类ResultInfo：状态码code、提示信息msg、返回的对象）
		ResultInfo<User> resultInfo=service.userSignUp(uname,uemail,upwd,uphone);
		//通过resultInfo对象的code值，判断是否修改成功
		if(resultInfo.getCode()==1){
		//用户注册成功,更新session作用域,重定向到登录页面
			
			response.sendRedirect("signIn.jsp");
		}else{
		//用户注册失败,将resultInfo对象存到request作用域,并回到注册页面
			request.setAttribute("resultInfo", resultInfo);
			request.getRequestDispatcher("signUp.jsp").forward(request, response);
		}
	}
	
	/**
	 * 检查email是否重复
	 * @param request
	 * @param response
	 */
	private void checkEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 接收用户名
		String uemail=request.getParameter("uemail");
		//调用service层的checkName方法,返回查询结果（返回封装类ResultInfo：状态码code、提示信息msg、返回的对象）
		ResultInfo<User> resultInfo=service.checkEmail(uemail);
		//将resultInfo对象转换成json格式的字符串，响应给ajax的回调函数
		JsonUtil.toJson(response, resultInfo);
		
	}
	
	/**
	 * 检查用户名是否重复
	 * @param request
	 * @param response
	 */
	private void checkName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 接收用户名
		String uname=request.getParameter("uname");
		//调用service层的checkName方法,返回查询结果（返回封装类ResultInfo：状态码code、提示信息msg、返回的对象）
		ResultInfo<User> resultInfo=service.checkName(uname);
		//将resultInfo对象转换成json格式的字符串，响应给ajax的回调函数
		JsonUtil.toJson(response, resultInfo);
			
		
	}
	
	/**
	 * 登录操作
	 * @param request
	 * @param response
	 */
	private void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//接收用户名和密码
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		//调用service层的userLogin方法,返回登录结果（返回封装类ResultInfo：状态码code、提示信息msg、返回的对象）
		ResultInfo<User> resultInfo=service.userLogin(uname,upwd);
		//根据的登录的结果跳转到不同的页面
		if(resultInfo.getCode()==1){//登录成功
			//将用户对象存入session作用域中
			request.getSession().setAttribute("user", resultInfo.getResult());
			
			//判断是否记住密码,如果是,则存cookie对象
			String rem=request.getParameter("remember");
			if("1".equals(rem)){
				//存cookie对象
				Cookie cookie=new Cookie("user",uname+"-"+upwd);
				//设置失效时间  七天
				cookie.setMaxAge(7*24*60*60);
				//相应cookie对象
				response.addCookie(cookie);
				
			}
			//重定向到首页MartIndexServlet
			response.sendRedirect("MartIndexServlet?actionName=null");
			
		}else{
			//登录失败,并且跳转到登录页面
			request.setAttribute("resultInfo", resultInfo);
			request.getRequestDispatcher("signIn.jsp").forward(request, response);
		}
		
		
	}

}
