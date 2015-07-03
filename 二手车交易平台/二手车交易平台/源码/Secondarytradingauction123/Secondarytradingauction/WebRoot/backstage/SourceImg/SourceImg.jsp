<%@ page language="java" import="java.util.*" contentType="text/html; charset=GBK"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'source_img_upload.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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

				<table class="table table-hover" border="0">
					<!-- 修改区-->
					<ul class="nav nav-tabs">
						<li><a><input type="checkbox" name="allChecked"
								id="allChecked" onClick="DoCheck('simg_id')" /> </a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown"
							href="javascript:fillHref('SingleServlet','SourceImg','simg_id')"> 删除
								<span class="caret"></span> </a>
						</li>
					</ul>
					<!-- 修改区-->
					<thead>
						<tr>
							<td width="8%">保险公司名称</td>
							<td width="10%"><div align="center">logo</div></td>
							<td colspan="3"><div align="center">操作</div></td>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="logo" varStatus="st" items="${requestScope.list}">
							<tr>
								<td>
		
									<div align="left">
										<input type="checkbox" name="simg_id" value=${logo.simg_id }>
										${logo.simg_name }
									</div></td>
								<td><div align="center"><img src="${logo.simg_path }" height="55" width="140"></img></div></td>

								<td width="7%">
									<div align="center">
										<a href="SingleServlet?operate=SourceImg.delete&c_id=${logo.simg_id }">删除</a>
									</div></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<center>
					<ul class="pagination">
						<li><a>共有${page.count}条记录</a></li>
						<li><a>第${page.page}页</a></li>
						<li><a href="QueryServlet?view=SourceImg&firstIndex=1">首页</a></li>
						<li><a
							href="QueryServlet?view=SourceImg&firstIndex=${page.page-1<=1?1:page.page- 1}">
								上一页 </a></li>
						<li><a
							href="QueryServlet?view=SourceImg&firstIndex=${page.page + 1 >=page.lastPage?page.lastPage:page.page + 1}">
								下一页</a></li>
						<li><a
							href="QueryServlet?view=SourceImg&firstIndex=${page.lastPage}"> 末页</a>
						</li>
					</ul>
				</center>
			</div>
		</div>
	</div>
	
	
	<br />	
	<div>
    <form action="InsureServlet" method="post" ENCTYPE="multipart/form-data">
      <table class="table table-hover"  border="0">
        <tbody>
          <tr>
            <td>保险公司名称：</td>
              <td><input type="text" class="input" name="simg_name"/></td>
              <td> logo：</td>
              <td><input type="file" name="file" class="input" />
		  	 </td>
          </tr>
          <tr>
		    <td colspan="4" align="center">
				<button class="btn btn-large btn-primary" type="submit">确定</button>
				&nbsp;&nbsp;&nbsp;
				<button class="btn btn-large btn-primary" type="button">取消</button>
		    </td>
		  </tr>
        </tbody>
      </table>
      </form>
      <br/>
    </div>
    <script>
    	function check(f) {
    		if(f.simg_name.value == "") {
    			alert("名称不能为空！请输入!");
    			f.simg_name.focus();
    			return false;
    		}
    		return true;
    	}
    	
    </script>
</body>
</html>
