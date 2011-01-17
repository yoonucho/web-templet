<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">
	function writeView(){
		document.location.href="<c:url value='/formBoard.do'/>";
	}
</script>
<title>Insert title here</title>
</head>
<body>
<table border="2">
	<tr>
		<td>글번호</td>
		<td>제목</td>
		<td>글쓴이</td>
		<td>히트수</td>
		<td>날짜</td>
	</tr>
<c:forEach var="blist" items="${list}">
	<tr>
		<td>${blist.seq}</td>
		<td><a href="<c:url value='/viewBoard.do'/>?seq=${blist.seq}">${blist.subject}</a></td>
		<td>${blist.writer}</td>
		<td>${blist.hit}</td>
		<td>${blist.wDate}</td>
	</tr>
</c:forEach>
	<tr>
		
	</tr>
</table>
<table>
	<tr>
		<td><a href="javascript: writeView()">글쓰기</a> </td>
	</tr>
</table>

<form:form action="/vd/test/insert.do" commandName="data"  name="data" method="post">
<form:errors/>

<table>
	<tr>
		<td>
<form:input path="name"  />

<form:errors path="name"  />
		
		</td>
	</tr>
<tr>
		<td>
<form:input path="name1"  />
		
		</td>
	</tr>
</table>

<input type="submit" value="저장"/>
</form:form>

<!---->
<!--<form action="/vd/test/insert.do" name="test" method="post"> -->
<!---->
<!--<input name="name" value="" />-->
<!---->
<!--<input type="submit" value="저장"/>-->
<!--</form>-->


</body>
</html>