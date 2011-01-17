<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">
	function goList(){
		document.location.href="<c:url value='/boardTestlist.do'/>";
	}
	
	function delete_article(){
		document.location.href="<c:url value='/deleteBoardTest.do?seq='/>${boardTest.seq}";
	}
</script>
<title>Insert title here</title>
</head>
<body>
<table border="2">
	<tr><td>글번호:</td>
		<td>${boardTest.seq}</td>
	</tr>	
	<tr><td>제목:</td>
		<td>${boardTest.subject}</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>${boardTest.note}</td>
	</tr>
	<tr>
		<td>글쓴이</td>
		<td>${boardTest.writer}</td>
	</tr>
</table>
<a href="javascript: goList();">글목록으로..</a>
<a href="javascript: delete_article();">삭제</a>
<a></a>
</body>
</html>