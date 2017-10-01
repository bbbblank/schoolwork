<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="layui/css/layui.css">
<style type="text/css">
	.loginform{
		float:center;
		padding-left:550px;
		padding-top:190px;
	}
	body{
 		 background:url("img/img1.jpg");
 		 background-size:1400px 768px;
  }
</style>
</head>
<body>
	<div class="loginform">
	<form  action =  "loginaction" method ="post">
	
		<div class="layui-form-item">
			<label class="layui-form-label">账号</label>
				 <div class="layui-input-block">
					<input	style="width:220px;" class="layui-input" type="text" name="stu.uid">
				</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
				 <div class="layui-input-block">
					<input	style="width:220px;" class="layui-input" type="text" name="stu.stupw">
				</div>
		</div>
		<div class="layui-form-item">
    			<div class="layui-input-block">
    				<input class="layui-btn layui-btn-radius layui-btn-normal"  type="submit" value="登录">
   		 		</div>
 		</div>
	</form>
	</div>
</body>
</html>