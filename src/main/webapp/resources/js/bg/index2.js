var list;
(function(){
	yjgIndex2 = {
		init:function(){
			var self = this;

			//获取页面
			self.getPage();
			//绑定事件
			self.event();
			self.addImg();
		},

		getPage:function(){
			$("#sy").css('display','');
			$("#spgl2").css('display','none');
			$("#fkxx2").css('display','none');
			$("#GOODScaoz").css('display','none');
			$("#glysq2").css('display','none');
			$("#yhgl2").css('display','none');
			$("#dzsh2").css('display','none');
			$("#pzgl2").css('display','none');
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
		event:function(){
			//品种管理
			$("#pzgl").on('click',function(){
				$("#sy").css('display','none');
				$("#spgl2").css('display','none');
				$("#fkxx2").css('display','none');
				$("#GOODScaoz").css('display','none');
				$("#glysq2").css('display','none');
				$("#yhgl2").css('display','none');
				$("#dzsh2").css('display','none');
				$("#pzgl2").css('display','');
				$.ajax({
					type: 'POST',
					url: ctx+'/index/getTitle',
					async:false,
					success:function(data){
						var data = eval('(' + data + ')'); //字符串转换成json
						list=data.RetData;
						var html='';
						$("#pzlist1").empty();
						for(var a=0;a<list.length;a++){
							if(list[a].name=='主页'){
								continue;
							}
							html+='<tr>\
										<td class="pzLD">'+(a)+'</td>\
										<td class="pzLD pznamezzzz">'+list[a].name+'</td>\
										<td class="pzLD">'+list[a].createPer+'</td>\
										<input class="pzQQ" type="hidden" value="'+list[a].typeId+'">\
										<td style="cursor:pointer;color:#428bca"><span class="pzzzzzup">修改</span>&nbsp;&nbsp;<span class="pzzzzzdel">删除</span></td>\
									</tr>';
						}
						$("#pzlist1").append(html);
					},
					error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
				        	console.log(XMLHttpRequest);
				        	console.log(textStatus);
				        	console.log(errorThrown);
				    },
				})
				$(".pzLD").on('click',function(){
					var typeId1=$(this).siblings(".pzQQ").val();
					var list2;
					for(var a=0;a<list.length;a++){
						if((list[a].typeId)==typeId1){
							list2=list[a].list;
						}
					}
					var html2='';
					$("#pzlist2").empty();
					for(var b=0;b<list2.length;b++){
						html2+='<tr>\
									<td >'+(b+1)+'</td>\
									<td class="pz2namezzzz">'+list2[b].name+'</td>\
									<td >'+list2[b].createPer+'</td>\
									<input class="pz2QQz" type="hidden" value="'+list2[b].typeId+'">\
									<input class="pz2QQ" type="hidden" value="'+list2[b].typeDid+'">\
									<td style="cursor:pointer;color:#428bca"><span class="pz2zzzzup">修改</span>&nbsp;&nbsp;<span class="pz2zzzzdel">删除</span></td>\
								</tr>';
					}
					$("#pzlist2").append(html2);
					//新增子品种
					$('#xzPZ2').on('click',function(){
						$("#pzaaaa2").click();
						$("#pz2Namezz").val("");
						$("#pzdidZZZ").val("");
						$.ajax({
							type: 'POST',
							url: ctx+'/index/getTitle',
							async:false,
							success:function(data){
								var data = eval('(' + data + ')'); //字符串转换成json
								list=data.RetData;
								var html='';
								$("#pz2list").empty();
								for(var a=0;a<list.length;a++){
									if(list[a].name=='主页'){
										continue;
									}
									html+='<option value='+list[a].typeId+'> '+list[a].name+'</option>';
								}
								$("#pz2list").append(html);
							},
							error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
						        	console.log(XMLHttpRequest);
						        	console.log(textStatus);
						        	console.log(errorThrown);
						    },
						})
						$("#pz2list option:first").prop("selected", 'selected');
					})
					//子品种修改
					$('.pz2zzzzup').on('click',function(){
						$("#pzaaaa2").click();
						$.ajax({
							type: 'POST',
							url: ctx+'/index/getTitle',
							async:false,
							success:function(data){
								var data = eval('(' + data + ')'); //字符串转换成json
								list=data.RetData;
								var html='';
								$("#pz2list").empty();
								for(var a=0;a<list.length;a++){
									if(list[a].name=='主页'){
										continue;
									}
									html+='<option value='+list[a].typeId+'> '+list[a].name+'</option>';
								}
								$("#pz2list").append(html);
							},
							error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
						        	console.log(XMLHttpRequest);
						        	console.log(textStatus);
						        	console.log(errorThrown);
						    },
						})
						//回显
						var named=$(this).parents().siblings(".pz2namezzzz").html();
						var typeid=$(this).parents().siblings(".pz2QQz").val(); //所属主品种ID
						var typeDid=$(this).parents().siblings(".pz2QQ").val(); //修改子品种ID
						$("#pz2Namezz").val(named);
						$("#pzdidZZZ").val(typeDid);
						$("#pz2list option[value="+typeid+"]").prop("selected", 'selected');
					})
					$(".pz2zzzzdel").on('click',function(){
						var typeDid=$(this).parents().siblings(".pz2QQ").val(); //删除子品种ID
						alert("子品种删除"+typeDid);
						$.ajax({
							type: 'POST',
							url: ctx+'/index2/delTypeD',  //删除子品种
							data:{'typeDid':typeDid},
							async:false,
							success:function(data){
								alert("删除成功");
								//模拟点击
								$("#pzgl").click();
							},
							error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
						        	console.log(XMLHttpRequest);
						        	console.log(textStatus);
						        	console.log(errorThrown);
						    },
						})
					})
				})
				$("#pzlist1 td:first").click();
				//新增主品种
				$('#xzPZ1').on('click',function(){
					$("#pzaaaa1").click();
					$("#pzNamezz").val("");
					$("#pzidZZZ").val("");
				})
				//主品种修改
				$('.pzzzzzup').on('click',function(){
					$("#pzaaaa1").click();
					var name=$(this).parents().siblings(".pznamezzzz").html();
					var typeid=$(this).parents().siblings(".pzQQ").val();
					$("#pzNamezz").val(name);
					$("#pzidZZZ").val(typeid);
				})
			
				$(".pzzzzzdel").on('click',function(){
					var typeid=$(this).parents().siblings(".pzQQ").val();
					alert("主品种删除"+typeid);
					$.ajax({
						type: 'POST',
						url: ctx+'/index2/delType',   ///删除主品种
						data:{'typeid':typeid},
						async:false,
						success:function(data){
							alert("删除成功");
							//模拟点击
							$("#pzgl").click();
						},
						error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
					        	console.log(XMLHttpRequest);
					        	console.log(textStatus);
					        	console.log(errorThrown);
					    },
					})
				})
			});
			//主品种新增or修改确定
			$("#zpzqd").on('click',function(){
				var name=$("#pzNamezz").val();
				var typeid=$("#pzidZZZ").val();
			//	alert("zz"+" "+name+typeid);
				$.ajax({
					type: 'POST',
					url: ctx+'/index2/addType',   
					data:{'name':name,"typeid":typeid},
					async:false,
					success:function(data){
						alert("操作成功");
						//模拟点击
						$("#pzgl").click();
					},
					error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
				        	console.log(XMLHttpRequest);
				        	console.log(textStatus);
				        	console.log(errorThrown);
				    },
				})
			})
			//子品种新增or修改确定
			$("#zpz2qd").on('click',function(){
				var name=$("#pz2Namezz").val();
				var typeDid=$("#pzdidZZZ").val();
				var typeid=$("#pz2list option:selected").val();
			//	alert("xx"+name+typeDid+typeid);
				$.ajax({
					type: 'POST',
					url: ctx+'/index2/addTypeD',   
					data:{'name':name,"typeid":typeid,"typeDid":typeDid},
					async:false,
					success:function(data){
						alert("操作成功");
						//模拟点击
						$("#pzgl").click();
					},
					error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
				        	console.log(XMLHttpRequest);
				        	console.log(textStatus);
				        	console.log(errorThrown);
				    },
				})
			})
			//商品管理
			$("#spgl").on('click',function(){
				$("#spgl2").css('display','');
				$("#fkxx2").css('display','none');
				$("#sy").css('display','none');
				$("#GOODScaoz").css('display','none');
				$("#glysq2").css('display','none');
				$("#yhgl2").css('display','none');
				$("#dzsh2").css('display','none');
				$("#pzgl2").css('display','none');
				loadData1(1);
				loadpage1();
				$("#spQD").on('click',function(){
					$("#GOODScaoz").css("display","");
					$("#spgl2").css("display","none");
					$("#goodsIdZZ").val("");
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
			});
			//陶瓷新增确定
			$("#spQD11").on('click',function(){
				$("#ff4").ajaxSubmit({
					type:'POST',
					url:ctx+'/user/addGoods2',
					success:function(data){
						if(data.RetCode=='1'){
							$("#spgl").click();
						}else{
							alert("发生错误");
						}
					}
				})
			});
		/*	$("#spsh").on('click',function(){
				alert("商品审核");
			});*/
			//管理员授权
			$("#glysq").on('click',function(){
				$("#spgl2").css('display','none');
				$("#fkxx2").css('display','none');
				$("#sy").css('display','none');
				$("#GOODScaoz").css('display','none');
				$("#glysq2").css('display','');
				$("#yhgl2").css('display','none');
				$("#dzsh2").css('display','none');
				$("#pzgl2").css('display','none');
				$.ajax({
					type: 'POST',
					data:{"ifAdmin":"Y"},
					url: ctx+'/user/seletAllUser',
					async:false,
					success:function(data){
						var list=data.RetData;
						var html='';
						$("#glylist").empty();
						for(var a=0;a<list.length;a++){
							var createPer=""
							if(list[a].createPer!=""&&list[a].createPer!=undefined){
								createPer=list[a].createPer;
							}
							html+='<tr>\
										<td style="width:60px;">'+(a+1)+'</td>\
										<td style="width:300px;">'+list[a].userName+'</td>\
										<td style="width:100px;">'+list[a].createDate+'</td>\
										<td style="width:60px;">'+createPer+'</td>\
									</tr>';
						}
						$("#glylist").append(html);
					},
					error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
				        	console.log(XMLHttpRequest);
				        	console.log(textStatus);
				        	console.log(errorThrown);
				    },
				})
				$("#glyzz").on('click',function(){
					$("#glysq2").css('dispaly','none');
					$("#yhgl").click();
					$(".yhcaozzzz").html('授权');
					$(".yhcaozzzz").addClass("yhsqzzzz");
					$("#yhfhzz").css('display','');
					$(".yhsqzzzz").off('click');
					$(".yhsqzzzz").on('click',function(){
						var userId=$(this).siblings(".userQQ").val();
						$.ajax({
							type: 'POST',
							data:{"userId":userId,"flag":"1"},
							url: ctx+'/user/chageUser',
							async:false,
							success:function(data){
								alert("授权成功！");
								$("#glysq").click();
							},
							error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
						        	console.log(XMLHttpRequest);
						        	console.log(textStatus);
						        	console.log(errorThrown);
						    },
						})
					});
				});
			});
			//店主申请
			$("#dzsh").on('click',function(){
				$("#spgl2").css('display','none');
				$("#fkxx2").css('display','none');
				$("#sy").css('display','none');
				$("#GOODScaoz").css('display','none');
				$("#glysq2").css('display','none');
				$("#yhgl2").css('display','none');
				$("#yhfhzz").css('display','none');
				$("#dzsh2").css('display','');
				$("#pzgl2").css('display','none');
				  loadData3(1);
				  loadpage3();
				  $(".dzxxxx").on('click',function(){
					  var sellerId=$(this).siblings(".dzQQ").val();
						$.ajax({
							type: 'POST',
							data:{"sellerId":sellerId},
							url: ctx+'/user/getSeller2',
							async:false,
							success:function(data){
								var seller=data.RetData;
								$("#dzsfzhm").html(seller.tIdCard);
								$("#dzmz").html(seller.tUserName);
								$("#tuZZ1").attr("src","/imagesZZ/"+seller.tIdCardUrl1);
								$("#tuZZ2").attr("src","/imagesZZ/"+seller.tIdCardUrl2);
								$("#sellerZZZ").val(seller.sellerId);
								$("#sellerZZZ2").val(seller.tStatus);
								$("#dzqqq").click();
							},
							error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
						        	console.log(XMLHttpRequest);
						        	console.log(textStatus);
						        	console.log(errorThrown);
						    },
						})
				  });
			});
			$("#dzsqtg").on("click",function(){
				var sellerStu=$(this).siblings("#sellerZZZ2").val();
				var sellerId=$(this).siblings("#sellerZZZ").val();
				if(sellerStu=="20"){
					alert("已经通过了审核");
					$(".modal-header .close").click();
					return false;
				}
				$.ajax({
					type: 'POST',
					data:{"sellerId":sellerId},
					url: ctx+'/user/updateSeller',
					async:false,
					success:function(data){
						$(".modal-header .close").click();
						$("#dzsh").click();
					},
					error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
				        	console.log(XMLHttpRequest);
				        	console.log(textStatus);
				        	console.log(errorThrown);
				    },
				})
			});
			$("#dzsqbtg").on("click",function(){
				var sellerStu=$(this).siblings("#sellerZZZ2").val();
				if(sellerStu=="20"){
					alert("已经通过了审核");
					$(".modal-header .close").click();
					return false;
				}
				var sellerId=$(this).siblings("#sellerZZZ").val();
				$.ajax({
					type: 'POST',
					data:{"sellerId":sellerId},
					url: ctx+'/user/delSeller',
					async:false,
					success:function(data){
						$(".modal-header .close").click();
						$("#dzsh").click();
					},
					error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
				        	console.log(XMLHttpRequest);
				        	console.log(textStatus);
				        	console.log(errorThrown);
				    },
				})
			});
			//用户管理
			$("#yhgl").on('click',function(){
				$("#spgl2").css('display','none');
				$("#fkxx2").css('display','none');
				$("#sy").css('display','none');
				$("#GOODScaoz").css('display','none');
				$("#glysq2").css('display','none');
				$("#yhgl2").css('display','');
				$("#yhfhzz").css('display','none');
				$("#dzsh2").css('display','none');
				$("#pzgl2").css('display','none');
				loadData2(1);
				loadpage2();
				$(".yhcaozzzz").off('click');
				$(".yhcaozzzz").on('click',function(){
					var userId=$(this).siblings(".userQQ").val();
					alert(userId+"重置");
					$.ajax({
						type: 'POST',
						data:{"userId":userId,"flag":"0"},
						url: ctx+'/user/chageUser',
						async:false,
						success:function(data){
							alert("密码重置成功！");
							$("#yhgl").click();
						},
						error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
					        	console.log(XMLHttpRequest);
					        	console.log(textStatus);
					        	console.log(errorThrown);
					    },
					})
				});
			});
			$(".zkzz").on('click',function(){
				if($(this).val()=='Y'){
					$("#zkjg").css('display','');
				}else{
					$("#zkjg").css('display','none');
				}
			});
			//反馈信息
			$("#fkxx").on('click',function(){
				$("#sy").css('display','none');
				$("#spgl2").css('display','none');
				$("#fkxx2").css('display','');
				$("#fkxx3").css('display','none');
				$("#GOODScaoz").css('display','none');
				$("#glysq2").css('display','none');
				$("#yhgl2").css('display','none');
				$("#dzsh2").css('display','none');
				$("#pzgl2").css('display','none');
				$.ajax({
					type: 'POST',
					url: ctx+'/contact/getContact',
					async:false,
					success:function(data){
						var list=data.RetData;
						if(list!=null&&list.length!=0){
							$("#fkxxW").css('display','none');
							$("#fkxxY").css('display','');
							$("#fkxx3").css('display','none');
							var html='';
							$("#fklist").empty();
							for(var a=0;a<list.length;a++){
								var mStatus='';
								if(list[a].mStatus=='10'){
									mStatus='待处理';
								}else{
									mStatus='已处理';
								}
								html+='<tr>\
											<td style="width:60px;">'+(a+1)+'</td>\
											<input type="hidden" value="'+list[a].messageId+'" class="mid">\
											<td style="width:300px;">'+list[a].mDetail+'</td>\
											<td style="width:100px;">'+list[a].createDate+'</td>\
											<td style="width:60px;">'+mStatus+'</td>\
										</tr>';
							}
							$("#fklist").append(html);
						}else{
							$("#fkxxW").css('display','');
							$("#fkxxY").css('display','none');
							$("#fkxx3").css('display','none');
						}
					},
					error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
				        	console.log(XMLHttpRequest);
				        	console.log(textStatus);
				        	console.log(errorThrown);
				    },
				})
				$("#fklist tr").on('click',function(){
					var mId=$(this).children(".mid").val();
					$("#fkxxY").css('display','none');
					$("#fkxx3").css('display','');
					$.ajax({
						type: 'POST',
						data:{"messageId":mId},
						url: ctx+'/contact/getOneContact',
						async:false,
						success:function(data){
							var message=data.RetData;
							var mStatus='';
							if(message.mStatus=='10'){
								mStatus='待处理';
							}else{
								mStatus='已处理';
							}
							$("#mUserZ").html(message.mName);
							$("#mStatuZ").html(mStatus);
							$("#mDetailZ").html('&nbsp;&nbsp;'+message.mDetail);
						},
						error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
					        	console.log(XMLHttpRequest);
					        	console.log(textStatus);
					        	console.log(errorThrown);
					    },
					})
					$("#fkxxfh").on('click',function(){
						$("#fkxx").click();
					});
				});
			});
		}
	};
})();

$(function(){
	yjgIndex2.init();
});
//商品分页
function exeData1(num, type) {
    loadData1(num);
    loadpage1();
}
function loadpage1() {
    var myPageCount = parseInt($("#PageCount1").val());
    var myPageSize = parseInt($("#PageSize1").val());
    var countindex = myPageCount % myPageSize > 0 ? (myPageCount / myPageSize) + 1 : (myPageCount / myPageSize);
    $("#countindex1").val(countindex);
    if(countindex==0){
    	return false;
    }
    $.jqPaginator('#pagination1', {
        totalPages: parseInt($("#countindex1").val()),
        visiblePages: parseInt($("#visiblePages1").val()),
        currentPage: 1,
        first: '<li class="first"><a href="javascript:;">首页</a></li>',
        prev: '<li class="prev"><a href="javascript:;"><i class="arrow arrow2"></i>上一页</a></li>',
        next: '<li class="next"><a href="javascript:;">下一页<i class="arrow arrow3"></i></a></li>',
        last: '<li class="last"><a href="javascript:;">末页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            if (type == "change") {
                exeData1(num, type);
            }
        }
    });
}
function loadData1(num) {
	//alert(num);
	//发送ajax num当前页 PageSize每页显示多少条前台写死
	$("#PageSize1").val(8);
	$.ajax({
		type: 'POST',
		url: ctx+'/category/getGoodsList',
		async:false,
		data:{'pageIndex':num,"pageSize":8},
		success:function(data){
			  var size=data.RetData.size;
			  var list=data.RetData.list;
			  var html='';
			  $("#splist").empty();
			  if(list!=null&&list.length!=0){
				  $("#pageSP1").css('display','');
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
									<td>'+list[a].goodsFrom+'</td>\
									<td><input class="goodsQQ" type="hidden" value="'+list[a].goodsId+'"><a class="glyphicon glyphicon-edit spUpdate"></a>&nbsp;&nbsp;<a class="glyphicon glyphicon-remove spRemove"></a></td>\
								</tr>';
						}else{
							html+='<tr>\
									<td>'+list[a].goodsName+'</td>\
									<td>'+list[a].goodsPrice+'</td>\
									<td>'+list[a].goodsNum+'</td>\
									<td>N</td>\
									<td>0</td>\
									<td>'+list[a].goodsFrom+'</td>\
									<td><input class="goodsQQ" type="hidden" value="'+list[a].goodsId+'"><a class="glyphicon glyphicon-edit spUpdate"></a>&nbsp;&nbsp;<a class="glyphicon glyphicon-remove spRemove"></a></td>\
								</tr>';
						}
					}
					$("#splist").append(html);
				}else{
					$("#pageSP1").css('display','none');
				}
			  $("#PageCount1").val(size);
		},
		error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
	        	console.log(XMLHttpRequest);
	        	console.log(textStatus);
	        	console.log(errorThrown);
	    },
	})
	//商品修改
	$(".spUpdate").on('click',function(){
		var self = $(this);
		var goodsId=self.siblings(".goodsQQ").val();
		$("#GOODScaoz").css("display","");
		$("#spgl2").css("display","none");
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
			async:false,
			url: ctx+'/user/seletOneGoods',
			data:{"goodsId":goodsId},
			success:function(data){
				if(data.RetCode=='1'){
					var goods=data.RetData;
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
					$("#pzlist option[value="+goods.typeDid+"]").attr('selected','selected');
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
	//商品删除
	$(".spRemove").on('click',function(){
		var self = $(this);
		var goodsId=self.siblings(".goodsQQ").val();
		$.ajax({
			type: 'POST',
			async:false,
			url: ctx+'/user/remGoods',
			data:{"goodsId":goodsId},
			success:function(data){
				if(data.RetCode=='1'){
					$("#spgl").click();
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
}
//用户管理分页
function exeData2(num, type) {
    loadData2(num);
    loadpage2();
}
function loadpage2() {
    var myPageCount = parseInt($("#PageCount2").val());
    var myPageSize = parseInt($("#PageSize2").val());
    var countindex = myPageCount % myPageSize > 0 ? (myPageCount / myPageSize) + 1 : (myPageCount / myPageSize);
    $("#countindex2").val(countindex);
    if(countindex==0){
    	return false;
    }
    $.jqPaginator('#pagination2', {
        totalPages: parseInt($("#countindex2").val()),
        visiblePages: parseInt($("#visiblePages2").val()),
        currentPage: 1,
        first: '<li class="first"><a href="javascript:;">首页</a></li>',
        prev: '<li class="prev"><a href="javascript:;"><i class="arrow arrow2"></i>上一页</a></li>',
        next: '<li class="next"><a href="javascript:;">下一页<i class="arrow arrow3"></i></a></li>',
        last: '<li class="last"><a href="javascript:;">末页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            if (type == "change") {
                exeData2(num, type);
            }
        }
    });
}
function loadData2(num) {
	//alert(num);
	//发送ajax num当前页 PageSize每页显示多少条前台写死
	$("#PageSize2").val(8);
	$.ajax({
		type: 'POST',
		url: ctx+'/user/getUserList',
		async:false,
		data:{'pageIndex':num,"pageSize":8},
		success:function(data){
			  var size=data.RetData.size;
			  var list=data.RetData.list;
			  var html='';
			  $("#yhlist").empty();
			  if(list!=null&&list.length!=0){

				  $("#pageSP2").css('display','');
					var html='';
					$("#yhlist").empty();
					for(var a=0;a<list.length;a++){
						var gender='';
						if(list[a].gender=='F'){
							gender='女';
						}else{
							gender='男';
						}
						html+='<tr>\
								<td>'+(a+1)+'</td>\
								<td>'+list[a].userName+'</td>\
								<td>'+gender+'</td>\
								<td>'+list[a].phoneNum+'</td>\
								<td>'+list[a].createDate+'</td>\
								<input class="userQQ" type="hidden" value="'+list[a].userId+'">\
								<td style="cursor:pointer;color:#428bca" class="yhcaozzzz">密码重置</td>\
							 </tr>';	
					}
					$("#yhlist").append(html);
				
			  }else{
					$("#pageSP2").css('display','none');
				}
			  $("#PageCount2").val(size);
		},
		error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
	        	console.log(XMLHttpRequest);
	        	console.log(textStatus);
	        	console.log(errorThrown);
	    },
	})
}
//店主分页
function exeData3(num, type) {
    loadData3(num);
    loadpage3();
}
function loadpage3() {
    var myPageCount = parseInt($("#PageCount3").val());
    var myPageSize = parseInt($("#PageSize3").val());
    var countindex = myPageCount % myPageSize > 0 ? (myPageCount / myPageSize) + 1 : (myPageCount / myPageSize);
    $("#countindex3").val(countindex);
    if(countindex==0){
    	return false;
    }
    $.jqPaginator('#pagination3', {
        totalPages: parseInt($("#countindex3").val()),
        visiblePages: parseInt($("#visiblePages3").val()),
        currentPage: 1,
        first: '<li class="first"><a href="javascript:;">首页</a></li>',
        prev: '<li class="prev"><a href="javascript:;"><i class="arrow arrow2"></i>上一页</a></li>',
        next: '<li class="next"><a href="javascript:;">下一页<i class="arrow arrow3"></i></a></li>',
        last: '<li class="last"><a href="javascript:;">末页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            if (type == "change") {
                exeData3(num, type);
            }
        }
    });
}
function loadData3(num) {
	//alert(num);
	//发送ajax num当前页 PageSize每页显示多少条前台写死
	$("#PageSize3").val(8);
	$.ajax({
		type: 'POST',
		url: ctx+'/user/getSellerList',
		async:false,
		data:{'pageIndex':num,"pageSize":8},
		success:function(data){
			  var size=data.RetData.size;
			  var list=data.RetData.list;
			  var html='';
			  $("#dzlist").empty();
			  if(list!=null&&list.length!=0){

				  $("#pageSP3").css('display','');
					var html='';
					$("#dzlist").empty();
					for(var a=0;a<list.length;a++){
						var tStatus='';
						if(list[a].tStatus=='10'){
							tStatus='待审核';
						}else{
							tStatus='审核通过';
						}
						html+='<tr>\
								<td>'+(a+1)+'</td>\
								<td>'+list[a].tUserName+'</td>\
								<td>'+list[a].tPhoneNum+'</td>\
								<td>'+tStatus+'</td>\
								<td>'+list[a].createDate+'</td>\
								<input class="dzQQ" type="hidden" value="'+list[a].sellerId+'">\
								<td style="cursor:pointer;color:#428bca" class="dzxxxx">详情</td>\
							 </tr>';	
					}
					$("#dzlist").append(html);
				
			  }else{
					$("#pageSP3").css('display','none');
				}
			  $("#PageCount3").val(size);
		},
		error:function (XMLHttpRequest, textStatus, errorThrown) {					        	
	        	console.log(XMLHttpRequest);
	        	console.log(textStatus);
	        	console.log(errorThrown);
	    },
	})
}
function aa(){
	$("#glysq").click();
}
function bb(){
	$("#spgl").click();
	$("#ff4 input").val("");
	$("#ff4 textarea").val("");
	$(".g-showImg").remove();
	$('.default').css('display','');
}