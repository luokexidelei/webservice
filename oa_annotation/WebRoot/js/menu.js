var menu = {
	setting:{
		isSimpleData: true,
        treeNodeKey: "mid",
        treeNodeParentKey: "pid",
        showLine: true,
        root: {
            isRoot: true,
            nodes: []
        }
	},
	loadMenuTree:function(){
		$.post("menuItemAction_showMenuItemByUser.action",null,function(data){
			$("#menuTree").zTree(menu.setting,data.menuList); 
		});
	}
};
$().ready(function(){
	menu.loadMenuTree();
});
