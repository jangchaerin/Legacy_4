<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} Reply page</h1>

	<form action="./reply" method="post">
		<input type="hidden" value="${dto.num}" name="num">
		Title<input type="text" name="title"> 
		Contents<input type="text" name="contents"> 
		Writer<input type="text" name="writer">

		<button type="submit">Reply</button>

	</form>
</body>
</html>
