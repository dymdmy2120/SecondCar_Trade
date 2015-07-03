//启动拍卖
	var startLoc;
	var startCurrent;
	var startVname;
	//终止拍卖
	var stopCurrent;
	var stopVname;
	var bid_id;
	var bidValue;
	var isAllowCou;
	$(document).ready(function()
	{ 
    var flag=true;
	$("a[id^='start']").click(function(){//启动拍卖
	startCurrent=$(this).attr("id");
 	startVname=$(this).attr("value");
 	bid_id="#hidden"+startVname;
 	allowCou="#allow"+startVname;
 	if($(allowCou).val()==0){
 		flag=false;
 		alert('允许拍卖的人数为0，不能启动拍卖!');
 	}
 	bidValue=$(bid_id).val();
 	
 	if(flag){
 	operate("start",bidValue);
 	}
 	
  
	});
	
	$("a[id^='stop']").live('click',function(){//终止拍卖 用live函数是为了 通过jquery动态添加后的元素的点击事件起作用

    if(delete_confirm()){
     stopVname=$(this).attr("value");
     bid_id="#hidden"+stopVname;
     bidValue=$(bid_id).val();
	 operate("stop",bidValue);
	stopCurrent=$(this).attr("id");
	
    }
	
	});
  });
  function delete_confirm() 
{
    event.returnValue = confirm("终止竞拍，你确认要终止吗？");
    return  event.returnValue;
}
  function createXMLHttpRequest(){
   if(window.ActiveXObject){
     xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
   }
   else if(window.XMLHttpRequest){
      xmlHttp=new XMLHttpRequest();
   } 
}
  function operate(param,bidValue){ // 点击启动拍卖或终止拍卖的调用的功能
  createXMLHttpRequest();
  var url="StartStopAuctionServlet?param="+param+"&bid_id="+bidValue;
   xmlHttp.open("GET",url,true);
 
   xmlHttp.onreadystatechange=callback;
   xmlHttp.send(null); 
}
 function callback(){//回调函数 当异步提交请求成功后调用的函数
   if(xmlHttp.readyState==4){
     showResult();
	  }
} 

function showResult(){//请求完后执行的函数
       var flag=false;
	   var xmlDoc=xmlHttp.responseXML;
	   var content=xmlDoc.getElementsByTagName("content");
	    flag=content[0].childNodes[0].firstChild.data;
	   var operate=content[1].childNodes[0].firstChild.data;
	   if(flag=='true'&&operate=='start'){
	   alert("启动拍卖成功");
	   startLoc="#"+startCurrent+"Div";
   	$(startLoc).empty();
 	var str="<a href='javascript:void(0)' id='stop"+startVname+"' value='"+startVname+"'>终止拍卖</a>";
 	$(startLoc).append($(str));
	$(startLoc).attr("id","stop"+startVname+"Div");
	   
	   }else if(flag=='true'&&operate=='stop'){
	   alert("终止拍卖成功");
	   var divId="#stop"+stopVname+"Div";
	$(divId).parent().parent().remove();
	window.location.href="QueryServlet?view=StartContest";
	   
	   } else if(flag=='false'&&operate=='start'){
		   alert("启动拍卖失败");
		   
	   } else if(flag=='false'&&operate=='stop'){
		   alert("终止拍卖失败");
	   }
    }