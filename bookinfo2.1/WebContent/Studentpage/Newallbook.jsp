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
  <li class="layui-nav-item layui-this"><a href="testshowbook?leaduid=<s:property value = "#session.uid"/>">全部书籍</li>
  <li class="layui-nav-item "><a href="NewSerchbook.jsp">查找书籍</a></li>
  <li class="layui-nav-item "><a href="serchstubook?leaduid=<s:property value="#session.uid"/>">我的信息</a></li>
  <li class="layui-nav-item"><a href="NewResetpassword.jsp">修改密码</a></li>
  
</ul>


<blockquote class="layui-elem-quote">你好：<s:property value='#session.uid'/></blockquote>


<table class="layui-table">
	  <colgroup>
	    <col width="150">
	    <col width="200">
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
	      <th>发行商</th>
	      <th>总存量</th>
	      <th>现存量</th>
	      <th>作者</th>
	      <th>操作</th>
	    </tr> 
	  </thead>
	  <tbody>
	  <s:iterator value = "books" var ="bookinfo">
	    <tr>
	      <td><s:property value='#bookinfo.bid'/></td>
	      <td><s:property value='#bookinfo.bname'/></td>
	      <td><s:property value='#bookinfo.bpublicment'/></td>
	      <td><s:property value='#bookinfo.bnumcount'/></td>
	      <td><s:property value='#bookinfo.bnumnow'/></td>
	      <td><s:property value='#bookinfo.bwriter'/></td>
	      <td><a href="leadbook?leadid=<s:property value='#bookinfo.bid'/>&leaduid=<s:property value="#session.uid"/>">借书</a></td>
	    </tr>
	    </s:iterator> 
	  </tbody>
	</table>
	<div  class="right"  >
		<a href = "testshowbook?page=0&node=0"><s:property value='#request.node+1'/></a>
		<a href ="testshowbook?page=5"><s:property value='#request.node+ 2' /></a>
		<s:property value='#node'/>
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