<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8" />
<title>蓝点暑假项目</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
<link rel="stylesheet" href="css/ace.min.css" />
<link rel="stylesheet" href="css/ace-rtl.min.css" />
<link rel="stylesheet" href="css/ace-skins.min.css" />
<script src="js/ace-extra.min.js"></script>
<script src="js/select/check.js"></script>
<script src="js/select/query.js"></script>
<script src="js/select/error.js"></script>
<script src="js/ace-extra.min.js"></script>

</head>
<body>
	<center>
		<h2>
			<font color="#FF0000"> 佣金比例和竞拍低价设定 </font>
		</h2>
	</center>
	<input type="hidden" id="msg" value=${info[0] } />
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<div class="page-content">
			<div class="page-header">
				<table class="table table-hover" border="1">
					<thead>
						<tr>

							<td width="9%" align="center">会员身份</td>
							<td width="12%"><div align="center">竞拍限额</div></td>
							<td width="12%"><div align="center">竞拍佣金比例</div></td>
							<td colspan="2"><div align="center">操作</div></td>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="rank" varStatus="st" items="${requestScope.list}">
							<form
								action="SingleServlet?operate=Rank.update&r_rank=${rank.r_rank }"
								method="post" onSubmit="return checkForm(this)">
								<tr>
									<td>
										<div align="center">${rank.r_rank==0? "普通会员" : "VIP" }</div>
									</td>
									<td><div align="center">
											<input type="text" class="input" name="r_range"
												value="${rank.r_range }" />
										</div></td>
									<td><div align="center">
											<input type="text" class="input" name="r_cmsion"
												value="${rank.r_cmsion }" />%
										</div></td>
									<td width="15%">
										<div align="center">
											<input type="submit" value="设定" ) />
										</div></td>
									</td>
								</tr>
							</form>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
<script type="text/javascript">
	function checkForm(form) {
		if (!(/^\d+$/.test(form.r_range.value))) {
			alert("错误!竞拍限额必须为数字!");
			return false;
		}
		if (!(/^\d+$/.test(form.r_cmsion.value))) {
			alert("错误!竞拍佣金比例必须为数字!");
			return false;
		}
		if(!(form.r_cmsion.value>0 && form.r_cmsion.value<=100)) {
			alert("错误!竞拍佣金比例只能在1-100之间");
			return false;
		}
		return true;
	}
</script>
</body>
</html>
