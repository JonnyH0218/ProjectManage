<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>easyui测试页面</title>
</head>
<link rel="stylesheet" type="text/css" href="/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
<script type="text/javascript" src="/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"></script>
<script type="text/javascript">
    $(function () {
        //页面加载完毕后，为按钮绑定事件
        $("#but1").click(function () {
            //判断系统管理选项卡是否存在
           var e = $("#mytabs").tabs("exists","系统管理");
           if (e){
               $("#mytabs").tabs("select","系统管理")
           }else{
               //调用tabs对象的add方法动态添加一个选项卡
               $("#mytabs").tabs("add",{
                   title:'系统管理',
                   iconCls:'icon-edit',
                   closable:true,
                   content:'<iframe frameborder="0" width="100%" height="100%" src="https://www.baidu.com"></iframe>'
               });
           }
        });

    });

</script>

<body class="easyui-layout">
<div title="企业项目管理系统" data-options="region:'north'" style="height: 15%">北部区域</div>
<div title="系统菜单" data-options="region:'west'" style="width: 15%">
    <%--制作accordion折叠面板
        fit:true自适应（填充父容器）
    --%>
    <div class="easyui-accordion" data-options="fit:true">
        <div data-options="iconCls:'icon-redo'" title="面板一">111</div>
        <a id="but1" class="easyui-linkbutton">添加一个选项卡</a>
        <div  title="面板二">
            <!-- 展示ztree效果 :使用标准json数据构造ztree-->
            <ul id="ztree1" class="ztree"></ul>
            <script type="text/javascript">
                $(function(){
                    //页面加载完成后，执行这段代码----动态创建ztree
                    var setting = {};
                    //构造节点数据
                    var zNodes = [
                        {"name":"节点一","children":[
                                {"name":"节点一_1"},
                                {"name":"节点一_2"}
                            ]},//每个json对象表示一个节点数据
                        {"name":"节点二"},
                        {"name":"节点三"}
                    ];
                    //调用API初始化ztree
                    $.fn.zTree.init($("#ztree1"), setting, zNodes);
                });
            </script>
        </div>
        <div title="面板三">
            <!-- 展示ztree效果 :使用简单json数据构造ztree-->
            <ul id="ztree2" class="ztree"></ul>
            <script type="text/javascript">
                $(function(){
                    //页面加载完成后，执行这段代码----动态创建ztree
                    var setting2 = {
                        data: {
                            simpleData: {
                                enable: true//使用简单json数据构造ztree节点
                            }
                        }
                    };
                    //构造节点数据
                    var zNodes2 = [
                        {"id":"1","pId":"2","name":"节点一"},//每个json对象表示一个节点数据
                        {"id":"2","pId":"3","name":"节点二"},
                        {"id":"3","pId":"0","name":"节点三"}
                    ];
                    //调用API初始化ztree
                    $.fn.zTree.init($("#ztree2"), setting2, zNodes2);
                });
            </script>
        </div>
        <div title="面板四">
            <!-- 展示ztree效果 :发送ajax请求获取简单json数据构造ztree-->
            <ul id="ztree3" class="ztree"></ul>
            <script type="text/javascript">
                $(function(){
                    //页面加载完成后，执行这段代码----动态创建ztree
                    var setting3 = {
                        data: {
                            simpleData: {
                                enable: true//使用简单json数据构造ztree节点
                            }
                        },
                        callback: {
                            //为ztree节点绑定单击事件
                            onClick: function(event, treeId, treeNode){
                                if(treeNode.page != undefined){
                                    //判断选项卡是否已经存在
                                    var e = $("#mytabs").tabs("exists",treeNode.name);
                                    if(e){
                                        //已经存在，选中
                                        $("#mytabs").tabs("select",treeNode.name);
                                    }else{
                                        //动态添加一个选项卡
                                        $("#mytabs").tabs("add",{
                                            title:treeNode.name,
                                            closable:true,
                                            content:'<iframe frameborder="0" height="100%" width="100%" src="https://www.baidu.com"></iframe>'
                                        });
                                    }
                                }
                            }
                        }
                    };

                    //发送ajax请求，获取json数据
                    //jQuery提供 的ajax方法：ajax、post、get、load、getJSON、getScript
                    var url = "${pageContext.request.contextPath}/json/project.json";
                    $.post(url,{},function(data){
                        //调用API初始化ztree
                        $.fn.zTree.init($("#ztree3"), setting3, data);
                    },'json');
                });
            </script>
        </div>
    </div>
</div>
<div data-options="region:'center'">
    <%-- 制作一个tabs选项卡面板 --%>
        <div class="easyui-tabs" data-options="fit:true" id="mytabs">
            <div data-options="iconCls:'icon-redo'" title="面板一">111</div>
            <div data-options="closable:true" title="面板二" data-options="">222</div>
            <div title="面板三">333</div>
        </div>
</div>
<%--
<div data-options="region:'east'" style="width: 15%">东部区域</div>
<div data-options="region:'south'" style="height: 10%">南部区域</div>
--%>
</body>
</html>

