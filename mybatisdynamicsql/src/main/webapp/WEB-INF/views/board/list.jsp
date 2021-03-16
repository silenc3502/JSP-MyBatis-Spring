<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>Board</title>
</head>
<body>
	<form:form modelAttribute="board" method="POST" action="search">
	<h2>LIST</h2>
	TITLE : <form:input path="title" /><input type="submit" value="Search" />
	<a href="register">New</a>
	<table border="1">
		<tr>
			<th align="center" width="60">NO</th>
			<th align="center" width="300">TITLE</th>
			<th align="center" width="100">WRITER</th>
			<th align="center" width="180">REGDATE</th>
		</tr>
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="4">
						List is empty.
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="board">
					<tr>
						<td align="center">${board.boardNo}</td>
						<td align="left"><a href="/board/read?boardNo=${board.boardNo}">${board.title}</a></td>
						<td align="right">${board.writer}</td>
						<td align="center"><javatime:format value="${board.regDate}" pattern="yyyy-MM-dd HH:mm" /></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	</form:form>
</body>
</html>
