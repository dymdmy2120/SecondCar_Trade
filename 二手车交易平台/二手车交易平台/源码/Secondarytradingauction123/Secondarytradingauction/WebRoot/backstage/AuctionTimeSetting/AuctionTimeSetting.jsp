<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java"
	import="cn.zlpc.vo.AuctionTimeSetting,java.text.SimpleDateFormat,java.text.DateFormat"%>
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
<script src="backstage/AuctionTimeSetting/DateTool/WdatePicker.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/select/auctionTimeSet.js"></script>
<script src="js/ace-extra.min.js"></script>
</head>
<body>
	<%
		List<AuctionTimeSetting> list = (List<AuctionTimeSetting>) request
				.getAttribute("list");
	%>
	<center>
		<h2>
			<font color="#FF0000"> 竞拍时间设定 </font>
		</h2>
	</center>
	<span style="display:block;text-align:right;"> <a href="#">
			<input type="text" placeholder="Search"> </a> <a href="#"
		role="button"><i class="icon-search">搜索</i> </a> </span>
	<div class="main-container" id="main-container">
		<div class="page-content">
			<div class="page-header">
				<table class="table table-hover" border="1">
					<thead>
						<tr>

							<td width="9%">车牌号</td>
							<td width="12%"><div align="center">车辆名称</div></td>
							<td width="12%"><div align="center">竞拍开始时间</div></td>
							<td width="9%"><div align="center">竞拍结束时间</div></td>
							<td width="12%"><div align="center">竞拍底价</div></td>
							<td width="11%"><div align="center">竞拍加价</div></td>
							<td colspan="2"><div align="center">操作</div></td>
						</tr>
					</thead>
					<tbody>

						<%
							for (int i = 0; i < list.size(); i++) {
								AuctionTimeSetting auction = list.get(i);
								Integer bid = auction.getBid_id();
								Integer stopAuction = auction.getStopAuction();
								String vname = auction.getVname();
								Integer v_id = auction.getV_id();
								String plateNo = auction.getPlateNo();
								DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
								String bidTime = null, bidEndTime = null;
								if (auction.getBidEndTime() != null) {
									bidTime = format.format(auction.getBidTime());
									bidEndTime = format.format(auction.getBidEndTime());
									if (stopAuction == 1) {
										bidTime = "点我设置时间";
										bidEndTime = "点我设置时间";
									}

								} else {
									bidTime = "点我设置时间";
									bidEndTime = "点我设置时间";
								}
								Integer bSpri = auction.getBidSpri();
								Integer plus = auction.getPlusPri();
						%>

						<tr>
							<td width="5%">
								<div><%=plateNo%></div>
							</td>
							<td width="5%">
								<div><%=vname%></div>
							</td>
							<input type="hidden" id="hidden<%=v_id%>" value="<%=bid%>">
							<td><div align="center">
									<input type="text" value="<%=bidTime%>" id="bidTime<%=v_id%>" 
										name="bidTime" class="Wdate"
										onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"
										style="width:150px" />
							</td>
							<td><input type="text" value="<%=bidEndTime%>"
								id="bidEndTime<%=v_id%>" class="Wdate"
								onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"
								style="width:150px">
							</td>
							<td width="10%"><div align="center">
									<input type="text" id="bspir<%=v_id%>" value="<%=bSpri%>"
										class="input" />
								</div>
							</td>
							<td width="10%"><div align="center">
									<input type="text" id="plus<%=v_id%>" value="<%=plus%>"
										class="input" />
								</div>
							</td>

							<td width="5%">
								<div align="center">
									<a id="confirm<%=v_id%>" href="javascript:void(0)"
										value="<%=v_id%>"><button>确定</button>
									</a>
									</button>
								</div>
							</td>
							</td>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>
			</div>
		</div>
	</div>

	<center>
		<ul class="pagination">
			<li><a>共有${page.count}条记录</a>
			</li>
			<li><a>第${page.page}页</a>
			</li>
			<li><a href="QueryServlet?view=AuctionTimeSetting&firstIndex=1">首页</a>
			</li>
			<li><a
				href="QueryServlet?view=AuctionTimeSetting&firstIndex=${page.page-1<=1?1:page.page- 1}">
					上一页 </a>
			</li>
			<li><a
				href="QueryServlet?view=AuctionTimeSetting&firstIndex=${page.page + 1 >=page.lastPage?page.lastPage:page.page + 1}">
					下一页</a>
			</li>
			<li><a
				href="QueryServlet?view=AuctionTimeSetting&firstIndex=${page.lastPage}">
					末页</a>
			</li>
		</ul>
	</center>
	</div>
</body>
</html>
