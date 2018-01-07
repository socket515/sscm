
//生成标签页
var tab = new Ext.TabPanel({
    region:'center',
    deferredRender:false,
    activeTab:0,
    resizeTabs:true, // turn on tab resizing
    minTabWidth: 115,
    tabWidth:135,
    enableTabScroll:true,
    html:'<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="queryStudent.html"></iframe>'
});

var randomNum = Math.round(Math.random()*10000);

//载入目标页
function actionFn(node, url) {
    return tab.add({
        'id':node.id,
        'title':node.text,
        closable:true,  //通过html载入目标页
        html:'<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>'
    });
}

Ext.onReady(function() {
    //layout
    var viewport = new Ext.Viewport({
        layout:'border',
        items:[
            new Ext.BoxComponent({
                region:'north',
                el: 'north',
                height:110
            }),new Ext.BoxComponent({
                region:'south',
                el: 'south',
                height:25
            }),{
                region:'west',
                id:'west-panel',
                split:true,
                width: 200,
                minSize: 175,
                maxSize: 400,
                margins:'0 0 0 0',
                layout:'accordion',
                title:'学生选课系统',
                collapsible :true,
                layoutConfig:{
                    animate:true
                },
                items: [
					{
						title:'学生管理',
						border:false,
						html:'<div id="tree1" style="overflow:auto;width:100%;height:100%"></div>'
						//iconCls:'nav'
					},
					{
						title:'教师管理',
						border:false,
						//iconCls:'settings',
						html:'<div id="tree2" style="overflow:auto;width:100%;height:100%"></div>'
					},
					{
						title:'课程管理',
						border:false,
						//iconCls:'settings',
						html:'<div id="tree4" style="overflow:auto;width:100%;height:100%"></div>'
					},
                    {
                        title:'系统公告',
                        border:false,
                        //iconCls:'settings',
                        html:'<div id="tree7" style="overflow:auto;width:100%;height:100%"></div>'
                    },
                    {
                        title:'密码修改',
                        border:false,
                        //iconCls:'settings',
                        html:'<div id="tree6" style="overflow:auto;width:100%;height:100%"></div>'
                    }
                ]
            },
            tab//初始标签页
        ]
    });

    var root3 = new Ext.tree.TreeNode({
        id:"root3",
        text:"根"
    });

    var QueryTeacher= new Ext.tree.TreeNode({
        id:'QueryTeacher',
        icon:'img/im2.gif',
        text:'查看教师信息',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'demandsProcess.html';
                if (!n) { //判断是否已经打开该面板
                    n = actionFn(node, url);
                } else {
                    tab.remove(n);
                    n = tab.getComponent(node.id);
                    n = actionFn(node, url);
                }
                tab.setActiveTab(n);
            }
        }
    });

	var AddTeacher= new Ext.tree.TreeNode({
        id:'AddTeacher',
        icon:'img/im2.gif',
        text:'增加教师信息',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'itemsProcess.html';
                if (!n) { //判断是否已经打开该面板
                    n = actionFn(node, url);
                } else {
                    tab.remove(n);
                    n = tab.getComponent(node.id);
                    n = actionFn(node, url);
                }
                tab.setActiveTab(n);
            }
        }
    });

    var ChangeTeacher= new Ext.tree.TreeNode({
        id:'ChangeTeacher',
        icon:'img/im2.gif',
        text:'修改教师信息',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'returnsProcess.html';
                if (!n) { //判断是否已经打开该面板
                    n = actionFn(node, url);
                } else {
                    tab.remove(n);
                    n = tab.getComponent(node.id);
                    n = actionFn(node, url);
                }
                tab.setActiveTab(n);
            }
        }
    });
	
	var DeleteTeaherProcess= new Ext.tree.TreeNode({
        id:'DeleteTeaherProcess',
        icon:'img/im2.gif',
        text:'删除教师信息',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'returnsProcess.html';
                if (!n) { //判断是否已经打开该面板
                    n = actionFn(node, url);
                } else {
                    tab.remove(n);
                    n = tab.getComponent(node.id);
                    n = actionFn(node, url);
                }
                tab.setActiveTab(n);
            }
        }
    });

    root3.appendChild(QueryTeacher);
	root3.appendChild(AddTeacher);
    root3.appendChild(ChangeTeacher);
	root3.appendChild(DeleteTeaherProcess);
    
    var tree3 = new Ext.tree.TreePanel({
		renderTo:"tree2",
		root:root3,
		animate:true,
		enableDD:false,
		border:false,
		rootVisible:false,
		containerScroll: true
	});

    var root5 = new Ext.tree.TreeNode({
        id:"root5",
        text:"根"
    });

    var QueryCourse= new Ext.tree.TreeNode({
        id:'QueryCourse',
        icon:'img/im2.gif',
        text:'查询课程信息&nbsp;&nbsp;&nbsp;&nbsp;',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'serviceStatistics.html';
                if (!n) { //判断是否已经打开该面板
                    n = actionFn(node, url);
                } else {
                    tab.remove(n);
                    n = tab.getComponent(node.id);
                    n = actionFn(node, url);
                }
                tab.setActiveTab(n);
            }
        }
    });

    var AddCourse= new Ext.tree.TreeNode({
        id:'AddCourse',
        icon:'img/im2.gif',
        text:'增加课程信息&nbsp;&nbsp;&nbsp;&nbsp;',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'itemStatistics.html';
                if (!n) { //判断是否已经打开该面板
                    n = actionFn(node, url);
                } else {
                    tab.remove(n);
                    n = tab.getComponent(node.id);
                    n = actionFn(node, url);
                }
                tab.setActiveTab(n);
            }
        }
    });

	var ChangeCouerse= new Ext.tree.TreeNode({
        id:'ChangeCouerse',
        icon:'img/im2.gif',
        text:'修改课程信息&nbsp;&nbsp;&nbsp;&nbsp;',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'historyOrder.html';
                if (!n) { //判断是否已经打开该面板
                    n = actionFn(node, url);
                } else {
                    tab.remove(n);
                    n = tab.getComponent(node.id);
                    n = actionFn(node, url);
                }
                tab.setActiveTab(n);
            }
        }
    });
	
	var DeleteCourse= new Ext.tree.TreeNode({
        id:'DeleteCourse',
        icon:'img/im2.gif',
        text:'修改课程信息&nbsp;&nbsp;&nbsp;&nbsp;',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'historyOrder.html';
                if (!n) { //判断是否已经打开该面板
                    n = actionFn(node, url);
                } else {
                    tab.remove(n);
                    n = tab.getComponent(node.id);
                    n = actionFn(node, url);
                }
                tab.setActiveTab(n);
            }
        }
    });
	
    root5.appendChild(QueryCourse);
    root5.appendChild(AddCourse);
	root5.appendChild(ChangeCouerse);
	root5.appendChild(DeleteCourse);

    var tree5 = new Ext.tree.TreePanel({
		renderTo:"tree4",
		root:root5,
		animate:true,
		enableDD:false,
		border:false,
		rootVisible:false,
		containerScroll: true
	});

    var root2 = new Ext.tree.TreeNode({
        id:"root2",
        text:"树的根"
    });
	
	var QueryStudent= new Ext.tree.TreeNode({
        id:'QueryStudent',
        icon:'img/user.gif',
        text:'学生信息管理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'queryStudent.html';
                if (!n) { //判断是否已经打开该面板
                    n = actionFn(node, url);
                } else {
                    tab.remove(n);
                    n = tab.getComponent(node.id);
                    n = actionFn(node, url);
                }
                tab.setActiveTab(n);
            }
        }
    });
	
	var AddStudent= new Ext.tree.TreeNode({
        id:'AddStudent',
        icon:'img/user.gif',
        text:'增加学生信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'addstudent.html';
                if (!n) { //判断是否已经打开该面板
                    n = actionFn(node, url);
                } else {
                    tab.remove(n);
                    n = tab.getComponent(node.id);
                    n = actionFn(node, url);
                }
                tab.setActiveTab(n);
            }
        }
    });
	
	root2.appendChild(QueryStudent);
	root2.appendChild(AddStudent);

    var tree2 = new Ext.tree.TreePanel({
        renderTo:"tree1",
        root:root2,    //对应 根节点
        animate:true,
        enableDD:false,
        border:false,
        rootVisible:false,
        containerScroll: true
    });



    var root6 = new Ext.tree.TreeNode({
        id:"root6",
        text:"根"
    });

    var PersonalSetup= new Ext.tree.TreeNode({
        id:'PersonalSetup',
        icon:'img/im2.gif',
        text:'密码修改&nbsp;&nbsp;&nbsp;&nbsp;',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'personalSetup.html';
                if (!n) { //判断是否已经打开该面板
                    n = actionFn(node, url);
                } else {
                    tab.remove(n);
                    n = tab.getComponent(node.id);
                    n = actionFn(node, url);
                }
                tab.setActiveTab(n);
            }
        }
    });

    root6.appendChild(PersonalSetup);

	var tree6 = new Ext.tree.TreePanel({
		renderTo:"tree6",
		root:root6,
		animate:true,
		enableDD:false,
		border:false,
		rootVisible:false,
		containerScroll: true
	});

    var root7 = new Ext.tree.TreeNode({
        id:"root7",
        text:"根"
    });

	var Notice= new Ext.tree.TreeNode({
        id:'Notice',
        icon:'img/im2.gif',
        text:'系统公告&nbsp;&nbsp;&nbsp;&nbsp;',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'notice.html';
                if (!n) { //判断是否已经打开该面板
                    n = actionFn(node, url);
                } else {
                    tab.remove(n);
                    n = tab.getComponent(node.id);
                    n = actionFn(node, url);
                }
                tab.setActiveTab(n);
            }
        }
    });

	root7.appendChild(Notice);

	var tree7 = new Ext.tree.TreePanel({
		renderTo:"tree7",
		root:root7,
		animate:true,
		enableDD:false,
		border:false,
		rootVisible:false,
		containerScroll: true
	});

});
