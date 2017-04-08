<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>薪资管理</title>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件-->
    <script type="text/javascript" src="bootstrap-3.3.7-dist/js/jquery-3.2.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/InfoSalaManage.css"/>
    <script src="js/createTable.js" type="text/javascript">
    </script>
    <style type="text/css">
        /*//添加后不自动换行*/
        td{
            white-space: nowrap;
            text-align: center;
        }
    </style>

</head>

<body>
<div class="container-fluid" style="margin: 6px;">
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
                                <li><a href="InformationManageAction.action?department=all&infoType=basicInfo">基本信息</a> </li>
                                <li class="divider"></li>
                                <li><a href="InformationManageAction.action?department=all&infoType=basic">综合信息</a></li>
                                <li><a href="InformationManageAction.action?department=all&infoType=position">岗位信息</a></li>
                                <li><a href="InformationManageAction.action?department=all&infoType=contract">合同信息</a></li>
                                <li><a href="InformationManageAction.action?department=all&infoType=education">学历信息</a></li>
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
                                <li><a href="SalaryManageAction.action?salaryType=component">工资组成</a></li>
                                <li class="divider"></li>
                                <li><a href="SalaryManageAction.action?salaryType=socialsecurity">社会保险</a></li>
                                <li><a href="#">公积金</a></li>
                                <li><a href="#">所得税</a></li>
                                <li class="divider"></li>
                                <li><a href="#">考勤管理</a></li>
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
            <div class="col-md-1 leftside-bar btn-group-vertical" role="group" aria-label="...">
                <button id="all" type="button"
                        class="btn btn-primary btn-lg btn-block"
                        onclick="selectDepartmentToCreateTable('all', '${sessionScope.salaryType}')">
                    <span class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbsp;&nbsp;总览</button>
                <button id="office" type="button" class="btn btn-primary"
                        onclick="selectDepartmentToCreateTable('office', '${sessionScope.salaryType}')">
                        经理办</button>
                <button id="fd" type="button" class="btn btn-primary">财务部</button>
                <button id="eed" type="button" class="btn btn-primary">设备工程部</button>
                <button id="pwd" type="button" class="btn btn-primary">公用工程部</button>
                <button id="pd" type="button" class="btn btn-primary">生产部</button>
                <button id="qcd" type="button" class="btn btn-primary">质检部</button>
                <button id="workshop" type="button" class="btn btn-primary">车间</button>
                <button id="temp" type="button" class="btn btn-primary">临时用工</button>
            </div>
        <div class="col-md-11">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <div id="captionTypeDiv" style="text-align: right"></div>
                </div>
                <div class="panel-body">
                    <div>
                        <div style="margin: 10px;">
                            <input id="enquiryDateInput" class="form-control" type="month" style="text-align: center"></input>
                            <%-- <div><button id="testBtn">test</button></div>--%>

                        </div>
                    </div>
                    <div class="table-responsive">
                        <table id="salaryTable" class="table table-bordered">
                            <caption>你好，${sessionScope.user}#${sessionScope.salaryType}</caption>
                            <thead>
                            <tr>
                                <th>请选择日期</th>
                            </tr>
                            </thead>
                            <tbody>
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
                </div>
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
                            <button id="saveModificationBtn"
                                    onclick="saveModification(document, 'salaryTable', 'EmployeeInfoFormDiv', 'saveModificationBtn')"
                                    type="button" class="btn btn-primary" data-dismiss="modal">保存</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        </div>

                    </div>
                </div>
            </div>

        </div>

    </div>
</div>
<script type="text/javascript">
    $("#testBtn").click(function () {
        var uri = "SalaryTableAction.action";
        $.post(uri, {department:"all", salaryType:"component"},
            function (data) {
                /*for (var b in data){
                    $("#testDiv").append(b + ":" + data[b]+"<br/>");
                }*/
                var start = eval(data["test"]);
                employeesSalaryTest = start;
                setCaption(document, "工资组成");
                createTable(document, 'salaryTable', salaryTableHead, eval(data["test"]),'salaryTableHead');

        },
        "json");
    });
    var currentDate = new Date();
    var enquiryDate;
    if (currentDate.getMonth() < 9){
        enquiryDate = currentDate.getFullYear() + "-0" + (currentDate.getMonth()+1);
    }
    else {
        enquiryDate = currentDate.getFullYear() + "-" + (currentDate.getMonth()+1);
    }
    document.getElementById("enquiryDateInput").value = enquiryDate;

    //实现表头表内容皆为服务器回传
    function getSalaryTableAjax(department, salaryType, tableCaption, tableHeadString, tableContentString) {
        var uri = "SalaryTableAction.action";
        $.post(uri, {department:department, salaryType:salaryType},
            function (data) {
                //$("#testDiv").text(data["salaryTableHead"]);
                setCaption(document, tableCaption);
                createTable(document, 'salaryTable', JSON.parse(data[tableHeadString]), eval(data[tableContentString]),'salaryTableHead');
            },
            "json");
    }
    if ("${sessionScope.salaryType}" == "component"){
        //setCaption(document, "工资组成");
        //createTable(document, 'salaryTable', salaryTableHead, employeesSalary,'salaryTableHead');
        getSalaryTableAjax("all", "component", "工资组成", "salaryTableHead", "employeesSalary");
    }else if ("${sessionScope.salaryType}" == "socialsecurity") {
        setCaption(document, "社会保险");
        createTable(document, 'salaryTable', socialsecurityTableHead, employeesSS, 'socialsecurityTableHead');
    }
    function selectDepartmentToCreateTable(department, salaryType) {
        //总览按钮
        if (salaryType == "component"){
            if (department == "all") {
                //componentAllSalaryAction
                createTable(document, 'salaryTable', salaryTableHead, employeesSalary,'salaryTableHead');
            }else if (department == "office"){
                //componentOfficeSalaryAction
                createTable(document, 'salaryTable', salaryTableHead, employeesSalaryOffice,'salaryTableHead');
            }
        }else if (salaryType == "socialsecurity"){
            if (department == "all"){
                createTable(document, 'salaryTable', socialsecurityTableHead, employeesSS, 'socialsecurityTableHead');
            }else if (department == "office"){
                createTable(document, 'salaryTable', socialsecurityTableHead, employeesSSOffice, 'socialsecurityTableHead');
            }
        }
    }
    function getData(){

    }

</script>
</body>
</html>