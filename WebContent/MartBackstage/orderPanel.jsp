<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Carbon - Admin Template</title>
    <link rel="stylesheet" href="OneStatic/dist/vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="OneStatic/dist/vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="OneStatic/dist/css/styles.css">
    <link rel="stylesheet" href="MyStatic/css/MartZhe.css">
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <div class="page-header">
        <nav class="navbar page-header">
            <a href="#" class="btn btn-link sidebar-mobile-toggle d-md-none mr-auto">
                <i class="fa fa-bars"></i>
            </a>

            <a class="navbar-brand" href="#">
                <img src="../OneStatic/dist/imgs/logo.png" alt="logo">
            </a>

            <a href="#" class="btn btn-link sidebar-toggle d-md-down-none">
                <i class="fa fa-bars"></i>
            </a>

            <ul class="navbar-nav ml-auto">
                <li class="nav-item d-md-down-none">
                    <a href="#">
                        <i class="fa fa-bell"></i>
                        <span class="badge badge-pill badge-danger">5</span>
                    </a>
                </li>

                <li class="nav-item d-md-down-none">
                    <a href="#">
                        <i class="fa fa-envelope-open"></i>
                        <span class="badge badge-pill badge-danger">5</span>
                    </a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img src="../OneStatic/dist/imgs/avatar-1.png" class="avatar avatar-sm" alt="logo">
                        <span class="small ml-1 d-md-down-none">John Smith</span>
                    </a>

                    <div class="dropdown-menu dropdown-menu-right">
                        <div class="dropdown-header">Account</div>

                        <a href="#" class="dropdown-item">
                            <i class="fa fa-user"></i> Profile
                        </a>

                        <a href="#" class="dropdown-item">
                            <i class="fa fa-envelope"></i> Messages
                        </a>

                        <div class="dropdown-header">Settings</div>

                        <a href="#" class="dropdown-item">
                            <i class="fa fa-bell"></i> Notifications
                        </a>

                        <a href="#" class="dropdown-item">
                            <i class="fa fa-wrench"></i> Settings
                        </a>

                        <a href="#" class="dropdown-item">
                            <i class="fa fa-lock"></i> Logout
                        </a>
                    </div>
                </li>
            </ul>
        </nav>
    </div>

    <div class="main-container">
        <div class="sidebar">
            <nav class="sidebar-nav">
                <ul class="nav">
                    <li class="nav-title">Navigation</li>

                    <li class="nav-item">
                        <a href="index.jsp" class="nav-link">
                            <i class="icon icon-speedometer"></i> Dashboard
                        </a>
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-target"></i> Layouts <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="layouts-normal.html" class="nav-link">
                                    <i class="icon icon-target"></i> Normal
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="layouts-fixed-sidebar.html" class="nav-link">
                                    <i class="icon icon-target"></i> Fixed Sidebar
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="layouts-fixed-header.html" class="nav-link">
                                    <i class="icon icon-target"></i> Fixed Header
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="layouts-hidden-sidebar.html" class="nav-link">
                                    <i class="icon icon-target"></i> Hidden Sidebar
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-energy"></i> UI Kits <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="alerts.html" class="nav-link">
                                    <i class="icon icon-energy"></i> Alerts
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="buttons.html" class="nav-link">
                                    <i class="icon icon-energy"></i> Buttons
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="cards.html" class="nav-link">
                                    <i class="icon icon-energy"></i> Cards
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="modals.html" class="nav-link">
                                    <i class="icon icon-energy"></i> Modals
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="tabs.html" class="nav-link">
                                    <i class="icon icon-energy"></i> Tabs
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="progress-bars.html" class="nav-link">
                                    <i class="icon icon-energy"></i> Progress Bars
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="widgets.html" class="nav-link">
                                    <i class="icon icon-energy"></i> Widgets
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-graph"></i> Charts <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="chartjs.html" class="nav-link">
                                    <i class="icon icon-graph"></i> Chart.js
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="nav-item">
                        <a href="martBackstageServlet?actionName=searchOrders" class="nav-link">
                            <i class="icon icon-puzzle"></i> Order Panel
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="martBackstageServlet?actionName=searchProductAndStock" class="nav-link active">
                            <i class="icon icon-grid"></i> Product Table
                        </a>
                    </li>
                    
                    <li class="nav-item">
                    	<a href="martBackstageServlet?actionName=search" onclick="location.reload()" class="nav-link active">
                    		<i class="icon icon-grid"></i> Manipulate Panel
                    	</a>
                    </li>

                    <li class="nav-title">More</li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-umbrella"></i> Pages <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="blank.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Blank Page
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="signin.jsp" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Login
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="signup.jsp" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Register
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="invoice.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Invoice
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="MartBackstage/fun404.jsp" class="nav-link">
                                    <i class="icon icon-umbrella"></i> 404
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="500.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> 500
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="settings.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Settings
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>



        <div class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header bg-light">
                           User Table
                        </div>

                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table" style="background-image:url(https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1561546116274&di=4c074f44972df5a49634ef79d1430313&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2Fb13daed209e7ffdce54e606153b54e4bdf817cb1.jpg); background-size:cover;">
                                    <thead>
                                    <tr>
                                        <th>Order ID</th>
                                        <th>User ID</th>
                                        <th>Order Number</th>
                                        <th>Order Status</th>
                                        <th>Order Payment time</th>
                                        <th>Order Send time</th>
                                        <th>Order end time</th>
										<th>Order close time</th>
										<th>Order create time</th>
										<th>Order update time</th>
										<th>Order Money</th>
										<th>Order is in</th>
										<th>Order Product Details</th>
                                        <th>Operation</th>
                                    </tr>
                                    </thead>
                                 <!-- 
                                    <tbody>
                                        <tr>
                                        <td>Mart13551237197</td>
                                        <td>20</td>
                                        <td class="text-nowrap">Ronnie</td>
                                        <td>10000</td>
                                        <td>100</td>
                                        <td>Vtuber手办</td>
                                        <td>223</td>     
                                        <td>1000</td>
                                        <td> <button type="submit" id="btn" class="btn btn-success">修改</button>&nbsp;&nbsp;<button type="submit" id="btn" class="btn btn-warning">删除</button></td>
                                    </tr>
                                     <tr>
                                        <td>Mart1354617714</td>
                                        <td>21</td>
                                        <td class="text-nowrap">Shirakami Fubuki</td>
                                        <td>10000</td>
                                        <td>100</td>
                                        <td>AMD 显卡</td>
                                        <td>223</td>     
                                        <td>1000</td>
                                        <td> <button type="submit" id="btn" class="btn btn-success">修改</button>&nbsp;&nbsp;<button type="submit" id="btn" class="btn btn-warning">删除</button></td>
                                    </tr>
                                     <tr>
                                        <td>Mart1355270944</td>
                                        <td>22</td>
                                        <td class="text-nowrap">Kagura Nana</td>
                                        <td>10000</td>
                                        <td>100</td>
                                        <td>NVIDIA 显卡</td>
                                        <td>223</td>     
                                        <td>1000</td>
                                        <td> <button type="submit" id="btn" class="btn btn-success">修改</button>&nbsp;&nbsp;<button type="submit" id="btn" class="btn btn-warning">删除</button></td>
                                    </tr>
                                     <tr>
                                        <td>Mart13525257614</td>
                                        <td>23</td>
                                        <td class="text-nowrap">Natsuiro Matsuri</td>
                                        <td>10000</td>
                                        <td>100</td>
                                        <td>英特尔 CPU</td>
                                        <td>223</td>     
                                        <td>1000</td>
                                        <td> <button type="submit" id="btn" class="btn btn-success">修改</button>&nbsp;&nbsp;<button type="submit" id="btn" class="btn btn-warning">删除</button></td>
                                    </tr>
                                    <tr>
                                        <td>Mart13242525614</td>
                                        <td>24</td>
                                        <td class="text-nowrap">Natsuiro Matsuri</td>
                                        <td>10000</td>
                                        <td>100</td>
                                        <td>AMD CPU</td>
                                        <td>223</td>     
                                        <td>1000</td>
                                        <td> <button type="submit" id="btn" class="btn btn-success">修改</button>&nbsp;&nbsp;<button type="submit" id="btn" class="btn btn-warning">删除</button></td>
                                    </tr>
                                    <tr>
                                        <td>Mart13534237014</td>
                                        <td>25</td>
                                        <td class="text-nowrap">某壕</td>
                                        <td>100000</td>
                                        <td>100</td>
                                        <td>华硕群殴国度</td>
                                        <td>223</td>     
                                        <td>20000</td>
                                        <td> <button type="submit" id="btn" class="btn btn-success">修改</button>&nbsp;&nbsp;<button type="submit" id="btn" class="btn btn-warning">删除</button></td>
                                    </tr>
                                    <tr>
                                        <td>Mart13532567614</td>
                                        <td>26</td>
                                        <td class="text-nowrap">某壕1</td>
                                        <td>100000</td>
                                        <td>100</td>
                                        <td>外星人笔记本</td>
                                        <td>223</td>     
                                        <td>40000</td>
                                        <td> <button type="submit" id="btn" class="btn btn-success">修改</button>&nbsp;&nbsp;<button type="submit" id="btn" class="btn btn-warning">删除</button></td>
                                    </tr>
                                    <tr>
                                        <td>Mart1356858614</td>
                                        <td>27</td>
                                        <td class="text-nowrap">平民1</td>
                                        <td>100000</td>
                                        <td>100</td>
                                        <td>散热缩水星</td>
                                        <td>223</td>     
                                        <td>10000</td>
                                        <td> <button type="submit" id="btn" class="btn btn-success">修改</button>&nbsp;&nbsp;<button type="submit" id="btn" class="btn btn-warning">删除</button></td>
                                    </tr>
                                    <tr>
                                        <td>Mart135595447</td>
                                        <td>28</td>
                                        <td class="text-nowrap">某壕2</td>
                                        <td>100000</td>
                                        <td>100</td>
                                        <td>烧烤煎炸蛇</td>
                                        <td>223</td>     
                                        <td>27000</td>
                                        <td> <button type="submit" id="btn" class="btn btn-success">修改</button>&nbsp;&nbsp;<button type="submit" id="btn" class="btn btn-warning">删除</button></td>
                                    </tr>
                                     <tr>
                                        <td>Mart123526447</td>
                                        <td>29</td>
                                        <td class="text-nowrap">某壕2</td>
                                        <td>100000</td>
                                        <td>100</td>
                                        <td>烧烤煎炸蛇</td>
                                        <td>223</td>     
                                        <td>27000</td>
                                        <td> <button type="submit" id="btn" class="btn btn-success">修改</button>&nbsp;&nbsp;<button type="submit" id="btn" class="btn btn-warning">删除</button></td>
                                    </tr>  -->
                                    <c:if test="${resultInfo.result ==null }">
                                    	<tr>
	                                        <td>ws</td>
	                                        
                                   		 </tr>
                                    </c:if>
                                    <c:if test="${resultInfo.result !=null }">
                                    	<c:forEach items="${resultInfo.result }" var="order">
                                    		<tr id="tr_${order.orderId}" ><input type="hidden" id="oId" value="${order.orderId}" />
                                            <td id="orderId_${order.orderId }">${order.orderId }</td>
	                                        <td id="userId_${order.orderId }">${order.userId }</td>
	                                        <td class="text-nowrap" id="orderNumber_${order.orderId }">${order.orderNumber }</td>
	                                        <td id="orderStatus_${order.orderId }">${order.orderStatus }</td>
	                                        <td id="orderPayment_${order.orderId }">${order.orderPayment }</td>
	                                        <td id="orderSend_${order.orderId }">${order.orderSend }</td>
	                                        <td id="orderEnd_${order.orderId }">${order.orderEnd }</td>
	                                        <td id="orderClose_${order.orderId }">${order.orderClose }</td>
	                                        <td id="orderCreate_${order.orderId }">${order.orderCreate }</td>
	                                        <td id="orderUpdate_${order.orderId }">${order.orderUpdate } </td>
	                                        <td id="orderMoney_${order.orderId }">${order.orderMoney }</td>
	                                        <td id="orderisIn_${order.orderId }">${order.orderisIn }</td>
	                                        <td>
	                                        <table id="innerTable">
	                                        <tbody>
	                                        <thead>
	                                        	<tr>
	                                        		<th>Product ID</th>
	                                        		<th>Product Image</th>
	                                        		<th>Product Name</th>
	                                        		<th>Product Brand</th>
	                                        		<th>Product Price</th>
	                                        		<th>Sorder Count</th>
	                                        		<th>Sorder ID</th>
	                                        		<th>Order ID</th>
	                                        		<th>User ID</th>
	                                        	</tr>
	                                        </thead>
	                                        <c:forEach items="${order.list }" var="list">
		                                     <tr id="tr2_${order.orderId }"><input type="hidden" id="pId" value="${list.proId}" />
		                                        <td  id="proId_${order.orderId }">${list.proId }</td>
		                                        <td  id="proImg_${order.orderId }"><img src="${list.proImg }" height="60" width="60" ></td>
		                                        <td  id="proName_${order.orderId }">${list.proName }</td>
		                                        <td  id="proBrand_${order.orderId }">${list.proBrand }</td>
		                                        <td  id="proPrice_${order.orderId }">${list.proPrice }</td>
		                                        <td  id="soCount_${order.orderId }">${list.soCount }</td>
		                                        <td  id="soId_${order.orderId }">${list.soId }</td>
		                                        <td  id="orderId_${order.orderId }">${list.orderId }</td>
		                                        <td  id="userId_${order.orderId }">${list.userId }</td>      
	                                        </tr>
	                                        </c:forEach>
	                                        </tbody>
	                                        </table>
	                                        </td>
	                                        <td> <button type="button" id="btn" class="btn btn-success" onclick="showOrderModal(${order.orderId})">修改</button>
	                                        &nbsp;&nbsp;
	                                        <button type="button" id="btn" class="btn btn-warning" onclick="comfirmOrderDelete(${order.orderId})">删除</button></td>
	                                    	</tr>
	                                    	
                                    	</c:forEach>
                                    </c:if> 
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                            </div>
                        </div>
                    </div>
                </div>


<div class="modal fade" id="myOrderModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改订单详情</h4>
            </div>
            <div class="modal-body">
            <form id="editForm">
						修改ID:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="userId" id="userIdMo" readonly="readonly" /><br />
						修改用户名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="userName" id="userNameMo" /><br />
						修改用户密码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="userPwd" id="userPwdMo" /><br />
						修改用户性别:&nbsp;&nbsp;<input type="radio" name="userSex" id="userSexMo" checked="checked" value="2" />男
						<input type="radio" name="userSex" id="userSexMo" value="1" />女<br />
						修改用户邮箱:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="userMail" id="userMailMo" /><br />
						修改用户手机号:&nbsp;<input type="text" name="userMobile" id="userMobileMo" /><br />
						修改用户头像&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="userHead" id="userHeadMo" readonly="readonly" /><br />
						修改用户余额&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="userBalance" id="userBalanceMo" /><br />
						修改用户状态&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="userStatus" id="userStatusMo" />
					</form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="sendOrderModifyReq()">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


</body>
<script src="OneStatic/dist/vendor/jquery/jquery.min.js"></script>
<script src="OneStatic/dist/vendor/popper.js/popper.min.js"></script>
<script src="OneStatic/dist/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="OneStatic/dist/vendor/chart.js/chart.min.js"></script>
<script src="OneStatic/dist/js/carbon.js"></script>
<script src="OneStatic/dist/js/demo.js"></script>
<script src="MyStatic/js/MartZhe.js"></script>
</html>