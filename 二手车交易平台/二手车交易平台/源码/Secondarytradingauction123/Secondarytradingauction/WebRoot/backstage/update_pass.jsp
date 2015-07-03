<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>密码修改</title>

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
<script src="js/ace-extra.min.js"></script>
<script language="javascript">
	function checkForm(f) {
		if(f.password.value == f.password1.value) {
			alert("新密码不能和原始密码一致！");
			f.password1.focus();
			return false;
		}
		if(f.password1.value != f.password2.value) {
			alert("两次输入密码不一致！");
			f.password2.focus();
			return false;
		}
		if (!(/^\w{6,16}$/.test(f.password.value))) {
			alert("密码必须为6-16位！");
			f.password.focus();
			return false;
		}
		if (!(/^\w{6,16}$/.test(f.password1.value))) {
			alert("密码必须为6-16位！");
			f.password1.focus();
			return false;
		}
		if (!(/^\w{6,16}$/.test(f.password2.value))) {
			alert("密码必须为6-16位！");
			f.password2.focus();
			return false;
		}
	
		return true;
	}
</script>
<script src="js/select/error.js"></script>
</head>
<body>
<input type="hidden" id="msg" value=${info[0] } />
	<div class="main-container" id="main-container">
		<div class="main-container" id="main-container">
			<div class="page-content">
				<!-- /.page-header -->
				<br />
				<form action="AdminUpdatePass" method="post" onSubmit="return checkForm(this)">
					<center>
						<table height="196" border="0" class="table-hover">
							<tbody>
								<tr>
									<h1>
										<font color="#F00">密码修改</font>
									</h1>
								</tr>
								<tr>
									<td width="177"><strong>
											<center>&nbsp;原始密码:</center> </strong></td>
									<td width="330"><input type="password" name="password"
										class="form-control" required autofocus style="height:auto" />
									</td>
								</tr>
								<tr>
									<td width="177"><strong>
											<center>&nbsp;请输入密码:</center> </strong></td>
									<td width="330"><input type="password" name="password1"
										class="form-control" required autofocus style="height:auto" />
									</td>
								</tr>
								<tr>
									<td width="177"><strong>
											<center>请再次输入密码：</center> </strong></td>
									<td width="330"><input type="password" name="password2"
										class="form-control" required autofocus style="height:auto" />
									</td>
								</tr>
								<tr>
									<td width="177"><strong>
											<center>确认超级管理员密码：</center> </strong></td>
									<td width="330"><input type="password" name="superword"
										class="form-control" required autofocus style="height:auto" />
									</td>
								</tr>
							</tbody>
						</table>
						<p align="center">&nbsp;</p>
						<div align="center">
							<!-- <a href="user_file/User/User_User_mibao_update.jsp">
                      <button class="btn btn-primary"> 确认修改    </button> 
                      </a>      -->
							<input type="submit" value="确认修改" class="btn btn-primary">
						</div>
					</center>
				</form>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div>
		<!-- /.col -->
	</div>
</body>
</html>
