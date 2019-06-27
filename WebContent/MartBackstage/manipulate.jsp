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
                        <a href="index.html" class="nav-link">
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
                        <a href="martBackstageServlet?actionName=searchOrders" class="nav-link active">
                            <i class="icon icon-puzzle"></i> Order Panel
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="martBackstageServlet?actionName=searchProductAndStock" class="nav-link active">
                            <i class="icon icon-grid"></i> Product Table
                        </a>
                    </li>
                    
                    <li class="nav-item">
                    	<a href="javascript:void(0)" onclick="location.reload()" class="nav-link active">
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
                                <a href="signIn.jsp" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Login
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="signUp.jsp" class="nav-link">
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
                                <table class="table" style="background-image:url(https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1561547266919&di=c472fee0a043e653e73d50313ab7038a&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2Ffd50d1d97a21ad141adf8925f2c9fd43a83818ff.jpg); background-size:cover;">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Password</th>
                                        <th>Sex</th>
                                        <th>Email Address</th>
                                        <th>Phone Number</th>
                                        <th>Head</th>
                                        <th>Balance</th>
                                        <th>Status</th>
                                        <th>Operation</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td class="text-nowrap">Ronnie</td>
                                        <td>A940922h</td>
                                        <td>1</td>
                                        <td>591806780@qq.com</td>
                                        <td>13512136952</td>
                                        <td><img alt="头像" src="data:image/jpeg;base64,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" height="60" width="60"></td>
                                        <td>10000</td>
                                        <td>2</td> 
                                        <td> <button type="submit" id="btn" class="btn btn-success">修改</button>&nbsp;&nbsp;<button type="submit" id="btn" class="btn btn-warning">删除</button></td>
                                    </tr>
                                    <c:if test="${resultInfo.result ==null }">
                                    	<tr>
	                                        <td>ws</td>
	                                        
                                   		 </tr>
                                    </c:if>
                                    <c:if test="${resultInfo.result !=null }">
                                    	<c:forEach items="${resultInfo.result }" var="list">
                                    		<tr id="tr_${list.userId}" ><input type="hidden" id="uId" value="${list.userId}" />
                                    		
	                                        <td id="userId_${list.userId }">${list.userId }</td>
	                                        <td class="text-nowrap" id="userName_${list.userId }">${list.userName }</td>
	                                        <td id="userPwd_${list.userId }">${list.userPwd }</td>
	                                        <td id="userSex_${list.userId }">${list.userSex }</td>
	                                        <td id="userMail_${list.userId }">${list.userMail }</td>
	                                        <td id="userMobile_${list.userId }">${list.userMobile }</td>
	                                        <td id="userHead_${list.userId }"><img src="${list.userHead }" height="60" width="60"></td>
	                                        <td id="userBalance_${list.userId }">${list.userBalance}</td>
	                                        <td id="userStatus_${list.userId }">${list.userStatus }</td>
	                                        <td> <button type="button" id="btn" class="btn btn-success" onclick="showModal(${list.userId})">修改</button>
	                                        &nbsp;&nbsp;
	                                        <button type="button" id="btn" class="btn btn-warning" onclick="comfirmDelete(${list.userId})">删除</button></td>
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


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改用户信息</h4>
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
                <button type="button" class="btn btn-primary" onclick="sendModifyReq()">提交更改</button>
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