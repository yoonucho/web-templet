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
		<h3 id="adduser">상세보기</h3>
		<form action="${pageContext.request.contextPath}/us/ma/USMA031Q.do"
		name="frmSave" id="frmSave" method="post" class="form">
		<input type="hidden" name="usr_id" value="${map.usr_id }" />
		<table>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">아이디</td>
				<td width="510" bgcolor="#FFFFFF">
					${map.usr_id }	
				</td>
			</tr>
	
			<tr>
				<td width="127" align=center class="txt_pro" bgcolor="#FFFFFF">비밀번호</td>
				<td width="510" bgcolor="#FFFFFF">
					${map.usr_pw }
				</td>
			</tr>
			<!-- 일반 입력창(이름) -->
			<tr style="display: " id="name_input_view">
				<td height=10 align="center" bgcolor="#F6F6F6" width="127"
					class="txt_pro">이름</td>
				<td height=10 bgcolor="#FFFFFF" width="510">
					${map.name }
				</td>
			</tr>
	
			<!-- 일반 입력창(주민등록번호) -->
			<tr style="display: " id="ssn_input_view">
				<td height=10 align="center" bgcolor="#F6F6F6" width="127"
					class="txt_pro">주민등록번호</td>
				<td height=10 bgcolor="#FFFFFF" width="510">
					${map.ssn1 }-${map.ssn2 }
				</td>
			</tr>
	
			<tr>
				<td height=10 align="center" bgcolor="#FFFFFF" width="127"
					class="txt_pro">주소</td>
				<td height=10 bgcolor="#FFFFFF" width="510">
					${map.zip1}-${map.zip2}<br/>
					${map.addr1} ${map.addr2} 
				</td>
			</tr>
			<tr>
				<td height=10 align="center" bgcolor="#FFFFFF" width="127"
					class="txt_pro">유선전화</td>
				<td height=10 bgcolor="#FFFFFF" width="510">
				${map.tel1}-${map.tel2}-${map.tel3}
				</td>
			</tr>
			<tr>
				<td height=10 align="center" bgcolor="#FFFFFF" width="127"
					class="txt_pro">휴대전화</td>
				<td height=10 bgcolor="#FFFFFF" width="510">
				${map.cell1}-${map.cell2}-${map.cell3}
				</td>
			</tr>
	
	
			<tr>
				<td height=10 align="center" bgcolor="#FFFFFF" width="127"
					class="txt_pro">이메일</td>
				<td height=10 bgcolor="#FFFFFF" width="510">
					${map.email1 }@${map.email2 }
				</td>
			</tr>
			<tr>
				<td height=10 align="center" bgcolor="#FFFFFF" width="127"
					class="txt_pro">뉴스메일</td>
				<td height=10 bgcolor="#FFFFFF" colspan=3 width="510">
					뉴스 메일을
					받으시겠습니까?
					<input type='radio' name='is_news_mail' value='T' <c:if test="${map.mail_agree_yn=='T' }">checked="checked"</c:if>>동의 
					<input type='radio' name='is_news_mail' value='F' <c:if test="${map.mail_agree_yn=='F' }">checked="checked"</c:if>> 동의안함
					<input type='radio' name='is_news_mail' value='D' <c:if test="${map.mail_agree_yn=='D' }">checked="checked"</c:if>> 절대수신안함</td>
			</tr>
		</table>
			<div align="center">
				<input id="button1" type="submit" value="수정" /> <input
					id="button2" type="reset" value="초기화" />
			</div>
		</form>
	</div>

</body>
</html>
