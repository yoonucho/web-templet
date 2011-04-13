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
</script>

</head>

<body>

<form:form commandName="frmChk" name="frmChk" id="frmChk" action="./CMMA020Q.do" method="post">
<form:errors/>
	아이디 : <form:input path="usr_id"/><form:errors path="usr_id" /><br/>
	비밀번호 : <form:input path="usr_pw"/><form:errors path="usr_pw" />
	<input type="submit" value="로그인"/>
</form:form>

</body>
</html>
