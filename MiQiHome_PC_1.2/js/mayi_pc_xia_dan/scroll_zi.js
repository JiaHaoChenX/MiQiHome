$(function(){
	$(".content").css("position","relative");
	var d,yg,h,j,oLeftW,oParW;
	getdistance();
	h = $('#pin1').offset().top;
	$(window).resize(function(){
		setTimeout(function(){
			getdistance();
			scroll();
		},300);
		
	})
	function getdistance(){
		yg = $('#pin1').height();
		j = $('.foot').offset().top-yg;
		oLeftW = $(".content_left").width()+$(".content_left").offset().left;
		oParW = $(".content").width()+$(".content").offset().left;
		d = oLeftW + (oParW - oLeftW - $(".content_right").width());
	}
	$('.insurance_label,.more,#editMobile,.invoice_label,.c_person').click(function(){
		setTimeout(function(){
			getdistance();
			scroll();
		},30)
	})
	
	
	$(window).scroll(function(){
		scroll();
		
	})
	
	function scroll(){
		var p = $(window).scrollTop();
		var t = $('.foot').offset().top-p;
		if(p<=h){
			$('#pin1').css({
				position:'static'
			})
		}
		else if(p>=h){
			if(t>=yg+30){
				$('#pin1').css({
					position:'fixed',
					left:d,
					top:0
				})
			}else{
				//var jH = p-(p-j)-88;
				$('#pin1').css({
					position:'absolute',
					left:"auto",
					right:0,
					top:"auto",
					bottom:"30px"
				})
			}
		}
	}
}) 