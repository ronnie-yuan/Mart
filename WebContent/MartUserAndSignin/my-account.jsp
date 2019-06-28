<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>My Account</title>
    <meta name="robots" content="noindex, follow" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicon -->


    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
   
    <link rel="stylesheet" href="OneStatic/assets/css/plugins/plugins.css">


	<script src="MyStatic/js/jquery-1.11.3.js"></script>
	
    <!-- Main Style CSS (Please use minify version for better website load performance) -->
    <link rel="stylesheet" href="OneStatic/assets/css/style.css">
    <!--<link rel="stylesheet" href="OneStatic/assets/css/style.min.css">-->

</head>

<body>

    <!-- Start Breadumb Area -->
    <div class="breadcumb-area ptb--100 ptb_md--100 ptb_sm--100  bg_image bg_image--3">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="inner text-center">
                        <h2 class="font--40 mb--0">My Account</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Breadumb Area -->
    <div class="main-wrapper">
        <!-- Start My Account Area -->
        <div class="my-account-area pt--120 pb--90">
            <div class="container">
                <div class="row">
                    <div class="ml-auto mr-auto col-lg-12">
                        <div class="checkout-wrapper">
                            <div id="faq" class="panel-group">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                            <span>1</span>
                                            <a data-toggle="collapse" data-parent="#faq" href="#my-account-1">Edit my
                                                account information </a>
                                        </h5>
                                    </div>
                                    <div id="my-account-1" class="panel-collapse collapse ">
                                        <div class="panel-body">
                                            <div class="billing-information-wrapper">
                                                <div class="account-info-wrapper">
                                                    <h4>My Account Information(我的账户信息)</h4>
                                                    <h5>My Personal Details(个人资料)</h5>
                                                </div>
                                                <div class="row">
                                                	<label for="img" class="col-sm-2 control-label">head(头像):</label>
												    <div class="col-sm-5">
												    	
												    	<span><img alt="www.baidu.com" src="${user.userHead }" id="img1" width="40px" height="40px"></span> 
												    </div>
                                                    <div class="col-lg-6 col-md-6">
                                                        <div class="billing-info">
                                                            <label>Name(用户名)</label>
                                                            <input type="text" id="uname" name="uname" readonly="readonly" value="${user.userName }">
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-6 col-md-6">
                                                        <div class="billing-info">
                                                            <label>Sex(性别)</label>
                                                            <input type="text" id="usex" name="usex" value="${user.userSex }"> 
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-12 col-md-12">
                                                        <div class="billing-info">
                                                            <label>Email Address(邮箱地址)</label>
                                                            <input type="email" id="uemail" name="uemail" value="${user.userMail }">
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-6 col-md-6">
                                                        <div class="billing-info">
                                                            <label>Telephone(电话)</label>
                                                            <input type="text" id="uphone" name="uphone" readonly="readonly" value="${user.userMobile }"> 
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-6 col-md-6">
                                                        <div class="billing-info">
                                                            <label>Status(状态)</label>
                                                            <input type="text" id="ustatus" name="ustatus" readonly="readonly" value="${user.userStatus }">
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-6 col-md-6">
                                                        <div class="billing-info">
                                                            <label>Balance(用户金额)</label>
                                                            <input type="text" id="ubalance" name="ubalance" readonly="readonly" value="${user.userBalance }">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="billing-back-btn">
                                                    <div class="billing-back">
                                                        <a href="#">
                                                            <i class="fa fa-long-arrow-up"></i> back(回到顶部)</a>
                                                    </div>
                                                    <span style="font-size: 16px;color:red" id="msg3"></span>
                                                    <div class="billing-btn">
                                                    	<input id="but001" type="button" value="Preserve(保存)" class="btn btn-info">
                                                    	
                                                    </div>                                                   
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                                
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                            <span>2</span>
                                            <a data-toggle="collapse" data-parent="#faq" href="#my-account-2">Change
                                                My password(修改密码) </a>
                                        </h5>
                                    </div>
                                    <div id="my-account-2" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <div class="billing-information-wrapper">
                                                <div class="account-info-wrapper">
                                                    <h4>Change Password</h4>
                                                    <h5>My Password</h5>
                                                </div>
                                                <div class="row">
                                                	<div class="col-lg-12 col-md-12">
                                                        <div class="billing-info">
                                                            <label>The old password(旧密码)</label>
                                                            <input type="password" id="password03" name="password3">
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-12 col-md-12">
                                                        <div class="billing-info">
                                                            <label>Password(密码)</label>
                                                            <input type="password" id="password01" name="password">
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-12 col-md-12">
                                                        <div class="billing-info">
                                                            <label>Password Confirm(确认密码)</label>
                                                            <input type="password" id="password02" name="password02">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="billing-back-btn">
                                                    <div class="billing-back">
                                                        <a href="#">
                                                            <i class="fa fa-long-arrow-up"></i> back</a>
                                                    </div>
                                                    <span style="font-size: 16px;color:red" id="msg4"></span>
                                                    <div class="billing-btn">
                                                        <input id="but002" type="button" value="Preserve(保存)" class="btn btn-info">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                               
                               
                               
                               
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                            <span>3</span>
                                            <a data-toggle="collapse" data-parent="#faq" href="#my-account-3">
                                                My order(我的订单) </a>
                                        </h5>
                                    </div>
                                    <div id="my-account-3" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <div class="billing-information-wrapper">
                                                <div class="account-info-wrapper">
                                                    <h4>我的订单</h4>
                                                </div>
                                                <div class="entries-wrapper">
                                                    <div class="row">
                                                    	<div class="col-lg-12 col-12 d-flex align-items-center justify-content-center">
                                                    		<!-- 判断数据是否存在，不存在显示提示信息 -->
                                                            <c:if test="${empty checkOrderCenter}">
                                                            	<h2>${checkOrderCenter.msg }</h2>
                                                            </c:if>
                                                            <!-- 判断数据时候否存在，存在显示订单列表 -->
                                                            <c:if test="${!empty checkOrderCenter }">
	                                                            <table>	
	                                                            	<tr>
																		<th>订单号</th>
																		<th>订单编号</th>
																		<th>订单状态</th>
																		<th>订单创建时间</th>
																		<th>订单更新时间</th>
																		<th>订单支付时间</th>
																		<th>订单总金额</th>
																	</tr>
																	<c:forEach items="${OrderList }" var="Order">
																	<tr id="tr_${Order.orderId }"  >
																		<input type="hidden" id="oId" value="${order.orderId}" />
																		<td >${Order.orderId }</td>
																		<td>${Order.orderNumber }</td>
																		<td>${Order.orderStatus }</td>
																		<td>${Order.orderCreate }</td>
																		<td>${Order.orderUpdate }</td>
																		<td>${Order.orderPayment }</td>
																		<td>${Order.orderMoney }</td>
																		<td><button type="button" class="btn btn-info"  onclick="openMoTai(${Order.orderId })"  >查看</button></td>
                                                                		<td><button type="button" class="btn btn-info"  onclick="deleteOrder(${Order.orderId })" >删除</button></td>
																		
																	</tr>
																	</c:forEach>
																</table>	
                                                            </c:if>
                                                    	</div>
                                                        
                                                    </div>
                                                </div>
                                                
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End My Account Area -->
        	<!-- 模态框（Modal） -->
		<div class="modal fade" data-backdrop="false" id="wodemotaikuang" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel1111">模态框（Modal）标题</h4>
		            </div>
		            <div class="modal-body">在这里添加一些文本</div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		                <button type="button" class="btn btn-primary">提交更改</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
    </div>
    
    
    
	
	
    <!-- jQuery JS -->
    <script src="OneStatic/assets/js/vendor/jquery.js"></script>
    
    <!-- Modernizer JS -->
    <script src="OneStatic/assets/js/vendor/modernizr.min.js"></script>

    <!-- Bootstrap JS -->
    <script src="OneStatic/assets/js/vendor/bootstrap.min.js"></script>
    <script src="OneStatic/assets/js/plugins/plugins.js"></script>
    <!-- Vendor & Plugins JS (Please remove the comment from below vendor.min.js & plugins.min.js for better website load performance and remove js files from avobe) -->
    <!--
	<script src="OneStatic/assets/js/vendor/vendor.min.js"></script>
	<script src="OneStatic/assets/js/plugins/plugins.min.js"></script>
	-->

    <!-- Main JS -->
    <script src="OneStatic/assets/js/main.js"></script>

	<script src="MyStatic/js/utils.js"></script>
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
		<script src="MyStatic/js/MartQiu02.js"></script>
	
	

	
	
	
	
	
</body>

	<script type="text/javascript">


	</script>
	
	
</html>

