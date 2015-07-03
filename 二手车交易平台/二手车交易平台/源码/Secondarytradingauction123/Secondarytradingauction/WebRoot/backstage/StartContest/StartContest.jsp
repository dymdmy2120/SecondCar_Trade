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
<script src="js/jquery.min.js"></script>
<script src="js/select/startAuction.js"></script>

<script src="js/ace-extra.min.js"></script>
</head>
<body>
	<center>
	<h2>
	<font color="#FF0000">
	拍卖启动管理	</font>	</h2>
</center>
<div class="main-container" id="main-container" >
  
 <div class="page-content" >
  <div class="page-header">
  
  <table class="table table-hover" border="1">
    	
	<thead>
      <tr>
	   <td width="10%"><div align="center">车牌号</div></td>
        <td width="12%">车辆名称</td>
        <td width="9%"><div align="center">关注人数</div></td>
        <td width="9%"><div align="center">申请竞拍人数</div></td>
        <td width="9%"><div align="center">允许竞拍人数</div></td>
        <td width="7%"><div align="center">车辆底价</div></td>
        <td width="7%"><div align="center">车辆加价</div></td>
         <td ><div align="center">竞拍开始时间</div></td>
        <td ><div align="center">竞拍结束时间</div></td>
        <td  width="2%"><div align="center">操作</div></td>
       
	  </tr>
	  </thead>
	  
	  <tbody>
			<c:forEach var="startContest" varStatus="st"
							items="${requestScope.list}">
							<c:choose>
							<c:when test="${startContest.v_id==null}">
							没有可启动拍卖的竞拍车辆。
							</c:when>
						
							</c:choose>
			<tr>
		
		<input type="hidden" id="hidden${startContest.v_id }" value="${startContest.bid_id }"/>
		<input type="hidden" id="allow${startContest.v_id }" value="${startContest.allowCou }"/>
        <td><div align="center">${startContest.plateNo}</div></td>
        <td> <div align="left">${startContest.vname}</div></td>
        <td><div align="center">${startContest.attCou}</div></td>
         <td><div align="center">${startContest.applyCou}</div></td>
        <td><div align="center">${startContest.allowCou}</div></td>
        <td><div align="center">${startContest.bidSpri}</div></td>
        <td><div align="center">${startContest.plusPri}</div></td>
        <td><div align="center">${startContest.bidTime}</div></td>
        <td><div align="center">${startContest.bidEndTime}</div></td>
        	<c:choose>
	  <c:when test="${startContest.beginAuction==0}">
		<td width="10%"> 
		<div align="center" id="start${startContest.v_id}Div"><a href="javascript:void(0)" id="start${startContest.v_id}" value='${startContest.v_id}'>启动拍卖</a> </div>
		</td>
			
			</c:when>
			<c:otherwise>
		<td width="10%">
		<div align="center" id="stop${startContest.v_id}Div"><a href="javascript:void(0)" id="stop${startContest.v_id}" value='${startContest.v_id}'>终止拍卖</a> </div>
		</td>
		</c:otherwise>
			</c:choose>

			</tr>
		</c:forEach>
					</tbody>
  </table>
 <center>
		<ul class="pagination">
			<ul class="pagination">
				<li><a>共有${page.count}条记录</a></li>
				<li><a>第${page.page}页</a></li>
				<li><a href="QueryServlet?view=StartContest&firstIndex=1">首页</a>
				</li>
				<li><a
					href="QueryServlet?view=StartContest&firstIndex=${page.page-1<=1?1:page.page- 1}">
						上一页 </a></li>
				<li><a
					href="QueryServlet?view=StartContest&firstIndex=${page.page + 1 >=page.lastPage?page.lastPage:page.page + 1}">
						下一页</a></li>
				<li><a
					href="QueryServlet?view=StartContest&firstIndex=${page.lastPage}">
						末页</a></li>
			</ul>
		</ul>
	</center>
</div>
</div>
</div>

</body>
</html>
