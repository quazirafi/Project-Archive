<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Student List Page!</h1>

	<table>
		<thead>
			<tr>
				<th>Student ID</th>
				<th>Student Reg</th>
				<th>Student Name</th>
				<th>Session</th>
			</tr>
		</thead>

		<tbody>
			<c:if test="${not empty students}">
				<c:forEach var="student" items="${students}">
					<tr>
						<td>${student.getIdStudent()}</td>
						<td><a href="<c:url value='/profile'/>" name="regNo"
							value="${student.getRegistrationNo()}">${student.getRegistrationNo()}</a></td>
						<td>${student.getName()}</td>
						<td>${student.getSession()}</td>
					</tr>
				</c:forEach>

			</c:if>
		</tbody>
	</table>

	<a href="<c:url value="/"/>">Index Page</a>
</body>
</html>