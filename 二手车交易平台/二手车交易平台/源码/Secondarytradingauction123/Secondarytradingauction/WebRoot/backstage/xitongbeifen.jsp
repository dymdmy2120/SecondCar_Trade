<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8" />
		 <meta charset="utf-8" />
        <title>
            蓝点暑假项目
        </title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"
        />
        
        <link rel="stylesheet" href="css/font-awesome.min.css" />
          <link href="css/bootstrap.css" rel="stylesheet">
    
      
        <link rel="stylesheet" href="css/ace.min.css" />
        <link rel="stylesheet" href="css/ace-rtl.min.css" />
        <link rel="stylesheet" href="css/ace-skins.min.css" />
       
        <script type="text/javascript" src="js/ace-extra.min.js"></script>
        <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="js/lab2.js"></script>
  
</head>

<body>
	 <center>
		<h2>
			<font color="#FF0000">
				系统数据备份
			</font>	
		</h2>
	</center>
	<hr />
<div class="main-container" id="main-container">    
   
	<br  />&nbsp;&nbsp;&nbsp;<button class="btn btn-large btn-primary" type="button">备份全部</button> 
</div>
	
</body>


</html>
