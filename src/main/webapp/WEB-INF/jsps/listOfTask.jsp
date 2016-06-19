<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>Insert title here</title>
</head>
<body>
	<h1>WELCOME TO COURSE LIST PAGE!</h1>
</body>

<table>
	<thead>
		<tr>
			<th>Task ID</th>
			<th>Task Title</th>
			<th>Total Group</th>
			<th>Total Submissions</th>
			<th>Task Deadline</th>

		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty tasks}">
			<c:forEach var="tasks" items="${tasks}">
				<tr>
					<td>${tasks.getTaskId()}</td>
					<td>${tasks.getTaskTitle()}</td>
					<td>${tasks.getTaskTotalGroupNo()}</td>
					<td>${tasks.getTaskTotalSubmissonNo()}</td>
					<td>${tasks.getTaskDeadline()}</td>

				</tr>
			</c:forEach>

		</c:if>
	</tbody>
</table>
<a href="<c:url value="/"/>">Index Page</a>


</html>