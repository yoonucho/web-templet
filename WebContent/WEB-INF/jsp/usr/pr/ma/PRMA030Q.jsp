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
	getCmmt({currentPageNo:1});
});

//코멘트 가져오기
function getCmmt(option1){
	$.hwBlock("divComment");
	var option = {
		type : "get",
		url: "./PRMA050Q.do",
		data : {"currentPageNo":option1.currentpageno,"prd_seq_no":'${param.prd_seq_no}'},
		success : function (json){
			var html="";
			if(!json){
				return false;
			}
			
			if(json.list.length>0){
				var html ="";
				var cnt = json.list.length;
				jQuery.each(json.list, function (i) {
					html+="<li id='li_"+i+"'>";
					html+=$.tv.rpall(this.content,"\n","<br/>");
					html+="&nbsp;<a href='#' id='a_"+i+"' onclick='showEdtCmmt(\""+this.seq_no+"\",\""+$.tv.rpall(this.content,"\n","<br/>")+"\","+i+");return false;'>수정</a>";
					html+="&nbsp;<a href='#' onclick='delCmmt("+this.seq_no+");return false;'>삭제</a>";
					html+="</li>";
				});
				$.tv.ajPJson(json.paging,getCmmt,option1,"divPaging");
				
			}
			
			$("#divCmmtList").html(html);
			$.hwUnBlock("divComment");
		}
	};
	$.tv.getJson(option);
}

//코멘트 삭제
function delCmmt(seq_no){
	var option = {
		url: "./PRMA051T.do",
		data : {"seq_no":seq_no},
		success : function(){getCmmt({currentPageNo:1});}
	};
	$.tv.getJson(option);
}

//코멘트 등록
function addCmmt(content){
	var option = {
		url: "./PRMA050T.do",
		data : {"prd_seq_no":'${param.prd_seq_no}',"content":content},
		success : function(){getCmmt({currentPageNo:1});}
	};
	$.tv.getJson(option);
}

function showEdtCmmt(seq_no,content,num){
	var c = $.tv.rpall(content,"<br>","\n");
	c = $.tv.rpall(c,"<br/>","\n");
	c = $.tv.rpall(c,"</a>","");
	$("#edtContent").val(c);
	$("#edtBtn").die("click");
	$("#edtBtn").live("click",function(){editCmmt(seq_no,$("#edtContent").val());return false;	});
	
	$("#divEdit").css("top",$("#a_"+num).offset().top-130);
	
	$("#divEdit").show();
}

//코멘트 수정
function editCmmt(seq_no,content){
	var option = {
		url: "./PRMA052T.do",
		data : {"seq_no":seq_no,"content":content},
		success : function(){getCmmt({currentPageNo:1});$("#divEdit").hide();}
	};
	$.tv.getJson(option);
}

function returnZip(){
	var zip1 = zip.split("-")[0];
	var zip2 = zip.split("-")[1];
	alert(zip1+" "+ zip2 + " "+ addr);	
}

function buyNow(){
	$('#frmSave').attr("action","${pageContext.request.contextPath}/usr/de/ma/DEMA050Q.do");
	$('#frmSave').submit();
}

</script>

</head>

<body>


	<div id="box">
		<h3 id="adduser">
			상세보기
		</h3>
		<form action="${pageContext.request.contextPath}/pr/ma/PRMA031Q.do"
		name="frmSave" id="frmSave" method="post" class="form">
		<input type="hidden" name="prd_seq_no" value="${map.prd_seq_no }" /> 
		
				<table>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">제품 카테고리</td>
				<td width="510" bgcolor="#FFFFFF">
					${map.cate_nm }
				</td>
			</tr>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">제품명</td>
				<td width="510" bgcolor="#FFFFFF">
					${map.prd_nm }
				</td>
			</tr>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">가격</td>
				<td width="510" bgcolor="#FFFFFF">
					${map.prd_price }원
				</td>
			</tr>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">적립금</td>
				<td width="510" bgcolor="#FFFFFF">
					${map.prd_save }%
				</td>
			</tr>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">제품 상세내용</td>
				<td width="510" bgcolor="#FFFFFF">
					<textarea name="prd_content" rows="" cols="" style="width:300px;height:300px;">${map.prd_content }</textarea>
				</td>
			</tr>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">제품이미지</td>
				<td width="510" bgcolor="#FFFFFF">
					<c:if test="${!empty map.prd_img && map.prd_img!='' }">
					<div  id="pd_img">
						<img src="${pageContext.request.contextPath}${map.prd_img }" style="width:100px;height:100px;" />
					</div>
					</c:if>
				</td>
			</tr>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">옵션</td>
				<td width="510" bgcolor="#FFFFFF">
					<select name="del_cnt">
						<option value="1">1개</option>
						<option value="2">2개</option>
						<option value="3">3개</option>
						<option value="4">4개</option>
						<option value="5">5개</option>
						<option value="6">6개</option>
						<option value="7">7개</option>
						<option value="8">8개</option>
						<option value="9">9개</option>
						<option value="10">10개</option>
					</select>
				</td>
			</tr>
			<tr>
				<td width="127" align=center class="txt_pro" nowrap bgcolor="#FFFFFF">주문</td>
				<td width="510" bgcolor="#FFFFFF">
					<a href="#">장바구니담기</a>
					<a href="#" onclick="buyNow();">바로주문하기</a>
				</td>
			</tr>
		</table>
		</form>
	</div>
<div id="divComment">
	코
	<ul id="divCmmtList">
	
	</ul>
	<div id="divPaging">
	
	</div>
</div>
<br/>
<div>
	내용입력
	<textarea id="cmmtContent" rows="" cols=""></textarea>
	<a href="#" onclick="addCmmt($('#cmmtContent').val());return false;">저장</a>
</div>

<div id="divEdit" style="display:none;position: absolute;top:30px;background-color: white;">
	내용입력
	<textarea id="edtContent" rows="" cols="" style="width:200px;height:50px;"></textarea>
	<a href="#" id="edtBtn">저장</a>
	<a href="#" onclick="$('#divEdit').hide();return false;">닫기</a>
</div>


<div id="divZipCodeView11" style="cursor: default">
<fieldset>
	<input name="dong" type="text" value="${param.dong}"/>
	<input type="button" value="검색"/>
	<ul id="ulZip">
		<li><a href="#" onclick="$.showZip();" >동홍동 1</a> </li>
		<li><a href="#" onclick="alert(12);$('#_divZipCodeView').remove();return false;" >동홍동2</a> </li>
		
	</ul>
 </fieldset>
</div> 


</body>
</html>
