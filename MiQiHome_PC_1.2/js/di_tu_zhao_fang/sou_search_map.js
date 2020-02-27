$(function(){
	var ctx = $("#ctx").val();
	//media兼容IE8
	setwidth();
	map_height();
	$(window).on("ready resize",function(){
		setwidth();
		map_height();
	})
	$('.range-slider').jRange({
		from: 60,
		to: 1000,
		step: 1,
		format: '%s',
		width: "264px",
		scale: ["￥"+60,"￥"+1000],
		showScale:true,
		showLabels: false,
		isRange: true,
		onstatechange:function(){
			var valSpring = $("#filter_price").val();
			var arr = valSpring.split(",");
			if(arr[1]-arr[0]<60){
				if( arr[0]==60){
					this.setValue("60,120");
					arr[0]=60;
					arr[1]=120;
				}else if(arr[1]==1000){
					this.setValue("940,1000");
					arr[0]=940;
					arr[1]=1000;
				}
				else{
					if($(".last-active").hasClass("high")){
						arr[1]=parseInt(arr[0])+60;
						this.setValue(arr.join(","));
					}else{
						arr[0]=parseInt(arr[1])-60;
						this.setValue(arr.join(","));
					}
				}
			}
			if(arr[1]==1000){
				arr[1]="1000+";
			}
			$(".queding").css("color","#21C890");
			$("#price_num1").html(arr[0]);
			$("#price_num2").html(arr[1]);
		}
	});
	$("#mited").click(function(){
		$(".result-business").show();
		$('.next .add').eq(0).find('a').addClass('font-bold addOn');
	});
	//价格选项
	$("#toup_price").click(function(){
		//价格由低到高
		var url = $(this).attr("url");
		window.location.href = url;
	})
	$("#todown_price").click(function(){
		//价格由高到低
		var url = $(this).attr("url");
		window.location.href = url;
	})
	
	$('.tab').on('click','li',function(e){
    	e.stopPropagation();
        var name = $(this).prop('class');
        name = name.split(' ')[0];
        $(this).addClass('active');
        $(this).siblings().removeClass('active');
        $('#'+name).addClass('active');
        $('#'+name).siblings().removeClass('active');
    });
	// 搜索栏 入住人数
    $('.people .chose-people').click(function(e){
    	MYRP.rpComm($(this));
    	$("#index_list_calendar").hide();
    	$(".search-modal").fadeOut();
    	var that_model =  $(this).parents('.people').find('.search-modal');
        $(this).parents('.people').find('.search-modal').fadeIn().on('click','li',function(e){
        	MYRP.rpComm($(this));
        	e.stopPropagation();
            var count = $(this).text();
            var peoplenum = $(this).attr("peoplenum");
            $(this).addClass('on').siblings().removeClass('on');
            $('#countVal').text(count);
            $('#countVal').attr("popnum",peoplenum);
            $('#topCountVal').text(count);
            $(this).closest('.search-modal').hide();
            setTimeout(function(){
    			$('#landmarkBtn').click();
    		},300);
        });
        e.stopPropagation(e);
        $(document).one("click", function (e){
        	that_model.hide();
        });
    });
    
   //日历
    $('.time input').click(function(e){
    	MYRP.rpComm($(this));
        e.stopPropagation();
        $(".search-modal").fadeOut();
        $(this).parents('.time').find('#index_list_calendar-box').fadeIn().addClass('active');
        $(document).one("click", function (){
            if($('#checkoutday').val() !=="" || $("#checkinday").val() === ""){
                $('#index_list_calendar-box').fadeOut().removeClass('active');
            }
        });
        $("#index_list_calendar-box").click(function(e1){
        	e1.stopPropagation();
        	return;
        })
    });
    //滚动条
    $('.search-modal,.search-modal .tab-content,#roomScroll').niceScroll({
        cursorcolor: '#484848',
        cursoropacitymax: '0.25',
        cursorwidth: '6px',
        cursorborderradius: '100px'
    });
    //合并床型、设施、特色房型到其他
	$("#moreOther .moreOthernav").mouseover(function(){
		$(this).closest("li").siblings().find(".rt-word").fadeOut();
		$(this).addClass("addOn");
		var oLeft = $(this).position().left;
		var index = parseInt($(this).attr("more"))-1;
		$("#moreOther .checkbox").eq(index).show();
		if($(window).width()-$(this).offset().left<=$("#moreOther .checkbox").eq(index).width()){
			$("#moreOther .checkbox").eq(index).css("left",$(window).width()-$("#moreOther .checkbox").eq(index).width()-$(this).offset().left-35+"px")
			.siblings('.checkbox').hide();
		}
		else{
			$("#moreOther .checkbox").eq(index).css("left",oLeft-4+"px")
			.siblings('.checkbox').hide();
		}
	}).mouseleave(function(){
		var that = $(this);
		var index = parseInt($(this).attr("more"))-1;
		$("#moreOther .checkbox").eq(index).hover(function(){
			$(this).show();
			that.addClass("addOn");
		},function(){
			var index = parseInt(that.attr("more"))-1;
			that.removeClass("addOn");
			$("#moreOther .checkbox").eq(index).hide();
		})
		that.removeClass("addOn");
		$("#moreOther .checkbox").eq(index).hide();
	})
	$('.clearall').click(function(){
		window.location.href=ctx+$(this).find("a").attr('href');
	});
	$('#customPriceBtnNew').click(function(){
		var minPrice =  $('#price_num1').html();
		var maxPrice =  $('#price_num2').html();
		if(isNaN(maxPrice)){
			maxPrice = "99999";
		}
		var priceStr = "p"+minPrice+'-'+maxPrice;
		var urlRequest = $(this).attr('urlRequest');
		if((/p[\d]+-[\d]+/).test(urlRequest)){
			urlRequest = urlRequest.replace(/p[\d]+-[\d]+/,priceStr);
		}
		window.location.href=urlRequest;
	});
	$(".lt-icon").hover(function(){
		$(".search-modal").hide();
		$(this).next().fadeIn();
		var oclosest = $(this).closest('li').siblings();
		oclosest.each(function(){
			if($(this).attr("id")!="moreOther"){
				
				$(this).find('.rt-word').hide();
			}
		});
		if($(this).closest("#position").length>0){
			if($(window).width()-$("#position .lt-icon").offset().left<=$(".position_choose").width()){
				$(".position_choose").css("left",$(window).width()-$(".position_choose").width()-$("#position .lt-icon").offset().left-45+"px");
			}
			else{
				$(".position_choose").css("left",-15);
			}
		};
		var valSpring = $("#filter_price").val();
		$('.range-slider').jRange('setValue', valSpring);
	},function(){
		$(this).next().hover(function(){
			$(this).show();
			return;
		},function(){
			$(this).hide();
		})
		
		$(this).next().hide();
	});
})
function setwidth(){
	var ow = $(window).width();
	if(ow<=1600){
		if(ow<=1400){
	        $(".add_filter a").css("padding","0 8px 0 10px");
	        $(".filter ul li .lt-icon, .filter ul li#moreOther .moreOthernav,#list_search .search_main .filterList.people .chose-people").css("padding","0 16px 0 6px");
	        $(".filter ul li .lt-icon, .filter ul li#moreOther .moreOthernav").addClass("afterR4").removeClass("afterR2 afterR10 afterR20");
	        $("#list_search .search_main .filterList.time .clear").css("right","2px");
	        if(ow>1330){
	        	$("#list_search .search_main .filterList.keyword").css("width","420px");
	        }
			else if(ow>1200 && ow<1330){
				$("#list_search .search_main .filterList.keyword").css("width","300px");
			}
			else if(ow<=1200){
				$("#list_search .search_main .filterList.keyword").css("width","204px");
			}
		}
		else {
			$(".filter ul li .lt-icon, .filter ul li#moreOther .moreOthernav,#list_search .search_main .filterList.people .chose-people").css("padding"," 0 18px 0 6px");
			$(".filter ul li .lt-icon, .filter ul li#moreOther .moreOthernav").addClass("afterR2").removeClass("afterR10 afterR4 afterR20");
		}
		
	}
	else if(ow>1600 && ow<=1800){
        $(".filter ul li .lt-icon, .filter ul li#moreOther .moreOthernav").css("padding","0 26px 0 10px");
        $(".filter ul li .lt-icon, .filter ul li#moreOther .moreOthernav").addClass("afterR10").removeClass("afterR2 afterR4 afterR20");
    }
	else if(ow>1800){
		$(".filter ul li .lt-icon, .filter ul li#moreOther .moreOthernav").css("padding","0 38px 0 20px");
        $(".filter ul li .lt-icon, .filter ul li#moreOther .moreOthernav").addClass("afterR20").removeClass("afterR2 afterR4 afterR10");
	}
}
var mapCollect_flag = false;//收藏
function lodge_collect(obj){
	if(mapCollect_flag){
		return ;
	}
	mapCollect_flag =true;
	var user = getCookie('MAYIUID');
	if(null==user||user.length==0){
		$("#loginshow").click();
	}else{
		var roomid = $(obj).attr("id");
		roomid = roomid.replace("map_c_","").replace("c_","");
		var state = $(obj).attr("state");
		var ctx = $('#ctx').val();
		$.ajax({
			url:ctx+'/user/tenant/setCollection?roomid='+roomid+"&state="+state,
			type:'POST',
			dataType:'json',
			success:function(data){
				if(data==1){
					if(state==1){
						state=2;
						$("#c_"+roomid).addClass("ct_on").attr("title","取消收藏");
						$("#map_c_"+roomid).addClass("ct_on").attr("title","取消收藏");
					}else{
						state=1;
						$("#c_"+roomid).removeClass("ct_on").attr("title","收藏");
						$("#map_c_"+roomid).removeClass("ct_on").attr("title","收藏");
					}
					$("#c_"+roomid+"").attr("state",state);
					$("#map_c_"+roomid+"").attr("state",state);
				}else{
					alert('收藏失败！');
				}
				mapCollect_flag = false;
			},
			error:function(){
				alert('请求异常，请稍后再试！');
				mapCollect_flag = false;
			}
		});
	}
}
function map_height(){
	var clientH = $(window).height();
	var headH = $(".header").outerHeight()+$("#filter").outerHeight();
	var map_H = clientH-headH;
	var room_H = map_H - $("#sortDiv").outerHeight()-$("#page").outerHeight()-60;
	$("#map,.map_for_fixed,.map").height(map_H);
	$("#roomScroll").css("height",room_H+"px");
}
function goNoMap(){
	var url = window.location.href;
	window.location.href =url.replace("?map=no","").replace("&map=no","");
}