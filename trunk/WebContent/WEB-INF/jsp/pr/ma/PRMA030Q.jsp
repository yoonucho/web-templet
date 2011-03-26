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
$(window).load(function(){
	$.tv.addLikePd('${map.prd_seq_no }',"pd_img");	
});

</script>

</head>

<body>


	<div id="box">
		<h3 id="adduser">
			상세보기
		</h3>
		<form action="${pageContext.request.contextPath}/pr/ma/PRMA031Q.do"
		name="frmSave" id="frmSave" method="post" class="form">
		<input type="hidden" name="prd_seq_no" value="${map.prd_seq_no }" /> 
		
				<table>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">제품 카테고리</td>
				<td width="510" bgcolor="#FFFFFF">
					${map.cate_nm }
				</td>
			</tr>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">제품명</td>
				<td width="510" bgcolor="#FFFFFF">
					${map.prd_nm }
				</td>
			</tr>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">가격</td>
				<td width="510" bgcolor="#FFFFFF">
					${map.prd_price }원
				</td>
			</tr>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">적립금</td>
				<td width="510" bgcolor="#FFFFFF">
					${map.prd_save }%
				</td>
			</tr>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">제품 상세내용</td>
				<td width="510" bgcolor="#FFFFFF">
					<textarea name="prd_content" rows="" cols="" style="width:300px;height:300px;">${map.prd_content }</textarea>
				</td>
			</tr>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">제품이미지</td>
				<td width="510" bgcolor="#FFFFFF">
					<c:if test="${!empty map.prd_img && map.prd_img!='' }">
					<div  id="pd_img">
						<img src="${pageContext.request.contextPath}${map.prd_img }" style="width:100px;height:100px;" />
					</div>
					</c:if>
				</td>
			</tr>
		</table>
		<div align="center">
			<input id="button1" type="submit" value="수정" />
		</div>
		</form>
	</div>

</body>
</html>
