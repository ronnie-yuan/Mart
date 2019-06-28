package com.Mart.Dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.Mart.po.BigType;
import com.Mart.po.Cart;
import com.Mart.po.Collect;
import com.Mart.po.Order;
import com.Mart.po.OrderProDetails;
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
	
	//购物车传来用户需要购买的所有商品信息,进行订单创建
	public int insertOrder(Integer userId, String orderNumber, String orderCreate, Integer orderMoney) {
		//准备sql
		String sql="insert into c_order(userId,orderNumber,orderCreate,orderMoney) values(?,?,?,?)";
		List<Object> params=new ArrayList();
		params.add(userId);
		params.add(orderNumber);
		params.add(orderCreate);
		params.add(orderMoney);
		
		//调用basedao方法
		int row=dao.executeUpdate(sql, params);
		return row;
	}
	
	//通过创建了的订单编号去数据库查询返回一个当前创建订单的订单类
	public Order cjOrder(String orderNumber) {
		//准备sql
		String sql="select * from c_order where orderNumber=?";
		List<Object> params=new ArrayList();
		params.add(orderNumber);
		Order order=(Order) dao.queryRow(sql, params, Order.class);
		return order;
	}
	
	
	//通过获取到的需要购买的商品id 来进行查询当前购买用户购物车中对应的商品数量
	public List<Integer> selectSocount(Integer userId, List<Integer> list) {
		//准备sql语句
		String sql="select cCount from c_cart where userId=? and proId=? ";
		
		List<Integer> Socount=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			List<Object> params=new ArrayList();
			params.add(userId);
			params.add(list.get(i));
			Socount.add((Integer) dao.findSingleValue(sql, params));
		}
		return Socount;
	}
	
	//订单创建成功后进行订单子表的添加操作
	public int insertSorder(Integer orderId, List<Integer> list, List<Integer> socount) {
		//准备sql
		String sql="insert into c_sorder(orderId,proId,soCount) values(?,?,?)";
		
		int count=0;
		for(int i=0;i<list.size();i++){
			List<Object> params=new ArrayList();
			params.add(orderId);
			params.add(list.get(i));
			params.add(socount.get(i));
			dao.executeUpdate(sql, params);
			count++;
		}
		return count;
	}

	//删除购物车中对应的当前用户所选择购买的商品信息
	public int delectCarPro(Integer userId, List<Integer> list) {
		//准备sql
		String sql="DELETE FROM c_cart where userid=? and proId=?";
		
		int count=0;
		for(int i=0;i<list.size();i++){
			List<Object> params=new ArrayList();
			params.add(userId);
			params.add(list.get(i));
			dao.executeUpdate(sql, params);
			count++;
		}
		return count;

	}
	
	//查询订单子表,将该订单编号的所有商品存入到当前订单对象中显示
	public List<OrderProDetails> selsectOrderProDetails(String orderNumber) {
		//准备sql
		String sql="select p.proId,p.proImg,p.proName,p.proBrand,p.proPrice,so.soCount,so.soId,o.orderId,o.userId from c_order o,c_sorder so,c_product p where so.orderId = o.orderId and so.proId=p.proId and o.orderNumber=?";
		List<Object> params=new ArrayList();
		params.add(orderNumber);
		List<OrderProDetails> list=dao.queryRows(sql, params, OrderProDetails.class);

		return list;
	}
	
	//进行pay支付宝表的添加
	public int insertPay(Integer userId, Integer orderId, String trade_no) {
		//准备sql
		String sql="insert into c_pay(userId,orderId,payNumber) values(?,?,?)";
		List<Object> params=new ArrayList();
		params.add(userId);
		params.add(orderId);
		params.add(trade_no);
		
		int rwo=dao.executeUpdate(sql, params);
		return rwo;
	}
	
	//调用addWishlist()方法查询当前用户是否已经添加该商品,如果添加了,则在心愿表表上修改该商品数量 1有  0无
	public Collect addWishlist(Integer userId, Integer proId) {
		//准备sql
		String sql="select * from c_collect where userId=? and proId=?";
		List<Object> params=new ArrayList();
		params.add(userId);
		params.add(proId);
		Collect collect=(Collect) dao.queryRow(sql, params, Collect.class);
		
		return collect;
	}

	public void addWishlistOne(Integer userId, Integer proId) {
		//准备sql
		String sql="insert into c_collect(userId,proId) values(?,?)";
		List<Object> params=new ArrayList();
		params.add(userId);
		params.add(proId);
		dao.executeUpdate(sql, params);
		
	}

	public void allChecked(Integer userId, Integer status) {
		//准备sql
		String sql="UPDATE c_cart c SET c.cChecked=? WHERE c.userId=?";
		List<Object> params=new ArrayList();
		params.add(status);
		params.add(userId);
		
		dao.executeUpdate(sql, params);
		
		
	}
	
	//获取到购物车中当前登录用户购物车中选中商品的id集合
	public List<Product> selectProIdList(Integer userId) {
		//准备sql
		String sql="select c.proId from c_cart c where c.userId=? and c.cchecked=1";
		List<Object> params=new ArrayList();
		params.add(userId);
		List<Product> li= dao.queryRows(sql, params, Product.class);
		
		return li;
	}
	
	//获取当前购物车中选中状态的所有商品的总价
	public BigDecimal selectAllCkmMo(Integer userId) {
		//准备sql
		String sql="select sum(c.cCount * p.proPrice)   from c_cart c ,c_product p where c.userId=? and c.proId=p.proId and c.cChecked=1";
		List<Object> params=new ArrayList();
		params.add(userId);
		BigDecimal  in=(BigDecimal) dao.findSingleValue(sql, params);
		
		return in;
	}
	
	//购物车页面 单选事件
	public int singleClick(Integer status, Integer userId, Integer proId) {
		//准备sql
		String sql="UPDATE c_cart c SET c.cChecked=? WHERE c.userId=? and c.proId=?";
		List<Object> params=new ArrayList();
		params.add(status);
		params.add(userId);
		params.add(proId);
		int row=dao.executeUpdate(sql, params);
		
		return row;
	}

	public List<Cart> selectProCheck(Integer userId) {
		//准备sql
		String sql="select c.proId from c_cart c where c.userId=? and c.cChecked=1";
		List<Object> params=new ArrayList();
		params.add(userId);
		List<Cart> li=dao.queryRows(sql, params, Cart.class);
		
		
		return li;
	}


}
