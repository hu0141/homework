<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
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
<br/>
<br/>
<a href="${pageContext.request.contextPath}/logoutServlet"><p align="center"><font color="coral">登出</font></p></a>
<br/>
<br/>
	<font color="blue" size="4">新增用户:</font>
	<form action="${pageContext.request.contextPath}/user/insertUser.action" method="post" >
		<table width="100%"  align="center" border=1>
			<tr>
				<td>用户名称<font color="red">*</font></td>
				<td ><input name="userName" /></td>
				<td>用户描述</td>
				<td><input name="remark"/></td>
				<td colspan="2" rowspan="2"><input type="submit" value="保存"/></td>
			</tr>
			
		</table>
	</form>
<br/>
	<font color="blue" size="4">查找用户：</font>
	<form action="${pageContext.request.contextPath}/user/searchUser.action" method="post">
	<table width="100%" border=1>
	<tr>
	<td>用户名称:</td>
	<td><input type="text" name="userName"/></td>
	<td>用户描述:</td>
	<td><input type="text" name="remark"/></td>
	<td><input type="submit" value="查询"/></td>
	</tr>
	</table>
	</form>
<br/>
	<font color="blue" size="4">用户列表:</font>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href='javascript:document.userForm.submit();'><font color="red">批量删除</font></a>
	<form name="userForm" action="${pageContext.request.contextPath}/user/batchDeleteUser.action" method="post">
		<table width="100%" border=1>
		<tr>
			<td><p><input type="checkbox" onclick="checkboxed('ids')"/>全选/全不选</p></td>
			<td>用户名称</td>
			<td>创建时间</td>
			<td>关联设备数量</td>
			<td>用户简介</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${userList}" var="user">
		<tr>
			<td><input type="checkbox" name="ids" value="${user.uId}"/></td>
			<td>${user.userName }</td>
			<td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td>${user.deviceCount}</td>
			<td>${user.remark}</td>
			<td>
				<a href="${pageContext.request.contextPath }/user/findUserById.action?uId=${user.uId}">修改</a>
				<a href="${pageContext.request.contextPath }/user/deleteUser.action?uId=${user.uId}">删除</a>
				<a href="${pageContext.request.contextPath}/device/findAllDevice.action?uId=${user.uId}">关联设备</a>
			</td>
		</tr>
		</c:forEach>
		</table>
	</form>
</body>
<script type="text/javascript" >
	var temp = true;	
	function checkboxed(objName){
    var objNameList=document.getElementsByName(objName);
    if(null!=objNameList){
    	if(temp){
	        for(var i=0;i<objNameList.length;i++){
	            objNameList[i].checked="checked";
	        }
	        temp = false;
    	} else {
    		for(var i=0;i<objNameList.length;i++){
	            objNameList[i].checked="";
	        }
    		temp = true;
    	}
    }
}
</script>
</html>