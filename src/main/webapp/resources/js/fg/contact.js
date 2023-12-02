(function(){
	yjgMM = {
			isHideMenu:true,
			init:function(){
				var self = this;
				//事件绑定
				self.event();			
			},
			/**
			 * 事件绑定
			 */
			event:function(){
				$("#confirmM").on('click',function(){
					var name=$("#mName").val();
					var email=$("#mEmail").val();
					var phone=$("#mPhone").val();
					var message=$("#mDetail").val();
					if($.trim(name)==''||name==undefined||$.trim(email)==''||email==undefined||$.trim(phone)==''||phone==undefined||$.trim(message)==''||message==undefined){
						$("#contactTX").css('display','');
						return false;
					}
					$.ajax({
						type: 'POST',
						url: ctx+'/contact/addContact',
						data:{"mName":name,"mEmail":email,"mPhone":phone,"mDetail":message},
						async:false,
						success:function(data){
							if(data.RetCode=='1'){
								$("#zzz").click();
							}else{
								window.location.href =ctx+'/contact';
							}
						},
						error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
					        	console.log(XMLHttpRequest);
					        	console.log(textStatus);
					        	console.log(errorThrown);
					    },
					});	
				});
				$(".form-control").on('focus',function(){
					$("#contactTX").css('display','none');
				});
			},
	};
})();
$(function(){
	yjgMM.init();
});
