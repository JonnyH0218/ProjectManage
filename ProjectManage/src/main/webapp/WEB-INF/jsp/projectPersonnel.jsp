<%--
  Created by IntelliJ IDEA.
  User: glnsh
  Date: 2019/5/7
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>项目人员</title>
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
            personnelType: $('#personnelType').val()
        });
    }

    function formatOper(val,row,index) {
        return '<a href="#" onclick="editUser('+index+')">删除</a>';
    }

    function editUser(index){
        $('#dg').datagrid('selectRow',index);// 关键在这里
        var row = $('#dg').datagrid('getSelected');
        if (row){
            $.messager.confirm("提示", "你确定要删除吗?", function (r) {
                if (r) {
                   $.ajax({
                       type: "POST",
                       url: "/deletePersonnel",
                       data:"id="+row.id,
                       success:function(data){
                           window.location.reload();
                           $.messager.confirm("删除成功")
                       },
                       error:function(data){
                           $.messager.confirm(data)
                       }
                   })
                }
            });

        }
    }
    function addPersonnel() {
        //打开一个对话框
        $('#dlg').dialog('open').dialog('setTitle', '添加项目人员');
        $('#fm').form('clear');
        url = '/addPersonnel';
    }
    function savePersonnel() {
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
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addPersonnel()">添加项目人员</a>
    <span>所属项目：</span>
    <input id="projectName" class="easyui-combobox" name="dept" data-options="valueField:'projectName',textField:'projectName',url:'/selectAllProject'">
    <span>人员类型:</span>
    <input id="personnelType" style="line-height:26px;border:1px solid #ccc">
    <a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
</div>
<div id="dlg" class="easyui-dialog" style="width:70%;height: 70%" data-options="closed:true,modal:true,resizable:true,border:'thin',buttons:'#dlg-buttons'">
    <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
        <div style="margin-bottom:10px">
            <input name="projectName"  label="选择项目：" class="easyui-combobox" name="dept" data-options="valueField:'projectName',textField:'projectName',url:'/selectAllProject'">
        </div>
        <div style="margin-bottom:10px">
            <input name="personnelName" class="easyui-textbox"  label="人员姓名："style="width:50%">
        </div>
        <div style="margin-bottom:10px">
            <input name="personnelType" class="easyui-textbox"  label="人员类型："style="width:50%">
        </div>
    </form>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="savePersonnel()">Save</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
           onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
    </div>
</div>
<table id="dg" class="easyui-datagrid" title="项目列表" style="width:100%;height:auto"
       data-options="
               url:'/selectPersonnelByPage',
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
        <th data-options="field:'personnelName',width:80">姓名</th>
        <th data-options="field:'projectName',width:80,align:'left'">所属项目</th>
        <th data-options="field:'personnelType',width:140,align:'left'">人员类型</th>
        <th data-options="field:'_operate',width:80,align:'center',formatter:formatOper">操作</th>
    </tr>
    </thead>
</table>
</body>
</html>
