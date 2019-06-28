package com.Mart.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Mart.Dao.BaseDao;
import com.Mart.po.Order;
import com.Mart.po.OrderProDetails;
import com.Mart.po.Product;
import com.Mart.po.User;
import com.Mart.util.DBUtil;

/**
 * 后台Dao层
 * @author MSI-PC
 *
 */
public class MartBackstageDao {
	
	
	public List<User> findAllUser(){
		User user = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<User> list = new ArrayList<>();
		
		try {
			// 1、得到数据库连接
			connection = DBUtil.getConnection();
			// 2、准备SQL语句
			String sql = "select * from c_user";
			
			// 3、预编译
			preparedStatement = connection.prepareStatement(sql);
			
			// 4、执行查询，返回结果集
			resultSet = preparedStatement.executeQuery();
			// 5、判断并分析结果集，得到user对象
			while(resultSet.next()) {
				user = new User();
				user.setUserId(resultSet.getInt("userId"));
				user.setUserName(resultSet.getString("userName"));
				user.setUserPwd(resultSet.getString("userPwd"));
				user.setUserSex(resultSet.getInt("userSex"));
				user.setUserMobile(resultSet.getString("userMobile"));
				user.setUserHead(resultSet.getString("userHead"));
				user.setUserBalance(resultSet.getInt("userBalance"));
				user.setUserStatus(resultSet.getInt("userStatus"));
				user.setUserCreateTime(resultSet.getString("userCreateTime"));
				user.setUserAnswer(resultSet.getString("userAnswer"));
				user.setUserQuestion(resultSet.getString("userQuestion"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBUtil.close(connection, preparedStatement, resultSet);
		}	
		return list;
	}
	
	
	/**
	 * 通过用户名查找用户信息
	 * @param uname
	 * @return
	 */
	public User findUserByName(String uname) {
		User user = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			// 1、得到数据库连接
			connection = DBUtil.getConnection();
			// 2、准备SQL语句
			String sql = "select * from c_user where userName = ?";
			
			// 3、预编译
			preparedStatement = connection.prepareStatement(sql);
			// 4、设置参数，下标从1开始
			preparedStatement.setString(1, uname);
			
			// 5、执行查询，返回结果集
			resultSet = preparedStatement.executeQuery();
			// 6、判断并分析结果集，得到user对象
			if (resultSet.next()) {
				user = new User();
				user.setUserId(resultSet.getInt("userId"));
				user.setUserName(uname);
				user.setUserPwd(resultSet.getString("userPwd"));
				user.setUserSex(resultSet.getInt("userSex"));
				user.setUserMobile(resultSet.getString("userMobile"));
				user.setUserHead(resultSet.getString("userHead"));
				user.setUserBalance(resultSet.getInt("userBalance"));
				user.setUserStatus(resultSet.getInt("userStatus"));
				user.setUserCreateTime(resultSet.getString("userCreateTime"));
				user.setUserAnswer(resultSet.getString("userAnswer"));
				user.setUserQuestion(resultSet.getString("userQuestion"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		return user;
	}
	
	/**
	 * 按照用户Id查找用户信息
	 * @param id
	 * @return
	 */
	public List<User> findUserById(Integer id){
		User user = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<User> list = new ArrayList<>();
		
		try {
			// 1、得到数据库连接
			connection = DBUtil.getConnection();
			// 2、准备SQL语句
			String sql = "select * from c_user where userId = ?";
			
			// 3、预编译
			preparedStatement = connection.prepareStatement(sql);
			// 4、设置参数，下标从1开始
			preparedStatement.setInt(1, id);
			
			// 5、执行查询，返回结果集
			resultSet = preparedStatement.executeQuery();
			// 6、判断并分析结果集，得到user对象
			if (resultSet.next()) {
				user = new User();
				user.setUserId(id);
				user.setUserName(resultSet.getString("userName"));
				user.setUserPwd(resultSet.getString("userPwd"));
				user.setUserSex(resultSet.getInt("userSex"));
				user.setUserMobile(resultSet.getString("userMobile"));
				user.setUserHead(resultSet.getString("userHead"));
				user.setUserBalance(resultSet.getInt("userBalance"));
				user.setUserStatus(resultSet.getInt("userStatus"));
				user.setUserCreateTime(resultSet.getString("userCreateTime"));
				user.setUserAnswer(resultSet.getString("userAnswer"));
				user.setUserQuestion(resultSet.getString("userQuestion"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		
		list.add(user);
		return list;
	}
	
	/**
	 * 通过用户id修改用户信息
	 * @param user
	 * @return
	 */
	public int updateInfo(User user){
		// 定义sql语句
		String sql = "update c_user set userName = ?, userPwd = ?, userSex = ?, userMail = ?, userMobile = ?, userBalance = ?, userStatus = ?, userCreateTime = ?, userQuestion = ?, userAnswer = ? where userId = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUserName());
		params.add(user.getUserPwd());
		params.add(user.getUserSex());
		params.add(user.getUserMail());
		params.add(user.getUserMobile());
		params.add(user.getUserBalance());
		params.add(user.getUserStatus());
		params.add(user.getUserCreateTime());
		params.add(user.getUserQuestion());
		params.add(user.getUserAnswer());
		params.add(user.getUserId());
		
		// 调用BaseDao更新方法
		int row = BaseDao.executeUpdate(sql, params);
		return row;
	}
	
	public int updateInfoByName(User user){
		// 定义sql语句
		String sql = "update c_user set userId = ?, userPwd = ?, userSex = ?, userMail = ?, userMobile = ?, userHead = ?, userBalance = ?, userStatus = ?, userCreateTime = ?, userQuestion = ?, userAnswer = ? where userName = ?";
		
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUserId());
		params.add(user.getUserPwd());
		params.add(user.getUserSex());
		params.add(user.getUserMail());
		params.add(user.getUserMobile());
		params.add(user.getUserHead());
		params.add(user.getUserBalance());
		params.add(user.getUserStatus());
		params.add(user.getUserCreateTime());
		params.add(user.getUserQuestion());
		params.add(user.getUserAnswer());
		params.add(user.getUserName());
		
		// 调用BaseDao更新方法
		int row = BaseDao.executeUpdate(sql, params);
		return row;
	}
	
	public int insertUser(User user){
		// 定义sql语句
		String sql = "insert into c_user (userName, userPwd, userSex, userMail, userMobile, userHead, userBalance, userStatus, userCreateTime, userAnswer, userQuestion) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		List<Object> params = new ArrayList<Object>();
		
		params.add(user.getUserName());
		params.add(user.getUserPwd());
		params.add(user.getUserSex());
		params.add(user.getUserMail());
		params.add(user.getUserMobile());
		params.add(user.getUserHead());
		params.add(user.getUserBalance());
		params.add(user.getUserStatus());
		params.add(user.getUserCreateTime());
		params.add(user.getUserAnswer());
		params.add(user.getUserQuestion());
		
		
		// 调用BaseDao更新方法
		int row = BaseDao.executeUpdate(sql, params);
		return row;
	}
	/**
	 *  根据用户名删除
	 * @param uname
	 * @return
	 */
	public int deleteUserByName(String uname) {
		int row = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	
		
		try {
			// 1、得到数据库连接
			connection = DBUtil.getConnection();
			// 2、准备SQL语句
			String sql = "delete from c_user where userName = ?";
			
			// 3、预编译
			preparedStatement = connection.prepareStatement(sql);
			// 4、设置参数，下标从1开始
			preparedStatement.setString(1, uname);
			
			// 5、执行查询，返回结果集
			row = preparedStatement.executeUpdate();
		
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBUtil.close(connection, preparedStatement, null);
		}
		return row;
	}
	
	/**
	 * 根据用户id删除
	 * @param userId
	 * @return
	 */
	public int deleteUserById(Integer userId){
		int row = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		
		try {
			// 1、得到数据库连接
			connection = DBUtil.getConnection();
			// 2、准备SQL语句
			String sql = "delete from c_user where userId = ?";
			
			// 3、预编译
			preparedStatement = connection.prepareStatement(sql);
			
			// 4、设置参数，下标从1开始
			preparedStatement.setInt(1, userId);
			
			// 5、执行查询，返回结果集
			row = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBUtil.close(connection, preparedStatement, null);
		}
		return row;
	}
	/**
	 * 防止删除后用户id乱序, 配合删除使用
	 * @return
	 */
	public int avoidMessAfterDelete(){
		int row = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try{
			// 建立连接
			connection = DBUtil.getConnection();
			
			// 准备sql语句
			String sql = "alter table c_user auto_increment = 1";
			
			// 预处理
			preparedStatement = connection.prepareStatement(sql);
			
			row = preparedStatement.executeUpdate();
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, null);
		}
		
		return row;
	}
	/**
	 * 检查用户名和用户ID是否一致
	 * @param userName
	 * @param userId
	 * @return
	 */
	public boolean checkIdByUserName(String userName, Integer userId) {
		// 建立连接
		boolean flag = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			// 1、得到数据库连接
			connection = DBUtil.getConnection();
			// 2、准备SQL语句
			String sql = "select userName from c_user where userId = ?";
			
			// 3、预编译
			preparedStatement = connection.prepareStatement(sql);
			// 4、设置参数，下标从1开始
			preparedStatement.setInt(1, userId);
			
			// 5、执行查询，返回结果集
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				String uname = resultSet.getString("userName");
				if(userName.equals(uname)){
					flag = true;
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		
		return flag;
	}

	/**
	 * 查询所有商品及其库存
	 * @param proId
	 * @return
	 */
	public List<Product> searchAllProductAndStock() {
		Product product = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Product> list = new ArrayList<>();
	
		try {
			// 1、得到数据库连接
			connection = DBUtil.getConnection();
			// 2、准备SQL语句
			String sql = "select proId, proName, proBrand, proPrice, proStock, ProStatus, ProImg from c_product";
			
			// 3、预编译
			preparedStatement = connection.prepareStatement(sql);
		
			// 4、执行查询，返回结果集
			resultSet = preparedStatement.executeQuery();
			// 5、判断并分析结果集，得到user对象
			while(resultSet.next()) {
				product = new Product();
				product.setProId(resultSet.getInt("proId"));
				product.setProName(resultSet.getString("proName"));
			    product.setProBrand(resultSet.getString("proBrand"));
			    product.setProPrice(resultSet.getInt("proPrice"));
				product.setProStock(resultSet.getInt("proStock"));
				product.setProStatus(resultSet.getInt("proStatus"));
				product.setProImg(resultSet.getString("proImg"));
	
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBUtil.close(connection, preparedStatement, resultSet);
		}	
		return list;
	}

	/**
	 * 插入新商品数据
	 * @param product
	 * @return
	 */
	public int insertProduct(Product product) {
		// 准备sql语句
		String sql = "insert into c_product (proId, proName, proBrand, proPrice, proStock, proStatus, proImg, proDescription, smId, bigId) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		List<Object> params = new ArrayList<Object>();
		params.add(product.getProId());
		params.add(product.getProName());
		params.add(product.getProBrand());
		params.add(product.getProPrice());
		params.add(product.getProStock());
		params.add(product.getProStatus());
		params.add(product.getProImg());
		params.add(product.getProDescription());
		params.add(product.getSmId());
		params.add(product.getBigId());
		
		// 调用BaseDao更新方法
		int row = BaseDao.executeUpdate(sql, params);
		return row;
	}

	/**
	 * 更新商品价格, 库存, 状态
	 * @param proId
	 * @param proPrice
	 * @param proStock
	 * @param proStatus
	 * @return
	 */
	public int updatePriceStockStatus(Integer proId, Integer proPrice, Integer proStock, Integer proStatus) {
		//  定义sql语句
		String sql = "update c_product set proPrice = ?, proStock = ?, proStatus = ? where proId = ?";
		
		List<Object> params = new ArrayList<Object>();
		params.add(proPrice);
		params.add(proStock);
		params.add(proStatus);
		params.add(proId);
		
		// 调用BaseDao更新方法
		int row = BaseDao.executeUpdate(sql, params);
		return row;
	}

	/**
	 * 修改当前产品的所有信息
	 * @param product
	 * @return
	 */
	public int updateAllProductProperties(Product product) {
		// 定义sql语句
		String sql = "update c_product set proName = ?, proBrand = ?, proPrice = ?, proStock = ?, proStatus = ?, proImg = ?, proDescription = ?, smId = ?, bigId = ? where proId = ?";
		
		List<Object> params = new ArrayList<Object>();
		params.add(product.getProName());
		params.add(product.getProBrand());
		params.add(product.getProPrice());
		params.add(product.getProStock());
		params.add(product.getProStatus());
		params.add(product.getProImg());
		params.add(product.getProDescription());
		params.add(product.getSmId());
		params.add(product.getBigId());
		params.add(product.getProId());
		
		// 调用BaseDao更新方法
		int row = BaseDao.executeUpdate(sql, params);
		return row;
	}

	/**
	 * 查询所有订单, 由于Order类有一个OrderProDetails类列表, 所以需要分步操作
	 * @return
	 */
	public List<Order> searchAllUserOrders() {
		// TODO Auto-generated method stub
		Order orders = null;
		OrderProDetails orderProDetails = null;
		Connection connection = null;
		PreparedStatement preparedStatement1 = null; //处理订单sql
		PreparedStatement preparedStatement2 = null; //处理商品详情sql
		ResultSet resultSet1 = null;  // 处理订单sql
		ResultSet resultSet2 = null;  // 处理商品详情sql
		List<Order> list = new ArrayList<>(); // 订单列表
		List<OrderProDetails> details = new ArrayList<>(); // 商品详情列表
		
		try{
			connection = DBUtil.getConnection();
			
			String orderSql = "select * from c_user u,c_order o where u.userId=o.userId";
			String orderDetailSql = "select p.proId,p.proImg,p.proName,p.proBrand,p.proPrice,so.soCount,so.soId,o.orderId,o.userId from c_order o,c_sorder so,c_product p where so.orderId = o.orderId and so.proId=p.proId";
			

			// 3、预编译
			preparedStatement1 = connection.prepareStatement(orderSql);
			preparedStatement2 = connection.prepareStatement(orderDetailSql);
		
			// 4、执行查询，返回结果集
			resultSet1 = preparedStatement1.executeQuery();
			resultSet2 = preparedStatement2.executeQuery();
			
			while(resultSet2.next()){ // 需要先获得商品细节列表
				orderProDetails = new OrderProDetails();
				orderProDetails.setOrderId(resultSet2.getInt("orderId"));
				orderProDetails.setProId(resultSet2.getInt("proId"));
				orderProDetails.setUserId(resultSet2.getInt("userId"));
				orderProDetails.setSoId(resultSet2.getInt("soId"));
				orderProDetails.setSoCount(resultSet2.getInt("soCount"));
				orderProDetails.setProBrand(resultSet2.getString("proBrand"));
				orderProDetails.setProName(resultSet2.getString("proName"));
				orderProDetails.setProImg(resultSet2.getString("proImg"));
				orderProDetails.setProPrice(resultSet2.getInt("proPrice")); // 注意ProPrice
				
				details.add(orderProDetails);
			}
			
			while(resultSet1.next()){ // 再获取订单列表
				orders = new Order();
				orders.setOrderId(resultSet1.getInt("orderId"));
				orders.setUserId(resultSet1.getInt("userId"));
				orders.setOrderisIn(resultSet1.getInt("orderisIn"));
				orders.setOrderStatus(resultSet1.getInt("orderStatus"));
				orders.setOrderMoney(resultSet1.getInt("orderMoney"));
				orders.setOrderNumber(resultSet1.getString("orderNumber"));
				orders.setOrderPayment(resultSet1.getString("orderPayment"));
				orders.setOrderCreate(resultSet1.getString("orderCreate"));
				orders.setOrderClose(resultSet1.getString("orderClose"));
				orders.setOrderUpdate(resultSet1.getString("orderUpdate"));
				orders.setOrderEnd(resultSet1.getString("orderEnd"));
				orders.setOrderSend(resultSet1.getString("orderSend"));
				orders.setList(details);
				list.add(orders);
				
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, preparedStatement1, resultSet1);
			DBUtil.close(connection, preparedStatement2, resultSet2);
		}
		
		return list;
	}

	/**
	 * 判断orderId是否在order表中
	 * @param orderId
	 * @return
	 */
	public boolean orderIdInOrders(Integer orderId) {
		// 建立连接
		boolean flag = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			// 1、得到数据库连接
			connection = DBUtil.getConnection();
			// 2、准备SQL语句
			String sql = "select orderId from c_order where orderId = ?";
			
			// 3、预编译
			preparedStatement = connection.prepareStatement(sql);
			// 4、设置参数，下标从1开始
			preparedStatement.setInt(1, orderId);
			
			// 5、执行查询，返回结果集
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				String id = resultSet.getString("orderId");
				if(id != null){
					flag = true;
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		
		return flag;
	}

	/**
	 * 更新当前orderId的信息
	 * @param order
	 * @return
	 */
	public int updateOrder(Order order) {
		// 准备sql语句
		
		String sql = "update c_order set orderStatus = ?, orderUpdate = ?, orderMoney = ?, orderisIn = ? where orderId = ?";
		
		List<Object> params = new ArrayList<Object>();
		params.add(order.getOrderStatus());
		params.add(order.getOrderUpdate());
		params.add(order.getOrderMoney());
		params.add(order.getOrderisIn());
		params.add(order.getOrderId());
		
		int row = BaseDao.executeUpdate(sql, params);
		return row;
	}

	/**
	 * 插入新订单
	 * @param order
	 * @return
	 */
	public int insertOrder(Order order) {
		// 准备sql语句
		
		String sql = "insert into c_order (orderId, userId, orderNumber, orderStatus, orderPayment, orderSend, orderClose, orderCreate, orderUpdate, orderMoney, orderisIn) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		List<Object> params = new ArrayList<Object>();
		params.add(order.getOrderId());
		params.add(order.getUserId());
		params.add(order.getOrderNumber());
		params.add(order.getOrderStatus());
		params.add(order.getOrderPayment());
		params.add(order.getOrderSend());
		params.add(order.getOrderClose());
		params.add(order.getOrderCreate());
		params.add(order.getOrderUpdate());
		params.add(order.getOrderMoney());
		params.add(order.getOrderisIn());
		
		int row = BaseDao.executeUpdate(sql, params);
		return row;
	}


	public int setOrderStatus(Integer orderId, Integer orderStatus) {
		// 准备sql语句
		
		String sql = "update c_order set orderStatus = ? where orderId = ?";
		
		List<Object> params = new ArrayList<Object>();
		params.add(orderStatus);
		params.add(orderId);
		
		int row = BaseDao.executeUpdate(sql, params);
		return row;
	}


	public int setProductStatus(Integer proId, Integer proStatus) {
		// 准备sql语句
		
		String sql = "update c_product set proStatus = ? where proId = ?";
		
		List<Object> params = new ArrayList<Object>();
		params.add(proStatus);
		params.add(proId);
		
		int row = BaseDao.executeUpdate(sql, params);
		return row;
	}

/**
 * 设置用户状态
 * @param userId
 * @param userStatus
 * @return
 */
	public int setUserStatus(Integer userId, Integer userStatus) {
		// 准备sql语句
		
		String sql = "update c_user set userStatus = ? where userId = ?";
		
		List<Object> params = new ArrayList<Object>();
		params.add(userStatus);
		params.add(userId);
		
		int row = BaseDao.executeUpdate(sql, params);
		return row;
	}

/**
 * 用户余额-订单总额
 * @param orderId
 * @param userId
 * @param orderStatus
 * @param orderMoney
 * @return
 */
public int substractUserBalance(Integer orderId, Integer userId, Integer orderStatus, Integer orderMoney) {
	
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;	
		Integer userBalance = null;
		
		try{
			// 1、得到数据库连接
						connection = DBUtil.getConnection();
						// 2、准备SQL语句
						String sql = "select userBalance from c_user where userId = ?";
						
						// 3、预编译
						preparedStatement = connection.prepareStatement(sql);
						
						// 4、设置参数，下标从1开始
						preparedStatement.setInt(1, userId);
						
						// 5、执行查询，返回结果集
						resultSet = preparedStatement.executeQuery();
						
						while(resultSet.next()){
							userBalance = resultSet.getInt("userBalance");
						}
						
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}
		
		Integer newUserBalance = userBalance - orderMoney; 
			
		String updateSql = "update c_user set userBalance = ? where userId = ?";
		
		List<Object> params = new ArrayList<Object>();
		params.add(newUserBalance);
		params.add(userId);
	
		int row = BaseDao.executeUpdate(updateSql, params);
		return row;
	}

/**
 * 查找当前商品库存, 当前订单商品数量, 并将库存修改为当前库存-该订单商品数量
 * @param orderId
 * @return
 */
public Map<Integer, Integer> substractOrderProductStock(Integer orderId) {
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	PreparedStatement preparedStatement2 = null;
	PreparedStatement preparedStatement3 = null;
	ResultSet resultSet = null;	
	ResultSet resultSet2 = null;
	ResultSet resultSet3 = null;
	Integer proId = null;
	Integer proStock = null;
	Map<Integer, Integer> proId_proStock = new HashMap<Integer, Integer>();
	
	try{
		// 1、得到数据库连接
		connection = DBUtil.getConnection();
		// 2、准备SQL语句
		String sql = "select proId from (select p.proId,p.proImg,p.proName,p.proBrand,p.proPrice,so.soCount,so.soId,o.orderId,o.userId from c_order o,c_sorder so,c_product p where so.orderId = o.orderId and so.proId=p.proId and o.orderId = ?) t ";
		
		// 3、预编译
		preparedStatement = connection.prepareStatement(sql);
		
		// 4、设置参数，下标从1开始
		preparedStatement.setInt(1, orderId);
		
		// 5、执行查询，返回结果集
		resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()){
			
			proId = resultSet.getInt("proId");
					
			String sql2 = "select proStock from c_product where proId = ?";
			
			String sql3 = "select soCount from c_sorder where proId = ?";
			
			preparedStatement2 = connection.prepareStatement(sql2);
			
			preparedStatement2.setInt(1, proId);
			
			resultSet2 = preparedStatement2.executeQuery();
			
			preparedStatement3 = connection.prepareStatement(sql3);
			
			preparedStatement3.setInt(1, proId);
			
			resultSet3 = preparedStatement3.executeQuery();
			
			if(resultSet2.next() && resultSet3.next()){
				
				proStock = resultSet2.getInt("proStock") - resultSet3.getInt("soCount");
				proId_proStock.put(proId, proStock);
			}			
		}
			
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		DBUtil.close(null, preparedStatement, resultSet);
		DBUtil.close(connection, preparedStatement, resultSet2);
	}
	if(proId_proStock.isEmpty()){
		proId_proStock.put(0, 0);
	}	
	return proId_proStock;
	}	
}
