$(function(){
	var picList = $('#picsmall li').length;
	var picSmallWidth = $('#picsmall li').height()+10;
	var picLength = picList*picSmallWidth;
	var index=0;
    var length=$(".piclist li").length;
    var i=1;
    
    var setTimer = setInterval(slideNext, 6000);
    function run() {
       setTimer = setInterval(slideNext, 6000);
    }
    function stopa(){
       clearInterval(setTimer);
    }

    $('#TabChangeCon_01').hover(function(){
         stopa();
    },function(){
       run();
    });
    $('#picsmall').css('height',picLength);
    //房源详情页图片画廊展示效果
    $('.piclist,#big_play_prev,#big_play_next').hover(function(){
            $('#big_play_prev').stop().animate({top:'0%'},500);
            $('#big_play_next').stop().animate({bottom:'0%'},500);
        },function(){
            $('#big_play_prev').stop().animate({top:'50%'},500);
            $('#big_play_next').stop().animate({bottom:'50%'},500);
    });
    function showImg(i){
        $(".piclist li")
            .eq(i).stop(true,true).fadeIn(800)
            .siblings("li").hide();
         $("#picsmall li").children("a").removeClass("current").eq(i).addClass("current");
         var  arrs = $("#picsmall li"); 
			for(var j=0;j<arrs.length;j++)
			{
				$(arrs[j]).attr("class","minPic");	
			} 
        }

        function slideNext(){	
      
        if(index >= 0 && index < length-1) {
            ++index;
            showImg(index);
        }else if(picList == 6 || picList == 5){
            showImg(0);
            index=0;
            return false;
        }else{
			showImg(0);
			index=0;
			aniPx=(length-7)*70+'px'; //所有图片数 - 可见图片数 * 每张的距离 = 最后一张滚动到第一张的距离
			$("#picsmall").animate({ "top": "+="+aniPx },200);
			i=1;
            return false;
        }
        if(i<0 || i>length-7) {return false;}				  
           $("#picsmall").animate({ "top": "-=70px" },200);
           i++;
    }
     
    function slideFront(){
       if(index >= 1 ) {
             --index;
             showImg(index);
        }
        if(i<2 || i>length+7) {return false;}
               $("#picsmall").animate({ "top": "+=70px" },200);
               i--;
   	 }	
        $(".piclist li").eq(0).show();
        $("#picsmall li").eq(0).children("a").addClass("current");
//       $("body").on("#big_play_next,#play_next",function(){
//      	slideNext();
//          return false;
//      })
        $("#big_play_next,#play_next").click(function(){
            slideNext();
            return false;
        });
//       $("body").on("click","#big_play_prev,#play_prev",function(){
//      	slideFront();
//          return false;
//      })
        $("#big_play_prev,#play_prev").click(function(){
            slideFront();
            return false;
        });
//      
        $("body").on("click","#picsmall li",function(){
        	
        	 index  =  $("#picsmall li").index(this);
            showImg(index);
            return false;
        })
//      $("#picsmall li").click(function(i){
//      	
//          index  =  $("#picsmall li").index(this);
//          console.log(this);
//          showImg(index);
//          return false;
//      });	
});
