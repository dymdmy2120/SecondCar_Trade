//用户名校验的方法
//这个方法将使用XMLHTTPRequest对象来进行AJAX的异步数据交互
var xmlhttp;
function verify() {
    //0。使用dom的方式获取文本框中的值
    //document.getElementById("userName")是dom中获取元素节点的一种方法，一个元素节点对应HTML页面中的一个标签，如果<input>
    //。value可以获取一个元素节点的value属性值
//    var userName = document.getElementById("userName").value;

    //1.创建XMLHttpRequest对象
    //这是XMLHttpReuquest对象无部使用中最复杂的一步
    //需要针对IE和其他类型的浏览器建立这个对象的不同方式写不同的代码

    if (window.XMLHttpRequest) {
        //针对FireFox，Mozillar，Opera，Safari，IE7，IE8
        xmlhttp = new XMLHttpRequest();
        //针对某些特定版本的mozillar浏览器的BUG进行修正
        if (xmlhttp.overrideMimeType) {
            xmlhttp.overrideMimeType("text/xml");
        }
    } else if (window.ActiveXObject) {
         //针对IE6，IE5.5，IE5
        //两个可以用于创建XMLHTTPRequest对象的控件名称，保存在一个js的数组中
        //排在前面的版本较新
        var activexName = ["MSXML2.XMLHTTP","Microsoft.XMLHTTP"];
        for (var i = 0; i < activexName.length; i++) {
            try{
                //取出一个控件名进行创建，如果创建成功就终止循环
                //如果创建失败，回抛出异常，然后可以继续循环，继续尝试创建
                xmlhttp = new ActiveXObject(activexName[i]);
                break;
            } catch(e){
            }
        }
    }
    //确认XMLHTtpRequest对象创建成功
    if (!xmlhttp) {
        alert("XMLHttpRequest对象创建失败!!");
        return;
    } else {
//        alert(xmlhttp.readyState);
    }

    //2.注册回调函数
    //注册回调函数时，之需要函数名，不要加括号
    //我们需要将函数名注册，如果加上括号，就会把函数的返回值注册上，这是错误的
    xmlhttp.onreadystatechange = callback;
    //3。设置连接信息
    //第一个参数表示http的请求方式，支持所有http的请求方式，主要使用get和post
    //第二个参数表示请求的url地址，get方式请求的参数也在url中
    //第三个参数表示采用异步还是同步方式交互，true表示异步
    xmlhttp.open("GET","AJAXServlet",true);

    //POST方式请求的代码
    //xmlhttp.open("POST","AJAXServer",true);
    //POST方式需要自己设置http的请求头
    //xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    //POST方式发送数据
    //xmlhttp.send("name=" + userName);

    //4.发送数据，开始和服务器端进行交互
    //同步方式下，send这句话会在服务器段数据回来后才执行完
    //异步方式下，send这句话会立即完成执行
    xmlhttp.send(null);
}

//回调函数
function callback() {
    //alert(xmlhttp.readyState);
    //5。接收响应数据
    //判断对象的状态是交互完成
    if (xmlhttp.readyState == 4) {
        //判断http的交互是否成功
        if (xmlhttp.status == 200) {
            //获取服务漆器端返回的数据
            //获取服务器段输出的纯文本数据
            var responseText = xmlhttp.responseText;
            //将数据显示在页面上
            //通过dom的方式找到div标签所对应的元素节点
//            var divNode = document.getElementById("result");
            alert(responseText);
            //设置元素节点中的html内容
//            divNode.innerHTML = responseText;
        } else {
            alert("出错了！！！");
        }
    }
}
