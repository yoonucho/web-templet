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
					<th class="table-header-repeat line-left minwidth-1"><a href="">번호</a>	</th>
					<th class="table-header-repeat line-left minwidth-1"><a href="">제목</a></th>
					<th class="table-header-repeat line-left"><a href="">등록자</a></th>
					<th class="table-header-repeat line-left"><a href="">등록일</a></th>
					<th class="table-header-repeat line-left"><a href="">조회수</a></th>
				</tr>
<c:if test="${paginationInfo.list !=null }">
	<c:forEach var="map" items="${paginationInfo.list}" varStatus="status">
				<tr <c:if test="${(status.count mod 2)==0 }">class="alternate-row"</c:if>>
					<td><input  type="checkbox"/></td>
					<td>Sabev</td>
					<td>${map.brd_title }</td>
					<td>${map.reg_nm }</td>
					<td>${map.reg_dt }</td>
					<td>${map.brd_hit }</td>
				</tr>
	</c:forEach>
</c:if>
<!-- 				<tr> -->
<!-- 					<td><input  type="checkbox"/></td> -->
<!-- 					<td>Sabev</td> -->
<!-- 					<td>George</td> -->
<!-- 					<td><a href="">george@mainevent.co.za</a></td> -->
<!-- 					<td>R250</td> -->
<!-- 					<td><a href="">www.mainevent.co.za</a></td> -->
<!-- 					<td class="options-width"> -->
<!-- 					<a href="" title="Edit" class="icon-1 info-tooltip"></a> -->
<!-- 					<a href="" title="Edit" class="icon-2 info-tooltip"></a> -->
<!-- 					<a href="" title="Edit" class="icon-3 info-tooltip"></a> -->
<!-- 					<a href="" title="Edit" class="icon-4 info-tooltip"></a> -->
<!-- 					<a href="" title="Edit" class="icon-5 info-tooltip"></a> -->
<!-- 					</td> -->
<!-- 				</tr> -->
<!-- 				<tr class="alternate-row"> -->
<!-- 					<td><input  type="checkbox"/></td> -->
<!-- 					<td>Sabev</td> -->
<!-- 					<td>George</td> -->
<!-- 					<td><a href="">george@mainevent.co.za</a></td> -->
<!-- 					<td>R250</td> -->
<!-- 					<td><a href="">www.mainevent.co.za</a></td> -->
<!-- 					<td class="options-width"> -->
<!-- 					<a href="" title="Edit" class="icon-1 info-tooltip"></a> -->
<!-- 					<a href="" title="Edit" class="icon-2 info-tooltip"></a> -->
<!-- 					<a href="" title="Edit" class="icon-3 info-tooltip"></a> -->
<!-- 					<a href="" title="Edit" class="icon-4 info-tooltip"></a> -->
<!-- 					<a href="" title="Edit" class="icon-5 info-tooltip"></a> -->
<!-- 					</td> -->
<!-- 				</tr> -->
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
<a href="${pageContext.request.contextPath}/bd/ma/BDMA020Q.do" >등록</a>

</body>
</html>
