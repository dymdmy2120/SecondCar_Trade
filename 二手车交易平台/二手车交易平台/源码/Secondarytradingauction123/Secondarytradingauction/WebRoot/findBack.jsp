<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<title>咨立拍车</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
  <link type="text/css" href="css/foot.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.min.js"></script>

<script>
	function checkForm(){
		var firstPas = document.getElementById("firstPas").value;
		
		if(firstPas == ""){
			alert("请填写密码！");
			return false;
		}
		var secondPas = document.getElementById("secondPas").value;
		if(secondPas == ""){
			alert("请再次确认密码！");
			return false;
		}
		if(firstPas != secondPas){
			alert("两次密码不同,请再次核对！");
			return false;
		}
		return true;
	}
	$(document).ready(function(){
	  	$("#btnFind").click(function(){
		   if(checkForm()){
		   	$("#AlterForm").submit();
		   }else{
		   }
  		});
  	});
</script>
</head>
<script src="js/select/error.js"></script>
</head>
<body>
		
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
<input type="hidden" id="msg" value=${info[0] } />

<!-- 头部加上导航栏结束-->

<!-- 内容开始 -->
<div style="width:960px;height:400px;margin:0 auto;" >
<hr style= "border: 1px dashed #66F" />

<table style="border-style:dashed;border-width:1px; border-color:#66F;" bordercolor="#66F" width="960" height="360" cellpadding="0" cellspacing="0" align="center" >
  <tr>
    <td width="440">
    	<div  style="border: 1px solid #66F;width:350px;height:250px;">
      <form  method="post" name="AlterForm" id="AlterForm" action="zlpc/findBack" onsubmit="javascript:return checkForm()" >
    	  <table align="center" width="340" border="0" height="174" cellpadding="0" cellspacing="0">
    	    <tr>
    	      <td height="26" colspan="3"><font size="+2" color="#66F"><b>　　　　重置密码</b></font></td>
   	        </tr>
    	    <tr>
    	      <td width="80"><font size="-1">新密　码：</font></td>
    	      <td width="172"><input type="password" id="firstPas" size="20" /></td>
    	      <td width="88">&nbsp;</td>
  	      </tr>
    	    <tr>
    	      <td height="39"><font size="-1">再次确认：</font></td>
    	      <td colspan="2"><input type="password" name="psword" id="secondPas" size="20" /></td>
   	        </tr>
    	    <tr>
    	      <td height="40">&nbsp;</td>
    	      <td colspan="2"> <img id="btnFind" src="img/forgetPaButton.png" /></td>
  	        </tr>
  	      </table>
        	</form>
        </div>
    </td>
    <td width="518">
    	<font size="-1" color="#777777">成为有咨立拍车的会员，您才能竞拍到您看中的车辆，若您还没有咨立拍车的账号，请先<a href="register"><font size="+1"><b>注册</b></font></a>账号。</font>
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
