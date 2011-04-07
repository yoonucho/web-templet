//필수 값 체크(빈값 체크)
blankCheck = function(objname, formname, msg) {
	try	{
		var str = $(objname, formname).attr("value");
		str = $.trim(str);

		if( str =="") {
			$(objname, formname).focus();
			//$(objname, formname).val().focus();
			if(msg != null || "" != msg){alert(msg);}
			return false;
		} else {
			return true;
		}

	} catch (e) { alert(e);	}
}

//이메일 형식 체크
func_checkEmail = function(objname, formname) {
	var str_email = $(objname,formname).attr("value");
	
	var regExp=/^[A-Za-z0-9._\-]{3,12}@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; 
	
	if	(!regExp.test(str_email)) {
		alert("이메일 주소 형식이 맞지않습니다.");
		$(objname).focus();
		return false;
	} else {
		return true;
	}

}

//찜리스트
function getZzimList(currentPage){
	var contentTypeCd = "";

	if($("#contentTypeCd > option:selected").val()!=undefined){
		contentTypeCd = $("#contentTypeCd > option:selected").val();	
	}
	jQuery.ajax({
		type: 'GET',
		url: window.location.pathname.replace('.html','List.html'),
		dataType: 'html',
		data:'currentPage=' + currentPage+"&contentTypeCd="+contentTypeCd,
		success: function(serializedHTML,textStatus){
				$('#jjimList').attr('innerHTML',serializedHTML);
		},
		error: function(){
			alert('잘못된 데이터가 리턴되었습니다. 관라자에게 문의하십시오.');
		}
	});
}

//좋아하는 장르 수정,레이어 팝업
$(function() {

	$("#genreSubmit").click(function(){
				
		if($("input:checkbox[name=genreCd]:checked").length < 1){
			alert('좋아하는 장르는 선택해 주세요.');
			return false;
		}
		
		if($("input:checkbox[name=genreCd]:checked").length > 3){
			alert('좋아하는 장르는 최대 3개까지 선택이 가능 합니다.');
			return false;
		}
	
		jQuery.ajax({
    		type: 'POST',
    		url: '/myPlayy/createGenreCd.html',
    		dataType: 'html',
    		data: $("form[name=memberGenre]").serialize(),
    		success: function(serializedHTML,textStatus){
    				alert('좋아하는 장르 설정이 완료 되었습니다.');
					$('.bx-dim').remove();
					$('#genre-layer').hide();
					$('.like-movie').html(serializedHTML);
					return false;
    		},
    		error: function(){
    			alert('좋아하는 장르 수정 실패 하였습니다.');
				return false;
    		}
    	});
	});
	
	//레이어 팝업
	$('#myplay-top span.genre a').click(function(){
		$('<div>').appendTo('body').addClass('bx-dim').animate({'opacity':'0.5'});
		// 크기 값 확인
		$('.bx-dim').css('left',$(window).scrollLeft() + 'px');
		$('.bx-dim').css('top',$(window).scrollTop() + 'px');

		$('.bx-dim').css('width',$(window).width());
		$('.bx-dim').css('height',$(window).height());
		$('#genre-layer').show();
	});
	
	$(window).scroll(function(){ // scroll
		$('.bx-dim').css('left',$(window).scrollLeft() + 'px');
		$('.bx-dim').css('top',$(window).scrollTop() + 'px');
		$('.bx-dim').css('width','100%');
		$('.bx-dim').css('height','100%');
	});

	$('.ico-close').click(function(){
		$('.bx-dim').remove();
		$('#genre-layer').hide();
	});
			
});

// 파일업로드 이벤트
function profileForm() {
	if (!$("#file")) {
		alert("파일을 선택하세요.");
		$("#file").focus();
		return;
	}

	//파일전송
	var frm = $('#myPhoto');  
	frm.submit();
}


//프로필 수정
$(function() {
	
	//저장
    $("#submit").click(function() {
		
		var selectedValue = "";
       	var radios = $("input:radio");  //타입이 radio인 항목을 찾는다.
       	for(var i = 0; i < radios.length;i++) {
		
            if(radios[i].checked == true) //라디오 버튼중 선택되어진 항목의 값을 가져온다.
            {
                selectedValue = $(radios[i]).val() ;
            }
       	}
	
		$('#memberCover','#profileForm').attr("value",$("#cover").attr("value"));
		$('#memberHomeUrl','#profileForm').attr("value",$("#homeUrl").attr("value"));
		$('#newsEmailYn','#profileForm').attr("value",selectedValue);
		$('#newsEmail','#profileForm').attr("value",$("#email").attr("value"));
		
		if($("#newsEmail","#profileForm").attr("value") != '') { 
			if(!func_checkEmail( "#newsEmail", "#profileForm")) { return false; }
		}
		if($("#memberCover", "#profileForm").attr("value").length > 200){
				alert('자기소개는 200자이하 입니다.');
				return false;
		}
		if($("#memberHomeUrl", "#profileForm").attr("value").length > 50){
			alert('홈피&블로그 주소는 50자이하 입니다.');
			return false;
		}
		if(selectedValue == 'Y'){
			if(!blankCheck("#newsEmail", "#profileForm","Playy 뉴스레터 구독이메일 입력해주세요.")){return false;}
		}	
		if($("#newsEmail", "#profileForm").attr("value").length > 50){
			alert('Playy 뉴스레터 구독이메일은 50자이하 입니다.');
			return false;
		}
		
		var contents = jQuery.trim(jQuery("textarea:first").val());
		
		jQuery.ajax({
			type:'POST',
			url : '../contents/denyWordCheckList.html', 
			data : {contents : contents}, 
			contentType :'application/x-www-form-urlencoded;charset=utf-8',
			success : function(data) {
				var obj = jQuery.parseJSON(data);
				if(obj.result == "true"){
					alert("자기소개에 \"" + obj.denyWord + "\" 등록할 수 없는 단어 입니다.");
					return;
				} else {
					var homeUrl = $("#memberHomeUrl", "#profileForm").attr("value");
					
					jQuery.ajax({
						type:'POST',
						url : '../contents/denyWordCheckList.html', 
						data : {contents : homeUrl}, 
						contentType :'application/x-www-form-urlencoded;charset=utf-8',
						success : function(data) {
							var obj = jQuery.parseJSON(data);
							if(obj.result == "true"){
								alert("홈피&블로그 주소에 \"" + obj.denyWord + "\" 등록할 수 없는 단어 입니다.");
								return;
							} else {
								//프로필 등록
								jQuery.ajax({
						    		type: 'POST',
						    		url: '/myPlayy/profile.html',
						    		dataType: 'html',
						    		data: $("form[name=profileForm]").serialize(),
						    		success: function(serializedHTML,textStatus){
											if('modify' == serializedHTML){
												alert('프로필 수정이 완료 되었습니다.');
												location.href = '/myPlayy/profile.html';
												return;
											}else{
												alert('프로필 수정이 실패 되었습니다.');
								    			return;
											}	
						    		},
						    		error: function(){
						    			alert('프로필 수정이 실패 되었습니다.');
						    			return;
						    		}
						    	});
							}
					 	}
					});
				}
		 	}
		});
		
		
		
    });
	
	$("#cancle").click(function() {
		location.href = './home.html';
	});
			
});

//이용,결제 내역 검색 
function search_channelCode(value){
	getPaymentList('1',value);
}

//이용,결제 내역 목록
function getPaymentList(currentPage,value){
	var search = '';
	if(currentPage != 'new'){
		search = $('#channelCode > option:selected').attr("value");
	}
	jQuery.ajax({
		type: 'POST',
		url: window.location.pathname.replace('usePlay.html',value+'.html'),
		dataType: 'html',
		data: 'currentPage=' + currentPage+'&channelCode=' + search,
		success: function(serializedHTML,textStatus){
				$('#div_content').html(serializedHTML);
		},
		error: function(){
			alert('잘못된 데이터가 리턴되었습니다. 관라자에게 문의하십시오.');
		}
	});
}

//팬 목록
function getFanmList(currentPage, value){
	
	var contentTypeCd = "";
	if(jQuery("#contentTypeCd > option:selected").val()!=undefined){
		contentTypeCd = jQuery("#contentTypeCd > option:selected").val();
	}
	//alert(window.location.pathname.replace('.html','List.html?mode='+value));
	jQuery.ajax({
		type: 'GET',
		url: window.location.pathname.replace('.html','List.html?mode='+value),
		dataType: 'html',
		data:'currentPage=' + currentPage+"&contentTypeCd="+contentTypeCd,
		success: function(serializedHTML,textStatus){
				$('#conList').html(serializedHTML);
		},
		error: function(){
			alert('잘못된 데이터가 리턴되었습니다. 관라자에게 문의하십시오.');
		}
	});
}

//MyPlayy 내부 후측메뉴 호버링제어
function setHover(IsTurnedOFF,ref_this){
    if(IsTurnedOFF){
    	$(ref_this).attr('src',$(ref_this).attr('src').replace('_off','_on'));
    }
    else{
    	if(location.href.search($($(ref_this).attr('parentNode')).attr('href')) == -1){
    		$(ref_this).attr('src',$(ref_this).attr('src').replace('_on','_off'));
    	}
    }
}


//검색결과 전체보기 및 간단보기 
$(document).ready(function(){
	
	var $obj = $('.myinfo .info-txt');
	var $more2 = $('#myplay-top .myinfo span.more');
	var high = $obj.outerHeight();
	var value= $('#textCover').attr('value');
	
	if(value > 110){
		$obj.animate({'height':'30px'});
	}
	
	$more2.children().toggle(function(){
		$obj.animate({'height':high});
		$(this).text('- 줄이기');
		return false;
	},function(){
		$obj.animate({'height':'30px'});
		$(this).text('+ 더 보기');		
		return false;
	});

});
