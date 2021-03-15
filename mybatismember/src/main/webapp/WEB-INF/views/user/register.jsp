<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>User</title>
</head>

<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<script>
	$(document).ready(function() {

		var formObj = $("#member");

		$("#btnRegister").on("click", function() {
			formObj.attr("action", "/user/register");
			formObj.attr("method", "post");
			formObj.submit();
		});

	});
</script>

<body>
	<h3>REGISTER</h3>
	
	<form:form modelAttribute="member" action="register">
		<table>
			<tr>
				<td>userid</td>
				<td><form:input path="userId" /></td>
				<td><font color="red"><form:errors path="userId" /></font></td>
			</tr>
			<tr>
				<td>userpw</td>
				<td><form:input path="userPw" /></td>
				<td><font color="red"><form:errors path="userPw" /></font></td>
			</tr>
			<tr>
				<td>username</td>
				<td><form:input path="userName" /></td>
				<td><font color="red"><form:errors path="userName" /></font></td>
			</tr>
		</table>
	</form:form>
	
	<div>
		<button type="submit" id="btnRegister">Register</button>
	</div>
</body>
</html>
