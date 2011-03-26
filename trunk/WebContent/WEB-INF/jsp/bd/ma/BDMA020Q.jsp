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
		<h3 id="adduser">글등록</h3>
		<form action="${pageContext.request.contextPath}/bd/ma/BDMA030T.do" name="frmSave" id="frmSave" method="post" enctype="multipart/form-data" class="form">
			<fieldset id="personal">
				<legend>CONTENT</legend>
				<table class="contentTable">
					<tr>
						<td><label for="brd_title">제목</label> 
							<input name="brd_title" id="brd_title" type="text" />
						</td>
					</tr>
					<tr>
						<td><label for="content">내용</label>
							<textarea name="content" id="content" rows="" cols="" style="width: 300px;height: 300px;"></textarea> 
						</td>
					</tr>
					<tr>
						<td><label for="content">파일1</label>
							<input type="file" class="file_1" name="file1" /> 
						</td>
					</tr>
					<tr>
						<td><label for="content">파일2</label>
							<input type="file" class="file_1" name="file2" /> 
						</td>
					</tr>
					<tr>
						<td><label for="content">파일3</label>
							<input type="file" class="file_1" name="file3" /> 
						</td>
					</tr>
				</table>
			</fieldset>
			<div align="center">
				<input id="button1" type="submit" value="글등록" /> <input
					id="button2" type="reset" value="초기화" />
			</div>
		</form>

	</div>

</body>
</html>
