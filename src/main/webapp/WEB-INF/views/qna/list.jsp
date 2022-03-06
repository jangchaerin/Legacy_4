<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<h1>Qna List Page</h1>
	<div>
		<form action="./list" method="get">
			<fieldset>
				<select name="kind">
					<option value="col1">제목</option>
					<option value="col2">내용</option>
					<option value="col3">작성자</option>
				</select>
				<input type="text" name="search" value="${pager.search}">
				<button type="submit">검색</button>
			</fieldset>
		</form>
	</div>
	<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>컨텐츠</td>
			<td>작성자</td>
			<td>Hit</td>
			<td>날짜</td>
			<td>Ref</td>
			<td>Step</td>
			<td>Depth</td>
			
		</tr>
		<c:forEach items="${list }" var="qna">
			<tr>
				<td>${qna.num}</td>
				<td><a href="./detail?num=${qna.num}">${qna.title}</a></td>
				<td>${qna.contents}</td>
				<td>${qna.writer}</td>
				<td>${qna.hit}</td>
				<td>${qna.regDate}</td>
				<td>${qna.ref}</td>
				<td>${qna.step}</td>
				<td>${qna.depth}</td>
			</tr>
		</c:forEach>
		</table>
		
		<div>
			<c:if test="${pager.pre}">
				<a href="./list?page=${pager.startNum-1}">Preview</a>
			</c:if>	
			
			<c:forEach begin="${pager.startNum}" end ="${pager.lastNum}" step="1" var="i">
				<a href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
			</c:forEach>
		
			<c:if test="${pager.next}">
				<a href="./list?page=${pager.lastNum+1}">NEXT</a>
			</c:if>
	
		</div>
	
	
	<a href="./add">ADD</a>


</body>
</html>