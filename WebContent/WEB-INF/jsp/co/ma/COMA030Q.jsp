<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include/taglibs.jsp"%>
<html>
<head>
<title>게시판</title>
<!--<meta name="decorator" content="shop_EX"/>-->
<meta name="decorator" content="shop_usr"/>
<script type="text/javascript">

$(document).ready(function(){
	
});

function delSubmit(frmID){
	if(confirm("삭제하시겠습니까?")){
		$('#'+frmID).attr('action','${pageContext.request.contextPath}/co/ma/COMA040T.do');
		$('#'+frmID).submit();	
	}
}
</script>

</head>

<body>

	<div id="box">
		<h3 id="adduser">
			상세보기
		</h3>
		<table>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">카테고리명</td>
				<td width="510" bgcolor="#FFFFFF">
					${map.code_nm }(코드:${map.code_seq_no })
				</td>
			</tr>
		</table>
		
		<table width="100%">
			<thead>
				<tr>
					<th>코드고유번호</th>
					<th>코드명</th>
					<th>사용여부</th>
					<th>등록자</th>
					<th>등록일</th>
					<th>상태</th>
				</tr>
			</thead>
			<tbody>
<c:if test="${list !=null }">
	<c:forEach var="map1" items="${list}" varStatus="status">
			<tr>
					<form action="${pageContext.request.contextPath}/co/ma/COMA030T.do" id="frmSave${status.count }" name="frmSave${status.count }" method="post">
					<input type="hidden" name="code_seq_no" value="${map1.code_seq_no }"/>
					<input type="hidden" name="code_p_seq_no" value="${map1.code_p_seq_no }"/>
					<td><input name="code" type="text" value="${map1.code }" readonly="readonly" style="width: 60px;"/></td>
					<td><input name="code_nm" type="text" value="${map1.code_nm}"  style="width: 60px;"/></td>
					<td>
						<input name="use_yn" type="radio" value="Y" <c:if test="${map1.use_yn=='Y'}">checked="checked"</c:if>/>사용
						<input name="use_yn" type="radio" value="N" <c:if test="${map1.use_yn!='Y'}">checked="checked"</c:if>/>미사용
					</td>
					<td><input name="reg_nm" type="text" value="${map1.reg_nm}"/></td>
					<td><input name="reg_dt" type="text" value="${map1.reg_dt}"/></td>
					<td><a href="#" onclick="$('#frmSave${status.count }').submit();" >저장</a> 
						<a href="#" onclick="delSubmit('frmSave${status.count }');" >삭제</a>
					</td>
				</form>
			</tr>
	</c:forEach>
</c:if>
		<tr id="newCode" >
			<form action="${pageContext.request.contextPath}/co/ma/COMA020T.do" id="frmSaveI" name="frmSaveI"  method="post">
			<input type="hidden" name="code_p_seq_no" value="${map.code_seq_no }" />
				<td>신규 저장</td>
				<td>코드:<input name="code" type="text" value=""  style="width: 60px;"/></td>
				<td>코드명:<input name="code_nm" type="text" value="" style="width: 60px;"/></td>
				<td colspan="2">
					<input name="use_yn" type="radio" value="Y" checked="checked"/>사용
					<input name="use_yn" type="radio" value="N"/>미사용
				</td>
				<td><a href="#" onclick="$('#frmSaveI').submit();" >저장</a> </td>
			</form>
		</tr>
			</tbody>
		</table>
	</div>



		

</body>
</html>
