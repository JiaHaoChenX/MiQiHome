/*点击查看地图*/
$('.look_map').click(function(){
	var map_scoll = $('.room_adress').offset().top-60;
  $("html,body").animate({
    scrollTop: map_scoll
  }, 600);

})
function openDialog(e) {
	document.getElementById("xiala").style.display = "block";
	e = e||window.event;
	if(+'\v1') {
		e.stopPropagation();
	} else  {
		e.cancelBubble = true;
	}
}

$(function(){	
	/*时段优惠*/
	$(document).ready(function(){
		$(".shiduanL a").mouseover(function(){
			$(".zhekou").show(300);}
		)
		$(".shiduanL a").mouseleave(function(){
			$(".zhekou").hide(0);}
		)
	})
	
	//价格明细
	$(document).on('mouseenter','#PriceDetails',function() {
		$('.mingxi').show(300);
	});
	
	$(document).on('mouseleave','#PriceDetails',function() {
			$('.mingxi').hide(0);
	});
	//收藏
	 $("#sc_word").click(function(){
		 if($(this).html()=="收藏")
	     {
			 $(".mmcoll1").click();
	     }
		 else
	     {
			 $(".mmcoll2").click();
	     }		 		
	  })
	 var h = $('#sc_word').offset().top;
	 var w = $('#sc_word').offset().left;
	 $('.mmcoll').css({
		left:w-22+'px',
		top:h+'px'
	 })
	
	 var a = $('.jiaotong_ul').height();
	 $('.jiaotong_ul li').css('height',a+'px');
	 $('#hasContent').click(function() {		
		loadPageComment('1','1',true);
		loadPageComment('1','2',true);
	});
	 /*页面初始化时判断更多按钮是否显示*/
	 $('#attached_home02').show();
	 $('.pingjia_cnt1').each(function(){
	 	if($(this).height()>60){
	 		$(this).addClass('over');
	 		$(this).next().show();
	 	}else{
	 		$(this).next().hide();
	 		$(this).removeClass('over');

	 	}
	 })
	 $('#attached_home02').hide();
	 /*页面初始化时判断更多按钮是否显示代码结束*/	
});

/*日历*/
$(document).ready(function(){
//    $(".calendarB").click(function(){
//		$(".calend").show();
//	})
	
	$(".shadow").click(function(){
		$(".calend").hide();
	})	
	
	$(".select").click(function(){
		$(".calend").hide();
	})	
});

/*右侧APP下单扫码*/
$('.priceTotalR ').mouseover(function(){
	$('.erwm_tan').show();
})
$('.priceTotalR ').mouseout(function(){
	$('.erwm_tan').hide();
})

function showMap(){   
    if(map==null){
    	var longitude = $("#longitude").val();
        var latitude = $("#latitude").val();  
		map = new BMap.Map('dituContent');	
		var point = new BMap.Point(longitude,latitude);
	    map.centerAndZoom(point, 17);
	    var marker = new BMap.Marker(point);  // 创建标注
	    map.addOverlay(marker);              // 将标注添加到地图中
	    map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
	}
}

function setskip(){
	var countNum = $("#countNum").val();
	var countLordNum = $("#countLordNum").val();
	$('#pjskip').click(function(){	
		if(countNum<=0&&countLordNum>0)
		{
			$("#lordComment").click();
		}
	});
}
/*退款规则的margin值*/
$('.c_bar_box').css('margin-top',85);
$(function(){
	//项目定位
	
	
	var subtop=[];
	function arr(){
		subtop = [];
		var subheight = $(".desChioce").height();
		subtop.push([$("#photo").offset().top, "type"]);
		subtop.push([$("#room").offset().top, "type"]);
		subtop.push([$("#pingjia").offset().top, "type"]);
		subtop.push([$("#address").offset().top, "type"]);
	}

	arr();
	$(document).click(function(){
		arr();
	})
	var menuIsC = false;
	$("#desChioce01").find("li").each(function(idx) {
		$(this).click(function() {
			if(idx==4){
				return false;
			}
			menuIsC=true;
			$("#desChioce01 li").removeClass("current").eq(idx).addClass("current");
			if(idx == 0){
				var h = subtop[idx][0] - 23;
				$("html").animate({
					"scrollTop": h + "px"
				},function(){
					menuIsC = false;
				});

				$(document.body).animate({
					"scrollTop": h + "px"
				},function(){
					menuIsC = false;
				});
			}else{
				var h = subtop[idx][0] - 60;
				$("html").animate({
					"scrollTop": h + "px"
				},function(){
					menuIsC = false;
				});
				$(document.body).animate({
					"scrollTop": h + "px"
				},function(){
					menuIsC = false;
				});
			}
		});
	});	
		$(window).scroll(function() {
			scroll();
			if(!menuIsC){
				for(var i=0;i<subtop.length;i++){
					if($(window).scrollTop()>=(subtop[i][0]-120) ){

						$("#desChioce01 li").removeClass("current").eq(i).addClass("current") ;
					} 
				}
			} 
		});

		$(window).resize(function(){
			scroll();
		})

		/*判断页面顶部及右侧固定条*/
			function scroll(){
				var scroll = $(window).scrollTop();
				var drop_h = $('.main-4').offset().top-$('.main-r_1').height();
				if($('.img_playPar').offset().top<scroll){
					$('#desChioce01').show();
					var Left_li = $('#desChioce01 .price').offset().left;
					if(scroll<drop_h-24){

						$('.main-r_1').css({
							position:'fixed',
							left:Left_li-22+"px",
							top:'10px',
							zIndex:200
						})
					}
					/*右侧接触到底部的时候*/
					else if(scroll>=drop_h-24){
						$('.main-r_1').css({
							position:'absolute',
							left:Left_li-22+"px",
							top:drop_h-24,
							zIndex:200
						})
					}
				}else if($('.img_playPar').offset().top>=scroll){
					$('#desChioce01').hide();
					$('.main-r_1').css({
							position:'relative',
							left:'-1px',
							top:'0px',
							zIndex:1
						})	
				}

				

			}
		
	stockAddAttr();	
	
	var mindays = $("#mindays").val();
	
	var stockCnt =$("#stockCnt").val();
	
	if(stockCnt>0 && mindays==1){
		goBookBtnAddClick();
	}else{
		goBookBtnRemoveClick();
	}
	
	setskip();
	
	$('#goBookBtn').click(function(){	  
		goBookRoom();
	});
	
});	

// 评论
$('.pingjiaTit li').each(function(i) {
	$('.more_room_instro').hide();
	$(this).click(function(){
		var num = $(this).index();
		if(num==1){
			$('.more_room_instro').show();
			$('#attached_home02').show();
			$('#contact_roomer').hide();
	    }else if(num==0){
	    	$('.more_room_instro').hide();
	    	$('#attached_home02').hide();
			$('#contact_roomer').show();
	    }
		$(this).addClass('on').parent().siblings().children().removeClass('on');
		$(this).addClass('on').siblings().removeClass('on');
		if(parseInt($(this).find('span').html().replace('(','').replace(')',''))>=5)
		{
			$('.pingjiaTit').removeClass("no_score");
		}else
		{
			$('.pingjiaTit').addClass("no_score");
		}
		return false;
	});
});
/*评价*/
$('.more_ping').click(function(){
	
	if($(this).prev().height()==58){
		$(this).prev().height('auto');
		$(this).children('.ping_txt').text('收起');
		$(this).children('.more_btn').addClass('up_moreBtn');
	}else{
		$(this).prev().height('58px');
		$(this).children('.ping_txt').text('更多');
		$(this).children('.more_btn').removeClass('up_moreBtn');
	}		
})

	var h_room_he = $('.room_he').height(); 
    $('.room_he').addClass('room_he_close');
	if (h_room_he > 88) {		
		$(".more_Instro").show();
	}
	else
	{		
		var roommoreInfo = $("#roommoreInfo").val();	
		if(roommoreInfo!="")
		{		
			$(".more_Instro").show();
		}
		else
		$(".more_Instro").hide();
	}
	/*房源介绍点击更多*/
	var inster_scroll = 0;
	$('.more_Instro').click(function(){
		if($('.zhan_off').css('display')=='none'){
			  
			inster_scroll=$(document).scrollTop();
			$('.zhan_off').css('display','block');
			$('.room_he').addClass('room_he_open').removeClass('room_he_close');
			$(this).children('span').text('收起');
			$(this).children('i').addClass('up_moreBtn');
		}else{
			$('.zhan_off').css('display','none');
			$('.room_he').removeClass('room_he_open').addClass('room_he_close');
			$(this).children('span').text('');
			$(this).children('i').removeClass('up_moreBtn');
			$(document).scrollTop(inster_scroll);
		}
	})

   /*配套设施信息不可用的放到最后*/
     $('.peitao_ul li').each(function(){
     	if($(this).hasClass('no')){
     		$(this).remove();
     		$('.peitao_ul').append($(this));
     	}
     })

	
    $('.peitao_ul li:gt(7)').hide();
	var peiT_scroll=0;
    $('.more_peitao').click(function(){
    	if($('.peitao_ul li:gt(7)').is(":hidden")){
    		
    		peiT_scroll=$(document).scrollTop();
    		$('.peitao_ul li:gt(7)').show();
    		$(this).children('span').text('收起');
    		$(this).children('.more_btn').addClass('up_moreBtn');
    	}else{
    		$('.peitao_ul li:gt(7)').hide();
    		$(this).children('span').text('更多');
    		$(this).children('.more_btn').removeClass('up_moreBtn');
    		$(document).scrollTop(peiT_scroll);
    	}
    })

    /*房屋规则信息*/
    $('.zhu_rule').click(function(){
    	if($(".c_bar_box").is(":hidden")) {
    		$('.c_bar_box').show();
    		$(this).children('.more_btn').addClass('up_moreBtn');
    		$(this).children('.more_btn_green').addClass('up_moreBtn_green');
    	}else{
    		$('.c_bar_box').hide();
    		$(this).children('.more_btn').removeClass('up_moreBtn');
    		$(this).children('.more_btn_green').removeClass('up_moreBtn_green');
    	}
       
    })

    $(document).click(function(){
    	$('.xiala').hide();
    })

function stockAddAttr(){
	$('.xiala li a').each(
		function(i) {
			$(this).click(
				function(){
					
					$('#searchcityin_xq').val($(this).html());
					
					ajaxPriceDetial();
		});
	});
}

function ajaxPriceDetial(){
	
	var DEFAULT_VERSION = "8.0";
	var ua = navigator.userAgent.toLowerCase();
	var isIE = ua.indexOf("msie")>-1;
	var safariVersion;
	if(isIE){
	    safariVersion =  ua.match(/msie ([\d.]+)/)[1];
	}
	
	var ctx = $('#ctx').val();
	
	var checkinday=$("#checkinday").val();
	var checkoutday=$("#checkoutday").val();
	
	var roomid=$("#luid").val();
	var rNum = $('#searchcityin_xq').val();
	var roomnum=rNum.substring(0,rNum.length-1);
	var url=ctx+"/room/checkstock/";
	
	if(checkinday==''||checkoutday=='')
	{
		return;
	}
	
   	$.get(url, {
    roomid: roomid,roomnum:roomnum,checkinday:checkinday,checkoutday:checkoutday}, function(data) {
	    var jsonData = eval(data); 
	    var priceJson = jsonData.priceJson;
	    var discountNum = jsonData.discountNum
	    
	    var totalPrice = (priceJson.sum*roomnum)/100;
	    var originalTotalPrice = (priceJson.originalTotalPrice*roomnum)/100;
	    
	    //平均夜间价
	    var nightAve= priceJson.nightAvePrice;
	    var priceDetailHtml='总计￥<span>'+originalTotalPrice+'</span>';
	    var totleLHtml="";
	    var totleRHtml="";
	    
	    var calendarList = jsonData.calendarList;
	    
	    var ctx1 = $("#ctx1").val();
	    var fanji = $(".fanji_img");
	    if(discountNum != undefined){
	    	var ssr = ctx1+"/resourcesWap/topic/2016/shuangdan/images/"+discountNum+"d.png";
	    	$(".fanji_img").attr("src",ssr);
	    }
	    else if(fanji != undefined && discountNum == undefined)
	    {
	    	$(".fanji_img").remove();
	    }
	    $('#calendarUl').html("");
	    
	    var calendarHtml="";
	    for(var j=0;j<calendarList.length;j++){
	    	
	    	var showStock =calendarList[j].stock;
	    	
	    	if(showStock==0){
	    		calendarHtml+='<li class="none"><b style="font-size: 13px;">'+calendarList[j].date+'</b><p class="priceCal"><span>无房</span></p></li>';
	    	}else{
	    		calendarHtml+='<li><b style="font-size: 13px;">'+calendarList[j].date+'</b><p class="priceCal">￥<span>'+calendarList[j].price+'</span></p></li>';
	    	}
        }
	    
	    $('#calendarUl').html(calendarHtml);
	    
	    $('#timeL').css('border','');
		$('#timeR').css('border','');
	    
	    if(jsonData.stock==0){
	    	
	    	goBookBtnRemoveClick();
	    	$('#xiala').html("");
	    }else{
	    	goBookBtnAddClick();
		    $(".nofang").css('display','none');
		    if(safariVersion <= DEFAULT_VERSION ){
		    	$("#goBookBtn").css('background','#ffa200');
		    	
		    	$('#goBookBtn').hover(function(){$(this).css('background','#ffa200');},
		    			function(){$(this).css('background','#ffb400');});
		    	
		    	$("#goBookBtn1").css('background','#ffa200');
		    	
		    	$('#goBookBtn1').hover(function(){$(this).css('background','#ffa200');},
		    			function(){$(this).css('background','#ffb400');});
		    	
			}else{
				$("#goBookBtn").css('background','');
		    	$("#goBookBtn1").css('background','');
			}
		    
	    	
	    	var stockListHtml="<ul>";
	        for(var i=1;i<=jsonData.stock;i++){
	        	
	        	var stockHtml ='<li><a href="javascript:void(0);" id="stock'+i+'" >'+i+'套</a></li>'
	        	stockListHtml =stockListHtml+stockHtml;
	        }
	        
	        stockListHtml=stockListHtml+'</ul>';
	        
	        
	        $('#xiala').html(stockListHtml);
	        
	        
	        stockAddAttr();
	        
	        $("#hasStock").val('1');
	    	$("#tipMsg").hide();
	    }
	    
	    if(!($('#specialdiscount')&&$('#specialdiscount').val()))
		{
	    	totleLHtml= '<span>房东规定：特殊价格不参与打折</span>';
	    }
    
    	totleRHtml='<span>总计：<font>￥'+totalPrice+'</font></span>'
    
	    var pricenum=0;
    	var priceLHtml;
	    var itemHtml='<tr><th style="width:149px">日期</th><th style="width:149px">单价</th><th style="width:100px">数量</th><th style="width:100px">小计</th></tr>';
	    for(var i in priceJson.items){
	    	
	    	var item=priceJson.items[i];
	    	priceLHtml ='￥<span>'+(priceJson.items[0].price)/100+'</span>/晚';
	    	if(i==0&& nightAve != undefined && (nightAve >(priceJson.items[0].price)/100) ){
	    		priceLHtml	+=  "<p class='f16' style='margin-left:5px;display:inline-block;text-decoration: line-through;color:#777'><font>￥</font>"+nightAve+"</p>";
	    	}
	    	itemHtml +='<tr><td>'+item.date+'</td><td>￥'+(item.price/100)+'</td><td>'+roomnum+'</td><td>￥'+(item.price/100)*roomnum+'</tr>';
	    	
	    }	   
	    $(".priceL").html(priceLHtml);
	    $("#priceTotalL").html(priceDetailHtml);
	    if(originalTotalPrice!=totalPrice)
    	{
	    	 $("#priceTotalL").addClass("orgPrice");
	    	 var desc1 = priceJson.desc1;
	    	 var desc2 = priceJson.desc2;
	    	 var str = "折扣价￥"+totalPrice+"(";
	    	 if(desc1 !=undefined && desc1 !=""){
	    		 str +="<span>"+desc1+"</span>"; 
	    	 }
	    	 str += "<span style='color: rgb(255, 88, 114);'>省"+(Math.round((originalTotalPrice-totalPrice)*100)/100)+"元</span>"
	    	 if(desc2 !=undefined && desc2 !=""){
	    		 str +="<span>"+desc2+"</span>"; 
	    	 }
	    	 str +=")";
	    	 $("#discountTotal").html(str); 
    	}else
		{
    		 $("#priceTotalL").removeClass("orgPrice");
    		 $("#discountTotal").html("");
		}
	    
	    $("#totleL").html(totleLHtml);
	    $("#totleR").html(totleRHtml);
	    $("#itemDetail").html(itemHtml);
	    
	    $("#nights").val(jsonData.nights);
    	if(jsonData.status!=1){
		    $("#hasStock").val('0');
	    	goBookBtnRemoveClick();
	    }
	    
	})    
}

function goBookRoom(){
    var roomid=$("#luid").val();
    
    var rNum = $('#searchcityin_xq').val();
    var roomnum=rNum.substring(0,rNum.length-1);
    
	var checkinday=$("#checkinday").val();
	var checkoutday=$("#checkoutday").val();
	
	if(checkinday==''||checkoutday=='')
	{	
		
		$(".nofang").html('请选择入住日期');
	    $(".nofang").css('display','block');
		return;
	}
	var ctx = $('#ctx').val();
	var checkUrl=ctx+"/room/checkstock/";
   	$.get(checkUrl, {
    roomid: roomid,roomnum:roomnum,checkinday:checkinday,checkoutday:checkoutday}, function(data) {
    	var jsonData = eval(data);
    	
	    if(jsonData.status!=1){
    	    $("#hasStock").val('0');
    	    $(".nofang").html(jsonData.tipmsg);
		    $(".nofang").css('display','block');
	    	goBookBtnRemoveClick();
        }else{
        	var fromsea='';
        	var ref = window.top.document.referrer;
        	if(ref.indexOf("sea.html")>=0){
        		fromsea ="?type=fromsea";
        	}
        	var url = ctx+"/order/waitinit/room-"+roomid+"_roomnum-"+roomnum+"_checkinday-"+checkinday+"_checkoutday-"+checkoutday+fromsea;
        	var comefrom = $("#hidden_comefrom").val();
        	if (comefrom == 'youxuan') {
        		url = url + "?comefrom=youxuan"
        	} 
   			window.location.href=url;
        }
   	});
}

function goBookBtnAddClick(){
	$('#goBookBtn1').click(function(){
		$("body,html").stop();
		goBookRoomFlag=1;
	});

	$('#goBookBtn').click(function(){	  
		goBookRoomFlag=1;
	 
	});
}

function goBookBtnRemoveClick(){
	$('#goBookBtn1').click(function(){	
		goBookRoomFlag=2;
		$('#timeL').css('border','solid 3px #f80');
		$('#timeR').css('border','solid 3px #f80');
		$('body,html').animate({scrollTop:0},500);
		
	});

	$('#goBookBtn').click(function(){	    
		goBookRoomFlag=2;
	});
}

/*分享按钮hover*/
$('.share_parent').mouseover(function(){
	$(this).find('#fx_word').hide();
	$(this).find('.share').show();
})

$('.share_parent').mouseout(function(){
	$(this).find('#fx_word').show();
	$(this).find('.share').hide();
})

/*分享中微信按钮浮层*/
$('.weixin').mouseover(function(){
	$(this).next().show();
})
$('.weixin').mouseout(function(){
	$(this).next().hide();
})
//////////////////////////////新评论///////////////////////////////////
//评论分页	
var loadPageComment = function(pageNo,type,skipFlag) {	
	if (type == "1") {
		var lodgeunitid = $('#luid').val();
		getCommentPage("lodgeunitPJ_cnt", lodgeunitid, pageNo, type,skipFlag);
	} else {
		var lordid = $('#ownerid').val();
		getCommentPage("lordPJ_cnt", lordid, pageNo,type,skipFlag);
	}
}
//获得评论公共方法
function getCommentPage(commentTypeId,searchid,pageNo,type,skipFlag)
{
	if(skipFlag==null||skipFlag==true)
	$('#pjskip').click();
	var pageSize= 10;	
	var lordHeadImg = $("#lordHeadImg").val();	
	var pageNo = parseInt(pageNo);	
	var ctx = $('#ctx').val();
	var ctx1 = $('#ctx1').val();	
	var dataType;	
	if($('#hasContent').prop("checked")){
		dataType = 1;
	}else{
		dataType = 2;
	}			
	$.ajax({
		url :  ctx + "/comment/id-"+searchid+"/type-"+type+"/dataType-"+dataType+"/comments-p"+pageNo+"-"+pageSize+".json",
		type : 'get',
		success : function(data) {
			var jsonObj=eval(data);
			if(jsonObj.totalPage!=0){			
				if(jsonObj && jsonObj.status==1){
					var jsonData = jsonObj.data.comments;
					var totalCount =   parseInt(jsonObj.totalCount);					
					var pageCount = parseInt(totalCount/pageSize);					
					if(parseInt(totalCount%pageSize)!=0)
						pageCount=pageCount+1;		
					if(pageNo>pageCount)
						pageNo = pageCount;
					if(pageNo<1)
						pageNo = 1;					
					var commentListDivHtml='';					
					for(var item in jsonData)
					{	
						
						var commentid= jsonData[item].id
						var content = jsonData[item].content;
						var tenant = jsonData[item].tenant;
						var timeString = jsonData[item].checkindayStr;		
						var tenantHeadImg = jsonData[item].tenant.headimageurl;
						var nickname = jsonData[item].tenant.nickname;
						var username = jsonData[item].tenant.username;						
						if(tenantHeadImg==null||tenantHeadImg=='')
							tenantHeadImg = ctx1+'/resourcesWeb/images/default_headImg.jpg';
						
						commentListDivHtml += '<div class="pingjiaDes clearfloat">';
						commentListDivHtml += '<div class="roomer_photo fl">';
						commentListDivHtml += '<img  src="'+tenantHeadImg+'" alt="" />';
						commentListDivHtml += '<span>';
						commentListDivHtml += tenant.shownickname;				
						commentListDivHtml += '</span>';
						commentListDivHtml += '</div>';
						commentListDivHtml += '<div id="houseDes" class=\'fl\'>';
						commentListDivHtml += '<div class=\'pingjia_tiao relave\'>';
						commentListDivHtml += '<div class="des">';
						commentListDivHtml += '<div class=\'pingjia_cnt1\'>';
						var shortContent = "";
						if(content.length>0){
							shortContent = content;
			        	}else{
			        		shortContent = '该房客只打了分，暂无文字内容';
			        	}
						commentListDivHtml += shortContent;
						commentListDivHtml += '</div>';
						commentListDivHtml += '<span class=\'more_ping relave\'><i class=\'ping_txt\'>更多</i><i class="absot more_btn"></i></span>';
						commentListDivHtml += '</div>';		
						if(type=="2")
						{
							
							var lodgeunit = jsonData[item].lodgeunit;	
							if(lodgeunit!=null)
							{  
								var roomtitle = jsonData[item].lodgeunit.title;
								var roomid = jsonData[item].lodgeunit.id;
							    commentListDivHtml += '<div class=\'more_room_instro absot\'><a href="'+ctx+'/room/'+roomid+'" target=_blank><span class=\'absot\'></span>'+roomtitle+'</a></div>';
							}
						}
						commentListDivHtml += '<div class="bottom absot">';					
						commentListDivHtml += '<div class="time"><span>'+timeString+'入住</span></div>';
						commentListDivHtml += '</div>';
						commentListDivHtml += '</div>';
						var recomment = jsonData[item].recomment;						
			        	var recomentHtml = "";
			        	if(recomment != null && recomment.content != null && recomment.content.length > 0){
			        		var createtime = recomment.createtime.substring(0,18);
			        		recomentHtml += '<div class=\'roomer_reply relave clearfloat\'>';
			        		recomentHtml += '<img  src="'+lordHeadImg+'" alt="" class=\'fl roomer_toux\'/>';
			        		recomentHtml += '<div class=\'reply_cnt fl\'>';	
			        		recomentHtml += '<h4>房东回复：</h4>';	
			        		recomentHtml += '<div>'+recomment.content+'</div>';	
			        		recomentHtml += '<div class="bottom absot reply_time">';
			        		recomentHtml += '<div class="time">';
			        		recomentHtml += '<span>'+createtime+'</span>';
			        		recomentHtml += '</div>';
			        		recomentHtml += '</div>';
			        		recomentHtml += '</div>';
			        		recomentHtml += '</div>';			        		
			        	}	
			        	commentListDivHtml += recomentHtml;
			        	commentListDivHtml += '</div>';
			        	commentListDivHtml += '</div>';	
					}	
					var pageHtml  = "";
					if(pageCount>1)
					{
							pageHtml = "<div class=\"page_turn\" id=\""+commentTypeId+"page\">";					
		                    var pm = new pageModel(pageNo,pageSize,totalCount);                   
		                    var lastPage=5;
		                    var currentPageItem = pm.getCurrentPageItem();                    
							if(pm.isHavePrePage())
							{
								pageHtml+="<a href=\"javascript:loadPageComment('"+(pageNo-1)+"','"+type+"')\" rel=\"nofollow\" class=\"up-page\">&lt;</a>";
							}
							for(var i=0;i<currentPageItem.length;i++)
							{
								var pgclass = "";
								if(currentPageItem[i]==pageNo)
								{
									pgclass = "pg-active";
								}
								pageHtml+="<a class='"+pgclass+"'  href=\"javascript:loadPageComment('"+currentPageItem[i]+"','"+type+"')\" rel=\"nofollow\">"+currentPageItem[i]+"</a>";
								lastPage = 	parseInt(currentPageItem[i]+1);
							}
							if (pageCount>lastPage+1)
							{
								pageHtml+="<a href=\"javascript:void(0)\">...</a>";
								pageHtml+="<a   href=\"javascript:loadPageComment('"+pageCount+"','"+type+"')\" rel=\"nofollow\">"+pageCount+"</a>"; 
							}
							if(pm.isHaveNextPage())
						    {																		
								pageHtml+="<a href=\"javascript:loadPageComment('"+(pageNo+1)+"','"+type+"')\" rel=\"nofollow\" class=\"up-page\">&gt;</a>";
						    }		
							pageHtml+="</div>";
				     }
		        	commentListDivHtml += pageHtml;			        	
					$('#'+commentTypeId).html(commentListDivHtml);		
					/*评价*/
					$('.pingjia_cnt1').each(function(){
						if($(this).height()>60){
							$(this).addClass('over');
							$(this).next().show();
						}else{
							$(this).next().hide();
							$(this).removeClass('over');

						}
					})				
					/*评价*/
					$('.more_ping').click(function(){
						
						if($(this).prev().height()==58){
							$(this).prev().height('auto');
							$(this).children('.ping_txt').text('收起');
							$(this).children('.more_btn').addClass('up_moreBtn');
						}else{
							$(this).prev().height('58px');
							$(this).children('.ping_txt').text('更多');
							$(this).children('.more_btn').removeClass('up_moreBtn');
						}		
					})
	        	}				
			}			
    	}
		});
}
/**
 * 获得头像
 * @param url
 * @param needMayi
 * @param width
 * @param height
 * @param isCut
 * @param quality
 * @returns {String}
 */
function getHeadImgUrl(url,needMayi,width,height,isCut,quality)
{
	var str = "_"+width+"x"+height + "c.jpg";
	var empUrl = "";
	if(url!=null&&url!='')
	{
		if(url.indexOf("http")>-1)
		{		
			if(url.indexOf("resourcesWeb")==-1)
			{
				url = url.replace(url.substring(url.indexOf("_"),url.lastIndexOf(".")),str);
			}
			return url;
		}
		else
		{					
			 url = "http://i1.mayi.com/" + url + ".jpg" + str;
			 return url;
		}		
	}
	else
		return empUrl;	
}

$(function(){
	
	var suding_tan = $('.suding_tan');
	if(suding_tan!=null && suding_tan.length>0)
	{
		var sdtan = getCookie('sdtan');
		if(sdtan==undefined){
			$('.suding_tan').fadeIn(600);
			setTimeout(function(){
				$('.suding_tan').hide();
			},3000);
			setCookie('sdtan',1,10*24*3600);
		}
	}
	
	
	$('.suding_icon').hover(function(){
		$(this).parent().children('.suding_tan').show();
	},function(){
		$(this).parent().children('.suding_tan').hide();
	})
	/*查看开票须知*/
	$(".invoice_notes_btn").click(function(){
		$(".invoice_link").show();
	})
	$(".invoice_close").click(function(){
		$(".invoice_link").hide();
	})
	
})