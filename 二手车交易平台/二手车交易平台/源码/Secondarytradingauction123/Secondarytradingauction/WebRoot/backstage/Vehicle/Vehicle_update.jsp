
<%@page import="cn.zlpc.dao.BaseDao"%>
<%@page import="cn.zlpc.po.SourceImg"%>
<%@page import="cn.zlpc.po.Vehicle"%>
<%@page import="cn.zlpc.util.ImageUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<title>咨立拍车</title>
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
<link rel="stylesheet" href="css/uploadify.css" />
<link type="text/css" href="css/picture-slides.css" rel="stylesheet" />
<!--[if lte IE 8]>
		  <link rel="stylesheet" href="css/ace-ie.min.css" />
		<![endif]-->
<!-- inline styles related to this page -->
<!-- ace settings handler -->
<script src="js/Calendar4.js"></script>
<script src="js/ace-extra.min.js"></script>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
	var vehicles = [ {
		"key" : "fbrule",
		"value" : '${requestScope.list[0].fbrule}'
	}, {
		"key" : "ftransfer",
		"value" : '${requestScope.list[0].ftransfer}'
	}, {
		"key" : "fbroke",
		"value" : '${requestScope.list[0].fbroke}'
	}, {
		"key" : "fagain",
		"value" : '${requestScope.list[0].fagain}'
	}, {
		"key" : "fmort",
		"value" : '${requestScope.list[0].fmort}'
	}, {
		"key" : "fdisass",
		"value" : '${requestScope.list[0].fdisass}'
	}, {
		"key" : "gear",
		"value" : '${requestScope.list[0].gear}'
	} ,{
		"key" : "v_source",
		"value" : '${requestScope.list[0].v_source}'
	}  ];

	function changeSelected() {

		for ( var i = 0; i < vehicles.length; i++) {

			jsSelectItemByValue(document.getElementById(vehicles[i].key),
					vehicles[i].value);
		}

	}

	function jsSelectItemByValue(objSelect, objItemText) {
		for ( var i = 0; i < objSelect.options.length; i++) {
			if (objSelect.options[i].value == objItemText) {
				objSelect.options[i].selected = true;
				break;
			}
		}
	}

	/**
	 *	实现表单提交
	 */
	function validate(f) {

		if (f.v_id.value == "") {
			alert("车牌号 不能为空");
			f.v_id.focus();
			return false;
		}
		if (f.vname.value == "") {
			alert("车辆名称不能为空");
			f.vname.focus();
			return false;
		}
		var mobile = f.tel.value;
		if (mobile == "") {
			alert("联系方式不能为空");
			f.tel.focus();
			return false;
		}
		if (mobile.length != 11) {
			alert("联系方式错误");
			f.tel.focus();
			return false;
		}
		if (f.pledge.value == "") {
			alert("保证金不能为空");
			f.pledge.focus();
			return false;
		}
	}

	function Test() {
		alert("qwqwqw");
	}
</script>
<script language="javascript">
	var xmlHttp;
	var flag = true;
	function createXMLHttp() {
		if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		} else {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	function deleteImage(imageUrl) {
		if (imageUrl == "img/nophoto.jpg") {
			alert("错误！该图片仅为显示作用！无法删除！");
		} else {
			createXMLHttp();
			xmlHttp.open("POST", "DeleteImageServlet?v_id=" + imageUrl);
			xmlHttp.onreadystatechange = checkUseridCallback;
			xmlHttp.send(null);
		}
	}
	function checkUseridCallback() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				var text = xmlHttp.responseText;
				if (text == "true") { // 用户id已经存在了
					alert("删除成功！");
					window.location.href = "QueryServlet?view=Vehicle&operate=update&queryCondition=v_id&queryValue=${requestScope.list[0].v_id } ";
				} else {
					alert("删除失败！");
					flag = true;
				}
			}

		}
	}
</script>
</head>
<body onload="changeSelected()">
	<center>
		<h2>
			<font color="#FF0000"> 修改车辆信息</font>
		</h2>
	</center>

	<div class="main-container" id="main-container">

		<div class="page-content">
			<div class="page-header">

				<form id="vehicleAdd" action="SingleServlet?operate=Vehicle.update"
					method="post" onsubmit="return validate(this)"
					enctype="multipart/form-data">

					<table class="table table-hover" border="0">

						<tbody>
							<tr>
								<input type="hidden" class="input" name="v_id" id="v_id"
									value=${requestScope.list[0].v_id } readonly>
								<td>&nbsp;车牌号：</td>
								<td><input type="text" class="input" name="plateNo"
									id="plateNo" value=${requestScope.list[0].plateNo }>
								</td>
								<td>车辆名称：</td>
								<td><input type="text" class="input" name="vname"
									value=${requestScope.list[0].vname}>
								</td>
								<td>停放地点：</td>
								<td><input type="text" class="input" name="loc"
									value=${requestScope.list[0].loc}>
								</td>
							</tr>
							<tr>
								<td>车辆型号：</td>
								<td><input type="text" class="input" name="v_version"
									value=${requestScope.list[0].v_version }>
								</td>
								<td>车辆档位：</td>
								<td><select name="gear" id="gear">
										<option value="1">自动挡</option>

										<option value="0">手动挡</option>

										<option value="2">手动自动挡</option>
								</select></td>
								<td>&nbsp;车架号：</td>
								<td><input type="text" class="input" name="vframe"
									value=${requestScope.list[0].vframe }>
								</td>
							</tr>
							<tr>
								<td>&nbsp;发动机：
									<td><input type="text" class="input" name="motor"
										value=${requestScope.list[0].motor }>
								</td>
								<td>&nbsp;变速箱：</td>
								<td><input type="text" class="input" name="gearBox"
									value=${requestScope.list[0].gearBox }>
								</td>
								<td>&nbsp;&nbsp;排量：</td>
								<td><input type="text" class="input" name="output"
									value=${requestScope.list[0].output }>
								</td>
							</tr>
							<tr>
								<td>&nbsp;主气囊：</td>
								<td><input type="text" class="input" name="mairSac"
									value=${requestScope.list[0].mairSac }>
								</td>
								<td>&nbsp;副气囊：</td>
								<td><input type="text" class="input" name="sairSac"
									value=${requestScope.list[0].sairSac }>
								</td>
								<td>联系方式：</td>
								<td><input type="text" class="input" name="tel"
									value=${requestScope.list[0].tel}>
								</td>
							</tr>
							<tr>
								<td>车辆来源：</td>
								<td><input type="text" class="input" name="source"
									value=${requestScope.list[0].source }>
								</td>
								<td>初级登记时间：</td>
								<td><input type="text" class="input"
									onclick="MyCalendar.SetDate(this)" name="regTime"
									value="<fmt:formatDate pattern="yyyy-MM-dd"
										value="${requestScope.list[0].regTime }" type="both" />" />
								</td>
								<td>保证金：</td>
								<td><input type="text" class="input" name="pledge"
									value=${requestScope.list[0].pledge }>
								</td>
							</tr>
							<tr>
								<td>是否过户：</td>
								<td><select name="ftransfer" id="ftransfer">
										<option value="1">是</option>
										<option value="0">否</option>
								</select></td>

								<td>是否拆解：</td>
								<td><select name="fdisass" id="fdisass">
										<option value="1">是</option>
										<option value="0">否</option>
								</select></td>
								<td>是否有二次事故：</td>
								<td><select name="fagain" id="fagain">
										<option value="1">是</option>
										<option value="0">否</option>
								</select></td>
							</tr>
							<tr>
								<td>是否违章：</td>
								<td><select name="fbrule" id="fbrule">
										<option value="1">是</option>
										<option value="0">否</option>
								</select></td>
								<td>是否抵押：</td>
								<td><select name="fmort" id="fmort">
										<option value="1">是</option>
										<option value="0">否</option>
								</select></td>
								<td>车架是否受损：</td>
								<td><select name="fbroke" id="fbroke">
										<option value="1">是</option>
										<option value="0">否</option>
								</select></td>

							</tr>
							</form>
							<tr>
								<td>来源(保险):</td>
								 
								<td><select name="v_source">
								<%
						          	List<Object> list2 = new BaseDao().queryForSingle(
											SourceImg.class, 0, 0, null, null, null, false);
						          	if(list2.size() == 0) {
						          		SourceImg si = new SourceImg();
						          		si.setSimg_name("不存在，请添加！");
						          		list2.add(si);
						          	}
						          	request.setAttribute("list2", list2);
						          %>
							   		 <c:forEach var="si" varStatus="st" items="${requestScope.list2}">
							   				<option value="${si.simg_path }">${si.simg_name }</option>
							   				</c:forEach>
							   			</select>
								  </td>
								<td colspan="2">车辆图片上传：<input type="file" name="picture"
									id="picture" multiple /></td>
								<td colspan="2">注意事项:<textarea rows="2" cols="60"
										placeholder="拖动右下角,可以调节输入框大小" name="note"></textarea></td>
							</tr>
							<tr>
								<td colspan="3" align="center"><button class="btn btn-large btn-primary"
										id="btnSubmit" type="submit">确定</button>
								</td>
								<td colspan="3" ><a href="mainfra.jsp"></a>
									<button class="btn btn-large btn-primary" type="button">取消</button>
									</a>
								</td>
							</tr>
							<%
								List<Object> list = (List<Object>)request.getAttribute("list");
													Vehicle v = (Vehicle)list.get(0);
													List<String>  imageList = ImageUtil.getImage(ImageUtil.GET_PATH+v.getV_id()+"\\", ImageUtil.SHOW_PATH+v.getV_id()+"/");
													if(imageList.size() == 0 ) {
														imageList.add("img/nophoto.jpg");
													}
													request.setAttribute("imageList", imageList);
							%>
						</tbody>
					</table>
					<br />
					<div id="div2">
						<h4>已上传图片：</h4>
						<ul class="picture-slides-thumbnails">
							<c:forEach var="entry" items="${imageList}">
								<li><img src="${entry}" alt="车辆图片" height="90" width="80" />
									<font size="+1" class="btn btn-large btn-primary"
									onClick="deleteImage('${entry}')">删除图片</font>
								</li>
							</c:forEach>
						</ul>
					</div>
			</div>
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
	</div>
</body>
</html>
