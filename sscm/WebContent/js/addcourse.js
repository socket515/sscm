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
		var creditt = $("#addcreditt").val();
		var comment = $("#tcomment").val();
		if(cno==""||name==""||creditt==""){
			alert("请正确填写信息");
			return;
		}
		$.ajax({
			type: "POST",
			url: "/sscm/admin/addCourse",
			data: { cno:cno,cname:name,type:type,credit:creditt,introduction:comment },
					success: function(msg) {
						if (msg=="false"){
							alert("添加失败！");
						} else if(msg=="true"){
							alert("添加成功！");
							resetAttr();
						}else if(msg=="key"){
							alert("课程代码不要重复");
						}
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
	$("#addcreditt").val('');
	$("#tcomment").val('');
}