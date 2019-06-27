package com.Mart.test;

import java.util.List;

import org.junit.Test;

import com.Mart.Dao.MartBackstageDao;
import com.Mart.po.Order;
import com.Mart.po.Product;
import com.Mart.po.User;

public class TestMartBackstageDao {

	MartBackstageDao martBackstageDao = new MartBackstageDao();
	
	@Test
	public void testCheckIdByUserName() {
		boolean flag = martBackstageDao.checkIdByUserName("彪", 1);
		System.out.println(flag);
	}

	@Test 
	public void testFindAllUser(){
		List<User> list = martBackstageDao.findAllUser();
		System.out.println(list);
	}
	
	@Test
	public void testSearchAllProductAndStock(){
		List<Product> product = martBackstageDao.searchAllProductAndStock();
		System.out.println(product);
	}
	
	@Test
	public void testSearchAllUserOrders(){
		List<Order> list = martBackstageDao.searchAllUserOrders();
		System.out.println(list);
	}
}
