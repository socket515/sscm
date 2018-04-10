$(document).ready( function () {
	$("#addsend").click(function() {
		$("#addsure").modal({
			backdrop : 'static',
			keyboard : false
		});
	});
	$("#addreset").click(function() {
		resetAttr();
	});
	$("#addHaulBtn").click(function() {
		var sno = $("#addtno").val();
		var name = $("#addtname").val();
		var dept = $("#addtdept").val();
		var dt = $("#adddt").val();
		var comment = $("#tcomment").val();
		if(sno==""||name==""){
			alert("请正确填写信息");
			return;
		}
		$.ajax({
			type: "POST",
			url: "/sscm/admin/addTeacher",
			data: { tno:sno,tname:name,tdept:dept,dt:dt,tcomment:comment },
					success: function(msg) {
						if(msg=="true"){
							alert("添加成功！");
							resetAttr();
						}else(msg=="key"){
							alert("教师工号不要重复");
						}
					},
					error: function(a) {
						alert("增加失败");
					}
		});
	});
});
function resetAttr() {
	$("#addtno").val('');
	$("#addtname").val('');
	$("#addtdept").val('');
	$("#adddt").val('');
	$("#tcomment").val('');
}