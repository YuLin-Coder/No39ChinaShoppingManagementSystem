(function(){
	yjgpwd = {
			init:function(){
				var self = this;
				//事件绑定
				self.page();
				self.event();			
			},
			page:function(){
				$(".xingming").css('display','');
				$(".mibao").css('display','none');
				$(".mima").css('display','none');
			},
			/**
			 * 事件绑定
			 */
			event:function(){
				$(".form1").on('click',function(){
					var userName=$("#userName").val();
					if($.trim(userName)==''||userName==undefined){
						alert("请填写用户名");
						return false;
					}
					$.ajax({
						type: 'POST',
						url: ctx+'/findpwd/checkUser',
						data:{"userName":userName},
						success:function(data){
							if(data.RetCode=='1'&&data.RetData!=null){
								if(data.Mibao!=null){
									$("#uquestion").val(data.Mibao.uquestion);
									$("#daAntrue").val(data.Mibao.uanswer);
									$("#uID").val(data.RetData.userId);
									$(".xingming").css('display','none');
									$(".mibao").css('display','');
									$(".mima").css('display','none');
								}else{
									alert("无法找回,请联系管理员");
								}
							}else{
								alert("没有该用户");
							}
						},
						error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
					        	console.log(XMLHttpRequest);
					        	console.log(textStatus);
					        	console.log(errorThrown);
					    },
					});	
				});
				$(".form2").on('click',function(){
					var uanswer=$("#daAn1").val();
					var uanswer2=$("#daAntrue").val();
					if(uanswer==uanswer2){
						$(".xingming").css('display','none');
						$(".mibao").css('display','none');
						$(".mima").css('display','');
					}else{
						alert("回答错误，请重新输入！");
					}
					
				});
				$(".form3").on('click',function(){
					var password=$("#passwordz").val();
					var userId=$("#uID").val();
					$.ajax({
						type: 'POST',
						url: ctx+'/findpwd/updateUser',
						data:{"password":password,"userId":userId},
						async:false,
						success:function(data){
							if(data.RetCode=='1'){
								alert("修改成功");
								 window.location.href =ctx+'/login';
							}else{
								alert("发生异常");
							}
						},
						error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
					        	console.log(XMLHttpRequest);
					        	console.log(textStatus);
					        	console.log(errorThrown);
					    },
					});	
				})
			},
	};
})();
$(function(){
	yjgpwd.init();
});




