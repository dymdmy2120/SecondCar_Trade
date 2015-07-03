<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!--[if IE 8 ]> <html class="ie ie8 lte_ie8" lang="zh-CN"> <![endif]-->
<head>
<base href="<%=basePath%>">
<title>咨立拍车-网站</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
  <link type="text/css" href="css/foot.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.min.js"></script>

<script>
	function doblur(id,spanId){
		var textObj = document.getElementById(id);
		if(textObj.value == ""){
			var divId = document.getElementById(spanId);
			divId.style.color ="#FF0000";
		}
    }
	
	function onfocus(spanId){
			var divId = document.getElementById(spanId);
			divId.style.color ="#FFFFFF";
	}
	
	function checkForm4(){
		var filter = /^[A-Za-z0-9]+$/;
		var uid = document.enrolForm.u_id.value;
		if(uid == ""){
			alert("账号不能为空");
			return false;
		}else{
			if(uid.length>16 || uid.length<6){
				alert("账号由6~15位组成，请确认！");
				return false;
			}
		}
		if(filter.test(uid)){
			
		}else{
			alert("账号只能由数字或字母组成！");
			return fasle;
		}
		if(document.enrolForm.tname.value == ""){
			alert("真实姓名不能为空!");
			return false;
		}
		if(document.enrolForm.tel.value == "" ){
			alert("联系电话不能为空！");
			return false;
		}
		if(document.enrolForm.tel.value.length != 11){
			alert("联系电话不为11位！");
			return false;
		}
		var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		var email = document.enrolForm.email.value;
		if(filter.test(email) == false){
			alert("邮箱格式错误！");
			return false;
		}
		if(document.enrolForm.email.value == ""){
			alert("邮箱不能为空！");
			return false;
		}
		if(document.enrolForm.u_address.value == ""){
			alert("地区不能为空！");
			return false;
		}
		if(document.enrolForm.reIntro.value == ""){
			alert("保留信息不能为空!")
			return false;
		}
		if(document.enrolForm.psword.value == ""){
			alert("密码不能为空！");
			return false;
		}
		if(document.enrolForm.psword.value != document.enrolForm.firstPas.value){
			alert("两次密码不相同！");
			return false;
		}
		return true;
	}
	
	$(document).ready(function(){
	  	$("#btnLogin").click(function(){
	  	 if(checkForm4()){
	   		$("#enrolFormid").submit();
	  	 }
  	});
  	});
</script>
<script language="javascript">
		var xmlHttp ;
		var flag = true ;
		function createXMLHttp(){
			if(window.XMLHttpRequest){
				xmlHttp = new XMLHttpRequest() ;
			} else {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP") ;
			}
		}
		function checkUserid(userName){
			createXMLHttp() ;
			xmlHttp.open("POST","LoginServlet?operater=forgetPws.ajax&&u_id="+userName) ;
			xmlHttp.onreadystatechange = checkUseridCallback ;
			xmlHttp.send(null) ;
		}
		function checkUseridCallback(){
			if(xmlHttp.readyState == 4){
				if(xmlHttp.status == 200){
					var text = xmlHttp.responseText ;
					if(text == "true"){	// 用户id已经存在了
						alert("该账号已存在，请换个账号！");
						flag = false ;
					} else {
						flag = true ;
					}
				}
				
			}
		}
	</script>
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
<!-- 头部加上导航栏结束-->

<!-- 内容开始 -->
<div style="width:960px;height:560px;margin:0 auto;margin-left:180px;" >
<hr style= "border: 1px dashed #66F" />
<table style="border-style:dashed;border-width:1px; border-color:#66F;" bordercolor="#66F" width="960" height="500" cellpadding="0" cellspacing="0" align="center" >
  <tr>
    <td width="428">
    	<div  style="border: 1px solid #66F;width:400px;height:450px;">
    	  <form  method="post" name="enrolForm" id="enrolFormid" action="zlpc/enrol" >
    	  <table align="center" width="420" border="0" height="450" cellpadding="0" cellspacing="0">
    	    <tr>
    	      <td height="26" colspan="3"><font size="+2" color="#66F"><b>　　　　　会员注册</b></font></td>
   	        </tr>
    	    <tr>
    	      <td width="94"><font size="-1">　账　　号：</font></td>
    	      <td width="150"><input type="text" name="u_id" id="u_id" size="20" onblur="checkUserid(this.value)" onfocus="document.getElementById('u_idSpan').style.color ='#FFFFFF'" /></td>
    	      <td width="156"><div id="u_idSpan" ><font size="-1" >*6~15位数字或字母组成</font></div></td>
  	      </tr>
    	    <tr>
    	      <td><font size="-1">　昵　　称：</font></td>
    	      <td width="150"><input type="text" name="u_name" size="20" /></td>
    	      <td width="156">&nbsp;</td>
  	        </tr>
    	    <tr>
    	      <td><font size="-1">　真实姓名：</font></td>
    	      <td><input type="text" name="tname" id="tname" size="20" onblur="doblur('tname','tnameSpan')" onfocus="document.getElementById('tnameSpan').style.color ='#FFFFFF'" /></td>
    	      <td><div id="tnameSpan" ><font size="-1" >*必填</font></div></td>
  	      </tr>
    	    <tr>
    	      <td><font size="-1">　身份证号：</font></td>
    	      <td><input type="text" name="cardID" size="20" /></td>
    	      <td>&nbsp;</td>
  	        </tr>
    	    <tr>
    	      <td><font size="-1">　手机号码：</font></td>
    	      <td><input type="text" name="tel" id="tel" size="20" onblur="doblur('tel','telSpan')" onfocus="document.getElementById('telSpan').style.color ='#FFFFFF'" /></td>
    	      <td><div id="telSpan" ><font size="-1" >*必填</font></div></td>
  	      </tr>
    	    <tr>
    	      <td><font size="-1">　邮　　箱：</font></td>
    	      <td><input type="text" name="email" id="email" size="20" onblur="doblur('email','emailSpan')" onfocus="document.getElementById('emailSpan').style.color ='#FFFFFF'" /></td>
    	      <td><div id="emailSpan" ><font size="-1" >*必填</font></div></td>
  	        </tr>
    	    <tr>
    	      <td><font size="-1">　所　在地：</font></td>
    	      <td><input type="text" name="u_address" id="u_address" size="20" onblur="doblur('u_address','u_addressSpan')" onfocus="document.getElementById('u_addressSpan').style.color ='#FFFFFF'" /></td>
    	      <td><div id="u_addressSpan" ><font size="-1" >*省及市填写即可</font></div></td>
  	        </tr>
    	    <tr>
    	      <td><font size="-1">　预留信息:</font></td>
    	      <td><input type="text" name="reIntro" size="20" id="reIntro" onblur="doblur('reIntro','reIntroSpan')" onfocus="document.getElementById('reIntroSpan').style.color ='#FFFFFF'" /></td>
    	      <td><div id="reIntroSpan" ><font size="-1" >*找回密码需要，请牢记</font></div></td>
  	        </tr>
    	    <tr>
    	      <td><font size="-1">　登录密码：</font></td>
    	      <td><input type="password" name="firstPas" id="firstPas" size="20" onblur="doblur('firstPas','firstPasSpan')" onfocus="document.getElementById('firstPasSpan').style.color ='#FFFFFF'" /></td>
    	      <td><div id="firstPasSpan" ><font size="-1" >*必填</font></div></td>
  	        </tr>
    	    <tr>
    	      <td><font size="-1">　确认密码：</font></td>
    	      <td><input type="password" name="psword" size="20" /></td>
    	      <td></td>
  	        </tr>
    	    <tr>
    	      <td>&nbsp;</td>
    	      <td>　　<img src="img/enrolbutton.png" id="btnLogin" /></td>
    	      <td>&nbsp;</td>
  	        </tr>
  	      </table>
       	  </form>
        	
        </div>
    </td>
    <td width="530">
    	<font size="-1" color="#777777">成为有咨立拍车的会员，您才能竞拍到您看中的车辆，若您已经拥有咨立拍车的账号，请直接<a href="login.jsp"><font size="+1"><b>登录</b></font></a>账号。</font>    </td>
  </tr>
</table>
</div>

<!-- 内容结束 -->


<!-- 尾部开始 -->
<jsp:include page="user_file/foot.jsp" flush="true" />
<!-- 尾部结束  -->

</body>
</html>
