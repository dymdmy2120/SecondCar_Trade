
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8" />
<title>蓝点暑假项目</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
<link rel="stylesheet" href="css/ace.min.css" />
<link rel="stylesheet" href="css/ace-rtl.min.css" />
<link rel="stylesheet" href="css/ace-skins.min.css" />
<script src="js/ace-extra.min.js"></script>
</head>
<body>
<center>
	<h2>
	<font color="#FF0000">
	当月数据导出
	</font>
	</h2>
</center>
<hr />
 <form action="ExportServlet" method="post">
<div class="main-container" id="main-container">
 <div class="page-content">
  &nbsp;&nbsp;&nbsp;<input class="btn btn-large btn-primary" type="submit" value="导出本月信息"></button>   
 </div>
 <div>
 </form>

 	<table class="table table-hover" border="1">
 		<tr bgColor="#EDEDED">
 			<td>日期</td>
 			<td>竞拍车辆编号</td>
 			<td>车辆来源</td>
 			<td>竞拍底价</td>
 			<td>竞拍是否成功</td>
 			<td>成交价格</td>
 			<td>竞拍成功会员</td>
 			<td>竞拍人数</td>
 		</tr>
 		<c:forEach var="BusinessBooks" varStatus="st" items="${requestScope.list}">
 		<tr>
 			<td>${BusinessBooks.bidtime }</td>
 			<td>${BusinessBooks.plateNo }</td>
 			<td>${BusinessBooks.source }</td>
 			<td>${BusinessBooks.bspri }</td>
 			<td>${BusinessBooks.state }</td>
 			<td>${BusinessBooks.price }</td>
 			<td>${BusinessBooks.tname }</td>
 			<td>${BusinessBooks.counts }</td>
 		</tr>
		</c:forEach>
 	</table>
 </div>
</div>
</body>
</html>
