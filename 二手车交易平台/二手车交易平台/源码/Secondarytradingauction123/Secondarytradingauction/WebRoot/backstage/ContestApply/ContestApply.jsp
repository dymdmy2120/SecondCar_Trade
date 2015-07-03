<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
<script src="js/select/check.js"></script>
<script src="js/ace-extra.min.js"></script>
<script src="js/select/query.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/select/error.js"></script>
</head>
<body>
	<center>
		<h2>
			<font color="#FF0000"> 批准竞拍申请 </font>
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
								id="allChecked" onClick="DoCheck('u_id')" /> </a>
						</li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown"
							href="javascript:fillAgree('UserDeleteServlet','ContestApply','u_id' ,'1')">
								批准 <span class="caret"></span> </a></li>
						<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
						<li><a><input type="checkbox" name="allChecked"
								id="allChecked" onClick="DoCheck('u_id')" /> </a>
						</li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown"
							href="javascript:fillAgree('UserDeleteServlet','ContestApply','u_id' , '0')">
								不批准 <span class="caret"></span> </a></li>
						<form action="" id="start" method="post"></form>
						<span style="display:block;text-align:right;"> <select
							id="select" onChange="select()">
								<option value="u_id">按会员账号搜索</option>
								<option value="tname">按会员名搜索</option>
								<option value="r_rank">按会员级别搜索</option>
						</select> <input type="text" placeholder="Search" id="queryInput"
							name="u_id"> <a href="javascript:start('ContestApply')"
							role="button"><i class="icon-search">搜索</i> </a> </span>
					</ul>

					<!-- 修改区-->
					<thead>
						<tr>
							<td width="9%">会员账号</td>
							<td width="9%">会员名</td>
							<td width="12%"><div align="center">会员级别</div>
							</td>
							<td width="12%"><div align="center">待竞拍车辆名称</div>
							</td>
							<td width="11%"><div align="center">待竞拍车辆车牌号</div>
							</td>
							<td width="9%"><div align="center">待竞拍底价</div>
							</td>
							<td width="10%"><div align="center">待竞拍车辆加价</div>
							</td>
							<td colspan="2"><div align="center">操作</div>
							</td>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="contestApply" varStatus="st"
							items="${requestScope.list}">
							<tr>

								<td>
									<div align="left">
										<input type="checkbox" name="u_id" value=${contestApply.u_id },${contestApply.v_id }>${contestApply.u_id
										}
									</div>
								</td>
								<td><div align="center">${contestApply.tname}</div>
								</td>
								<td><div align="center">${contestApply.rank}</div>
								</td>
								<td><div align="center">${contestApply.vname}</div>
								</td>
								<td><div align="center">${contestApply.plateNo}</div>
								</td>
								<td><div align="center">${contestApply.bidSpri}</div>
								</td>
								<td><div align="center">${contestApply.plusPri}</div>
								</td>
								<td width="15%">
									<div align="center">
										<a href="UserDeleteServlet?u_id=${contestApply.u_id },${contestApply.v_id }&operate=ContestApply&state=1">批准</a>
									</div>
								</td>
								<td width="9%"><div align="center">
										<a data-toggle="modal" href="UserDeleteServlet?u_id=${contestApply.u_id },${contestApply.v_id }&operate=ContestApply&state=0">不批准</a>
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
						<li><a href="QueryServlet?view=ContestApply&firstIndex=1">首页</a>
						</li>
						<li><a
							href="QueryServlet?view=ContestApply&firstIndex=${page.page-1<=1?1:page.page- 1}">
								上一页 </a>
						</li>
						<li><a
							href="QueryServlet?view=ContestApply&firstIndex=${page.page + 1 >=page.lastPage?page.lastPage:page.page + 1}">
								下一页</a>
						</li>
						<li><a
							href="QueryServlet?view=ContestApply&firstIndex=${page.lastPage}">
								末页</a>
						</li>
					</ul>
				</center>
			</div>
		</div>
	</div>
</body>
</html>
