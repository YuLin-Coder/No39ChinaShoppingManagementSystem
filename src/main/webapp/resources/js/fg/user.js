(function(){
	yjgUU = {
		init:function(){
			var self = this;
			//绑定事件
			self.event();
			//添加图片
			self.addImg();
		},
		event:function(){
			$('#ff5').bootstrapValidator({
				feedbackIcons: {
						invalidinvalidvalid: 'glyphicon glyphicon-ok',
						invalid: 'glyphicon glyphicon-remove',
						validating: 'glyphicon glyphicon-refresh'
				},
				excluded:[":disabled"],
				fields: {
					passwordold: {
				    	validators: {
				        	notEmpty: {
				           		message: '旧密码不能为空'
				       		},
				        	remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input 	name值，获得一个json数据。例表示正确：{"valid",true}  
				       			url: ctx+'/user/checkPassword',//验证地址
				        		message: '密码错误',//提示消息
				        	//	delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
				        		type: 'POST'//请求方式
				    		}
						}
					},
					passwordnew: {
				    	validators: {
				        	notEmpty: {
				            	message: '新密码不能为空'
				        	}
				    	}
					},
					passwordnew2: {
				    	validators: {
				        	notEmpty: {
				            	message: '密码不能为空'
				        	},
				        	identical: {
								field: 'passwordnew',
								message: '两次密码不一样'
							}
				    	}
					}
				}
			});
			$("#passwordQD").on("click", function(){
			     //获取表单对象
			    var bootstrapValidator = $("#ff5").data('bootstrapValidator');
			        //手动触发验证
			        bootstrapValidator.validate();
			        if(bootstrapValidator.isValid()){
			        	var psaaword=$("#passwordnew").val();
			        	$.ajax({
							type: 'POST',
							url: ctx+'/user/updateUser2',
							data:{"psaaword":psaaword},
							async:false,
							success:function(data){
								alert("修改成功！");
								window.location.href =ctx+'/login';
							},
							error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
						        	console.log(XMLHttpRequest);
						        	console.log(textStatus);
						        	console.log(errorThrown);
						    },
						})
			        }
			});
			$("#myCollect").on('click',function(){
				$.ajax({
					type: 'POST',
					url: ctx+'/user/getCollect',
					async:false,
					success:function(data){
						var data = eval('(' + data + ')'); //字符串转换成json
						var list=data.RetData;
						$("#exictSC").empty();
						if(list!=null&&list.length!=0){
							$("#noSC").css('display','none');
							$("#exictSC").css('display','');
							var html='';
							for(var a=0;a<list.length;a++){
								if(list[a].goods.ifZK=='Y'){
									html+='<div class="row" id="collect'+list[a].collectId+'">\
										<div class="product well">\
											<div class="col-md-3">\
												<div class="image">\
													<img src="/imagesZZ/'+list[a].goods.goodsUrl+'" />\
												</div>\
											</div>\
											<div class="col-md-9">\
												<div class="caption">\
													<div class="name"><h3><a href="'+ctx+'/product?goodsId='+list[a].goods.goodsId+'">'+list[a].goods.goodsName+'</a></h3></div>\
													<div class="info">\
														<ul>\
															<li>来源: '+list[a].goods.goodsFrom+'</li>\
															<li>剩余数量: '+list[a].goods.goodsNum+'</li>\
														</ul>\
													</div>\
													<div class="price" id="zkk">$'+list[a].goods.goodsPriceZ+'<span>$'+list[a].goods.goodsPrice+'</span></div>\
													<hr>\
													<input type="hidden" class="collectIdz" value="'+list[a].collectId+'">\
													<input type="hidden" class="goodsIdZZZZZ" value="'+list[a].goods.goodsId+'">\
													<span class="btn btn-default pull-right addCartZZZ">加入购物车</span>\
													<span class="btn btn-default pull-right removeGoods">移除</span>\
												</div>\
											</div>\
											<div class="clear"></div>\
										</div>\
								 </div>';
								}else{
									html+='<div class="row" id="collect'+list[a].collectId+'">\
										<div class="product well">\
											<div class="col-md-3">\
												<div class="image">\
													<img src="/imagesZZ/'+list[a].goods.goodsUrl+'" />\
												</div>\
											</div>\
											<div class="col-md-9">\
												<div class="caption">\
													<div class="name"><h3><a href="'+ctx+'/product?goodsId='+list[a].goods.goodsId+'">'+list[a].goods.goodsName+'</a></h3></div>\
													<div class="info">\
														<ul>\
															<li>来源:'+list[a].goods.goodsFrom+'</li>\
															<li>剩余数量: '+list[a].goods.goodsNum+'</li>\
														</ul>\
													</div>\
													<div class="price" id="nzkk">$'+list[a].goods.goodsPrice+'</div>\
													<hr>\
													<input type="hidden" class="collectIdz" value="'+list[a].collectId+'">\
													<input type="hidden" class="goodsIdZZZZZ" value="'+list[a].goods.goodsId+'">\
													<span  class="btn btn-default pull-right addCartZZZ">加入购物车</span>\
													<span  class="btn btn-default pull-right removeGoods">移除</span>\
												</div>\
											</div>\
											<div class="clear"></div>\
										</div>\
								 </div>';
								}	
							}
							$("#exictSC").append(html);
						}else{
							$("#noSC").css('display','');
							$("#exictSC").css('display','none');
						}
						
					},
					error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
				        	console.log(XMLHttpRequest);
				        	console.log(textStatus);
				        	console.log(errorThrown);
				    },
				})
				//移除收藏
				$(".removeGoods").on('click',function(){
					var self =$(this);
					var collectId=self.siblings(".collectIdz").val();
					
					$.ajax({
						type: 'POST',
						url: ctx+'/user/remCollect',
						data:{"collectId":collectId},
						success:function(data){
							if(data.RetCode=='1'){
								$("#collect"+collectId).slideUp(800,function(){
									$("#collect"+collectId).remove();
								});
							}else{
								alert("错误！");
							}
						},
						error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
					        	console.log(XMLHttpRequest);
					        	console.log(textStatus);
					        	console.log(errorThrown);
					    },
					})
				});
				$(".addCartZZZ").on('click',function(){
					var goodsId=$(this).siblings(".goodsIdZZZZZ").val();
					$.ajax({
						type: 'POST',
						data:{"goodsId":goodsId},
						url: ctx+'/cart/addCart',
						success:function(data){
							if(data.RetCode=='1'){
								alert("加入购物车成功");
								//$(this).siblings(".removeGoods").click(); //==========
							}else{
								alert("错误");
							}
						},
						error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
					        	console.log(XMLHttpRequest);
					        	console.log(textStatus);
					        	console.log(errorThrown);
					    },
					})
				
				});
			});
			$("#dzsq").on('click',function(){
				$.ajax({
					type: 'POST',
					url: ctx+'/user/getSeller',
					async:false,
					success:function(data){
						var seller=data.RetData;
						if(seller==null||seller==undefined){
							//未申请店主
							$("#SQ").css('display','');
							$("#SH").css('display','none');
							$("#HW").css('display','none');
							$("#HWcaoz").css('display','none');
						}else{
							if(seller.tStatus=='10'){
								//在审核
								$("#SQ").css('display','none');
								$("#SH").css('display','');
								$("#HW").css('display','none');
								$("#HWcaoz").css('display','none');
							}else{
								//审核通过
								$("#SQ").css('display','none');
								$("#SH").css('display','none');
								$("#HWcaoz").css('display','none');
								$("#HW").css('display','');
								$.ajax({
									type: 'POST',
									url: ctx+'/user/getProduct',
									async:false,
									success:function(data){
										var list=data.RetData;
										if(list!=null&&list.length!=0){
											$("#noSP").css('display','none');
											$("#exictSP").css('display','');
											var html='';
											$("#splist").empty();
											for(var a=0;a<list.length;a++){
												if(list[a].ifZK=='Y'){
													html+='<tr>\
															<td>'+list[a].goodsName+'</td>\
															<td>'+list[a].goodsPrice+'</td>\
															<td>'+list[a].goodsNum+'</td>\
															<td>Y</td>\
															<td>'+list[a].goodsPriceZ+'</td>\
															<td><input class="goodsQQ" type="hidden" value="'+list[a].goodsId+'"><a class="glyphicon glyphicon-edit spUpdate"></a>&nbsp;&nbsp;<a class="glyphicon glyphicon-remove spRemove"></a></td>\
														</tr>';
												}else{
													html+='<tr>\
															<td>'+list[a].goodsName+'</td>\
															<td>'+list[a].goodsPrice+'</td>\
															<td>'+list[a].goodsNum+'</td>\
															<td>N</td>\
															<td>0</td>\
															<td><input class="goodsQQ" type="hidden" value="'+list[a].goodsId+'"><a class="glyphicon glyphicon-edit spUpdate"></a>&nbsp;&nbsp;<a class="glyphicon glyphicon-remove spRemove"></a></td>\
														</tr>';
												}
											}
											$("#splist").append(html);
										}else{
											$("#noSP").css('display','');
											$("#exictSP").css('display','none');
										}
									},
									error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
								        	console.log(XMLHttpRequest);
								        	console.log(textStatus);
								        	console.log(errorThrown);
								    },
								})
							}
						} 
					},
					error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
				        	console.log(XMLHttpRequest);
				        	console.log(textStatus);
				        	console.log(errorThrown);
				    },
				})
				$(".spUpdate").on('click',function(){
					var self = $(this);
					var goodsId=self.siblings(".goodsQQ").val();
					$("#SQ").css('display','none');
					$("#SH").css('display','none');
					$("#HW").css('display','none');
					$("#HWcaoz").css('display','');
					$.ajax({
						type: 'POST',
						async:false,
						url: ctx+'/index/getTypeD',
						success:function(data){
							var data = eval('(' + data + ')'); //字符串转换成json
							console.log(data.RetCode);
							if(data.RetCode=='1'){
								var name=data.RetData;
								$("#pzlist").empty();
								var html='';
								for(var z=0;z<name.length;z++){
									html+='<option value='+name[z].typeDid+'>'+name[z].name+'</option>';
								}
								$("#pzlist").append(html);
							}else{
								alert("错误！");
							}
						},
						error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
					        	console.log(XMLHttpRequest);
					        	console.log(textStatus);
					        	console.log(errorThrown);
					    },
					})
					$.ajax({
						type: 'POST',
						url: ctx+'/user/seletOneGoods',
						async:false,
						data:{"goodsId":goodsId},
						success:function(data){
							if(data.RetCode=='1'){
								var goods=data.RetData;
							
								$("#pzlist option[value="+goods.typeDid+"]").attr('selected','selected');
								$("#goodsName").val(goods.goodsName);
								$("#goodsPrice").val(goods.goodsPrice);
								$("#goodsNum").val(goods.goodsNum);
								if(goods.ifZK=='Y'){
									//$(".zkzz[value='Y']").click();
									$("#goodsPriceZ").val(goods.goodsPriceZ);
								}else{
									//$(".zkzz[value='N']").click();
								}
								$("#goodsDesc").val(goods.goodsDesc);
								var showImg = "<div class='g-showImg'>"+
		 										"<i class='u-close' style='display:none;'></i>"+
		 											"<img src='/imagesZZ/"+goods.goodsUrl+"'/>"+
		 												"</div>";
								$("#tu1").find('.g-showImg').css('display','none');
								$("#tu1").find('.default').css('display','none');
								$("#tu1").append(showImg);
								var showImg = "<div class='g-showImg'>"+
									"<i class='u-close' style='display:none;'></i>"+
										"<img src='/imagesZZ/"+goods.goodsUrl2+"'/>"+
											"</div>";
								$("#tu2").find('.g-showImg').css('display','none');
								$("#tu2").find('.default').css('display','none');
								$("#tu2").append(showImg);
								var showImg = "<div class='g-showImg'>"+
									"<i class='u-close' style='display:none;'></i>"+
										"<img src='/imagesZZ/"+goods.goodsUrl3+"'/>"+
											"</div>";
								$("#tu3").find('.g-showImg').css('display','none');
								$("#tu3").find('.default').css('display','none');
								$("#tu3").append(showImg);
								var showImg = "<div class='g-showImg'>"+
									"<i class='u-close' style='display:none;'></i>"+
										"<img src='/imagesZZ/"+goods.goodsUrl4+"'/>"+
											"</div>";
								$("#tu4").find('.g-showImg').css('display','none');
								$("#tu4").find('.default').css('display','none');
								$("#tu4").append(showImg);
								$("#goodsIdZZ").val(goods.goodsId);
							}else{
								alert("错误！");
							}
						},
						error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
					        	console.log(XMLHttpRequest);
					        	console.log(textStatus);
					        	console.log(errorThrown);
					    },
					})
				});
				$(".spRemove").on('click',function(){
					var self = $(this);
					var goodsId=self.siblings(".goodsQQ").val();
					$.ajax({
						type: 'POST',
						url: ctx+'/user/remGoods',
						data:{"goodsId":goodsId},
						success:function(data){
							if(data.RetCode=='1'){
								$("#dzsq").click();
							}else{
								alert("错误！");
							}
						},
						error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
					        	console.log(XMLHttpRequest);
					        	console.log(textStatus);
					        	console.log(errorThrown);
					    },
					})
				});
				
			});
			//陶瓷新增
			$("#spQD").on('click',function(){
				$("#goodsIdZZ").val("");
				$("#HW").css('display','none');
				/*$("#HWcaoz").slideDown(800,function(){
					$("#HWcaoz").css('display','');
				});*/
				 $("#HWcaoz input").attr("value","");
				$("#HWcaoz").css('display','');
				$.ajax({
					type: 'POST',
					async:false,
					url: ctx+'/index/getTypeD',
					success:function(data){
						var data = eval('(' + data + ')'); //字符串转换成json
						console.log(data.RetCode);
						if(data.RetCode=='1'){
							var name=data.RetData;
							$("#pzlist").empty();
							var html='';
							for(var z=0;z<name.length;z++){
								html+='<option value='+name[z].typeDid+'>'+name[z].name+'</option>';
							}
							$("#pzlist").append(html);
						}else{
							alert("错误！");
						}
					},
					error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
				        	console.log(XMLHttpRequest);
				        	console.log(textStatus);
				        	console.log(errorThrown);
				    },
				})
			});
			//联动效果
			$(".zkzz").on('click',function(){
				if($(this).val()=='Y'){
					$("#zkjg").css('display','');
				}else{
					$("#zkjg").css('display','none');
				}
			});
			$("#spQD11").on('click',function(){
				$("#ff4").ajaxSubmit({
					type:'POST',
					url:ctx+'/user/addGoods',
					success:function(data){
						if(data.RetCode=='1'){
							$("#dzsq").click();
						}else{
							alert("发生错误");
						}
					}
				})
			});
			$("#sellerQD").on('click',function(){
				$("#ff3").ajaxSubmit({
					type:'POST',
					url:ctx+'/user/addSeller',
					success:function(data){
						if(data.RetCode=='1'){
							$("#dzsq").click();
						}else{
							alert("发生错误");
						}
					}
				})
			});
			$("#upUser").on('click',function(){
				$("#ff2").ajaxSubmit({
					type:'POST',
					url:ctx+'/user/updateUser',
					success:function(data){
						if(data.RetCode=='1'){
							alert("修改成功");
							$("#xgUser").click();
						}else{
							alert("发生错误");
						}
					}
				})
			});
			//修改用户数据回显
			$("#xgUser").on('click',function(){
				$.ajax({
					type: 'POST',
					url: ctx+'/index/getSession',
					success:function(data){
						var data = eval('(' + data + ')'); //字符串转换成json
						var user=data.User;
						$("#userName").val(user.userName);
						if(user.gender=='M'){
							$("#gender1").attr('checked','true');
						}else{
							$("#gender2").attr('checked','true');
						}
						$("#phoneNum").val(user.phoneNum);
						$("#email").val(user.email);
						$("#addressD").val(user.addressD);
						var address=user.address.split('-');
						$("#province").find("option[value='"+address[0]+"']").attr("selected",'true'); 
						$("#province").trigger("change");
						$("#city").find("option[value='"+address[1]+"']").attr("selected",'true'); 
						$("#city").trigger("change");
						$("#district").find("option[value='"+address[2]+"']").attr("selected",'true'); 
					},
					error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
				        	console.log(XMLHttpRequest);
				        	console.log(textStatus);
				        	console.log(errorThrown);
				    },
				})	
			});
			$("#mmxg").on('click',function(){
				
			});
		},
		/**
		 * 添加图片
		 */
		addImg:function(){
		 	var self = this;
		 	var $body = $('body');

		 	$body.on('mouseover','.m-imgWrap .g-showImg',function(){
		 		$(this).find('.u-close').css('display','');
		 	})
		 	$body.on('mouseout','.m-imgWrap .g-showImg',function(){
		 		$(this).find('.u-close').css('display','none');
		 	})

		 	//点击删除
		 	$body.on('click','.m-imgWrap .g-showImg .u-close',function(){
		 		
		 		$(".u-ipt-file").val('');
				var $this = $(this),
					$memberAdd = $this.closest('.m-imgWrap');

				$memberAdd.find('.g-showImg').each(function(){
					$(this).closest('.g-showImg').remove();
				});
				//判断是否全部删除完成
				if ( $memberAdd.find('.g-showImg').length==0 ) {
					$memberAdd.find('.default').css('display','');
				}
				return false;
			});
		},
	};
})();

$(function(){
	yjgUU.init();
});
 


