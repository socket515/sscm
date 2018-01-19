var times = new Array('周一3-4节','周一5-6节','周一7-8节','周二1-2节','周二3-4节','周二5-6节','周二5-6节','周二7-8节', '周三1-2节', '周三3-4节', '周三5-6节', '周三7-8节', '周四1-2节', '周四3-4节', '周四5-6节', '周四7-8节', '周五1-2节', '周五3-4节', '周五5-6节', '周五7-8节');
var address = new Array('1101课室', '1102课室', '1103课室', '1104课室', '1201课室', '1202课室', '1203课室', '1204课室', '1301课室', '1302课室', '1303课室', '1304课室', '1401课室', '1402课室', '1403课室', '1404课室', '1501课室', '1502课室', '1503课室', '1504课室');
$(document).ready( function () {

		var table=$('#table11').DataTable(
        {
        searching: false,//屏蔽datatales的查询框
        aLengthMenu:[5],
        "stateSave": true,
        "bRetrieve": true,
        "ordering": false,//关闭排序
        "pagingType":"simple_numbers",
        "bLengthChange": false,//屏蔽tables的一页展示多少条记录的下拉列表
        "processing": true, //打开数据加载时的等待效果
        "serverSide": true,//打开后台分页
		"bPaginate":true,
        " buttons": [
                   'selectAll',
                   'selectNone'
               ],
         "language": {
                 "lengthMenu": "每页 _MENU_ 条记录",
                 "zeroRecords": "没有找到记录",
                 "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
                 "infoEmpty": "无记录",
                 "infoFiltered": "(从 _MAX_ 条记录过滤)",
                 "search":"搜索:",
                 "paginate": {
                    "first":      "第一页",
                    "last":       "最后一页",
                    "next":       "下一页",
                    "previous":   "上一页"
    },

             },
            // "scrollY": "300px",//滚动宽度
    		//"scrollCollapse": "false",//滚动条
    		"ajax":{
    			"url":"/sscm/student/getArrange",
    		    "dataSrc": "aaData", 
    		    "data": function (d) {
                    d.cno = $('#querycno').val(); 
					d.cname = $('#querycname').val();
					d.type = $('#querytype').val();
					d.tname = $('#querytname').val();
					d.atime = $('#queryatime').val();
					d.address = $('#address').val();	
				}
    		},
//    		"aoColumnDefs": [
//            {
//               sDefaultContent: '',
//               aTargets: [ '_all' ]
//             }
//             ],
    		
    		"aoColumns" :[
				{"mDataProp":"cno"},
    			{"mDataProp":"cname"},
				{"mDataProp":"credit"},
				{
                 "sClass": "text-center",
                 "mDataProp": "type",
                 "render": function (mDataProp, type, full, meta) {
                     if(mDataProp)
						 return '选修';
					 else
						 return '必修';
                 },
                 "bSortable": false
                },
    			{"mDataProp":"tname"},
				{"mDataProp":"anum"},
				{"mDataProp":"maxnum"},
				{
                 "sClass": "text-center",
                 "mDataProp": "atime",
                 "render": function (mDataProp, type, full, meta) {
                     return times[mDataProp];
                 },
                 "bSortable": false
                },
				{
                 "sClass": "text-center",
                 "mDataProp": "address",
                 "render": function (mDataProp, type, full, meta) {
                     return address[mDataProp];
                 },
                 "bSortable": false
                },
				{"mDataProp":"sd"},
				{
                 "sClass": "text-center",
				 "mDataProp":"id",
                 "render": function (mDataProp, type, full, meta) {
					return '<button class="btns" onclick="detailFunc('+mDataProp+','+full.atime+')" >选课</button>';
                 },
                 "bSortable": false
             },
    		],
            
        });
		$("#table_id_example_filter").hide();
		 //按钮查询
	$(document).on("click","#search",function(){
		var cno = $('#querycno').val(); 
		var cname = $('#querycname').val();
		var type = $('#querytype').val();
		var tname = $('#querytname').val();
		var atime = $('#queryatime').val();
		var address = $('#address').val();
		if(cno==""&&cname==""&&type=="-1"&&tname==""&&atime=="-1"&&address=="-1"){
			alert("至少选择一个条件查询");
			return;
		}
	    table.draw();
	});
	$("#closemodel").click(function() {
		$("#deleteHaulId").val('');
		$("#times").val('');
	});
	$("#deleteHaulBtn").click(function() {
		var id = $("#deleteHaulId").val();
		var time = $("#times").val();
		$.ajax({
					type: "POST",
					url: "/sscm/student/selectCourse",
					data: { id:id,time:time},
						success: function(msg) {
							if(msg=="true"){
							   alert("选课成功");
							   $("#deleteHaulId").val('');
							   $("#times").val('');
							} else if(msg=="wrong") {
								alert("选课重复错误！注意时间!")
							} else if(msg=="false"){
								alert("选课失败");
							} else if(msg=="err"){
								alert("连接超时");
							}else{
								alert("连接超时");
								window.top.location.href = 'login.html';
							}
						},
					error: function(a) {
						alert("选课失败");
					}
				});
	});
  
 });
 function detailFunc(id,time){
	$("#deleteHaulId").val(id);
	$("#times").val(time);
	$("#delcfmOverhaul").modal({
        backdrop : 'static',
        keyboard : false
    });
 }
	 


