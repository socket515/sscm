var state = 0;
$(document).ready( function () {
	init();
	$("#addsend").click(function() {
		if(state==0){return;}
		$("#addsure").modal({
			backdrop : 'static',
			keyboard : false
		});
	});
	$("#addreset").click(function() {
		changeAttr();
	});
	$("#cancle").click(function(){
		lockAttr();
	});
	$("#addHaulBtn").click(function() {
		var sno = $("#tnoinfo").val();
		var name = $("#tnameinfo").val();
		var dept = $("#tdeptinfo").val();
		var dt = $("#dtinfo").val();
		var comment = $("#tcomment").val();
		if(sno==""||name==""||dt==""){
			alert("请正确填写信息");
			return;
		}
		$.ajax({
			type: "POST",
			url: "/sscm/teacher/changeTeacher",
			data: { tno:sno,tname:name,tdept:dept,dt:dt,tcomment:comment },
					success: function(msg) {
						if (msg=="false"){
							alert("修改失败！");
						} else{
							alert("修改成功！");
						}
						lockAttr();
					},
					error: function(a) {
						alert("修改失败");
					}
		});
	});
});
function changeAttr() {
	state = 1;
	$("#tnameinfo").removeAttr("readonly"); 
	$("#dtinfo").removeAttr("readonly");
	$("#tcomment").removeAttr("readonly"); 
}
function lockAttr(){
	state = 0;
	$("#tnameinfo").attr({"readonly":"readonly"}); 
	$("#dtinfo").attr({"readonly":"readonly"});
	$("#tcomment").attr({"readonly":"readonly"}); 
}
function init(){
	state = 0;
	$.ajax({
			type: "GET",
			url: "/sscm/teacher/getTeacher",
			success: function(msg) {
				if(msg!=""){
					var data = eval('(' + msg + ')');
					initData(data);	
				}else{
					alert("登录超时")
					window.top.location.href = 'login.html';
				}
			},
			error: function(a) {
				alert("登录超时aaaa")
				window.top.location.href = 'login.html';
			}
		});
}

function initData(data){
	$("#tnoinfo").val(data.tno);
	$("#tnameinfo").val(data.tname);
	$("#tdeptinfo").val(data.tdept);
	$("#dtinfo").val(data.dt);
	$("#tcomment").val(data.tcomment);
}