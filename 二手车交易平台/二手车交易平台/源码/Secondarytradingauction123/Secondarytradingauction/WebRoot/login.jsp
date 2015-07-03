<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!--[if IE 8 ]> <html class="ie ie8 lte_ie8" lang="zh-CN"> <![endif]-->
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>咨立拍车-网站</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="css/foot.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.min.js"></script>

<script>
	function doblur(id, spanId) {
		var textObj = document.getElementById(id);
		if (textObj.value == "") {
			var divId = document.getElementById(spanId);
			divId.style.visibility = "visible";
		}
	}

	function onfocus(spanId) {
		alert('id');
		var divId = document.getElementById(spanId);
		alert(divId);
		divId.style.visibility = "hidden";
	}

	function checkForm(f) {
		if (f.u_id.value == "") {
			alert("请输入账号！");
			return false;
		}
		if (f.psword.value == "") {
			alert("请输入密码！");
			return false;
		}
		return true;
	}
	$(document).ready(function() {
		$("#btnLogin").click(function() {
			$("#form1").submit();
		});
	});
</script>
<script src="js/select/error.js"></script>
</head>
<body>
	<input type="hidden" id="msg" value=${info[0] } />
	<jsp:include page="user_file/top.jsp" flush="true" />
	<div class="menu_navcc">
		<div class="menu_nav clearfix">
			<ul class="nav_content" id="nav">
				<li class="current"><a href="index.html" title="首页"> <span>
							首页 </span> </a>
				</li>
					<li><a href="paimai.html"
					title="网络拍卖"> <span> 网络拍卖 </span>
				</a></li>
				<li><a href="user.html" title="会员中心"> <span>
							会员中心 </span> </a>
				</li>
				<li><a href="#" title="VIP大厅"> <span> VIP大厅 </span> </a>
				</li>

				<li><a href="ypgonggao.html"
					title="预拍公告"> <span> 预拍公告 </span> </a>
				</li>
				<li><a href="Notice_front.html" title="帮助中心"> <span>
							帮助中心 </span> </a>
				</li>
				<li><a href="company.html" title="公司简介">
						<span> 关于我们 </span> </a>
				</li>
			</ul>
			<div class="menu_nav_right"></div>
		</div>
	</div>
	<!-- 头部加上导航栏结束-->

	<!-- 内容开始 -->

	<div style="width:960px;height:400px;margin:0 auto; margin-left:180px;">
		<hr style="border: 1px dashed #66F" />
		<table
			style="border-style:dashed;border-width:1px; border-color:#66F;"
			bordercolor="#66F" width="960" height="360" cellpadding="0"
			cellspacing="0" align="center">
			<tr>
				<td width="440">
					<div style="border: 1px solid #66F;width:350px;height:250px;">
						<form method="post" name="loginForm2"
							action="zlpc/login" id="form1"
							onsubmit="javascript:return checkForm(this)">
							<table align="center" width="340" border="0" height="220"
								cellpadding="0" cellspacing="0">
								<tr>
									<td height="26" colspan="3"><font size="+2" color="#66F"><b>　　　　　会员登录</b> </font>
									</td>
								</tr>
								<tr>
									<td width="80"><font size="-1"> 　　　账 号</font>
									</td>
									<td width="172"><input type="text" size="20" name="u_id"
										id="uid" onblur="doblur('uid','uidSpan')"
										onfocus="document.getElementById('uidSpan').style.visibility='hidden'" />
									</td>
									<td width="88"><div id="uidSpan" style="visibility:hidden">
											<font size="-1" color="#FF0000">此处不能为空</font>
										</div>
									</td>
								</tr>
								<tr>
									<td><font size="-1"> 　　　密 码</font>
									</td>
									<td><input type="password" name="psword" size="20" />
									</td>
									<td><a href="login/forget"><font size="-1">忘记密码？</font>
									</a>
									</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td>　　　<img src="img/loginbutton.png" id="btnLogin" />
									</td>
									<td>&nbsp;</td>
								</tr>
							</table>
						</form>
					</div></td>
				<td width="518"><font size="-1" color="#777777">成为有咨立拍车的会员，您才能竞拍到您看中的车辆，若您还没有咨立拍车的账号，请先<a
						href="register"><b><font size="+1">注册</font> </b> </a>账号。 </font>
				</td>
			</tr>
		</table>
	</div>

	<!-- 内容结束 -->


	<!-- 尾部开始 -->
	<jsp:include page="user_file/foot.jsp" flush="true" />
	<!-- 尾部结束  -->

</body>
</html>
