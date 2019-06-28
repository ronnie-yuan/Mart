package com.Mart.service;



import java.util.List;

import com.Mart.Dao.MartCarDao;
import com.Mart.po.Cart;
import com.Mart.po.Cartproduct;
import com.Mart.po.vo.ResultInfo;
import com.Mart.util.StringUtil;

public class MartCarService {
	private  MartCarDao martcarDao=new MartCarDao();
	
	/**
	 * 查询商品集合
	 * 	1、调用Dao层的查询方法，通过当前用户ID查询商品列表，返回类型列表List<Cartproduct>
		2、判断类型列表是否为空
			如果为空，code=0，mag=xxx，返回resultInfo对象
			如果不为空，code=1，将集合设置到reusultInfo对象，返回resultInfo对象
	 * @param userId
	 * @return
	 */
	public ResultInfo<List<Cartproduct>> findProduct(Integer userId) {
		//调用Dao层的方法，通过用户Id查询购物车商品列表
		List<Cartproduct>list=martcarDao.FindListByUserId(userId);
		ResultInfo<List<Cartproduct>>resultInfo=new ResultInfo<>();
		if(list==null||list.size()<1){
			resultInfo.setCode(0);
			resultInfo.setMsg("购物车中无商品");
		}else{
			resultInfo.setCode(1);
			resultInfo.setResult(list);
		}
		return resultInfo;
	}
	/*
	public ResultInfo<Cartproduct> deleteProduct(Integer proId) {
		long count =martcarDao.findCartproductbyproId();
	}*/

	public int plusPro(Integer userId, Integer proId) {
		// 
		int i=martcarDao.plusPro(userId,proId);
		return i;
	}

	

	public int minusPro(Integer userId, Integer proId) {
		//
		int i=martcarDao.minusPro(userId,proId);
		return i;
		
	}

	public int deletePro(Integer userId, Integer proId) {
		int i=martcarDao.deletePro(userId,proId);
		return i;
	}
	
	

}
