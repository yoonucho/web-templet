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
		<h3 id="adduser">글등록</h3>
		<form action="${pageContext.request.contextPath}/bd/ma/BDMA050T.do" name="frmSave" id="frmSave" method="post" enctype="multipart/form-data" class="form">
		<input name="brd_seq_no" type="hidden" value="${map.brd_seq_no }"/>
			<fieldset id="personal">
				<legend>CONTENT</legend>
				<table class="contentTable">
					<tr>
						<td><label class="label" for="brd_title">제목</label></td>
						<td> 
							<input name="brd_title" id="brd_title" type="text" value="${map.brd_title }" />
						</td>
					</tr>
					<tr>
						<td><label class="label" for="content">내용</label></td>
						<td> 
							<textarea name="content" id="content" rows="" cols="" style="width: 300px;height: 300px;">${map.content }</textarea> 
						</td>
					</tr>
<c:if test="${filList !=null }">
	<c:forEach var="map" items="${filList}" varStatus="status">
					<tr>
						<td><label class="label" for="file${status.count }">파일${status.count }</label></td>
						<td> 
							<input name="del${status.count }" type="checkbox" value="${map.file_seq_no }" id="del${status.count }"  />
							<label for="del${status.count }">삭제</label>
							<input type="hidden" name="file_name${status.count }" value="${map.file_seq_no }" />
							<a href="${pageContext.request.contextPath}/bd/ma/downloadFile.do?m_file_nm=${map.m_file_nm}&v_file_nm=${map.v_file_nm}">${map.v_file_nm}</a>
							<br/>
							<input type="file" class="file_1" id="file${status.count }" name="file${status.count }" /> 
						</td>
					</tr>
	</c:forEach>
	<c:forEach var="i" begin="${fn:length(filList)+1 }" end="3" step="1">
					<tr>
						<td><label class="label" for="file${i }">파일${i }</label></td>
						<td> 
							<input type="file" class="file_1" name="file${i }" id="file${i }" /> 
						</td>
					</tr>
	</c:forEach>
</c:if>
<c:if test="${filList ==null }">
					<tr>
						<td><label class="label" for="content">파일1</label></td>
						<td> 
							<input type="file" class="file_1" name="file1" /> 
						</td>
					</tr>
					<tr>
						<td><label class="label" for="content">파일2</label></td>
						<td> 
							<input type="file" class="file_1" name="file2" /> 
						</td>
					</tr>
					<tr>
						<td><label class="label" for="content">파일3</label></td>
						<td> 
							<input type="file" class="file_1" name="file3" /> 
						</td>
					</tr>
</c:if>

				</table>
			</fieldset>
			<div align="center">
				<input id="button1" type="submit" value="글등록" /> <input
					id="button2" type="button" onclick="location.href='${pageContext.request.contextPath}/bd/ma/BDMA010Q.do;'" value="목록" />
			</div>
		</form>

	</div>
</body>
</html>
