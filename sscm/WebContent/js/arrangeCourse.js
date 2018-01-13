var state = 0;
var state2 = true;
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
    			"url":"/sscm/teacher/queryCourse",
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
					return '<button class="btns" onclick="detailFunc(' + full.cno +','+ mDataProp +',\''+full.introduction+'\')" >排课</button>';
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
	$("#closemodelsend").click(function() {
		state2 = true;
		$("#tcomment").val('');
		$("#arrangecno").val('');
	});
	$("#sendHaulBtn").click(function() {
		var cno = $("#arrangecno").val();
		var number = $("#anumber").val();
		var atime = $("#atime").val();
		var address = $("#address").val();
		var adate = $("#adate").val();
		var url = "/sscm/teacher/addArrange1"
		if(cno==""||number==""||atime==""||address==""||adate==""){
			alert("请正确输入");
			return;
		}
		if(!state2){
			url = "/sscm/teacher/addArrange2";
			state2 = true;
		}
		$.ajax({
					type: "POST",
					url: url,
					data: { cno:cno,maxnum:number,atime:atime,address:address,sd:adate},
						success: function(msg) {
							if(msg=="true"){
							   alert("开课成功");
							   $("#tcomment").val('');
							   $("#anumber").val();
							   $("#arrangecno").val('');
							   $("#atime").val();
							} else if(msg=="wrong") {
								alert("选课重复错误！注意时间和地点")
							} else if(msg=="false"){
								alert("开课失败");
							}
						},
					error: function(a) {
						alert("开失败");
					}
				});
	});
  
 });
 function detailFunc(cno,states,introduction){
	$("#arrangecno").val(cno);
	state2 = states;
	$("#tcomment").val(introduction);
	$("#updateOverhaul").modal({
        backdrop : 'static',
        keyboard : false
    });
 }
	 


