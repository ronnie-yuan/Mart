package com.Mart.Dao;

import java.util.ArrayList;
import java.util.List;

import com.Mart.po.Order;
import com.Mart.po.OrderProDetails;
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
	//获取短信验证码
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

	public int updateInfo(User user) {
		 
		//准备sql语句
		String sql="update c_user set userPwd=? where userMobile=?" ;
		//赋值
		List<Object> list =new ArrayList<>();
		list.add(user.getUserPwd());
		list.add(user.getUserMobile());
		//调用BaseDao的方法更新数据库
		int row=basedao.executeUpdate(sql, list);
		
		return row;
	}
	
	
	//用户修改个人中心的信息,在数据库进行更新
	public int updateAccount(User user) {
		// 准备sql语句
		String sql="update c_user set userSex=? ,userMail=? where userId=?";
		//赋值
		List<Object> list =new ArrayList<>();
		list.add(user.getUserSex());
		list.add(user.getUserMail());
		list.add(user.getUserId());
		//调用BaseDao的方法更新数据库
		int row=basedao.executeUpdate(sql, list);
		
		return row;
	}
	
	
	//修改密码功能中查询旧密码是否正确
	public User checkPwd(String password03) {
		//准备sql
		String sql="select * from c_user where userPwd=?";
		//赋值
		List<Object> list =new ArrayList<>();
		list.add(password03);
		//调用BaseDao的方法查询数据库
		User user=(User) basedao.queryRow(sql, list, User.class);
		return user;
	}
	
	
	//修改个人密码	
	public int updatePwd(User user) {
		// 准备sql
		String sql="update c_user set userPwd=? where userId=?";
		//赋值
		List<Object> list =new ArrayList<>();
		list.add(user.getUserPwd());
		list.add(user.getUserId());
		//调用BaseDao的方法更新数据库
		int row=basedao.executeUpdate(sql, list);
		return row;
	}
	
	/**
	 * 个人中心
	 * 查看个人订单
	 * @param request
	 * @param response
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	public List<Order> checkUserOrder(Integer userId) {
		//查询当前登录用户所有的订单信息
		String selectOrder="select o.orderId ,o.userId,o.orderNumber,o.orderStatus,o.orderPayment,o.orderSend,o.orderEnd,o.orderClose,o.orderCreate,o.orderUpdate,o.orderMoney,o.orderisIn from c_user u,c_order o where u.userId=o.userId  and u.userId=? and o.orderisIn=1 ";
		List<Object> params=new ArrayList();
		params.add(userId);
		
		List<Order> OrderList=basedao.queryRows(selectOrder, params, Order.class);
		
		//不全订单中的商品信息
		for(int i=0;i<OrderList.size();i++){
			//获取到当前订单对象,并且获取到订单对象中的订单编号
			Order order=OrderList.get(i);
			String OrderNumber=order.getOrderNumber();
			
			//准备sql，传入订单编号作为参数
			String selectOrderProDetails="select p.proId,p.proImg,p.proName,p.proBrand,p.proPrice,so.soCount,so.soId,o.orderId,o.userId from c_order o,c_sorder so,c_product p where so.orderId = o.orderId and so.proId=p.proId and o.orderNumber=?";
			List<Object> Forparams=new ArrayList();
			
			Forparams.add(OrderNumber);
			
			//创建订单内商品信息对象集合
			List<OrderProDetails> OrderProDetailsList=basedao.queryRows(selectOrderProDetails, Forparams, OrderProDetails.class);
			System.out.println(OrderProDetailsList.get(0));
			System.out.println(OrderProDetailsList.get(1));
			OrderList.get(i).setList(OrderProDetailsList);
			
		}
		return OrderList;

	}

	


	


}
