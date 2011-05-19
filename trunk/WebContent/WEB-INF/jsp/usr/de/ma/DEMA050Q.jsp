<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include/taglibs.jsp"%>
<html>
<head>
<title>게시판</title>
<meta name="decorator" content="shop_usr"/>
<link rel="stylesheet" href="${ctx }/css/jquery/ui-lightness/jquery-ui-1.8.13.custom.css"> 
<script src="${ctx }/js/jquery/jquery-ui-1.8.13.custom.min.js"></script>
<style> 
h1 { padding: .2em; margin: 0; }
#products { float:left; width: 500px; margin-right: 2em; }
#cart { width: 200px; float: left; }
/* style the list to maximize the droppable hitarea */
#cart ol { margin: 0; padding: 1em 0 1em 3em; }
.cartList {
	display:inline-block; 
	float:left;
	width: 320px;
	height: 200px;
}
#usr_delivery{
	
}


</style> 

<script type="text/javascript">
 
$(function() {
	/*
	$( "#catalog li" ).draggable({
		appendTo: "body",
		helper: "clone"
	});
	$( "#cart ol" ).droppable({
		activeClass: "ui-state-default",
		hoverClass: "ui-state-hover",
		accept: ":not(.ui-sortable-helper)",
		drop: function( event, ui ) {
			$( this ).find( ".placeholder" ).remove();
			$( "<li></li>" ).text( ui.draggable.text() ).appendTo( this );
		}
	});
	*/
	$( ".trClass" ).draggable({
		appendTo: "body",
		helper: "clone",
		opacity: 0.75
	});
	$( ".cart" ).droppable({
		activeClass: "ui-state-default",
		hoverClass: "ui-state-hover",
		accept: ":not(.ui-sortable-helper)",
		drop: function( event, ui ) {
			//$( this ).find( ".placeholder" ).remove();
			//alert(ui.draggable.html());
			//console.log(ui.draggable);
			$( "<li></li>" ).html( ui.draggable.html() ).appendTo( this );
			//$(this).html($(this).html()+ui.draggable.html());
			
		}
	});
});
</script> 

<script type="text/javascript">

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
		<form action="./DEMA050Q.do" name="frmSave" id="frmSave" method="post" class="form">
		<table>
			<tr>
				<th>제품 사진</th>
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
				<td class="trClass">
<!--				<img src="${map.prd_img }" width="50px" height="50px"/> -->
<img src="/vd/common/images/mypage/photo01.gif" width="50px" height="50px"/>
				
				</td>
				<td>${map.prd_nm }</td>
				<td>
					<input type="hidden" name="prd_seq_no" value="${map.prd_seq_no }" />
					<input name="del_cnt" value="${map.del_cnt }" style="width:30px;" type="text" />개 <input type="submit" value="적용">
				</td>
				<td>${map.prd_price } 원</td>
				<td>없음</td>
			</tr>
	</c:forEach>
</c:if>
		</table>
		<div id="divComment">
			<input type="hidden" name="totalVal" value="${totalVal }"/> 
			총 가격 : ${totalVal } 원
		
		</div>
		</form>
	</div>
<div >
	<input type="radio" name="multiYn" id="multiYn1" value="N" onclick="$('#cartMain').hide();"/><label for="multiYn1">한곳배송</label>
	<input type="radio" name="multiYn" onclick="$('#cartMain').show();" id="multiYn2" value="Y"/><label for="multiYn2">여러곳 배송(멀티배송)</label>
</div>
<div id="cartMain" style="display: none;">
	<ul class="cartList cart">
		<li>입력</li>
	</ul>
	<ul class="cartList cart">
		<li>입력2</li>
	</ul>
</div>


<div>
<form name="frmDelivery" action="./DEMA050T.do" method="post">
<c:if test="${list !=null }">
	<c:forEach var="map" items="${list}" varStatus="status">
<input name="prd_seq_nos" type="hidden" value="${map.prd_seq_no }" />
<input name="del_cnts" type="hidden" value="${map.del_cnt }" />
	</c:forEach>
</c:if>
<table class="tbData">
	<tr>
		<th>배송지 선택</th>
		<td>
			<input type="radio" name="addrType" value="Default" id="addrType1" /><label for="addrType1">기본주소</label>
			<input type="radio" name="addrType" value="New" id="addrType2" onclick="dataInit();" /><label for="addrType2">새로입력</label>
			<a href="#" onclick="alert('배송지목록');return false;">배송지 목록</a>
		</td>
	</tr>
	<tr>
		<th>보낸사람</th>
		<td>
			<input name="from_usr" type="text" value="" />
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
		<td>
			<textarea style="width:300px;height:30px;" name="del_msg"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="text-align: right;">
			<input type="submit" value="구매"/>
		</td>
	</tr>
</table>
</form>
</div>


</body>
</html>
