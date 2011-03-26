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
			상세보기
		</h3>
		<form action="${pageContext.request.contextPath}/pr/ca/PRCA031Q.do"
		name="frmSave" id="frmSave" method="post" class="form">
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
		</table>
		<div align="center">
			<input id="button1" type="submit" value="수정" />
		</div>
		</form>
	</div>

</body>
</html>
