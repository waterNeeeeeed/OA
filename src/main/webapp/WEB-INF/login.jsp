<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>江岳科技OA办公系统</title>
    <!-- <script src="https://code.jquery.com/jquery-3.1.1.js" type="text/javascript"></script> -->
    <!--
        <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    -->
    <!-- 最新的 Bootstrap 核心 JavaScript 文件
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    -->
    <!-- 最新的 Bootstrap 核心 JavaScript 文件-->
    <script type="text/javascript" src="bootstrap-3.3.7-dist/js/jquery-3.2.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <style type="text/css">
        body{
            padding-top: 100px;
        }
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
    </style>
</head>

<body>
    <div>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <h1>江岳科技</h1>
            </div>
        </nav>
    </div>
<!--
<s:property value="tip"/>
<s:form action="login">
    <s:textfield name="user" key="username"/>
    <s:textfield name="pass" key="password"/>
    <s:submit key="log"/>
</s:form>
-->
<div class="container">
 <div class="row">
  <div class="col-md-8">
    <div>
        <h2>你好，欢迎使用OA</h2>
        <p>迅速提高办公效率</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">了解更多</a></p>
    </div>
  </div>
  <div class="col-md-3 col-md-offset-1 well">
  	<s:form action="login">
  		<div class="form-group">
    		<label for="exampleInputUsername">用户名</label>
    		<input type="text" class="form-control" id="exampleInputEmail1" placeholder="用户名" name="user">
  		</div>
  		<div class="form-group">
    		<label for="exampleInputPassword1">密码</label>
    		<input type="password" class="form-control" id="exampleInputPassword1" placeholder="密码" name="pass">
  		</div>
  
  		<div class="checkbox">
    		<label>
      		<input type="checkbox">记住我
    		</label>
  		</div>
 	 	<!-- <button type="submit" class="btn btn-default">Submit</button> -->
        <s:submit key="登录" type="submit" class="btn btn-primary"/>
	</s:form>
  </div>
 </div>
</div>

<div class="footer">
    <div class="container">
        <p class="text-muted">地址：山东江岳科技开发股份有限公司</p>
    </div>
</div>
</body>
</html>