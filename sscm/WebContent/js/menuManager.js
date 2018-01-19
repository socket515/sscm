
//生成标签页
var tab = new Ext.TabPanel({
    region:'center',
    deferredRender:false,
    activeTab:0,
    resizeTabs:true, // turn on tab resizing
    minTabWidth: 115,
    tabWidth:135,
    enableTabScroll:true,
    html:'<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="transQuery.html"></iframe>'
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
						title:'工作空间',
						border:false,
						html:'<div id="tree1" style="overflow:auto;width:100%;height:100%"></div>'
						//iconCls:'nav'
					},
					{
						title:'流程监控',
						border:false,
						//iconCls:'settings',
						html:'<div id="tree2" style="overflow:auto;width:100%;height:100%"></div>'
					},
					{
						title:'统计信息',
						border:false,
						//iconCls:'settings',
						html:'<div id="tree4" style="overflow:auto;width:100%;height:100%"></div>'
					},
                    {
                        title:'库存管理',
                        border:false,
                        //iconCls:'settings',
                        html:'<div id="tree3" style="overflow:auto;width:100%;height:100%"></div>'
                    },
                    {
                        title:'系统设置',
                        border:false,
                        //iconCls:'settings',
                        html:'<div id="tree5" style="overflow:auto;width:100%;height:100%"></div>'
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

    var DemandsProcess= new Ext.tree.TreeNode({
        id:'DemandsProcess',
        icon:'img/im2.gif',
        text:'事务流程监控',
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

	var ItemsProcess= new Ext.tree.TreeNode({
        id:'ItemsProcess',
        icon:'img/im2.gif',
        text:'订购流程监控',
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

    var ReturnsProcess= new Ext.tree.TreeNode({
        id:'ReturnsProcess',
        icon:'img/im2.gif',
        text:'退货流程监控',
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

    root3.appendChild(DemandsProcess);
	root3.appendChild(ItemsProcess);
    root3.appendChild(ReturnsProcess);
    
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

    var ServiceStatistics= new Ext.tree.TreeNode({
        id:'ServiceStatistics',
        icon:'img/im2.gif',
        text:'事务统计&nbsp;&nbsp;&nbsp;&nbsp;',
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

    var ItemStatistics= new Ext.tree.TreeNode({
        id:'ItemStatistics',
        icon:'img/im2.gif',
        text:'物品统计&nbsp;&nbsp;&nbsp;&nbsp;',
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

	var historyOrder= new Ext.tree.TreeNode({
        id:'historyOrder',
        icon:'img/im2.gif',
        text:'订购历史&nbsp;&nbsp;&nbsp;&nbsp;',
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
	
    root5.appendChild(ServiceStatistics);
    root5.appendChild(ItemStatistics);
	root5.appendChild(historyOrder);

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
	
	var ProblemManage= new Ext.tree.TreeNode({
        id:'ProblemManage',
        icon:'img/user.gif',
        text:'事务处理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'transQuery.html';
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
	
	var DeliveryTracking= new Ext.tree.TreeNode({
        id:'DeliveryTracking',
        icon:'img/user.gif',
        text:'订单处理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'deliveryTracking.html';
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
	
	var ReturnTracking= new Ext.tree.TreeNode({
        id:'ReturnTracking',
        icon:'img/user.gif',
        text:'退货处理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'returnTracking.html';
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

    var AffairReport= new Ext.tree.TreeNode({
        id:'AffairReport',
        icon:'img/user.gif',
        text:'新事务申报&nbsp;&nbsp;&nbsp;&nbsp;',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'demandReport.html';
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
	
	var GoodsReport= new Ext.tree.TreeNode({
        id:'GoodsReport',
        icon:'img/user.gif',
        text:'物品订购申报',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'itemOrder.html';
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
	
	var GoodsReturnReport= new Ext.tree.TreeNode({
        id:'GoodsReturnReport',
        icon:'img/user.gif',
        text:'物品退货申报',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'returnManage.html';
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

	root2.appendChild(ProblemManage);
	root2.appendChild(DeliveryTracking);
	root2.appendChild(ReturnTracking);
    root2.appendChild(AffairReport);
    root2.appendChild(GoodsReport);
    root2.appendChild(GoodsReturnReport);

    var tree2 = new Ext.tree.TreePanel({
        renderTo:"tree1",
        root:root2,    //对应 根节点
        animate:true,
        enableDD:false,
        border:false,
        rootVisible:false,
        containerScroll: true
    });

    var root4 = new Ext.tree.TreeNode({
        id:"root4",
        text:"根"
    });

    var InventoryList= new Ext.tree.TreeNode({
        id:'InventoryList',
        icon:'img/im2.gif',
        text:'在库管理&nbsp;&nbsp;&nbsp;&nbsp;',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'inventoryList.html';
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

	var StorageList= new Ext.tree.TreeNode({
        id:'StorageList',
        icon:'img/im2.gif',
        text:'入库清单&nbsp;&nbsp;&nbsp;&nbsp;',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'storageList.html';
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

	var OutLibraryList = new Ext.tree.TreeNode({
        id:'OutLibraryList',
        icon:'img/im2.gif',
        text:'出库清单&nbsp;&nbsp;&nbsp;&nbsp;',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'outLibraryList.html';
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

	var ReturnList= new Ext.tree.TreeNode({
        id:'ReturnList',
        icon:'img/im2.gif',
        text:'退货清单&nbsp;&nbsp;&nbsp;&nbsp;',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'returnList.html';
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

    root4.appendChild(InventoryList);
	root4.appendChild(StorageList);
	root4.appendChild(OutLibraryList);
	root4.appendChild(ReturnList);

    var tree4 = new Ext.tree.TreePanel({
		renderTo:"tree3",
		root:root4,
		animate:true,
		enableDD:false,
		border:false,
		rootVisible:false,
		containerScroll: true
	});

	var root1 = new Ext.tree.TreeNode({
        id:"root1",
        text:"根"
    });

	var ServicesSetup= new Ext.tree.TreeNode({
        id:'ServicesSetup',
        icon:'img/im2.gif',
        text:'事务设置&nbsp;&nbsp;&nbsp;&nbsp;',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'servicesSetup.html';
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

	var ItemSetup= new Ext.tree.TreeNode({
        id:'ItemSetup',
        icon:'img/im2.gif',
        text:'物品设置&nbsp;&nbsp;&nbsp;&nbsp;',
        listeners:{
            'click':function(node, event) {
                event.stopEvent();
                var n = tab.getComponent(node.id);
                var url = 'itemSetup.html';
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

	root1.appendChild(ServicesSetup);
	root1.appendChild(ItemSetup);

	var tree1 = new Ext.tree.TreePanel({
		renderTo:"tree5",
		root:root1,
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
