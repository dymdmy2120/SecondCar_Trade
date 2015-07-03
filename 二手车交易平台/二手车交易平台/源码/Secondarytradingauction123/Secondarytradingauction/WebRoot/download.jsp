<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'download.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body align="center">
    <a href="http://mydown.yesky.com/soft/309/33948309.shtml" target="blank"> 360浏览器下载地址</a>&nbsp;&nbsp;&nbsp;
     <a href="http://rj.baidu.com/soft/detail/11843.html?ald" target="blank"> 火狐浏览器下载地址</a>&nbsp;&nbsp;&nbsp;
      <a href="http://rj.baidu.com/soft/detail/14744.html?ald" target="blank"> 谷歌浏览器下载地址</a>
  </body>
</html>
