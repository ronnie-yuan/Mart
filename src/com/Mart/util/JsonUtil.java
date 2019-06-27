package com.Mart.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/**
 * 将对象转换成JSON字符串，并响应给ajax的回调函数
 * @author Lisa Li
 *
 */
public class JsonUtil {

	public static void toJson(HttpServletResponse response, Object object) throws IOException {
		// 1、设置响应类型及编码
		response.setContentType("application/json;charset=UTF-8");
		// 2、得到输出流
		PrintWriter out = response.getWriter();
		// 将对象转换成json格式的字符串
		String json = JSON.toJSONString(object);
		// 将json字符串响应给ajax饿回调函数
		out.write(json);
		// 关闭资源
		out.close();
	}
}
