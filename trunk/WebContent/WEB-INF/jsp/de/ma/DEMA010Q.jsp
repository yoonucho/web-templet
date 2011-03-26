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
                	<h3>주문 목록</h3>
                	
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
					<th width="40px"><a href="#">번호</a></th>
					<th width="100px"><a href="#">주문자(아이디)</a></th>
					<th><a href="#">보낸사람(받는사람)</a></th>
					<th><a href="#">등록일</a></th>
					<th><a href="#">주소(우편번호)</a></th>
					<th><a href="#">가격</a></th>
					<th><a href="#">상품</a></th>
					<th><a href="#">상태</a></th>
				</tr>
			</thead>
			<tbody>

<c:if test="${paginationInfo.list !=null }">
	<c:forEach var="map" items="${paginationInfo.list}" varStatus="status">
				<tr <c:if test="${(status.count mod 2)==0 }">class="alternate-row"</c:if>>
					<td><input  type="checkbox"/></td>
					<td>
						<a href="${pageContext.request.contextPath}/de/ma/DEMA030Q.do?del_seq_no=${map.del_seq_no }">${map.reg_nm }(${map.usr_id })</a>
					</td>
					<td>${map.from_usr }(${map.to_usr })</td>
					<td>${map.reg_dt }</td>
					<td>${map.addr1 } ${map.addr2 }(${map.zip1 }-${map.zip2 })</td>
					<td>${map.del_pay }</td>
					<td>
		<c:forEach var="map1" items="${map.list}" varStatus="status">
			${map1.prd_nm }(수량 : ${map1.del_cnt })
			<br/>
		</c:forEach>
					</td>
					<td>
						<select name="">
							<option name="1" <c:if test="${map.status =='1' }">selected="selected"</c:if>>대기</option>
							<option name="2" <c:if test="${map.status =='2' }">selected="selected"</c:if>>발송중</option>
							<option name="3" <c:if test="${map.status =='3' }">selected="selected"</c:if>>취소</option>
							<option name="4" <c:if test="${map.status =='4' }">selected="selected"</c:if>>배송완료</option>
						</select>
					</td>
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

<a href="${pageContext.request.contextPath}/pr/ca/PRCA020Q.do" >삭제</a>

</body>
</html>
