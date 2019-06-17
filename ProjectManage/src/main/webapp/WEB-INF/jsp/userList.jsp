<%--
  Created by IntelliJ IDEA.
  User: glnsh
  Date: 2019/5/7
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
</head>
<link rel="stylesheet" type="text/css" href="/easyui/themes/metro/easyui.css">
<link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
<script type="text/javascript" src="/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
    function doSearch() {
        $('#dg').datagrid('load', {
            userName: $('#userName').val(),
            role: $('#role').val()
        });
    }
</script>
<body>
<div id="tb" style="padding:3px">
    <span>用户名：</span>
    <input id="userName" style="line-height:26px;border:1px solid #ccc">
    <span>权限：</span>
    <input id="role" style="line-height:26px;border:1px solid #ccc">
    <a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
</div>

<table id="dg" class="easyui-datagrid" title="项目列表" style="width:100%;height:auto"
       data-options="
               url:'/selectAllUserByPage',
               method:'get',
               border:false,
               singleSelect:true,
               pagination:true,
               fit:true,
               pageSize:25,
               pageList:[25,15,10],
               fitColumns:true"
>
    <thead>

    <tr>
        <th data-options="field:'id',width:80">序号</th>
        <th data-options="field:'userName',width:80">用户名</th>
        <th data-options="field:'role',width:80,align:'left'">权限</th>
        <th data-options="field:'email',width:140,align:'left'">邮箱</th>
        <th data-options="field:'lastTime',width:200">最近登陆时间</th>
    </tr>
    </thead>
</table>
</body>
</html>
