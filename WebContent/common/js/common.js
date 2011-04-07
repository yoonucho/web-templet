//Browser Title---------
document.title="Playy";

// png ie6
function setPng24(obj) {
    obj.width=obj.height=1;
    obj.className=obj.className.replace(/\bpng24\b/i,'');
    obj.style.filter ="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+ obj.src+"',sizingMethod='image');";
    obj.src=''; 
    return '';
}

// 공통  메뉴
$(document).ready(function(){
	setActiveGNB();
	lnbMenuInit();
});

// 메뉴 선택 유지를 위한 쿠키생성
function activeGNB(mainId, subId) { 
	$.cookie("GNBMenu", null);
	var cookieString = mainId+","+subId;
	$.cookie("GNBMenu", cookieString, {path:'/', domain:'playy.co.kr'});
}

// 쿠키값에 따른 메뉴 유지
function setActiveGNB(){
	$('#header .gnb').hide();
	$('#header .gnb02').hide();
	$('#header .gnb03').hide();
	
	if ($.cookie('GNBMenu')) {
		var GNBMenu = $.cookie("GNBMenu").split(',');
	} else {
		activeGNB('gnb', 'homeMovie');
		var GNBMenu = ['gnb','homeMovie'];
	}
	
	$('#header .sub_' + GNBMenu[0] + ' .subMenu img').each(function(){
		$(this).attr('src', $(this).attr('src').replace('_on.gif', '_off.gif'));
	});
	
	if(GNBMenu[1] != "homeMovie" || GNBMenu[1]!="seriesHome" || GNBMenu[1] != "musicHome"){
		$('#header #'+ GNBMenu[1]).attr('src', $('#header #' + GNBMenu[1]).attr('src').replace('_off.gif', '_on.gif'));
	}
	
	$('.'+ GNBMenu[0]).show();
}

// 팬/찜 등록
// cId : 영상 - 컨텐츠 아이디, 인물 - 인물 아이디
// fzType : 등록 종류(insertMovieFan - 영상팬, insertMovieZzim - 영상찜, insertPersonFan - 인물팬)
function lnbInsertFanZzim(cId, fzType){
	
	var result = $.ajax({
		url : "/main/insertFanZzim.html",
		data : ({
			contentId : cId, 
			section : fzType
		}),
		async : true
	}).responseText;
	return result;
}


// 팬/찜 해제
// cId : 영상 - 컨텐츠 아이디, 인물 - 인물 아이디
// fzType : 등록 종류(deleteMovieFan - 영상팬, deleteMovieZzim - 영상찜, deletePersonFan - 인물팬)
function lnbInsertDeleteFanZzim(cId, fzType){
	
	var result = $.ajax({
		url : "/main/deleteFanZzim.html",
		data : ({
			contentId : cId, 
			section : fzType
		}),
		async : true
	}).responseText;
	return result;
}

// LNB 팬&짐 해제
function lnbFanZzim(reqType, cId, fzType){
	var result = "";
	if(reqType=="in"){
		result = lnbInsertFanZzim(cId, fzType);
	} else {
		result = lnbInsertDeleteFanZzim(cId, fzType);
	}
	if(result == 'success'){
		lnbMenuInit();
	} else {
		alert('잠시 후 다시 하시기 바랍니다.['+result+']');
	}
}

// lnb 초기화
function lnbMenuInit(){
	if ($.cookie('LNBMenu')) {
		var LNBMenu = $.cookie("LNBMenu").split(',');
	} else {
		var LNBMenu = "recentUse,screen,1,small";
		$.cookie("LNBMenu",LNBMenu,{path:'/', domain:'playy.co.kr'});
		var LNBMenu = ['recentUse','screen','1','small'];
	}
	
	lnbMenuSelect(LNBMenu[0], LNBMenu[1], LNBMenu[2], LNBMenu[3]);
}
//LNBMyplayy 선택
// folder (최근이용작(recentUse) / 찜목록(zzim) / 팬목록(fan))
// tab(팬 목록의 영상(screen)/인물(person))
// page (현재 페이지)
// smallTab 인물팬의 간략보기(small)/전체보기(big)
function lnbMenuSelect(folder, tab, page, smallTab){
	$.ajax({
		url: "/main/lnbUserInfo.html",
		data:{
			lnbFolder 	: folder,
			lnbTab		: tab,
			currentPage	: page,
			isTabSmall : smallTab
		},
		cache: false,
		async: false,
		success:function(html){
			$('#LnbUserInfo').empty();
			$('#LnbUserInfo').html(html);
		}
	});
}

//LNB 페이징
function goLNBPage(page, folder, tab, smallTab){
	$.cookie("LNBMenu",null);
	var cookieString = folder +","+tab+","+page+","+smallTab;
	$.cookie("LNBMenu",cookieString,{path:'/', domain:'playy.co.kr'});
	
	var LNBMenu = $.cookie("LNBMenu").split(",");
	lnbMenuSelect(LNBMenu[0],LNBMenu[1],LNBMenu[2],LNBMenu[3]);
}

//LNB 영화 마우스 오버시 toggl 띄우기
function togglExpiredDateInfoOn(id){
	$("#"+id).show();
}

//LNB 영화 마우스 오버시 toggl 내리기
function togglExpiredDateInfoOff(id){
	$("#"+id).hide();
}

//로그인 호출이 필요한 곳
function loginCall(){
	var answer = "로그인이 필요합니다. 로그인 하시겠습니까?";
	if(answer){
		loginPop();
	}
}

//플레이 상세페이지로 이동
function goPlayPage(option){
/*
 * 
cseq : 컨텐츠 번호(필수)
typeCd : 분류(필수)
    - 영화 : movie
      - 시리즈/애니 : series
      - 뮤직 : music	
*/
	var type = "";
	if('1001'==option.contentTypeCd){
		type="movie";
	}else if('1002'==option.contentTypeCd||'1003'==option.contentTypeCd||'1004'==option.contentTypeCd){
		type="series";
	}else if('1005'==option.contentTypeCd){
		type="music";
	}
	//alert(option.key+","+option.contentTypeCd);
	location.href="/main/adultCheck.html?cseq="+option.key+"&typeCd="+type;
}

//배우 상세보기로 이동
function goActorPage(option){
	//alert(option.key);
	location.href="/contents/contentActor.html?personId="+option.key;
}

//회원 상세보기로 이동
function goPersonPage(option){
	//alert(option.key);
	location.href="/contents/contentProfile.html?mseq="+option.key;
}

//팬찜 로그인여부
var _isLogin="false";
//팬찜 등록 삭제
function insDelFZ(cId, fzType, img, viewCnt, fnc){
	if('false'==_isLogin){
		loginCall();
		return false;
	}
	
	var image = $("#"+img);
	if(image.attr("src").indexOf("_off")>-1){	//등록
		$.ajax({
			url : "/main/insertFanZzim.html",
			data : ({
				contentId : cId, 
				section : fzType
			}),
			success:function(html){
				if("success"==html){
					image.attr("src",image.attr("src").replace("_off","_on"));
					if(undefined != viewCnt && viewCnt!='')
						jQuery("#"+viewCnt).html(Number(jQuery("#"+viewCnt).html())+1);
					lnbMenuInit();
					if(fnc!=undefined){
						fnc(img);
					}
				}else{
					alert('등록실패');
				}
			}
		});
	}else if(image.attr("src").indexOf("_on")){	//삭제
		fzType = fzType.replace("insert","delete");
		$.ajax({
			url : "/main/deleteFanZzim.html",
			data : ({
				contentId : cId, 
				section : fzType
			}),
			success:function(html){
				if("success"==html){
					image.attr("src",image.attr("src").replace("_on","_off"));
					if(undefined != viewCnt && viewCnt!='')
						jQuery("#"+viewCnt).html(Number(jQuery("#"+viewCnt).html())-1);
					lnbMenuInit();	
					if(fnc!=undefined){
						fnc(img);
					}
				}else{
					alert('삭제실패');
				}
			}
		});
	}
}

//회원 상세보기로 이동
function goGenrePage(option){
	var options = $.extend(true, {
		genre:  "",
		year:  "",
		state:  ""
	}, option);
	var param="";
	if(""!=options.genre){
		if(""!=param)
			param+="&";
		param+="genre="+options.genre;
	}
	if(""!=options.year){
		if(""!=param)
			param+="&";
		param+="year="+options.year;
	}
	if(""!=options.state){
		if(""!=param)
			param+="&";
		param+="state="+options.state;
	}
	location.href="/movie/genreMovie.html?"+param;
}

//언더라인 정의 함수
function setUnderLine(ref_this,IssetUnderLine){
	if(IssetUnderLine){
		$(ref_this).css("text-decoration", "underline");
	}
	else{
		$(ref_this).css("text-decoration", "none");
	}
}


