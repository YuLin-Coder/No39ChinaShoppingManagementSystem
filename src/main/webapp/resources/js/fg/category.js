(function(){
	yjg = {
		init:function(){
			var self = this;

			//获取页面(分页)
			self.getPage();
			//绑定事件
			self.event();
		},

		getPage:function(){
			  loadData(1);
			  loadpage();
		},
		event:function(){
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
		}
	};
})();

$(function(){
	yjg.init();
});
function exeData(num, type) {
    loadData(num);
    loadpage();
}
function loadpage() {
    var myPageCount = parseInt($("#PageCount").val());
    var myPageSize = parseInt($("#PageSize").val());
    var countindex = myPageCount % myPageSize > 0 ? (myPageCount / myPageSize) + 1 : (myPageCount / myPageSize);
    $("#countindex").val(countindex);
    if(countindex==0){
    	return false;
    }
    $.jqPaginator('#pagination', {
        totalPages: parseInt($("#countindex").val()),
        visiblePages: parseInt($("#visiblePages").val()),
        currentPage: 1,
        first: '<li class="first"><a href="javascript:;">首页</a></li>',
        prev: '<li class="prev"><a href="javascript:;"><i class="arrow arrow2"></i>上一页</a></li>',
        next: '<li class="next"><a href="javascript:;">下一页<i class="arrow arrow3"></i></a></li>',
        last: '<li class="last"><a href="javascript:;">末页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            if (type == "change") {
                exeData(num, type);
            }
        }
    });
}
function loadData(num) {
	//alert(num);
	//发送ajax num当前页 PageSize每页显示多少条前台写死
	$("#PageSize").val(8);
	$.ajax({
		type: 'POST',
		url: ctx+'/category/getGoodsList',
		async:false,
		data:{'pageIndex':num,"pageSize":8},
		success:function(data){
			  var size=data.RetData.size;
			  var list=data.RetData.list;
			  var html='';
			  $("#products").empty();
			  if(list!=null&&list.length!=0){
				  $("#nopd").css('display','none');
				  for(var a=0;a<list.length;a++){
					  if(list[a].ifZK=='Y'){
						  html+='<div class="col-lg-3 col-md-3 col-xs-12 product">\
							<div class="image"><a href="'+ctx+'/product?goodsId='+list[a].goodsId+'"><img src="/imagesZZ/'+list[a].goodsUrl+'" /></a></div>\
							<div class="buttons">\
								<div class="btn cart" ><span class="glyphicon glyphicon-shopping-cart"></span></div>\
								<input type="hidden" class="goodsIdDD" value="'+list[a].goodsId+'">\
								<div class="btn wishlist" ><span class="glyphicon glyphicon-heart"></span></div>\
								<div class="btn compare" ><span class="glyphicon glyphicon-transfer"></span></div>\
							</div>\
							<div class="caption">\
								<div class="name"><h3><a href="'+ctx+'/product?goodsId='+list[a].goodsId+'">'+list[a].goodsName+'</a></h3></div>\
								<div class="price">$'+list[a].goodsPriceZ+'<span>$'+list[a].goodsPrice+'</span></div>\
							</div>\
						</div>';
					  }else{
						  html+='<div class=" col-lg-3 col-md-3 col-xs-12 product">\
									<div class="image"><a href="'+ctx+'/product?goodsId='+list[a].goodsId+'"><img src="/imagesZZ/'+list[a].goodsUrl+'" /></a></div>\
									<div class="buttons">\
										<div class="btn cart" ><span class="glyphicon glyphicon-shopping-cart"></span></div>\
										<div class="btn wishlist" ><span class="glyphicon glyphicon-heart"></span></div>\
										<input type="hidden" class="goodsIdDD" value="'+list[a].goodsId+'">\
										<div class="btn compare" ><span class="glyphicon glyphicon-transfer"></span></div>\
									</div>\
									<div class="caption">\
										<div class="name"><h3><a href="'+ctx+'/product?goodsId='+list[a].goodsId+'">'+list[a].goodsName+'</a></h3></div>\
										<div class="price">$'+list[a].goodsPrice+'</div>\
									</div>\
							  	</div>';
					  }
				  } 
				  $('#products').append(html);
			  }else{
				  $("#nopd").css('display','');
			  }
			  $("#PageCount").val(size);
		},
		error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
	        	console.log(XMLHttpRequest);
	        	console.log(textStatus);
	        	console.log(errorThrown);
	    },
	})
}



