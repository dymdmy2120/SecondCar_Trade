$(document).ready(
		function() {
			var v_id;
			var bSpri;
			var plus;
			var bidTime;
			var bidEndTime;
			var spirValue;
			var plusValue;
			$("a[id^='confirm']").click(
					function() {
						v_id = $(this).attr("value");
						bSpri = "#bspir" + v_id;
						plus = "#plus" + v_id;
						bidTime = "#bidTime" + v_id;
						bidEndTime = "#bidEndTime" + v_id;
						var d = new Date(); 
						var currTime ;
							currTime= d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate()+" "+d.getHours()+":"+d.getMinutes();
							d.getTime();
						
						spirValue = $(bSpri).val();
						plusValue = $(plus).val();
						var flag = true;
						var date1 = new Date($(bidTime).val());
						if (!isNumber(spirValue)) {
					
							alert("竞拍底价中应输入为合理的数字！");
							$(bSpri).focus();
							flag = false;
						} else if (!isNumber(plusValue)) {
							alert("竞拍加价中应输入为合理的数字！");
							$(plus).focus();
							flag = false;

						} else if ($(bidTime).val() == '点我设置时间'
								|| $(bidEndTime).val() == '点我设置时间') {

							alert("请设定时间！");
							flag = false;

						} else if($(bidTime).val()>=$(bidEndTime).val()){
							alert("竞拍结束时间不能小于或等于开始时间！");
							
							$(bidTime).focus();
							flag=false;
							
						}else if(d.getTime() - date1.getTime() > 0){
							alert("竞拍开始时间不能比当前时间小！");	
							$(bidTime).focus();
							flag=false;
						}
						if (flag) {
							var bidId = "#hidden" + v_id;
							var bid = $(bidId).val();
							var beginTime = $(bidTime).attr("value");
							var endTime = $(bidEndTime).attr("value");
							setTime(v_id, bid, beginTime, endTime, spirValue,
									plusValue);

						}

					});

		});

function createXMLHttpRequest() {
	if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	}
}
function setTime(v_id, bid_id, bidTime, bidEndTime, spri, plus) { // 点击启动拍卖或终止拍卖的调用的功能
	createXMLHttpRequest();
	var url = "AuctionTimeSettingServlet?v_id=" + v_id + "&bid_id=" + bid_id
			+ "&bidTime=" + bidTime + "&bidEndTime=" + bidEndTime + "&bidSpri="
			+ spri + "&plusPri=" + plus;
	xmlHttp.open("GET", url, true);

	xmlHttp.onreadystatechange = callback;
	xmlHttp.send(null);
}
function callback() {// 回调函数 当异步提交请求成功后调用的函数
	if (xmlHttp.readyState == 4) {
		showResult();
	}
}

function showResult() {// 请求完后执行的函数

	var flag = false;
	var xmlDoc = xmlHttp.responseXML;
	var content = xmlDoc.getElementsByTagName("content");
	flag = content[0].childNodes[0].firstChild.data;
	if (flag == 'true') {
		alert('竞拍设置成功');
	} else if (flag == 'false') {

		alert('竞拍信息设置失败');
	}
}

function isNumber(oNum) {
	if (!oNum)
		return false;
	var strP = /^[1-9](\d+)?$/;
	if (!strP.test(oNum))
		return false;
	try {
		if (parseFloat(oNum) != oNum)
			return false;
	} catch (ex) {
		return false;
	}
	return true;
}
