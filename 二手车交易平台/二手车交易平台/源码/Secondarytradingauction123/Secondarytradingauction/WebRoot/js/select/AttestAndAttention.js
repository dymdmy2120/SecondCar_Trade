var xmlHttp;
var flag;
var vid;
var count;
function createXMLHttp() {
	if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	} else {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
}
function setRequest(u_id, v_id, name, value , attCount) {
	if(u_id == "") {
		var gotoWhere ;
		if(name == 'state') {
			gotoWhere = "登记";
		}else {
			gotoWhere = "关注";
		}
		if (confirm("登录才能加入" + gotoWhere + ",确定去登录吗？")) {
			window.location.href = "login.html";
		}
	}else{
		count = attCount;
		vid = v_id;
		createXMLHttp();
		var url = "AttestAndAttentionServlet?u_id=" + u_id + "&v_id=" + v_id + "&"
				+ name + "=" + value;
		xmlHttp.open("POST", url);
		xmlHttp.onreadystatechange = setRequestCallback;
		xmlHttp.send(null);
	}
	
}
function setRequestCallback() {
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			++count;
			document.getElementById("appCount" + vid).innerHTML=count;
			var text = xmlHttp.responseText;
			alert(text);
		}
	}
}


