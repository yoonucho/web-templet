/* 인물상세(회원) 에서 사용하는 js */

//도메인 취득 함수
function get_domain(){
	return location.href.replace(location.pathname,'').replace('#','');
}

//상세페이지 이동 함수(영화)
function go_detailPage_Movie(target_CSEQ){
	location.href = get_domain() + '/movie/contentMovie.html?cseq=' + target_CSEQ;
}

//상세페이지 이동 함수
function go_detailPage_Series(target_CSEQ){
	location.href = get_domain() + '/series/contentSeries.html?cseq=' + target_CSEQ;
}

//리뷰 리스트를 ajax요청하는 함수
function getReviewList(currentPage){
	var mseq = location.search.split('?mseq=')[1];
	var URL = '/series/contentProfileReviewList.html';
	$.ajax({
		type: 'GET',
		url: URL,
		dataType: 'html',
		data: 'mseq=' + mseq + '&currentPage=' + currentPage,
		success: function(serializedHTML,textStatus){
				$('#review_container').attr('innerHTML',serializedHTML);
		}
	});
}
  

function span_favoriteList(value, type){
	
	var sizeSpan = document.getElementById('sizeSpan');
	var typeSpan = document.getElementById('typeSpan'); 
	chgColor();
	if(value == 'series')
	{
		typeSpan.value = value; 
	}
	else if(value == 'person')
	{
		typeSpan.value = value;

	}

	if(type == 0)
	{
		$('#fanList-div').css('height','auto');
		if(sizeSpan.value == 'big')
		{
			$('#span_status').attr('innerHTML','- 간략보기');
		}
		else
		{
			$('#span_status').attr('innerHTML','+ 전체보기');
		}
	}
	else 
	{
		if(sizeSpan.value == 'big')	// 전체 보기 모드였을시에.
		{
			if(typeSpan.value == 'series')
			{
				$('#fanList-div').animate({height:230},"normal");
				$('#fanList-div .zzim-list li:gt(2)').hide();
				$('#fanList-div .paginate').hide();
			}
			else
			{
				var fanTotalCurrentRecord  = $('#fanTotalCurrentRecord').attr('value');
				if(fanTotalCurrentRecord > 3)
				{
					$('#fanList-div').animate({height:230},"normal"); 
					$('#fanList-div .paginate').hide();
				}
				else
				{
					$('#fanList-div').animate({height:120},"normal"); 
					$('#fanList-div .paginate').hide();
				}
			}
			
			sizeSpan.value = 'small';
			$('#span_status').attr('innerHTML','+ 전체보기');
		}
		else
		{
			sizeSpan.value = 'big';
			$('#fanList-div .zzim-list li:gt(2)').show();
			$('#fanList-div .paginate').show();
			$('#fanList-div').css('height','auto');
			$('#span_status').attr('innerHTML','- 간략보기');
		}
	}  
}

function span_type(value)
{
	var sizeSpan = document.getElementById('sizeSpan');
	var typeSpan = document.getElementById('typeSpan'); 
	
	typeSpan.value = value;
	sizeSpan.value = 'small';
	if(value == 'series')
	{
		$('#fanList-div').css('height','230'); 
		$('#fanList-div .zzim-list li:gt(2)').hide();
		$('#fanList-div .paginate').hide();
	}
	else
	{
		$('#fanList-div').css('height','230');
		$('#fanList-div .paginate').hide();
	}
	chgColor();
}

function chgColor()
{
	var typeSpan = document.getElementById('typeSpan');
	if(typeSpan.value == 'series')
	{
		$('#tabInfo').attr('src', $('#tabInfo').attr('src').replace('_off.gif', '_on.gif'));
		$('#tabAward').attr('src', $('#tabAward').attr('src').replace('_on.gif', '_off.gif'));
	}
	else if(typeSpan.value == 'person')
	{
		$('#tabInfo').attr('src', $('#tabInfo').attr('src').replace('_on.gif', '_off.gif'));
		$('#tabAward').attr('src', $('#tabAward').attr('src').replace('_off.gif', '_on.gif'));
	}
	else
	{
		return;
	}
	
}

//팬 목록
function getFanmList(currentPage, value){
	var mseq = location.search.split('?mseq=')[1];
	var type = 0;
	if(currentPage == 0)
	{
		type = 1;
		currentPage = 1;
	}
 
	var url = "/contents/contentProfileFanActorList.html";
	jQuery.ajax({
		type: 'GET',
		url: url + '?mseq=' + mseq + '&currentPage=' + currentPage + '&mode=' + value,
		dataType: 'html',
		success: function(serializedHTML,textStatus){
				$('#fanList-div').attr('innerHTML',serializedHTML);
				if(type == 1)
				{
					span_type(value);
				}
				else
				{
					span_favoriteList(value, type);
				}
		} 
	});
}
 

//리뷰 삭제/신고 보이기
function reviewOn(count){
	jQuery('.review-list .li_'+count).css('background','#f5f5f5');
	jQuery('.review-list .li_'+count+' .del').css('visibility','visible');
	jQuery('.review-list .li_'+count+' .notify').css('visibility','visible');
}
// 리뷰 삭제/신고 안보이기
function reviewOff(count){
	jQuery('.review-list .li_'+count).css('background','#fff');
	jQuery('.review-list .li_'+count+' .del').css('visibility','hidden');
	jQuery('.review-list .li_'+count+' .notify').css('visibility','hidden');
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
