function scrollPage(obj)
{
    var windowHeight = $(window).height();
    var offsetTop = parseInt(obj.offset().top);
    var scrollTop = $(document).scrollTop();
    var suggestionHeight = obj.height();
    if( (windowHeight - (offsetTop - scrollTop)) - suggestionHeight < 0 ) {
        var newTopHeight = scrollTop + (suggestionHeight + 10 ) - (windowHeight - (offsetTop - scrollTop));
        $('html,body').animate({ scrollTop: newTopHeight }, 300);
    }

}

function pad(num, n) {
    var len = num.toString().length;
    while(len < n) {
    	
        num = "0" + num;
    }
    return num;
}

function getShortWeekNameByDate(date)
{
    var week = new Array("周日", "周一", "周二", "周三", "周四", "周五", "周六");
    return week[new Date(date).getDay()];
}

function getDateDiff(sDate1, sDate2){
    var sDate = new Date(sDate1.replace(/-/g, "/"));
    var eDate = new Date(sDate2.replace(/-/g, "/"));
    var timediff = eDate.getTime() - sDate.getTime();
    var daydiff = parseInt(timediff/1000/60/60/24);
    return daydiff;
}

var numToStr = function(n,num) {
    numStr = num.toString();
    var l = numStr.length;
    for (var i=1; i<= n - l;++i) {
        numStr = '0'+numStr;
    }
    return numStr;
}


/*yuandan : [ "2016-1-1", "2017-1-1", "2018-1-1", "2019-1-1", "2020-1-1"],
chuxi   : [ "2016-2-7", "2017-1-27", "2018-2-15", "2019-2-4", "2020-1-24"],
chunjie : [ "2016-2-8", "2017-1-28", "2018-2-16", "2019-2-5", "2020-1-25"],
yuanxiao: [ "2016-2-22", "2017-2-11", "2018-3-2", "2019-2-19", "2020-2-8"],
qingming: [ "2016-4-4", "2017-4-4", "2018-4-5", "2019-4-5", "2020-4-4"],
wuyi    : [ "2016-5-1", "2017-5-1", "2018-5-1", "2019-5-1", "2020-5-1"],
duanwu  : [ "2016-6-9", "2017-5-30", "2018-6-18", "2019-6-7", "2020-6-25"],
zhongqiu: [ "2016-9-15", "2017-10-4", "2018-9-24", "2019-9-13", "2020-10-1"],
guoqing : [ "2016-10-1", "2017-10-1", "2018-10-1", "2019-10-1", "2020-10-1"]*/
try{
    var calendarV2 = function(e, options) {
        options = options || {};

        this.classWeek   = options.classWeek || 'calendar-week';
        this.classTitle   = options.classTitle || 'calendar-title';
        this.classMonth   = options.classMonth || 'calendar-month';
        this.classDay   = options.classDay || 'calendar-day';
        this.classDayBase   = options.classDayBase || 'line2';
        this.classDayShow   = options.classDayShow || 'show-date';
        this.classDaySelect = options.classDaySelect || 'cal_select';
        this.classDayPass = options.classDayPass || 'old';
        this.classDayUnSelectAble = options.classDayUnSelectAble || 'unselectable';
        this.classPink = options.classPink || 'pink';
        this.prependHtml   = options.prependHtml || '';
        this.today   = options.today || new Date();

        this.fillDayInfo = options.fillDayInfo || null;
        this.getDayInfo  = options.getDayInfo || null;

        this.checkState = 0;
        this.doColor = false;

        this.checkIn      = options.checkIn || null;
        this.checkOut     = options.checkOut || null;
        this.checkDayChange = options.checkDayChange || function(){};
        this.setDay = new Date();

        this.dateArray      = [];
        this.monthArray     = [];
        this.calenderHTML   = '';
        this.clearDateHtml   = '';
        this.preMonthHtml   = '';
        this.nextMonthHtml   = '';
        this.totalMohth     = 2;
        this.firstGray = false;
        this.holidays={
	        yuandan : [ "2018-1-1", "2019-1-1", "2020-1-1"],
	        chuxi   : [ "2018-2-15", "2019-2-4", "2020-1-24"],
	        chunjie : [ "2018-2-16", "2019-2-5", "2020-1-25"],
	        yuanxiao: [ "2018-3-2", "2019-2-19", "2020-2-8"],
	        qingming: [ "2018-4-5", "2019-4-5", "2020-4-4"],
	        wuyi    : [ "2018-5-1", "2019-5-1", "2020-5-1"],
	        duanwu  : [ "2018-6-18", "2019-6-7", "2020-6-25"],
	        zhongqiu: [ "2018-9-24", "2019-9-13", "2020-10-1"],
	        guoqing : [ "2018-10-1", "2019-10-1", "2020-10-1"],
	        xiuxi 	: [ "2018-9-22","2018-9-23","2018-9-24","2018-10-1","2018-10-2","2018-10-3","2018-10-4","2018-10-5","2018-10-6","2018-10-7"],
	        shangban: [ "2018-9-29","2018-9-30"]
        	
        }
        this.datename={
            "today"   : "今天",
            "yuandan" : "元旦",
            "chuxi"   : "除夕",
            "chunjie" : "春节",
            "yuanxiao": "元宵",
            "qingming": "清明",
            "wuyi"    : "五一",
            "duanwu"  : "端午",
            "zhongqiu": "中秋",
            "guoqing" : "国庆",
            "xiuxi"	  : "休",
            "shangban": "班"
        };

        this.e = typeof(e) == 'object' ? e : $(e);

        this.init();

        return(this);
    }
    calendarV2.prototype.init = function() {
        this.dateArray      = [];
        this.monthArray     = [];
        this.calenderHTML   = '';
        this.checkState = 0;
        this.gengerateCalArray().gengerateCalHtml().fillCalender();
        this.bindEvent();
        return(this);
    }
    calendarV2.prototype.preMonth = function() {
        if((this.today.getMonth() == this.firstDate.m) && (this.today.getFullYear() == this.firstDate.y) ){
            return false;
        }
        else {
            this.setDay.setDate(1);
            (this.firstDate.m == 0) ? (this.setDay.setMonth(11)) : this.setDay.setMonth(this.firstDate.m-1);
            (this.firstDate.m == 0) ? (this.setDay.setFullYear(this.firstDate.y-1)) : this.setDay.setFullYear(this.firstDate.y);
            this.dateArray      = [];
            this.monthArray     = [];
            this.calenderHTML   = '';
            this.checkState = 0;
            this.gengerateCalArray().gengerateCalHtml().fillCalender();
            this.bindEvent();
            return(this);
        }
    }
    calendarV2.prototype.nextMonth = function() {
        this.setDay.setDate(1);
        (this.lastDate.m == 0) ? this.setDay.setMonth(11) : (this.setDay.setMonth(this.lastDate.m-1));
        (this.lastDate.m == 0) ? this.setDay.setFullYear(this.lastDate.y-1) :this.setDay.setFullYear(this.lastDate.y);
        this.dateArray      = [];
        this.monthArray     = [];
        this.calenderHTML   = '';
        this.checkState = 0;
        this.gengerateCalArray().gengerateCalHtml().fillCalender();
        this.bindEvent();
        return(this);
    }
    calendarV2.prototype.setYmd = function(y,m,d, isDisplay) {
        var cdate = new Date();
        this.setDay = new Date();
        m = isDisplay ? m - 1 : m;
        cdate.setDate(1);
        cdate.setMonth(m);
        cdate.setFullYear(y);
        cdate.setDate(d);
        return cdate;
    }
    calendarV2.prototype.getYmd = function(s) {
        return s.getFullYear() + '-' + numToStr(2,s.getMonth() + 1) + '-' + numToStr(2,s.getDate());
    }

    calendarV2.prototype.gengerateCalArray = function() {
        for (var i = 0; i <= this.totalMohth; i++) {
            var toMonth = this.setDay.getMonth();
            for (var j = 1; j <= 37; j++) {
                this.setDay.setDate(j);
                if (this.setDay.getMonth() != toMonth){
                    break;
                }
                this.dateArray.push({y:this.setDay.getFullYear(),m:this.setDay.getMonth(),d:this.setDay.getDate(),w:this.setDay.getDay()});
            };
        };
        this.firstDate = this.dateArray[0];
        this.lastDate  = this.dateArray[this.dateArray.length -1];
        return(this);
    }

    calendarV2.prototype.gengerateCalHtml = function() {
        this.calenderHTML = '';
        this.monthArray = [];
        var m = -1;
        var len = this.dateArray.length - 1;
        for (var i = 0; i <= len; i++) {
            var day = this.dateArray[i];
            var cc = this.setYmd(day.y,day.m,day.d,false);
            if (m == -1) m = day.m;
            if (m != day.m) {
                this.calenderHTML += this.genMonth();
                this.monthArray = [];
                m = day.m;
            }
            this.monthArray.push(day);
        };
        return(this);
    }

    calendarV2.prototype.genDate = function(day) {
        var writeDay = this.setYmd(day.y,day.m,day.d,false);
        var old = '';
        var unselectable = '';
        var checkDay = '';
        var isToday = this.getYmd(writeDay) == this.getYmd(this.today) ? 1 : 0;
        var dayText = isToday ? '今天' : this.getDateDesc(day);
        if(isNaN(dayText) && (dayText == '休' || dayText == '班')){
        	dayText = day.d;
        }
        var flagxiu = this.getDateDesc(day);
        var flagban = this.getDateDesc(day);
        
        if (writeDay < this.today) old = this.classDayPass;
        if (writeDay>=this.today && writeDay < this.checkIn && this.checkOut == null) unselectable = this.classDayUnSelectAble;
        if (    (this.checkIn && writeDay <= this.checkOut && writeDay > this.checkIn) ||
            (this.checkOut && this.getYmd(writeDay) == this.getYmd(this.checkOut)) ||
            (this.checkIn && this.getYmd(writeDay) == this.getYmd(this.checkIn))
        ) {
            checkDay = this.classDaySelect;
        }
        if (this.checkIn && this.getYmd(writeDay) == this.getYmd(this.checkIn)) dayText = '入住';
        if (this.checkOut && this.getYmd(writeDay) == this.getYmd(this.checkOut)) dayText = '退房';

        if(old) {
            var li_classes = [this.classDayBase, old, checkDay];
        }
        else if(unselectable) {
            var li_classes = [this.classDayBase, unselectable];
        }
        else {
            var li_classes = [this.classDayBase, this.classDayShow, checkDay];
        }
        var li_html = '';
        
        if(dayText == '今天'){
        	li_html =  '<li class="'+ li_classes.join(' ') +'" d="'+day.d+'" m="'+day.m+'" y="'+day.y+'" w="'+day.w+'" today="'+isToday+'" ymd="'+this.getYmd(writeDay)+'" ><span>'+ dayText +'</span>';
        	for(var propety in this.holidays) {
        		if(this.holidays.hasOwnProperty(propety)){
        			var curHoliday = this.holidays[propety];
        			for(var i = 0; i < curHoliday.length; i++) {
        				if((day.y+"-"+(day.m+1)+"-"+day.d) == curHoliday[i]){
        					li_html =  '<li class="'+ li_classes.join(' ') +'" d="'+day.d+'" m="'+day.m+'" y="'+day.y+'" w="'+day.w+'" today="'+isToday+'" ymd="'+this.getYmd(writeDay)+'" ><span class="festival">'+ dayText +'</span>';
        					break;
        				}else{
        					
        				}
        			}
        		}
        	}
        }else{
        	if(flagxiu == '休' || isNaN(dayText)){
        		li_html =  '<li class="'+ li_classes.join(' ') +'" d="'+day.d+'" m="'+day.m+'" y="'+day.y+'" w="'+day.w+'" today="'+isToday+'" ymd="'+this.getYmd(writeDay)+'" ><span class="festival">'+ dayText +'</span>';
        	}else if(flagban == '班'){
        		li_html =  '<li class="'+ li_classes.join(' ') +'" d="'+day.d+'" m="'+day.m+'" y="'+day.y+'" w="'+day.w+'" today="'+isToday+'" ymd="'+this.getYmd(writeDay)+'" ><span class="work">'+ dayText +'</span>';
        	}else{
        		li_html =  '<li class="'+ li_classes.join(' ') +'" d="'+day.d+'" m="'+day.m+'" y="'+day.y+'" w="'+day.w+'" today="'+isToday+'" ymd="'+this.getYmd(writeDay)+'" ><span>'+ dayText +'</span>';
        	}
        }
        var new_html = '';
        if ( this.fillDayInfo) new_html = this.fillDayInfo(li_html);
        return new_html == '' ? li_html : new_html;
    }

    calendarV2.prototype.genMonth = function() {
        var dayHtml = '';
        var len = this.monthArray.length - 1;
        for (var i = 0; i <= len ; i++) {
            var day = this.monthArray[i];
            if (i==0) dayHtml+=this.genEmptyDay(day.w);
            var dayHtml = dayHtml + this.genDate(day);
        };
        dayHtml+=this.genEmptyDay(6 - day.w);
        var preHtml =
            '<div class="'+this.classMonth+'">'+
            '<div class="'+this.classTitle+'">'+
            '<h2 cury="'+day.y+'" curm="'+(day.m + 1)+'">'+day.y+'-'+(day.m + 1)+'</h2>'+
            '</div>'+
            '<ul class="'+this.classWeek+'">'+
            '<li class="pink red">日</li>' +
            '<li>一</li>' +
            '<li>二</li>' +
            '<li>三</li>' +
            '<li>四</li>' +
            '<li>五</li>' +
            '<li class="pink red">六</li>' +
            '</ul>';
        var afterHtml = '</div>';
        return preHtml + '<ul class="'+this.classDay+'">'+dayHtml+'</ul>' + afterHtml;
    }

    calendarV2.prototype.genEmptyDay = function(num) {
        var emptyday = '';
        for (var i = 1; i<= num; i++) {
            emptyday+='<li class="'+this.classDayPass+' '+this.classDayBase+'"></li>';
        }
        return emptyday;
    }

    calendarV2.prototype.fillCalender = function() {
        this.e.html(this.prependHtml + this.calenderHTML + this.preMonthHTML() + this.nextMonthHTML());
        if($("#clearSelect").length < 1){
            this.e.after(this.clearDateHTML());
        }
        if(this.checkIn && this.checkOut && $("#clearSelect").length >= 1){
            $("#clearSelect").show();
        }
        this.e.find('.' + this.classMonth).first().addClass('paddingR10');
        this.e.find('.' + this.classMonth).first().children('.' + this.classTitle).addClass('width_274');
        return(this);
    }
    calendarV2.prototype.clearSelect = function() {
        var _this = this;
        this.e.find('.checkedday,' + '.' + this.classDaySelect).each(function(){
            if ($(this).attr('today') == '1') {
                $(this).find('span').html('今天');
            } else {
                $(this).find('span').html($(this).attr('d'));
            }
            if (_this.fillDayInfo) _this.fillDayInfo($(this));

        })
            .removeClass('checkedday');
        this.e.find('.' + this.classDaySelect).each(function(){
        	$(this).removeClass("cal_select").removeClass("between");
        })
        this.e.find('.' + this.classDayUnSelectAble).addClass(this.classDayShow).removeClass(this.classDayUnSelectAble);
        $("#clearSelect").removeClass("on_active");
        if(this.checkIn && this.checkOut) {
            this.e.hide().removeClass('active');
        }
        this.checkOut = null;
        this.checkIn  = null;
        this.firstGray = false;
        return(this);
    }

    calendarV2.prototype.bindEvent = function() {
        var _this = this;

        this.e.find('.' + this.classDayBase).on('click', function(){
            if ($(this).hasClass(_this.classDayPass) || $(this).hasClass(_this.classDayUnSelectAble)) return false;
            if ($(this).hasClass('cal_noRoom')) return false;
            if ($(this).hasClass(_this.classDaySelect) && $('.checkedday').index(this) == 0) return false;
            var thisday = $(this).find('span');
            if (!_this.checkIn && !_this.checkOut) {
                $('.checkedday').removeClass('checkedday');
                $(this).addClass('checkedday');
            } else if (_this.checkIn && !_this.checkOut) {
                $(this).addClass('checkedday');
            } else if (_this.checkIn && _this.checkOut) {
                _this.clearSelect();
                _this.e.show();
                $(this).addClass('checkedday');
            } else if (!_this.checkIn && _this.checkOut) {
                _this.clearSelect();
            }
            $("#clearSelect").addClass("on_active");
            $(this).toggleClass(_this.classDaySelect);
            _this.refreshCheckState();
        })
        return(this);
    }
    calendarV2.prototype.refreshCheckState = function() {
    	_this = this;
		var checkedday = this.e.find('.checkedday');
		//判断入住日期是否为空
		if(_this.checkIn == null){
			var checkFirst = checkedday.first();
			checkFirst.find('span').html('入住');
			this.checkIn = this.setYmd(checkFirst.attr('y'),checkFirst.attr('m'),checkFirst.attr('d'));
			var startMonth_value = (this.checkIn.getMonth() < 9) ? '0'+ (this.checkIn.getMonth()+1) : (this.checkIn.getMonth()+1);
			var startDate_value = (this.checkIn.getDate() < 10) ? '0'+ (this.checkIn.getDate()) : this.checkIn.getDate();
			$('#checkinday_value').val(this.checkIn.getFullYear() + '-' + startMonth_value + '-' + startDate_value).addClass("active");
           
			var startMonth = this.checkIn.getMonth()+1;
            var startDate = this.checkIn.getDate();
            $('#checkinday').val(startMonth + '月' + startDate + '日').addClass("active");
            $('#clearSelect').show();
            $('#checkoutday').val('');
    		$('#checkoutday_value').val('');
    		$('#zrdays').text('0晚');
		}else{
			var checkLast = checkedday.last();
			var leaveday = checkLast.attr('ymd');
			//判断离店日期是否为空
			if(_this.checkOut == null){
				console.log(checkedday.first().attr('ymd'));
				var checkFirst = checkedday.first();
				var enterday = checkFirst.attr('ymd');
				if(enterday == leaveday){
					if(999 <  _this.getYmd(_this.checkIn)){//离店日期小于入住日期
						checkFirst.find('span').html('入住');
						checkLast.find('span').html(checkLast.attr('d'));
						checkLast.removeClass('cal_select');
						checkLast.removeClass('checkedday');
						this.checkIn = this.setYmd(checkFirst.attr('y'),checkFirst.attr('m'),checkFirst.attr('d'));
						var startMonth_value = (this.checkIn.getMonth() < 9) ? '0'+ (this.checkIn.getMonth()+1) : (this.checkIn.getMonth()+1);
	                    var startDate_value = (this.checkIn.getDate() < 10) ? '0'+ (this.checkIn.getDate()) : this.checkIn.getDate();
	                    $('#checkinday_value').val(this.checkIn.getFullYear() + '-' + startMonth_value + '-' + startDate_value).addClass("active");
	                    
	                    var startMonth = this.checkIn.getMonth()+1;
	                    var startDate = this.checkIn.getDate();
	                    $('#checkinday').val(startMonth + '月' + startDate + '日').addClass("active");
	                    $('#checkoutday').val('');
	            		$('#checkoutday_value').val('');
	            		$('#zrdays').text('0晚');
					}else{
						checkLast.find('span').html('退房');
						this.checkOut = this.setYmd(checkLast.attr('y'),checkLast.attr('m'),checkLast.attr('d'));
						//入住与离店之间日期选中
						if (_this.fillDayInfo) {
							this.fillDayInfo(checkLast);
							if(!_this.checkIn) {
								this.fillDayInfo(checkFirst);
							}
						}
						this.doColor = leaveday == 999 ? false : true;
						doColorState = false;
						this.e.find('.' + this.classDayBase).not('.old').each(function(){
							var liYmd = $(this).attr('ymd');
							liYmd = new Date(liYmd.replace(/-/g, "/"));
							if (_this.doColor) {
								if(!_this.checkIn) {
									if ($(this).hasClass(_this.classDaySelect)) doColorState = !doColorState;
									if (doColorState){
										$(this).addClass(_this.classDaySelect);
										$(this).addClass('checkedday');
										if (_this.getDayInfo) _this.getDayInfo($(this));
									} 
								}
								else {
									if( (_this.getYmd(liYmd) >= _this.getYmd(_this.checkIn))  && ( _this.getYmd(liYmd) <= _this.getYmd(_this.checkOut)) ) {
										$(this).addClass(_this.classDaySelect);
										$(this).addClass('checkedday');
										if (_this.getDayInfo) _this.getDayInfo($(this));
									}
								}
							}
							if (_this.fillDayInfo) _this.fillDayInfo($(this));
						})
						var checkdaycount=0;
						$("li.checkedday").each(function(){
							if(checkdaycount !=0 && checkdaycount != $("li.checkedday").length-1){
								$(this).addClass("between");
							}
							checkdaycount++;
						});
						$("#zrdays").text(($("li.checkedday").length-1)+"晚");
						this.checkDayChange();
						//地图页跳转
						if($("#no_map").val()=="1"){
							setTimeout(function(){
				    			$('#landmarkBtn').click();
				    		},300);
						}
						return(this);
					}
				}else{
					
					/*if(!_this.checkIn) {
					checkFirst.find('span').html('入住');
				}*/
					if(enterday <  _this.getYmd(_this.checkIn)){//离店日期小于入住日期
						checkFirst.find('span').html('入住');
						checkLast.find('span').html(checkLast.attr('d'));
						checkLast.removeClass('cal_select');
						checkLast.removeClass('checkedday');
						this.checkIn = this.setYmd(checkFirst.attr('y'),checkFirst.attr('m'),checkFirst.attr('d'));
						var startMonth_value = (this.checkIn.getMonth() < 9) ? '0'+ (this.checkIn.getMonth()+1) : (this.checkIn.getMonth()+1);
						var startDate_value = (this.checkIn.getDate() < 10) ? '0'+ (this.checkIn.getDate()) : this.checkIn.getDate();
						$('#checkinday_value').val(this.checkIn.getFullYear() + '-' + startMonth_value + '-' + startDate_value).addClass("active");
						
						var startMonth = this.checkIn.getMonth()+1;
						var startDate = this.checkIn.getDate();
						$('#checkinday').val(startMonth + '月' + startDate + '日').addClass("active");
					}else{
						checkLast.find('span').html('退房');
						this.checkOut = this.setYmd(checkLast.attr('y'),checkLast.attr('m'),checkLast.attr('d'));
						//入住与离店之间日期选中
						if (_this.fillDayInfo) {
							this.fillDayInfo(checkLast);
							if(!_this.checkIn) {
								this.fillDayInfo(checkFirst);
							}
						}
						this.doColor = leaveday == enterday ? false : true;
						doColorState = false;
						this.e.find('.' + this.classDayBase).not('.old').each(function(){
							var liYmd = $(this).attr('ymd');
							liYmd = new Date(liYmd.replace(/-/g, "/"));
							if (_this.doColor) {
								if(!_this.checkIn) {
									if ($(this).hasClass(_this.classDaySelect)) doColorState = !doColorState;
									if (doColorState){
										$(this).addClass(_this.classDaySelect);
										$(this).addClass('checkedday');
										if (_this.getDayInfo) _this.getDayInfo($(this));
									} 
								}
								else {
									if( (_this.getYmd(liYmd) >= _this.getYmd(_this.checkIn))  && ( _this.getYmd(liYmd) <= _this.getYmd(_this.checkOut)) ) {
										$(this).addClass(_this.classDaySelect);
										$(this).addClass('checkedday');
										if (_this.getDayInfo) _this.getDayInfo($(this));
									}
								}
							}
							if (_this.fillDayInfo) _this.fillDayInfo($(this));
						})
						var checkdaycount=0;
						$("li.checkedday").each(function(){
							if(checkdaycount !=0 && checkdaycount != $("li.checkedday").length-1){
								$(this).addClass("between");
							}
							checkdaycount++;
						});
						this.checkDayChange();
						//地图页跳转
						if($("#no_map").val()=="1"){
							setTimeout(function(){
				    			$('#landmarkBtn').click();
				    		},300);
						}
						return(this);
				}
				}
			}else{
				this.checkIn = this.setYmd(checkFirst.attr('y'),checkFirst.attr('m'),checkFirst.attr('d'));
				this.checkOut = null;
			}
		}
    }
    calendarV2.prototype.resetBeforeCheckInState = function() {
        this.e.find('.' + this.classDayUnSelectAble).addClass(this.classDayShow).removeClass(this.classDayUnSelectAble);
    }
    calendarV2.prototype.clearDateHTML = function() {
        var clearHtml = '<div class="clear_date" id="clearSelect" ></div>';
        // var clearHtml = '<span class="clear circle">&times;</span>';
        return clearHtml;
    }
    calendarV2.prototype.preMonthHTML = function() {
        if((this.today.getMonth() == this.firstDate.m) && (this.today.getFullYear() == this.firstDate.y)) {
            return '';
        }
        else {
            var preMonth = '<span class="cal_pre" id="preMonth"></span>';
            return preMonth;
        }
    }
    calendarV2.prototype.nextMonthHTML = function() {
    	var startDate = new Date();
    	var endDate = this.today.getFullYear()+"-"+this.firstDate.m;
    	
    	var nowy = this.lastDate.y;
    	var nowm = this.lastDate.m;
    	var nowd = this.lastDate.d;
    	var monthflag = getHeafYear(nowy,nowm,nowd);
    	if(monthflag == true){
    		var nextMonth = '<span class="cal_next" id="nextMonth"></span>';
    		return nextMonth;
    	}else{
    		return '';
    	}
    	
    }
    //日期最多展示6个月（含当前月）
    function getHeafYear(nowy,nowm,nowd){
    	var ensDate = new Date();
    	var e1 = ensDate.getFullYear();
    	var e2 = ensDate.getMonth()+5;
    	
    	var startDate = new Date();
    	startDate.setFullYear(nowy);
    	startDate.setMonth(nowm-1);
    	startDate.setDate(nowd);
    	if(e2 >= 11){
    		e1+=1;
    		e2-=11;
    		ensDate.setFullYear(e1);
    		ensDate.setMonth(e2-1);
    	}else{
    		ensDate.setFullYear(e1);
    		ensDate.setMonth(e2);
    	}
    	
    	if(startDate.getTime() >= ensDate.getTime()){
    		return false;
    	}else{
    		return true;
    	}
    }

   /* calendarV2.prototype.nextMonthHTML = function() {
        var nextMonth = '<span class="cal_next" id="nextMonth"></span>';
        return nextMonth;
    }*/

    calendarV2.prototype.getDateDesc= function(day)
    {
        for(var propety in this.holidays) {
            if(this.holidays.hasOwnProperty(propety)){
                var curHoliday = this.holidays[propety];
                for(var i = 0; i < curHoliday.length; i++) {
                    if((day.y+"-"+(day.m+1)+"-"+day.d) == curHoliday[i]){
                        return this.datename[propety];
                    }
                }
            }
        }
        return day.d;
    }

}
catch(e){console.log(e);}

var defaultText = '';
var defaultStartText = '入住日期';
var defaultEndText = '退房日期';
try{
    var execCalendar = function(input,option){
        var inputObj = $(input);
        var autoSearch = option.autoSearch || null;
        var calendar = new calendarV2('#index_list_calendar-box', {
            checkDayChange:function(){
                if(this.checkIn){
                    var startMonth_value = (this.checkIn.getMonth() < 9) ? '0'+ (this.checkIn.getMonth()+1) : (this.checkIn.getMonth()+1);
                    var startDate_value = (this.checkIn.getDate() < 10) ? '0'+ (this.checkIn.getDate()) : this.checkIn.getDate();
                    $('#checkinday_value').val(this.checkIn.getFullYear() + '-' + startMonth_value + '-' + startDate_value).addClass("active");
                    
                    var startMonth = this.checkIn.getMonth()+1;
                    var startDate = this.checkIn.getDate();
                    $('#checkinday').val(startMonth + '月' + startDate + '日').addClass("active");
                    $('#checkoutday').val('');
                    $('#clearSelect').show();
                }
                if(this.checkOut){
                    var endMonth_value = (this.checkOut.getMonth() < 9) ? '0'+ (this.checkOut.getMonth()+1) : (this.checkOut.getMonth()+1);
                    var endDate_value = (this.checkOut.getDate() < 10) ? '0'+ (this.checkOut.getDate()) : this.checkOut.getDate();
                    $('#checkoutday_value').val(this.checkOut.getFullYear() + '-' + endMonth_value + '-' + endDate_value).addClass("active");
                    
                    var endMonth = this.checkOut.getMonth()+1;
                    var endDate = this.checkOut.getDate();
                    $('#checkoutday').val(endMonth + '月' + endDate +'日').addClass("active");
                    this.e.hide().removeClass('active');
                    $('#clearSelect').show();
                    $('.icon_searchandremove').show();
                    if(autoSearch) {
                        $('#filter_confirm').click();
                    }
                }
				//计算共多少晚
                var totalDays = $DTU.getDateMargin(stringToDate($('#checkinday_value').val()),stringToDate($('#checkoutday_value').val()));
                $("#zrdays").text(totalDays+"晚");
                scrollPage($('#index_list_calendar-box'));
            },
            checkIn: $('#checkinday_value').val() ? new Date($('#checkinday_value').val().replace(/-/g, "/")) : null,
            checkOut: $('#checkoutday_value').val() ? new Date($('#checkoutday_value').val().replace(/-/g, "/")) : null
        })

        $('#index_list_calendar-box').unbind('click');
        $('#clearSelect').on('click',function(){
            $(this).hide();
            calendar.clearSelect();
            //清除展示层时间数据
            $('#checkinday').val('');
            $('#checkoutday').val('');
            //清除隐藏层时间数据
            $('#checkinday_value').val('');
            $('#checkoutday_value').val('');
            if(autoSearch&&$('#tmpenddate').val()&&$('#tmpstartdate').val()) {
                $('#deldatetime').click();
                $('#filter_confirm').click();
                return false;
            }
            $("#zrdays").html("0晚");
        })
        $("#index_list_calendar-box").on('click','#preMonth',function(){
            calendar.preMonth();
            scrollPage($('#index_list_calendar-box'));
        })
        $("#index_list_calendar-box").on('click','#nextMonth',function(){
            calendar.nextMonth();
            scrollPage($('#index_list_calendar-box'));
        })
        inputObj.bind('click focus',function(){
            /*if($('#checkinday').val() == '' && $('#checkoutday').val() == ''){
                inputObj.val(defaultStartText);
            }*/
            if($('#checkinday').val() != '' && $('#checkoutday').val() != ''){
                calendar.resetBeforeCheckInState();
            }
//            calendar.e.show();
            scrollPage($('#index_list_calendar-box'));
        })
        inputObj.bind('blur',function(){
        })
    }

    $('#calendar_btn_s').click(function(){
        $("#checkinday").click();
//        $("#startenddate").click();
    })
}
catch(e){}

function endDateWarn (inputObj)
{
    var i = 0,t=false,v=inputObj.val();
    if( (v == '') || t) return ;
    t= setInterval(function(){
        if($('#checkinday').val() == '' || $("#checkoutday").val() != '') { clearInterval(t); return ;}
        i++;
        if(i%2) { inputObj.val(' '); }
        else { inputObj.val(v); }
        if(i== 6){ clearInterval(t); }
    },600);
}

$(document).ready(function(){
//    var indexCalendar = new execCalendar('#startenddate',{});
    var indexCalendar = new execCalendar('#checkinday',{});
})

function stringToDate(DateStr)  
{   
  
    var converted = Date.parse(DateStr);  
    var myDate = new Date(converted);  
    if (isNaN(myDate))  
    {   
        //var delimCahar = DateStr.indexOf('/')!=-1?'/':'-';  
        var arys= DateStr.split('-');  
        myDate = new Date(arys[0],--arys[1],arys[2]);  
    }  
    return myDate;  
}