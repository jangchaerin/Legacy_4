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
	
	<div>
		<c:forEach items="${dto.fileDTOs}" var="f"> <!-- f라는 변수에 filedtos를 담는다 -->
		<%-- <a href="../resources/upload/${board}/${f.fileName}">${f.oriName}</a> --%>
				<!-- image태그가 아니라 a태그 씀. 첨부파일이 꼭 이미지일 경우는 없기때문 -->
				<!-- ${board} 를 써주는 이유는 notice일떄와 qna일때 저장되는 폴더가 다르기때문-->
				<a href="./fileDown?fileNum=${f.fileNum}">${f.oriName}</a> 

		</c:forEach>
		
	</div>
	
	<hr>
   
	<form action="../noticeReply/add" method="post" enctype="application/x-www-form-urlencoded">
		<input type="hidden" name="num" value="${dto.num}" id="num">
   		<input type="text" readonly name="writer" value="${member.id}" id="writer">
   		<textarea rows="" cols="" name="contents" id="contents"></textarea>
   		<button type="button" id ="reply">Reply</button>
   </form>
	
	<table id="replyResult">
		
	</table>
	
	
	
	
	<a href="./list">List</a>
	
	<c:if test="${member.id eq dto.writer}">
		<a href="./update?num=${dto.num}">Update</a>
		<a href="./delete?num=${dto.num}">Delete</a>
	</c:if>
	
	<c:if test="${board ne 'notice'}" >
	<a href="./reply?num=${dto.num} ">Reply</a>
	</c:if>

	<script src="../resources/js/noticeReply.js"></script>
</body>
</html>