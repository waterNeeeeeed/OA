<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>员工信息管理</title>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件-->
    <script type="text/javascript" src="bootstrap-3.3.7-dist/js/jquery-3.2.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/InfoSalaManage.css"/>


</head>

<body>
<div class="container">
    <!-- 导航条 -->
    <div class="row">
        <nav class="navbar navbar-inverse" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <li><a class="navbar-brand" href="OA.action"><font color="#ebfaff">OA</font></a></li>
                </div>
                <div>
                    <ul class="nav navbar-nav manage-nav-font">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                员工信息管理<b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="InformationManageAction.action">基本信息</a> </li>
                                <li class="divider"></li>
                                <li><a href="#">新增员工</a></li>
                                <li><a href="#">删除员工</a></li>
                                <li><a href="#">部门调动</a></li>
                                <li class="divider"></li>
                                <li><a href="#">档案管理</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                薪资管理<b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="SalaryManageAction.action">工资组成</a></li>
                                <li class="divider"></li>
                                <li><a href="#">社保</a></li>
                                <li><a href="#">公积金</a></li>
                                <li><a href="#">所得税</a></li>
                                <li class="divider"></li>
                                <li><a href="#">请假</a></li>
                            </ul>

                        </li>

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                工作流管理<b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">用车流程</a></li>
                                <li><a href="#">报销流程</a></li>
                                <li><a href="#">请假流程</a></li>

                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                仓储管理<b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">所有仓库</a></li>
                                <li><a href="#">A仓库</a></li>
                                <li><a href="#">B仓库</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                生产计划管理<b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">所有计划</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                后勤管理<b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">后勤仓库</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                采购管理<b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">所有计划</a></li>
                            </ul>
                        </li>

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                用户管理<b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">所有管理员</a></li>
                                <li class="divider"></li>
                                <li><a href="#">当前在线管理员</a></li>
                                <li><a href="#">当前在线用户</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div align="right">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="ExitAction.action">
                                退出
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>

    <div class="row">
            <div class="col-md-2 leftside-bar btn-group-vertical" role="group" aria-label="...">
                <button id="all" type="button"
                        class="btn btn-primary btn-lg btn-block" onclick="createTable()">总览</button>
                <button id="office" type="button" class="btn btn-primary">经理办</button>
                <button id="fd" type="button" class="btn btn-primary">财务部</button>
                <button id="eed" type="button" class="btn btn-primary">设备工程部</button>
                <button id="pwd" type="button" class="btn btn-primary">公用工程部</button>
                <button id="pd" type="button" class="btn btn-primary">生产部</button>
                <button id="workshop" type="button" class="btn btn-primary">车间</button>
                <button id="temp" type="button" class="btn btn-primary">临时用工</button>
            </div>
        <div class="col-md-10">
            <div class="table-responsive">
                <div style="text-align: right">你好，${sessionScope.user}</div>
                <table id="infoTable" class="table table-bordered">
                    <caption>基本信息</caption>
                    <thead>
                    <tr>
                        <th>EID</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>部门</th>
                        <th>职务</th>
                        <th>身份证号</th>
                        <th>入职时间</th>
                        <th>操作</th>

                    </tr>
                    </thead>
                    <tbody>
                    <!--
                    <tr>
                        <td>001</td>
                        <td>巩涛</td>
                        <td>男</td>
                        <td>技术研发部</td>
                        <td>班长</td>
                        <td>370783198708256132</td>
                        <td>2013/08</td>
                        <td><button>修改</button>
                            <button>保存</button>
                        </td>
                    </tr>
                    -->
                    </tbody>
                </table>
                <ul class="pagination">
                    <li><a href="#">&laquo;</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&raquo;</a></li>
                </ul>
            </div>

            <!-- 用于修改信息的模态对话框 -->
            <div class="modal" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">

                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="exampleModalLabel">New message</h4>
                        </div>

                        <div class="modal-body">
                            <form id="EmployeeInfoForm">
                                <div id="EmployeeInfoFormDiv" class="form-group">
                                </div>
                            </form>
                        </div>

                        <div class="modal-footer">
                            <button id="saveModificationBtn" onclick="saveModification()" type="button" class="btn btn-primary" data-dismiss="modal">保存</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        </div>

                    </div>
                </div>
            </div>

        </div>

    </div>
</div>
<script type="text/javascript">
    var informationTableHead ={
        eid:"EID", name:"姓名", sex:"性别", department:"部门", position:"职务", identification :"身份证号", hiredate:"入职日期"
    };
    var employees = [
    {eid:"001", name:"巩涛", sex:"男", department:"经理办", position:"班长", identification :"370783198708256132", hiredate:"2013-08"},
    {eid:"002", name:"张百城", sex:"男", department:"车间", position:"操作工", identification :"370783199408256132", hiredate:"2015-08"}];
    function createTable() {
        var table = document.getElementById("infoTable");
        var old_length = table.rows.length;
        //删除旧的表格
        for (var i=old_length-1; i>=0; i--){
            table.deleteRow(i);
        }
        //设置表头
        var nhead = 0;
        var ncell = 0;
        var th = table.insertRow(nhead);
        for (var a in informationTableHead){
            var td = th.insertCell(ncell);
            td.innerHTML = informationTableHead[a];
            ncell++;
        }
        var td = th.insertCell(ncell);
        td.innerHTML = "操作";
        th.setAttribute("style", "font-weight:bold");
        //设置表内容
        for (var i=0; i<employees.length; i++){
            var tr = table.insertRow(i+1);
            var ncell = 0;
            for (var b in employees[i]){
                var td = tr.insertCell(ncell);
                td.innerHTML = employees[i][b];
                ncell++;
            }
            //var td = tr.insertCell(ncell);
            //td.innerHTML = "<button id=\"button" + (i+1) +"\" class=\"btn btn-success\">修改</button>";
            //最后增加操作项
            var td = tr.insertCell(ncell);
            td.innerHTML = "<button data-toggle=\"modal\" data-target=\"#exampleModal\" data-whatever=\"@getbootstrap\" onclick=\"createEmployeeInfoForm(this)\" value=\"" + (i+1) + "\" class=\"btn btn-success btn-sm\">修改</button>";

        }
    }
    function createEmployeeInfoForm(target) {
        var rowsIndex = target.value;
        var table = document.getElementById("infoTable");
        var formContent = document.getElementById("EmployeeInfoFormDiv");
        var saveBtn = document.getElementById("saveModificationBtn");
        saveBtn.value = rowsIndex;
        //先清空旧有元素
        formContent.innerHTML = "";

        var cellsIndex = 0;
        for (var a in informationTableHead){
            var label = document.createElement("label");

            label.setAttribute("for", informationTableHead[a]);
            label.setAttribute("class", "control-label");
            label.innerHTML = informationTableHead[a];
            var input = document.createElement("input");
            input.setAttribute("type", "text");
            input.setAttribute("class", "form-control");
            input.setAttribute("id", informationTableHead[a]);
            input.setAttribute("value", table.rows[rowsIndex].cells[cellsIndex].innerHTML);
            if (informationTableHead[a] == "EID" || informationTableHead[a] == "eid"){
                input.setAttribute("disabled", "disabled");
            }
            formContent.appendChild(label);
            formContent.appendChild(input);
            cellsIndex++;
        }


    }
    //保存修改
    function saveModification() {
        var table = document.getElementById("infoTable");
        var formContent = document.getElementById("EmployeeInfoFormDiv");
        var saveBtn = document.getElementById("saveModificationBtn");
        var content = formContent.getElementsByTagName("input");
        var rowsIndex = saveBtn.value;
        var n = 0;
        for (var a in content){
            table.rows[rowsIndex].cells[n].innerHTML = content[n].value;
            n++;
        }
    }
</script>
</body>

</html>