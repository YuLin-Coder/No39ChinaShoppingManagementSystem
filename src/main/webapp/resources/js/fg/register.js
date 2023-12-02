$(document).ready(function(){        
	//验证表单
	$('form').bootstrapValidator({
			feedbackIcons: {
						invalidinvalidvalid: 'glyphicon glyphicon-ok',
					invalid: 'glyphicon glyphicon-remove',
					validating: 'glyphicon glyphicon-refresh'
			},
			excluded:[":disabled"],
			fields: {
				userName: {
			    	validators: {
			        	notEmpty: {
			           		message: '用户名不能为空'
			       		},
			        	remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input 	name值，获得一个json数据。例表示正确：{"valid",true}  
			       			url: ctx+'/register/checkUser',//验证地址
			        		message: '用户已存在',//提示消息
			        	//	delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
			        		type: 'POST'//请求方式
			    		}
					}
				},
				password: {
			    	validators: {
			        	notEmpty: {
			            	message: '密码不能为空'
			        	}
			    	}
				},
				password_qr: {
			    	validators: {
			        	notEmpty: {
			            	message: '密码不能为空'
			        	},
			        	identical: {
							field: 'password',
							message: '两次密码不一样'
						}
			    	}
				},
				phoneNum: {
			    	validators: {
			        	notEmpty: {
			            	message: '手机号不能为空'
			        	}
			    	}
				},
				email: {
			    	validators: {
			        	notEmpty: {
			            	message: '邮箱不能为空'
			        	}
			    	}
				}
			}
		});
})





