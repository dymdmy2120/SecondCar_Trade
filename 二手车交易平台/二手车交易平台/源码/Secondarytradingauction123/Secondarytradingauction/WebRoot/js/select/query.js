//查询时所需表单的替换
function select() {
	var name=$('#select option:selected').val();
	$('#queryInput').attr("name" , name );
}

function start(name) {
	var value = document.getElementById("queryInput").value;
	if(value == "") {
		alert("查询内容不能为空！请重新输入");
		return false;
	}
	var formAction = "QueryServlet?view=" + name + "&queryCondition=" + $('#queryInput').attr("name") + "&queryValue=" + value;
	$('#start').attr("action" , formAction);
	$('#start').submit();
}