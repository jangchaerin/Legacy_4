<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>QnA Detail Page</h1>
	<h3>제목:${dto.title}</h3>
	<h3>컨텐츠:${dto.contents}</h3>
	<h3>작성자:${dto.writer}</h3>


	<a href="./list">List</a>
	<a href="./update?num=${dto.num}">Update</a>
	<a href="./delete?num=${dto.num}">Delete</a>

</body>
</html>