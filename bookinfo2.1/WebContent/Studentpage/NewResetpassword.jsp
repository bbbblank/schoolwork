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
	.center{float:center;
			padding-left:550px;
			padding-top:190px;
	}

</style>

</head>
<body>
<ul class="layui-nav" lay-filter="">
  <li class="layui-nav-item "><a href="testshowbook?leaduid=<s:property value = "#session.uid"/>">全部书籍</li>
  <li class="layui-nav-item "><a href="NewSerchbook.jsp">查找书籍</a></li>
  <li class="layui-nav-item "><a href="serchstubook?leaduid=<s:property value="#session.uid"/>">我的信息</a></li>
  <li class="layui-nav-item layui-this"><a href="">修改密码</a></li>
  
</ul>

	
	<blockquote class="layui-elem-quote">
	
	你好：<s:property value='#session.uid'/>
	
	</blockquote>
	 <div class ="center">
		 <form action = "changepasswd" method="post">
			<input name="leaduid" type="hidden" value=<s:property value='#session.uid'/>>
			新密码：<input name ="stu.stupw" type ="text" >
			<input type="submit" value="修改密码">
		</form>
	</div>
	
	
	
	
<script>
//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element();
  
  //…
});
</script>
</body>
</html>