package com.Mart.alipay;

import java.io.FileWriter;
import java.io.IOException;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092800619225";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCJ5N+ybEyzQ//SjQ4CvJGzg5Ag2YhE7DI3e3/Z1EvL0dV4V44o2Y4N+hZ/JQzGZItZcGxGx54CL0XOx2VfjdwBfv+azsTRjt0touKio6ohNqKjgGq3lKNLGBTv1HoS9jRYFVrWmGc1dfiBKXSRbR6WAb5Vm7viPRA/Hfy9NgElUy8eR9WVOwUNOqQmnzN8jNugew0htqftGOIWsREqRPvfQjfxrhvWLSGDnhBX3xBUGh6tDUafkcSzhHpqmdaaTO51nMgzBkvqQ8yHYT/AqDpCu8QiPTPpfTYKCEpJCFYyx+ILLvr8S9i69qArSh/GPat+0M7kK+OgC3REi3p/IoZNAgMBAAECggEAW7dValFKOrnxv9N+DCfsKSBKju7hCianx+tmwDXKLEjm2WIy9cyuBXHf4LV9578cSGLUQcenuwBCSCSrsoCiYoRb8lWw50lEp4P9hfuhvvGd/238jRpZ+iqMUnBauZ30dtnNT4qSqyZKIW63T7rqaw/BzyMENpgy5ChH4Hm5DV9pHdTLFJnGznyZ/5sJDLsI3RRRKQBsWuA9Vg65W0qsnYN+6Qq+lvie6HHVUogIfAIlvQNTntM8QplMHS5Y+nxhdqt6WRW9lavZxNhQbGYwoWnvXxGf09oilc6oEwBvDazo2ECVvjZTLaJVBq6U7OajlMzRDBAPGeVb9PmL5e2tKQKBgQDSc4sq/Ih5nGvLfJ+GbDU6/lrYkGPRNOpN0cUI2ULc4Hyb7hHYBhPEc7eejO0FN1h7NTrkUmXM0Mcx7684WHTeNStMTQg/3OoLDkXZjxcKH9iS+gfMGOGiXsF8aHMuOhFOHq/F5ANszeeU2oHS0gDdlKEag3BFVqZsJxJkCEvW4wKBgQCnvSeqV3TG5XuNzois45carvH+87iApnc8zuNSDnrVVgrrQovntzPc37Dljq52uiuKUD5xFqqI6Yfz9FeMRPvgc6xKDr/0bEua91m9D7xQB0sRP+HgM2bn8hKzUm6MHZ5m4i/7XwoODcAPvN6kuMhjhkYs3HrzZaoEBo9RRE+FDwKBgQCcSqD9IKS+JBPOAFR8wRnbIREYqkrnELQ9bN82jhtg6/q+1tQ7qW++wu2H+0L/T7YPcl21ORhPPnHgvQ9U+iR47eWk+cR5oTfTVBs90k2bAEGYDcYCpivTqSlqmiuIFinJ6XJCte5xPI2S95/YkIuCA6KNjTWw2QQpZ+75iUvBXwKBgDnE+KM/CZXytRHKvuGkZIcpF2kyMSoFqu1DZ6D8IavVvV73BU4hl3gLhlYZRNbZGWPCbS7vmn4ax9rqHTjPDVxpGj5LRCr/HS7a34owoC+Dw4PGV5mquldJ1Mzzp+UT0lkmr1XIjqL2c144MwnSJhm4xfRvXtzy95H5XGSlvSlbAoGBALnoNiP3jWAezPyMMmsaOZSEDLI9KJBcOYZv6MlMiJ1VKJl6g8tsgQGhQDbjlPTnMWb2HoktZW41cqaZREmIlaYtrbbn1xEZrRpjRBWknzPxTq6OxPDaTa5jksX33XjEL4KR2GQj61UMxvRFzboq1YWJfiB04j4jueAJWd8YKbuF";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhDzOnKZEUTuWBnx9dCVfJo7ET7VMDDynzz6gD8VmIkcT2R5AJifEXeUCmkoOeb3SgZ7MuKCZtu5oUpWXpe3ykAjtuBnYdiLEnMyCuX4n59yIa50ohEQ1XR+Z7VtzsXWh/Kb/9RxbOq89t13vkD7Qsn7dhKQMz0ZNdM6teIxQeLaLhQiky0iHAyr9UC3QJvxpFsW7yl03EVZ/p3LnEVLR0v723QHNwx5mUdKf40BH/D5k/n3h0rasnwFNTveit5aLVP3GFdEy9hHLeCK8+uZnW676gETDApFEV55NppgQvqaY7QyrNZWzYcsZz/cJokJE3Rla9uDrVD6PMWMpbQ+z+wIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/Mart/return_url";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";
	AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl,app_id,merchant_private_key,"json","utf-8",alipay_public_key,"RSA2");


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

