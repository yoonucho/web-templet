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
		<h3 id="adduser">제품
			<c:choose>
				<c:when test="${!empty frmSave.prd_seq_no && frmSave.prd_seq_no !=0 }">수정</c:when>
				<c:otherwise>등록</c:otherwise>
			</c:choose>
		</h3>
		
		<c:set var="ac" value="${pageContext.request.contextPath}/pr/ma/PRMA020T.do"/>
		<c:if test="${!empty frmSave.prd_seq_no && frmSave.prd_seq_no !=0 }">
			<c:set var="ac" value="${pageContext.request.contextPath}/pr/ma/PRMA030T.do"/>	
		</c:if>	
		
		<form:form action="${ac }" commandName="frmSave" id="frmSave" name="frmSave" method="post" enctype="multipart/form-data" cssClass="form">
		<form:errors/>
		<form:hidden path="prd_seq_no"/>
		
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
					<input type="file" name="file1" class="file_1"/>
				</td>
			</tr>
		</table>
		<div align="center">
			<c:choose>
				<c:when test="${!empty frmSave.prd_seq_no && frmSave.prd_seq_no !=0 }">
				<input id="button1" type="submit" value="수정" />
				</c:when>
				<c:otherwise>
				<input id="button1" type="submit" value="등록" />
				</c:otherwise>
			</c:choose>
			
		</div>
		</form:form>
	</div>

</body>
</html>
