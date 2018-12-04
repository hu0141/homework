<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>

</head>
<body> 
	<form id="userForm"	action="${pageContext.request.contextPath }/user/updateUser.action" method="post">
		<input type="hidden" name="uId" value="${user.uId}" /> 修改用户信息：
		<table width="100%" border=1>
			<tr>
				<td>用户名称</td>
				<td><input type="text" name="userName" value="${user.userName}" /></td>
			</tr>
			<tr>
				<td>用户简介</td>
				<td><textarea rows="3" cols="30" name="remark">${user.remark}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>

	</form>
</body>

</html>