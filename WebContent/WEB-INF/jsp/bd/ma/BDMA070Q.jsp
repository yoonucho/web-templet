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


	<div id="box">
		<h3 id="adduser">상세조회</h3>
		<form action="${pageContext.request.contextPath}/bd/ma/BDMA040Q.do?brd_seq_no=${map.brd_seq_no}" name="frmSave" id="frmSave" method="post" enctype="multipart/form-data" class="form">
		<input name="brd_seq_no" type="hidden" value="${map.brd_seq_no}">
			<fieldset id="personal">
				<legend>CONTENT</legend>
				<table class="contentTable">
					<tr>
						<td><label for="brd_title">제목</label>
						</td> 
						<td>
						${map.brd_title }
						</td>
					</tr>
					<tr>
						<td><label for="content">내용</label>
						</td>
						<td>
							<textarea name="content" id="content" rows="" cols="" style="width: 300px;height: 300px;">${map.content }</textarea> 
						</td>
					</tr>
<c:if test="${filList !=null }">
	<c:forEach var="map" items="${filList}" varStatus="status">
					<tr>
						<td><label for="content">FILE ${status.count }</label>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/bd/ma/downloadFile.do?m_file_nm=${map.m_file_nm}&v_file_nm=${map.v_file_nm}">${map.v_file_nm}</a>
						</td>
					</tr>
	</c:forEach>
</c:if>
				</table>
			</fieldset>
			<div align="center">
				<input id="button1" type="submit" value="수정" /> 
				<input id="button2" type="button" onclick="location.href='${pageContext.request.contextPath}/bd/ma/BDMA010Q.do';" value="목록" />
			</div>
		</form>

	</div>
</body>
</html>
