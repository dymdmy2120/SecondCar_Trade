function DoCheck(name) {
	var ch = document.getElementsByName(name);
	
	if (isTrue(ch)) {
		for ( var i = 0; i < ch.length; i++) {
			ch[i].checked = true;
		}
	} else {
		for ( var i = 0; i < ch.length; i++) {
			ch[i].checked = false;
		}
	}
}

function isTrue(ch) {
	var allCheck = document.getElementsByName("allChecked");
	for(var i = 0 ; i < allCheck.length ; i ++) {
		if(allCheck[i].checked == true) {
			return true;
		}
	}
	return false;
}

function fillHref(tag , voName, name) {
	var verifyForm = document.getElementById("start");
	var action = getFormAction(tag , voName , name);
	//alert(action);
	if(!action) {
		return action;
	}
	verifyForm.action = action;
	verifyForm.submit();
}

function fillAgree(tag , voName, name , state) {
	var verifyForm = document.getElementById("start");
	var action = getFormAction(tag , voName , name);
	if(!action) {
		return action;
	}
	action += "&state=" + state;
	//alert(action);
	verifyForm.action = action;
	verifyForm.submit();
} 


/**
 * 获取应填入表单的action
 * @returns
 */
function getFormAction(tag , voName , name) {
	if(tag == 'null') {
		tag = "SingleServlet";
	}
	var formAction = tag + "?";
	var ch = document.getElementsByName(name);
	var flag = false;
	for ( var i = 0; i < ch.length; i++) {
		if (ch[i].checked) {
			flag = true;
			if(ch[i].value != "") {
				formAction += name + "=" + ch[i].value + "&";
			}
		}
	}
	if (!flag) {
		alert("请至少选择一行数据！");
		return flag;
	}
	formAction += "operate=" + voName + ".delete";
	return formAction;
}

