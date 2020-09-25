<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
<form action="update"  method= "post">
Task: <input type="text" name="task" value="${param.task}"><br>
Tag: <input type="text" name="tag" value="${param.tag}"><br>
<input type="hidden" name="id" value="${param.id}">
<input type="submit" value="update">

</form>


</body>
</html>