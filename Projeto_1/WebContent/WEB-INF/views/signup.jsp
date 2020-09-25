<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,br.edu.insper.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>
<h1>Sign Up</h1>
<form name="info" action="signup" method="post">
 		
	<label for="username">Username:</label><br>
	<input type="text" id="username" name="username"><br>
	<label for="pwd">Password:</label><br>
	<input type="password" id="pwd" name="pwd">
	<input type="submit" value="Sign Up">
</form> 

<p></p>
</body>
</html>