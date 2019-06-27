package com.Mart.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Mart.po.vo.ResultInfo;
import com.Mart.po.User;
import com.Mart.service.MartUserService;
import com.Mart.util.JsonUtil;
import com.Mart.util.SmsDemo;
import com.aliyuncs.exceptions.ClientException;


@WebServlet("/MartUserServlet")
public class MartUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MartUserService service=new MartUserService();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收参数 
		String actionName=request.getParameter("actionName");
		//对参数进行判断,进入相对应的操作
		
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
		}else {
			
			// 如果未传递actionName的值，拦截到登录页面
			response.sendRedirect("signIn.jsp");
		}
	}
	
	/**
	 * 储存模态框中的密码
	 * @param request
	 * @param response
	 */
	private void StoragePwd(HttpServletRequest request, HttpServletResponse response) {
		//接收参数(密码)
		String upwd1=request.getParameter("upwd1");
		//调用service层的StoragePwd方法,返回查询结果（返回封装类ResultInfo：状态码code、提示信息msg、返回的对象
		//ResultInfo<User> resultInfo=service.StoragePwd(upwd1);
	}

	/**
	 * 通过手机号获取短信验证并查询手机号是否存在
	 * @param request
	 * @param response
	 */
	private void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		// 接收手机信息参数
		String phone=request.getParameter("uphone");
		//调用service层的getCode方法,返回查询结果（返回封装类ResultInfo：状态码code、提示信息msg、返回的对象
		ResultInfo<User> resultInfo=service.getCode(phone);
		//将用户对象存入session作用域中
		request.getSession().setAttribute("user", resultInfo.getResult());
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
		
		System.out.println("哈哈哈哈哈哈");
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
			
			response.sendRedirect("signIn");
		}else{
		//用户注册失败,将resultInfo对象存到request作用域,并回到注册页面
			request.setAttribute("resultInfo", resultInfo);
			request.getRequestDispatcher("signUp").forward(request, response);
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
			//重定向到首页IndexServlet
			response.sendRedirect("MartIndexServlet?actionName=null");
			
		}else{
			//登录失败,并且跳转到登录页面
			request.setAttribute("resultInfo", resultInfo);
			request.getRequestDispatcher("signIn.jsp").forward(request, response);
		}
		
		
	}

}
