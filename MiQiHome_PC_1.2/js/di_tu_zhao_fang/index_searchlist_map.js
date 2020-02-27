/*棣栭〉銆佹悳绱㈠垪琛ㄩ〉鍏叡JS鏂规硶*/
$(document).click(function(ev){
	ev = ev || window.event;
	var target = ev.target || ev.srcElement;
	if (!/^(landmarkBtn)|(tosearchlist)|(searchcityin)|(searchcityb)|(searchcitydiv)|(hotcity)|(a_b_c_d_e_f_g)|(h_i_j_k_l_m_n_o)|(p_q_r_s_t_u_v)|(w_x_y_z)|(a_b_c_d)|(e_f_g_h_j)|(k_l_m_n)|(p_q_r_s_t_w)|(x_y_z)|(cityselecttitleul)|(cityselectul)|(overseas)$/.test(target.id)&&!$(target).hasClass("citylili")){
		$("#searchcitydiv").css("display","none");
		if($('.error_tip_list').css('display')!='none'){
			$('.error_tip_list').css('display','none');
		}
		if($('.suggest_results').css('display')!='none'){
			$('.suggest_results').css('display','none');
		}
		if($('.people').css('display')!=='none'){
			$('#nav_p_num').click();
		}
		if($('.key_word_list').css('display')!='none'){
			$('.key_word_list').css('display','none');
		}
	} 
	
	if (!/^(startenddate)|(calendar_btn_s)|(calendar-box)|(preMonth)|(nextMonth)|(clearSelect)$/.test(target.id) && !$(target).is("#index_list_calendar-box,#index_list_calendar-box *")) {
        if( $('#checkinday').val() !='' && $("#checkoutday").val() == '') {
            endDateWarn($('#startenddate'));
        }
        else {
            if( $('#checkinday').val() =='' && $("#checkoutday").val() == '') {
                $('#startenddate').val(defaultText);
            }
            $("#index_list_calendar-box").hide();
        }
    }
});

document.onkeydown=function(event){
	var e = event || window.event || arguments.callee.caller.arguments[0];
	if(e && e.keyCode==27){ // 鎸� Esc 
		//瑕佸仛鐨勪簨鎯�
		$("#biaoji").removeClass("map_biaoji");
		$(".BMap_mask").parent().removeClass("map_bj");	
		mapBj_flag = false;
	}
	if(e && e.keyCode==113){ // 鎸� F2 
		//瑕佸仛鐨勪簨鎯�
	}            
	if(e && e.keyCode==13){ // enter 閿�
		if($('#loginboxdiv')&&$('#loginboxdiv').css("display")!='none'){
			return ; //FIXME 鐧诲綍妗嗚嚜鍔ㄧ櫥褰�
		}
		else if($('#tosearchlist'))
		{
			$('#tosearchlist').click();
		}

	}
}; 
var version = 0; 

var lastKeyword = "";
function getSuggestResult(sugurl,s,cityid,page,k){
	if(s!=lastKeyword)
	{
		if(k){
			$('#searchcityin1').attr("surl","");
		}else
		{
			$('#searchcityin').attr("surl","");
		}
		lastKeyword=s; 
	}
	version++;
	s = replaceSpecialChat(s);
	if(page=='list'&&!k)
	{
		$('#searchcityin1').val("");
	}
	_getSuggestResult(sugurl,s,cityid,page,k,version);

} 
function _getSuggestResult(sugurl,s,cityid,page,k,v)
{
	var f = 1;
	$.ajax({
		url:sugurl,
		data:{searchkey:s,
			  s:s,
			  cityid:cityid,
			  pagefrom:page,
			  platfrom:1
		},
		type:'GET',
		dataType:'json',
		success:function(data){
			if(version!=v)
			{ 
				return;
			} 

			if(null!=data.error&&data.error.length>0){
				if(page=='list'){
					f = 2;
					$(".error_tip_list").html('<p>'+data.error+'</p>');
				}
				if(page=='index'){
					$(".error_tip_list").html(data.error);
				}
				$('.error_tip_list').css('display','block');
				if(k)
				{
					var oLeft = $(".keyword").position().left;
	                $('.error_tip_list').css({"right":0,"left":"auto"});
				}
				
				else
				{
					if(page=='list'){
						$('.error_tip_list').css('left',0);
					}
				}
				$('.suggest_results').css('display','none');
			}else{
				var s = $('#searchcityin').val().trim();
				if(null!=s && s.length>0 && s!='鐩殑鍦般€佹櫙鐐广€佸晢鍦堢瓑' && s!='鐩殑鍦般€佸煄甯�'){
				}else{
					$('.error_tip_list').css('display','none');
					$('.suggest_results').css('display','none');
					$(".search-modal").hide();
					$("#searchcityin").focus();
					$('.select-hotcity').css('display','block');
					return;
				}
				var list = data.list;
				var suggestList = data.suggestList;
				var data = '<ul id="suggestul">';
				var hasNick = false;
				var hasAddr = false;
				var hasOther = false;
				var noSIcon = false;
				var type = "";
				var count = 0;
				
				for(var i=0;i<list.length;i++){
					var sug = list[i];
					var name = sug.name;
					if(name.indexOf(s)!=-1){
						name = name.replace(s,'<font class="c22bb62">'+s+'</font>');
					}
					var sugurl = sug.url;
					//district 鍜宻treet閲嶆柊缁勮URL
					if(sugurl.indexOf('district')!=-1 || sugurl.indexOf('street')!=-1){
						var newds = sugurl.split('-')[1];
						sugurl = sugurl.substring(0,sugurl.lastIndexOf('/'))+'_'+newds;
					}
					var liClass = "";
					if(type!=sug.sort)
					{ 
						liClass = "have_label";
						type=sug.sort; 
					}
				
					var sIcon='';
				
					if(liClass!=''||i==0)
					{
						if(sug.sort==1)
						{
							sIcon='<label class="c_gray f14"><i class="icon icon-city mr15"></i>鍩庡競</label>';
						}
						else if(sug.sort==2)
						{
							sIcon='<label class="c_gray f14"><i class="icon icon-goal mr15"></i>鐩殑鍦�</label>';
						}
						else if(sug.sort==3)
						{
							sIcon='<label class="c_gray f14"><i class="icon icon-shop mr15"></i>鍟嗗湀</label>';
						}
						else if(sug.sort==4)
						{
							sIcon='<label class="c_gray f14"><i class="icon icon-point mr15"></i>鏅偣</label>';
						}
						else if(sug.sort==5)
						{
							sIcon='<label class="c_gray f14"><i class="icon icon-street mr15"></i>琛楅亾</label>';
						}
						else if(sug.sort==6)
						{
							sIcon='<label class="c_gray f14"><i class="icon icon-subway mr15"></i>鍦伴搧</label>';
						}
						else if(sug.sort==7)
						{
							sIcon=' <label class="c_gray f14"><i class="icon icon-air mr15"></i>鏈哄満杞︾珯</label>';
						}
						else if(sug.sort==8)
						{
							sIcon=' <label class="c_gray f14"><i class="icon icon-district mr15"></i>琛屾斂鍖�</label>';
						}
						else if(sug.sort==9)
						{
							sIcon='<label class="c_gray f14"><i class="icon icon-hospital mr15"></i>鍖婚櫌</label>';
						}
						else if(sug.sort==10)
						{
							sIcon='<label class="c_gray f14"><i class="icon icon-school mr15"></i>瀛︽牎</label>';
						}else if(sug.sort == -3)
						{
							sIcon = '<label class="c_gray f14 room "><i class="icon icon-room mr15"></i>鎴挎簮淇℃伅</label>';
						}else if(sug.sort == 0){ 
							sIcon = '<label class="c_gray f14"><i class="icon icon-landmark mr15"></i>鍦版爣</label>';
						}
					} 
					if(sug.sort==0&&sug.type!=-1&&sug.type!=-2)
					{
						noSIcon = true;
					}
//					if(i==0||i==1){ 
						if(i==0){ 
						if(sug.type==0)
						{
							hasOther = true;
							if(sug.type == 0 && sug.desc.indexOf('甯�') != -1){
					    		sug.genre = sug.desc.substring(sug.desc.lastIndexOf('路')+1,sug.desc.lastIndexOf('甯�'));
					    	}else if(sug.type == 0){
					    		sug.genre = sug.desc.substring(sug.desc.lastIndexOf('路')+1,sug.desc.length);
					    	}
							data+='<li type="'+sug.type+'" class="'+liClass+' bor-none" rel="guang"><a url="'+sugurl+'" type="'+sug.type+'">'+sIcon+'<p class="leftspan f14 mt10"  kw="'+sug.name+'" ><font class="keyword">'+name+'</font>,'+sug.genre+'</p></a></li>';
						}else if(sug.type==-3){
							hasOther = true;
								data+='<li type="'+sug.type+'" class="have_label bor-none">'+
								'<a url="'+sugurl+'"  type="'+sug.type+'">'+'<label class="c_gray_dark f14 "><i class="icon icon-room mr15"></i>'+sug.name+'</label>'+
								'<p class="f12 c_gray">'+
								'<span class="room_city icon_after">'+sug.cityName+'</span>'+
								'<span class="icon_after">锟�'+sug.price/100+'</span>'+
								'<span class="icon_after">'+sug.roomNum+'灞�</span>';
								if(sug.praise != 0){
									data +='<span class="icon_after">'+sug.praise+'鍒�</span>';
								}
								data +='</p>'+
								'</a>'+
								'</li>';
								count ++;
						}
						else
						{
							hasOther = true;
							data+='<li type="'+sug.type+'"  rel="guang" '+('style="cursor: pointer;" class=" bor-none"')+'><a url="'+sugurl+'" type="'+sug.type+'">'+sIcon+'<p class="leftspan f14"  kw="'+sug.name+'" ><font class="keyword">'+name+'</font>,'+sug.genre+'</p></a></li>';
						}
					}else{
						if(sug.type==0)
						{
							if(sug.type == 0 && sug.desc.indexOf('甯�') != -1){
					    		sug.genre = sug.desc.substring(sug.desc.lastIndexOf('路')+1,sug.desc.lastIndexOf('甯�'));
					    	}else if(sug.type == 0){
					    		sug.genre = sug.desc.substring(sug.desc.lastIndexOf('路')+1,sug.desc.length);
					    	}
							data+='<li type="'+sug.type+'" class="bor-none '+liClass+'" rel="guang"><a url="'+sugurl+'" type="'+sug.type+'">'+sIcon+'<p class="leftspan f14 mt10"  kw="'+sug.name+'" ><font class="keyword">'+name+'</font>,'+sug.genre+'</p></a></li>';
						}else if(sug.type == -3){
							data+='<li type="'+sug.type+'" class="have_label ">'+
							'<a url="'+sugurl+'"  type="'+sug.type+'">'+'<label class="c_gray_dark f14 "><i class="icon icon-room mr15"></i>'+sug.name+'</label>'+
							'<p class="f12 c_gray">'+
							'<span class="room_city icon_after">'+sug.cityName+'</span>'+
							'<span class="icon_after">锟�'+sug.price/100+'</span>'+
							'<span class="icon_after">'+sug.roomNum+'灞�</span>';
							if(sug.praise != 0){
								data +='<span class="icon_after">'+sug.praise+'鍒�</span>';
							}
							data +='</p>'+
							'</a>'+
							'</li>';
							count ++;
						}
						else
						{
							data+='<li type="'+sug.type+'"  rel="guang" '+('style="cursor: pointer;" class="bor-none"')+'><a url="'+sugurl+'" type="'+sug.type+'">'+sIcon+'<p class="leftspan f14"  kw="'+sug.name+'" ><font class="keyword">'+name+'</font>,'+sug.genre+'</p></a></li>';
						}
					}
				}
				if(cityid!=0){
					//data +='<div class="other_city" style="cursor: pointer;" onclick="getOtherSug()">鎼滅储鍏朵粬鍩庡競</div>';
				}
				data+='</ul>';
				if(k == 1 && count >= 5 && suggestList != undefined){
					//鏄剧ずxxx+鎴挎簮
					data +='<div class="sug_room_tip t-center"><a class="btn_find" href="'+suggestList.url+'">'+suggestList.name+'</a></div>';
				}
				if(k == 0 || k == undefined){
					data+='<div class="hotmore hint f12 c_gray sug_room_tip">鍏堥€夋嫨鍩庡競鍐嶆悳绱紝鍙緱鍒版洿澶氱粨鏋�</div>';
				}
				$('.suggest_results').html(data);
				$('.suggest_results').css('display','block');
				if(k)
				{
					var oLeft = $("#searchcityin1").position().left;
					$('.suggest_results').css({"left":oLeft+"px"});
				}
				else
				{
					if(page=='list'){
						var oLeft = $("#searchcityin").position().left;
						$('.suggest_results').css({"left":oLeft+"px"});
					}
				}
				$('.error_tip_list').css('display','none');
				/*鎼滅储鐚滄祴灞曠ず*/
				$(".suggest_results li").hover(function(){
					if(!$(this).hasClass("hover")){
						$(this).addClass("hover").siblings().removeClass("hover");
					}
				});
				/*鎼滅储鐚滄祴閫夋嫨 棣栭〉鐐瑰嚮涓嶈皟鏁碪RL*/
				$('.suggest_results ul li').click(function()
				{
					if($(this).attr('type') == -3){
						window.location.href = $(this).find('a').attr('url');
					}
					var ctx=$('#ctx').val();
					var search_kw = '';
					$('.suggest_results').css('display','none');
					if(k)
					{
						search_kw = $('#searchcityin1').val();
						$('#searchcityin1').val($(this).children().children(".leftspan").attr("kw"));
					}
					else
					{
						search_kw = $('#searchcityin').val();
						$('#searchcityin').val($(this).children().children(".leftspan").attr("kw"));
					}
					var url = $(this).children().attr('url')+'/';
					var log_ext = "-";
					var typeid=$(this).children().attr('type');
					var spinyin = $('#searchcityin').attr("surl");
					var value = $('#searchcityin').val();
					var parmStr = '';
					var checkinday ='';
					var checkoutday='';
					var surl = $(this).children().attr('url')+'/';
					if(page=='index'){ 
						$('#searchcityin').attr("surl",surl);
						$('#searchcityin').attr("typeid",typeid);
						checkinday = $('#checkinday_value').val();
						checkoutday = $('#checkoutday_value').val();
						if(checkinday == undefined || checkinday == '' || checkinday == '鍏ヤ綇鏃堕棿'
							|| checkoutday == undefined || checkoutday == '' || checkoutday == '閫€鎴挎椂闂�'){
							$('#index_list_calendar-box').show();
						}
						$('#searchcityin').attr("search",search_kw);
						return false;
					}
					if(page=='list')
					{		
						var tempUrl = "";				
						// 鍏ヤ綇绂诲簵鏃ユ湡
						checkinday = $('#checkinday_value').val();
						checkoutday = $('#checkoutday_value').val();
						if(!k)
						{							
							tempUrl = ctx + "/" + url.replace(/\//g, "") +'/';
							var peoplenum = 0;
							if($('#countVal').attr("popnum") != null && $('#countVal').attr("popnum") != '涓嶉檺'){
								peoplenum = $('#countVal').attr("popnum");
							}
							if(peoplenum != '' && peoplenum != 0)
							{
								if(tempUrl.substr(tempUrl.length - 1, 1) != "/"){
									tempUrl += "/"; 
								}
								tempUrl += "g" + peoplenum + "/"; 
							}
								// 鍏ヤ綇绂诲簵鏃ユ湡
							if(checkinday != null && checkinday != "" && checkinday != "鍏ヤ綇鏃堕棿"&& 
								checkoutday != null && checkoutday != "" && checkoutday != "閫€鎴挎椂闂�")
							{ 
								tempUrl += "?d1=" + checkinday + "&d2="+checkoutday;
							}
							url = tempUrl;
						}
						else
						{
							// 鍘熷閾炬帴鍦板潃
							var originalUrl = window.location.pathname;
							var items = originalUrl.split("/");															
							if(items.length > 3)
							{
								if(url.substr(url.length - 1, 1) != "/")
								{
									tempUrl += "/";
								}
								tempUrl += url;
								if(tempUrl.substr(url.length - 1, 1) != "/")
								{
									tempUrl += "/";
								}
								tempUrl += items[2] + "/"; 
							}
							else
							{
								if(url.substr(url.length - 1, 1) != "/"){
									url += "/"; 
								}
								url += "g" + peoplenum + "/"; 
							}	
							url = tempUrl;
							
							if(checkinday != null && checkinday != "" && checkinday != "鍏ヤ綇鏃堕棿"&& 
								checkoutday != null && checkoutday != "" && checkoutday != "閫€鎴挎椂闂�")
							{ 
								url += "?d1=" + checkinday + "&d2="+checkoutday;
							}
							// 杩藉姞鍏抽敭璇�
							var sKw = $('#searchcityin1').val();
							if(sKw.length > 0)
							{
								url += (url.indexOf('?')!=-1) ? "&s="+sKw : "?s="+sKw;
							}
							// 鍘熷鍙傛暟
							var originalParam = window.location.search;
							if(originalParam.indexOf("map=no") > -1)
							{
								url += (url.indexOf('?')!=-1) ? "&map=no" : "?map=no";
							}							
						}					
					}

					var skey = ''; 
					var sugvalue = $(this).children().children(".leftspan").attr("kw");
					if(parmTypeid(typeid)){
						skey = sugvalue;
					}
					if(!parmTypeid(typeid)){
						setSearchCookie($(this).children().children(".leftspan").attr("kw"),surl);	
					}
					if(skey.length>0){
						parmStr = '?s='+encodeURIComponent(skey)+"";
						if(typeid==-2){
							parmStr+='&t=2';
						}
					}
					if(checkinday!=undefined && checkinday!='' && checkinday!='鍏ヤ綇鏃堕棿'){
						if(parmStr.length>0){
							parmStr +='&d1='+checkinday;
						}else{
							parmStr +='?d1='+checkinday;
						}
						log_ext = checkinday;
						if(checkoutday!='' && checkoutday!='閫€鎴挎椂闂�'){
							parmStr += '&d2='+checkoutday;
							log_ext += '_'+checkoutday;
						}
					}
					if(parmStr!='' && page!='list'){
						url = url +parmStr;
					}
					//鎼滅储鏃ュ織
					save_search_log(search_kw,sugvalue,url,typeid,1,page,1);
					var typeids;
					if(typeid == 0){
						typeids = 1;
					}else{
						typeids = 2;
					}
					if($(".city_inland").hasClass("active")){
						setSearchCookie_index(value,spinyin,typeids,"inland");
					}else{
						setSearchCookie_index(value,spinyin,typeids,"oversea");
					}
					window.location.href=ctx+url;
				});
			}
			$(".select-hotcity").css('display','none');
			$(".key_word_list").css('display','none');
		},
		error:function(){
			console.log('璇锋眰寮傚父锛岃绋嶅悗鍐嶈瘯锛�');
		}
	});
}

function searchBtnClick(value,cityid,page){
	var ctx = $('#ctx').val();
	var sugdis = $('.suggest_results').css('display');
	var sugurl = $('.suggest_results .hover a').attr('href');
	var url = '';
	var checkinday = '';
	var checkoutday = '';
	var f = 1;
	var sugvalue=''; 
	var log_ext = "-";
	if(value!=null && value.length>0  && value!='鐩殑鍦�' && value!='鐩殑鍦般€佹櫙鐐广€佸晢鍦堢瓑'&& value!='浣嶇疆銆佹爣棰樸€佹埧涓滅瓑' && value!='鐩殑鍦般€佸煄甯�')
	{
		var spinyin = '';
		var ctx = $('#ctx').val(); 
		var search_kw = $('#searchcityin').attr('search');
		var skey = '';
		var skey_type = -1;
		var spinyin = $('#searchcityin').attr("surl");
		var typeid = $('#searchcityin').attr('typeid');
		if(page=='index'){
			var sugcss = $('.suggest_results').css('display');
			if(sugcss!='none'){
				search_kw = $('#searchcityin').val();
				skey = $(".suggest_results li.hover a .leftspan").text();
				skey_type = $(".suggest_results li.hover a").attr('type');
				$("#searchcityin").val($(".suggest_results li.hover a .leftspan").text());
				spinyin = $(".suggest_results li.hover a").attr('url');
			}else{
				skey = $('#searchcityin').val();
			}
		}
		if(spinyin =="" || spinyin =="undefined" || spinyin == undefined)
		{
			return;
		}
		if(spinyin.substring(spinyin.length-1,spinyin.length)!="/"){
			if(typeid == 0){//typeid!="" && 
				url =ctx+spinyin;
			}else{
				url =ctx+spinyin+'/';
			}	
		}
		else
		{
			url =ctx+spinyin;
		}
		var peoplenum = 0;
		if($('#countVal').attr("popnum") != null && $('#countVal').attr("popnum") != '涓嶉檺'){
			peoplenum = $('#countVal').attr("popnum");
		}
		if(peoplenum != '' && peoplenum != 0)
		{
			if(url.substr(url.length - 1, 1) != "/"){
				url += "/"; 
			}
			url += "g" + peoplenum + "/"; 
		}
		if(page=='index'){ 
			checkinday = $('#checkinday_value').val();
			checkoutday = $('#checkoutday_value').val();
			if(checkinday!=null&&checkinday!=""&&checkinday!="鍏ヤ綇鏃堕棿"){ 
				if(checkoutday!=null&&checkoutday!=""&&checkoutday!="閫€鎴挎椂闂�"){
					url = url + "?d1="+checkinday;
					url = url + "&d2="+checkoutday;
					log_ext = checkinday+"_"+checkoutday;
				}
			}
			//鎼滅储鏃ュ織
			save_search_log(search_kw,skey,url,skey_type,1,page,2);
		} 
		else if(page=='list')
		{
			f = 2;
			checkinday =  $('#checkinday_value').val();
			checkoutday = $('#checkoutday_value').val();
			// 鍘熷閾炬帴鍦板潃
			var originalUrl = window.location.pathname;
			url = originalUrl;
			var originalCity = url.split("/")[1];
			if(spinyin.replace(/\//g,"") != originalCity.replace(/\//g, ""))
			{
				url = ctx + "/" + spinyin.replace(/\//g, "") +'/';
				if(peoplenum != '' && peoplenum != 0)
				{
					if(url.substr(url.length - 1, 1) != "/"){
						url += "/"; 
					}
					url += "g" + peoplenum + "/"; 
				}
			}
			else
			{
				if(spinyin.replace(/\//g,"").split("_")[0] != originalCity.split("_")[0])
				{
					url = ctx + "/" + spinyin.replace(/\//g, "") +'/';
				}
				if(peoplenum != '' && peoplenum != 0)
				{
					 var reg = new RegExp("g([1-9]{1})");
					 if(reg.test(url))
					 {
						 url = url.replace(reg, 'g' + peoplenum);
					 }
					 else
					 {
						var items = url.split("/");
						if(items.length > 3)
						{
							url = "/" + items[1] + "/" + items[2] + 'g' + peoplenum + "/"; 
						}
						else
						{
							if(url.substr(url.length - 1, 1) != "/"){
								url += "/"; 
							}
							url += "g" + peoplenum + "/"; 
						}	
					 }	
				}else
				{
					 var reg = new RegExp("/g([1-9]{1})");
					 if(reg.test(url))
					 {
						 url = url.replace(reg, "");
					 }
					 else
					 {
						 var reg_num = new RegExp("g([1-9]{1})");
						 if(reg_num.test(url))
						 {
							 url = url.replace(reg_num, "");
						 }
					 }	
				}		
			}
			
			// 鍏ヤ綇绂诲簵鏃ユ湡
			if(checkinday != null && checkinday != "" && checkinday != "鍏ヤ綇鏃堕棿"&& 
				checkoutday != null && checkoutday != "" && checkoutday != "閫€鎴挎椂闂�")
			{ 
				url += "?d1=" + checkinday + "&d2="+checkoutday;
				log_ext = checkinday+"_"+checkoutday;
			}
			// 杩藉姞鍏抽敭璇�
			var sKw = $('#searchcityin1').val();
			if(sKw.length > 0)
			{
				url += (url.indexOf('?')!=-1) ? "&s="+sKw : "?s="+sKw;
			}
			// 鍘熷鍙傛暟
			var originalParam = window.location.search;
			if(originalParam.indexOf("map=no") > -1)
			{
				url += (url.indexOf('?')!=-1) ? "&map=no" : "?map=no";
			}
			// 鎼滅储鏃ュ織
			save_search_log(sKw.length>0?sKw:search_kw,skey,url,skey_type,1,page,2);
		}  
		var typeids;
		if(typeid == 0){
			typeids = 1;
		}else{
			typeids = 2;
		}
		if($(".city_inland").hasClass("active")){
			setSearchCookie_index(value,spinyin,typeids,"inland");
		}else{
			setSearchCookie_index(value,spinyin,typeids,"oversea");
		}
		setCookie_('searchBtnClick',2,10);
		setCookie_('keywords_searchBtnClick',value ,10);
		setCookie_('pagefrom',page,10);
		window.location.href=url;
	} 
	else{
		/*$('.suggest_results').html('');
		$('.error_tip_list').html('璇疯緭鍏ュ叧閿瓧');
		$('.error_tip_list').css('display','block');
		$('.select-hotcity').css('display','none');
		$('.suggest_results').css('display','none');
		if($('.people').css('display')!=='none'){
			$('#nav_p_num').click();
		}*/
		$('#searchcityin').click();
	}
}

function save_search_log(search_kw,skey,url,type,platfrom,page,searchType){
	if(search_kw && search_kw !="浣嶇疆銆佹爣棰樸€佹埧涓滅瓑"){
		$.ajax({
			type : "GET",
			async:false,
			data:{search_kw:search_kw,skey:skey,url:url,type:type,platfrom:platfrom,page:page,searchType:searchType},
			url : $('#ctx').val() +"/search/log",
			success : function(data) {
			}
		});
	}
}

function setSearchCookie(keyword,url){
	//灏嗘悳绱㈣瘝鏀惧叆cookie
	var value = keyword+"&"+url;
	var seakey = getCookie('searchkey');
	if(null!=seakey&&seakey.length>0){
		if(seakey.indexOf(value)==-1){
			var keys = seakey.split(',');
			seakey += ","+value;
			if(keys.length>9){
				seakey = seakey.substring(seakey.indexOf(',')+1,seakey.length);
			}
		}    
	}else{
		seakey = value;
	}
	setCookie('searchkey',seakey,365*20);
}

String.prototype.endWith=function(s){
	  if(s==null||s==""||this.length==0||s.length>this.length)
	     return false;
	  if(this.substring(this.length-s.length)==s)
	     return true;
	  else
	     return false;
	  return true;
	 }
//瀛榗ookie鍔犲叆鍦版爣淇℃伅
function setSearchCookie_index(keyword,url,isDiBiao,cityType){
	//灏嗘悳绱㈣瘝鏀惧叆cookie
	var newUrl = url.replace("?s="+keyword,"");
	if(!newUrl.endWith("/")){
		newUrl+="/";
	}
	var value = keyword+"&"+newUrl+"&"+isDiBiao;
	var seakey = getCookie('searchkey');
	if(null!=seakey&&seakey.length>0){
		if(seakey.indexOf(keyword)==-1){
			var keys = seakey.split(',');
			seakey += ","+value+"&"+(new Date().getTime());
			if(keys.length>9){
				seakey = seakey.substring(seakey.indexOf(',')+1,seakey.length);
			}
		}else{
			var keys = seakey.split(',');
			for(var i=0;i<keys.length;i++){
				if(keys[i].indexOf(keyword) != -1){
					var anddata = keys[i].split('&')
					anddata[3] =  new Date().getTime();
					keys[i] = ""
					for(var j=0;j<anddata.length;j++){
						if(j != (anddata.length-1)){
							keys[i]+=anddata[j]+"&";
						}else{
							keys[i]+=anddata[j];
						}
					}
				} 
			}
			seakey = keys.toString();
		}
	}else{
		seakey = value+"&"+(new Date().getTime());
	}
	seakey = seakey+"&"+cityType;
	setCookie('searchkey',seakey,365*20);
	setCookie('cityType',cityType,365*20);//瀛樺偍鍩庡競绫诲埆鐘舵€�
}
//閫氳繃鍩庡競鍚嶆壘
/*
function getCityPinyinbyName(cityname){
	for(var city in citys){
		var cityinfo = citys[city];
		if(cityinfo[1]==cityname||cityinfo[2]==cityname){
			return cityinfo[2];
			break;
		}
	}
	return "";
}*/

//鏍￠獙鏄惁鍏抽敭瀛�
function parmTypeid(typeid){
	if(typeid!='1'&&typeid!='2'&&typeid!='3'&&typeid!='5'&&typeid!='6'&&typeid!='7'&&typeid!='8'&&typeid!='9'&&typeid!='10'){
		return true;
	}else{
		return false;
	}
}

function Bind_Click(ele) {
	setCookie('searchkey','',-1);
	$(".cleartrace").parent().parent(".searh-recent").remove();
	return false;
}

//Suggest鎻愮ず鎸変笂涓嬮敭鐩樼Щ鍔ㄥ厜鏍�
var movePrev = function(){
	var index = $("li.hover").prevAll().length;
	if(index == 0) $(".suggest_results li").removeClass('hover').eq($(".suggest_results li").length-1).addClass('hover');            //鍙惊鐜Щ鍔�
	// if(index == 0) return false;                                                            //涓嶅彲寰幆绉诲姩
	else $(".suggest_results li").removeClass('hover').eq(index-1).addClass('hover');
	if($('#suggest').css('left')=='82px' ){
		$("#searchcityin").val($("li.hover a .leftspan").attr('kw'));	
	}else
	{
		$("#searchcityin1").val($("li.hover a .leftspan").attr('kw'));
	}
}

var moveNext = function(){
	var index = $("li.hover").prevAll().length;
	if(index == $(".suggest_results li").length-1) $(".suggest_results li").removeClass('hover').eq(0).addClass('hover');            //鍙惊鐜Щ鍔�
	// if(index == $("li").length-1) return false;                                                //涓嶅彲寰幆绉诲姩
	else $(".suggest_results li").removeClass('hover').eq(index+1).addClass('hover');
	if($('#suggest').css('left')=='82px' ){
		$("#searchcityin").val($("li.hover a .leftspan").attr('kw'));	
	}else
	{
		$("#searchcityin1").val($("li.hover a .leftspan").attr('kw'));
	}

}

function getCookie(name){
	var arr = document.cookie.split("; ");
	for(var i=0,len=arr.length;i<len;i++){
		var item = arr[i].split("=");
		if(item[0]==name){
			return unescape(item[1]);
		}
	}
	return "";
}

function setCookie(c_name, value, exdays) {
	var exdate = new Date();
	exdate.setDate(exdate.getDate() + exdays);
	var c_value = escape(value) + ((exdays == null) ? "" : "; expires=" + exdate.toUTCString())+";path=/";
	document.cookie=c_name + "=" + c_value;
}
function setCookie_(c_name, value, exdays) {
	var exdate = new Date();
	exdate.setDate(exdate.getDate() + exdays);
	var c_value = encodeURI(value) + ((exdays == null) ? "" : "; expires=" + exdate.toUTCString())+";path=/";
	document.cookie=c_name + "=" + c_value;
}
//鏇挎崲杈撳叆妗嗕腑鐗规畩瀛楃
function replaceSpecialChat(ch){
	var reg = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~锛丂#锟モ€︹€�&*锛堬級鈥斺€攟{}銆愩€戔€橈紱锛氣€濃€�'銆傦紝銆侊紵銆嘳");
	var rv = "";
	for (var i = 0; i < ch.length; i++) {
		rv += ch.substr(i,1).replace(reg,'');
	}

	return rv;
}

String.prototype.trim = function () {
	return this .replace(/^\s\s*/, '' ).replace(/\s\s*$/, '' );
}