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
	
	<c:set var="ac" value="${pageContext.request.contextPath}/pr/ma/PRMA020T.do"/>
	<c:if test="${!empty frmSave.prd_seq_no && frmSave.prd_seq_no !=0 }">
		<c:set var="ac" value="${pageContext.request.contextPath}/pr/ma/PRMA030T.do"/>	
	</c:if>

	${ac }
	<form:form action="${ac }" commandName="frmSave" id="frmSave" name="frmSave" method="post" enctype="multipart/form-data">
	<form:hidden path="prd_seq_no"/>
	<form:errors/>
		<table>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">제품 카테고리</td>
				<td width="510" bgcolor="#FFFFFF">
					<form:select path="cate_seq_no">
						<form:option value="0">없음</form:option>
						<form:options items="${cateList }" itemLabel="cd_nm" itemValue="cd"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">제품명</td>
				<td width="510" bgcolor="#FFFFFF">
					<form:input path="prd_nm"/>
				</td>
			</tr>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">가격</td>
				<td width="510" bgcolor="#FFFFFF">
					<form:input path="prd_price"/>원
				</td>
			</tr>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">적립금</td>
				<td width="510" bgcolor="#FFFFFF">
					<form:input path="prd_save"/>%
				</td>
			</tr>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">제품 상세내용</td>
				<td width="510" bgcolor="#FFFFFF">
					<form:textarea path="prd_content" cssStyle="width:300px;height:300px;"/>
				</td>
			</tr>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">제품이미지</td>
				<td width="510" bgcolor="#FFFFFF">
					<c:if test="${!empty frmSave.prd_img && frmSave.prd_img !='' }">
					<img src="${pageContext.request.contextPath}${frmSave.prd_img }" style="width:100px;height:100px;" />
					
					<br/>
					<form:checkbox path="del1" value="${frmSave.prd_img }" label="삭제"/>
					<form:hidden path="file_name1" value="${frmSave.prd_img }"/>
					<br/>
					</c:if>
					<input type="file" name="file1"/>
					
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
	</form:form>
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
