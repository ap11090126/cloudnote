function userLogin(){
			//alert("绑定成功");
		var name=$("#count").val().trim();
		var password=$("#password").val().trim();
		$("#count_span").html("");
		$("#password_span").html("");
		//alert(name+","+password);
		var ok=true;
		if(name==""){
			$("#count_span").html("用户名不能为空");
			ok=false;
		}
		if(password==""){
			$("#password_span").html("用户名不能为空");
			ok=false;
		}
		if(ok){
			$.ajax({
				url:path+"/user/login.do",
				type:"post",
				data:{"name":name,"password":password},
				dataType:"json",
				success:function(result){
					//result是服务器返回的JSON结果
					if(result.status==0){
						var userId=result.data.cn_user_id;
						addCookie("userId",userId,2);
						window.location.href="edit.html";
						
					}else if(result.status==1){
						$("#count_span").html(result.msg);
					}else if(result.status==2){
						$("#password_span").html(result.msg);
					}
				},
				error:function(){
					alert("登陆失败");
				}
			});
		}
	}
