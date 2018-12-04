<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改设备信息</title>

</head>
<body> 
	<form id="deviceForm"	action="${pageContext.request.contextPath }/device/updateDevice.action" method="post">
		<input type="hidden" name="id" value="${device.id }" /> 
		<input type="hidden" name="uId" value="${device.uId }" /> 
		修改设备信息：
		<table width="100%" border=1>
			<tr>
				<td>设备名称</td>
				<td><input type="text" name="devName" value="${device.devName }" /></td>
			</tr>
			<tr>
				<td>设备简介</td>
				<td><textarea rows="3" cols="30" name="remark">${device.remark }</textarea>
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