<%--
  Created by IntelliJ IDEA.
  User: glnsh
  Date: 2019/4/16
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>项目列表</title>
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
            projectState: $('#projectState').val()
        });
    }

    function addProject() {
        //打开一个对话框
        $('#dlg').dialog('open').dialog('setTitle', '添加项目问题');
        $('#fm').form('clear');
        url = '/addProject';
    }

    function saveProject() {
        $('#fm').form('submit', {
            url: url,
            success: function (data) {
                $.messager.alert({
                    title: 'message',
                    msg: data
                });
                $('#dlg').dialog('close');        // close the dialog
                $('#dg').datagrid('reload');    // reload the user data
            }

        });
    }
</script>
<body>
<div id="tb" style="padding:3px">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addProject()">添加项目</a>
    <span>项目名称:</span>
    <input id="projectName" style="line-height:26px;border:1px solid #ccc">
    <span>项目状态:</span>
    <input id="projectState" style="line-height:26px;border:1px solid #ccc">
    <a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
</div>
<div id="dlg" class="easyui-dialog" style="width:70%;height: 70%" data-options="closed:true,modal:true,resizable:true,border:'thin',buttons:'#dlg-buttons'">
    <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
        <div style="margin-bottom:10px">
            <input name="projectName"  class="easyui-textbox" label="项目名称：" style="width: 50%">
        </div>
        <div style="margin-bottom:10px">
            <input name="signAdress" class="easyui-textbox"  label="签署地："style="width:50%">
        </div>
        <div style="margin-bottom:10px">
            <input name="signTime" class="easyui-datebox"  label="签署时间："style="width:50%">
        </div>
        <div style="margin-bottom:10px">
            <input name="projectDescribe" class="easyui-textbox"  label="项目描述："style="width:70%;height:60px">
        </div>
        <div style="margin-bottom:10px">
            <input name="customer" class="easyui-textbox"  label="合作方："style="width:50%">
        </div>
        <div style="margin-bottom:10px">
            <input name="projectCharger" class="easyui-textbox"  label="负责人："style="width:50%">
        </div>
    </form>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveProject()">Save</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
           onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
    </div>
</div>
<table id="dg" class="easyui-datagrid" title="项目列表" style="width:100%;height:auto"
       data-options="
               url:'/findProjectByPage',
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
        <th data-options="field:'projectName',width:80">项目名称</th>
        <th data-options="field:'projectCharger',width:80,align:'left'">项目负责人</th>
        <th data-options="field:'projectState',width:140,align:'left'">项目状态</th>
        <th data-options="field:'creatTime',width:200">创建时间</th>
    </tr>
    </thead>
</table>
</body>
</html>
