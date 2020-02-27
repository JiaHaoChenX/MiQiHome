//保险单价
var payunitpriceYuan = 0.00;    //以元为单位，保险的单价
var idCardCode = "111";
var hkmacaoCode = "516";
var taiwanCode = "511";
var passportCode = "414";
var militaryIDCode = "233";
var isClickSubmit = false;
var yes_btn = "";
//初始化JS
$(function() {	
    //初始化保险日历
	//callTimeout('',initInsuranceDate,200);
    
    $('#safeticket').hover(function() {
        $('.saferule').show();
    }, function() {
        $('.saferule').hide();
    });
    $("#safeticket").hover(function() {
        $(".safeticket_details_cover").show();
        $(".safeticket_details_cover").hover(function() {
            $(".safeticket_details_cover").show();
        }, function() {
            $('.safeticket_details_cover').hide();
    });
    }, function() {
        $('.safeticket_details_cover').hide();
    })
    $(".details_link").click(function() {
		$(".iframe_for_rule").show();
        $('.details_link_details').show();
    })
	
    $(".makeSure").click(function() {
        $('.details_link_details').hide();
    })    
	$(".selectIdcard").change(function(){ 
		/*changeidtype("1","");*/
	}); 
	
	
	
	/*添加入住人新加2017-11-02*/
	
	$(".optional").on("click",".birthday",function(){
		initInsuranceDate();
	})
	/*入住人列表check，点击复选框的时候*/
	/*$(".optional").on("click",".vf_check_btn",function(){
		if($(this).hasClass("false_btn")){
			return false;
		}
		//
		var oneid = $(this).closest(".verifier").attr("contactid");
		if($(this).closest(".verifier").hasClass("on_check")){  //要移除
			removeInsuranceInputIds_new(oneid);
			//setPrice('remove');
		}else{
			addInsuranceInputIds_new(oneid);
			//setPrice('add');
		}
		$(this).closest(".verifier").toggleClass("on_check");
		
		checked_num();
	})*/
	
	/*选择男女*/
	$(".optional").on("change","#sex",function(){
		$(this).removeClass("c_gray");
		$(this).find("option[value='placeholder']").remove();
	})
	
	
	/*身份证护照选择*/
	$(".optional").on("change",".select_IDcord",function(){
		var selectValue = $(this).val();
		var borsCountry = $(this).closest(".ruzhu_form").find(".bors_country");
		if(selectValue==passportCode)
        {
        	borsCountry.addClass("show");
        	$(".rz_name").hide();
        	$(".overseas").show();
        	$("#idcord").removeClass('w190').addClass('w122');
        }else if(selectValue==idCardCode){
        	borsCountry.removeClass("show");
        	$(".overseas").hide();
        	$(".rz_name").show();
        	$("#idcord").removeClass('w122').addClass('w190');
        }
	})
	
	/*添加入住人*/
	var onoff = 0;
	var yes_btn = "add_icon";
	$(".addvf_icon").click(function(){
		if($(this).hasClass("gray")){
			return fasle;
		}
		if(onoff==1){
			return false;
		}
		$("#iseditperson").val("1");
		yes_btn = "add_icon";
		$(this).addClass("gray");
		onoff=1;
		$(".vf_table").find(".verifier").each(function(){
			$(this).find(".vf_edit").addClass("gray");
			$(this).find(".vf_remove").addClass("gray");
			$(this).find(".vf_check_btn").addClass("false_btn");
		})
		$(".vf_table").after(vf_form("","","","","",""));
		
	})
	
	/*入住人列表check，点击复选框的时候*/
	$(".c_person").on("click",function(){
		var p_name=$(this).text();
		var p_type=$(this).attr("data-type");
		var p_idInfo=$(this).attr("data-info");
		var p_yanzheng=$(this).attr("data-yanzheng");
		var p_id=$(this).attr("data-id")

		if(!$(this).hasClass("checked")){
			addInsuranceInputIds_new(p_id);
			$(this).addClass("checked")
			var citytype =$('#citytype').val();
			if(p_type!='IDcard'){
				var part1= '<div class="verifier_list w346 vf_ID huzhao">护照证号：<span class="hz_num">'+$(this).attr("data-idcard")+'</span><span class="sex">'+$(this).attr("data-sex")+'</span><span class="country">'+$(this).attr("data-country")+'</span><span class="vf_birth">'+$(this).attr("data-birth")+'</span></div>'
				var part2='';
				if(citytype == 0){
					part2 = '<span class="yanz_status" yanstate="1">不支持验证</span><span class="yanz_icon cursorpt"></span>'
				}
			}else{
				var part1= '<div class="verifier_list w346 vf_ID">身份证号：<span class="IDcord">'+$(this).attr("data-idcard")+'</span></div>'
				var part2=p_yanzheng=='true' ? '<span class="yanz_status" yanstate="1">验证通过，不可修改</span>':'<span class="yanz_status" yanstate="1">验证未通过</span><span class="yanz_icon cursorpt"></span>'
			}
			var part3=p_yanzheng=='true'? '<div class="verifier_list cursorpt w60">'+
			'<span class="vf_edit"></span>'+
			'</div>'+
			'<div class="verifier_list vf_remove cursorpt">'+
			'<span class="vf_remove" remove="1">删除</span>'+
			'</div>':
			'<div class="verifier_list cursorpt w60">'+
			'<span class="vf_edit">编辑</span>'+
			'</div>'+
			'<div class="verifier_list vf_remove cursorpt">'+
			'<span class="vf_remove" remove="1">删除</span>'+
			'</div>'


			$(".vf_table").append('<li class="borb verifier clearfloat success_yanz on_check" list="1" contactid='+p_id+'>'+
				'<div class="vf_list_div">'+
				'<div class="verifier_list w72 vf_name">'+p_name+'</div>'+
				'<div class="verifier_list vf_age" hidden="true">25</div>'+
				part1+
				'<div class="verifier_list w234 relave">'+
				part2+
				'</div>'+
				part3+
				'</div>'+
				'</li>');
			if(onoff==1){
				$(".vf_table").find(".verifier").each(function(){
					$(this).find(".vf_edit").addClass("gray");
					$(this).find(".vf_remove").addClass("gray");
					$(this).find(".vf_check_btn").addClass("false_btn");
				})
			}
		}else{
			removeInsuranceInputIds_new(p_id);
			$(this).removeClass("checked");
			$(".vf_table>li").filter(function(index){
				if($(this).attr("contactid")==p_id){
					return index==$(this).index();
				}
			}).remove();
		}
		checked_num();
	})
	
	/*点击编辑按钮*/
	var olist = 1;
	$(".optional").on("click",".vf_edit",function(){
		if($(this).hasClass("gray")){
			return false;
		}
		$("#iseditperson").val("1");
		yes_btn = "eidt";
		olist = $(this).closest(".verifier").attr("list");
		gray();
		var oPar = $(this).closest(".verifier");
		var name = oPar.find(".vf_name").html();
		var idcord = "";
		var idtype = "";
		var birthday = "";
		var nation = "";
		var sex = "";
		var show = "";
		var idtype = ""
		/*身份证*/
		if(oPar.find(".IDcord").length>0){
			idcord = oPar.find(".IDcord").html();
			idtype = "111"
			
		}else if(oPar.find(".hz_num").length>0){
			/*护照*/
			idcord = oPar.find(".hz_num").html();
			idtype = "414";
			show="show";
			idtype2 =true;
			idtype1=false;
		}
		if(oPar.find(".vf_birth").length>0){
			birthday = oPar.find(".vf_birth").html();
			nation = oPar.find(".country").html();
			sex = oPar.find(".sex").html();
		}
		$(this).closest(".vf_list_div").hide();
		oPar.append(vf_form(name,idcord,show,birthday,nation,""));
		oPar.find(".selectNation").find("option[value='"+nation+"']").attr("selected","selected");
		oPar.find(".select_IDcord ").find("option[value='"+idtype+"']").attr("selected","selected");
		oPar.find("#sex").removeClass('c_gray')
		.find("option[value='placeholder']").remove()
			.end().find("option[value='"+sex+"']").attr("selected","selected");
	})
	
	
	/*取消添加，修改按钮*/
	$(".optional").on("click",".rzr_remove",function(){
		onoff=0;
		$(".addvf_icon").removeClass("gray");
		$(this).closest(".cnt1_dl").remove();  
		if(olist != "" || olist != null){
			var num = olist-1;
			/*if(olist)*/
			$(".verifier[list='"+olist+"']").find(".vf_list_div").show();
		}
		green();	
		olist="";
		yes_btn = "";
		$("#iseditperson").val("0");
		return false;
	})
	
	/*删除已有入住人*/
	var remove_id ="";
	var remove_contact_id = "";
	$(".optional").on("click",".vf_remove",function(){
		if($(this).hasClass("gray")){
			return false;
		}
		$("#layer_rz").show();
		remove_id = $(this).closest(".verifier");
		//发送请求，删除
		remove_contact_id = $(this).closest("li");
		return false;
	})
	$("#vf_layer_close,#layer_rz .cancel").click(function(){
		$("#layer_rz").hide();
	})
	$("#layer_rz .sure").click(function(){
		$("#layer_rz").hide();
		remove_id.remove();
		//执行删除
		var contactid = remove_contact_id.attr("contactid");
		var deleteUrl = $("#ctx").val() + "/order/deleteUserContact";     
        $.get(deleteUrl, {userContactId: contactid}, function(data) {  
            if(data.status==0){
            	showTip("删除成功",2);
            	remove_contact_id.remove();
            	$(".p_list .c_person[data-id='"+contactid+"']").remove();
            	/*复杂写法
            	 $(".p_list .c_person ").each(function(){
        			if($(this).attr("data-id")==contactid){
        				$(this).remove()
        			}
        		})*/
        		green();
        		//删除成功后，交押金的人数以及价格发生变化
        		removeInsuranceInputIds_new(contactid);
        		//setPrice('remove');
        		checked_num();
            }
        });
		
		//showTip("删除成功",2);
		//green();
		/*循环看下是不是删除的最后一个*/
		var onumber = 0;
		$(".p_list .c_person").each(function(){
			onumber++;
		})
		if(onumber<1){
			$(".addvf_icon").addClass("gray");
			$(".optional").append(vf_form("","","","","","dis_no"));
		}
	})
	
	/*点击提交按钮（仅作为弹层演示）*/
	$(".submit").click(function(){
		//$("#layer_rz_notsave").show();
	})
	/**放弃保存，继续提交订单*/
	$("#layer_rz_notsave .cancel").click(function(){
		$("#layer_rz_notsave").hide();
		//$("#iseditperson").val("0");
		$(".rzr_remove").click();
		if(isClickSubmit){
			setTimeout(function(){
				submitOrder();
			},200);
		}else{
			history.go(-1);
		}
	})
	/**继续编辑*/
	$("#vfsave_layer_close,#layer_rz_notsave .sure").click(function(){
		$("#layer_rz_notsave").hide();
	})
	/*所有按钮置灰*/
	function gray(){
		$(".addvf_icon").addClass("gray");
		$(".vf_table").find(".verifier").each(function(){
			$(this).find(".vf_edit").addClass("gray");
			$(this).find(".vf_remove").addClass("gray");
			$(this).find(".vf_check_btn").addClass("false_btn");
		})
	}
	/*所有按钮可点击*/
	function green(){
		$(".addvf_icon").removeClass("gray");
		$(".vf_table").find(".verifier").each(function(){
			$(this).find(".vf_edit").removeClass("gray");
			$(this).find(".vf_remove").removeClass("gray");
			$(this).find(".vf_check_btn").removeClass("false_btn");
		})
	}
	/*验证状态的说明弹层*/
	var oDiv='';
	var yanz_left=0;
	$(".optional").on("mouseover",".yanz_icon",function(){
		var parent = $(this).closest(".verifier_list");
		yanz_left = parseInt(parent.find(".yanz_status").outerWidth())+$(this).outerWidth()+24;
		oDiv = sf_layer_text();
		parent.append(oDiv);
		parent.find(".yanz_status_layer").css("left",yanz_left);
	})
	$(".optional").on("mouseout",".yanz_icon",function(){
		$(this).closest(".verifier_list").find(".yanz_status_layer").remove();
	})
	
	/**修改，添加入住人信息时候，保存，校验*/
	$(".optional").on("click",".rzr_submit",function(){
		var error = $("#error_show");
        var nameval =$(".rz_name").val(); // 名称
        var idtype = $(".select_IDcord").val();
		var idCard = $("#idcord").val();  //身份证号
		var birthday = $(".birthday").val();
		var nation = $("#person_nation1").val();
        var message = "";
        var numberval=$(".select_IDcord").val();
        var rz_lastName = $('.rz_lastName').val().trim().toUpperCase();//姓
        var rz_firstName = $('.rz_firstName').val().trim().toUpperCase();//名
        var rz_email = $('.rz_email').val();//邮箱
        var sex = $("#sex").val();
        if(numberval == '414'){
        	var name_R = /^[A-Z]+$/;
        	if(rz_lastName==""){
        		message="请填写入住人姓氏拼音";
        		error.html(message);
            	return false;
        	}
        	if(!name_R.test(rz_lastName)){
        		message="请填写正确的姓氏拼音";
        		error.html(message);
            	return false;
        	}
        	if(rz_firstName==""){
        		message="请填写入住人名字拼音";
        		error.html(message);
            	return false;
        	}
        	if(!name_R.test(rz_lastName)){
        		message="请填写正确的名字拼音";
        		error.html(message);
            	return false;
        	}
        	nameval = rz_lastName+rz_firstName;
        }
        if(nameval==""){
        	message="请填写真实姓名";
        	error.html(message);
        	return false;
        }	
        var myreg = /^[a-zA-Z\u4e00-\u9fa5\s]+$/; // 真实姓名只能添加英文和汉字
        if(nameval.length<=1 || !myreg.test(nameval)){
        	message="真实姓名不合法！";
        	flag =true;
        	error.html(message);
        	return false;
        }
       	if(numberval=="111"){
	       	if(idCard==""){
	       		message="请填写身份证号码";
	        	flag =true;
	        	error.html(message);
				return false;
	       	}
	       	else if(!checkPapertype(idtype,idCard)){
				message="身份证号码格式不正确！";
	        	flag =true;
	        	error.html(message);
				return false;
			}
	  	}
       	if(numberval=="414"){
       		if(idCard==""){
       			message="请填写护照号码";
	        	flag =true;
	        	error.html(message);
				return false;
       		}
       		//验证护照号格式是否正确、
       		var passport_re = /^[a-zA-Z0-9]{5,20}$/;
       		if(!passport_re.test(idCard)){
       			message="护照号码格式有误，请重新填写！";
       			flag =true;
       			error.html(message);
       			return false;
       		}
	  		if(birthday == "" ||birthday == null){
	  			message="请选择出生日期";
	        	flag =true;
	        	error.html(message);
				return false;
	  		}
	  		if(sex=="" || sex == null){
	  			message="请选择性别";
	        	flag =true;
	        	error.html(message);
				return false;
	  		}
	  		if(rz_email==""){
	  			message="请填写联系人邮箱";
       			flag =true;
       			error.html(message);
       			return false;
	  		}
	  		var email_re = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	  		if(!email_re.test(rz_email)){
	  			message="邮箱格式不正确";
       			flag =true;
       			error.html(message);
       			return false;
			}
	  	}
       	//重复身份证号提示信息
       	if(checkSame(idCard)){
       		message="身份证/护照有重复";
       		error.html(message);
			return false;
       	}
       	
       	/**请求服务器校验身份证和姓名信息是否正确*/
       	var remoteObj = null;
       	//如果是修改，那么获取contactid
       	var thatcontactid = "";
       	if(yes_btn == "add_icon"){
       		thatcontactid = "";
      	}else if(yes_btn == "eidt"){
      		thatcontactid = $(this).closest(".verifier").attr("contactid");
      	}
       	$.ajax({
            type:"post",  //请求方式
            url:"/order/checkSaveUserContact", //服务器的链接地址
            async:false, 
            dataType:"json",
            data:{
            	nameval:nameval,
            	idCard:idCard,
            	idtype:idtype,
            	birthday:birthday,
            	nation:nation,
            	contactId:thatcontactid,
            	sex:sex,
            	lastname:rz_lastName,
            	firstname:rz_firstName,
            	email:rz_email
            },
            success:function(data){
            	remoteObj = data;
            },
            error:function(request){
                alert("发生错误:"+request.status);
            }
       	});
       	if(remoteObj.state==2 || remoteObj.state==-1){
     	   layer.alert(remoteObj.stateDesc,8,"温馨提示");
     	   return false;
        }
       	//end
       	$("#iseditperson").val("0");
      	var num = parseInt($(".verifier").eq($(".verifier").length-1).attr("list"));
      	var cntModel = remoteObj.userContactModel;
      	if(yes_btn == "add_icon"){
      		if(cntModel.idtype == "111"){
      			$(".p_list").append('<div class="c_person " data-type="IDcard"  data-idcard="'+cntModel.idcard+'" data-yanzheng="true" data-id="'+cntModel.id+'"><span></span>'+cntModel.realname+'</div>');
      		}else{
      			$(".p_list").append('<div class="c_person " data-idcard="'+cntModel.idcard+'" data-sex="'+cntModel.sex+'" data-country="'+cntModel.country+'" data-birth ="'+cntModel.birthday+'"  data-yanzheng="false" data-id="'+cntModel.id+'"><span></span>'+cntModel.realname+'</div>');
      		}
      	}
      	$(".rzr_remove").click();
      	$(".p_list .c_person[data-id='"+cntModel.id+"']").on("click",function(){
    		var p_name=$(this).text();
    		var p_type=$(this).attr("data-type");
    		var p_idInfo=$(this).attr("data-info");
    		var p_yanzheng=$(this).attr("data-yanzheng");
    		var p_id=$(this).attr("data-id");
    		var citytype =$('#citytype').val();
    		if(!$(this).hasClass("checked")){
    			addInsuranceInputIds_new(p_id);
    			$(this).addClass("checked")
    			if(p_type!='IDcard'){
    				var part1= '<div class="verifier_list w346 vf_ID huzhao">护照证号：<span class="hz_num">'+$(this).attr("data-idcard")+'</span><span class="sex">'+$(this).attr("data-sex")+'</span><span class="country">'+$(this).attr("data-country")+'</span><span class="vf_birth">'+$(this).attr("data-birth")+'</span></div>'
    				var part2='';
    				if(citytype == 0){
    					part2='<span class="yanz_status" yanstate="1">不支持验证</span><span class="yanz_icon cursorpt"></span>'
    				}
    			}else{
    				var part1= '<div class="verifier_list w346 vf_ID">身份证号：<span class="IDcord">'+$(this).attr("data-idcard")+'</span></div>'
    				var part2=p_yanzheng=='true' ? '<span class="yanz_status" yanstate="1">验证通过，不可修改</span>':'<span class="yanz_status" yanstate="1">验证未通过</span><span class="yanz_icon cursorpt"></span>'
    			}
    			var part3=p_yanzheng=='true'? '<div class="verifier_list cursorpt w60">'+
    			'<span class="vf_edit"></span>'+
    			'</div>'+
    			'<div class="verifier_list vf_remove cursorpt">'+
    			'<span class="vf_remove" remove="1">删除</span>'+
    			'</div>':
    			'<div class="verifier_list cursorpt w60">'+
    			'<span class="vf_edit">编辑</span>'+
    			'</div>'+
    			'<div class="verifier_list vf_remove cursorpt">'+
    			'<span class="vf_remove" remove="1">删除</span>'+
    			'</div>'


    			$(".vf_table").append('<li class="borb verifier clearfloat success_yanz on_check" list="1" contactid='+p_id+'>'+
    				'<div class="vf_list_div">'+
    				'<div class="verifier_list w72 vf_name">'+p_name+'</div>'+
    				'<div class="verifier_list vf_age" hidden="true">25</div>'+
    				part1+
    				'<div class="verifier_list w234 relave">'+
    				part2+
    				'</div>'+
    				part3+
    				'</div>'+
    				'</li>');
    			if(onoff==1){
    				$(".vf_table").find(".verifier").each(function(){
    					$(this).find(".vf_edit").addClass("gray");
    					$(this).find(".vf_remove").addClass("gray");
    					$(this).find(".vf_check_btn").addClass("false_btn");
    				})
    			}
    		}else{
    			removeInsuranceInputIds_new(p_id);
    			$(this).removeClass("checked");
    			$(".vf_table>li").filter(function(index){
    				if($(this).attr("contactid")==p_id){
    					return index==$(this).index();
    				}
    			}).remove();
    		}
    		checked_num();
    	})
      	$(".p_list .c_person[data-id='"+cntModel.id+"']").click();
      	/*if(yes_btn == "add_icon"){
     
      		if($(".verifier").length<1){
	      		num=1;
	      		$(".vf_table").append(list(num,cntModel.id,cntModel.realname,cntModel.age,cntModel.idtype,cntModel.idcard,remoteObj.state,remoteObj.stateDesc,cntModel.birthday,cntModel.country,cntModel.sex));
	      		$(".rzr_remove").removeClass("dis_no");
	      		
	      	}else{
	      		$(".vf_table").append(list((num+1),cntModel.id,cntModel.realname,cntModel.age,cntModel.idtype,cntModel.idcard,remoteObj.state,remoteObj.stateDesc,cntModel.birthday,cntModel.country,cntModel.sex));
	      	}
      	}*/
      	/*else if(yes_btn == "eidt"){
      		var opar = $(this).closest(".verifier");
      		var idx =opar.index();
      		var obj = list((idx+1),cntModel.id,cntModel.realname,cntModel.age,cntModel.idtype,cntModel.idcard,remoteObj.state,remoteObj.stateDesc,cntModel.birthday,cntModel.country,cntModel.sex);
      		$(".vf_table .verifier").eq(idx).before(obj);
      		opar.remove();
      		
      	}
  		//只要添加了，那么就默认勾选，认证失败的话，不会出现勾选
  		if(remoteObj.userContactModel.state != 2){
  			addInsuranceInputIds_new(remoteObj.userContactModel.id);
			//setPrice('add');
  		}
      	
      	green();
      	$(this).closest(".cnt1_dl").remove();
		onoff=0;
    	$(".addvf_icon").show().removeClass("gray");
    	checked_num();*/
    	yes_btn="add_icon";
	})
	
	
	//检查是否有重复的身份证号码
	function checkSame(oneIdCard) {
	    var idcardArray = new Array();
	    var error = false;
		$(".IDcord").each(function(){
			if($(this).closest(".vf_list_div")!=null && $(this).closest(".vf_list_div").css("display")!='none' ){
				var id = $(this).html();
				idcardArray.push(id);
			}
			
		});
	    $(".hz_num").each(function(){
	    	if($(this).closest(".vf_list_div")!=null && $(this).closest(".vf_list_div").css("display")!='none' ){
	    		var id = $(this).html();
				idcardArray.push(id);
			}
			
		});
	    if (contains(idcardArray, oneIdCard)) {
	        error = true;
	    }
	    return error;
	    
	}
	/*拼接验证状态弹层*/
	function sf_layer_text(){
		var str = '<div class="asote yanz_status_layer">';
			str += '<p>为了确保入住人投保成功并真正享受到《住宿意外险》的安全保障，蚂蚁将免费为每位入住人进行身份信息验证。</p>';
			str += '<p>验证通过的入住人，信息不可再修改。<br/>尚未验证的入住人，会在您选中后点击“确定”按钮时进行验证。</p>';
			str += '<p>验证失败的入住人，无法进行投保，请您修改入住人信息。</p>';
			str += '<p>目前暂不支持身份证以外的证件类型验证，请您确保信息填写无误，否则将无法享受保险公司的理赔服务。</p>';
			str += '</div>';
		return str;
	}
	/*拼接添加保险表单*/
	/*function vf_form(name,idcord,show,birthday,nation,dis_no){
		var vf_form = '<dl class="cnt1_dl clearfloat ">';
			vf_form += '<dt class="fl">入住人姓名</dt>';
			vf_form += '<dd class="fl clearfloat" style="position:relative">';
			vf_form += '<div class="fl ruzhu_form">';
			vf_form += '<div class="clearfloat">';
			vf_form += '<input type="text" placeholder="真实姓名" class="rzr_list w108 mr26 fl rz_name" value="'+name+'"/>';
			vf_form += '<div class="border w92 mar_r_6 fl"><select class="rzr_list pad_l_4 select_IDcord w92 " autocomplete="off">';
			vf_form += '<option name="cardtypevalue" value="111">身份证</option>';
			vf_form += '<option name="cardtypevalue" value="414">护照</option>';
			vf_form += '</select></div>';
			vf_form += '<input type="text" placeholder="证件号码" class="rzr_list w190 fl" value="'+idcord+'" id="idcord"/>';
			vf_form += '</div>';
			vf_form += '<div class="mt16 clearfloat bors_country '+show+'">';
			vf_form += '<input type="text" placeholder="出生日期" class="J_Select birthday fl w190 mr26" value="'+birthday+'"/>';
			vf_form += '<div class="border mr26"><select class="rzr_list w84 fl selectNation pl10 c_gray" id="sex" autocomplete="off">'
			vf_form += '<option value="placeholder" class="c_gray" disabled selected>性别</option><option value="男">男</option><option value="女">女</option>';
			vf_form += '</select></div>';
			vf_form += '<div class="border"><select class="rzr_list w170 fl selectNation pl10" id="person_nation1" autocomplete="off">';
			vf_form += '<option value="阿富汗">阿富汗AFGHANISTANA</option><option value="阿尔巴尼亚">阿尔巴尼亚ALBANIA</option><option value="阿尔及利亚">阿尔及利亚ALGERIA</option><option value="安道尔">安道尔ANDORRA</option><option value="安哥拉">安哥拉ANGOLA</option><option value="安提瓜和巴布达">安提瓜和巴布达ANTIGUABARBUDA</option><option value="阿拉伯联合酋长国">阿拉伯联合酋长国ARAB</option><option value="阿根廷">阿根廷ARGENTINA</option><option value="亚美尼亚">亚美尼亚ARMENIA</option><option value="阿鲁巴">阿鲁巴ARUBA</option><option value="澳大利亚">澳大利亚AUSTRALIA</option><option value="奥地利">奥地利AUSTRIA</option><option value="阿塞拜疆共和国">阿塞拜疆共和国AZERBAIJAN</option><option value="巴哈马">巴哈马BAHAMAS</option><option value="巴林">巴林BAHRAIN</option><option value="孟加拉国">孟加拉国BANGLADESH</option><option value="巴巴多斯">巴巴多斯BARBADOS</option><option value="白俄罗斯">白俄罗斯BELARUS</option><option value="比利时">比利时BELGIUM</option><option value="伯里兹">伯里兹BELIZE</option><option value="伯利兹">伯利兹BELIZE</option><option value="贝宁">贝宁BENIN</option><option value="不丹">不丹BHUTAN</option><option value="玻利维亚">玻利维亚BOLIVIA</option><option value="波斯尼亚和黑塞哥维那">波斯尼亚和黑塞哥维那BOSNIA</option><option value="博茨瓦纳">博茨瓦纳BOTSWANA</option><option value="巴西">巴西BRAZIL</option><option value="文莱">文莱BruneiDarussalam</option><option value="保加利亚">保加利亚BULGARIA</option><option value="布基纳法索">布基纳法索BURKINAFASO</option><option value="布隆迪">布隆迪BURUNDI</option><option value="柬埔寨">柬埔寨CAMBODIA</option><option value="喀麦隆">喀麦隆CAMEROON</option><option value="加拿大">加拿大CANADA</option><option value="佛得角">佛得角CAPEVERDE</option><option value="中非共和国">中非共和国Central Africa Republic</option><option value="乍得">乍得CHAD</option><option value="智利">智利CHILE</option><option value="中国" selected>中国CHINA</option><option value="哥伦比亚">哥伦比亚COLOMBIA</option><option value="科摩罗">科摩罗COMOROS</option><option value="刚果（布）">刚果（布）CONGO</option><option value="库克群岛">库克群岛COOKISLANDS</option><option value="哥斯达黎加">哥斯达黎加CostaRica</option><option value="科特迪瓦">科特迪瓦COTEDLVOIRE</option><option value="克罗地亚">克罗地亚CROATIA</option><option value="古巴共和国">古巴共和国CUBA</option><option value="塞浦路斯">塞浦路斯CYPRUS</option><option value="捷克共和国">捷克共和国CZECHREPUBLIC</option><option value="刚果（金）">刚果（金）DEMOCRATIC REPUBLIC OF CONGO</option><option value="也门民主人民共和国">也门民主人民共和国DEMOCRATICYEMEN</option><option value="丹麦">丹麦DENMARK</option><option value="吉布提">吉布提DJIBOUTI</option><option value="多米尼克">多米尼克DOMINICA</option><option value="多米尼加">多米尼加DOMINICAN REPUBLIC</option><option value="厄瓜多尔">厄瓜多尔ECUADOR</option><option value="埃及">埃及EGYPT</option><option value="萨尔瓦多">萨尔瓦多EL SALVADOR</option><option value="赤道几内亚">赤道几内亚EQUATORIALGUINEA</option><option value="厄立特里亚">厄立特里亚ERITREA</option><option value="爱沙尼亚">爱沙尼亚ESTONIA</option><option value="埃塞俄比亚">埃塞俄比亚ETHIOPIA</option><option value="斐济">斐济FIJI</option><option value="芬兰">芬兰FINLAND</option><option value="法国">法国FRANCE</option><option value="加蓬">加蓬GABON</option><option value="冈比亚">冈比亚GAMBIA</option><option value="格鲁吉亚">格鲁吉亚GEORGIA</option><option value="德国">德国GERMANY</option><option value="加纳">加纳GHANA</option><option value="希腊">希腊GREECE</option><option value="格林纳达">格林纳达GRENADA</option><option value="危地马拉">危地马拉Guatemala</option><option value="几内亚">几内亚GUINEA</option><option value="几内亚比绍">几内亚比绍GUINEABISSAU</option><option value="圭亚那">圭亚那GUYANA</option><option value="海地">海地HAITI</option><option value="荷兰">荷兰HOLLAND</option><option value="洪都拉斯">洪都拉斯HONDURAS</option><option value="匈牙利">匈牙利HUNGARY</option><option value="冰岛">冰岛ICELAND</option><option value="印度">印度INDIA</option><option value="印度尼西亚">印度尼西亚INDONESIA</option><option value="伊朗">伊朗IRAN</option><option value="伊拉克">伊拉克IRAQ</option><option value="爱尔兰">爱尔兰IRELAND</option><option value="以色列">以色列ISRAEL</option><option value="意大利">意大利ITALY</option><option value="牙买加">牙买加JAMAICA</option><option value="日本">日本JAPAN</option><option value="约旦">约旦JORDAN</option><option value="哈萨克斯坦">哈萨克斯坦KAZAKHSTAN</option><option value="肯尼亚">肯尼亚KENYA</option><option value="吉尔吉斯共和国">吉尔吉斯共和国KIRGIZSTAN</option><option value="基里巴斯">基里巴斯KIRIBATI</option><option value="韩国">韩国KOREA</option><option value="朝鲜">朝鲜Korea</option><option value="科威特">科威特KUWAIT</option><option value="老挝">老挝LAOS</option><option value="拉脱维亚">拉脱维亚LATVIA</option><option value="黎巴嫩">黎巴嫩LEBANON</option><option value="莱索托">莱索托LESOTHO</option><option value="利比里亚">利比里亚LIBERIA</option><option value="利比亚">利比亚LIBYA</option><option value="列支敦士登">列支敦士登LIECHTENSTEIN</option><option value="立陶宛">立陶宛LITHUANIA</option><option value="卢森堡">卢森堡LUXEMBOURG</option><option value="马其顿">马其顿MACEDONIA</option><option value="马达加斯加">马达加斯加MADAGASCAR</option><option value="马拉维">马拉维MALAWI</option><option value="马来西亚">马来西亚MALAYSIA</option><option value="马尔代夫">马尔代夫MALDIVES</option><option value="马里">马里MALI</option><option value="马耳他">马耳他MALTA</option><option value="马绍尔群岛">马绍尔群岛MARSHALL ISLANDS</option><option value="毛里塔尼亚">毛里塔尼亚MAURITANIA</option><option value="毛里求斯">毛里求斯MAURITIUS</option><option value="墨西哥">墨西哥MEXICO</option><option value="密克罗尼西亚联邦">密克罗尼西亚联邦MICRONESIA</option><option value="摩尔多瓦">摩尔多瓦MOLDOVA</option><option value="摩纳哥">摩纳哥MONACO</option><option value="蒙古">蒙古MONGOLIA</option><option value="黑山">黑山MONTENEGRO</option><option value="摩洛哥">摩洛哥MOROCCO</option><option value="莫桑比克">莫桑比克MOZAMBIQUE</option><option value="缅甸">缅甸MYANMAR</option><option value="纳米比亚">纳米比亚NAMIBIA</option><option value="瑙鲁">瑙鲁NAURU</option><option value="尼泊尔">尼泊尔NEPAL</option><option value="新西兰">新西兰NEWZEALAND</option><option value="尼加拉瓜">尼加拉瓜NICARAGUA</option><option value="尼日尔">尼日尔NIGER</option><option value="尼日利亚">尼日利亚NIGERIA</option><option value="挪威">挪威NORWAY</option><option value="阿曼">阿曼OMAN</option><option value="巴基斯坦">巴基斯坦PAKISTAN</option><option value="帕劳">帕劳PALAU</option><option value="巴勒斯坦">巴勒斯坦PALESTINE</option><option value="巴拿马">巴拿马PANAMA</option><option value="巴布亚新几内亚">巴布亚新几内亚PAPUANEWGUINEA</option><option value="巴拉圭">巴拉圭PARAGUAY</option><option value="秘鲁">秘鲁PERU</option><option value="菲律宾">菲律宾PHILIPPINES</option><option value="波兰">波兰POLAND</option><option value="葡萄牙">葡萄牙PORTUGAL</option><option value="波多黎各">波多黎各PUERTO RICO</option><option value="卡塔尔">卡塔尔QATAR</option><option value="罗马尼亚">罗马尼亚ROMANIA</option><option value="俄罗斯">俄罗斯RUSSIA</option><option value="卢旺达">卢旺达RWANDA</option><option value="圣基茨和尼维斯">圣基茨和尼维斯SAINT KITTS</option><option value="圣文森特和格林纳丁斯">圣文森特和格林纳丁斯SAINT VINCENT AND THE GRENADIN</option><option value="圣卢西亚">圣卢西亚SAINTLUCIA</option><option value="美属萨摩亚">美属萨摩亚SAMOA</option><option value="圣马力诺">圣马力诺SANMARINO</option><option value="圣多美和普林西比">圣多美和普林西比SAOTOMEPRINCIPE</option><option value="沙特阿拉伯">沙特阿拉伯SAUDIARABIA</option><option value="塞内加尔">塞内加尔SENEGAL</option><option value="塞尔维亚">塞尔维亚SERBIA</option><option value="塞舌尔">塞舌尔SEYCHELLES</option><option value="塞拉利昂">塞拉利昂SIERRALEONE</option><option value="新加坡">新加坡SINGAPORE</option><option value="斯洛伐克">斯洛伐克SLOVAKIA</option><option value="斯洛伐克共和国">斯洛伐克共和国SLOVAKREPUBLIC</option><option value="斯洛文尼亚">斯洛文尼亚SLOVENIA</option><option value="所罗门群岛">所罗门群岛SOLOMON ISLANDS</option><option value="索马里">索马里SOMALI</option><option value="南非">南非SOUTHAFRICA</option><option value="西班牙">西班牙SPAIN</option><option value="斯里兰卡">斯里兰卡SRILANKA</option><option value="苏丹">苏丹SUDAN</option><option value="苏里南">苏里南SURINAM</option><option value="斯威士兰">斯威士兰SWAZILAND</option><option value="瑞典">瑞典SWEDEN</option><option value="瑞士">瑞士SWITZERLAND</option><option value="叙利亚">叙利亚SYRIA</option><option value="塔吉克斯坦">塔吉克斯坦TAJIKISTAN</option><option value="坦桑尼亚">坦桑尼亚TANZANIA</option><option value="泰国">泰国THAILAND</option><option value="乌干达">乌干达THE REPUBLIC OF UGANDA</option><option value="东帝汶">东帝汶TIMOR</option><option value="多哥">多哥TOGO</option><option value="汤加">汤加TONGA</option><option value="特立尼达和多巴哥">特立尼达和多巴哥TRINIDADANDTOBAGO</option><option value="突尼斯">突尼斯TUNISIA</option><option value="土耳其">土耳其TURKEY</option><option value="土库曼斯坦">土库曼斯坦TURKMENISTAN</option><option value="乌克兰">乌克兰UKRAINE</option><option value="英国">英国UNITED KINGDOM</option><option value="美国">美国UNITEDSTATES</option><option value="乌拉圭">乌拉圭Uruguay</option><option value="乌兹别克斯坦">乌兹别克斯坦UZBEKISTAN</option><option value="瓦努阿图">瓦努阿图VANUATU</option><option value="梵蒂冈">梵蒂冈VATICAN</option><option value="委内瑞拉">委内瑞拉Venezuela</option><option value="越南">越南VIETNAM</option><option value="赞比亚">赞比亚ZAMBIA</option><option value="津巴布韦">津巴布韦ZIMBABWE</option>';
			vf_form += '</select></div>';
			vf_form += '</div>';
			vf_form += '<span class="error"></span>';
			vf_form += '</div>'
			vf_form += '<span class="rzr_submit fl green_btn">保存</span>';
			vf_form += '<span class="rzr_remove fl '+dis_no+'">取消</span>';
			vf_form += '</dd>';
			vf_form += '</dl>';
		
		return vf_form;
	}*/
	/*拼接添加保险表单*/
	function vf_form(name,idcord,show,birthday,nation,dis_no){
		var citytype =$('#citytype').val();
		var vf_form = '<dl class="cnt1_dl clearfloat add_newperson">';
			vf_form += '<dt class="fl">添加入住人</dt>';
			vf_form += '<dd class="fl clearfloat" style="position:relative">';
			vf_form += '<div class="fl ruzhu_form">';
			vf_form += '<div class="clearfloat">';
			if(citytype == 1){
				vf_form +='<input  style="display: none;" type="text" placeholder="真实姓名" class="rzr_list w108 mr10 fl rz_name" value="">';
				vf_form +='<div class="fl overseas" >';
				vf_form +='<input type="text" placeholder="姓(拼音,如ZHANG)" class="rzr_list mr10 fl rz_lastName" maxlength="25" onkeyup="value=value.replace(/[^a-zA-Z]/g,\'\');" style="text-transform:uppercase;">';
				vf_form +='<input type="text" placeholder="名(拼音,如SAN)" class="rzr_list mr10 fl rz_firstName"  maxlength="25" onkeyup="value=value.replace(/[^a-zA-Z]/g,\'\');" style="text-transform:uppercase;">';
				vf_form +='</div>';
			}
			else{
				vf_form +='<input type="text" placeholder="真实姓名" class="rzr_list w108 mr10 fl rz_name" value="">';
				vf_form +='<div class="fl overseas" style="display: none;">';
				vf_form +='<input type="text" placeholder="姓(拼音,如ZHANG)" class="rzr_list mr10 fl rz_lastName" maxlength="25" onkeyup="value=value.replace(/[^a-zA-Z]/g,\'\');" style="text-transform:uppercase;">';
				vf_form +='<input type="text" placeholder="名(拼音,如SAN)" class="rzr_list mr10 fl rz_firstName"  maxlength="25" onkeyup="value=value.replace(/[^a-zA-Z]/g,\'\');" style="text-transform:uppercase;">';
				vf_form +='</div>';
			}
			
			vf_form += '<div class="border w70 border_r_no fl"><select class="rzr_list pad_l_4 select_IDcord w70" autocomplete="off">';
			if(citytype == 1){
				vf_form += '<option name="cardtypevalue" value="414">护照</option>';
			}
			else{
				vf_form += '<option name="cardtypevalue" value="111">身份证</option>';
				vf_form += '<option name="cardtypevalue" value="414">护照</option>';
			}
			vf_form += '</select></div>';
			if(citytype == 1){
				vf_form += '<input type="text" placeholder="证件号码" class="rzr_list w122 fl" value="'+idcord+'" id="idcord"/>';
			}
			else{
				vf_form += '<input type="text" placeholder="证件号码" class="rzr_list w190 fl" value="'+idcord+'" id="idcord"/>';
			}
			
			vf_form += '</div>';
			if(citytype == 1){
				show = "show"
			}
			vf_form += '<div class="mt16 clearfloat bors_country '+show+'">';
			vf_form += '<input type="text" placeholder="出生日期" class="J_Select birthday fl w80  mr10" value="'+birthday+'"/>';
			vf_form += '<div class="border mr10"><select class="rzr_list w84 fl selectNation pl10 c_gray" id="sex" autocomplete="off">'
			vf_form += '<option value="placeholder" class="c_gray" disabled selected>性别</option><option value="男">男</option><option value="女">女</option>';
			vf_form += '</select></div>';
			vf_form += '<div class="border mr10"><select class="rzr_list w112 fl selectNation pl10" id="person_nation1" autocomplete="off">';
			vf_form += '<option value="阿富汗">阿富汗AFGHANISTANA</option><option value="阿尔巴尼亚">阿尔巴尼亚ALBANIA</option><option value="阿尔及利亚">阿尔及利亚ALGERIA</option><option value="安道尔">安道尔ANDORRA</option><option value="安哥拉">安哥拉ANGOLA</option><option value="安提瓜和巴布达">安提瓜和巴布达ANTIGUABARBUDA</option><option value="阿拉伯联合酋长国">阿拉伯联合酋长国ARAB</option><option value="阿根廷">阿根廷ARGENTINA</option><option value="亚美尼亚">亚美尼亚ARMENIA</option><option value="阿鲁巴">阿鲁巴ARUBA</option><option value="澳大利亚">澳大利亚AUSTRALIA</option><option value="奥地利">奥地利AUSTRIA</option><option value="阿塞拜疆共和国">阿塞拜疆共和国AZERBAIJAN</option><option value="巴哈马">巴哈马BAHAMAS</option><option value="巴林">巴林BAHRAIN</option><option value="孟加拉国">孟加拉国BANGLADESH</option><option value="巴巴多斯">巴巴多斯BARBADOS</option><option value="白俄罗斯">白俄罗斯BELARUS</option><option value="比利时">比利时BELGIUM</option><option value="伯里兹">伯里兹BELIZE</option><option value="伯利兹">伯利兹BELIZE</option><option value="贝宁">贝宁BENIN</option><option value="不丹">不丹BHUTAN</option><option value="玻利维亚">玻利维亚BOLIVIA</option><option value="波斯尼亚和黑塞哥维那">波斯尼亚和黑塞哥维那BOSNIA</option><option value="博茨瓦纳">博茨瓦纳BOTSWANA</option><option value="巴西">巴西BRAZIL</option><option value="文莱">文莱BruneiDarussalam</option><option value="保加利亚">保加利亚BULGARIA</option><option value="布基纳法索">布基纳法索BURKINAFASO</option><option value="布隆迪">布隆迪BURUNDI</option><option value="柬埔寨">柬埔寨CAMBODIA</option><option value="喀麦隆">喀麦隆CAMEROON</option><option value="加拿大">加拿大CANADA</option><option value="佛得角">佛得角CAPEVERDE</option><option value="中非共和国">中非共和国Central Africa Republic</option><option value="乍得">乍得CHAD</option><option value="智利">智利CHILE</option><option value="中国" selected>中国CHINA</option><option value="哥伦比亚">哥伦比亚COLOMBIA</option><option value="科摩罗">科摩罗COMOROS</option><option value="刚果（布）">刚果（布）CONGO</option><option value="库克群岛">库克群岛COOKISLANDS</option><option value="哥斯达黎加">哥斯达黎加CostaRica</option><option value="科特迪瓦">科特迪瓦COTEDLVOIRE</option><option value="克罗地亚">克罗地亚CROATIA</option><option value="古巴共和国">古巴共和国CUBA</option><option value="塞浦路斯">塞浦路斯CYPRUS</option><option value="捷克共和国">捷克共和国CZECHREPUBLIC</option><option value="刚果（金）">刚果（金）DEMOCRATIC REPUBLIC OF CONGO</option><option value="也门民主人民共和国">也门民主人民共和国DEMOCRATICYEMEN</option><option value="丹麦">丹麦DENMARK</option><option value="吉布提">吉布提DJIBOUTI</option><option value="多米尼克">多米尼克DOMINICA</option><option value="多米尼加">多米尼加DOMINICAN REPUBLIC</option><option value="厄瓜多尔">厄瓜多尔ECUADOR</option><option value="埃及">埃及EGYPT</option><option value="萨尔瓦多">萨尔瓦多EL SALVADOR</option><option value="赤道几内亚">赤道几内亚EQUATORIALGUINEA</option><option value="厄立特里亚">厄立特里亚ERITREA</option><option value="爱沙尼亚">爱沙尼亚ESTONIA</option><option value="埃塞俄比亚">埃塞俄比亚ETHIOPIA</option><option value="斐济">斐济FIJI</option><option value="芬兰">芬兰FINLAND</option><option value="法国">法国FRANCE</option><option value="加蓬">加蓬GABON</option><option value="冈比亚">冈比亚GAMBIA</option><option value="格鲁吉亚">格鲁吉亚GEORGIA</option><option value="德国">德国GERMANY</option><option value="加纳">加纳GHANA</option><option value="希腊">希腊GREECE</option><option value="格林纳达">格林纳达GRENADA</option><option value="危地马拉">危地马拉Guatemala</option><option value="几内亚">几内亚GUINEA</option><option value="几内亚比绍">几内亚比绍GUINEABISSAU</option><option value="圭亚那">圭亚那GUYANA</option><option value="海地">海地HAITI</option><option value="荷兰">荷兰HOLLAND</option><option value="洪都拉斯">洪都拉斯HONDURAS</option><option value="匈牙利">匈牙利HUNGARY</option><option value="冰岛">冰岛ICELAND</option><option value="印度">印度INDIA</option><option value="印度尼西亚">印度尼西亚INDONESIA</option><option value="伊朗">伊朗IRAN</option><option value="伊拉克">伊拉克IRAQ</option><option value="爱尔兰">爱尔兰IRELAND</option><option value="以色列">以色列ISRAEL</option><option value="意大利">意大利ITALY</option><option value="牙买加">牙买加JAMAICA</option><option value="日本">日本JAPAN</option><option value="约旦">约旦JORDAN</option><option value="哈萨克斯坦">哈萨克斯坦KAZAKHSTAN</option><option value="肯尼亚">肯尼亚KENYA</option><option value="吉尔吉斯共和国">吉尔吉斯共和国KIRGIZSTAN</option><option value="基里巴斯">基里巴斯KIRIBATI</option><option value="韩国">韩国KOREA</option><option value="朝鲜">朝鲜Korea</option><option value="科威特">科威特KUWAIT</option><option value="老挝">老挝LAOS</option><option value="拉脱维亚">拉脱维亚LATVIA</option><option value="黎巴嫩">黎巴嫩LEBANON</option><option value="莱索托">莱索托LESOTHO</option><option value="利比里亚">利比里亚LIBERIA</option><option value="利比亚">利比亚LIBYA</option><option value="列支敦士登">列支敦士登LIECHTENSTEIN</option><option value="立陶宛">立陶宛LITHUANIA</option><option value="卢森堡">卢森堡LUXEMBOURG</option><option value="马其顿">马其顿MACEDONIA</option><option value="马达加斯加">马达加斯加MADAGASCAR</option><option value="马拉维">马拉维MALAWI</option><option value="马来西亚">马来西亚MALAYSIA</option><option value="马尔代夫">马尔代夫MALDIVES</option><option value="马里">马里MALI</option><option value="马耳他">马耳他MALTA</option><option value="马绍尔群岛">马绍尔群岛MARSHALL ISLANDS</option><option value="毛里塔尼亚">毛里塔尼亚MAURITANIA</option><option value="毛里求斯">毛里求斯MAURITIUS</option><option value="墨西哥">墨西哥MEXICO</option><option value="密克罗尼西亚联邦">密克罗尼西亚联邦MICRONESIA</option><option value="摩尔多瓦">摩尔多瓦MOLDOVA</option><option value="摩纳哥">摩纳哥MONACO</option><option value="蒙古">蒙古MONGOLIA</option><option value="黑山">黑山MONTENEGRO</option><option value="摩洛哥">摩洛哥MOROCCO</option><option value="莫桑比克">莫桑比克MOZAMBIQUE</option><option value="缅甸">缅甸MYANMAR</option><option value="纳米比亚">纳米比亚NAMIBIA</option><option value="瑙鲁">瑙鲁NAURU</option><option value="尼泊尔">尼泊尔NEPAL</option><option value="新西兰">新西兰NEWZEALAND</option><option value="尼加拉瓜">尼加拉瓜NICARAGUA</option><option value="尼日尔">尼日尔NIGER</option><option value="尼日利亚">尼日利亚NIGERIA</option><option value="挪威">挪威NORWAY</option><option value="阿曼">阿曼OMAN</option><option value="巴基斯坦">巴基斯坦PAKISTAN</option><option value="帕劳">帕劳PALAU</option><option value="巴勒斯坦">巴勒斯坦PALESTINE</option><option value="巴拿马">巴拿马PANAMA</option><option value="巴布亚新几内亚">巴布亚新几内亚PAPUANEWGUINEA</option><option value="巴拉圭">巴拉圭PARAGUAY</option><option value="秘鲁">秘鲁PERU</option><option value="菲律宾">菲律宾PHILIPPINES</option><option value="波兰">波兰POLAND</option><option value="葡萄牙">葡萄牙PORTUGAL</option><option value="波多黎各">波多黎各PUERTO RICO</option><option value="卡塔尔">卡塔尔QATAR</option><option value="罗马尼亚">罗马尼亚ROMANIA</option><option value="俄罗斯">俄罗斯RUSSIA</option><option value="卢旺达">卢旺达RWANDA</option><option value="圣基茨和尼维斯">圣基茨和尼维斯SAINT KITTS</option><option value="圣文森特和格林纳丁斯">圣文森特和格林纳丁斯SAINT VINCENT AND THE GRENADIN</option><option value="圣卢西亚">圣卢西亚SAINTLUCIA</option><option value="美属萨摩亚">美属萨摩亚SAMOA</option><option value="圣马力诺">圣马力诺SANMARINO</option><option value="圣多美和普林西比">圣多美和普林西比SAOTOMEPRINCIPE</option><option value="沙特阿拉伯">沙特阿拉伯SAUDIARABIA</option><option value="塞内加尔">塞内加尔SENEGAL</option><option value="塞尔维亚">塞尔维亚SERBIA</option><option value="塞舌尔">塞舌尔SEYCHELLES</option><option value="塞拉利昂">塞拉利昂SIERRALEONE</option><option value="新加坡">新加坡SINGAPORE</option><option value="斯洛伐克">斯洛伐克SLOVAKIA</option><option value="斯洛伐克共和国">斯洛伐克共和国SLOVAKREPUBLIC</option><option value="斯洛文尼亚">斯洛文尼亚SLOVENIA</option><option value="所罗门群岛">所罗门群岛SOLOMON ISLANDS</option><option value="索马里">索马里SOMALI</option><option value="南非">南非SOUTHAFRICA</option><option value="西班牙">西班牙SPAIN</option><option value="斯里兰卡">斯里兰卡SRILANKA</option><option value="苏丹">苏丹SUDAN</option><option value="苏里南">苏里南SURINAM</option><option value="斯威士兰">斯威士兰SWAZILAND</option><option value="瑞典">瑞典SWEDEN</option><option value="瑞士">瑞士SWITZERLAND</option><option value="叙利亚">叙利亚SYRIA</option><option value="塔吉克斯坦">塔吉克斯坦TAJIKISTAN</option><option value="坦桑尼亚">坦桑尼亚TANZANIA</option><option value="泰国">泰国THAILAND</option><option value="乌干达">乌干达THE REPUBLIC OF UGANDA</option><option value="东帝汶">东帝汶TIMOR</option><option value="多哥">多哥TOGO</option><option value="汤加">汤加TONGA</option><option value="特立尼达和多巴哥">特立尼达和多巴哥TRINIDADANDTOBAGO</option><option value="突尼斯">突尼斯TUNISIA</option><option value="土耳其">土耳其TURKEY</option><option value="土库曼斯坦">土库曼斯坦TURKMENISTAN</option><option value="乌克兰">乌克兰UKRAINE</option><option value="英国">英国UNITED KINGDOM</option><option value="美国">美国UNITEDSTATES</option><option value="乌拉圭">乌拉圭Uruguay</option><option value="乌兹别克斯坦">乌兹别克斯坦UZBEKISTAN</option><option value="瓦努阿图">瓦努阿图VANUATU</option><option value="梵蒂冈">梵蒂冈VATICAN</option><option value="委内瑞拉">委内瑞拉Venezuela</option><option value="越南">越南VIETNAM</option><option value="赞比亚">赞比亚ZAMBIA</option><option value="津巴布韦">津巴布韦ZIMBABWE</option>';
			vf_form += '</select></div><input type="text" placeholder="邮箱(用于接收确认函，详细入住说明)" class="rzr_list w254 rz_email" maxlength="64" >';
			vf_form += '</div>';
			vf_form += '<span class="error" id="error_show"></span>';
			vf_form += '</div>'
			vf_form += '<div class="absot"><span class="rzr_submit fl c22bb62">保存</span>';
			vf_form += '<span class="rzr_remove fl '+dis_no+'">取消</span></div>';
			vf_form += '</dd>';
			vf_form += '</dl>';
		
		return vf_form;
	}
	
	/*创建一个新的保险人列表项*/
	function list(list_num){
		var citytype =$('#citytype').val();
		var str = '<li class="borb verifier clearfloat nosupport_yanz on_check" list="'+list_num+'">';
			str += '<div class="vf_list_div">';
			str += '<div class="verifier_list vf_check on_check"><span class="vf_check_btn"></span></div>';
			str += '<div class="verifier_list w72 vf_name">汪峰</div>';
			str += '<div class="verifier_list w346 huzhao">护照号码：<span class="hz_num">E3870209</span><span class="country">中国</span><span class="vf_birth">1990-09-09</span></div>';
			str += '<div class="verifier_list w234 relave">';
			if(citytype == 0 ){
				str += '<span class="yanz_status">不支持验证</span>';
				str += '<span class="yanz_icon cursorpt"></span>';
			}
			str += '</div>';
			str += '<div class="verifier_list cursorpt w60">';
			str += '<span class="vf_edit gray">编辑</span>';
			str += '</div>';
			str += '<div class="verifier_list vf_remove cursorpt">';
			str += '<span class="vf_remove">删除</span>';
			str += '</div>';
			str += '</div>';
			str += '</li>';   
		return str;
	}
	/*创建一个新的保险人列表项*/
	function list(list_num,id,name,age,idtype,idCard,state,stateDesc,birthday,nation,sex){
		var str = '';
		var citytype =$('#citytype').val();
		if(state==0){
			str += '<li class="borb verifier clearfloat nosupport_yanz on_check" list="'+list_num+'" contactid="'+id+'" >';
		}else if (state==1){
			str += '<li class="borb verifier clearfloat success_yanz on_check" list="'+list_num+'" contactid="'+id+'" >';
		}else if (state==2){
			str += '<li class="borb verifier clearfloat false_yanz " list="'+list_num+'" contactid="'+id+'" >';
		}else if(state==3){
			str += '<li class="borb verifier clearfloat no_yanz on_check" list="'+list_num+'" contactid="'+id+'" >';
		}
		
		str += '<div class="vf_list_div">';
		str += '<div class="verifier_list vf_check on_check"><span class="vf_check_btn"></span></div>';
		str += '<div class="verifier_list w72 vf_name">'+name+'</div>';
		str += '<div class="verifier_list vf_age" hidden="true">'+age+'</div>';
		if(idtype==111){
			str += '<div class="verifier_list w346 vf_ID">身份证号：<span class="IDcord">'+idCard+'</span></div>';
		}else{
			str += '<div class="verifier_list w346 huzhao">护照号码：<span class="hz_num">'+idCard+'</span><span class="sex">'+sex+'</span><span class="country">'+nation+'</span><span class="vf_birth">'+birthday+'</span></div>';
		}
		str += '<div class="verifier_list w234 relave">';
		if(citytype == 0){
			str += '<span class="yanz_status" yanstate="'+state+'">'+stateDesc+'</span>';
			str += '<span class="yanz_icon cursorpt"></span>';
		}
		str += '</div>';
		if(state==1){
			str += '<div class="verifier_list cursorpt w60">';
			str += '<span class="vf_edit gray">编辑</span>';
			str += '</div>';
		}else{
			str += '<div class="verifier_list cursorpt w60">';
			str += '<span class="vf_edit">编辑</span>';
			str += '</div>';
		}
		str += '<div class="verifier_list vf_remove cursorpt">';
		str += '<span class="vf_remove">删除</span>';
		str += '</div>';
		str += '</div>';
		str += '</li>';   
		return str;
	}
	function checked_num(){
		var num = 0;
		$(".verifier").each(function(){
			//if($(this).hasClass("on_check")){
			num++;
			//}
		});
		if(num>0){
			$(".vf_selected").removeClass("dis_no");
			$(".choice_vfnum").html(num+"位");
		}else{
			$(".vf_selected").addClass("dis_no");
		}
		
		console.log($("#insuranceInputIds").val())
	}
	
	//获取被选中的，需要参加保险的人数
	function get_checked_num(){
		var num = 0;
		$(".verifier").each(function(){
			//if($(this).hasClass("on_check")){
			num++;
			//}
		});
		return num;
	}
	
	/***拼接和删除入住人信息的id集合，传递后台用于保险人列表***/
	/**
	 * 被保险人，入住人的勾选与否对应逻辑
	 * 添加入住人，删除入住人，修改入住人信息，以及手动勾选，均会触发事件**/
	function addInsuranceInputIds_new(id) {
	    var ids = $("#insuranceInputIds").val();
	    //避免出现重复的id,不需要做什么多余的操作
	    if(ids.indexOf(id+"")>=0){
	    	return ids;
	    }
	    if (ids == "") {
	        ids += id;
	    } else {
	        ids += "," + id;
	    }
	    $("#insuranceInputIds").val(ids);
	    return ids;
	}
	
	function removeInsuranceInputIds_new(id) {
	    var ids = $("#insuranceInputIds").val();
	    var idsarry = new Array();
	    if(ids.indexOf(",")>=0){
	    	idsarry = ids.split(",");
	    }else{
	    	idsarry.push(ids);
	    }
	    var newids = "";
	    for (var i = 0; i < idsarry.length; i++) {
	        if (id == idsarry[i]) continue;
	        if (newids == "") {
	            newids += "" + idsarry[i];
	        } else {
	            newids += "," + idsarry[i];
	        }
	    }
	    $("#insuranceInputIds").val(newids);
	    return newids;
	}
	
	whenPageInit();
	
	/**
	 * 当页面第一次加载的时候，判断是否有联系人，如果没有，那么显示一个输入框
	 */
	function whenPageInit(){
		var onumber = 0;
		$(".p_list .c_person").each(function(){
			onumber++;
		})
		if(onumber<1){
			$(".addvf_icon").addClass("gray");
			$(".optional").append(vf_form("","","","","","dis_no"));
		}
	}
	//email输入校验
	$("#emailcode").on("blur",function(){
		var emailcode = $(this).val();
		if(emailcode.length>0){
			$(".error_email").hide();
			var email_re = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			if(!email_re.test(emailcode)){
				$(".error_email").show();
			}
		}else{
			$(".error_email").show();
		}
	});
});

var showTip=function(tip,time){
	 if(!time||typeof(time)!='number'){
		 time=2
	 }
	 if(typeof(tip) != "undefined"&&tip!=''){
		 var context=$('body');
		 var tiparticle=$("#article_showTip");
		 if(typeof(tiparticle) != "undefined")
			 tiparticle.remove();
		 var html='<div id="article_showTip" class="tc-ar"><b>'+tip+'</b></div>';
		 context.append(html);
		 tiparticle=$("#article_showTip");
		 tiparticle.click(function(){
			 tiparticle.remove();
		 })
		 setTimeout(function(){
			 tiparticle.remove();
         },1000*time);
	 }
}

/**
 * 检查一下身份证类型的合法性
 */
function checkPapertype(papertype,value)
{
	if(papertype==idCardCode)
	{
		var checkFlag = new clsIDCard(value);
		return checkFlag.IsValid();
	}
	
	else if(papertype==passportCode)
	{
		return isPassport(value);
	}
	return true;
}
////////////////////////////////////////////
// 改变价格:remove,add
function setPrice(type) {

    //var peopleNum = $(".inspersonDetail").length; 保险人的个数，新版本中
	var peopleNum = get_checked_num();
    var dayNum = parseFloat($("#nights").text());    //共几晚
    var moneyunitYuan = parseFloat(payunitpriceYuan);  //保险的单价
    var insurancePriceShow = getInsurancePriceShow()   //新版本全免费
    var ordertotalPriceShow = (parseFloat($("#showtotalprice").text()) + parseFloat(insurancePriceShow)).toFixed(2);   //预定套数后面的房费价格+保险的价格=页面订单总金额
    //$("#insurancePriceShow").html(insurancePriceShow);    添加被保险人的位置的保险费用，已去掉
    /*if(insurancePriceShow&&insurancePriceShow!='0.00'){   去掉
		$("#insuranceprice").html("￥"+insurancePriceShow);
	}else{    
		$("#insuranceprice").html("免费");
	} */
    if(peopleNum>=1){            //这块本身有问题，没有这个tr_insurance，但是有一个tr_insruance,不确定
    	$('#tr_insurance').show();
	}else{
    	$('#tr_insurance').hide();
	}    

    var ordertotalprice = 0;  //订单总金额
    var onlineAmount = 0;    //支付到蚂蚁
    // 以分为单位，
    var insurancePrice = getInsurancePriceShow()*100;
    var onlinePayAmountShow = null;
    
    if (type != 'init') {
        if (type == 'add') {
            onlinePayAmountShow = (parseFloat($("#onlinePayAmountShow").text()) + parseFloat(dayNum * moneyunitYuan)).toFixed(2);
            ordertotalprice = parseInt($("#totalPrice").val()) + parseInt(dayNum * moneyunitYuan * 100);
            onlineAmount = parseInt($("#onlineAmount").val()) + parseInt(dayNum * moneyunitYuan * 100);
        } else {
            onlinePayAmountShow = (parseFloat($("#onlinePayAmountShow").text()) - parseFloat(dayNum * moneyunitYuan)).toFixed(2);
            ordertotalprice = parseInt($("#totalPrice").val()) - parseInt(dayNum * moneyunitYuan * 100);
            onlineAmount = parseInt($("#onlineAmount").val()) - parseInt(dayNum * moneyunitYuan * 100);
        }
    } else {
        onlinePayAmountShow = (parseFloat($("#onlinePayAmountShow").text()) + parseFloat(insurancePriceShow)).toFixed(2);
        ordertotalprice = parseInt($("#totalPrice").val()) + parseInt(insurancePrice);
        onlineAmount = parseInt($("#onlineAmount").val()) - parseInt(insurancePrice);
        //var insuranceInputIds = $("#insuranceInputIds").val();
        //if (peopleNum != insuranceInputIds.split(",").length) $("#insuranceInputIds").val("1");   //有疑问
        $(".ntd_div6").find("span").html($("#nights").text());
    }    
    // 重新初始化价格，给隐藏域赋值
    $("#peopleNum").html(peopleNum);
    $("#totalPrice").val(ordertotalprice);
    $("#onlineAmount").val(onlineAmount); 
   
    $("#rightInsurancePrice").html("免费");    //新版本总是免费
    setCuponPrice(type);
}

/**
 * 此方法用于获取保险的展示价格，华泰保险中，蚂蚁承保，因此展示价格均为0，此方法直接返回0
 * @returns
 */
function getInsurancePriceShow()
{
	 return 0.00;
}
//选择优惠券的时候对价格的影响  
function setCuponPrice(type) {
    var isRadio = false;
    var amountShow = 0;
    /**
    $("#coupon").find(":radio:checked").each(function() {
        amountShow = $(this).attr("amountShow");
        isRadio = true;
    });
    if (!isRadio) {
        $("#coupon").find(":checkbox:checked").each(

        function() {
            amountShow = (parseFloat(amountShow) + parseFloat($(this).attr("amountShow"))).toFixed(2);
        });
    }*/
    var couponval = $('.jianmq').attr('couponval');
    if(typeof(couponval)!='undefined'){
    	amountShow = couponval;
    } 
    var insurancePriceShow=getInsurancePriceShow();
    var ticketPriceShow = ticketManager.sumPrice/100  ; 

    var ordertotalPriceShow = (parseFloat($("#orderroomprice").val()) + parseFloat(insurancePriceShow)+parseFloat(ticketPriceShow)).toFixed(2);
    $("#actuallytotalprice").html(ordertotalPriceShow);
    
    var onlinePayAmountShow = (parseFloat($("#onlinePayAmount").val())  - parseFloat(amountShow)).toFixed(2);   
    if (onlinePayAmountShow < 0) {
        onlinePayAmountShow = '0.00';
        $("#promotionAmount").text('-' + (parseFloat($("#onlinePayAmount").val())).toFixed(2));
    } else {
        $("#promotionAmount").text('-' + amountShow);
    }  
    //押金金额
    var depositpriceshow = $("#depositprice").html();
    onlinePayAmountShow = (parseFloat(onlinePayAmountShow) + parseFloat(insurancePriceShow)+ parseFloat(ticketPriceShow)+ parseFloat(depositpriceshow)).toFixed(2);
    var showtotalprice2 = parseFloat($("#showtotalprice2").text().replace("￥",""));//房费
    //按条件隐藏发票信息
    showOrHideInvoiceDiv();
    if($("#isInvoice").val() == "yes"){
    	var invoice_tax_free = $("#invoice_tax_free").val();
    	if(invoice_tax_free == 1){
    		var invoicepostage = inoviceExpressFee;
        	$("#invoicepostage").text(invoicepostage);
        	onlinePayAmountShow = (parseFloat(onlinePayAmountShow) + parseFloat(invoicepostage)).toFixed(2);
    	}
    	else{
    		var invoiceTax  = ((showtotalprice2 - couponval) * inoviceTaxPoint).toFixed(2);
        	var invoicepostage = inoviceExpressFee;
        	$("#invoiceTax").text(invoiceTax);
        	$("#invoicepostage").text(invoicepostage);
        	onlinePayAmountShow = (parseFloat(onlinePayAmountShow) + parseFloat(invoiceTax) + parseFloat(invoicepostage)).toFixed(2);
    	}
    	
    }
    $("#onlinePayAmountShow").html(onlinePayAmountShow);
    $(".invoice_tip").hide();
}
//选择是否开发票时对价格的变化
function setInvoicePrice(flag){
	var onlinePayAmountShow = parseFloat($("#onlinePayAmountShow").text());//线上支付钱
	var showtotalprice2 = parseFloat($("#showtotalprice2").text().replace("￥",""));//房费
	var couponval = parseFloat($(".jianmq").attr("couponval"));//优惠券的钱
	var invoice_tax_free = $("#invoice_tax_free").val();
	if(invoice_tax_free == 1){
		var invoicepostage = inoviceExpressFee;
		if("yes" == flag){
			$("#invoicepostage").text(invoicepostage);
			$(".invoicepostage").show();
			$("#onlinePayAmountShow").text((onlinePayAmountShow + parseFloat(invoicepostage)).toFixed(2));
			$(".invoice_tip").show();
		}else{
			$("#invoicepostage").text(0);
			$(".invoicepostage").hide();
			$("#onlinePayAmountShow").text((parseFloat(onlinePayAmountShow) - parseFloat(invoicepostage)).toFixed(2));
			$(".invoice_tip").hide();
		}
	}
	else{
		//发票的税前 = （房费 - 优惠卷的钱）X 6%
		var invoiceTax  = ((showtotalprice2 - couponval) * inoviceTaxPoint).toFixed(2);
		var invoicepostage = inoviceExpressFee;
		if("yes" == flag){
			$("#invoiceTax").text(invoiceTax);
			$(".invoiceTax").show();
			$("#invoicepostage").text(invoicepostage);
			$(".invoicepostage").show();
			$("#onlinePayAmountShow").text((onlinePayAmountShow + parseFloat(invoiceTax) + parseFloat(invoicepostage)).toFixed(2));
			$(".invoice_tip").show();
		}else{
			$("#invoiceTax").text(0);
			$(".invoiceTax").hide();
			$("#invoicepostage").text(0);
			$(".invoicepostage").hide();
			$("#onlinePayAmountShow").text((parseFloat(onlinePayAmountShow) - parseFloat(invoiceTax) - parseFloat(invoicepostage)).toFixed(2));
			$(".invoice_tip").hide();
		}
	}
	
	$("#isInvoice").val(flag);
}
//按条件隐藏发票信息
function showOrHideInvoiceDiv(){
	var showtotalprice2 = parseFloat($("#showtotalprice2").text().replace("￥",""));//房费
	var couponval = parseFloat($(".jianmq").attr("couponval"));//优惠券的钱
	var invoice_tax_free = $("#invoice_tax_free").val();
	if(showtotalprice2 - couponval <= 0){
		if(invoice_tax_free == 0){
			$("#invoiceTax").text(0);
			$(".invoiceTax").hide();
		}
		$("#invoicepostage").text(0);
		$(".invoicepostage").hide();
		$("#orderinvoiceDiv").hide();
		$("#isInvoice").val("no");
		$(".invoice_no").children().get(0).checked = true;
	}else{
		$("#orderinvoiceDiv").show();
	}
}

///////////////////////保险日期/////
function initInsuranceDate(){
	var checkin = '1910-01-01';
	//var checkout =  getYesterday($('#checkinday').val());
	var checkout =  new Date().format("yyyy-MM-dd");
	birthdayCalendar(checkin,checkout);	
}
var oCalBirthday;
function birthdayCalendar(fcheckin,fcheckout){
	try{
	  	YUI({}).use('trip-calendar', function(Y) {
				/**
				 * 弹出式日历实例
				 * 将日历与指定的触发元素绑定
				 * 日历可根据浏览器窗口大小，自动调整显示位置
				 */
	  		oCalBirthday = new Y.TripCalendar({
		  		//绑定日历的节点，支持选择器模式，可批量设置（必选）
					triggerNode: '.birthday',					
					minDate: fcheckin,
					maxDate: fcheckout,
					count : '1',
					isSelect: true
				});
	
	  		oCalBirthday.on('dateclick', function(e) {
					//this.getCurrentNode().setAttribute('data-date', e.date);
				});
	
				//显示日历时自定义事件
	  		oCalBirthday.on('show', function() {					
							
				});
	
				//解决chrome的foucs事件bug
				Y.on('click', function(e) {e.currentTarget.focus();}, 'button, .J_Link');
			}); 
	}catch(e){
		console.log(e);
	}
}
function getYesterday(datetime)
{		
	var today=new Date(datetime); //月份为0-11
	var yesterday_milliseconds=today.getTime()-1000*60*60*24;
	var yesterday=new Date();
	yesterday.setTime(yesterday_milliseconds);

	var strYear=yesterday.getFullYear();
	var strDay=yesterday.getDate();
	var strMonth=yesterday.getMonth()+1;
	if(strMonth<10)
	{
	  strMonth="0"+strMonth;
	}
	var strYesterday=strYear+"-"+strMonth+"-"+strDay;
	return strYesterday;
}
//判断数组内是否存在
function contains(arr, obj) {
    var i = arr.length;
    while (i--) {
        if (arr[i] === obj) {
            return true;
        }
    }
    return false;
}
Date.prototype.format = function(format) {
    var o = {
        "M+": this.getMonth() + 1,
        //month
        "d+": this.getDate(),
        //day
        "h+": this.getHours(),
        //hour
        "m+": this.getMinutes(),
        //minute
        "s+": this.getSeconds(),
        //second
        "q+": Math.floor((this.getMonth() + 3) / 3),
        //quarter
        "S": this.getMilliseconds() //millisecond
    }

    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }

    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
 }



/**
 * 提交订单时获得保险人的数据
 * @returns
 */
function getInsuranceJson_new()
{
	var insuranceJson = '';
	$(".verifier").each(function(){
		//if($(this).hasClass("on_check")){
		var contactid = $(this).attr("contactid")==undefined?0:$(this).attr("contactid");
		var realname =$(this).find(".vf_name").html();
		var state = $(this).find(".yanz_status").attr("yanstate");
		var stateDesc =$(this).find(".yanz_status").html();
		var idCard = "";
		var idtype = "";
		var country = "中国";
		var birthday = "";
		var sex = "";
		var nation = "";
		if($(this).find(".huzhao").html()!=null){  //护照
			idtype = 414;
			idCard =$(this).find(".hz_num").html();
			country = $(this).find(".country").html();
			birthday = $(this).find(".vf_birth").html();
			sex = $(this).find(".sex").html();
		}else if($(this).find(".vf_ID").html()!=null){   //身份证
			idtype = 111;
			idCard =$(this).find(".IDcord").html();
		}
		insuranceJson += '{realname:"' + realname+ '",state:"' + state + '",stateDesc:"' + stateDesc + '",idtype:"' + idtype+ '",idcard:"' + idCard + '",sex:"' + sex + '",birthday:"'+ birthday + '",id:"'+contactid+'",country:"'+country+'",nation:"'+nation+'"},';
		
		//}
	});
	insuranceJson = '['+ insuranceJson.substring(0, insuranceJson.length - 1) + ']';
	return insuranceJson;
}

/**
 * 为了给order.js使用
 * @returns {Number}
 */
function get_checked_num_2(){
	var num = 0;
	$(".verifier").each(function(){
		//if($(this).hasClass("on_check")){
		num++;
		//}
	});
	return num;
}

function get_checked_num(){
	var num = 0;
	$(".verifier").each(function(){
		//if($(this).hasClass("on_check")){
		num++;
		//}
	});
	return num;
}

/**
 * 未成年人数
 * @returns {Number}
 */
function get_nonage_num(){
	var num = 0;
	$(".verifier").each(function(){
		//if($(this).hasClass("on_check")){
		var age =$(this).find(".vf_age").html();
		if(age<16){
			num++;
		}
		//}
	});
	return num;
}



/**
 * 浏览器的回退按钮触发事件
 */
/*$(function(){
	console.log(history.length);
	window.history.pushState('forward', null, '#');
    window.history.forward(1);
    console.log(history.length);
    window.addEventListener("popstate", function(e) {
    	isClickSubmit = false;
    	if($("#iseditperson").val()=='1'){
    		window.history.pushState('forward', null, '#');
    		window.history.forward(1);
    		console.log(history.length);
    		$("#layer_rz_notsave").show();    //根据自己的需求实现自己的功能
    	}else{
    		history.go(-2);
    	}
	}, false);
});
*/
$(function(){
	var roomId = location.href.substring(location.href.indexOf("-")+1,location.href.indexOf("_"));
	var urlPath = location.href.substring(0,location.href.indexOf("/",10)+1);
//	window.history.pushState({ title: '房源详情' }, null, '#');
    console.log(history.length);
    window.addEventListener("popstate", function(e) {
    	isClickSubmit = false;
    	if($("#iseditperson").val()=='1'){
//    		window.history.pushState({ title: '房源详情' }, null, '#');
    		$("#layer_rz_notsave").show();    //根据自己的需求实现自己的功能
    	}else{
    		window.location.href = urlPath+"room/"+roomId;
    	}
	}, false);
});







