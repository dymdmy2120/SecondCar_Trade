<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
	<title>咨立拍车-网站</title>
	<meta name="viewport" content="width=device-width, inital-scale=1.0">
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="css/font-awesome.min.css" />
	<script src="js/select/error.js"></script>
</head>
<%
	if(session.getAttribute("admin") != null) {
		//注销
		session.invalidate();
	}
%>
<input type="hidden" id="msg" value=${info[0] } />
<body style="background:url(img/login.jpg); background-repeat:no-repeat; background-size: 1366px 768px">
	<div class="container" align="center" style="margin-top:100px;">
		<form class="form-signin" role="form" style="size:300px;" action="LoginServlet?operater=adminlogin" method="post">
			<h2 class="page-header">咨立拍车后台管理系统</h2><br /><br />
			<div class="input-prepend input-append">
            <span class="add-on">用户名：</span>
            <input type="text" class="form-control " name="admin" placeholder="请输入用户名" required autofocus  style="width:200px; height:30px;"/>
            </div>
            <br />
            <div class="input-append input-prepend">
			<span class="add-on">密&nbsp;&nbsp;&nbsp;&nbsp;码：</span><input type="password" name="pasword" class="form-control" placeholder="请输入密码" required  style="width:200px; height:30px;"/>
            </div>
            <br />
			<button class="btn btn-lg btn-primary btn-block" type="submit" style="width:270px;">登入</button>
		</form>
	</div>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>

</body>
</html>