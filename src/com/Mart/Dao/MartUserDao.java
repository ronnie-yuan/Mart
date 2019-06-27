package com.Mart.Dao;

import java.util.ArrayList;
import java.util.List;

import com.Mart.po.User;


public class MartUserDao {
	private BaseDao basedao=new BaseDao();
	
	//通过用户名,密码到数据库查询用户对象,(登录操作)
	public User findUserByName(String uname,String upwd) {
		//准备sql语句
		String sql="select*from c_user where userName=? and userPwd=?";
		//赋值
		List<Object> list =new ArrayList<>();
		list.add(uname);
		list.add(upwd);
		//调用BaseDao的方法进行数据库查询
		User user=(User) basedao.queryRow(sql, list, User.class);
		
		return user;
	}

	//通过用户名到数据库查找用户对象(验证用户名)
	public User findUserByuname(String uemail) {
		// 准备sql语句
		String sql="select*from c_user where userName=?";
		//赋值
		List<Object> list =new ArrayList<>();
		list.add(uemail);
		//调用BaseDao的方法进行数据库查询
		User user=(User) basedao.queryRow(sql, list, User.class);
		
		return user;
	}
	//向数据库添加数据(用户注册)
	public int UpdateUser(String uname, String uemail, String upwd,String uphone) {
		// 创建sql语句
		String sql="insert into c_user(userName,userMail,userPwd,userMobile) values(?,?,?,?);";
		//赋值
		List<Object> list =new ArrayList<>();
		list.add(uname);
		list.add(uemail);
		list.add(upwd);
		list.add(uphone);
		//调用BaseDao 的方法进行添加数据
		int row=basedao.executeUpdate(sql, list);
		return row;
	}

	//通过email到数据库查找用户对象(验证email)
	public User findUserByuemail(String uemail) {
		// 准备sql语句
		String sql="select*from c_user where userMail=?";
		//赋值
		List<Object> list =new ArrayList<>();
		list.add(uemail);
		//调用BaseDao的方法进行数据库查询
		User user=(User) basedao.queryRow(sql, list, User.class);
		
		return user;
	}

	public User findUserByPhone(String phone) {
		// 创建sql语句
		String sql="select * from c_user where userMobile=?";
		//赋值
		List<Object> list =new ArrayList<>();
		list.add(phone);
		//调用BaseDao的方法进行数据库查询
		User user=(User) basedao.queryRow(sql, list, User.class);
		return user;
	}



}
