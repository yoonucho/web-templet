<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:if test="${paginationInfo.totalPageCount > paginationInfo.pageSize}">
	<c:if test="${paginationInfo.firstPageNoOnPageList > paginationInfo.pageSize}">
		<a href="${_uri}?currentPageNo=1${paginationInfo.prameter}">
		<img src="img/b_fir.gif" border="0" alt="처음으로가기" style="vertical-align: middle;" /></a>
		
		<a href="${_uri}?currentPageNo=${paginationInfo.firstPageNoOnPageList-1}${paginationInfo.prameter}">
		<img src="img/b_f.gif" border="0" alt="이전보기" style="vertical-align: middle;" /></a>
	</c:if>
	<c:if test="${paginationInfo.firstPageNoOnPageList <= paginationInfo.pageSize}">
	</c:if>
</c:if>

<c:forEach var="result1" begin="${paginationInfo.firstPageNoOnPageList}" end="${paginationInfo.lastPageNoOnPageList}" step="1" varStatus="status">
	<c:if test="${result1 == paginationInfo.currentPageNo}">
		<strong><c:out value="${result1}"></c:out></strong>
	</c:if>
	<c:if test="${result1 != paginationInfo.currentPageNo}">
		<a href="${_uri}?currentPageNo=${result1}${paginationInfo.prameter}" >
		<c:out value="${result1}"></c:out></a>
	</c:if>

	<c:if test="${result1 != paginationInfo.lastPageNoOnPageList}">&nbsp;</c:if>
</c:forEach>

<c:if test="${paginationInfo.totalPageCount > paginationInfo.pageSize}">
	<c:if test="${paginationInfo.totalPageCount <= paginationInfo.lastPageNoOnPageList}">
	</c:if>
	<c:if test="${paginationInfo.totalPageCount > paginationInfo.lastPageNoOnPageList}">
		<a href="${_uri}?currentPageNo=${paginationInfo.lastPageNoOnPageList+1}${paginationInfo.prameter}">
		<img src="img/b_b.gif" border="0" alt="다음보기" style="vertical-align: middle;" /></a>
		
		<a href="${_uri}?currentPageNo=${paginationInfo.lastPageNo}${paginationInfo.prameter}">
		<img src="img/b_e.gif" border="0" alt="마지막보기" style="vertical-align: middle;" /></a>
	</c:if>
</c:if>