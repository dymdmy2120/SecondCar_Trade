      $(document).ready(function(e) {
          $(".navmore").hover(function(){
			$(this).addClass("navmore-hover");
		    $(this).find(".navMoreUL").show();
		  },function(){
			$(this).removeClass("navmore-hover");
		    $(this).find(".navMoreUL").hide();	  
	 }); 
	   
	    $(".topSearch").hover(function(){
		   $(this).find(".chooseS").show();
		},function(){
		   $(this).find(".chooseS").hide();
		});
		/** cool end **/
		 $(".tengxun-channel-more").hover(function(){
			 $(this).addClass("tengxun-channel-more-hover");
			 $(this).find(".tengxun-more-channels").show();
		 },function(){
			 $(this).removeClass("tengxun-channel-more-hover");
			 $(this).find(".tengxun-more-channels").hide();
			 });
			 
		$(".tengxun-search-text").focusin(function(){
			 $(this).parent().addClass("focus");
			 $(".tengxun-search-text").val("");
		 });
		 $(".tengxun-search-text").focusout(function(){
			 $(this).parent().removeClass("focus");
			 $(".tengxun-search-text").val("中国合伙人");
		});
		
		 $(".head-history").hover(function(){
		   $('.muen-history').show(0);
		
		 },function(){
	      $('.muen-history').delay(150).hide(0);
		});  
		
		$(".head-favorites").hover(function(){
		   $('.muen-favorites').delay(0).show(0);
		  
		},function(){
		   $('.muen-favorites').delay(150).hide(0);
		});  
		
		 $(".timeline-video-list dd").hover(function(){
			 $(this).addClass("hover-video");
		 },function(){
			 $(this).removeClass("hover-video");
		});	 
      
        
    });
   