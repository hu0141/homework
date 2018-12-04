<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	a:link,a:visited{
	 text-decoration:none;  /*超链接无下划线*/
	}
	a:hover{
	 text-decoration:underline;  /*鼠标放上去有下划线*/
	}
</style>
<body>
	<br/><br/><br/><br/><br/><br/><br/>
	<h3 align="center">${message}</h3>
	<br/><br/><br/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/${path}">返回上一级</a>
</body>
</html>