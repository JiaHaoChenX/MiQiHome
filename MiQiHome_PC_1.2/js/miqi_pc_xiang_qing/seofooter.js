/**
 * Created by admin on 2017/9/4.
 */
/*360自动收录*/
(function(){
var src = (document.location.protocol == "http:") ? "http://js.passport.qihucdn.com/11.0.1.js?4a081a8cc466e69349b219f72b3f9851":"https://jspassport.ssl.qhimg.com/11.0.1.js?4a081a8cc466e69349b219f72b3f9851";
document.write('<script src="' + src + '" id="sozz"><\/script>');
})();

$(function(){
//订单文字滚动
    var num = 0;
    function goLeft() {
        if (num == -2440) {
            num = 0;
        }
        num -= 1;
        $(".cont-ul").css({
            left: num
        })
    }
    //设置滚动速度
    var timer = setInterval(goLeft, 20);
    //设置鼠标经过时滚动停止
    $(".carousel_box").hover(function() {
            clearInterval(timer);
        }, function() {
            timer = setInterval(goLeft, 20);
        })
//文字滚动结束
        
    $('.city_classify ul li').each(function(){
        $(this).hover(function(){
            $(this).addClass("choiced_bg_color").siblings().removeClass("choiced_bg_color");
            var idx = $(this).index();
            $(".big_classify_box .classify_box").hide().eq(idx).show();
        })
    })
    
    //footer的展开与收起
    $(".footer_open").click(function(){
        $(this).parent().css("height","auto");
        $(this).siblings(".footer_close").css("display","block");
        $(this).css("display","none");
    })
    $(".footer_close").click(function(){
        $(this).parent().css("height","75px");
        $(this).siblings(".footer_open").css("display","block");
        $(this).css("display","none");
    });
})

