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

</head>

<body>
<div class="container">
    <div class="row">
        <nav class="navbar navbar-inverse" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <li><a class="navbar-brand" href="#"><font color="#ebfaff">OA</font></a></li>
                </div>
                <div>
                    <ul class="nav navbar-nav manage-nav-font">
                        <li>
                            <a href="InformationManageAction.action">
                                员工信息管理
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="SalaryManageAction.action">
                                薪资管理
                            </a>
                            <!--
                            <a href="SalaryManageAction.action" class="dropdown-toggle" data-toggle="dropdown">
                                薪资管理<b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">工资组成</a></li>
                                <li class="divider"></li>
                                <li><a href="#">社保</a></li>
                                <li><a href="#">公积金</a></li>
                                <li><a href="#">所得税</a></li>
                            </ul>
                            -->
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
                <button type="button" class="btn btn-primary btn-lg btn-block">总览</button>
                <button type="button" class="btn btn-primary">经理办</button>
                <button type="button" class="btn btn-primary">财务部</button>
                <button type="button" class="btn btn-primary">设备工程部</button>
                <button type="button" class="btn btn-primary">公用工程部</button>
                <button type="button" class="btn btn-primary">生产部</button>
                <button type="button" class="btn btn-primary">车间</button>
                <button type="button" class="btn btn-primary">临时用工</button>
            </div>
        <div class="col-md-10">
            <div>你好，${sessionScope.user}</div>
            <div class="table-responsive">

                <table id="salaryTable" class="table table-bordered">
                    <caption>工资组成</caption>
                    <thead>
                    <tr>
                        <th>EID</th>
                        <th>姓名</th>
                        <th>部门</th>
                        <th>日期</th>
                        <th>应发工资</th>
                        <th>基本工资</th>
                        <th>考核工资</th>
                        <th>浮动工资</th>
                        <th>节日</th>
                        <th>假日</th>
                        <th>夜班费</th>
                        <th>保健、补助</th>
                        <th>合计</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>001</td>
                        <td>巩涛</td>
                        <td>技术研发部</td>
                        <td>2017/02</td>
                        <td>20000</td>
                        <td>20000</td>
                        <td>20000</td>
                        <td>20000</td>
                        <td>1000</td>
                        <td>1000</td>
                        <td>1000</td>
                        <td>200</td>
                        <td>60000</td>
                        <td>
                            <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap">修改</button>
                        </td>
                    </tr>
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



            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="exampleModalLabel">New message</h4>
                        </div>
                        <div class="modal-body">
                            <form id="EmInfo">
                                <div class="form-group">
                                    <label for="recipient-name" class="control-label">Recipient:</label>
                                    <input type="text" class="form-control" id="recipient-name">
                                </div>
                                <div class="form-group">
                                    <label for="message-text" class="control-label">Message:</label>
                                    <textarea class="form-control" id="message-text"></textarea>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">

                            <button type="button" class="btn btn-primary">Send message</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<script type="text/javascript">
    var informationTableHead ={
        eid:"EID", name:"姓名", department:"部门", date:"日期",
        salary:"应发工资", basicSalary:"基本工资", checkSalary:"考核工资", floatingSalary:"浮动工资",
        festivalSalary:"节日", holidaySalary:"假日", nightSalary:"夜班费", subsidySalary:"保健、补助",
        totalSalary:"合计", operation:"操作"
    };
    var employees = [
        {
            eid:"001", name:"巩涛", department:"经理办", date:"2017-02",
            salary:"20000", basicSalary:"5000", checkSalary:"5000", floatingSalary:"5000",
            festivalSalary:"200", holidaySalary:"200", nightSalary:"200", subsidySalary:"200",
            totalSalary:"20000", operation:"操作"
        }
    ];
/*
 <th>EID</th>
 <th>姓名</th>
 <th>部门</th>
 <th>日期</th>
 <th>应发工资</th>
 <th>基本工资</th>
 <th>考核工资</th>
 <th>浮动工资</th>
 <th>节日</th>
 <th>假日</th>
 <th>夜班费</th>
 <th>保健、补助</th>
 <th>合计</th>
 <th>操作</th>
 */
</script>
</body>
</html>