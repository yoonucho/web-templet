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

<div id="page-heading"><h1>Add product</h1></div>


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
	<!--  start content-table-inner -->
	<div id="content-table-inner">
	<form action="${pageContext.request.contextPath}/bd/ma/BDMA050T.do" name="frmSave" id="frmSave" method="post" enctype="multipart/form-data">
	<input name="brd_seq_no" type="hidden" value="${map.brd_seq_no }"/>
	
	<table border="0" width="100%" cellpadding="0" cellspacing="0">
	<tr valign="top">
	<td>
	
	
		<!-- start id-form -->
		<table border="0" cellpadding="0" cellspacing="0"  id="id-form">
		<tr>
			<th valign="top">제목</th>
			<td><input name="brd_title" type="text" value="${map.brd_title }" class="inp-form" /></td>
			<td></td>
		</tr>
	<tr>
		<th valign="top">내용</th>
		<td><textarea name="content" rows="" cols="" class="form-textarea">${map.content }</textarea></td>
		<td></td>
	</tr>
<c:if test="${filList !=null }">
	<c:forEach var="map" items="${filList}" varStatus="status">
	<tr>
		<th>Image ${status.count }:</th>
		<td>
		<input name="del${status.count }" type="checkbox" value="${map.file_seq_no }" id="del${status.count }"  /><label for="del${status.count }">삭제</label>
		<input type="hidden" name="file_name${status.count }" value="${map.file_seq_no }" />
		<a href="${pageContext.request.contextPath}/bd/ma/downloadFile.do?m_file_nm=${map.m_file_nm}&v_file_nm=${map.v_file_nm}">${map.v_file_nm}</a>
		
		<br/>
		<input type="file" class="file_1" name="file${status.count }" />
		</td>
		<td>
			<div class="bubble-left"></div>
			<div class="bubble-inner">JPEG, GIF 5MB max per image</div>
			<div class="bubble-right"></div></td>
	</tr>
	</c:forEach>
	<c:forEach var="i" begin="${fn:length(filList)+1 }" end="3" step="1">
	<tr>
		<th>Image ${i }:</th>
		<td><input type="file" class="file_1" name="file${i }" />
		</td>
		<td>
			<div class="bubble-left"></div>
			<div class="bubble-inner">JPEG, GIF 5MB max per image</div>
			<div class="bubble-right"></div></td>
	</tr>
	</c:forEach>
</c:if>
<c:if test="${filList ==null }">
	<tr>
		<th>Image 1:</th>
		<td><input type="file" class="file_1" name="file1" />
		</td>
		<td>
			<div class="bubble-left"></div>
			<div class="bubble-inner">JPEG, GIF 5MB max per image</div>
			<div class="bubble-right"></div></td>
	</tr>
	<tr>
		<th>Image 2:</th>
		<td><input type="file" class="file_1" name="file2" />
		</td>
		<td><div class="bubble-left"></div>
			<div class="bubble-inner">JPEG, GIF 5MB max per image</div>
			<div class="bubble-right"></div>
		</td>
	</tr>
	<tr>
		<th>Image 3:</th>
		<td><input type="file" class="file_1" name="file3" />
		</td>
		<td><div class="bubble-left"></div>
			<div class="bubble-inner">JPEG, GIF 5MB max per image</div>
			<div class="bubble-right"></div>
		</td>
	</tr>
</c:if>

	<tr>
		<th>&nbsp;</th>
		<td valign="top">
			<input type="button" value="" onclick="frmSave.submit();" class="form-submit" />
			<input type="reset" value="" class="form-reset"  />
		</td>
		<td></td>
	</tr>
	</table>
	</form>
	<!-- end id-form  -->

	</td>
	<td>


</td>
</tr>
<tr>
<td><img src="${pageContext.request.contextPath}/images/shared/blank.gif" width="695" height="1" alt="blank" /></td>
<td></td>
</tr>
</table>
 
<div class="clear"></div>
 

</div>
<!--  end content-table-inner  -->
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

</div>

</body>
</html>
