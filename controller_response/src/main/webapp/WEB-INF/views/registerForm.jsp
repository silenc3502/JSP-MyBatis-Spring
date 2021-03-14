<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>Register Form</h1>
	
	<a href="getRegister?userId=hongkd&password=1234">register?userId=hongkd&amp;password=1234</a> <br>
	
	<form action="/postRegister" method="post">
		userId: <input type="text" name="userId" value="hongkd"><br>
		password: <input type="text" name="password" value="1234"><br>
		<input type="submit" value="등록">
	</form>
</body>
</html>
