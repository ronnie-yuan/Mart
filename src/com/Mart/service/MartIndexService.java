package com.Mart.service;

import java.util.ArrayList;
import java.util.List;

import com.Mart.Dao.MartIndexDao;
import com.Mart.po.BigType;
import com.Mart.po.Cart;
import com.Mart.po.Product;
import com.Mart.po.vo.ResultInfo;
import com.Mart.util.StringUtil;



public class MartIndexService {
	private static MartIndexDao dao=new MartIndexDao();
	
	//进入主页,循环出商品分类中的数据
	public ResultInfo<List<BigType>> selectBigType() {
		List<BigType> list= new ArrayList();
		list = dao.selectBigType();
		ResultInfo<List<BigType>> resultInfo=new ResultInfo();
		if(list == null){
			resultInfo.setCode(0);
			return resultInfo;
		}
		resultInfo.setCode(1);
		resultInfo.setResult(list);
		return resultInfo;
	}
	
	//进入分类查询页面
	public ResultInfo<List<Product>> delectBigTypes(String bigId) {
		Integer i= Integer.parseInt(bigId);
		List<Product> list =new ArrayList<>();
		//调用dao层方法进行查询
		list=dao.delectBigTypes(i);
		ResultInfo<List<Product>> resultInfo=new ResultInfo();
		
		if(list == null){
			resultInfo.setCode(0);
			resultInfo.setMsg("未查询到该分类商品信息");
			return resultInfo;
		}
		
		resultInfo.setCode(1);
		resultInfo.setResult(list);
		return resultInfo;
	}
	
	//商品分类页面商品添加到购物车操作
	public int addCart(Integer userId, Integer proId) {
		int rwo=dao.addCart(userId,proId);
		return rwo;
	}
	
	//添加购物车时查询当前用户是否已经添加该商品
	public Cart addCartSelect(Integer userId, Integer proId) {
		//调用dao层进行查询
		Cart cart=dao.addCartSelect(userId,proId);
		
		return cart;
	}
	
	//进行商品分类页面商品数量增加操作
	public int addCartNum(Integer userId, Integer proId) {
		//调用dao层进行添加
		int row=dao.addCartNum(userId,proId);
		return row;
	}
}
