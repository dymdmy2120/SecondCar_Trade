// JavaScript Document
var oUl = document.getElementsByTagName('ul')[0];
	var aLi = oUl.getElementsByTagName('li');
	for(i = 0 ; i < aLi.length; i++) {
		aLi[i].index = i;
		aLi[i].onclick = function() {
			
			document.getElementById('paimai').style.display = "none";
			document.getElementById('huiyuan').style.display = "none";
			document.getElementById('cheliang').style.display = "none";
			document.getElementById('weihu').style.display = "none";
			document.getElementById('gonggao').style.display = "none";
			document.getElementById('zhongbiao').style.display = "none";
				document.getElementById('zhanghu').style.display = "none";
			for(j = 0 ; j < aLi.length; j++) {
				aLi[j].className = "";
			}
			if(this.index == 1) {
				document.getElementById('huiyuan').style.display = "block";
			}if(this.index == 6) {
				document.getElementById('paimai').style.display = "block";
			}if(this.index == 11) {
				document.getElementById('cheliang').style.display = "block";
			}if(this.index == 17) {
				document.getElementById('gonggao').style.display = "block";
			}if(this.index == 21) {
				document.getElementById('zhongbiao').style.display = "block";
			}
			if(this.index == 24) {
				document.getElementById('zhanghu').style.display = "block";
			}
			if(this.index == 27) {
				document.getElementById('weihu').style.display = "block";
			}
			this.className = "active";
		}

	}
	