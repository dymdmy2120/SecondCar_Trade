<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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
<script src="js/ace-extra.min.js"></script>
<script src="js/select/check.js"></script>
<script src="js/select/error.js"></script>
<script src="js/select/query.js" charset="utf-8"></script>
<script src="js/jquery.min.js"></script>
</head>
<body>
	<center>
		<h2>
			<font color="#FF0000"> 过期公告清理 </font>
		</h2>
	</center>
<input type="hidden" id="msg" value=${info[0] } />
	<div class="main-container" id="main-container">

		<div class="page-content">

			<table class="table table-hover" border="1">
				<!-- 修改区-->
				<form id="verify" action="" method="post"></form>
				<ul class="nav nav-tabs">
					<li><a><input type="checkbox" name="allChecked"
							id="allChecked" onClick="DoCheck('n_id')" /> </a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown"
						href="javascript:fillHref('null','Notice','n_id')"> 删除 <span
							class="caret"></span> </a>
					</li>

					<form action="" id="start" method="post"></form>
					<span style="display:block;text-align:right;"> <select
						id="select" onChange="select()">
							<option value="title">按公告标题搜索</option>
					</select> <input type="text" placeholder="Search" id="queryInput"
						name="title"> <a href="javascript:start('Notice')"
						role="button"><i class="icon-search">搜索</i> </a> </span>

				</ul>
				<!-- 修改区-->
				<thead>
					<tr>
						<td width="22%">公告标题</td>
						<td width="44%"><div align="center">公告主要内容</div></td>
						<td width="20%"><div align="center">公告上传日期</div></td>
						<td colspan="2"><div align="center">操作</div></td>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="notice" varStatus="st" items="${requestScope.list}">
						<tr>
							<td>
								<div align="left">
									<input type="checkbox" name="n_id" value="${notice.n_id }">
									${notice.title }
								</div></td>
							<td><div align="center">${notice.content }</div></td>

							<td><div align="center">
									<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
										value="${notice.n_time }" type="both" />
								</div></td>

							<td width="14%">
								<div align="center">
									<a
										href="SingleServlet?operate=Notice.delete&n_id=${notice.n_id }">删除</a>
								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<center>
				<ul class="pagination">
					<li><a>共有${page.count}条记录</a></li>
					<li><a>第${page.page}页</a></li>
					<li><a href="QueryServlet?view=Notice&firstIndex=1">首页</a></li>
					<li><a
						href="QueryServlet?view=Notice&firstIndex=${page.page-1<=1?1:page.page- 1}">
							上一页 </a></li>
					<li><a
						href="QueryServlet?view=Notice&firstIndex=${page.page + 1 >=page.lastPage?page.lastPage:page.page + 1}">
							下一页</a></li>
					<li><a
						href="QueryServlet?view=Notice&firstIndex=${page.lastPage}">
							末页</a></li>
				</ul>
			</center>
		</div>
	</div>
	</div>
</body>
</html>
