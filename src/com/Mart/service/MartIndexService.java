package com.Mart.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.Mart.Dao.MartIndexDao;
import com.Mart.po.BigType;
import com.Mart.po.Cart;
import com.Mart.po.Cartproduct;
import com.Mart.po.Collect;
import com.Mart.po.Order;
import com.Mart.po.OrderProDetails;
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
	
	//购物车传来用户需要购买的所有商品信息,进行订单创建
	public int insertOrder(Integer userId, String orderNumber, String orderCreate, Integer orderMoney) {
		//调用dao层进行添加方法
		int row=dao.insertOrder(userId,orderNumber,orderCreate,orderMoney);
		return row;
	}
	
	//通过创建了的订单编号去数据库查询返回一个当前创建订单的订单类
	public Order cjOrder(String orderNumber) {
		Order order=dao.cjOrder(orderNumber);
		
		return order;
	}
	
	//通过获取到的需要购买的商品id 来进行查询当前购买用户购物车中对应的商品数量
	public List<Integer> selectSocount(Integer userId, List<Integer> list) {
		List<Integer> Socount=dao.selectSocount(userId,list);
		return list;
	}
	
	//订单创建成功后进行订单子表的添加操作
	public int insertSorder(Integer orderId, List<Integer> list, List<Integer> socount) {
		int addSorder=dao.insertSorder(orderId,list,socount);
		return addSorder;
	}
	
	//删除购物车中对应的当前用户所选择购买的商品信息
	public int delectCarPro(Integer userId, List<Integer> list) {
		int rwo=dao.delectCarPro(userId,list);
		return rwo;
	}
	
	//查询订单子表,将该订单编号的所有商品存入到当前订单对象中显示
	public List<OrderProDetails> selsectOrderProDetails(String orderNumber) {
		List<OrderProDetails>	selectOrPro=dao.selsectOrderProDetails(orderNumber);
		return selectOrPro;
	}
	
	//调用addWishlist()方法查询当前用户是否已经添加该商品,如果添加了,则在心愿表表上修改该商品数量 1有  0无
	public int addWishlist(Integer userId, Integer proId) {
		//查询当前心愿单
		int rwo=0;
		Collect collect=dao.addWishlist(userId,proId);
		if(collect != null){
			rwo=1;
		}
		return rwo;
	}
	
	//添加心愿单操作
	public void addWishlistOne(Integer userId, Integer proId) {
		dao.addWishlistOne(userId,proId);
		
	}
	
	//购物车全选全不选修改购物车表内商品选择信息
	public void allChecked(Integer userId, Integer status) {
		dao.allChecked(userId,status);
		
	}
	
	//获取到购物车中当前登录用户购物车中选中商品的id集合
	public List<Product> selectProIdList(Integer userId) {
		List<Product> list=dao.selectProIdList(userId);
		return list;
	}
	
	//获取当前购物车中选中状态的所有商品的总价
	public BigDecimal selectAllCkmMo(Integer userId) {
		BigDecimal mo=dao.selectAllCkmMo(userId);
		return mo;
	}
	
	//购物车页面 单选事件
	public int singleClick(Integer status, Integer userId, Integer proId) {
		int row=dao.singleClick(status,userId,proId);
		return row;
	}
	
	//查询当前是否有选择的商品
	public int selectProCheck(Integer userId) {
		int rwo=0;
		List<Cart> catrList=dao.selectProCheck(userId);
		System.out.println(catrList.size());
		if(catrList.size() >0){
			rwo=1;
		}
		return rwo;
	}
	
	//查询单个商品
	public Product goushopDetails(Integer id) {
		
		Product product=dao.goushopDetails(id);
		return product;
	}
	
	//获取当前登录用户购物车中所有选中的商品数量
	public List<Cartproduct> selectUserProCked(Integer userId) {
		List< Cartproduct > selectUserProCkedList =dao.selectUserProCked(userId);
		return selectUserProCkedList;
	}

	public int addUserBl(Integer money, Integer userId) {
		int addTrueAndFalse=dao.addUserBl(money,userId);
		if(addTrueAndFalse != 1){
			return 0;
		}
		return 1;
	}


	

}
