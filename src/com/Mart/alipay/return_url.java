package com.Mart.alipay;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Mart.Dao.MartIndexDao;
import com.Mart.po.Order;
import com.Mart.po.User;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;


/**
 * Servlet implementation class return_url
 */
@WebServlet("/return_url")
public class return_url extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MartIndexDao dao=new MartIndexDao();
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		response.setHeader("Content-Type","text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		
		boolean signVerified = false;
		try {
			signVerified=AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		} //调用SDK验证签名
		
		//——请在这里编写您的程序（以下代码仅作参考）——
		if(signVerified) {
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//付款金额
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
			
			
			//进行存储支付宝表中数据
			//查询当前订单号对应的订单id
			Order order=dao.cjOrder(out_trade_no);
			
			//获取当前登录状态的用户id
			User user=(User) request.getSession().getAttribute("user");
			Integer userId=user.getUserId();
			
			//进行pay支付宝表的添加
			int row=dao.insertPay(userId,order.getOrderId(),trade_no);
			
			//进行页面跳转至个人中心让用户查看是否
			response.sendRedirect("MartUserServlet?actionName=gouPersonalCenter");
			
			
		}else {
			out.write("验签失败");
		}
	}

}
