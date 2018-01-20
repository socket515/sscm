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
		var cno = $("#addcno").val();
		var name = $("#addcname").val();
		var type = $("#addctype").val();
		var credit = $("#addcreditt").val();
		var introduction = $("#tcomment").val();
		if(cno==""||name==""||credit==""||type==""){
			alert("请正确填写信息");
			return;
		}
		$.ajax({
			type: "POST",
			url: "/sscm/admin/addStudents",
			data: { cno:cno,cname:name,credit:credit,type:type,introduction:introduction},
					success: function(msg) {
						if (msg=="false"){
							alert("添加失败！");
						} else if(msg=="true"){
							alert("添加成功！");
							resetAttr();
						}else if(msg=="key"){
							alert("学号不要重复");
						}
						resetAttr();
					},
					error: function(a) {
						alert("增加失败");
					}
		});
	});
});
function resetAttr() {
	$("#addcno").val('');
	$("#addcname").val('');
	$("#addctype").val('');
	$("#addcreditt").val('');
	$("#tcomment").val('');
}