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
		var sno = $("#addsno").val();
		var name = $("#addsname").val();
		var sex = $("#addsex").val();
		var age = $("#addsage").val();
		var dept = $("#addsdept").val();
		var dt = $("#adddt").val();
		if(sno==""||name==""||sex==""||age==""){
			alert("请正确填写信息");
			return;
		}
		$.ajax({
			type: "POST",
			url: "/sscm/addStudents",
			data: { sno:sno,sname:name,ssex:sex,sage:age,sdept:dept,dt:dt },
					success: function(msg) {
						alert("添加成功！");
						resetAttr();
					},
					error: function(a) {
						alert("增加失败");
					}
		});
	});
});
function resetAttr() {
	$("#addsno").val('');
	$("#addsname").val('');
	$("#addsex").val('');
	$("#addsage").val('');
	$("#addsdept").val('');
	$("#adddt").val('');
}