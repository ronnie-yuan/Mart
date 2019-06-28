//商品分类页面商品添加到购物车操作
function addCart(id){
	console.log("我来买东西了");
	$.ajax({
		type:"post",
		url:"MartIndexServlet",
		data:{
			actionName:"addCart",
			proId:id
			
		},
		success:function(result){
			if(result>0){
				alert("添加购物车成功");
			}
			
		}
	});
}

//商品分类页面
function addWishlist(id){
	console.log("添加心眼单");
	$.ajax({
		type:"post",
		url:"MartIndexServlet",
		data:{
			actionName:"addWishlist",
			proId:id
			
		},
		success:function(result){
			if(result>0){
				alert("添加心愿单成功");
			}
			
		}
	});
}