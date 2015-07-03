<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>蓝点暑假项目</title>
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
<link rel="stylesheet" href="css/ace.min.css" />
<link rel="stylesheet" href="css/ace-rtl.min.css" />
<link rel="stylesheet" href="css/ace-skins.min.css" />
<script src="js/ace-extra.min.js"></script>
<script src="js/select/check.js"></script>
<script src="js/ace-extra.min.js"></script>
<script src="js/select/error.js"></script>
</head>
<body>
	<center>
		<h2>
			<font color="#FF0000"> 账户管理</font>
		</h2>
	</center>
	<input type="hidden" id="msg" value=${info[0] } />
	<div class="main-container" id="main-container">

		<div class="page-content">
			<div class="page-header">

				<table class="table table-hover" border="1">
					<!-- 修改区-->
					<ul class="nav nav-tabs">
						<li><a><input type="checkbox" name="allChecked"
								id="allChecked" onClick="DoCheck('c_id')" /> </a>
						</li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown"
							href="javascript:fillHref('SingleServlet','Card','c_id')"> 删除
								<span class="caret"></span> </a></li>
					</ul>
					<!-- 修改区-->
					<thead>
						<tr>

							<td width="9%">银行卡号</td>
							<td width="12%"><div align="center">开户银行</div>
							</td>
							<td width="12%"><div align="center">开户支行</div>
							</td>
							<td width="12%"><div align="center">开户人</div>
							</td>
							<td colspan="3"><div align="center">操作</div>
							</td>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="card" varStatus="st" items="${requestScope.list}">
							<tr>
								<td>
									<div align="left">
										<input type="checkbox" name="c_id" value=${card.c_id }>
										${card.card_id }
									</div>
								</td>
								<td><div align="center">${card.c_type }</div>
								</td>
								<td><div align="center">${card.address }</div>
								</td>
								<td><div align="center">${card.c_owner }</div>
								</td>

								<td width="7%">
									<div align="center">
										<a href="SingleServlet?operate=Card.delete&c_id=${card.c_id }">删除</a>
									</div>
								</td>
								<td width="7%">
									<div align="center">
										<a href="#">修改</a>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<center>
					<ul class="pagination">
						<li><a>共有${page.count}条记录</a>
						</li>
						<li><a>第${page.page}页</a>
						</li>
						<li><a href="QueryServlet?view=Card&firstIndex=1">首页</a>
						</li>
						<li><a
							href="QueryServlet?view=Card&firstIndex=${page.page-1<=1?1:page.page- 1}">
								上一页 </a>
						</li>
						<li><a
							href="QueryServlet?view=Card&firstIndex=${page.page + 1 >=page.lastPage?page.lastPage:page.page + 1}">
								下一页</a>
						</li>
						<li><a
							href="QueryServlet?view=Card&firstIndex=${page.lastPage}"> 末页</a>
						</li>
					</ul>
				</center>
			</div>
		</div>
	</div>
</body>
</html>
