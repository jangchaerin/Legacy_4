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
	<h1>${board} Detail Page</h1>
	<h3>Name:${dto.title}</h3>
	<h3>Contents:${dto.contents}</h3>
	<h3>Writer:${dto.writer}</h3>

	<a href="./list">List</a>
	<a href="./update?num=${dto.num}">Update</a>
	<a href="./delete?num=${dto.num}">Delete</a>
	<c:if test="${board ne 'notice'}" >
	<a href="./reply?num=${dto.num} ">Reply</a>
	</c:if>
</body>
</html>