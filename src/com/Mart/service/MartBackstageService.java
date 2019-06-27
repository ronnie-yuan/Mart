package com.Mart.service;

import java.sql.ResultSet;
import java.util.List;

import com.Mart.Dao.MartBackstageDao;
import com.Mart.po.Order;
import com.Mart.po.Product;
import com.Mart.po.User;
import com.Mart.po.vo.ResultInfo;
import com.Mart.util.StringUtil;


/**
 * 后台Service层(业务逻辑层)
 * @author MSI-PC
 *
 */
public class MartBackstageService {
	
		MartBackstageDao martBackstageDao = new MartBackstageDao();
	/**
	 * 添加或修改用户
	 * @param userName
	 * @param userId
	 * @return
	 */
	public ResultInfo<User> addOrUpdateUser(User user) {
		
		ResultInfo<User> resultInfo = new ResultInfo<>();
		
		// 1. 判断用户Id是否存在, 不存在, 则执行添加操作
		if(user.getUserId() == null){
			// 判断是否为空
			if(StringUtil.isEmpty(user.getUserName())){
				resultInfo.setCode(0);
				resultInfo.setMsg("用户名不能为空");
				return resultInfo;
			}
			// 执行添加操作, 返回受影响的行数
			int row = martBackstageDao.insertUser(user);
			
			// 判断受影响的行数是否大于0
			if(row > 0){
				resultInfo.setCode(1);
			} else {
				resultInfo.setCode(0);
				resultInfo.setMsg("插入失败!");
			}
			return resultInfo;
		}
		// 2. 判断参数是否为空
		if(StringUtil.isEmpty(user.getUserName()) || user.getUserId() < 1){
			resultInfo.setCode(0);
			resultInfo.setMsg("参数不能为空, 请重试!");
			return resultInfo;
		}
		
		// 3. 调用Dao层, 判断用户名和用户ID是否一致, 不一致则修改失败
		if(!martBackstageDao.checkIdByUserName(user.getUserName(), user.getUserId())){
			resultInfo.setCode(0);
			resultInfo.setMsg("用户名与查询到的参数不一致!");
			return resultInfo;
		}
		
		// 4. 执行更新操作, 返回受影响的行数
		int row = martBackstageDao.updateInfo(user);
		
		// 5. 判断受影响的行数是否大于0
		if(row > 0){
			resultInfo.setCode(1);
		} else {
			resultInfo.setCode(0);
			resultInfo.setMsg("更新失败");
		}
		
		return resultInfo;
	}
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public ResultInfo<User> deleteUser(Integer userId) {
		
		ResultInfo<User> resultInfo = new ResultInfo<>();
		
		// 1、判断参数是否为空
				if (StringUtil.isEmpty(userId + "")) {
					resultInfo.setCode(0);
					resultInfo.setMsg("删除失败，请重试！");
					return resultInfo;
				}
		// 2. 调用Dao层, 通过userId查询是否存在用户记录, 如不存在则删除失败
				if(martBackstageDao.findUserById(userId) == null){
					resultInfo.setCode(0);
					resultInfo.setMsg(" 不存在该用户, 无法删除");
					return resultInfo;
				}
		
		// 3. 如果存在该用户, 则删除该用户记录, 返回受影响的行数
				int row = martBackstageDao.deleteUserById(userId);
				
	   // 4. 判断受影响的行数, 若大于则成功
				if(row > 0){
					resultInfo.setCode(1);
				} else {
					resultInfo.setCode(0);
					resultInfo.setMsg("数据库删除失败");
				}
		return resultInfo;
	}
	/**
	 * 查询所有用户
	 * 查询类型集合
	 *  1、调用Dao层的查询方法，通过当前用户ID查询用户列表，返回用户列表List<User>
		2、判断类型列表是否为空
			如果为空，code=0，mag=xxx，返回resultInfo对象
			如果不为空，code=1，将集合设置到reusultInfo对象，返回resultInfo对象
	 * @param userId
	 * @return
	 */
	public ResultInfo<List<User>> searchUser(Integer userId) {
		// 1、调用Dao层的查询方法，通过当前用户ID查询用户列表，返回用户列表List<User>
		List<User> list =  martBackstageDao.findAllUser();
		ResultInfo<List<User>> resultInfo = new ResultInfo<>();
		// 2、判断类型列表是否为空
		if (list == null || list.size() < 1) {
			// 如果为空，code=0，mag=xxx，返回resultInfo对象
			resultInfo.setCode(0);
			resultInfo.setMsg("暂未查询到类型数据！");
		} else {
			// 如果不为空，code=1，将集合设置到reusultInfo对象，返回resultInfo对象
			resultInfo.setCode(1);
			resultInfo.setResult(list);
		}
		return resultInfo;
		
	}
	/**
	 * 查询所有商品及其库存
	 * 查询类型集合
	 *  1、调用Dao层的查询方法，通过当前用户ID查询用户列表，返回用户列表List<User>
		2、判断类型列表是否为空
			如果为空，code=0，mag=xxx，返回resultInfo对象
			如果不为空，code=1，将集合设置到reusultInfo对象，返回resultInfo对象
	 * @param proId
	 * @return
	 */
	public ResultInfo<List<Product>> searchAllProductAndStock() {
		// 1、调用Dao层的查询方法，通过当前用户ID查询用户列表，返回用户列表List<User>
				List<Product> list =  martBackstageDao.searchAllProductAndStock();
				ResultInfo<List<Product>> resultInfo = new ResultInfo<>();
				// 2、判断类型列表是否为空
				if (list == null || list.size() < 1) {
					// 如果为空，code=0，mag=xxx，返回resultInfo对象
					resultInfo.setCode(0);
					resultInfo.setMsg("暂未查询到类型数据！");
					return resultInfo;
				} else {
					// 如果不为空，code=1，将集合设置到reusultInfo对象，返回resultInfo对象
					resultInfo.setCode(1);
					resultInfo.setResult(list);
				}
				return resultInfo;
	}
	/**
	 * 修改商品类或插入新商品类
	 * @param product
	 * @return
	 */
	public ResultInfo<Product> addOrUpdateProductStock(Product product) {
		
		ResultInfo<Product> resultInfo = new ResultInfo<>();
		
		// 1. 判断商品Id是否存在, 不存在, 则执行添加操作
				if(product.getProId() == null){
	
					// 执行添加操作, 返回受影响的行数
					int row = martBackstageDao.insertProduct(product);
					
					// 判断受影响的行数是否大于0
					if(row > 0){
						resultInfo.setCode(1);
					} else {
						resultInfo.setCode(0);
						resultInfo.setMsg("插入商品失败!");
						return resultInfo;
					}
					return resultInfo;
				}
		// 2. 如果商品ID存在, 但商品名不存在, 执行修改价格, 库存, 状态操作
				if(product.getProId() != null && product.getProName() == null){
					// 执行修改价格, 库存, 状态操作方法, 返回受影响的行数
					int row = martBackstageDao.updatePriceStockStatus(product.getProId(), product.getProPrice(), product.getProStock(), product.getProStatus());
					
					// 判断返回的行数
					if(row > 0){
						resultInfo.setCode(1);
					} else {
						resultInfo.setCode(0);
						resultInfo.setMsg("修改商品失败!");
						return resultInfo;
					}
					return resultInfo;
				}
				
			// 3. 如果商品ID存在且商品名存在, 修改所有当前商品的信息
				if(product.getProId() != null && product.getProName() != null){
					// 执行修改所有当前商品的信息
					int row = martBackstageDao.updateAllProductProperties(product);

					// 判断返回的行数
					if(row > 0){
						resultInfo.setCode(1);
					} else {
						resultInfo.setCode(0);
						resultInfo.setMsg("修改商品失败!");
						return resultInfo;
					}
					return resultInfo;
				}
		
			return resultInfo;
	}
	/**
	 * 查找所有订单
	 * @return
	 */
	public ResultInfo<List<Order>> searchUserOrders() {
		
		// 调用Dao层方法查询获得订单类集合
		List<Order> list =  martBackstageDao.searchAllUserOrders();
		ResultInfo<List<Order>> resultInfo = new ResultInfo<>();
		if (list == null || list.size() < 1) {
			// 如果为空，code=0，mag=xxx，返回resultInfo对象
			resultInfo.setCode(0);
			resultInfo.setMsg("暂未查询到类型数据！");
			return resultInfo;
		} else {
			// 如果不为空，code=1，将集合设置到reusultInfo对象，返回resultInfo对象
			resultInfo.setCode(1);
			resultInfo.setResult(list);
		}
		return resultInfo;
	}	
}
