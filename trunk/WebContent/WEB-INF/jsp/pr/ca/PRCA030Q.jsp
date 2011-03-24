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
	<form action="${pageContext.request.contextPath}/pr/ca/PRCA031Q.do"
		name="frmSave" id="frmSave" method="post">
	<input type="hidden" name="cate_seq_no" value="${map.cate_seq_no }" /> 
		<table>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">카테고리명</td>
				<td width="510" bgcolor="#FFFFFF">
					${map.cate_nm }(코드:${map.cate_seq_no })
				</td>
			</tr>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">사용여부</td>
				<td width="510" bgcolor="#FFFFFF">
					<c:if test="${map.use_yn=='Y' }">사용</c:if>
					<c:if test="${map.use_yn!='Y' }">미사용</c:if>
				</td>
			</tr>

			<tr>
				<th>&nbsp;</th>
				<td valign="top"><input type="button" value=""
					onclick="frmSave.submit();" class="form-submit" /> <input
					type="reset" value="" class="form-reset" /></td>
				<td></td>
			</tr>
		</table>
	</form>
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