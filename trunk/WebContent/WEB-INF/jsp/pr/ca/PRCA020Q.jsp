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
		<h3 id="adduser">
			<c:choose>
				<c:when test="${!empty frmSave.cate_seq_no && frmSave.cate_seq_no !=0 }">수정</c:when>
				<c:otherwise>등록</c:otherwise>
			</c:choose>
		</h3>
		<c:set var="ac" value="${pageContext.request.contextPath}/pr/ca/PRCA020T.do"/>
		<c:if test="${!empty frmSave.cate_seq_no && frmSave.cate_seq_no !=0 }">
			<c:set var="ac" value="${pageContext.request.contextPath}/pr/ca/PRCA030T.do"/>	
		</c:if>
	
		<form:form action="${ac }" commandName="frmSave" id="frmSave" name="frmSave" method="post" class="form">
		<form:errors/>
		<form:hidden path="cate_seq_no"/>
		<form:hidden path="cate_depth" value="1"/>
		
				<table>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">카테고리명</td>
				<td width="510" bgcolor="#FFFFFF">
					<form:input path="cate_nm"/>
				</td>
			</tr>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">사용여부</td>
				<td width="510" bgcolor="#FFFFFF">	
					<c:if test="${!empty frmSave.use_yn}">
						<form:radiobutton path="use_yn" label="사용" value="Y" />
					</c:if>
					<c:if test="${empty frmSave.use_yn}">
						<form:radiobutton path="use_yn" label="사용" value="Y" checked="checked"/>
					</c:if>
					
					<form:radiobutton path="use_yn" label="미사용" value="N"/>
				</td>
			</tr>
		</table>
		<div align="center">
			<c:choose>
				<c:when test="${!empty frmSave.cate_seq_no && frmSave.cate_seq_no !=0 }">
				<input id="button1" type="submit" value="수정" />
				</c:when>
				<c:otherwise>
				<input id="button1" type="submit" value="등록" />
				</c:otherwise>
			</c:choose>
			<input id="button2" type="reset" value="초기화" />
		</div>
		</form:form>
	</div>
</body>
</html>
