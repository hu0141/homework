<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设备列表</title>
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
<br/><br/>
<a href="${pageContext.request.contextPath}/user/findAllUser.action"><p align="center">返回至用户列表</p></a>
<br/>
<font color="blue" size="4">新增设备:</font>
<form action="${pageContext.request.contextPath}/device/insertDevice.action" method="post" >
	<input type="hidden" name="uId" value="${uId}"/>
	<table width="100%"  align="center" border=1>
		<tr>
			<td>设备名称<font color="red">*</font>:</td>
			<td><input type="text" name="devName"/></td>
			<td>设备描述:</td>
			<td><input type="text" name="remark"/></td>
			<td colspan="2" rowspan="2"><input type="submit" value="保存"/></td>
		</tr>
		
	</table>
</form>
<br/>
<font color="blue" size="4">查找设备：</font>
<form action="${pageContext.request.contextPath }/device/searchDevice.action" method="post">
	<input type="hidden" name="uId" value="${uId}"/>
	<table width="100%" border=1>
		<tr>
			<td>设备名称:</td>
			<td><input type="text" name="devName"/></td>
			<td>设备描述:</td>
			<td><input type="text" name="remark"/></td>
			<td><input type="submit" value="查询"/></td>
		</tr>
	</table>
</form>
<br/>
<font color="blue" size="4">设备列表：</font>
<table width="100%" border=1>
<tr>
	<td>设备名称</td>
	<td>创建时间</td>
	<td>设备描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${deviceList}" var="device">
<tr>
	<td>${device.devName}</td>
	<td><fmt:formatDate value="${device.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td>${device.remark}</td>
	<td>
		<a href="${pageContext.request.contextPath }/device/findDevById.action?id=${device.id}">修改</a>
		<a href="${pageContext.request.contextPath }/device/deleteDevice.action?id=${device.id}">删除</a>
	</td>
</tr>
</c:forEach>

</table>
</body>

</html>