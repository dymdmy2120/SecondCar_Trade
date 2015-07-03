$.fn.extend({
	allenMenu: function() {
		$(this).children('ul').children('li').hover(
			function() {
				if(!$(this).children('ul').hasClass('focus')) {
					$(this).addClass('focus');
					$(this).children('ul:first').stop(true, true).animate({ height:'show' }, 'fast');
				}
			},
			function() {
				$(this).removeClass('focus');
				$(this).children('ul:first').stop(true, true).animate({ height:'hide', opacity:'hide' }, 'slow');
			}
		);
		$(this).children('ul').children('li').children('ul').hover(
			function() {
				$(this).addClass('focus');
			},
			function() {
				$(this).removeClass('focus');
			}
		);
	}
});

$.fn.extend({
	allenSlide: function() {
		var ads = $(this).find('ul:first li');
		var name = $(this).attr('id');
		var n = ads.length;
		var w = ads.width();
		var h = ads.height();
		var clicked = false;
		var t = 4000;
		var lt = 5000;
		var speed = 'slow';
		var curPage = 0;
		
		//$(this).children('ul:first').append($(this).find('ul:first li:first').clone());
		
		//$(this).width(w).height(h);
		$(this).css('overflow', 'hidden');
		$(this).css('position', 'relative');
		$(this).children('ul:first').width(w * (n + 1));
		var pages = $('<div class="slide-page"></div>');
		for(var i = 1; i <= n; i++) {
			var el = $('<a href="#" id="' + name + '-page-' + i + '">' + i + '</a>');
			eval('el.click(function(){ clicked = true; slideTo(' + i + '); return false; });');
			pages.append(el);
		}
		$(this).append(pages);
		$('#' + name + '-page-1').parent().addClass('on');
		autoSlide();
		
		/* Fade Version
		*/
		function slideTo(page) {
			curPage = page;
			var ml = -1 * w * (page - 1);
			$('#' + name).find('li:eq('+(curPage-1)+')').stop();
			if(page > n) {
				page = 1;
				curPage = 1;
			}
			$('#' + name).find('li').each(function() {
				if($(this).css("display") != "none") {
					//$(this).css('z-index', '2');
					$(this).fadeOut(speed);
				}
			});
			//$('#' + name).find('li:eq('+(page-1)+')').css('z-index', '1');
			$('#' + name).find('li:eq('+(page-1)+')').fadeIn(speed);
			$('#' + name).find('.slide-page > a').removeClass('on');
			$('#' + name + '-page-' + curPage).addClass('on');
		}

		/* Slide Version
		function slideTo(page) {
			curPage = page;
			var ml = -1 * w * (page - 1);
			$('#' + name).children('ul:first').stop();
			if(page > n) {
				curPage = 1;
			} else if(page == 2 && !clicked) {
				$('#' + name).children('ul:first').css('margin-left', '0px');
			}
			$('#' + name).children('ul:first').animate({ marginLeft: ml }, speed);
			$('#' + name).find('.slide-page > a').removeClass('on');
			$('#' + name + '-page-' + curPage).addClass('on');
		}
		*/
		
		function autoSlide() {
			var tp = curPage;
			if(!clicked) {
				slideTo(tp + 1);
				eval('setTimeout(function() { autoSlide(); }, ' + t + ');');
			} else {
				clicked = false;
				eval('setTimeout(function() { autoSlide(); }, ' + lt + ');');
			}
		}

	}
});
