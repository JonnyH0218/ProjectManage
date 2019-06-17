<%--
  Created by IntelliJ IDEA.
  User: glnsh
  Date: 2019/5/26
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的消息</title>
</head>
<link rel="stylesheet" type="text/css" href="/easyui/themes/metro/easyui.css">
<link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
<script type="text/javascript" src="/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<body>

</body>
<table id="dg" class="easyui-datagrid" title="项目列表" style="width:100%;height:auto"
       data-options="
               url:'/showAllMessageByUser',
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
        <th data-options="field:'id',width:80">消息ID</th>
        <th data-options="field:'content',width:200">消息内容</th>
        <th data-options="field:'messageHandler',width:80,align:'left'">消息处理人</th>
        <th data-options="field:'founder',width:80,align:'left'">消息接收人</th>
        <th data-options="field:'createTime',width:140">创建时间</th>
    </tr>
    </thead>
</table>
</html>
