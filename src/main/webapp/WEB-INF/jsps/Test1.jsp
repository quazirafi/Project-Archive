<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table id="t1">
		<th>Course Title</th>
		<th>Course Code</th>
		<th>Credit</th>
		<c:forEach items="${courses}" var="courses">
        <tr>
            <td><c:out value="${courses.getCourseTitle()}"/></td>
            <td><c:out value="${courses.getCredit()}"/></td>
            <td><c:out value="${courses.getCourseCode()}"/></td>
        </tr>
    </c:forEach>
	</table>
	<table id="t1">
		<th>Username</th>
		<th>Password</th>
		<c:forEach items="${users}" var="users">
        <tr>
            <td><c:out value="${users.getUserName()}"/></td>
            <td><c:out value="${users.getPassword()}"/></td>
        </tr>
    </c:forEach>
	</table>
</body>
</html>