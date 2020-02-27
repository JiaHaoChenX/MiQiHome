;
(function(win, $) {
	$("#inote-login").css("color", "white").css("background-color", "#22BB62");
	$("#inormal-login ").mousedown(function() {
		$("#inormal-login").css("color", "white").css("background-color", "#22BB62");
		$("#inote-login").css("color", "#adadad").css("background-color", "white");
		$(".inormal-show").prop("hidden", "");
		$(".note-show").prop("hidden", "hidden");
	});
	$(".note-login ").mousedown(function() {
		$("#inote-login").css("color", "white").css("background-color", "#22BB62");
		$("#inormal-login").css("color", "#adadad").css("background-color", "white");
		$(".note-show").prop("hidden", "");
		$(".inormal-show").prop("hidden", "hidden");
	});
	/*微信悬浮事件*/
	$(".reg-right-p2").hover(function() {
		$(".reg-right-span1").css("background-color", "#0EBC5F");
		$(".i-span1").css("color", "white")
		$(".reg-right-weixin").css("color", "#0EBC5F");
	}, function() {
		$(".reg-right-span1").css("background-color", "");
		$(".i-span1").css("color", "")
		$(".reg-right-weixin").css("color", "");
	});
	/*qq悬浮事件*/
	$(".reg-right-p3").mouseenter(function() {
		$(".reg-right-span2").css("background-color", "#00BCEA");
		$(".i-span2").css("color", "white")
		$(".reg-right-qq").css("color", "#00BCEA");
	});
	/*鼠标离开QQ事件*/
	$(".reg-right-p3").mouseout(function() {
		$(".reg-right-span2").css("background-color", "");
		$(".i-span2").css("color", "")
		$(".reg-right-qq").css("color", "");
	})
	/*微博悬浮事件*/
	$(".reg-right-p4").hover(function() {
		$(".reg-right-span3").css("background-color", "#FC7212");
		$(".i-span3").css("color", "white")
		$(".reg-right-weibo").css("color", "#FC7212");
	}, function() {
		$(".reg-right-span3").css("background-color", "");
		$(".i-span3").css("color", "")
		$(".reg-right-weibo").css("color", "");
	});

	$(".middle_close").click(function() {
		$(".all").css("display", "none");
	})

	

})(window, $);