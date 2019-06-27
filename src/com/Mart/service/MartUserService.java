package com.Mart.service;

import java.util.List;

import com.Mart.Dao.MartUserDao;
import com.Mart.po.vo.ResultInfo;
import com.Mart.po.User;
import com.Mart.util.StringUtil;



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
			resultInfo.setMsg("用户不存在!!");
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
	public ResultInfo<User> getCode(String phone) {
		//得到封装类ResultInfo对象
		ResultInfo<User> resultInfo = new ResultInfo<>();
		// 设置ResultInfo对象中返回的对象（用来做回显的用户对象）
		User u=new User();
		u.setUserMobile(phone);
		resultInfo.setResult(u);
		// 判断数据是否为空
		if(StringUtil.isEmpty(phone)){
			//为空,设置ResultInfo对象的code=0，msg="xxx不能为空"，返回 resultInfo对象
			resultInfo.setCode(0);
			resultInfo.setMsg("输入的号码不存在!!");
			return resultInfo;
		}
		//调用Dao层,向数据库查询用户对象
		User user =martuserdao.findUserByPhone(phone);
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
	
	
}

