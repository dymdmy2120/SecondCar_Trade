function createXMLHttpRequest() {
	if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	}
}
function getFiledNames(param) { // 得到字段名
	createXMLHttpRequest();
	var url = "SaveAuctionServlet?"+param;
	xmlHttp.open("get", url, true);
	xmlHttp.send(null);
	xmlHttp.onreadystatechange = callback;

}
function callback() {// 回调函数 当异步提交请求成功后调用的函数
	if (xmlHttp.readyState == 4) {
		document.getElementById("show").innerHTML == "<font size='10' color='red'>拍卖结束</font>";
		
	}
}
