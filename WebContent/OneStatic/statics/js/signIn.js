/**
 *登录
 */
//判断姓名密码不为空
$("#button1").click(function(){
	//获取用户名和密码
	var uname=$("#username").val();
	var upwd=$("#password").val();
	//判断非空
	if(isEmpty(uname)){
		//为空,提示错误信息
		$("#msg").html("用户名不能为空!!");
		return;
	}
	if(isEmpty(upwd)){
		//为空,提示错误信息
		$("#msg").html("密码不能为空!!!");
		return;
	}
	//如果不为空清空提示信息
	
	$("#msg").html("");
	//提交表单
	$("#loginForm").submit();
	
})