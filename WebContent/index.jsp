﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Home</title>
    <meta name="robots" content="noindex, follow" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicon -->
    

    <!-- CSS
	============================================ -->

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="OneStatic/assets/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="OneStatic/assets/css/plugins/plugins.css">
	
    <!-- Vendor & Plugins CSS (Please remove the comment from below vendor.min.css & plugins.min.css for better website load performance and remove css files from avobe) -->
    <!--
    <script src="OneStatic/assets/js/vendor/vendor.min.js"></script>
    <script src="OneStatic/assets/js/plugins/plugins.min.js"></script>
    -->

    <!-- Main Style CSS (Please use minify version for better website load performance) -->
    <link rel="stylesheet" href="OneStatic/assets/css/style.css">
    <!--<link rel="stylesheet" href="OneStatic/assets/css/style.min.css">-->

</head>

<body>
    <!-- Start Header 中间主页,关于,商品等下拉选项-->
    <header class="header-area haeder-default header--transparent black-logo-version ptb_lg--40 ptb_md--40 ptb_sm--30">
        <div class="header-wrapper container">
            <div class="row align-items-center">
                <!-- Start Header Left -->
                <div class="col-xl-2 col-lg-6 col-md-6 col-sm-6 col-6">
                    <div class="logo">
                        <a href="index.jsp">
                            <img src="OneStatic/assets/images/logo/logo-black.png" alt="Draven logo">
                        </a>
                    </div>
                </div>
                <!-- Start Header Center -->
                <div class="col-xl-9 d-none d-xl-block">
                    <nav class="mainmenu__nav">
                        <!-- Start Mainmanu Nav -->
                        <ul class="primary-menu megamenu-wrapper">
                            <li class="lavel-1"><a href="IndexServlet?actionName=changePage&changePage=MartIndexAndSidebar/indexTwo.jsp">主页</a>
                                <ul class="dropdown__menu">
                                    
                               		<c:if test="${empty resultInfos.getResult() }">
                               			<li><span>无数据</span></li>
                               		</c:if>
                               		<c:if test="${!empty resultInfos.getResult() }">
                               			<c:forEach items="${resultInfos.getResult() }" var="list">
                               				<li><a href="MartIndexServlet?actionName=delectBigTypes&bigId=${list.getBigId() }"><span>${list.getBigName() }</span></a></li>
                               			</c:forEach>
                               		</c:if> 
                               		
                                </ul>
                            </li>
                            <li><a href="IndexServlet?actionName=changePage&changePage=about.jsp">关于</a></li>
                            <li class="lavel-1"><a href="IndexServlet?actionName=changePage&changePage=MartIndexAndSidebar/shop-left-sidebar.jsp">商品</a>
                                <ul class="dropdown__menu">
                                    <li><a href="IndexServlet?actionName=changePage&changePage=MartIndexAndSidebar/shop-left-sidebar.jsp"><span>左边选择框</span></a></li>                                   
                                    <li><a href="IndexServlet?actionName=changePage&changePage=MartProDetails/product-details.jsp"><span>商品详情</span></a></li>
                                </ul>
                            </li>
                            <li class="lavel-1"><a href="#">个人</a>
                                <ul class="dropdown__menu">
                                    <li><a href="martCarServlet?actionName=null"><span>购物车</span></a></li>
                                    <li><a href="IndexServlet?actionName=changePage&changePage=MartCartAndOrder/checkout.jsp"><span>订单详情</span></a></li>
                                    <li><a href="IndexServlet?actionName=changePage&changePage=MartWishlist/wishlist.jsp"><span>心愿单</span></a></li>
                                    <li><a href="IndexServlet?actionName=changePage&changePage=compare.jsp"><span>商品对比</span></a></li>
                                    <li><a href="MartUserServlet?actionName=gouPersonalCenter"><span>个人中心</span></a></li>
                                    <li><a href="javascript:void(0);" onclick="gouhoutai()"><span>后台系统</span></a></li>
                                    <li><a href="javascript:void(0);" onclick="zhuxiao()"><span>登出</span></a></li>
                                </ul>
                            </li>
                            <li><a href="IndexServlet?actionName=changePage&changePage=contact.jsp">联系我们</a></li>

                        </ul>
                        <!-- End Mainmanu Nav -->
                    </nav>
                </div>
                <!-- Start Header Right -->
                <div class="col-xl-1 col-lg-6 col-md-6 col-sm-6 col-6">
                    <div class="header-icon d-flex justify-content-end cart text-right">
                        <a class="cart-trigger" href="#">
                            <i class="fa fa-shopping-cart"></i>
                            <span class="cart-count">03</span>
                        </a>
                        <a class="hamburger-trigger d-block d-xl-none pl--15" href="#">
                            <i class="fa fa-bars"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- Start Header -->
    
    <!-- Start Search Flyover 右上方购物车-->
    <div class="search-flyoveray"></div>
    <div class="cart-flyout">
        <div class="cart-flyout-inner">
            <a class="btn-close-cart" href="#">
                <i class="fa fa-times"></i>
            </a>
            <div class="cart-flyout__content">
                <div class="cart-flyout__heading">购物车信息</div>
                <div class="widget_shopping_cart_content">
                    <ul class="product_list_widget">
                        <li>
                            <div class="thumb">
                                <img src="OneStatic/assets/images/product/sm-product-01.jpg" alt="product">
                            </div>
                            <div class="content">
                                <h6><a href="IndexServlet?actionName=changePage&changePage=MartProDetails/product-details.jsp">Boys light blue jacket</a></h6>
                                <div class="quntity">1 × $35.99</div>
                                <button class="remove-btn">×</button>
                            </div>
                        </li>

                        <li>
                            <div class="thumb">
                                <img src="OneStatic/assets/images/product/sm-product-02.jpg" alt="product">
                            </div>
                            <div class="content">
                                <h6><a href="IndexServlet?actionName=changePage&changePage=MartProDetails/product-details.jsp">Boys light blue jacket</a></h6>
                                <div class="quntity">1 × $35.99</div>
                                <button class="remove-btn">×</button>
                            </div>
                        </li>

                        <li>
                            <div class="thumb">
                                <img src="OneStatic/assets/images/product/sm-product-03.jpg" alt="product">
                            </div>
                            <div class="content">
                                <h6><a href="IndexServlet?actionName=changePage&changePage=MartProDetails/product-details.jsp">Boys light blue jacket</a></h6>
                                <div class="quntity">1 × $35.99</div>
                                <button class="remove-btn">×</button>
                            </div>
                        </li>

                    </ul>
                </div>
                <p class="minicart__total">Subtotal: <span class="price">164.97</span></p>
                <div class="cart__btn">
                    <a href="martCarServlet?actionName=null">购物车</a>
                    <a href="IndexServlet?actionName=changePage&changePage=MartCartAndOrder/checkout.jsp">Checkout</a>
                </div>
            </div>
        </div>
    </div>
    <!-- End Search Flyover -->
    
    <!-- Start Hamburger 左侧主页,关于,商品等下拉选项-->
    <div class="hamburger-area">
        <div class="btn-close-search">
            <button>
                <i class="fa fa-times" aria-hidden="true"></i>
            </button>
        </div>
        <!-- Start Main Menu -->
        <ul class="menu-primary-menu-1 responsive-manu d-block d-xl-none" id="responsive-manu">
            <li class="has-dropdown"><a href="index.jsp">主页</a>
                <ul class="sub-menu">
                               		<c:if test="${empty resultInfos.getResult() }">
                               			<li><span>无数据</span></li>
                               		</c:if>
                               		<c:if test="${!empty resultInfos.getResult() }">
                               			<c:forEach items="${resultInfos.getResult() }" var="list">
                               				<li><a href="MartIndexServlet?actionName=delectBigTypes&bigId=${list.getBigId() }"><span>${list.getBigName() }</span></a></li>
                               			</c:forEach>
                               		</c:if> 
                </ul>
            </li>
            <li><a href="IndexServlet?actionName=changePage&changePage=about.jsp">关于</a></li>
            <li class="has-dropdown"><a href="IndexServlet?actionName=changePage&changePage=shop.jsp">商品</a>
                <ul class="sub-menu">
                    <!-- <li><a href="shop.jsp"><span>右边选择框</span></a></li> -->
                    <li><a href="IndexServlet?actionName=changePage&changePage=MartIndexAndSidebar/shop-left-sidebar.jsp"><span>左边选择框</span></a></li>
                    <!-- <li><a href="shop-no-sidebar.jsp"><span>无选择框</span></a></li> -->
                   	<li><a href="IndexServlet?actionName=changePage&changePage=MartProDetails/product-details.jsp"><span>商品详情</span></a></li>
                </ul>
            </li>
            <li class="has-dropdown"><a href="#">个人</a>
                <ul class="sub-menu">
                    <li><a href="martCarServlet?actionName=null"><span>购物车</span></a></li>
                    <li><a href="IndexServlet?actionName=changePage&changePage=MartCartAndOrder/checkout.jsp"><span>订单详情</span></a></li>
                    <li><a href="IndexServlet?actionName=changePage&changePage=MartWishlist/wishlist.jsp"><span>心愿单</span></a></li>
                    <li><a href="IndexServlet?actionName=changePage&changePage=compare.jsp"><span>商品对比</span></a></li>
                    <li><a href="IndexServlet?actionName=changePage&changePage=MartUserAndSignin/my-account.jsp"><span>个人中心</span></a></li>
                    <li><a href="signIn.jsp"><span>登录注册</span></a></li>
                </ul>
            </li>
            <li class="has-dropdown"><a href="#">联系</a>
                <ul class="sub-menu">
                	<li><a href="IndexServlet?actionName=changePage&changePage=contact.jsp">联系我们</a></li>
                </ul>
            </li>
        </ul>
        <!-- End Main Menu -->
    </div>
    <!-- End Hamburger -->
	
	<!-- 动态包含 -->
 	<div>
 		<c:if test="${empty changePage }">
			<jsp:include page="MartIndexAndSidebar/indexTwo.jsp"></jsp:include> 
		</c:if>
		<c:if test="${!empty changePage }">
			<jsp:include page="${changePage }"></jsp:include>
		</c:if>
 	</div>


    <!-- JS
============================================ -->

    <!-- Modernizer JS -->
    <script src="OneStatic/assets/js/vendor/modernizr.min.js"></script>
    <!-- jQuery JS -->
    <script src="OneStatic/assets/js/vendor/jquery.js"></script>
    <!-- Bootstrap JS -->
    
    <script src="OneStatic/assets/js/plugins/plugins.js"></script>
    <!-- Vendor & Plugins JS (Please remove the comment from below vendor.min.js & plugins.min.js for better website load performance and remove js files from avobe) -->
    <!--
<script src="OneStatic/assets/js/vendor/vendor.min.js"></script>
<script src="OneStatic/assets/js/plugins/plugins.min.js"></script>
-->

    <!-- Main JS -->
    <script src="OneStatic/assets/js/main.js"></script>
	
</body>
<script type="text/javascript">
function gouhoutai(){
	var res = confirm("请慎入,非超级SVIP七钻全开月入百万不可进");

    if(res == true){

    	window.location.href="IndexServlet?actionName=houtai"; 
		
     }
}
function zhuxiao(){
	var res = confirm("确定要退出当前账号么?");
	
	if(res == true){
		window.location.href="IndexServlet?actionName=zhuxiao";
	}
	
}
</script>

</html>

