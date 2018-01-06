var state = 0;
$(document).ready( function () {

    var table=$('#table11').DataTable(
        {
        searching: false,//屏蔽datatales的查询框
        aLengthMenu:[10],
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
    			"url":"/sscm/queryStudents",
    		    "dataSrc": "aaData", 
    		    "data": function ( d ) {
                    if(state==1){
						d.sno = $('#outListNum').val();
					}
					else if(state==2){
						d.sdept = $('#sdept').val(); 
						d.sname = $('#sname').val();
						d.sdate = $('#sdate').val();
						d.edate = $('#edate').val();
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
				{"mDataProp":"sno"},
    			{"mDataProp":"sname"},
    			{
                 "sClass": "text-center",
                 "mDataProp": "ssex",
                 "render": function (mDataProp, type, full, meta) {
                     if(mDataProp==true)
						 return '男';
					 else
						 return '女';
                 },
                 "bSortable": false
             },
    			{"mDataProp":"sage"},
				{"mDataProp":"dt"},
    			{"mDataProp":"sdept"},
				{
                 "sClass": "text-center",
                 "mDataProp": "sno",
                 "render": function (mDataProp, type, full, meta) {
                     return '<button class="btn" value="' + mDataProp + '" >详情</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn" value="' + mDataProp + '" >删除</button>';
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
			alert("请输入学号！");
			return;
		}
		state = 1;
	    table.draw();
	    //table.search(args1+" "+args2).draw(false);//保留分页，排序状态

	});
	$(document).on("click","#search",function(){
		var sdept = $('#sdept').val(); 
		var sname = $('#sname').val();
		var sdate = $('#sdate').val();
		var edate = $('#edate').val();
		if(sdept==""&&sname==""&&sdate==""&&edate==""){
			alert("请正确输入查询条件！");
			return;
		}
		state = 2;
	    table.draw();
	    //table.search(args1+" "+args2).draw(false);//保留分页，排序状态

	});
  
 });


