<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注销</title>
    <meta http-equiv="refresh" content="1;URL=http://www.zlpaiche.com">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%
  if(session.getAttribute("user")==null){%>
   <center>
		<font size="+2" color="#E82030">您还没有登入，请先登入....</font>
	</center>
  <% }else{%> 
     <center>
		<font size="+2" color="#E82030"> 注销中...</font>
	</center>
     	<% session.invalidate();
  }
  %>
  </body>
</html>
