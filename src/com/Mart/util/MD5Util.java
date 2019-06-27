package com.Mart.util;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * 字符串加密
 * @author Lisa Li
 *
 */
public class MD5Util {

	public static String encode(String str) {
		try {
			// 得到MD5加密的算法程序
			MessageDigest messageDigest = MessageDigest.getInstance("md5");
			// 通过md5算法加密
			byte[] bytes = messageDigest.digest(str.getBytes());
			// 通过Base64编码
			String value = Base64.encodeBase64String(bytes);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static void main(String[] args) {
		System.out.println(MD5Util.encode(MD5Util.encode("123456")));
	}
}
