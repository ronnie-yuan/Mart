/**
 * 个人中心
 * 修改个人信息
 */
//获取个人信息中各文本框的值,并提交
$("#but001").click(function(){
	//由于用户名,手机,账户余额,状态文本框的值被锁定不可修改,所以不需要进行对它拿值
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
	//清空提示信息
	$("#msg3").html("");
	
	//发送ajax请求
	$.ajax({
		type:"post",
		url:"MartUserServlet",
		data:{
			actionName:"updateUserAccount",
			usex:usex,
			uemail:uemail
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


//查看订单














