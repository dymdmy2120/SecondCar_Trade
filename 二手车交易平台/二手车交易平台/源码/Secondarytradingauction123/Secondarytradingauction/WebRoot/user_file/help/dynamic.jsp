<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhstml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>最新动态</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body style=" margin:0px; width:266px">
	<div class="nri">
		<div class="to1">&nbsp;最新动态</div>
		<div class="mi1">
			<ul>
	<c:forEach var="notice" varStatus="st"
							items="${requestScope.list}">
							<strong>
				<li><a href="notice/${notice.n_id }.html" tppabs="#"  title="${notice.title} ">
						${notice.title}</a>【<span class="date" style="font-size: 10px"><fmt:formatDate pattern="yyyy年MM月dd日"
										value="${notice.n_time }" type="both" />】</span>
				</li></strong>
				</c:forEach>
			</ul>
			
		</div>
	</div>
	<p>&nbsp;</p>
	<div style="width: 280px; margin-top: -50px;">
		<p>&nbsp;</p>
		<p>
			<a href="paimai.html" target="_parent"
				tppabs="#"><img src="img/link1.jpg" width="280"
				height="180px" />
			</a>
		</p>
	</div>
	</div>
	</div>
</body>
</html>
