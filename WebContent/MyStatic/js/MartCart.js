//单击方法事件
function singleClick(id){
	
	$("#all").prop("checked",false);
	//获取当前对象的状态是否为选中
	var boolean=$("#p_"+id).prop("checked");
	//设定一个值作为单选的状态 0不选,1位全选
	var	checkedStatus=0;
	if(boolean){
		checkedStatus=1;
	}
	
	var va1=0;
	$("input[name=box]:checked").each(function(){
		va1++;
	});
	
	$("#spanProNum").html(va1);
	
	//发送ajax请求
	$.ajax({
		type:"post",
		url:"MartIndexServlet",
		data:{
			actionName:"singleClick",
			Status:checkedStatus,
			proId:id
		},
		success:function(result){
			$("#Totalprice").html("");
			if(result == null){
				$("#Totalprice").html("0");
				return;
			}
			
			$("#Totalprice").html(result);
			
			

			
		}
		
		
	})
}

