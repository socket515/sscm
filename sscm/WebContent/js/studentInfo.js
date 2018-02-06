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
		var sno = $("#addsno").val();
		var sname = $("#addsname").val();
		var ssex= $("#addsex").val();
		var sage = $("#addsage").val();
		var sdept = $("#addsdept").val();
		var major = $("#major").val();
		var dt = $("#adddt").val();
		if(sno==""||sname==""||ssex==""||sage==""||sdept==""||dt==""||major==""){
			alert("请正确填写信息");
			return;
		}
		$.ajax({
			type: "POST",
			url: "/sscm/student/updateStudents",
			data: { sno:sno,sname:sname,ssex:ssex,sage:sage,major:major,sdept:sdept,dt:dt},
					success: function(msg) {
						alert("修改成功！");
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
	$("#addsname").removeAttr("readonly");
	$("#addsage").removeAttr("readonly");
	$("#adddt").removeAttr("readonly");
}
function lockAttr(){
	state = 0;
	$("#addsname").attr({"readonly":"readonly"}); 
	$("#addsage").attr({"readonly":"readonly"}); 
	$("#adddt").attr({"readonly":"readonly"}); 
}
function init(){
	$.ajax({
			type: "GET",
			url: "/sscm/student/getStudent",
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
	$("#addsno").val(data.sno);
	$("#addsname").val(data.sname);
	$("#addsex").val(data.ssex);
	$("#addsage").val(data.sage);
	$("#addsdept").val(data.sdept);
	$("#adddt").val(data.dt);
	$("#major").val(data.major);
}