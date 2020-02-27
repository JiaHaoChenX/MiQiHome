//工具

document.write("<script src='js/public_js/jquery/jquery-1.11.3.min.js' type='text/javascript' charset='utf-8'></script>");
var util = {
	//获取url中的参数
	getUrlParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg); //匹配目标参数
		if(r != null) return unescape(r[2]);
		return null; //返回参数值
	},
	//获取n天后的日期
	fun_date(aa) {
		var date1 = new Date(),
			time1 = date1.getFullYear() + "-" + (date1.getMonth() + 1) + "-" + date1.getDate(); //time1表示当前时间
		var date2 = new Date(date1);
		date2.setDate(date1.getDate() + aa);
		return time2 = date2.getFullYear() + "-" + (date2.getMonth() + 1) + "-" + date2.getDate();
	},
	//获取当前时间
	getNowFormatDate() {
		var date = new Date();
		var seperator1 = "-";
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var strDate = date.getDate();
		if(month >= 1 && month <= 9) {
			month = "0" + month;
		}
		if(strDate >= 0 && strDate <= 9) {
			strDate = "0" + strDate;
		}
		var currentdate = year + seperator1 + month + seperator1 + strDate;
		return currentdate;
	},
	//时间戳转时间
	timestampToTime(time) {
		var now = new Date(time);
		var qud = "";
		return times = now.getFullYear() + "-" + ((now.getMonth() + 1) < 10 ? "0" : "") + (now.getMonth() + 1) + "-" + (now.getDate() < 10 ? "0" : "") + now.getDate();
	},
	//跨域获取IP地址	
	getIpconfig() {
		let ip = "";
		$.ajax({
			type: "get",
			url: "js/ipconfig.json",
			async: false,
			success: function(data) {
				ip = data.ip;
			}
		});
		return ip;
	},
	//获取当前日期 YYYY-MM-DD
	getNowFormatDate(num) {
//		alert(num);
		var date = new Date();
		var seperator1 = "-";
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var strDate = date.getDate();
		if(month >= 1 && month <= 9) {
			month = "0" + month;
		}
		if(strDate >= 0 && strDate <= 9) {
			if(num != "" && num != undefined) {
				strDate = "0" + (strDate + num);
			} else {
				strDate = "0" + strDate;
			}
		}
		var currentdate = year + seperator1 + month + seperator1 + strDate;
		return currentdate;
	},
	//计算两个日期的相隔天数
	getCalcDate(startTime, endTime) {
		let sTime = new Date(startTime); // 开始时间
		let eTime = new Date(endTime); // 结束时间
		let usedTime = eTime - sTime; // 相差的毫秒数
		let days = Math.floor(usedTime / (24 * 3600 * 1000)); // 计算出天数
		return days;
	}
};