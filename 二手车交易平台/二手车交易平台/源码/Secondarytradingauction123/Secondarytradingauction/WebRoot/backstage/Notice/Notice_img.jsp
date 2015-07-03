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
<title>蓝点暑假项目</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- basic styles -->
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
<!--[if IE 7]>
		  <link rel="stylesheet" href="css/font-awesome-ie7.min.css" />
		<![endif]-->
<!-- page specific plugin styles -->
<!-- fonts -->
<!-- ace styles -->
<link rel="stylesheet" href="css/ace.min.css" />
<link rel="stylesheet" href="css/ace-rtl.min.css" />
<link rel="stylesheet" href="css/ace-skins.min.css" />
<!--[if lte IE 8]>
		  <link rel="stylesheet" href="css/ace-ie.min.css" />
		<![endif]-->
<!-- inline styles related to this page -->
<!-- ace settings handler -->
<script src="js/ace-extra.min.js"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
		<script src="js/respond.min.js"></script>
		<![endif]-->
</head>
<body>
	<center>
		<h2>
			<font color="#FF0000">公告图片上传</font>
		</h2>
	</center>
<div class="main-container" id="main-container">
  <div class="page-content">
    <div class="page-header">
    <form action="#" method="post">
      <table class="table table-hover"  border="0">
        <tbody>
          <tr>
            <td>公告图片上传：
              <input type="file" /></td>
          </tr>
		 </tr>
          </tr>
		    <td>
				<button class="btn btn-large btn-primary" type="button">确定</button>
				&nbsp;&nbsp;&nbsp;
				<button class="btn btn-large btn-primary" type="button">取消</button>
		    </td>
		  </tr>
        </tbody>
      </table>
      </form>
      <br/>
    </div>
  </div>
</div>
</div>
</body>
</html>
