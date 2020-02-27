$(function() {
	$(".close-alert1").click(function() {
		$(".alert-box1").hide();
	})
	$(".close-alert2").click(function() {
		$(".alert-box2").hide();
	})
})

function loginowner(userid) {

	var ctx = $('#ctx').val();
	$.get(ctx + "/user/checkFrozenAccount?frozenOwnerid=" + userid,
			function(re) {

				if (re == 1) {
					$(".alert-box1").show();
				} else {
					var ctx = $('#ctx').val();
					location.href = ctx + "/landlord/" + userid + "/orders";
				}
			});
}

function publish(userid) {
	$(".alert-box2").show();
//	var ctx = $('#ctx').val();
//	$.get(ctx + "/user/checkFrozenAccount?frozenOwnerid=" + userid,
//			function(re) {
//				if (re == 1) {
//					$(".alert-box1").show();
//				} else {
//					$.get(ctx + "/room/publish/checkOfflineRoom", function(re) {
//						if (re.status == 1) {
//							layer.alert("鎮ㄦ澶勪簬杩濊涓嬬嚎鏈熼棿锛屾棤娉曞彂甯冩柊鎴挎簮", 5);
//							return false;
//						} else {
//							var ctx = $('#ctx').val();
//							location.href = ctx + "/room/publish/basicinfo";
//						}
//					});
//				}
//			});
}

function menufrozen(userid, url, frozentype) {

	var ctx = $('#ctx').val();
	var furl = ctx + "/user/checkFrozenAccount?frozenOwnerid=" + userid;
	furl += "&frozentype=" + frozentype;
	$.get(furl, function(re) {
		if (re == 1) {
			if (frozentype == 'user') {
				$(".frozeninfo").text("瀵逛笉璧凤紝鐢ㄦ埛璐﹀彿琚皝绂�");
			}
			$(".alert-box1").show();
		} else {
			location.href = url;
		}
	});
}