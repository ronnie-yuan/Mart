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
                                <a href="#" class="nav-link">
                                    <i class="icon icon-target"></i> Normal
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="icon icon-target"></i> Fixed Sidebar
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="icon icon-target"></i> Fixed Header
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="#" class="nav-link">
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
                                <a href="#" class="nav-link">
                                    <i class="icon icon-energy"></i> Alerts
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="icon icon-energy"></i> Buttons
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="icon icon-energy"></i> Cards
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="icon icon-energy"></i> Modals
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="icon icon-energy"></i> Tabs
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="icon icon-energy"></i> Progress Bars
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="MartCartAndOrder/cart.jsp" class="nav-link">
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
                    	<a href="martBackstageServlet?actionName=search" class="nav-link active">
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
                                <a href="login.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Login
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="register.html" class="nav-link">
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
                           Product Stock Table
                        </div>

                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                    <tr>
                                      <th>Product Id</th>
                                      <th>Product Name</th>
                                      <th>Product Brand</th>
                                      <th>Product Price</th>
                                      <th>product Stock</th>
                                      <th>product Status</th>
                                      <th>product Image</th>
                                      <th>Operation</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                     <c:if test="${resultInfo.result ==null }">
                                    	<tr>
	                                        <td>ws</td>
	                                        
                                   		 </tr>
                                    </c:if>
                                    <c:if test="${resultInfo.result !=null }">
                                    	<c:forEach items="${resultInfo.result }" var="list">
                                    	<tr id="tr_${list.proId}" ><input type="hidden" id="pId" value="${list.proId}" />
                                    		
	                                        <td id="proId_${list.proId }">${list.proId }</td>
	                                        <td class="text-nowrap" id="proName_${list.proId }">${list.proName }</td>
	                                        <td id="proBrand_${list.proId }">${list.proBrand }</td>
	                                        <td id="proPrice_${list.proId }">${list.proPrice }</td>
	                                        <td id="proStock_${list.proId }">${list.proStock }</td>
	                                        <td id="proStatus_${list.proId }">${list.proStatus }</td>
	                                        <td><img src="${list.proImg }" height="60" width="60"></td>
	                                        <td> <button type="button" id="btn" class="btn btn-success" onclick="showProductModal(${list.proId})">修改</button>
	                                        &nbsp;&nbsp;
	                                        <button type="button" id="btn" class="btn btn-warning" onclick="comfirmProductDelete(${list.proId})">删除</button></td>
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
                <div class="modal fade" id="myProModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改商品库存表信息</h4>
            </div>
            <div class="modal-body">
            <form id="editForm">
            			修改商品ID:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="productId" id="proIdMo" readonly="readonly" /><br />
						修改商品价格:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="productPrice" id="proPriceMo" /><br />
						修改商品库存:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="productStock" id="proStockMo" /><br />
						修改商品状态:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="productStatus" id="proStatusMo" /><br />
					</form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="sendProductModifyReq()">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script src="OneStatic/dist/vendor/jquery/jquery.min.js"></script>
<script src="OneStatic/dist/vendor/popper.js/popper.min.js"></script>
<script src="OneStatic/dist/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="OneStatic/dist/vendor/chart.js/chart.min.js"></script>
<script src="OneStatic/dist/js/carbon.js"></script>
<script src="OneStatic/dist/js/demo.js"></script>
<script src="MyStatic/js/MartZhe.js"></script>
</body>
</html>