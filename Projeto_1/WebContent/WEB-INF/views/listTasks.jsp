<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,br.edu.insper.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tasks</title>
</head>
<body>
<h1>Welcome, ${sessionScope["username"]}</h1>
<table border="1">

<c:forEach var="task" items="${tasks}">
<tr>
<td>${task.task}</td>
<td>${task.tag}</td>
<td>${task.creDate}</td>

<td>
<form action="remove" method="post">
<input type="hidden" name="id" value="${task.id}">
<input type="submit" value="remove">
</form>
</td>

<td>
<form action="update" method="get">
<input type="hidden" name="id" value="${task.id}">
<input type="hidden" name="user" value="${task.user}">
<input type="hidden" name="task" value="${task.task}">
<input type="hidden" name="tag" value="${task.tag}">
<input type="submit" value="update">
</form>
</td>

</c:forEach>
</table>

<form action="create" method="get">
<input type="submit" value="create">

</form>

<form action="login" method="get">
<input type="submit" value="exit">

</form>

</body>
</html>