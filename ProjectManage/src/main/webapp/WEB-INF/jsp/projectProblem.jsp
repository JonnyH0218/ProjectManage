<%--
  Created by IntelliJ IDEA.
  User: glnsh
  Date: 2019/5/7
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>项目问题</title>
</head>
<link rel="stylesheet" type="text/css" href="/easyui/themes/metro/easyui.css">
<link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
<script type="text/javascript" src="/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
    function doSearch() {
        $('#dg').datagrid('load', {
            ProblemPriority: $('#problemPriority').val(),
            ProjectName: $('#projectName').val(),
            ProjectAssembly: $('#projectAssembly1').val(),
            ProblemState: $('#problemState').val(),
        });
    }

    function addProblem() {
        //打开一个对话框
        $('#dlg').dialog('open').dialog('setTitle', '添加项目问题');
        $('#fm').form('clear');
        url = '/addProblem';
    }

    function formatOper(val,row,index) {
        var url = '<a id="btn" href="#" class="easyui-linkbutton" onclick="editUser(\'+index+\')">查看</a>'
        $('#btn').linkbutton({
            iconCls: 'icon-search'
        });
        return url;
    }

    function editUser(index){
        $('#dg').datagrid('selectRow',index);// 关键在这里
        var row = $('#dg').datagrid('getSelected');
        if (row){
            $('#win').window({
                href: "findProblemById?id="+row.id,
                title:"项目问题",
                width:600,
                height:400,
                modal:true,
            })
        }
    }
    function saveProblem() {
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

    function addProblemSolution() {
        //打开一个对话框
        $('#dlg1').dialog('open').dialog('setTitle', '添加解决方案');
        $('#fm1').form('clear');
        url = '/addProblemSolution';
    }

    function saveProblemSolution(){
        $('#fm1').form('submit', {
            url: url,
            success: function (data) {
                $.messager.alert({
                    title: 'message',
                    msg: data
                });
                $('#dlg1').dialog('close');        // close the dialog
                $('#dg').datagrid('reload');    // reload the user data
            }

        });
    }
</script>
<body>
<div id="tb" style="padding:3px">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addProblem()">添加问题</a>
    <span>优先级：</span>
    <select id="ProblemPriority" class="easyui-combobox" name="dept" style="width:200px;">
        <option value="">全部</option>
        <option value="高">高</option>
        <option value="中">中</option>
        <option value="低">低</option>
    </select>
    <span>所属项目：</span>
    <input id="ProjectName" class="easyui-combobox" name="dept" data-options="valueField:'projectName',textField:'projectName',url:'/selectAllProject'">
    <span>项目组件：</span>
    <select id="ProjectAssembly1" class="easyui-combobox" name="dept" style="width:200px;">
        <option value="">全部</option>
        <option value="WCS">WCS</option>
        <option value="WMS">WMS</option>
        <option value="其他">其他</option>
    </select>
    <span>状态</span>
    <select id="ProblemState" class="easyui-combobox" name="dept" style="width:200px;">
        <option value="">全部</option>
        <option value="已发布">已发布</option>
        <option value="已处理">已处理</option>
    </select>
<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
</div>
<div id="dlg" class="easyui-dialog" style="width:70%;height: 70%" data-options="closed:true,modal:true,resizable:true,border:'thin',buttons:'#dlg-buttons'">
    <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
    <div style="margin-bottom:10px">
        <input name="projectName"  label="选择项目：" class="easyui-combobox" name="dept" data-options="valueField:'projectName',textField:'projectName',url:'/selectAllProject'">
    </div>
    <div style="margin-bottom:10px">
        <span>项目组件：</span>
        <select id="projectAssembly" class="easyui-combobox" name="dept" style="width:200px;">
            <option value="">全部</option>
            <option value="WCS">WCS</option>
            <option value="WMS">WMS</option>
            <option value="其他">其他</option>
        </select>
    </div>
    <div style="margin-bottom:10px">
        <span>优先级：</span>
        <select id="projectPriority" class="easyui-combobox" name="dept" style="width:200px;">
            <option value="高">高</option>
            <option value="中">中</option>
            <option value="低">低</option>
        </select>
    </div>
    <div style="margin-bottom:10px">
        <input name="problemSketch" class="easyui-textbox"  label="问题简述："style="width:50%">
    </div>
    <div style="margin-bottom:10px">
        <input name="problemDescribe" class="easyui-textbox"  label="具体描述："style="width:70%;height:60px">
    </div>
    <div>
        <input name="problemHandler" class="easyui-textbox"  label="处理人："style="width:50%">
    </div>
    <div style="margin-bottom:10px">
        <input name="expectTime" class="easyui-datebox"  label="完成时间："style="width:50%">
    </div>
    </form>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveProblem()">Save</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
           onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
    </div>
</div>
<div id="dlg1" class="easyui-dialog" style="width:70%;height: 70%" data-options="closed:true,modal:true,resizable:true,border:'thin',buttons:'#dlg1-buttons'">
    <form id="fm1" method="post" novalidate style="margin:0;padding:20px 50px">
        <div style="margin-bottom:10px">
            <input name="problemId" class="easyui-textbox"  label="问题ID："style="width:30%">
        </div>
        <div style="margin-bottom:10px">
            <input name="problemSketch" class="easyui-textbox"  label="问题评论："style="width:30%">
        </div>
        <div style="margin-bottom:10px">
            <input name="problemSolution" class="easyui-textbox"  label="解决方案："style="width:70%;height:60px">
        </div>
    <div id="dlg1-buttons">
        <a href="#" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveProblemSolution()">Save</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
           onclick="javascript:$('#dlg1').dialog('close')">Cancel</a>
    </div>
    </form>
</div>
<table id="dg" class="easyui-datagrid" title="项目列表" style="width:100%;height:auto"
       data-options="
               url:'/selectAllProblemByPage',
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
        <th data-options="field:'problemSketch',width:140">问题简述</th>
        <th data-options="field:'problemPriority',width:80">优先级</th>
        <th data-options="field:'projectName',width:80,align:'left'">所属项目</th>
        <th data-options="field:'projectAssembly',width:80,align:'left'">项目组件</th>
        <th data-options="field:'problemHandler',width:80">处理人</th>
        <th data-options="field:'createTime',width:80">发布时间</th>
        <th data-options="field:'problemState',width:80">状态</th>
        <th data-options="field:'_operate',width:80,align:'center',formatter:formatOper">操作</th>
    </tr>
    </thead>
</table>
<div id="win">

</div>
</body>
</html>
