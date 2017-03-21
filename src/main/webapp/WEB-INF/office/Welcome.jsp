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
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="#" class="dropdown-toggle">
                                员工信息管理
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                薪资管理<b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">工资组成</a></li>
                                <li class="divider"></li>
                                <li><a href="#">社保</a></li>
                                <li><a href="#">公积金</a></li>
                                <li><a href="#">所得税</a></li>
                            </ul>
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
            <div class="jumbotron">
                <h1>hello</h1>
            </div>
        </div>

    </div>
</div>
</body>
</html>