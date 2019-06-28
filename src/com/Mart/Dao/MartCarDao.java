package com.Mart.Dao;



import java.util.ArrayList;
import java.util.List;

import com.Mart.po.Cart;
import com.Mart.po.Cartproduct;

public class MartCarDao {


	@SuppressWarnings("unchecked")
	public List<Cartproduct> FindListByUserId(Integer userId) {
		// 1.定义sql语句
		String sql="select p.proId,proImg,  proName,  proPrice,  ccount ,cchecked  from  c_user, c_cart, c_product p where c_user.userId=c_cart.userId and c_cart.proId=p.proId and c_user.userId=?";
		//2.设置参数集合
		List<Object>params =new ArrayList<>();
		params.add(userId);
		//3.调用BaseDao的查询方法，返回类型集合
		List<Cartproduct> list=BaseDao.queryRows(sql, params, Cartproduct.class);
		return list;
	}

	public int plusPro(Integer userId, Integer proId) {
		// 1.选择sql语句
		String sql="UPDATE c_cart c SET cCount=c.cCount+1 WHERE c.userId=? and c.proId=?";
		
		List<Object>params=new ArrayList<>();
		params.add(userId);
		params.add(proId);
		int rows=BaseDao.executeUpdate(sql, params);
		return rows;
	}

	public int minusPro(Integer userId, Integer proId) {
		// 1.选择sql语句
		String sql="UPDATE c_cart c SET cCount=c.cCount-1 WHERE c.userId=? and c.proId=?";
		List<Object>params=new ArrayList<>();
		params.add(userId);
		params.add(proId);
		int rows=BaseDao.executeUpdate(sql, params);
		return rows;
	}

	public int deletePro(Integer userId, Integer proId) {
		// 1.选择SQL语句
		String sql="DELETE from c_cart where c_cart.userId=? and c_cart.proId=?";
		List<Object>params=new ArrayList<>();
		params.add(userId);
		params.add(proId);
		int rows=BaseDao.executeUpdate(sql, params);
		return rows;
	}

	
	
	
	
	 

	

}
