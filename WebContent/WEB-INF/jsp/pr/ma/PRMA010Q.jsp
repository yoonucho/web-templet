<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include/taglibs.jsp"%>
<html>
<head>
<title>게시판</title>
<meta name="decorator" content="shop_EX"/>
<script type="text/javascript">

$(document).ready(function(){
	
});
</script>

</head>

<body>


                <div id="box">
                	<h3>제품 목록</h3>
                	
		<form id="mainform" action="" method="get">
		<table>
			<tr>
				<td>검색조건 : <input name="src_title" value="${param.src_title }" type="text" /> <input
					id="button1" type="submit" value="Send" />
				</td>
			</tr>
		</table>

		<table width="100%">
			<thead>
				<tr>
					<th width="40px"><a href="#">번호</a>
					</th>
					<th width="100px"><a href="#">상품명
					</a>
					</th>
					<th><a href="#">가격</a>
					</th>
					<th><a href="#">카테고리</a>
					</th>
					<th width="70px"><a href="#">등록자</a>
					</th>
					<th width="70px"><a href="#">등록일</a>
					</th>
					<th width="70px"><a href="#">조회수</a>
					</th>
				</tr>
			</thead>
			<tbody>

<c:if test="${paginationInfo.list !=null }">
	<c:forEach var="map" items="${paginationInfo.list}" varStatus="status">
				<tr>
					<td class="a-center">232</td>
					<td><a href="${pageContext.request.contextPath}/pr/ma/PRMA030Q.do?prd_seq_no=${map.prd_seq_no }">${map.prd_nm }</a></td>
					<td>
						<a href="${pageContext.request.contextPath}/pr/ma/PRMA030Q.do?prd_seq_no=${map.prd_seq_no }">${map.prd_price }</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/pr/ma/PRMA030Q.do?prd_seq_no=${map.prd_seq_no }">${map.cate_nm }</a>
					</td>
					<td>${map.reg_nm }</td>
					<td>${map.reg_dt }</td>
					<td>${map.brd_hit }</td>
				</tr>
	</c:forEach>
</c:if>
<c:if test="${fn:length(paginationInfo.list)==0 }">
				<tr>
					<td class="a-center" colspan="7">데이터가 없습니다</td>
				</tr>
</c:if>
			</tbody>
		</table>
		<div id="pager">
              	Page <a href="#"><img src="${pageContext.request.contextPath}/img/icons/arrow_left.gif" width="16" height="16" /></a> 
           	<input size="1" value="${paginationInfo.currentPageNo }" type="text" name="currentPageNo" id="page" /> 
           	<a href="#"><img src="${pageContext.request.contextPath}/img/icons/arrow_right.gif" width="16" height="16" /></a>of ${paginationInfo.totalPageCount }
              pages | View <select name="view">
              				<option>10</option>
                              <option>20</option>
                              <option>50</option>
                              <option>100</option>
              			</select> 
              per page | Total <strong>${paginationInfo.totalRecordCount }</strong> records found
              </div>
              </form>
              
          </div>
	<a href="${pageContext.request.contextPath}/pr/ma/PRMA020Q.do" >등록</a>

</body>
</html>
