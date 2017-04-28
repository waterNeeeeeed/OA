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
    <%--<link rel="stylesheet" type="text/css" href="css/InfoSalaManage.css"/>--%>
    <script src="js/createTable.js" type="text/javascript">
    </script>
    <style type="text/css">
        /*//添加后不自动换行*/
        td{
            white-space: nowrap;
            text-align: center;
        }
    </style>

    <script type="text/javascript" src="jquery-3d-menu-with-search/js/jquery-accordion-menu.js">

    </script>
    <link href="jquery-3d-menu-with-search/css/jquery-accordion-menu.css" rel="stylesheet" type="text/css" />
    <link href="jquery-3d-menu-with-search/css/font-awesome.css" rel="stylesheet" type="text/css" />

    <style type="text/css">
        /**{box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;}*/
        body{background:#f0f0f0;}
        .content{width:auto;margin:0px;}

        #demo-list a{
            overflow:hidden;
            text-overflow:ellipsis;
            -o-text-overflow:ellipsis;
            white-space:nowrap;
            width:100%;
        }
    </style>
    <script type="text/javascript">

        $(function(){
            //顶部导航切换
            $("#demo-list li").click(function(){
                $("#demo-list li.active").removeClass("active")
                $(this).addClass("active");
            })
        })
    </script>
</head>

<body>
<%--<div class="container">--%>
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
                                <li><a href="InformationManageAction.action?department=nothing&infoType=numberOfEmployees">概况</a></li>
                                <li class="divider"></li>
                                <li><a href="InformationManageAction.action?department=all&infoType=basicInfo">基本信息</a> </li>
                                <li><a href="InformationManageAction.action?department=all&infoType=basic">综合信息</a></li>
                                <li><a href="InformationManageAction.action?department=all&infoType=position">岗位信息</a></li>
                                <li><a href="InformationManageAction.action?department=all&infoType=contract">合同信息</a></li>
                                <li><a href="InformationManageAction.action?department=all&infoType=education">学历信息</a></li>
                                <li class="divider"></li>
                                <li><a href="#">员工管理</a></li>
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
                                <li><a href="#">社保基数</a></li>
                                <li><a href="SalaryManageAction.action?salaryType=socialsecurity">社保信息</a></li>
                                <li class="divider"></li>
                                <li><a href="#">公积金基数</a></li>
                                <li><a href="#">公积金信息</a></li>
                                <li class="divider"></li>
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
                                <li><a href="WorkFlowManageAction.action">工作流管理</a></li>
                                <%--<li class="divider"/>
                                <li><a href="#">用车流程</a></li>
                                <li><a href="#">报销流程</a></li>
                                <li><a href="#">请假流程</a></li>--%>

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
        <div class="col-md-2 sidebar" >
            <ul class="nav nav-sidebar">
                <li class="active">
                    <a href="#"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 总览 </a>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-usd" aria-hidden="true"></span> 财务部 </a></span>
                </li>
                <li>
                    <a href="#"><i class="fa fa-cog"></i> 设备工程部 </a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-file-image-o"></i> 公用工程部 </a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-glass"></i> 生产部 </a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-envelope"></i> 质检部 </a>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-th" aria-hidden="true"></span> 车间 </a>
                </li>
            </ul>

            <div class="content">

                <div id="jquery-accordion-menu" class="jquery-accordion-menu blue">
                    <%--<div class="jquery-accordion-menu-header" id="form"></div>--%>
                    <ul id="demo-list">
                        <li class="active"><a href="#"><i class="fa fa-home"></i>总览 </a></li>
                        <li><a href="#"><i class="fa fa-user"></i>经理办 </a></li>
                        <li>
                            <a href="#"><i class="fa fa-suitcase"></i>财务部 </a>
                            <span class="jquery-accordion-menu-label"> 12 </span>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-cog"></i>设备工程部 </a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-file-image-o"></i>公用工程部 </a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-glass"></i>生产部 </a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-envelope"></i>质检部 </a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-glass"></i>车间 </a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-cog"></i>Services </a>
                            <ul class="submenu">
                                <li><a href="#">Web Design </a></li>
                                <li><a href="#">Hosting </a></li>
                                <li><a href="#">Design </a>
                                    <ul class="submenu">
                                        <li><a href="#">Graphics </a></li>
                                        <li><a href="#">Vectors </a></li>
                                        <li><a href="#">Photoshop </a></li>
                                        <li><a href="#">Fonts </a></li>
                                        <li>
                                            <a href="#">Graphics </a>
                                            <span class="jquery-accordion-menu-label">10 </span>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="#">Consulting </a></li>
                            </ul>
                        </li>

                    </ul>
                    <div class="jquery-accordion-menu-footer">

                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-10">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <div id="captionTypeDiv" style="text-align: right;">你好，${sessionScope.user}</div>
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <%--<hr/>--%>
                        <table id="infoTable" class="table table-bordered">
                            <caption id="infoTableCaption">你好，${sessionScope.department_zh_CN}</caption>
                            <thead  style="text-align: center">
                                <tr>
                                    <th>序号</th>
                                    <th>员工类型</th>
                                    <th>人数</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td><td>江岳</td><td>93</td>
                                </tr>
                                <tr>
                                    <td>2</td><td>公泉</td><td>8</td>
                                </tr>
                                <tr>
                                    <td>3</td><td>返聘</td><td>8</td>
                                </tr>
                                <tr>
                                    <td>4</td><td>临时工</td><td>80</td>
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

    selectDepartmentToCreateTable("${sessionScope.department}", "${sessionScope.infoType}");
    function selectDepartmentToCreateTable(department, infoType) {
        var tableCaption;
        //总览按钮basic basicInfo position education contract
        if (infoType == "basic"){
            tableCaption = "综合信息";
        }
        if (infoType == "basicInfo"){
            tableCaption = "基本信息";
        }
        if (infoType == "position"){
            tableCaption = "岗位信息";
        }
        if (infoType == "education"){
            tableCaption = "教育信息";
        }
        if (infoType == "contract"){
            tableCaption = "合同信息";
        }
        getInfoTableAjax(department, infoType, tableCaption, 'informationTableHead', 'employeesInfo');

    }
    function getInfoTableAjax(department, infoType, tableCaption, tableHeadString, tableContentString) {
        var uri = "InfoTableAction.action";
        /*alert("getInfoTableAjax");*/
        $.post(uri, {department:department, infoType:infoType},
            function (data) {
                //$("#testDiv").text(data["salaryTableHead"]);
                /*alert("test_post");*/
                setCaption(document, tableCaption);
                $("#infoTableCaption").text(data["department_zh_CN"]);
                createTable(document, 'infoTable', JSON.parse(data[tableHeadString]), eval(data[tableContentString]),'informationTableHead');
            },
            "json");
    }
</script>
<script type="text/javascript">

    jQuery("#jquery-accordion-menu").jqueryAccordionMenu();

</script>
</body>

</html>