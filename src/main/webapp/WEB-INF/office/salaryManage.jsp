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
    <style type="text/css">

        .footer{
            position: absolute;
            bottom: 0;
            width: 100%;
            height: 60px;
            background-color: #f5f5f5;
        }
        .text-muted {
            color: #777;
        }
        .sidebar {
            position: fixed;
            top: 51px;
            bottom: 0;
            left: 0;
            z-index: 1000;
            display: block;
            padding: 20px;
            overflow-x: hidden;
            overflow-y: auto;
            background-color: #f5f5f5;
            border-right: 1px solid #eee;
        }
        .nav {
            padding-left: 0;
            margin-bottom: 0;
            list-style: none;
        }
        .nav-sidebar {
            margin-right: -21px;
            margin-bottom: 20px;
            margin-left: -20px;
        }
        .btn-group-vertical {
            position: relative;
            display: inline;
            vertical-align: middle;
        }
        .leftside-bar{
            position: relative;
            min-height: 1px;
            padding-right: 1px;
            padding-left: 1px;
        }
    </style>
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
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle">
                                员工信息管理
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                Java <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">jmeter</a></li>
                                <li><a href="#">EJB</a></li>
                                <li><a href="#">Jasper Report</a></li>
                                <li class="divider"></li>
                                <li><a href="#">分离的链接</a></li>
                                <li class="divider"></li>
                                <li><a href="#">另一个分离的链接</a></li>
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
            <div class="table-responsive">

                <table class="table table-bordered">
                    <caption>工资组成</caption>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>姓名</th>
                        <th>部门</th>
                        <th>日期</th>
                        <th>应发工资</th>
                        <th>基本工资</th>
                        <th>考核工资</th>
                        <th>浮动工资</th>
                        <th>节日</th>
                        <th>假日</th>
                        <th>夜班</th>
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
                        <td>60000</td>
                        <td><button>修改</button>
                            <button>保存</button>
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
        </div>

    </div>
</div>
</body>
</html>