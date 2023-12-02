$(document).ready(function(){
	$('.form-control').on('focus',function(){
		$("#loginTS").css('display','none');
	});
/*	function tiaoz(sj){
		 if(sj != 0) {  
             setTimeout(function() {  
                 $('#sjj').html(--sj+'秒后将自动跳转到后台管理页面');  
                 tiaoz(sj);  
             }, 1000);  
         }else{
        	 window.location.href =ctx+'/index2'; 
         }  
	}*/
	//校验用户
	$('#login').on('click',function(){
		/*window.wxc.xcConfirm("登录成功", window.wxc.xcConfirm.typeEnum.success);
		return false;*/
		var userName=$("#username").val();
		if(userName==null||userName==undefined||userName.trim==''){
			alert('请填写用户名');
		}
		var password=$("#password").val();
		if(password==null||password==undefined||password.trim==''){
			alert('请填写密码');
		}
		$.ajax({
			type: 'POST',
			url: ctx+'/login/checkLogin',
			data:{'userName':userName,'password':password},
			success:function(data){
				if(data.RetCode=='1'){
					if(data.ifAdmin=='Y'){
						/*$("#tsAdmin").click();
						var sj=$("#sjj").html().charAt(0);
						tiaoz(sj);*/
						window.location.href =ctx+'/index2'; 
					}else{
						window.location.href =ctx+'/index';
					}
				}else{
					$("#loginTS").css('display','');
					$("#username").val('');
					$("#password").val('');
				}
			},
			error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
		        	console.log(XMLHttpRequest);
		        	console.log(textStatus);
		        	console.log(errorThrown);
		    },
		});
	});
})





