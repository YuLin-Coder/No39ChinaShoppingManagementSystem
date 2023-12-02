(function(){
	yjgIn = {
		init:function(){
			var self = this;
			//绑定事件
			self.event();
		},
		event:function(){
			$.ajax({
				type: 'POST',
				url: ctx+'/index/getProducts',
				async:false,
				success:function(data){
					var data = eval('(' + data + ')'); //字符串转换成json
					var list=data.RetData;
					var html='';
					if(list!=null){
						for(var a=0;a<list.length;a++){
							html+='<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">\
									<div class="product">\
										<div class="image"><a href="'+ctx+'/product?goodsId='+list[a].goodsId+'"><img src="/imagesZZ/'+list[a].goodsUrl+'" /></a></div>\
										<div class="buttons">\
											<div class="btn cart"><span class="glyphicon glyphicon-shopping-cart"></span></div>\
											<input type="hidden" class="goodsIdDD" value="'+list[a].goodsId+'">\
											<div class="btn wishlist"><span class="glyphicon glyphicon-heart"></span></div>\
											<div class="btn compare"><span class="glyphicon glyphicon-transfer"></span></div>\
										</div>\
										<div class="caption">\
											<div class="name"><h3><a href="'+ctx+'/product?goodsId='+list[a].goodsId+'">'+list[a].goodsName+'</a></h3></div>\
										<div class="price">$'+list[a].goodsPrice+'</div>\
										</div>\
									</div>\
								  </div>';
							if(a==7){
								break;
							}
						}
						$("#newProducts").append(html);
					}
					var list2=data.RetDataZK;
					var html2='';
					if(list2!=null){
						for(var a=0;a<list2.length;a++){
							html2+='<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">\
										<div class="product">\
											<div class="image"><a href="'+ctx+'/product?goodsId='+list2[a].goodsId+'"><img src="/imagesZZ/'+list2[a].goodsUrl+'" /></a></div>\
											<div class="buttons">\
												<div class="btn cart" ><span class="glyphicon glyphicon-shopping-cart"></span></div>\
												<input type="hidden" class="goodsIdDD" value="'+list2[a].goodsId+'">\
												<div class="btn wishlist" ><span class="glyphicon glyphicon-heart"></span></div>\
												<div class="btn compare" ><span class="glyphicon glyphicon-transfer"></span></div>\
											</div>\
											<div class="caption">\
												<div class="name"><h3><a href="'+ctx+'/product?goodsId='+list2[a].goodsId+'">'+list2[a].goodsName+'</a></h3></div>\
												<div class="price">$'+list2[a].goodsPriceZ+'<span>$'+list2[a].goodsPrice+'</span></div>\
											</div>\
										</div>\
									</div>';
							if(a==3){
								break;
							}
						}
						$("#zkProducts").append(html2);
					}
				},
				error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
			        	console.log(XMLHttpRequest);
			        	console.log(textStatus);
			        	console.log(errorThrown);
			    },
			});
			$(".cart").on('click',function(){
				if($("#DDD").val()=='0'){
					alert("登录之后才能加入购物车");
				}else{
					var goodsId=$(this).siblings(".goodsIdDD").val();
					$.ajax({
						type: 'POST',
						data:{"goodsId":goodsId},
						url: ctx+'/cart/addCart',
						success:function(data){
							if(data.RetCode=='1'){
								alert("加入购物车成功");
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
				}
			});
			$(".wishlist").on('click',function(){
				if($("#DDD").val()=='0'){
					alert("登录之后才能进行收藏");
				}else{
					var goodsId=$(this).siblings(".goodsIdDD").val();
					$.ajax({
						type: 'POST',
						data:{"goodsId":goodsId},
						url: ctx+'/cart/addCollect',
						success:function(data){
							if(data.RetCode=='1'){
								alert("收藏成功");
							}else if(data.RetCode=='2'){
								alert("该商品已收藏");
							}else{
								alert("错误")
							}
						},
						error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
					        	console.log(XMLHttpRequest);
					        	console.log(textStatus);
					        	console.log(errorThrown);
					    },
					})
				}
			});
		},
	};
})();

$(function(){
	yjgIn.init();
});




