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
	.form-center{
		float:left;
		padding-left:450px;
	}
</style>


<script type="text/javascript">
	function resetform() {
		document.getElementById('inputForm').reset();
	}
</script>

</head>
<body>
<ul class="layui-nav" lay-filter="">
  <li class="layui-nav-item layui-this"><a href="">修改书籍</a></li>
</ul>

	
	<blockquote class="layui-elem-quote">
	
	你好：<s:property value='#session.uid'/>&nbsp;&nbsp;<a class="layui-btn layui-btn-mini layui-btn-radius layui-btn-danger" href="login.jsp">退出登录</a>
	<div  class="right">
		<form action= "changebook" method ="post">
			<input name="serchname" type ="text">
			<input type="submit" class="layui-btn layui-btn-mini" value="serch">
		</form>
	</div>
	</blockquote>
	 
	 
	  
	<div class="form-center">
	<form id="inputForm" action="save" method="post">
			
			<div class="layui-form-item">
			<label class="layui-form-label">图书编号</label>
				 <div class="layui-input-block">
					<input	style="width:220px;" class="layui-input" type="text" name="book.bid" value="<s:property value='#request.book.bid'/>">
				</div>
			</div>
			<div class="layui-form-item">
			<label class="layui-form-label">图书名字</label>
				 <div class="layui-input-block">
					<input	style="width:220px;" class="layui-input" type="text" name="book.bname" value="<s:property value='#request.book.bname'/>">
				</div>
			</div>
			<div class="layui-form-item">
			<label class="layui-form-label">图书作者</label>
				 <div class="layui-input-block">
					<input	style="width:220px;" class="layui-input" type="text" name="book.bwriter" value="<s:property value='#request.book.bwriter'/>">
				</div>
			</div>
			<div class="layui-form-item">
			<label class="layui-form-label">图书商家</label>
				 <div class="layui-input-block">
					<input	style="width:220px;" class="layui-input" type="text" name="book.bpublicment" value="<s:property value='#request.book.bpublicment'/>">
				</div>
			</div>
			<div class="layui-form-item">
			<label class="layui-form-label">图书总存量</label>
				 <div class="layui-input-block">
					<input	style="width:220px;" class="layui-input" type="text" name="book.bnumcount" value="<s:property value='#request.book.bnumcount'/>">
				</div>
			</div>
			<div class="layui-form-item">
			<label class="layui-form-label">图书现存量</label>
				 <div class="layui-input-block">
					<input	style="width:220px;" class="layui-input" type="text" name="book.bnumnow" value="<s:property value='#request.book.bnumnow'/>">
				</div>
			</div>
			<div class="layui-form-item">
    			<div class="layui-input-block">
    				<input class="layui-btn layui-btn-radius layui-btn-normal"  type="submit" value="提交">
					<a href="changebook?serchname=null" class="layui-btn layui-btn-radius layui-btn-normal" >清空</a>
   		 		</div>
 			</div>
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