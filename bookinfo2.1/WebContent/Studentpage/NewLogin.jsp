<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>show</title>
<link rel="stylesheet" href="layui/css/layui.css">
<style type="text/css">
	
</style>
	
</head>
<body>
<div  class="forminput">
	<form class="layui-form" action="loginaction">
	<div class="layui-form-item">
   	 <label class="layui-form-label">输入框</label>
	    <div class="layui-input-block">
	      <input style="width:190px;" type="text" name="stu.uid" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
	    </div>
  	</div>
	 <div class="layui-form-item">
    <label class="layui-form-label">密码框</label>
	    <div class="layui-input-inline">
	      <input type="password" name="stu.stupw" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
	    </div>
	<div class="layui-form-item">
	 
	 <div class="layui-form-item">
	 </div>
	 <label class="layui-form-label"></label>
		<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
	</div>
	
	</form>
</div>
</body>
</html>