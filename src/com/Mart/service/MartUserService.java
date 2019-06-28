package com.Mart.service;

import java.io.IOException;
import java.util.List;

import com.Mart.Dao.MartUserDao;
import com.Mart.po.vo.ResultInfo;
import com.Mart.po.Order;
import com.Mart.po.User;
import com.Mart.util.StringUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import jdk.nashorn.internal.ir.RuntimeNode.Request;



public class MartUserService {
	private MartUserDao martuserdao=new MartUserDao();
	
	//用户登录
	public ResultInfo<User> userLogin(String uname, String upwd) {
		//得到封装类ResultInfo对象
		ResultInfo<User> resultInfo = new ResultInfo<>();
		
		// 设置ResultInfo对象中返回的对象（用来做回显的用户对象）
		User u = new User();
		u.setUserName(uname);
		u.setUserPwd(upwd);
		resultInfo.setResult(u);
		
		
		
		//判断参数是否为空(姓名,密码)
		if(StringUtil.isEmpty(uname)||StringUtil.isEmpty(upwd)){
			//如果为空,设置ResultInfo对象的code=0，msg="xxx不能为空"，返回 resultInfo对象
			resultInfo.setCode(0);
			resultInfo.setMsg("用户名或密码不得为空!!!");
			return resultInfo;
		}
		//调用Dao层的方法,通过用户名查询用户对象，返回的是 用户对象user
		User user=martuserdao.findUserByName(uname,upwd);
		if(user==null){
			resultInfo.setCode(0);
			resultInfo.setMsg("用户名或密码错误!!");
			return resultInfo;
			
		}
		//如果相等，设置ResultInfo对象的code=1，msg="登录成功！"，返回 resultInfo对象
		resultInfo.setCode(1);
		resultInfo.setMsg("登录成功!!");
		resultInfo.setResult(user);
		
		return resultInfo;
	}
	//通过用户名查看用户对象
	public ResultInfo<User> checkName(String uname) {
		ResultInfo<User> resultInfo=new ResultInfo<>();
		//判断参数是否为空
		if(StringUtil.isEmpty(uname)){
			//如果为空,设置ResultInfo对象的code值为1,msg="xxx不能为空"，返回 resultInfo对象
			resultInfo.setCode(1);
			resultInfo.setMsg("用户名不得为空!!");
			return resultInfo;
		}	
		//调用DAO层,通过用户名查询用户对象;
		User user=martuserdao.findUserByuname(uname);
		//判断对象是否为空,如果为空则设置,姓名可以用,不为空则不可以用
		if(user!=null){
			resultInfo.setCode(1);
			System.out.println("===0899890====");
			resultInfo.setMsg("用户名已被占用，请重新输入!!");
		}else{
			resultInfo.setCode(0);
				
		}
		return resultInfo;
	}
	//通过email查看用户对象
	public ResultInfo<User> checkEmail(String uemail) {
		ResultInfo<User> resultInfo=new ResultInfo<>();
		//判断参数是否为空
		if(StringUtil.isEmpty(uemail)){
			//如果为空,设置ResultInfo对象的code值为1,msg="xxx不能为空"，返回 resultInfo对象
			resultInfo.setCode(1);
			resultInfo.setMsg("email不得为空!!");
			return resultInfo;
		}	
		//调用DAO层,通过email查询用户对象;
		User user=martuserdao.findUserByuemail(uemail);
		System.out.println(user);
		//判断对象是否为空,如果为空则设置,姓名可以用,不为空则不可以用
		if(user!=null){
			resultInfo.setCode(1);
			resultInfo.setMsg("email已被占用，请重新输入!!");
		}else{
			resultInfo.setCode(0);
				
		}
		return resultInfo;
	}
	//用户注册
	public ResultInfo<User> userSignUp(String uname, String uemail, String upwd,String uphone) {
		//得到封装类ResultInfo对象
		ResultInfo<User> resultInfo = new ResultInfo<>();
		// 设置ResultInfo对象中返回的对象（用来做回显的用户对象）
		User u= new User();
		u.setUserName(uname);
		u.setUserMail(uemail);
		u.setUserPwd(upwd);
		u.setUserPwd(uphone);
		resultInfo.setResult(u);
		
		//判断参数是否为空(姓名,密码)
		if(StringUtil.isEmpty(uname)||StringUtil.isEmpty(upwd) ||StringUtil.isEmpty(uemail)||StringUtil.isEmpty(uphone)){
			//如果为空,设置ResultInfo对象的code=0，msg="xxx不能为空"，返回 resultInfo对象
			resultInfo.setCode(0);
			resultInfo.setMsg("用户名,密码,邮箱,手机 不得为空!!!");
			return resultInfo;
		
		}
		//调用Dao层,向数据库添加用户信息
		int row=martuserdao.UpdateUser(uname,uemail,upwd,uphone);
		//判断受影响的行数是否大于0
		if(row>0){
			resultInfo.setCode(1);
			resultInfo.setMsg("用户注册成功,即将进入登录页面.");
			
		}else {
			resultInfo.setCode(0);
			resultInfo.setMsg("注册失败！");
		}
		return resultInfo;
	}
	
	//短信验证
	public ResultInfo<User> getCode(String phone) {
		//得到封装类ResultInfo对象
		ResultInfo<User> resultInfo = new ResultInfo<>();
		// 设置ResultInfo对象中返回的对象（用来做回显的用户对象）
		User u=new User();
		u.setUserMobile(phone);
		resultInfo.setResult(u);
		System.out.println(resultInfo);
		// 判断数据是否为空
		if(StringUtil.isEmpty(phone)){
			//为空,设置ResultInfo对象的code=0，msg="xxx不能为空"，返回 resultInfo对象
			resultInfo.setCode(0);
			resultInfo.setMsg("输入的号码不存在!!");
			return resultInfo;
		}
		//调用Dao层,向数据库查询用户对象
		User user =martuserdao.findUserByPhone(phone);
		//更新用户对象
		resultInfo.setResult(user);
		System.out.println("==="+user);
		//判断对象是否为空
		if(user!=null){
			//不为空 设置code=1
			resultInfo.setCode(1);
			resultInfo.setMsg("success");
		}else{
			resultInfo.setCode(0);
			resultInfo.setMsg("该用户不存在!!!");
		}
		return resultInfo;
	}
	//忘记密码并修改密码
	public ResultInfo<User> StoragePwd(HttpServletRequest request) throws IOException, ServletException{
		//接收参数(密码)
		String upwd1=request.getParameter("upwd1");
		System.out.println(upwd1);
		//得到封装类ResultInfo对象
		ResultInfo<User> resultInfo = new ResultInfo<>();
		//从session作用域中得到user对象
		User user =(User) request.getSession().getAttribute("user");
		// 判断参数是否为空（必填参数）
		if ( StringUtil.isEmpty(upwd1)) {
			// 如果为空，设置ResultInfo对象的code=0，msg="xxx不能为空"，返回 resultInfo对象
			resultInfo.setCode(0);
			resultInfo.setMsg("更改的密码不能为空！");
			return resultInfo;
		}
		//更新user对象
		user.setUserPwd(upwd1);
		// 调用Dao层的修改方法，通过用户 ID修改用户信息，返回受影响的行数
		int row = martuserdao.updateInfo(user);
		//对row进行判断,判断受影响的行数是否大于0
		if(row>0){
			resultInfo.setCode(1);
			resultInfo.setMsg("修改成功");
			resultInfo.setResult(user); // web层更新session对象
		}else {
			resultInfo.setCode(0);
			resultInfo.setMsg("修改失败！");
			resultInfo.setResult(user); // web层更新session对象
		}
		
		return resultInfo;
	}
	
	
	//修改个人中心信息
	@SuppressWarnings("unused")
	public ResultInfo<User> updateUserAccount(HttpServletRequest request) throws IOException{
		// 接收参数(性别,email)
		String usex =request.getParameter("usex");
		//吧字符窜类型的usex转化成integer
		Integer inte=Integer.parseInt(usex);
		String uemail=request.getParameter("uemail");
		//得到封装类的ResultInfo对象
		ResultInfo<User> resultInfo=new ResultInfo<>();
		//从session中获取用户对象,
		User user=(User) request.getSession().getAttribute("user");
		//判断参数非空
		if(StringUtil.isEmpty(uemail)){
			//为空,设置code为0,设置错误提示信息
			resultInfo.setCode(0);
			resultInfo.setMsg("email不能为空!!!");
			return resultInfo;
		}if(inte==null ){
			//为空,设置code为0,设置错误提示信息
			resultInfo.setCode(0);
			resultInfo.setMsg("性别不能为空!!!");
			return resultInfo;
		}
		//更新user对象
		user.setUserSex(inte);
		user.setUserMail(uemail);
		//调用Dao层的方法,更新数据库中的信息
		int row= martuserdao.updateAccount(user);
		//判断row是否>0,如果大于零则更新成功
		if(row>0){
			//更新成功
			resultInfo.setCode(1);
			resultInfo.setMsg("修改成功!!!");
			// web层更新session对象
			resultInfo.setResult(user);
		}else{
			//更新失败
			resultInfo.setCode(0);
			resultInfo.setMsg("网络不见了,修改失败!!!");
			resultInfo.setResult(user); // web层更新session对象
		}
		return resultInfo;
	}
	
	//修改密码功能中查询旧密码是否正确
	public ResultInfo<User> checkPwd(HttpServletRequest request) {
		//接收参数
		String password03=request.getParameter("password03");
		//得到封装类的ResultInfo对象
		ResultInfo<User> resultInfo=new ResultInfo<>();
		//判断非空
		if(StringUtil.isEmpty(password03)){
			//为空,设置code为0,设置错误提示信息
			resultInfo.setCode(0);
			resultInfo.setMsg("旧密码不能为空!!!");
			return resultInfo;
		}
		//调用Dao层的方法,查询数据库中的信息
		User user= martuserdao.checkPwd(password03);
		//判短user对象是否为空
		if(user==null){//查询失败
			resultInfo.setCode(0);
			resultInfo.setMsg("你输入的密码不存在!!");
			resultInfo.setResult(user);
			return resultInfo;
		}
		//查询成功
		resultInfo.setCode(1);
		resultInfo.setMsg("可以修改密码!!");
		resultInfo.setResult(user);
		
		return resultInfo;
		
	}
	
	//修改个人密码
	public ResultInfo<User> updateUserPwd(HttpServletRequest request) {
		//得到封装类的ResultInfo对象
		ResultInfo<User> resultInfo=new ResultInfo<>();
		//接收数据
		String password01=request.getParameter("password01");
		//得到session中的user对象
		User user =(User) request.getSession().getAttribute("user");
		//判断非空
		if(StringUtil.isEmpty(password01)){
			//为空,设置code为0,设置错误提示信息
			resultInfo.setCode(0);
			resultInfo.setMsg("密码不能为空!!!");
			return resultInfo;
		}
		//更新user对象
		user.setUserPwd(password01);
		//调用Dao层的方法,更新数据库中的用户密码
		int row =martuserdao.updatePwd(user);
		//判短row是否>0
		if(row==0){//未修改成功
			resultInfo.setCode(0);
			resultInfo.setMsg("可能网络原因,修改失败!!!");
			resultInfo.setResult(user);
			return resultInfo;
		}
		//row>0,修改成功
		resultInfo.setCode(1);
		resultInfo.setMsg("密码修改成功!!!");
		resultInfo.setResult(user);
		return resultInfo;
	}
	
	/**
	 * 个人中心
	 * 查看个人订单
	 * @param request
	 * @param response
	 */
	public ResultInfo<List<Order>> checkOrder(HttpServletRequest request) {
		//得到封装类的ResultInfo对象
		ResultInfo<List<Order>> resultInfo=new ResultInfo();
		
		//得到session中的user对象
		User user1=(User) request.getSession().getAttribute("user");
		System.out.println(user1.getUserId());
		
		//得到user中的userId
		Integer userId = user1.getUserId();
		
		//通过Dao层的方法去数据库查询所有的订单数据
		List<Order> OrderList =martuserdao.checkUserOrder(userId);
		//把订单集合存取到域对象中
		request.getSession().setAttribute("OrderList", OrderList);
		//判断得到的user对象是否为空
		if(OrderList==null){
			//为空,未查到订单信息
			resultInfo.setCode(0);
			resultInfo.setMsg("暂未查到订单信息!!!");
			resultInfo.setResult(OrderList);
			return resultInfo;
		}
		//则为查到订单信息
		resultInfo.setCode(1);
		resultInfo.setMsg("已查到订单信息!!!");
		resultInfo.setResult(OrderList);
		return resultInfo;
	}
	/**
	 * 个人中心
	 * 删除个人订单
	 * @param request
	 * @param response
	 */
	public ResultInfo<User> deleteUserOrder(HttpServletRequest request) {
		//得到封装类的ResultInfo对象
		ResultInfo<User> resultInfo=new ResultInfo();
		//从session域中获取
		return null;
	}

	
	
}

