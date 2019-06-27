package com.Mart.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.Mart.po.Product;
import com.Mart.po.User;
import com.Mart.po.vo.ResultInfo;
import com.Mart.service.MartBackstageService;

public class TestMartBackstageService {
	
	MartBackstageService martBackstageService = new MartBackstageService();
	
	User user = new User();
	
	@Test
	public void testSearchUser() {
		
		ResultInfo<List<User>> resultInfo = martBackstageService.searchUser(2);
		System.out.println(resultInfo);
		System.out.println(resultInfo.getCode());
		System.out.println(resultInfo.getMsg());
		System.out.println(resultInfo.getResult());
		
	}
	@Test
	public void testAddOrUpdateUser(){
		
		
		user.setUserName("Shirakami Fubuki");
		user.setUserPwd("A490922h");
		user.setUserSex(2);
		user.setUserMail("Shirakami@gmail.com");
		user.setUserMobile("330615218080");
		user.setUserHead("http://img2.imgtn.bdimg.com/it/u=626158890,4048352046&fm=26&gp=0.jpg");
		user.setUserBalance(5000);
		user.setUserStatus(1);
		user.setUserCreateTime(null);
		user.setUserAnswer("不是, 是猫");
		user.setUserQuestion("你是狐狸吗?");
		
		ResultInfo<User> resultInfo = martBackstageService.addOrUpdateUser(user);
		System.out.println(resultInfo);
		System.out.println(resultInfo.getCode());
		System.out.println(resultInfo.getMsg());
		System.out.println(resultInfo.getResult());
		
	}
	@Test
	public void testSearchProductAndStockByProId(){
		ResultInfo<List<Product>> resultInfo = martBackstageService.searchAllProductAndStock();
		System.out.println(resultInfo);
		System.out.println(resultInfo.getCode());
		System.out.println(resultInfo.getMsg());
		System.out.println(resultInfo.getResult());
	}
	@Test
	public void testAddOrUpdateProductStock(){
		Product product = new Product();
		
		product.setProName("Ti9门票");
		product.setProPrice(5000);
		product.setProStock(100);
		product.setProBrand("大麦黄牛牌");
		product.setProStatus(1);
		product.setProDescription("黄牛亲妈爆炸");
		product.setProImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562075853&di=98bd0a23c4574a80e03671464fb84e38&imgtype=jpg&er=1&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20190521%2Ff135f927db3f41a68801c462789dedfb.jpeg");
		product.setSmId(null);
		product.setBigId(7);
		
		ResultInfo<Product> resultInfo = martBackstageService.addOrUpdateProductStock(product);
		System.out.println(resultInfo);
		System.out.println(resultInfo.getCode());
		System.out.println(resultInfo.getMsg());
		System.out.println(resultInfo.getResult());
	}
}
