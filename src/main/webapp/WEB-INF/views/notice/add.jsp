<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add page</h1>

	<form action="./add" id ='frm' method="post">
		Title<input type="text" name="title" id="title"> 
		Contents<input type="text" name="contents" > 
		Writer<input type="text" name="writer" id="writer"> 
		<input type="button" name="insert">
		<button type="buttun" id="btn">ADD</button>

	</form>
</body>
</html>
