<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<br />
	<br />
	<br />
	<br /><br /><br />
	<p align="center"><font color="blue" size="6">homework</font></p>
	<br /><br />
	<form action="${pageContext.request.contextPath}/loginServlet" method="post">
		<table align="center">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" /></td>
				<td></td>
			</tr>
			<tr>
				<td>密 &nbsp;码&nbsp; :</td>
				<td><input type="password" name="password"/></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3">有效期：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="logintime" value="${15*60}" checked="true"/>15分钟
					<input type="radio" name="logintime" value="${30*60}" />30分钟</td>
			</tr>
			<tr >
				<td colspan="3" align="center"><input type="submit" value="登录"/></td>
			</tr>
		</table>
	</form>
</body>
</html>