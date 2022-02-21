<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Notice List Page</h1>

	<table>
	<tr>
		<th>제목</th><th>컨텐츠</th><th>hit</th>
	</tr>
	<c:forEach items="${list }" var="notice">
	<tr>
		<td><a href="./detail?num=${notice.num}">${notice.title}</a></td>
		<td>${notice.contents}</td>
		<td>${notice.hit}</td>
	</tr>
	</c:forEach>
</table>
<a href="./add">ADD</a>


</body>
</html>