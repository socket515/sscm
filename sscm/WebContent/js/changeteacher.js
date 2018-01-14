function changepassword(){
	var opwd = $("#oldpass").val();
	var npwd = $("#newpass").val();
	var repass = $("#repass").val();
	if(npwd!=repass){
		alert("两次密码不相等");
		return;
	}
	$.ajax({
		type: "POST",
		url: "/sscm/admin/changepassword",
		data:{opwd:opwd,npwd:npwd},
		success: function(msg) {
			if(msg=="true"){
				alert("修改成功！");
			} else if(msg=="wrong"){
				alert("原密码错误！");
			} else {
				alert("失败！");
			}
		},	
		error: function(a) {
			alert("error");
		}
	});
}