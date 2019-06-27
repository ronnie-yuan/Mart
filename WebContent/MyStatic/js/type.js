/**
 * 删除类型
 * @param typeId
 */
function deleteType(typeId) {
	// 弹出提示框询问用户是否确认删除
	swal({ 
		  title: "你确定要删除这条记录吗？", 
		  text: "", 
		  type: "warning",
		  showCancelButton: true, 
		  confirmButtonColor: "orange",
		  confirmButtonText: "确定",
		  cancelButtonText: "取消"
	}).then(function(){
		  // 发送ajax请求，删除指定类型的记录
		  $.ajax({
			  type:"post",
			  url:"typeServlet",
			  data:{
				  actionName:"delete",
				  typeId:typeId
			  },
			  success:function(result) {
				  // 判断是否删除成功
				  if (result.code == 1) {
					  // 删除成功
					  // 提示用户删除成功
					  swal(result.msg,"","success");
					  // 删除的DOM操作
					  deleteDom(typeId);
				  } else {
					// 提示用户删除失败
					  swal("删除失败！","","error");
				  }
			  }
		  });
	});
}

/**
 * 删除类型的DOM操作
 * 
 * 	类型列表表格：
		1、得到table对象 （table设置id属性值）
		2、得到table对象的子元素tr
		3、判断tr的长度
			如果大于2（表头+多条类型记录），直接移除指定tr对象  （tr元素添加id属性值，id="tr_" + typeId）
			如果等于2，（表头+1条类型记录），移除整个table对象，并设置提示信息
	左侧类型列表分组：
		移除左侧对应的类型记录
			li对象绑定id属性值,id="li_"+typeId
 * 	
 * @param typeId
 */
function deleteDom(typeId) {
	
	// ================类型列表表格=================
	// 1、得到table对象
	var myTable = $("#myTable");
	// 2、得到table对象的子元素tr （得到table的子元素tbody，再得到子元素tr）
	var trs = myTable.children().children();
	// 3、判断tr的长度
	if (trs.length > 2) {
		// 如果大于2（表头+多条类型记录），直接移除指定tr对象  （tr元素添加id属性值，id="tr_" + typeId）
		$("#tr_" + typeId).remove();
	} else {
		// 如果等于2，（表头+1条类型记录），移除整个table对象，并设置提示信息 （给table的父元素div,绑定id属性值）
		myTable.remove();
		$("#myDiv").html("<h2>暂未查询到类型记录！</h2>");
	}
	
	
	// ===============左侧类型列表分组================
	$("#li_" + typeId).remove();
	
}


/**
 * 打开修改模态框
 * @param typeId
 */
function openUpdateDialog(typeId) {
	
	// 设置修改模态框的标题
	$("#myModalLabel").html("<span class='glyphicon glyphicon-pencil'></span> 修改类型");
	
	// 获取要修改的行记录
	var tr = $("#tr_" + typeId);
	// 得到指定单元格的文本值
	var tname = tr.children().eq(1).text();
	// 给模态框的文本框赋值
	$("#typeName").val(tname);
	// 给typeId的隐藏域赋值
	$("#typeId").val(typeId);
	
	// 打开模态框
	$("#myModal").modal("show");
	
}

/**
 * 通过id绑定按钮的点击事件，打开添加模态框
 */
$("#addBtn").click(function(){
	
	// 每次打开模态框时，清空模态框中的文本框和隐藏域的值
	$("#typeName").val("");
	$("#typeId").val("");
	
	// 清空提示信息
	$("#msg").html("");
	
	// 设置添加模态框的标题
	$("#myModalLabel").html("<span class='glyphicon glyphicon-plus'></span> 修改类型");
	
	// 打开模态框
	$("#myModal").modal("show");
});





/**
 * 获取模态框中的值，发送ajax请求
 */
function submitType() {
	
	// 获取文本框的值
	var typeName = $("#typeName").val();
	
	// 修改操作：隐藏域中色typeId （如果是添加操作，则为null；不需要单独判断typeId的值，若为null则为添加操作；不为空则为修改操作）
	var typeId =  $("#typeId").val();
	
	// 判断类型名称是否为空
	if (isEmpty(typeName)) {
		$("#msg").html("类型名称不可为空！");
		return;
	}
	
	// 发送ajax请求后台，验证类型名是否可用
	// 请求路径   请求参数   回调函数
	$.get("typeServlet", {actionName:"checkTypeName",typeName:typeName, typeId:typeId},function(result){
		// 判断是否可用
		if (result.code != 1) {
			// 提示用户不可用
			$("#msg").html(result.msg);
			return;
		} else {
			// 必须等待验证结果返回之后才能调用更新方法
			// 发送ajax请求后台，添加或修改类型
			$.ajax({
				type:"post",
				url:"typeServlet",
				data:{
					actionName:"addOrUpdate",
					typeName:typeName,
					typeId:typeId
				},
				success:function(result){
					// 判断是否更新成功
					if (result.code == 1) {
						// 成功
						// 关闭模态框
						$("#myModal").modal("hide");
						// 提示用户成功
						swal("更新成功","","success");
						// DOM操作
						// 如果typeId不为空，则为修改操作；为空则为添加操作
						if (isEmpty(typeId)) {
							// 添加的 DOM操作   
							addDom(result.result);
							
						}  else  {
							// 修改的DOM操作   
							updateDom(typeId,typeName);
						}
					} else {
						// 失败
						$("#msg").html(result.msg);
					}
				}
			});
			
			
		}
	});
	
	
	
}

/**
 * 修改类型的DOM操作
 * 	1、修改指定行的类型名称单元格的值
 * 	2、修改左侧类型名分组的类型名
 * @param typeId
 * @param typeName
 */
function updateDom (typeId,typeName) {
	// 1、修改指定行的类型名称单元格的值
	var tr = $("#tr_" + typeId);
	// 修改类型名称单元格的值
	tr.children().eq(1).text(typeName);
	
	
	// 2、修改左侧类型名分组的类型名 （需要给左侧的类型名加上span标签，并设置id属性值）
	$("#sp_"+typeId).html(typeName);
}


/**
 * 添加类型
 * 	表格：
 * 		1、表格存在，追加tr记录
 * 		2、表格不存在，创建表格，追加tr，将表格追加到div中
 *	左侧分组：
 *		1、追加li记录
 * @param noteType
 */
function addDom (noteType) {
	// ================表格=================
	// 拼接tr字符串
	var tr = '<tr id="tr_'+noteType.typeId+'">';
	tr += '<td>'+noteType.typeId+'</td><td>'+noteType.typeName+'</td>';
	tr += '<td><button class="btn btn-primary" type="button" onclick="openUpdateDialog('+noteType.typeId+')">修改</button>&nbsp;';
	tr += '<button class="btn btn-danger del" type="button" onclick="deleteType('+noteType.typeId+')">删除</button>';
	tr += '</td></tr>';
	
	// 得到table对象
	var myTable = $("#myTable");
	// 判断表格对象是否存在 （判断表格的length是否大于0）
	if (myTable.length > 0) {
		// 表格存在，则直接追加tr对象
		myTable.append(tr);
	} else {
		// 表格不存在，创建表格，追加tr，将表格追加到div中
		var table = '<table class="table table-hover table-striped " id="myTable">';
		table += '<tbody> <tr> <th>编号</th> <th>类型</th> <th>操作</th> </tr>';
		table += tr + '</tbody></table>';
		// 直接将表格赋值到div中 （覆盖默认的h2标签）
		$("#myDiv").html(table);
	}
	
	// ================左侧菜单分组=================
	// 创建li对象
	var li = '<li id="li_'+noteType.typeId+'"><a href=""><span id="sp_'+noteType.typeId+'">'+noteType.typeName+'</span> <span class="badge">0</span></a></li>';
	// 将li对象追加到指定ul中  （需要给类型分组的ul对象设置id属性值）
	$("#typeUl").prepend(li);
}


	
	
	
			
			





