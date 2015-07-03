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
<meta charset="utf-8" />
<base href="<%=basePath%>">
<title>蓝点暑假项目</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
<link rel="stylesheet" href="css/ace.min.css" />
<link rel="stylesheet" href="css/ace-rtl.min.css" />
<link rel="stylesheet" href="css/ace-skins.min.css" />
<script src="js/ace-extra.min.js"></script>
<script src="js/select/check.js"></script>
<script src="js/select/query.js"></script>
<script src="js/jquery.min.js"></script>
</head>
<body>
	<center>
		<h2>
			<font color="#FF0000"> 车辆信息</font>
		</h2>
	</center>

	<div class="main-container" id="main-container">

		<div class="page-content">
			<div class="page-header">
				<table class="table table-hover" border="1">
					<!-- 修改区-->
					<ul class="nav nav-tabs">
						<li><a><input type="checkbox" name="allChecked"
								id="allChecked" onClick="DoCheck('v_id')" /> </a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown"
							href="javascript:fillHref('null','Vehicle','v_id')"> 删除 <span
								class="caret"></span> </a>
						</li>
						<!-- 表单搜索 -->
							<form action="" id="start" method="post">
							<span style="display:block;text-align:right;">
							 <select id="select" onChange="select()">
								 <option value="plateNo">按车牌号搜索</option>
							 </select> 
							<input type="text" placeholder="Search" id="queryInput"
								name="plateNo"> 
								<a href="javascript:start('Vehicle')"
								role="button"><i class="icon-search">搜索</i> </a> </span>
							</form>
						<!-- 表单搜索 -->
					</ul>
					<!-- 修改区-->
					<thead>
						<tr>
							<td width="7%">车牌号</td>
							<td width="5%"><div align="center">停放地点</div>
							</td>
							<td width="5%"><div align="center">车辆名称</div>
							</td>
							<td width="5%"><div align="center">保证金</div>
							</td>
							<td width="5%"><div align="center">车辆型号</div>
							</td>
							<td width="5%"><div align="center">档位</div>
							</td>
							<td width="8%"><div align="center">初次登记时间</div>
							</td>
							<td width="5%"><div align="center">车架号</div>
							</td>
							
							<td width="5%"><div align="center">联系方式</div>
							</td>
							<td width="5%"><div align="center">车辆来源</div>
							</td>
							<td width="5%"><div align="center">来源（保险）</div>
							</td>
							<td width="5%"><div align="center">注意事项</div>
							</td>
							<td width="9%"><div align="center">说明</div>
							</td>
							<td width="5%" colspan="2"><div align="center">操作</div>
							</td>
						</tr>
					</thead>

					<tbody>
						  <c:forEach var="vehicle" varStatus="st" 	items="${requestScope.list}">
						 	<%--<fmt:formatDate value='${date }' type="date" dateStyle="default" var="regTime" />
							--%><tr>
								<td>
									<div align="left">
										<input type="checkbox" name="v_id" value=${vehicle.v_id}>${vehicle.plateNo
										}
									</div>
								</td>
								<td><div align="center">${vehicle.loc }</div>
								</td>
								<td><div align="center">${vehicle.vname }</div>
								</td>
								<td><div align="center">${vehicle.pledge }</div>
								</td>
								<td><div align="center">${vehicle.v_version }</div>
								</td>
								<td><div align="center">${vehicle.gear == 0? "手动挡" : (vehicle.gear == 1 ?"自动挡" : (vehicle.gear == 2?"手动自动挡" : "")) }</div>
								</td>
								<td>
								<div align="center">
								<fmt:formatDate pattern="yyyy-MM-dd"
										value="${vehicle.regTime }" type="both" />
									
								</div>
								</td>
								<td><div align="center">${vehicle.vframe }</div>
								</td>
								
								
								
								<td><div align="center">${vehicle.tel }</div>
								</td>
								<td><div align="center">${vehicle.source }</div>
								</td>
								<td><div align="center"><img src="${vehicle.v_source }" width="60" height="50"></img></div>
								</td>
								<td><div align="center">${vehicle.note }</div>
								</td>
								<td><div align="center">更多信息请点击修改界面查看</div>
								</td>
								<td width="4%">
									<div align="center">
										<a href="QueryServlet?view=Vehicle&operate=update&queryCondition=v_id&queryValue=${vehicle.v_id} ">修改</a>
									</div>
								</td>
								<td width="4%"><div align="center">
										<a href="SingleServlet?operate=Vehicle.delete&v_id=${vehicle.v_id}">删除</a>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<center>
					<ul class="pagination">
						<li><a>共有${page.count}条记录</a></li>
						<li><a>第${page.page}页</a></li>	
						<li><a href="QueryServlet?view=Vehicle&firstIndex=1">首页</a></li>
						<li><a
							href="QueryServlet?view=Vehicle&firstIndex=${page.page-1<=1?1:page.page- 1}">
								上一页 </a></li>
						<li><a
							href="QueryServlet?view=Vehicle&firstIndex=${page.page + 1 >=page.lastPage?page.lastPage:page.page + 1}">
								下一页</a></li>
						<li><a
							href="QueryServlet?view=Vehicle&firstIndex=${page.lastPage}">
								末页</a></li>
					</ul>
				</center>
			</div>
		</div>
	</div>

</body>
</html>
