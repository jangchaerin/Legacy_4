<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>QnA Add Page</h1>
	
	<form action="./add" method="post">
		Title<input type="text" name="title" id="title">
		Contents<textarea name="contents" rows="" cols=""></textarea>
		Writer<input type="text" name="writer" id="writer">
		
		<button type="submit">ADD</button>
		
	
	</form>

</body>
</html>