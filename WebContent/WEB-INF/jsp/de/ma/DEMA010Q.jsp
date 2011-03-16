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

	<!--  start page-heading -->
	<div id="page-heading">
		<h1>Add product</h1>
	</div>
	<!-- end page-heading -->

	<table border="0" width="100%" cellpadding="0" cellspacing="0" id="content-table">
	<tr>
		<th rowspan="3" class="sized"><img src="${pageContext.request.contextPath}/images/shared/side_shadowleft.jpg" width="20" height="300" alt="" /></th>
		<th class="topleft"></th>
		<td id="tbl-border-top">&nbsp;</td>
		<th class="topright"></th>
		<th rowspan="3" class="sized"><img src="${pageContext.request.contextPath}/images/shared/side_shadowright.jpg" width="20" height="300" alt="" /></th>
	</tr>
	<tr>
		<td id="tbl-border-left"></td>
		<td>
		<!--  start content-table-inner ...................................................................... START -->
		<div id="content-table-inner">
		
			<!--  start table-content  -->
			<div id="table-content">
			
				<!--  start message-yellow -->
				<div id="message-yellow">
				<table border="0" width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td class="yellow-left">You have a new message. <a href="">Go to Inbox.</a></td>
					<td class="yellow-right"><a class="close-yellow"><img src="${pageContext.request.contextPath}/images/table/icon_close_yellow.gif"   alt="" /></a></td>
				</tr>
				</table>
				</div>
				<!--  end message-yellow -->
				
				<!--  start message-red -->
				<div id="message-red">
				<table border="0" width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td class="red-left">Error. <a href="">Please try again.</a></td>
					<td class="red-right"><a class="close-red"><img src="${pageContext.request.contextPath}/images/table/icon_close_red.gif"   alt="" /></a></td>
				</tr>
				</table>
				</div>
				<!--  end message-red -->
				
				<!--  start message-blue -->
				<div id="message-blue">
				<table border="0" width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td class="blue-left">Welcome back. <a href="">View my account.</a> </td>
					<td class="blue-right"><a class="close-blue"><img src="${pageContext.request.contextPath}/images/table/icon_close_blue.gif"   alt="" /></a></td>
				</tr>
				</table>
				</div>
				<!--  end message-blue -->
			
				<!--  start message-green -->
				<div id="message-green">
				<table border="0" width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td class="green-left">Product added sucessfully. <a href="">Add new one.</a></td>
					<td class="green-right"><a class="close-green"><img src="${pageContext.request.contextPath}/images/table/icon_close_green.gif"   alt="" /></a></td>
				</tr>
				</table>
				</div>
				<!--  end message-green -->
		
		 
				<!--  start product-table ..................................................................................... -->
				<form id="mainform" action="">
				<table border="0" width="100%" cellpadding="0" cellspacing="0" id="product-table">
				<tr>
					<th class="table-header-check"><a id="toggle-all" ></a> </th>
					<th class="table-header-repeat line-left minwidth-1"><a href="">주문자(아이디)</a></th>
					<th class="table-header-repeat line-left"><a href="">보낸사람(받는사람)</a></th>
					<th class="table-header-repeat line-left"><a href="">등록일</a></th>
					<th class="table-header-repeat line-left"><a href="">주소(우편번호)</a></th>
					<th class="table-header-repeat line-left"><a href="">가격</a></th>
					<th class="table-header-repeat line-left"><a href="">상품</a></th>
					<th class="table-header-repeat line-left"><a href="">상태</a></th>
				</tr>
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
				</table>
				<!--  end product-table................................... --> 
				</form>
			</div>
			<!--  end content-table  -->
		
			<!--  start actions-box ............................................... -->
			<div id="actions-box">
				<a href="" class="action-slider"></a>
				<div id="actions-box-slider">
					<a href="" class="action-edit">Edit</a>
					<a href="" class="action-delete">Delete</a>
				</div>
				<div class="clear"></div>
			</div>
			<!-- end actions-box........... -->
			
			<!--  start paging..................................................... -->
			<table border="0" cellpadding="0" cellspacing="0" id="paging-table">
			<tr>
			<td>
				<a href="" class="page-far-left"></a>
				<a href="" class="page-left"></a>
				<div id="page-info">Page <strong>1</strong> / 15</div>
				<a href="" class="page-right"></a>
				<a href="" class="page-far-right"></a>
			</td>
			<td>
			<select  class="styledselect_pages">
				<option value="">Number of rows</option>
				<option value="">1</option>
				<option value="">2</option>
				<option value="">3</option>
			</select>
			</td>
			</tr>
			</table>
			<!--  end paging................ -->
			
			<div class="clear"></div>
		 
		</div>
		<!--  end content-table-inner ............................................END  -->
		</td>
		<td id="tbl-border-right"></td>
	</tr>
	<tr>
		<th class="sized bottomleft"></th>
		<td id="tbl-border-bottom">&nbsp;</td>
		<th class="sized bottomright"></th>
	</tr>
	</table>
	<div class="clear">&nbsp;</div>
<a href="${pageContext.request.contextPath}/pr/ca/PRCA020Q.do" >등록</a>
<a href="${pageContext.request.contextPath}/pr/ca/PRCA020Q.do" >삭제</a>

</body>
</html>
