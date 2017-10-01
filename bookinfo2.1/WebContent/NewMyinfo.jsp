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
	.right{float:right;
			padding-right:50px;
	}

</style>

</head>
<body>
<ul class="layui-nav" lay-filter="">
  <li class="layui-nav-item "><a href="testshowbook?leaduid=<s:property value = "#session.uid"/>">全部书籍</li>
  <li class="layui-nav-item "><a href="NewSerchbook.jsp">查找书籍</a></li>
  <li class="layui-nav-item layui-this"><a href="">我的信息</a></li>
  <li class="layui-nav-item"><a href="NewResetpassword.jsp">修改密码</a></li>
  
</ul>





<blockquote class="layui-elem-quote">你好：<s:property value='#session.uid'/>&nbsp;&nbsp;<a class="layui-btn layui-btn-mini layui-btn-radius layui-btn-danger" href="login.jsp">退出登录</a></blockquote>
	
	
	
	<table class="layui-table">
	  <colgroup>
	    <col width="150">
	    <col width="200">
	    <col width="200">
	    <col width="200">
	    <col width="200">
	    <col width="150">
	
	  </colgroup>
	  <thead>
	    <tr>
	      <th>图书编号</th>
	      <th>书名</th>
	      <th>借书时间</th>
	      <th>还书时间</th>
	      <th>借书人</th>
	      <th>操作</th>
	    </tr> 
	  </thead>
	  <tbody>
	  <s:iterator value = "info" var ="readerinfo">
	    <tr>
	      <td><s:property value='#readerinfo.bid'/></td>
	      <td><s:property value='#readerinfo.bname'/></td>
	      <td><s:date name="#readerinfo.leaddate" /></td>
	      <td><s:date name="#readerinfo.returndate"/></td>
	      <td><s:property value='#readerinfo.stuname'/></td>      
	      <td><a style="align-items: center;" href="releadbook?leadid=<s:property value='#readerinfo.bid'/>&leaduid=<s:property value="#session.uid"/>">续借</a>
	      	<a style="align-items: center;" href="returnbook?leadid=<s:property value='#readerinfo.bid'/>&leaduid=<s:property value="#session.uid"/>">还书</a>
	      </td>
	    </tr>
	    </s:iterator> 
	  </tbody>
	</table>
	

<script>
//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element();
  
  //…
});
</script>
</body>
</html>