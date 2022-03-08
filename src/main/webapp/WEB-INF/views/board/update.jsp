<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} Update Page</h1>

	<form action="./update" method="post">
		<input type="hidden" name="num" value="${dto.num }"> Title<input
			type="text" name="title" value="${dto.title}"> Contents
		<textarea name="contents" rows="10" cols="">${dto.contents}</textarea>



		<input type="submit" name="insert">
		<button type="submit">ADD</button>
	</form>
</body>
</html>