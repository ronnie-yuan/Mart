//给姓名文本框绑定失焦,聚焦事件
$("#name").blur(function(){
	console.log("哈哈哈");
	//得到姓名并判断是否为空
	var uname=$("#name").val();
			
	if(isEmpty(uname)){
		$("#msg").html("用户名不得为空!!");
		//如果为空,禁用提交按钮
		$("#but").prop("disabled",true);
			return;
		}
		//发送ajax请求,判断姓名是否已经在数据库中!
	
	$.ajax({
		type:"post",
		url:"MartUserServlet",
		data:{
			actionName:"checkName",
			uname:uname
		},
		success:function(result){
			//成功返回一个code=1
		console.log("00000000");
			if(result.code==1){
				$("#msg").html(result.msg);
				// 禁用按钮
				$("#but").prop("disabled",true);
			}
		}
	});
}).focus(function(){
	// 1、清空提示信息
	$("#msg").html("");
	//	2、按钮可用
	$("#but").prop("disabled",false);
})

//给email文本框绑定失焦,聚焦事件
$("#email").blur(function(){
	//得到email并判断是否为空
	var uemail=$("#email").val();
			
	if(isEmpty(uemail)){
		$("#msg").html("email不得为空!!");
		//如果为空,禁用提交按钮
		$("#but").prop("disabled",true);
		return;
	}
	//发送ajax请求,判断email是否已经在数据库中!
	$.ajax({
		type:"post",
		url:"MartUserServlet",
		data:{
			actionName:"checkEmail",
			uemail:uemail
		},
		success:function(result){
			//成功返回一个code=1
			if(result.code==1){
				$("#msg").html(result.msg);
				// 禁用按钮
				$("#but").prop("disabled",true);
			}
		}
	});
}).focus(function(){
	// 1、清空提示信息
	$("#msg").html("");
	//	2、按钮可用
	$("#but").prop("disabled",false);
	 
})

/**
 * 用户注册
 */
$("#but").click(function(){
	//验证非空
	//得到用户数据
	//判断用户名是否为空
	var uname=$("#name").val();
	if(isEmpty(uname)){
		$("#msg").html("用户名不能为空!!!");
		return;
	}
	//判断email是否为空
	var email=$("#email").val();
	if(isEmpty(email)){
		$("#msg").html("email不能为空!!!");
		return;
	}
	//判断密码是否为空
	var upwd=$("#password").val();
	if(isEmpty(upwd)){
		$("#msg").html("密码不能为空!!!");
		return;
	}
	var reupwd=$("#re-password").val();
	console.log(reupwd);
	//判断重复输入的密码是否为空,并且验证是否一致
	if(isEmpty(reupwd)){
		console.log("===what fuck??===");
		$("#msg").html("密码验证行不能为空!!")
		return;
	}else if(upwd != reupwd){
		console.log("===what fuck you??===");
		$("#msg").html("密码不一致~!!")
		return;
	}
	
	var uphone=$("#phone").val();
	//判断电话是否为空
	if(isEmpty(uphone)){
		$("#msg").html("手机号不能为空!!")
		return;
	}
	//进行正则判断
	var zz=/0?(13|14|15|17|18|19)[0-9]{9}/;
	if(!zz.test(uphone)){
		$("#msg").html("请输入正确的手机号!!");
		return;
	}
	
	
	//如果不为空清空提示信息
	$("#msg").html("");
	//提交表单
	$("#loginform").submit();
})

/**
 * 找回密码
 */
//获取手机验证码的点击事件
$("#but1").click(function(){
	$("#msg").html("");
	//获取手机文本框中的值
	var uphone=$("#phone").val();
	//判断非空
	if(isEmpty(uphone)){
		//为空,返回错误信息
		$("#msg").html("手机不能为空!!");
		return;
	}
	
	//进行正则判断
	var zz=/0?(13|14|15|17|18|19)[0-9]{9}/;
	if(!zz.test(uphone)){
		$("#msg").html("请输入正确的手机号!!");
		return;
	}
	
	//如果不为空,清空提示信息
	$("#msg").html("");
	//发送ajax
	$.ajax({
		type:"post",
		url:"MartUserServlet",
		data:{
			actionName:"getCode",
			uphone:uphone
		},
		success:function(reslut){
			if(reslut==0){
				$("#msg").html("用户不存在!!!");
				return;
			}
			
			$("#msg").html("验证码已发送成功!!");
			console.log($("#hidden1").val());
			$("#hidden1").attr("value",reslut);
			console.log($("#hidden1").val());
			
		}
			
	})
})

//提交短信验证
$("#but2").click(function(){
	//获得短信框的值
	var umessage=$("#message").val();
	//判断非空
	if(isEmpty(umessage)){
		//为空,返回提示信息
		$("#msg").html("请输入你的验证短信!!!");
		return;
	}
	//如果不为空,清空提示信息
	$("#msg").html("");
	//获取隐藏域的值
	var message=$("#hidden1").val();
	//判断短信框的值是否与隐藏域中的验证信息相等
	if(umessage!=message){
		$("msg").html("验证码不正确,请重新输入!!");
		return;
	}else{
		//弹出模态框提示用户修改密码
		$('#myModal').modal('show');
	}
})


//关闭模态框按钮
$("#btn_submit1").click(function(){
	$('#myModal').modal('hide');
})


//提交模态框(提交修改)
$("#btn_submit").click(function(){
	//获取密码框和密码确认框的值
	var upwd1=$("#upwd1").val();
	var upwd2=$("#upwd2").val();
	console.log(upwd1);
	console.log(upwd2);
	//判断是否为空
	if(isEmpty(upwd1)||isEmpty(upwd2)){
		$("#msg2").html("密码框和密码确认框不得为空!!");
		return;
	}
	//判断密码是否一致
	if(upwd1!=upwd2){
		$("#msg2").html("密码不一致~~!");
		return;
	}
	//清空提示信息
	$("#msg").html("");
	
	//发送ajax
	$.ajax({
		type:"post",
		url:"MartUserServlet",
		data:{
			actionName:"StoragePwd",
			upwd1:upwd1,
		},
		success:function(result){
			//存取失败 返回result==0,
			if(result==0){
			$("#msg2").html("修改失败!!!!")	
			}
			
			//存取成功 返回result>0,
			console.log(result);
			//关闭模态框
			$('#myModal').modal('hide');
			//是否进入登录页面
			 alert("修改成功,是否进入登录页面?");
	        top.location='signIn.jsp';
		}
	})
})

