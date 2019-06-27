package com.Mart.Dao;

import java.util.ArrayList;
import java.util.List;

import com.Mart.po.BigType;
import com.Mart.po.Cart;
import com.Mart.po.Product;

public class MartIndexDao {
	private static BaseDao dao=new BaseDao();
	
	//进入主页,循环出商品分类中的数据
	public List<BigType> selectBigType() {
		List params=new ArrayList<>();
		String sql="select * from c_bigtype b order by b.bigId";
		List<BigType> list=dao.queryRows(sql, params, BigType.class);
		return list;
	}
	
	//进入分类查询页面
	public List<Product> delectBigTypes(Integer bigId) {
		//准备sql
		String sql="select * from c_product where bigId=?";
		//准备参数
		List<Object> params=new ArrayList();
		params.add(bigId);
		//调用basedao方法
		List<Product> list=dao.queryRows(sql, params, Product.class);
		return list;
	}
	
	//商品分类页面商品添加到购物车操作
	public int addCart(Integer userId, Integer proId) {
		//准备sql
		String sql="insert into c_cart(userId,proId,cCount,cChecked) VALUE(?,?,1,0)";
		//准备参数
		List<Object> params=new ArrayList();
		params.add(userId);
		params.add(proId);
		//调用basedao方法
		int row=dao.executeUpdate(sql, params);
		return row;
	}
	
	//添加购物车时查询当前用户是否已经添加该商品
	public Cart addCartSelect(Integer userId, Integer proId) {
		//准备sql
		String sql="select * from c_cart where userId=? and proId=?";
		//准备参数
		List<Object> params=new ArrayList<>();
		params.add(userId);
		params.add(proId);
		//调用baseDao方法
		Cart cart=(Cart) dao.queryRow(sql, params, Cart.class);
		return cart;
	}
	
	//进行商品分类页面商品数量增加操作
	public int addCartNum(Integer userId, Integer proId) {
		//准备sql
		String sql="UPDATE c_cart c SET c.cCount=c.cCount+1 where c.userId=? and c.proId=?";
		List<Object> params=new ArrayList();
		params.add(userId);
		params.add(proId);
		//调用basedao的方法
		int i=dao.executeUpdate(sql, params);
		return i;
	}


}
