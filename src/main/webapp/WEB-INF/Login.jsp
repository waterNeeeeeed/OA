<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>江岳科技OA办公系统</title>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件-->
    <script type="text/javascript" src="bootstrap-3.3.7-dist/js/jquery-3.2.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>

<body>
    <div>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <h1 style="color: #080808;font-weight: bold">
                    江岳科技
                    <!--
                    <b style="font-size: 16px;font-weight: normal">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OA办公系统</b>
                    -->
                </h1>
            </div>
        </nav>
    </div>

<div class="container">
 <div class="row">
  <div class="col-md-offset-2 col-md-6">
    <div>
        <p style="font-size: 66px">你好</p>
        <p style="font-size: 16px">欢迎使用OA办公系统,它可以帮你提高办公效率</p>
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
 	 	<button type="submit" class="btn btn-primary btn-block btn-lg">登录</button>
        <!-- <s:submit key="登录" type="submit" class="btn btn-primary btn-block btn-lg"/> -->
	</s:form>
  </div>
 </div>
</div>

<div class="footer">
    <div class="container">
        <p class="text-muted" style="padding-top: 20px;">版权所有：山东江岳科技开发股份有限公司</p>
    </div>
</div>
</body>
</html>