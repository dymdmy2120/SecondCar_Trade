<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty  suinforList}">

</c:if>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>"></base>
<meta charset="utf-8" />
<title>蓝点暑假项目</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
<link rel="stylesheet" href="css/ace.min.css" />
<link rel="stylesheet" href="css/ace-rtl.min.css" />
<link rel="stylesheet" href="css/ace-skins.min.css" />
<script src="js/ace-extra.min.js"></script>
<script src="js/ace-extra.min.js"></script>
<script src="js/select/query.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/select/error.js"></script>
</head>
<body>
	<center>
		<h2>
			<font color="#FF0000"> 会员中标信息 </font>
		</h2>
	</center>
<input type="hidden" id="msg" value=${info[0] } />
	<form action="" id="start" method="post"></form>
	<span style="display:block;text-align:right;"> <select
		id="select" onChange="select()">
			<option value="tname">按会员名搜索</option>
	</select> <input type="text" placeholder="Search" id="queryInput" name="tname">
		<a href="javascript:start('SucInfor')" role="button"><i
			class="icon-search">搜索</i> </a> </span>

	<div class="main-container" id="main-container">

		<div class="page-content">
			<div class="page-header">
				<table class="table table-hover" border="1">

					<thead>
						<tr>
							<td width="9%"><div align="center">
									<strong>会员名</strong>
								</div>
							</td>
							<td width="12%"><div align="center">
									<strong>车辆名称 </strong>
								</div>
							</td>
							<td width="12%"><div align="center">
									<strong>车牌号</strong>
								</div>
							</td>
							<td width="12%"><div align="center">
									<strong>会员联系方式</strong>
								</div>
							</td>
							<td width="11%"><div align="center">
									<strong>成交价格</strong>
								</div>
							</td>

						</tr>
					</thead>

					<tbody>
						<c:forEach var="sucInfor" varStatus="st"
							items="${requestScope.list}">
							<tr>
								<td>
									<div align="center">${sucInfor.tname}</div></td>
								<td><div align="center">${sucInfor.vname}</div>
								</td>
								<td><div align="center">${sucInfor.plateNo}</div>
								</td>
								<td><div align="center">${sucInfor.tel}</div>
								</td>
								<td><div align="center">${sucInfor.price}</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<center>
		<ul class="pagination">
			<ul class="pagination">
				<li><a>共有${page.count}条记录</a></li>
				<li><a>第${page.page}页</a></li>
				<li><a href="QueryServlet?view=SucInfor&firstIndex=1">首页</a>
				</li>
				<li><a
					href="QueryServlet?view=SucInfor&firstIndex=${page.page-1<=1?1:page.page- 1}">
						上一页 </a></li>
				<li><a
					href="QueryServlet?view=SucInfor&firstIndex=${page.page + 1 >=page.lastPage?page.lastPage:page.page + 1}">
						下一页</a></li>
				<li><a
					href="QueryServlet?view=SucInfor&firstIndex=${page.lastPage}">
						末页</a></li>
			</ul>
		</ul>
	</center>
	</div>
</body>
</html>
