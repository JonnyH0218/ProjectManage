<%--
  Created by IntelliJ IDEA.
  User: glnsh
  Date: 2019/5/8
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>项目记录</title>
</head>
<link rel="stylesheet" type="text/css" href="/easyui/themes/metro/easyui.css">
<link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="/easyui/demo/demo.css">
<script type="text/javascript" src="/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
    function doSearch() {
        $('#dg').datagrid('load', {
            projectName: $('#projectName').val(),
            recordCategory: $('#recordCategory1').val(),
        });
    }
    function exportExecl() {
       var url = "exportExcel?projectName="+$('#projectName').val();
       window.location = url;
    }

    function formatOper(val,row,index) {
        return '<a href="#" id="btn" onclick="editUser(\'+index+\')">查看</a>';
    }

    $('#btn').linkbutton({
        iconCls: 'icon-search'
    });
    function editUser(index){
        $('#dg').datagrid('selectRow',index);// 关键在这里
        var row = $('#dg').datagrid('getSelected');
        if (row){
            $('#win').window({
                href: "selectRecordById?id="+row.id,
                title:"日志",
                width:600,
                height:400,
                modal:true,
                content:'解决办法'
            })
        }
    }
    function saveRecord() {
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

    function addRecord() {
        //打开一个对话框
        $('#dlg').dialog('open').dialog('setTitle', '添加项目记录');
        $('#fm').form('clear');
        url = '/addRecord';
    }
</script>
<body>
<div id="tb" style="padding:3px">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addRecord()">添加记录</a>
    <span>所属项目：</span>
    <input id="projectName" class="easyui-combobox" name="dept" data-options="valueField:'projectName',textField:'projectName',url:'/selectAllProject'">
    <span>记录类别</span>
    <select id="recordCategory1" class="easyui-combobox" name="dept" style="width:200px;">
        <option value="">全部</option>
        <option value="日志">日志</option>
        <option value="周报">周报</option>
    </select>
    <a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
    <a href="#" class="easyui-linkbutton" plain="true" onclick="exportExecl()">下载</a>
</div>
<div id="dlg" class="easyui-dialog" style="width:70%;height: 70%" data-options="closed:true,modal:true,resizable:true,border:'thin',buttons:'#dlg-buttons'">
    <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
        <div style="margin-bottom:10px">
            <input name="projectName"  label="选择项目：" class="easyui-combobox" name="dept" data-options="valueField:'projectName',textField:'projectName',url:'/selectAllProject'">
        </div>
        <div style="margin-bottom:10px">
            <span>项目组件：</span>
            <select id="recordCategory" class="easyui-combobox" name="dept" style="width:200px;">
                <option value="日志">日志</option>
                <option value="周报">周报</option>
            </select>
        </div>
        <div style="margin-bottom:10px">
            <input name="problemDescribe" class="easyui-textbox"  label="具体描述："style="width:70%;height:60px">
        </div>
    </form>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveRecord()">Save</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
           onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
    </div>
</div>
<table id="dg" class="easyui-datagrid" title="项目列表" style="width:100%;height:auto"
       data-options="
               url:'/selectRecordByPage',
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
        <th data-options="field:'projectName',width:80">所属项目</th>
        <th data-options="field:'projectCharger',width:80,align:'left'">项目负责人</th>
        <th data-options="field:'recordCategory',width:80,align:'left'">记录类别</th>
        <th data-options="field:'founder',width:80,align:'left'">创建人</th>
        <th data-options="field:'createTime',width:150">创建时间</th>
        <th data-options="field:'_operate',width:80,align:'center',formatter:formatOper">操作</th>
    </tr>
    </thead>
</table>
<div id="win">

</div>
</body>
</html>