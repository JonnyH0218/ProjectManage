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
    <title>文档下载</title>
</head>
<link rel="stylesheet" type="text/css" href="/easyui/themes/metro/easyui.css">
<link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
<script type="text/javascript" src="/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
    function doSearch() {
        $('#dg').datagrid('load', {
            ProjectName: $('#projectName').val(),
        });
    }
    function formatOper(val, row, index) {
        return '<a href="#" onclick="downloads(' + row.id + ')">下载</a>';
    }

    function downloads(id) {
        var url = "/downloadFiles?id=" + id;
        window.location = url;
    }
</script>
<body>
<div id="tb" style="padding:3px">
    <span>所属项目：</span>
    <input id="ProjectName" class="easyui-combobox" name="dept" data-options="valueField:'projectName',textField:'projectName',url:'/selectAllProject'">
    <a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
</div>
</body>
<table id="dg" class="easyui-datagrid" title="文档列表" style="width:100%;height:auto"
       data-options="
               url:'/selectFilesByPage',
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
        <th data-options="field:'fileName',width:200">文档名称</th>
        <th data-options="field:'createTime',width:80,align:'left'">创建时间</th>
        <th data-options="field:'projectName',width:80,align:'left'">文档名称</th>
        <th data-options="field:'_operate',width:80,align:'center',formatter:formatOper">下载</th>
    </tr>
    </thead>
</table>
</html>
