<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Qna Update Page</h1>

<form action="./update" method="POST">
	num<input type="text" readonly ="readonly" name="num" value="${dto.num}">
	title<input type="text" name="title" value="${dto.title}">
	contents<input type="text" name="contents" value="${dto.contents}">
	
	<input type="submit" value="Update">
	
	
	

</form>


</body>
</html>