function showModal(sid){
	$("#myModal").modal('show');
	
	console.log("我进来了");
	var userId = $("#userId_"+sid).html();
	var userName = $("#userName_"+sid).html();
	var userPwd = $("#userPwd_"+sid).html();
	var userSex = $("input[type='radio']:checked").html();
	var userMail = $("#userMail_"+sid).html();
	var userMobile = $("#userMobile_"+sid).html();
	var userBalance = $("#userBalance_"+sid).html();
	var userStatus = $("#userStatus_"+sid).html();
	
	$("#userIdMo").attr("value",userId);
	$("#userNameMo").attr("value",userName);
	$("#userPwdMo").attr("value",userPwd);
	$("input[type='radio']:checked").val();
	$("#userMailMo").attr("value",userMail);
	$("#userMobileMo").attr("value",userMobile);
	$("#userBalanceMo").attr("value",userBalance);
	$("#userStatusMo").attr("value",userStatus);
	
	
}

function showProductModal(pid){
	$("#myProModal").modal('show');
	console.log("我进来了");
	var proId = $("#proId_"+pid).html();
	var proPrice = $("#proPrice_"+pid).html();
	var proStock = $("#proStock_"+pid).html();
	var proStatus = $("#proStatus_"+pid).html();
	
	// console.log(proStatus);
	
	$("#proIdMo").attr("value", proId);
	$("#proPriceMo").attr("value", proPrice);
	$("#proStockMo").attr("value", proStock);
	$("#proStatusMo").attr("value", proStatus);
	
	// console.log($("#proStatus").val());
	
}


/**
 * 确认框
 * @param id
 */
function comfirmDelete(id){
	console.log(id);
	var msg = confirm("确认删除?");
	var currentRow = $("#tr_"+id);
	console.log(currentRow, id);
	if (confirm(msg)==true){ 
		 deleteCurrentRow(currentRow, id);
		} else { 
		return; 
	} 
}
function comfirmProductDelete(productId){
	console.log(productId);
	var msg = confirm("确认删除?");
	var currentRow = $("#tr_"+productId);
	console.log(currentRow, productId);
	if (confirm(msg)==true){ 
		 deleteCurrentProductRow(currentRow, productId);
		}else{ 
		return; 
	} 
}
/**
 * 删除当前行
 * @param currentRow
 */
function deleteCurrentRow(currentRow, id){
	var userId = id;
	console.log(userId);
	
	$.ajax({
		type:"post",
		url:"martBackstageServlet",
		data:{
			actionName:"delete",
			userId:userId
		},
		dataType:"json", // 预期返回的数据的类型
		success:function(result){
			console.log(result);
			  // 判断是否删除成功
			  if (result.code == 1) {
				  // 删除成功
				  // 提示用户删除成功
				  swal(result.msg,"","success");
				  // 删除的DOM操作
				  currentRow.remove();
			  } else {
				// 提示用户删除失败
				  swal("删除失败！","","error");
			  }
		}
	});
}
/**
 * 删除商品行
 * @param currentRow
 * @param productId
 */
function deleteCurrentProductRow(currentRow, productId){
	var proId = productId;
	console.log(proId);
	
	$.ajax({
		type:"post",
		url:"martBackstageServlet",
		data:{
			actionName:"deleteCurrentProductRow",
			proId:proId
		},
		dataType:"json", // 预期返回的数据的类型
		success:function(result){
			console.log(result);
			  // 判断是否删除成功
			  if (result.code == 1) {
				  // 删除成功
				  // 提示用户删除成功
				  swal(result.msg,"","success");
				  // 删除的DOM操作
				  currentRow.remove();
			  } else {
				// 提示用户删除失败
				  swal("删除失败！","","error");
			  }
		}
	});
}

/**
 * 发送修改请求(用户)
 */
function sendModifyReq(){
	
	var userIds = $("#userIdMo").val();
	var userNames = $("#userNameMo").val();
	var userPwds = $("#userPwdMo").val();
	var userSexs = $("#userSexMo").val();
	var userMails = $("#userMailMo").val();
	var userMobiles = $("#userMobileMo").val();
	var userBalances = $("#userBalanceMo").val();
	var userStatuss = $("#userStatusMo").val();
	
	console.log(userIds);
	
	// 发送ajax请求
	$.ajax({
		type:"post",
		url:"martBackstageServlet",
		data:{
			actionName:"addOrUpdate",
			userId:userIds,
			userName:userNames,
			userPwd:userPwds,
			userSex:userSexs,
			userMail:userMails,
			userMobile:userMobiles,
			userBalance:userBalances,
			userStatus:userStatuss
		},
		dataType:"json", // 预期返回的数据的类型
		success:function(result){
			console.log(result);
			// 判断是否修改成功
			  if (result.code == 1) {
				  // 修改成功
				  			 
				  $("#userName_"+userIds).html(userNames);
				  
				
				  $("#userPwd_"+userIds).html(userPwds);
				  
				  
				  $("#userSex_"+userIds).html(userSexs);
				  
				 
				  $("#userMail_"+userIds).html(userMails);
				  
				 
				  $("#userMobile_"+userIds).html(userMobiles);
			
				  			 
				  $("userBalance_"+userIds).html(userBalances);
				  
				 
				  $("userStatus_"+userIds).html(userStatuss);
				  
				  // 提示用户修改成功
				  alert("修改成功");
				// 修改页面信息
			  } else {
				// 提示用户删除失败
				  alert("修改失败");
			  }
			  $("#myModal").modal('hide');
		}
	});
}
/**
 * 发送修改商品库存表请求
 */
function sendProductModifyReq(){
	var proIds = $("#proIdMo").val();
	var proPrices = $("#proPriceMo").val();
	var proStocks = $("#proStockMo").val();
	var proStatuss = $("#proStatusMo").val();
	
	console.log(proIds);
	console.log(proPrices);
	console.log(proStocks);
	console.log(proStatuss);
	
	// 发送ajax请求
	$.ajax({
		type:"post",
		url:"martBackstageServlet",
		data:{
			actionName:"addOrUpdateProductStock",
			proId:proIds,
			proPrice:proPrices,
			proStock:proStocks,
			proStatus:proStatuss
		},
		dataType:"json", // 预期返回的数据的类型
		success:function(result){
			console.log(result);
			// 判断是否修改成功
			  if (result.code == 1) {
				  // 修改成功
				 
				
				  $("#proPrice_"+proIds).html(proPrices);
				  
				
				  $("#proStock_"+proIds).html(proStocks);
				  
				
				  $("#proStatus"+proIds).html(proStatuss);
				  
				  // 提示用户修改成功
				  alert("修改成功");
				// 修改页面信息
			  } else {
				// 提示用户删除失败
				  alert("修改失败");
			  }  
			  $("#myProModal").modal('hide');
		}
	})
}