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

function delSubmit(frmID){
	if(confirm("삭제하시겠습니까?")){
		$('#'+frmID).attr('action','${pageContext.request.contextPath}/co/ma/COMA040T.do');
		$('#'+frmID).submit();	
	}
}
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
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">코드명</td>
				<td width="510" bgcolor="#FFFFFF">
					${map.code_nm }(코드:${map.code_seq_no })
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

<table>
<tr>
	<th>코드고유번호</th>
	<th>코드명</th>
	<th>사용여부</th>
	<th>등록자</th>
	<th>등록일</th>
	<th>상태</th>
</tr>
<c:if test="${list !=null }">
	<c:forEach var="map1" items="${list}" varStatus="status">
		<tr>
			<form action="${pageContext.request.contextPath}/co/ma/COMA030T.do" id="frmSave${status.count }" name="frmSave${status.count }" method="post">
				<input type="hidden" name="code_seq_no" value="${map1.code_seq_no }"/>
				<input type="hidden" name="code_p_seq_no" value="${map1.code_p_seq_no }"/>
				<td><input name="code" type="text" value="${map1.code }" readonly="readonly"/></td>
				<td><input name="code_nm" type="text" value="${map1.code_nm}"/></td>
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
				<td>코드:<input name="code" type="text" value=""/></td>
				<td>코드명:<input name="code_nm" type="text" value=""/></td>
				<td colspan="2">
					<input name="use_yn" type="radio" value="Y" checked="checked"/>사용
					<input name="use_yn" type="radio" value="N"/>미사용
				</td>
				<td><a href="#" onclick="$('#frmSaveI').submit();" >저장</a> </td>
			</form>
		</tr>
</table>

<div class="clear">&nbsp;</div>

</div>

</body>
</html>
