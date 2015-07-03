;(function($) {  

	var heartBeat = 10000;
	var hbTimer=undefined ;
	function keepAlive(ws){
		if(!hbTimer){
			hbTimer = window.setInterval(function(){
			ws.send(1);  
			}, heartBeat);
		}
	}
	function stopHeartBeat(){
		if(hbTimer){
			window.clearInterval(hbTimer);
			hbTimer=undefined;
		}
	}
    $.websocket = function(options) { 
        var defaults = {  
            domain: top.location.hostname,  
            port:80
        };  
        var opts = $.extend(defaults,options);  
        var szServer = "ws://" + opts.domain + ":" + opts.port + "/" + opts.protocol;  
        var socket = null;  
        var bOpen = false;  
        var t1 = 0;   
        var t2 = 0;   
        var messageevent = {  
            onInit:function(){  
                if(!("WebSocket" in window) && !("MozWebSocket" in window)){    
                    return false;  
                } 
                if(("MozWebSocket" in window)){  
                    socket = new MozWebSocket(szServer);    
                }else{  
                    socket = new WebSocket(szServer);  
                }  
                if(opts.onInit){  
                    opts.onInit();  
                }  
            },  
            onOpen:function(event){  
                bOpen = true;  
                if(opts.onOpen){  
                    opts.onOpen(event);  
                }  
                keepAlive(socket);
            },  
            onSend:function(msg){  
                t1 = new Date().getTime();   
                if(opts.onSend){  
                    opts.onSend(msg);  
                }  
                socket.send(msg);  
            },  
            onMessage:function(msg){  
                t2 = new Date().getTime();   
                if(opts.onMessage){  
                    opts.onMessage(msg.data,t2 - t1);  
                }  
            },  
            onError:function(event){  
                if(opts.onError){  
                    opts.onError(event);  
                }  
            },  
            onClose:function(event){  
                if(opts.onClose){  
                    opts.onClose(event);  
                }
                stopHeartBeat();
                if(socket.close() != null){  
                    socket = null;  
                }  
            }  
        }  ;
        messageevent.onInit();  
        socket.onopen = messageevent.onOpen;  
        socket.onmessage = messageevent.onMessage;  
        socket.onerror = messageevent.onError;  
        socket.onclose = messageevent.onClose;   
        this.send = function(pData){  
            if(bOpen == false){  
                return false;  
            }  
            messageevent.onSend(pData);  
            return true;  
        }  ;
        this.close = function(){  
            messageevent.onClose();  
        }  ;
        return this;  
    };  
})(jQuery); 