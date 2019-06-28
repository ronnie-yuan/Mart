<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Cart</title>
    <meta name="robots" content="noindex, follow" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicon -->
    
	
    <!-- CSS
	============================================ -->

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href=" OneStatic/assets/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href=" OneStatic/assets/css/plugins/plugins.css">

    <!-- Vendor & Plugins CSS (Please remove the comment from below vendor.min.css & plugins.min.css for better website load performance and remove css files from avobe) -->
    <!--
    <script src=" OneStatic/assets/js/vendor/vendor.min.js"></script>
    <script src=" OneStatic/assets/js/plugins/plugins.min.js"></script>
    -->

    <!-- Main Style CSS (Please use minify version for better website load performance) -->
    <link rel="stylesheet" href=" OneStatic/assets/css/style.css">
    <!--<link rel="stylesheet" href=" OneStatic/assets/css/style.min.css">-->

</head>

<body>

    <!-- Start Breadumb Area -->
    <div class="breadcumb-area ptb--100 ptb_md--100 ptb_sm--100  bg_image bg_image--3">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="inner text-center">
                        <h2 class="font--40 mb--0">Mart购物车</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Breadumb Area -->
    <div class="main-wrapper">

        <!-- Cart Page Start -->
         <form method="post" action="MartIndexServlet" >
        <div class="cart_area pt--120 pb--80 bg-color pt_md--80 pt_sm--80" data-bg-color="#ffffff">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                       
                        	<input type="hidden" name="actionName" value="insertOrder">
                            <!-- Cart Table -->
                            <div class="cart-table table-responsive mb--40">
                                <table class="table">
                                    <thead>
                                        <tr>
                                        	<th class="pro-thumbnail"><input type="checkbox" id="all" value="全选" /></th>
                                            <th class="pro-thumbnail">图片</th>
                                            <th class="pro-title">产品</th>
                                            <th class="pro-price">价格</th>
                                            <th class="pro-quantity">数量</th>
                                            <th class="pro-subtotal">总计</th>
                                            <th class="pro-remove">操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        
                                        <!-- 你好 -->
                                      	<c:if test="${empty resultInfo.result }">
                                      		<div><h2>暂未查询到购物车信息，请添加商品</h2></div>
                                      	</c:if>
                                      	<c:forEach items="${resultInfo.result }" var="list">
                                      		<!-- 商品tr头 -->
                                      		<tr id="tr_${list.proId }">
                                      		
                                      			<!-- 商品选择框 -->
                                      			<td><input type="checkbox" name="box" <c:if test="${list.cchecked == 1 }">checked="checked"</c:if>  value="${list.proPrice}" id="p_${list.proId}" onclick="singleClick(${list.proId})"  /></td>
	                                            <td class="pro-thumbnail"><a href="#"><img src="${list.proImg}" alt="Product"></a></td>
	                                            <td class="pro-title"><a href="#">${list.proName}</a></td>
	                                            <td class="pro-price"><span>￥${list.proPrice}</span>
	                                            	<!-- 商品价钱隐藏域 -->
	                                            	<input type="hidden" id="hidden_${list.proId}" value="${list.proPrice}" />
	                                            </td> 
	                                            <td class="pro-quantity">

	                                             	 <input type="button"  id="minus${list.proId}" value="-" onclick="minusPro(${list.proId})" />
                                                	<span id="m_${list.proId}" >${list.ccount}</span>
                                                	<input type="button" id="add" value="+" onclick="addPro(${list.proId})"/>
                                                	<!-- 商品数量隐藏域 -->
                                                	<input type="hidden" id="num_${list.proId}" value="${list.ccount}"/>
	                                            </td>
	                                            <td class="pro-subtotal"><span id="total_${list.proId}">￥${list.proPrice*list.ccount}</span></td>
	                                            <td class="pro-remove" id="delete_${list.proId}">
	                                            	<button class="btn btn-danger" type="button" onclick="deletePro(${list.proId})">删除</button>
	                 							
	                                            </td>
                                        	</tr>
                                      	</c:forEach>
                                        
                                    </tbody>
                                </table>
                            </div>
                        

                        <div class="row" >

                            <!-- Cart Summary -->
                            <div class="col-lg-6 col-12 mb--40 d-flex">
                                <div class="cart-summary">
                                    <div class="cart-summary-wrap">
                                    
                                        <h4>已选择<span id="spanProNum">0</span>件商品</h4>
                                        <h2>Grand Total ：￥<span id="Totalprice">0</span></h2>
                                        
                                    </div>
                                    <div class="cart-summary-button">
                                        <button type="button" class="checkout-btn"  onclick="cartCheckout()">结算</button>
                                        <button type="button" class="update-btn">Update Cart</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </form>
        <!-- Cart Page End -->
    </div>
    

    <!-- Quick View Modal -->
    <div class="quick-view-modal">
        <div class="quick-view-modal-inner">
            <div class="container">
                <div class="product-details">
                    <!-- Product Details Left -->
                    <div class="product-details-left">
                        <div class="product-details-images slider-navigation-2">
                            <a href="#">
                                <img class="w-100" src=" OneStatic/assets/images/product/product-01.jpg" alt="product image">
                            </a>
                            <a href="#">
                                <img class="w-100" src=" OneStatic/assets/images/product/product-02.jpg" alt="product image">
                            </a>
                            <a href="#">
                                <img class="w-100" src=" OneStatic/assets/images/product/product-03.jpg" alt="product image">
                            </a>
                            <a href="#">
                                <img class="w-100" src=" OneStatic/assets/images/product/product-04.jpg" alt="product image">
                            </a>
                            <a href="#">
                                <img class="w-100" src=" OneStatic/assets/images/product/product-05.jpg" alt="product image">
                            </a>
                        </div>
                        <div class="product-details-thumbs slider-navigation-2">
                            <img src=" OneStatic/assets/images/product/product-01.jpg" alt="product image thumb">
                            <img src=" OneStatic/assets/images/product/product-02.jpg" alt="product image thumb">
                            <img src=" OneStatic/assets/images/product/product-03.jpg" alt="product image thumb">
                            <img src=" OneStatic/assets/images/product/product-04.jpg" alt="product image thumb">
                            <img src=" OneStatic/assets/images/product/product-05.jpg" alt="product image thumb">
                        </div>
                    </div>
                    <!--// Product Details Left -->

                    <!-- Product Details Right -->
                    <div class="product-details-right">
                        <h5 class="product-title">Demo Product Name</h5>

                        <div class="ratting-stock-availbility">
                            <div class="ratting-box">
                                <span><i class="fa fa-star"></i></span>
                                <span><i class="fa fa-star"></i></span>
                                <span><i class="fa fa-star"></i></span>
                                <span><i class="fa fa-star"></i></span>
                                <span><i class="fa fa-star"></i></span>
                            </div>
                            <span class="stock-available">In stock</span>
                        </div>

                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam fringilla augue nec est
                            tristique auctor. Donec non est at libero vulputate rutrum. Morbi ornare lectus quis
                            justo gravida semper. Nulla tellus mi, vulputate adipiscing cursus eu, suscipit id
                            nulla. adipiscing cursus eu, suscipit id nulla.</p>

                        <div class="price-box">
                            <span class="pricebox-price">￥80.00</span>
                        </div>

                        <div class="product-details-quantity">
                            <div class="quantity-select">
                                <div class="pro-quantity">
                                    <div class="pro-qty"><input type="text" value="1"></div>
                                </div>
                            </div>
                            <a href="#" class="add-to-cart-button">
                                <span>ADD TO CAR</span>
                            </a>
                        </div>

                        <div class="product-details-color">
                            <span>Color :</span>
                            <ul>
                                <li class="red"><span></span></li>
                                <li class="green checked"><span></span></li>
                                <li class="blue"><span></span></li>
                                <li class="black"><span></span></li>
                            </ul>
                        </div>

                        <div class="product-details-size">
                            <span>Size :</span>
                            <ul>
                                <li class="checked"><span>S</span></li>
                                <li><span>M</span></li>
                                <li><span>L</span></li>
                                <li><span>XL</span></li>
                                <li><span>XXL</span></li>
                            </ul>
                        </div>

                        <div class="product-details-categories">
                            <span>Categories :</span>
                            <ul>
                                <li><a href="shop.jsp">Accessories</a></li>
                                <li><a href="shop.jsp">Kids</a></li>
                                <li><a href="shop.jsp">Women</a></li>
                            </ul>
                        </div>

                        <div class="product-details-tags">
                            <span>Tags :</span>
                            <ul>
                                <li><a href="shop.jsp">Electronic</a></li>
                                <li><a href="shop.jsp">Television</a></li>
                            </ul>
                        </div>

                        <div class="product-details-socialshare">
                            <span>Share :</span>
                            <ul>
                                <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a class="google-plus" href="#"><i class="fa fa-google-plus"></i></a></li>
                                <li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
                                <li><a class="instagram" href="#"><i class="fa fa-instagram"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <!--// Product Details Right -->

                </div>
            </div>
        </div>
        <button class="close-quickview-modal"><i class="fa fa-close"></i></button>
    </div>
    <!--// Quick View Modal -->
    <!-- Start Footer Area -->
    <footer class="footer-area bg-color plr--100 plr_lg--40 plr_md--30 plr_sm--30 clearfix" data-bg-color="#f4f8fa">
        <!-- Start Footer Top -->
        <div class="footer-top ptb--80">
            <div class="row">
                <div class="col-custom--5">
                    <div class="footer-widget">
                        <div class="logo">
                            <a href="index.jsp">
                                <img src=" OneStatic/assets/images/logo/logo-black.png" alt="Logo">
                            </a>
                        </div>
                        <div class="inner">
                            <p>On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms. </p>
                        </div>
                    </div>
                </div>
                <div class="col-custom--5 mt_mobile--40">
                    <div class="footer-widget">
                        <h5 class="title">Company</h5>
                        <div class="inner">
                            <ul class="ft-link">
                                <li><a href="#">About US</a></li>
                                <li><a href="#">Blogs</a></li>
                                <li><a href="#">Careers</a></li>
                                <li><a href="#">Contact</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-custom--5 mt_md--40 mt_sm--40">
                    <div class="footer-widget">
                        <h5 class="title">Product</h5>
                        <div class="inner">
                            <ul class="ft-link">
                                <li><a href="#">Pricing</a></li>
                                <li><a href="#">Features</a></li>
                                <li><a href="#">Customers</a></li>
                                <li><a href="#">Demos</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-custom--5 mt_md--40 mt_sm--40">
                    <div class="footer-widget">
                        <h5 class="title">Helps</h5>
                        <div class="inner">
                            <ul class="ft-link">
                                <li><a href="#">Introduction</a></li>
                                <li><a href="#">Feedback</a></li>
                                <li><a href="#">Referrals</a></li>
                                <li><a href="#">Network Status</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-custom--5 mt_md--40 mt_sm--40">
                    <div class="footer-widget">
                        <h5 class="title">Social Netowrk</h5>
                        <div class="inner">
                            <ul class="ft-link">
                                <li><a href="#">Facebook</a></li>
                                <li><a href="#">Twitter</a></li>
                                <li><a href="#">Linkedin</a></li>
                                <li><a href="#">Google +</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Footer Top -->
        <!-- Start Footer Middle -->
        <div class="footer-middle">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="footer-middle-inner ptb--45 text-center">
                            <div class="tags-list">
                                <span>Tags :</span>
                                <div class="tags">
                                    <a href="#">Minimal eCommerce</a>
                                    <a href="#">Marketing</a>
                                    <a href="#">User Exprience</a>
                                    <a href="#">Ali Express</a>
                                    <a href="#">Web</a>
                                    <a href="#">Digital Expo</a>
                                    <a href="#">Web Search</a>
                                    <a href="#">Affiliate</a>
                                    <a href="#">UCWeb</a>
                                    <a href="#">Support</a>
                                    <a href="#">Theme</a>
                                    <a href="#">Best Queality</a>
                                    <a href="#">Mobile</a>
                                    <a href="#">24 Support</a>
                                    <a href="#">Ali Express</a>
                                    <a href="#">Web</a>
                                    <a href="#">Laptop</a>
                                    <a href="#">Web Search</a>
                                    <a href="#">Affiliate</a>
                                    <a href="#">Photoshop</a>
                                    <a href="#">Support</a>
                                    <a href="#">Theme</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Footer Middle -->
        <!-- Start Copyright -->
        <div class="copyright-area">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="copyright-inner ptb--25 text-center">
                            <p class="mb--0">Copyright &copy; 2019.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Copyright -->
    </footer>
    <!-- End Footer Area -->




    <!-- JS
============================================ -->

    <!-- Modernizer JS -->
    <script src=" OneStatic/assets/js/vendor/modernizr.min.js"></script>
    <!-- jQuery JS -->
    <script src=" OneStatic/assets/js/vendor/jquery.js"></script>
    <!-- Bootstrap JS -->
    <script src=" OneStatic/assets/js/vendor/bootstrap.min.js"></script>
    <script src=" OneStatic/assets/js/plugins/plugins.js"></script>
    <!-- Vendor & Plugins JS (Please remove the comment from below vendor.min.js & plugins.min.js for better website load performance and remove js files from avobe) -->
    <!--
<script src=" OneStatic/assets/js/vendor/vendor.min.js"></script>
<script src=" OneStatic/assets/js/plugins/plugins.min.js"></script>
-->

    <!-- Main JS -->
    <script src=" OneStatic/assets/js/main.js"></script>
    

</body>
<script type="text/javascript" src="MyStatic/js/jquery-1.11.3.js"></script>
<script src="MyStatic/js/MartCart.js"></script>
<script type="text/javascript">
function cartCheckout(){
	var i=$("#spanProNum").html();
	console.log(i);
	if(i == 0){

		alert("亲爱的用户~请至少选择一个商品购买");
		return;
	}
	

	
}

function minusPro(mp){
	var r = $("#m_"+mp);
	var t =$("#total_"+mp);
	var p=$("#hidden_"+mp);
	if(r.html()<=1){
			$("#minus"+mp).prop("disabled",true);
			return;
		}
	
	
	$.ajax({
 		type:"post",
 		url:"martCarServlet",
 		data:{
 			actionName:"minusPro",
 			proId:mp
 			
 		},
 		success:function(result){
 			console.log(result);
 			if (result== 1) {
 				console.log(11111);
 				var rr=r.html();
 				var Int=parseInt(rr);
 				var Int2=Int-1;
 				var price=p.val();
 				r.html(Int2);
 				
 				t.html(Int2*price);
 				
			}
 		}
 		
 	})
	
}
	
function addPro(mp){
	
	$.ajax({
 		type:"post",
 		url:"martCarServlet",
 		data:{
 			actionName:"addPro",
 			proId:mp
 			
 		},
 		success:function(result){
 			if (result== 1){
 				var s = $("#m_"+mp);
 				var t =$("#total_"+mp);
 				var p=$("#hidden_"+mp);
 				var ss=s.html();
 				var ss1=parseInt(ss);
 				var ss2=ss1+1;
 				var price=p.val();
 				s.html(ss2);
 				t.html(ss2*price);
 				
			}
 		}
 		
 	})
} 


function deletePro(mp){

	$.ajax({
		type:"post",
 		url:"martCarServlet",
 		data:{
 			actionName:"deletePro",
 			proId:mp
 			
 		},
 		success:function(result){
 			if(result==1){
 				//删除成功
 				$("#tr_"+mp).remove();
 			}
 		}
	})
}





//全选全不选 点击事件
$("#all").click(function(){
	
	
	//this.全选的复选框
	var userids=this.checked;
	//设定一个值作为全选全不选的状态 0不选,1位全选
	var	allcheckedStatus=0;
	if(userids==true){
		allcheckedStatus=1;
	}
	
	//获取name=box的复选框,遍历输出复选框
	$("input[name=box]").each(function(){
		this.checked=userids;
	});
	
	
	var va =[];
	var va1=0;
	$("input[name=box]:checked").each(function(){
		va1++;
	});
	
	$("#spanProNum").html(va1);
	
	
	
	//发送ajax 将购物车表中的所有数据状态变为选中
	$.ajax({
		type:"post",
 		url:"MartIndexServlet",
 		data:{
 			actionName:"allChecked",
 			Status:allcheckedStatus
 			
 		},
 		success:function(result){
			if(result == null){
				$("#Totalprice").html("0");
				return;
			}
			$("#Totalprice").html(result);
 		}
	})
});

</script>

</html>

