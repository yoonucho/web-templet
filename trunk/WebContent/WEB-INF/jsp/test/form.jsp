<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">	
	function insert() {
		document.boardForm.action = "<c:url value='/insertBoardTest.do'/>";
		document.boardForm.submit();
	}
</script>
<title>Insert title here</title>
</head>
<body>

<form:form commandName="boardTest" method="post"  id="boardForm" name="boardForm" enctype="multipart/form-data"> 
<table border="2">
	<tr><td>글번호:</td>
		<td><form:input path="seq" id="seq"/></td>
	</tr>	
	<tr><td>제목:</td>
		<td><form:input path="subject" id="subject"/></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><form:input path="note" id="note"/></td>
	</tr>
	<tr>
		<td>글쓴이</td>
		<td><form:input path="writer" id="writer"/></td>
	</tr>
</table>
</form:form>
<a href="javascript: insert();">저장</a>
</body>
</html>