
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左部</title>
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
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<ul class="nav nav-list">
			<li class="active"><a href="backstage/mainfra.jsp" target="mainFrame">
					<i class="icon-home"></i> <span class="menu-text">首页</span> </a>
			</li>
			<li><a> <i class="icon-user"></i> <span class="menu-text">会员管理</span>
			</a>
				<ul class="nav nav-list " style="display:none" id="huiyuan">
					<li>
						<div align="center">
							<a href="QueryServlet?view=UserDelete" target="mainFrame">
								<i class="icon-plus"></i> <span class="menu-text"><strong>会员信息</strong>
							</span> </a>
						</div>
					</li>
					<li>
						<div align="center">
							<a href="QueryServlet?view=Rank" target="mainFrame"> <i
								class="icon-edit"></i> <span class="menu-text"><strong>底价和佣金比例设定</strong>
							</span> </a>
						</div>
					</li>
					<li>
						<div align="center">
							<a href="QueryServlet?view=ContestApply" target="mainFrame"> <i
								class="icon-edit"></i> <span class="menu-text"><strong>批准竞拍申请</strong>
							</span> </a>
						</div>
					</li>
					<li></li>
				</ul>
			</li>

			<li><a> <i class="icon-user"></i> <span class="menu-text">拍卖管理</span>
			</a>
				<ul class="nav nav-list " style="display:none" id="paimai">
					<li>
						<div align="center">
							<a href="QueryServlet?view=AuctionTimeSetting" target="mainFrame"> <i
								class="icon-plus"></i> <span class="menu-text"><strong>竞拍时间设定</strong>
							</span> </a>
						</div>
					</li>
					<li></li>
					<li>
						<div align="center">
							<a href="QueryServlet?view=StartContest" target="mainFrame"> <i
								class="icon-plus"></i> <span class="menu-text"><strong>拍卖启动</strong>
							</span> </a>
						</div>
					</li>
					<li>
					</li>
				</ul>
			</li>

			<!-- 车辆管理 -->
			<li><a> <i class="icon-user"></i> <span class="menu-text">车辆管理</span>
			</a>
				<ul class="nav nav-list " style="display:none" id="cheliang">
					<li>
						<div align="center">
							<a href="QueryServlet?view=Vehicle" target="mainFrame"> <i
								class="icon-plus"></i> <span class="menu-text"><strong>车辆信息</strong>
							</span> </a>
						</div>
					</li>
					<li></li>
					<li>
						<div align="center">
							<a href="backstage/Vehicle/Vehicle_add.jsp" target="mainFrame">
								<i class="icon-plus"></i> <span class="menu-text"><strong>添加车辆信息</strong>
							</span> </a>
						</div>
					</li>
					<li>
						<div align="center">
							<a href="QueryServlet?view=BusinessBooks" target="mainFrame">
								<i class="icon-edit"></i> <span class="menu-text"><strong>导出车辆Excel表</strong>
							</span> </a>
						</div>
					</li>
					<li>
						<div align="center">
							<a href="QueryServlet?view=SourceImg" target="mainFrame">
								<i class="icon-edit"></i> <span class="menu-text"><strong>保险来源图片上传</strong>
							</span> </a>
						</div>
					</li>
				</ul>
			</li>
			<!-- 车辆管理 -->
			<!-- 公告管理 -->
			<li><a> <i class="icon-list-alt"></i> <span
					class="menu-text">公告管理</span> </a>
				<ul class="nav nav-list" style="display:none" id="gonggao">
					<li>
						<div align="center">
							<a href="backstage/Notice/Notice_add.jsp" target="mainFrame">
								<i class="icon-folder-open"></i> <span class="menu-text"><strong>上传公告
								</strong> </span> </a>
						</div>
					</li>
					<li>
						<div align="center">
							<a href="backstage/Notice/Notice_img.jsp" target="mainFrame">
								<i class="icon-folder-open"></i> <span class="menu-text"><strong>公告图片
								</strong> </span> </a>
						</div>
					</li>
					<li>
						<div align="center">
							<a href="QueryServlet?view=Notice" target="mainFrame"> <i
								class="icon-folder-open"></i> <span class="menu-text"><strong>公告清理
								</strong> </span> </a>
						</div>
					</li>
				</ul>
			</li>
			<!-- 公告管理 -->
			<!-- 公告管理 -->
			<li><a> <i class="icon-list-alt"></i> <span
					class="menu-text">中标管理</span> </a>
				<ul class="nav nav-list" style="display:none" id="zhongbiao">
					<li>
						<div align="center">
							<a href="QueryServlet?view=SucInfor" target="mainFrame"> <i
								class="icon-folder-open"></i> <span class="menu-text"> <strong>
										会员中标信息 </strong> </span> </a>
						</div>
					</li>
					<li></li>
				</ul>
			</li>
			<!-- 公告管理 -->
			<!-- 账户管理 -->
			<li><a> <i class="icon-list-alt"></i> <span
					class="menu-text">账户管理</span> </a>
				<ul class="nav nav-list" style="display:none" id="zhanghu">
					<li>
						<div align="center">
							<a href="QueryServlet?view=Card" target="mainFrame"> <i
								class="icon-folder-open"></i> <span class="menu-text"> <strong>
										账户信息 </strong> </span> </a>
						</div>
					</li>
					<li>
						<div align="center">
							<a href="backstage/Card/Card_add.jsp" target="mainFrame"> <i
								class="icon-folder-open"></i> <span class="menu-text"> <strong>
										添加账户 </strong> </span> </a>
						</div>
					</li>
					
				</ul>
			</li>

			<!-- 账户管理 -->
			<!-- 系统维护 -->
			<li><a> <i class="icon-list-alt"></i> <span
					class="menu-text">系统维护</span> </a>
				<ul class="nav nav-list" style="display:none" id="weihu">
					<li>
						<div align="center">
							<a href="backstage/xitongbeifen.jsp" target="mainFrame"> <i
								class=" icon-resize-small"></i> <span class="menu-text"><strong>系统备份</strong>
							</span> </a>
						</div>
					</li>
					<li>
						<div align="center">
							<a href="backstage/xitonghuifu.jsp" target="mainFrame"> <i
								class="icon-retweet"></i> <span class="menu-text"><strong>系统恢复</strong>
							</span> </a>
						</div>
					</li>
					<li>
						<div align="center">
							<a href="backstage/update_pass.jsp" target="mainFrame"> <i
								class="icon-edit"></i> <span class="menu-text"><strong>密码修改</strong>
							</span> </a>
						</div>
					</li>
				</ul>
			</li>
			<!-- 系统维护 -->
			<li><a href="admin_login.jsp" target="_top"> <i
					class="icon-off"></i> <span class="menu-text">安全退出</span> </a>
			</li>
		</ul>
		<!-- /.nav-list -->
		<div class="sidebar-collapse" id="sidebar-collapse">
			<i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
				data-icon2="icon-double-angle-right"></i>
		</div>
		<script type="text/javascript">
			try {
				ace.settings.check('sidebar', 'collapsed')
			} catch (e) {
			}
		</script>
	</div>
	<script type="text/javascript" src="js/xixi.js">
		
	</script>
</body>
</html>