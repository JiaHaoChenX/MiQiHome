//随机头像
var headimg = [ 'blue', 'green', 'pink', 'purple', 'purple' ];
function getRandomHeadimg() {
	var i = Math.ceil(Math.random() * 5)-1;
	return '/resourcesWeb/v201510/images/commom/headimg/'+headimg+'.png';
}
$(function(){
	$(".one-line .open").click(function(){
			$(this).parent().css("height","auto");		
			$(this).siblings(".close").css("display","block");	
			$(this).css("display","none");
		})
	$(".one-line .close").click(function(){
			$(this).parent().css("height","20px");
			$(this).siblings(".open").css("display","block");
			$(this).css("display","none");
		});
	
});


window.onload=function(){
	    if( !('placeholder' in document.createElement('input')) ){  
			   
			    $('input[placeholder],textarea[placeholder]').each(function(){   
			      var that = $(this),   
			      text= that.attr('placeholder');   
			      if(that.val()===""){   
			        that.val(text).addClass('placeholder');   
			      }   
			      that.focus(function(){   
			        if(that.val()===text){   
			          that.val("").removeClass('placeholder');   
			        }   
			      })   
			      .blur(function(){   
			        if(that.val()===""){   
			          that.val(text).addClass('placeholder');   
			        }   
			      })   
			      .closest('form').submit(function(){   
			        if(that.val() === text){   
			          that.val('');   
			        }   
			      });   
			    });   
			  } 
	}
