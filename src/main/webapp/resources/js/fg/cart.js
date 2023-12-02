(function(){
	yjgCART = {
		init:function(){
			var self = this;

			//获取页面
			self.getPage();
			//绑定事件
			self.event();
		},

		getPage:function(){
			$.ajax({
				type: 'POST',
				url: ctx+'/cart/getCart',
				async:false,
				success:function(data){
					console.log(data);
					var list=data.RetData;
					var html='';
					if(list.length==0){
						$("#cartTS").css('display','');
						$(".pricedetails").css('display','none');
						$("#fanHui").html('返回购物');
					}else{
						$("#cartTS").css('display','none');
						$(".pricedetails").css('display','');
						$("#fanHui").html('返回继续购物');
						var zkPrice=0;
						var nzkPrice=0;
						for(var a=0;a<list.length;a++){
							if(list[a].goods.ifZK=='Y'){
								html+='<div class="row" id="cart'+list[a].cartId+'">\
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
												<label>数量: </label> <input class="form-inline quantity" type="text" value="'+list[a].goodsNum+'">\
												<hr>\
												<input type="hidden" class="cartIdz" value="'+list[a].cartId+'">\
												<a href="#" class="btn btn-default pull-right removeGoods">移除</a>\
											</div>\
										</div>\
										<div class="clear"></div>\
									</div>\
							 </div>';
							zkPrice+=((list[a].goods.goodsPrice)-(list[a].goods.goodsPriceZ))*(list[a].goodsNum);
							}else{
								html+='<div class="row" id="cart'+list[a].cartId+'">\
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
												<label>数量: </label> <input class="form-inline quantity" type="text" value="'+list[a].goodsNum+'">\
												<hr>\
												<input type="hidden" class="cartIdz" value="'+list[a].cartId+'">\
												<span  class="btn btn-default pull-right removeGoods">移除</span>\
											</div>\
										</div>\
										<div class="clear"></div>\
									</div>\
							 </div>';
							}	
							nzkPrice+=(list[a].goods.goodsPrice)*(list[a].goodsNum);
						}
						$("#cartList").append(html);
						var price=nzkPrice-zkPrice;
						$("#nzkPrice").html(nzkPrice);
						$("#zprice").html(zkPrice);
						$("#zkPrice").html(price);
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
			//更新数量
			$(".quantity").on('blur',function(){
				var self = $(this);
				var cartId=self.siblings(".cartIdz").val();
				var num=self.val();
				$.ajax({
					type: 'POST',
					url: ctx+'/cart/updateCart',
					data:{"cartId":cartId,"goodsNum":num},
					success:function(data){
						if(data.RetCode=='0'){
							alert("错误！");
						}
					},
					error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
				        	console.log(XMLHttpRequest);
				        	console.log(textStatus);
				        	console.log(errorThrown);
				    },
				})
			})
			//移除
			$(".removeGoods").on('click',function(){
				var self =$(this);
				var cartId=self.siblings(".cartIdz").val();
				
				$.ajax({
					type: 'POST',
					url: ctx+'/cart/remCart',
					data:{"cartId":cartId},
					success:function(data){
						if(data.RetCode=='1'){
							$("#cart"+cartId).slideUp(800,function(){
								$("#cart"+cartId).remove();
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
			})
			//结算
			$("#checkGoods").on('click',function(){
				$.ajax({
					type: 'POST',
					url: ctx+'/cart/remCart',
					success:function(data){
						if(data.RetCode=='1'){
							window.location.href =ctx+'/cart'; 
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
			})
		}
	};
})();

$(function(){
	yjgCART.init();
});




