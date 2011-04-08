<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include/taglibs.jsp"%>
<html>
<head>
<title>게시판</title>
<!--<meta name="decorator" content="shop_EX"/>-->
<meta name="decorator" content="shop_usr"/>
<script type="text/javascript">

$(document).ready(function(){
	
});
</script>

</head>

<body>

<form name="" method="get" action="">
<input name="dong" type="text" value="${param.dong}"/>
<input type="submit" value="검색"/>

</form>

<table width="100%">
	<thead>
		<tr>
			<th width="40px">우편번호</th>
			<th>주소</th>
			<th>번지</th>
		</tr>
	</thead>
	<tbody>

<c:if test="${list !=null }">
	<c:forEach var="map" items="${list}" varStatus="status">
		<tr>
			<td class="a-center">${map.zipcode }</td>
			<td class="a-center">${map.sido } ${map.gugun } ${map.dong }</td>
			<td>${map.bunji }</td>
		</tr>
	</c:forEach>
</c:if>
	</tbody>
</table>

</body>
</html>
