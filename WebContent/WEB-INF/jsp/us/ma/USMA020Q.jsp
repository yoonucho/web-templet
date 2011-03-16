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
	
	<c:set var="ac" value="${pageContext.request.contextPath}/us/ma/USMA020T.do"/>
	<c:if test="${!empty frmSave.usr_id && frmSave.usr_id !='' }">
		<c:set var="ac" value="${pageContext.request.contextPath}/us/ma/USMA030T.do"/>	
	</c:if>

	${ac }
	<form:form action="${ac }" commandName="frmSave" id="frmSave" name="frmSave" method="post">
	<form:errors/>
		<table>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">아이디</td>
				<td width="510" bgcolor="#FFFFFF">
					<table cellpadding=0 cellspacing=0>
						<tr>
							<td>
	<c:if test="${!empty frmSave.usr_id && frmSave.usr_id !='' }">
		${frmSave.usr_id }
		<form:hidden path="usr_id"/>
	</c:if>
	<c:if test="${empty frmSave.usr_id || frmSave.usr_id =='' }">
		<form:input path="usr_id"/>
	</c:if>
								
							</td>
							<td style='display: block'>&nbsp;<img
								src="http://img0001.echosting.cafe24.com/front/type_b/image/member_register/7.gif"
								align="absmiddle"
								onclick="javascript:window_open( '/front/php/id_check/id_check.php?id=' + frm.member_id.value, 'echost_id_check', '300', '300', '420', '254' )"
								style="cursor: hand"></td>
							<td>&nbsp;(영문소문자/숫자, 4~16자)</td>
						</tr>
					</table></td>
			</tr>
	
			<tr>
				<td width="127" align=center class="txt_pro" bgcolor="#FFFFFF">비밀번호</td>
				<td width="510" bgcolor="#FFFFFF">
					<form:input path="usr_pw"/>
					(영문자/숫자, 4~16자)</td>
			</tr>
			<tr>
				<td height=10 align="center" bgcolor="#FFFFFF" width="127"
					class="txt_pro">비밀번호 확인</td>
				<td height=10 bgcolor="#FFFFFF" width="510">
					<form:input path="usr_pw_chk"/>
				</td>
			</tr>
			<!-- 일반 입력창(이름) -->
			<tr style="display: " id="name_input_view">
				<td height=10 align="center" bgcolor="#F6F6F6" width="127"
					class="txt_pro">이름</td>
				<td height=10 bgcolor="#FFFFFF" width="510">
					<form:input path="name"/>
				</td>
			</tr>
	
			<!-- 일반 입력창(주민등록번호) -->
			<tr style="display: " id="ssn_input_view">
				<td height=10 align="center" bgcolor="#F6F6F6" width="127"
					class="txt_pro">주민등록번호</td>
				<td height=10 bgcolor="#FFFFFF" width="510">
					<form:input path="ssn1"/>-<form:password path="ssn2" value="${frmSave.ssn2 }" />
				</td>
			</tr>
	
			<tr>
				<td height=10 align="center" bgcolor="#FFFFFF" width="127"
					class="txt_pro">주소</td>
				<td height=10 bgcolor="#FFFFFF" width="510">
					<table width="510" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="26">
								<form:input path="zip1"/>-<form:input path="zip2"/>
							</td>
						</tr>
						<tr>
							<td height="26">
								<form:input path="addr1"/>기본주소
							</td>
						</tr>
						<tr>
							<td height="26"><form:input path="addr2"/> 나머지주소</td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td height=10 align="center" bgcolor="#FFFFFF" width="127"
					class="txt_pro">유선전화</td>
				<td height=10 bgcolor="#FFFFFF" width="510">
					<form:input path="tel1"/>-<form:input path="tel2"/>-<form:input path="tel3"/>
				</td>
			</tr>
			<tr>
				<td height=10 align="center" bgcolor="#FFFFFF" width="127"
					class="txt_pro">휴대전화</td>
				<td height=10 bgcolor="#FFFFFF" width="510">
					<form:select path="cell1">
						<form:option value=''>없음</form:option>
						<form:option value='010'>010</form:option>
						<form:option value='011'>011</form:option>
						<form:option value='016'>016</form:option>
						<form:option value='017'>017</form:option>
						<form:option value='018'>018</form:option>
						<form:option value='019'>019</form:option>
						<form:option value='070'>070</form:option>
					</form:select>-<form:input path="cell2"/>-<form:input path="cell3"/> 
				</td>
			</tr>
	
	
			<tr>
				<td height=10 align="center" bgcolor="#FFFFFF" width="127"
					class="txt_pro">이메일</td>
				<td height=10 bgcolor="#FFFFFF" width="510">
	
					<table width="510" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="26">
								<form:input path="email1"/>
							</td>
							<td>@</td>
							<td>
								<form:select path="email2">
									<form:option value="">::::::::::: 선택 :::::::::::</form:option>
									<form:option value="chol.com">chol.com      </form:option>
									<form:option value="dreamwiz.com">dreamwiz.c</form:option>
									<form:option value="empal.com">empal.com    </form:option>
									<form:option value="hanmir.com">hanmir.com  </form:option>
									<form:option value="hanafos.com">hanafos.com</form:option>
									<form:option value="hotmail.com">hotmail.com</form:option>
									<form:option value="lycos.co.kr">lycos.co.kr</form:option>
									<form:option value="nate.com">nate.com      </form:option>
									<form:option value="naver.com">naver.com    </form:option>
									<form:option value="daum.net">daum.net      </form:option>
									<form:option value="hanmail.net">hanmail.net</form:option>
									<form:option value="gmail.com">gmail.com    </form:option>
									<form:option value="paran.com">paran.com    </form:option>
									<form:option value="yahoo.co.kr">yahoo.co.kr</form:option>
									<form:option value="etc">직접입력               </form:option>
								</form:select>
							</td>
							<td id="etc_email" style="display: none;">&nbsp;
								<form:input path="email_txt" />
							</td>
							<td width="300">&nbsp;</td>
						</tr>
						<tr>
							<td height="20" colspan=5><img
								src="http://img0001.echosting.cafe24.com/front/type_b/image/member_register/9.gif"
								align="absmiddle"> 주문 및 배송확인 정보 등이 E-mail로 발송되므로 반드시 수신가능한
								E-mail 주소를 입력<br>하여주십시오.</td>
						</tr>
						<tr>
							<td colspan=5></td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td height=10 align="center" bgcolor="#FFFFFF" width="127"
					class="txt_pro">뉴스메일</td>
				<td height=10 bgcolor="#FFFFFF" colspan=3 width="510">뉴스 메일을
					받으시겠습니까? 
					
					<c:if test="${map ==null }"> 
					<form:radiobutton path="mail_agree_yn" value="T" label="동의" checked="checked"/>
					</c:if>
					<c:if test="${map !=null }"> 
					<form:radiobutton path="mail_agree_yn" value="T" label="동의" />
					</c:if>
					<form:radiobutton path="mail_agree_yn" value="F" label="동의안함"/>
					<form:radiobutton path="mail_agree_yn" value="D" label="절대수신안함"/>
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
