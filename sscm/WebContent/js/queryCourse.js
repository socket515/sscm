var state = 0;
var table;
$(document).ready( function () {

		table=$('#table11').DataTable(
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
    			"url":"/sscm/admin/queryCourse",
    		    "dataSrc": "aaData", 
    		    "data": function ( d ) {
                    if(state==1){
						d.cno = $('#outListNum').val();
					}
					else if(state==2){
						d.ctype = $('#ctype').val(); 
						d.cname = $('#sname').val();
					}
					d.state = state;
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
    			{"mDataProp":"credit"},
				{
                 "sClass": "text-center",
				 "mDataProp":"state",
                 "render": function (mDataProp, type, full, meta) {
					 if(mDataProp){
						 return '<button class="btns" disabled="disabled">修改</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btns"'+
						 ' disabled="disabled">删除</button>';
					 } else {
						 return '<button class="btns" onclick="detailFunc(' + full.cno +',\''+full.cname+'\','+ full.credit +','+full.type+',\''+full.introduction+'\')" >修改</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btns" onclick="deletefunc(' + full.cno + ')" >删除</button>';
					 }  
                 },
                 "bSortable": false
             },
    		],
            
        });
		$("#table_id_example_filter").hide();
		 //按钮查询
	$(document).on("click","#search2",function(){
		var sno = $('#outListNum').val();
		if(sno==""){
			alert("请输入课程代码！");
			return;
		}
		state = 1;
	    table.draw();
	    //table.search(args1+" "+args2).draw(false);//保留分页，排序状态

	});
	$(document).on("click","#search",function(){
		var ctype = $('#ctype').val(); 
		var sname = $('#sname').val();
		if(ctype==""&&sname==""){
			alert("请正确输入查询条件！");
			return;
		}
		state = 2;
	    table.draw();
	    //table.search(args1+" "+args2).draw(false);//保留分页，排序状态

	});
	$("#deleteHaulBtn").click(function() {
		var cno = $("#deleteHaulId").val();
		if(cno=="") return;
		$.ajax({
			type: "POST",
			url: "/sscm/admin/deleteCourse",
			data: { cno: cno },
			success: function(msg) {
				table.draw();
				//$("#delcfmOverhaul").modal('hide')
				$("#deleteHaulId").val('');
			},
			error: function(a) {
				//$("#delcfmOverhaul").modal('hide')
				alert("删除失败");
			}
		});
	});
	$("#closemodel").click(function() {
		$("#deleteHaulId").val('');
	});
	$("#closemodelsend").click(function() {
		$("#addcno").val('');
		$("#addcname").val('');
		$("#tcomment").val('');
		$("#addcredit").val('');
	});
	$("#sendHaulBtn").click(function() {
		var cno = $("#addcno").val();
		var name = $("#addcname").val();
		var ctype = $("#addctype").val();
		var comment = $("#tcomment").val();
		var credit = $("#addcredit").val();
		if(cno==""||name==""||comment==""||credit==""||ctype==""){
			alert("请正确输入");
			return;
		}
		$.ajax({
					type: "POST",
					url: "/sscm/admin/updateCourse",
					data: { cno:cno,cname:name,credit:credit,type:ctype,introduction:comment},
						success: function(msg) {
							alert("修改成功");
							table.draw();
						},
					error: function(a) {
						alert("修改失败");
					}
				});
	});
  
 });
 function detailFunc(cno,cname,credit,type,introduction){
	$("#addcno").val(cno);
	$("#addcname").val(cname);
	$("#addcredit").val(credit);
	if(type==true){
		$("#addctype").val(1);
	}else{
		$("#addctype").val(0);
	}
	$("#tcomment").val(introduction);
	$("#updateOverhaul").modal({
        backdrop : 'static',
        keyboard : false
    });
 }
 function deletefunc(sno){
	$("#deleteHaulId").val(sno);
	$("#delcfmOverhaul").modal({
        backdrop : 'static',
        keyboard : false
    });
 }
	 


