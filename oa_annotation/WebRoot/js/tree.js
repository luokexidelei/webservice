var tree = {
    setting : {
        zTree : '',
        pNode : '',
        isSimpleData : true,
        treeNodeKey : "mid",
        treeNodeParentKey : "pid",
        showLine : true,
        root : {
            isRoot : true,
            nodes : []
        },
        callback : {
            expand : function(event, treeId, treeNode) {

                tree.pNode = treeNode;
                tree.loadByPNode();
            }
        }
    },
    /**
     *一次性加载树
     */
    loadTree : function() {
        $.post("menuItemAction_getAllMenuItem.action", null, function(data) {

            $("#tree").zTree(tree.setting, data.menuList);

        });
    },
    /**
     *查询根节点
     */
    loadRootNode : function() {
        var parameter = {
            pid : 0
        };
        $.post("menuItemAction_showMenuItem.action", parameter, function(data) {

            tree.zTree = $("#tree").zTree(tree.setting, data.menuList);

        });
    },
    /**
     *追加子节点
     */
    loadByPNode : function() {
        var parameter = {
            pid : tree.pNode.mid
        };
        if (!tree.zTree.getNodeByParam("pid", tree.pNode.mid)) {
            $.post("menuItemAction_showMenuItem.action", parameter, function(data) {

                /**
                 *吧查询出来的子节点追加到父节点
                 */
                tree.zTree.addNodes(tree.pNode, data.menuList, true);
            });
        }
    }
};
$().ready(function() {
    tree.loadRootNode();
});
