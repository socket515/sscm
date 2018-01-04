//设置树的点击事件
function treeClick(node,e) {
	 if(node.isLeaf()){
		e.stopEvent();
		var n = tab.getComponent(node.id);
		if (!n) {
			var n = tab.add({
				'id' : node.id,
				'title' : node.text,
				closable:true,
				html : '我是"'+node.text+'"'
				});
		}
		tab.setActiveTab(n);
	 }
}

//生成标签页
var tab = new Ext.TabPanel({
			region:'center',
			deferredRender:false,
			activeTab:0,
			resizeTabs:true, // turn on tab resizing
			minTabWidth: 115,
			tabWidth:135,
			enableTabScroll:true
		});

Ext.onReady(function(){
   //layout
   var viewport = new Ext.Viewport({
		layout:'border',
		items:[
			new Ext.BoxComponent({
				region:'north',
				el: 'north',
				height:80
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
			title:'系统菜单',
			collapsible :true,
			layoutConfig:{
				animate:true
				},
		    items: [
			    {
					title:'EXT控件使用',
					border:false,
					html:'<div id="tree-div" style="overflow:auto;width:100%;height:100%"></div>'
					//iconCls:'nav'
			    },{
					title:'信息中心',
					border:false,
					//iconCls:'settings',
					html:'<div id="tree" style="overflow:auto;width:100%;height:100%"></div>'
			    },{
					title:'系统设置',
					border:false,
					//iconCls:'settings',
					html:'<div id="tree3" style="overflow:auto;width:100%;height:100%"></div>'
			    }]
			},
	        tab//初始标签页
		 ]
	});

	//设置树形面板
	var Tree = Ext.tree;
	// set the root node
	var root = new Tree.AsyncTreeNode({
		text: 'Ext JS',
		draggable:false,
		id:'root'
	});

	var tree = new Tree.TreePanel({
		el:'tree-div',
		autoScroll:true,
		root:root,
		animate:true,
		enableDD:false,
		border:false,
		rootVisible:false,
		containerScroll: true,
		loader: new Tree.TreeLoader({
			dataUrl:'treedata.php'
		})
	});

    tree.setRootNode(root);
	// render the tree
	tree.render();
	root.expand();
	tree.on('click',treeClick);

    //tree2
    var root2=new Ext.tree.TreeNode({
		    id:"root2",
		    text:"树的根"
		});

    var c1=new Ext.tree.TreeNode({
		id:'c1',
		icon:'img/im2.gif',
		text:'信息征集'
	});

    var c2=new Ext.tree.TreeNode({
		id:'c2',
		icon:'img/im2.gif',
		text:'bug征集'
	});


    var c22=new Ext.tree.TreeNode({
		id:'c22',
		icon:'img/im2.gif',
		text:'实例征集'
	});

    var c3=new Ext.tree.TreeNode({
		id:'c3',
		icon:'img/im2.gif',
		text:'给我留言'
	});

    var c4=new Ext.tree.TreeNode({
		id:'c4',
		icon:'img/im2.gif',
		text:'留言列表'
	});

	var c5=new Ext.tree.TreeNode({
		id:'c5',
		text:'更新公告'
	});

    var root3=new Ext.tree.TreeNode({
		    id:"root3",
		    text:"根"
		});
	c1.appendChild(c2);
    c1.appendChild(c22);
	root2.appendChild(c1);
    root2.appendChild(c3);
    root2.appendChild(c4);
    root3.appendChild(c5);

	var tree2=new Ext.tree.TreePanel({
		renderTo:"tree",
		root:root2,
		animate:true,
		enableDD:false,
		border:false,
		rootVisible:false,
		containerScroll: true
	});

   var tree3=new Ext.tree.TreePanel({
		renderTo:"tree3",
		root:root3,
		animate:true,
		enableDD:false,
		border:false,
		rootVisible:false,
		containerScroll: true
	});

	//end loding
	setTimeout(
				function() {
					Ext.get('loading').remove();
					Ext.get('loading-mask').fadeOut({remove:true});
				}, 250
			  );
});