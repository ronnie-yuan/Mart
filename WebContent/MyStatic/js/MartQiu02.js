/**
 * 个人中心
 * 修改个人信息
 */
//获取个人信息中各文本框的值,并提交
$("#but001").click(function(){
	//由于用户名,账户余额,状态文本框的值被锁定不可修改,所以不需要进行对它拿值
	//获取性别文本框信息,并判断是否为空
	var usex=$("#usex").val();
	if(isEmpty(usex)){
		$("#msg3").html("性别不能为空!!!");
		return;
	}
	//获取邮箱文本框信息,并判断是否为空
	var uemail=$("#uemail").val();
	console.log(uemail);
	if(isEmpty(uemail)){
		$("#msg3").html("邮箱不能为空!!!");
		return;
	}
	//获取手机文本框信息,并判断是否为空
	var uphone=$("#uphone").val();
	
	if(isEmpty(uphone)){
		//为空,返回错误信息
		$("#msg3").html("手机不能为空!!");
		return;
	}
	//进行正则判断
	var zz=/0?(13|14|15|17|18|19)[0-9]{9}/;
	if(!zz.test(uphone)){
		$("#msg3").html("请输入正确的手机号!!");
		return;
	}
	//清空提示信息
	$("#msg3").html("");
	
	//发送ajax请求
	$.ajax({
		type:"post",
		url:"MartUserServlet",
		data:{
			actionName:"updateUserAccount",
			usex:usex,
			uemail:uemail,
			uphone:uphone
		},
		success:function(result){
				//接收后台发送来的数据
				if(result!=0){
					//修改成功,显示提示信息
					$("#msg3").html("信息已更新成功!!!");
					return;
				}
				//未修改成功
				$("#msg3").html("信息未更新成功,请重试!!!");
			}
		})
	
})
/**
 * 个人中心
 * 用户余额充值
 */
$("#but0001").click(function(){
	
})

/**
 * 个人中心
 * 旧密码框绑定失焦事件,判断密码是否正确
 */
$("#password03").blur(function(){
	//获取值
	var password03=$("#password03").val();
	//判断旧密码框不可为空
	if(isEmpty(password03)){
		$("#msg4").html("旧密码不能为空!!!");
		//如果为空,禁用提交按钮
		$("#but002").prop("disabled",true);
			return;
	}
	//清空提示信息
	$("#msg4").html("");
	//发送ajax
	$.ajax({
		type:"post",
		url:"MartUserServlet",
		data:{
			actionName:"checkPwd",
			password03:password03
		},
		success:function(result){
			console.log(result);
			//对得到的后台数据进行操作
			if (result.code != 1) {//wei查询到密码
				$("#msg4").html(result.msg);
				// 禁用按钮
				 $("#but002").prop("disabled",true);
				 return;
			}
			//查询到密码
			$("#msg4").html(result.msg);
		}
		
	})
}).focus(function(){
	 // 1、清空提示信息
	 $("#msg4").html("");
	 //	2、按钮可用
	 $("#but002").prop("disabled",false);
		
});
/**
 * 个人中心
 * 修改个人密码
 */
$("#but002").click(function(){
	//获取密码框中的值
	var password01=$("#password01").val();
	//判断非空
	if(isEmpty(password01)){
		$("#msg4").html("密码不能为空!!!");
		return;
	}
	//获取确认密码框中的值
	var password02=$("#password02").val();
	//判断非空
	if(isEmpty(password02)){
		$("#msg4").html("确认密码不能为空!!!");
		return;
	}
	//并且判断确认框和密码框的值是否相等
	if(password01!=password02){
		$("#msg4").html("密码不一致!!!");
	}
	//清空提示信息
	$("#msg4").html("");
	
	//发送ajax请求
	$.ajax({
		type:"post",
		url:"MartUserServlet",
		data:{
			actionName:"updateUserPwd",
			password01:password01
		},
		success:function(result){
			//接收后台返回的数据
			if(result!=0){
				//修改成功,显示提示信息
				$("#msg4").html("密码修改成功!!!");
				return;
			}
			//未修改成功
			$("#msg4").html("密码修改失败,请重试!!!");
		}
		
	})
})


	//删除订单信息

	function deleteOrder(orderId){
	
	var res = confirm("确定删除当前订单么?");
	if(res==false){
		return;
	}
		
	//发送ajax
	$.ajax({
		type:"post",
		url:"MartUserServlet",
		data:{
			actionName:"deleteUserOrder",
			orderId:orderId,
		},
		success:function(result){
			if(result>0){
				//修改成功删除订单
				$("#tr_"+orderId).remove()
			}
		}
	})
	
		
	}
/**
 * 个人中心
 * 查看订单详情
 */
function openMoTai(orderId){

	//弹出模态框,展示订单信息
	$("#wodemotaikuang_"+orderId).modal("show");
	
}

/**
 * 个人中心
 * 退款
 */
function tuiKuang(orderId){
	var res = confirm("确定要对当前订单进行退款么?");
	
	if(res == true){
		window.location.href="退款接口rul";
	}

}


/**
 * 手机注册
 * 获取手机验证码
 */

$("#but0003").click(function(){
	//获取手机文本框的值
	var uphone=$("#mobilephone").val();
	
	//判断非空
	if(isEmpty(uphone)){
		$("#msg6").html("手机不能为空!!");
		return;
	}
	//进行正则判断
	var zz=/0?(13|14|15|17|18|19)[0-9]{9}/;
	if(!zz.test(uphone)){
		$("#msg6").html("请输入正确的手机号!!");
		return;
	}
	//如果不为空,清空提示信息
	$("#msg6").html("");
	
	//发送ajax
	$.ajax({
		type:"post",
		url:"MartUserServlet",
		data:{
			actionName:"getCode1",
			uphone:uphone
		},
		success:function(result){
			console.log(result);
			if(result==null){
				//短信验证失败
				$("#msg6").html("获取验证码失败,请重新发送!!");
				return;
			}
			//成功,提示
			$("#msg6").html("短信验证码已发送~~");
			var value1=$("#hidden3").val();
			console.log(value1);
			$("#hidden3").attr("value",result);
			var value1=$("#hidden3").val();
			console.log(value1);
		}
	})	
})

/**
 * 手机注册
 * 验证短信是否正确,并提交注册
 */

$("#but0002").click(function(){
	//获取短信框的值
	var message=$("#message").val();
	console.log(message);
	var value1=$("#hidden3").val();
	console.log(value1);
	//判断是否和隐藏域中的值相等
	if(message!=value1){
		$("#msg6").html("请输入正确的短信验证码!!!!!");
		return;
	}
	//清空提示信息
	$("#msg6").html("");
	//提交表单
	$("#loginForm4").submit();
	

})
