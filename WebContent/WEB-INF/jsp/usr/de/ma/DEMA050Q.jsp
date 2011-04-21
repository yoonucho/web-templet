<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include/taglibs.jsp"%>
<html>
<head>
<title>게시판</title>
<meta name="decorator" content="shop_usr"/>

<script type="text/javascript">

$(document).ready(function(){
	
});
$(window).load(function(){
	
});

//우편번호 넣기
function returnZip(zip, addr){
	
	var zip1 = zip.split("-")[0];
	var zip2 = zip.split("-")[1];
	//alert(zip1+" "+ zip2 + " "+ addr);
	$("#zip1").val(zip1);
	$("#zip2").val(zip2);
	$("#addr1").val(addr);
	$("#addr2").focus();
}

//데이터 초기화
function dataInit(){
	$.dtInit('tbData');
}

</script>

</head>

<body>


	<div id="box">
		<h3 id="adduser">
			결제하기
		</h3>
		<form action="${pageContext.request.contextPath}/pr/ma/PRMA031Q.do"
		name="frmSave" id="frmSave" method="post" class="form">
		<input type="hidden" name="prd_seq_no" value="${map.prd_seq_no }" /> 
		
		<table>
			<tr>
				<th>상품정보 옵션</th>
				<th width="100">수량</th>
				<th width="100">금액</th>
				<th width="100">배송비</th>
			</tr>
			<c:set var="totalVal" value="0"/>
<c:if test="${list !=null }">
	<c:forEach var="map" items="${list}" varStatus="status">
	<c:set var="totalVal" value="${totalVal+(map.prd_price*map.del_cnt) }" />
			<tr>
				<td>${map.prd_nm }</td>
				<td>${map.del_cnt } 개</td>
				<td>${map.prd_price } 원</td>
				<td>없음</td>
			</tr>
	</c:forEach>
</c:if>
		</table>
		</form>
	</div>
<div id="divComment">
	총 가격 : ${totalVal } 원

</div>

<div>
<table id="tbData">
	<tr>
		<th>배송지 선택</th>
		<td>
			<input type="radio" name="addrType" value="Default" id="addrType1" /><label for="addrType1">기본주소</label>
			<input type="radio" name="addrType" value="New" id="addrType2" onclick="dataInit();return false;" /><label for="addrType2">새로입력</label>
			<a href="#" onclick="alert('배송지목록');">배송지 목록</a>
		</td>
	</tr>
	<tr>
		<th>받으시는 분</th>
		<td>
			<input name="to_usr" type="text" value="" />
		</td>
	</tr>
	<tr>
		<th>주소</th>
		<td><input id="zip1" name="zip1" type="text" value="" size="3" readonly="readonly"/>-
		<input id="zip2" name="zip2" type="text" value="" size="3" readonly="readonly"/>
			<a href="#" onclick="$.showZip({'fn':returnZip});return false;">주소입력</a>
		</td>
	</tr>
	<tr>
		<th>&nbsp;</th>
		<td><input id="addr1" name="addr1" type="text" value="" readonly="readonly" /></td>
	</tr>
	<tr>
		<th>&nbsp;</th>
		<td><input id="addr2" name="addr2" type="text" value="" /></td>
	</tr>
	<tr>
		<th>휴대전화</th>
		<td>
			<select name="cell1">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="019">019</option>
			</select>
			-<input name="cell2" type="text" value="" size="4" />
			-<input name="cell3" type="text" value="" size="4" />
		</td>
	</tr>
	<tr>
		<th>집전화</th>
		<td>
			<select name="tel1">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="019">019</option>
			</select>
			-<input name="tel2" type="text" value="" size="4" />
			-<input name="tel3" type="text" value="" size="4" />
		</td>
	</tr>
	<tr>
		<th>배송시 요구사항</th>
		<td><input name="addr2" type="text" value="" /></td>
	</tr>
</table>
</div>


</body>
</html>
