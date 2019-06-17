<%--
  Created by IntelliJ IDEA.
  User: glnsh
  Date: 2019/5/7
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>项目需求</title>
</head>
<link rel="stylesheet" type="text/css" href="/easyui/themes/metro/easyui.css">
<link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
<script type="text/javascript" src="/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
    function doSearch() {
        $('#dg').datagrid('load', {
            projectName: $('#projectName').val(),
            equipmentState: $('#equipmentState').val()
        });
    }
</script>
<body>
<div id="tb" style="padding:3px">
    <span>所属项目：</span>
    <input id="projectName" class="easyui-combobox" name="dept" data-options="valueField:'projectName',textField:'projectName',url:'/selectAllProject'">
    <span>设备状态:</span>
    <select id="equipmentState" class="easyui-combobox" name="dept" style="width:200px;">
        <option value="">全部</option>
        <option value="设计选型">设计选型</option>
        <option value="采购">采购</option>
        <option value="制造组装">制造组装</option>
        <option value="安装调试">安装调试</option>
    </select>
    <a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
</div>

<table id="dg" class="easyui-datagrid" title="项目需求" style="width:100%;height:auto"
       data-options="
               url:'/selectEquipmentRequirementByPage',
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
        <th data-options="field:'equipmentName',width:80">设备名称</th>
        <th data-options="field:'equipmentSketch',width:80,align:'left'">设备说明</th>
        <th data-options="field:'projectName',width:140,align:'left'">所属项目</th>
        <th data-options="field:'equipmentState',width:200">设备状态</th>
    </tr>
    </thead>
</table>
</body>
</html>