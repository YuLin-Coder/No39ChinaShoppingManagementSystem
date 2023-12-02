(function(){
	yjgPro = {
		init:function(){
			var self = this;

			//获取页面
			self.getPage();
			//绑定事件
			self.event();
		},

		getPage:function(){
			//详情
			$.ajax({
				type: 'POST',
				url: ctx+'/product/loadGoods',
				async:false,
				success:function(data){
					var name1=data.RetData2;
					var goods=data.RetData;
					var name2=goods.goodsName;
					$("#typeNamez").html(name1);
					$("#typeNamez").attr('href',ctx+'/category?typeDid='+data.RetData3+'&name='+name1);
					$("#goodsNamez").html(name2);
					$(".goodsUrl").attr('src','/imagesZZ/'+goods.goodsUrl);
					$(".goodsUrl0").attr('src','/imagesZZ/'+goods.goodsUrl);
					$(".goodsUrl1").attr('src','/imagesZZ/'+goods.goodsUrl2);
					$(".goodsUrl2").attr('src','/imagesZZ/'+goods.goodsUrl3);
					$(".goodsUrl3").attr('src','/imagesZZ/'+goods.goodsUrl4);
					$("#goodsName").html(name2);
					$("#goodsFrom").html(goods.goodsFrom);
					$("#goodsType").html(name1);
					$("#goodsCreatT").html(goods.createDate);
					$("#goodsDesc").html(goods.goodsDesc);
					$(".goodsIdzzz").val(goods.goodsId);
					if(goods.ifZK=='Y'){
						var z='$'+goods.goodsPriceZ+'<span>$'+goods.goodsPrice+'</span>';
						$("#goodsPrice").html(z);
					}else{
						var z='$'+goods.goodsPrice
						$("#goodsPrice").html(z);
					}
					$.ajax({
						type: 'POST',
						url: ctx+'/product/goodsMessageS',
						async:false,
						success:function(data){
						//	var data = eval('(' + data + ')'); //字符串转换成json
							var list=data.RetData;
							if(list.length==0){
								$("#noMessage").css('display','');
								$("#messageZZ").css('display','none');
							}else{
								$("#noMessage").css('display','none');
								$("#messageZZ").css('display','');
								var html='';
								$("#messageZZ").empty();
								$.each(list, function (i, item) { 
				            		if(i==0){
				            				 html+='<div>\
				            							<span>用户：'+item.userName+'</span>\
				            							<span style="margin-left:80px;">满意度：'+item.manyd+'星</span>\
				            						  	<div >\
															评价：'+item.goodsMDetail+'\
				            							</div>\
				            						</div>';
						            		$("#messageZZ").append(html);
				            		}else{
				            				html+='<div style="margin-top:20px;">\
														<span>用户：'+item.userName+'</span>\
														<span style="margin-left:80px;">满意度：'+item.manyd+'星</span>\
														<div>\
															评价：'+item.goodsMDetail+'\
														</div>\
													  </div>';
						            		$("#messageZZ").append(html);
				            		}	
			            	    });
							}
						},
						error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
					        	console.log(XMLHttpRequest);
					        	console.log(textStatus);
					        	console.log(errorThrown);
					    },
					})
					
				},
				error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
			        	console.log(XMLHttpRequest);
			        	console.log(textStatus);
			        	console.log(errorThrown);
			    },
			})	
			//相似
			$.ajax({
				type: 'POST',
				url: ctx+'/product/xsGoods',
				async:false,
				success:function(data){
					$("#xsProducts").empty();
					var list=data.RetData;
					if(list!=null&&list.length!=0){
						$("#noxs").css('display','none');
						var html='';
						for(var a=0;a<list.length;a++){
							if(list[a].ifZK=='Y'){
								html+='<div class="col-lg-3 col-md-3 col-xs-12">\
									<div class="product">\
										<div class="image"><a href="'+ctx+'/product?goodsId='+list[a].goodsId+'"><img src="/imagesZZ/'+list[a].goodsUrl+'" /></a></div>\
										<div class="buttons">\
											<div class="btn cart" ><span class="glyphicon glyphicon-shopping-cart"></span></div>\
											<div class="btn wishlist" ><span class="glyphicon glyphicon-heart"></span></div>\
											<div class="btn compare" ><span class="glyphicon glyphicon-transfer"></span></div>\
										</div>\
										<div class="caption">\
											<div class="name"><h3><a href="'+ctx+'/product?goodsId='+list[a].goodsId+'">'+list[a].goodsName+'</a></h3></div>\
											<div class="price">$'+list[a].goodsPriceZ+'<span>$'+list[a].goodsPrice+'</span></div>\
										</div>\
									</div>\
								</div>';
							}else{
								html+='<div class="col-lg-3 col-md-3 col-xs-12">\
									<div class="product">\
										<div class="image"><a href="'+ctx+'/product?goodsId='+list[a].goodsId+'"><img src="/imagesZZ/'+list[a].goodsUrl+'" /></a></div>\
										<div class="buttons">\
											<div class="btn cart" ><span class="glyphicon glyphicon-shopping-cart"></span></div>\
											<div class="btn wishlist" ><span class="glyphicon glyphicon-heart"></span></div>\
											<div class="btn compare" ><span class="glyphicon glyphicon-transfer"></span></div>\
										</div>\
										<div class="caption">\
											<div class="name"><h3><a href="'+ctx+'/product?goodsId='+list[a].goodsId+'">'+list[a].goodsName+'</a></h3></div>\
											<div class="price">$'+list[a].goodsPrice+'</div>\
										</div>\
									</div>\
								</div>';
							}
							if(a==3){
								break;
							}
						}
						$("#xsProducts").append(html);
					}else{
						$("#noxs").css('display','');
					}
				},
				error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
			        	console.log(XMLHttpRequest);
			        	console.log(textStatus);
			        	console.log(errorThrown);
			    },
			})
		},
		event:function(){
			$('li img').on('click',function(){
				var src = $(this).attr('src');
				var img = '<img src="' + src + '" class="img-responsive"><div class="glyphicon glyphicon-remove closePP"></div></img>';
				
				//start of new code new code
				var index = $(this).parent('li').index();   
				
				var html = '';
				html += img;                
				html += '<div style="height:25px;clear:both;display:block;">';
				html += '<a class="controls next" href="'+ (index+1) + '"> <span class="glyphicon glyphicon-chevron-right"></span></a>';
				html += '<a class="controls previous" href="' + (index) + '"><span class="glyphicon glyphicon-chevron-left"></span></a>';
				html += '</div>';

				$('#myModal').modal();
				$('#myModal').on('shown.bs.modal', function(){
					$('#myModal .modal-body').html(html);
					//new code
					$('a.controls').trigger('click');
				})
				$('#myModal').on('hidden.bs.modal', function(){
					$('#myModal .modal-body').html('');
				});	
		   });	
			//左右切换
			$(document).on('click', 'a.controls', function(){
				var index = $(this).attr('href');
				var src = $('ul.row li:nth-child('+ index +') img').attr('src');             
				
				$('.modal-body img').attr('src', src);
				
				var newPrevIndex = parseInt(index) - 1; 
				var newNextIndex = parseInt(newPrevIndex) + 2; 
				
				if($(this).hasClass('previous')){               
					$(this).attr('href', newPrevIndex); 
					$('a.next').attr('href', newNextIndex);
				}else{
					$(this).attr('href', newNextIndex); 
					$('a.previous').attr('href', newPrevIndex);
				}
				
				var total = $('ul.row li').length + 1; 
				//hide next button
				if(total === newNextIndex){
					$('a.next').hide();
				}else{
					$('a.next').show()
				}            
				//hide previous button
				if(newPrevIndex === 1){
					$('a.previous').hide();
				}else{
					$('a.previous').show()
				}
				
				
				return false;
			});
			//点击叉关闭
			$(document).on('click', '.closePP', function(){
				$('#myModal').trigger('click');

			});
			
			//切换
			$(".nav-tabs a").click(function(){
				$(this).tab('show');
			});
			$('.nav-tabs a').on('shown.bs.tab', function(event){
				var x = $(event.target).text();         // active tab
				var y = $(event.relatedTarget).text();  // previous tab
				$(".act span").text(x);
				$(".prev span").text(y);
			});
			
			$(".rating").on('click','span',function(){
				var $this=$(this);
				if($(this).hasClass("glyphicon-star-empty")){
					$(this).removeClass("glyphicon-star-empty");
					$(this).addClass("glyphicon-star");
				}else{
					$(this).addClass("glyphicon-star-empty");
					$(this).removeClass("glyphicon-star");
				}
				
			});
			$("#msTJ").on('click',function(){
				var myd=$(".rating .glyphicon-star").length;
				var message=$("#messagez").val();
				var goodsId=$(".goodsIdzzz").val();
				alert(myd+'  '+message+' '+goodsId);
				if($("#DDD").val()=='0'){
					alert("登录之后才能评价");
				}else{
				//	return false;        //==========
					$.ajax({
						type: 'POST',
						data:{"goodsId":goodsId,"myd":myd,"message":message},
						url: ctx+'/product/goodsMessageAdd',
						success:function(data){
							if(data.RetCode=='1'){
								alert("评价成功");
								location.reload() 
							}else{
								alert("错误");
							}
						},
					})
				}
			});
			$("#jiaru").on('click',function(){
				var goodsId=$(".goodsIdzzz").val();
				var num=$(".quantity").val();
				if($("#DDD").val()=='0'){
					alert("登录之后才能加入购物车");
				}else{
					$.ajax({
						type: 'POST',
						data:{"goodsId":goodsId,"num":num},
						url: ctx+'/cart/addCart',
						success:function(data){
							if(data.RetCode=='1'){
								alert("加入购物车成功");
							}else{
								alert("错误");
							}
						},
					})
				}
			});
		}
	};
})();

$(function(){
	yjgPro.init();
});



