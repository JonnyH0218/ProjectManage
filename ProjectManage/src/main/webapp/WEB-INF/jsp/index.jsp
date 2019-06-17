<%--
  Created by IntelliJ IDEA.
  User: glnsh
  Date: 2019/4/19
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>项目管理系统</title>
    <link rel="stylesheet" type="text/css" href="/easyui/themes/metro/easyui.css">
    <link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
    <script type="text/javascript" src="/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"></script>
   <%-- <script type="text/javascript">
        //在此拿到jsAPI权限验证配置所需要的信息
        var _config = <%= com.alibaba.dingtalk.openapi.demo.auth.AuthHelper.getConfig(request) %>;
    </script>--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/zepto.min.js"></script>
    <script type="text/javascript" src="http://g.alicdn.com/dingding/open-develop/1.6.9/dingtalk.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/logger.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/demo.js"></script>
</head>



<body class="easyui-layout">
<div title="企业项目管理系统" data-options="region:'north'" style="height: 15%">企业项目管理系统</div>
<div title="系统菜单" data-options="region:'west'" style="width: 15%">
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
                                        content:'<iframe frameborder="0" height="100%" width="100%" src="'+treeNode.page+'"></iframe>'
                                    });
                                }
                            }
                        }
                    }
                };
                //发送ajax请求，获取json数据
                //jQuery提供 的ajax方法：ajax、post、get、load、getJSON、getScript
                var url = "${pageContext.request.contextPath}/json/tree.json";
                $.get(url,{},function(data){
                    //调用API初始化ztree
                    $.fn.zTree.init($("#ztree3"), setting3, data);
                },'json');
            });
        </script>
</div>
<div data-options="region:'center'">
    <div class="easyui-tabs" data-options="fit:true" id="mytabs">
    </div>

</div>
</body>
</html>
