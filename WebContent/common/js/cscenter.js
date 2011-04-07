//Read a page's GET URL variables and return them as an associative array.
function getUrlVars(){
    var vars = [], hash;
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for(var i = 0; i < hashes.length; i++)
    {
        hash = hashes[i].split('=');
        vars.push(hash[0]);
        vars[hash[0]] = hash[1];
    }
    return vars;
}

//커스터마이즈 팝업 오픈
function PopNewWindow(url,width,height){
	window.open(url,'_blank','width=' + width + ',height=' + height + ',scrollbars=yes');
	return false;
}

//결제관련 페이지로 부모창을 리프레쉬 시키는 함수
function go_PaymentPrincipal(){
	try{
		window.opener.location.href = '/event/eventFreeUseFul.html';
	}
	catch(e){
		window.open('http://www.playy.co.kr/event/eventFreeUseFul.html','_blank','toolbar=yes,titlebar=yes,resizable=yes,menubar=yes,fullscreen=yes,scrollbars=yes');
	}
	finally{
		window.close();
	}	
}

function update_hit(targetID){
	var URL;
	if(location.pathname.search('notice') != -1){
		URL = '/customer/noticeCount.html';
	}
	else if(location.pathname.search('helpFaq') != -1){
		URL = '/customer/faqCount.html';
	}
	else if(location.pathname.search('event') != -1){
		URL = '/customer/eventCount.html';
	}	
	else{
		//do nothing
	}

	$.ajax({
		type: 'POST',
		url: URL,
		dataType: 'html',
		data:
		'id=' + targetID
		, 
		success: function(serializedHTML,textStatus){
			//alert(serializedHTML);
		},
		error: function(){
			alert('조회수 업데이트에 실패하였습니다.');
		}
	});
}

function do_search(currentPage){
	if($('#kensaku').attr('value').length > 0){
		$.ajax({
			type: 'POST',
			url: '/customer/faqSearch.html',
			dataType: 'html',
			data:
			'title=' + $('#kensaku').attr('value') + 
			'&mode=search_by_title' + 
			'&currentPage=' + currentPage + '&faqCd='+ $('#faqCode').attr('value')
			, 
			success: function(serializedHTML,textStatus){
				$('div.contents').find('h2').attr('innerHTML','검색 결과');
				$('#list_container').attr('innerHTML',serializedHTML);
			},
			error: function(){
				alert('검색결과 취득에 실패하였습니다.');
			}
		});
	}
	else{
		alert('검색 문자열을 입력해 주세요');
	}
}

function do_search_notice(currentPage){
	if($('#kensaku').attr('value').length > 0){
		$.ajax({
			type: 'POST',
			url: '/customer/noticeSearch.html',
			dataType: 'html',
			data:
			'title=' + $('#kensaku').attr('value') + 
			'&mode=search_by_title' + 
			'&currentPage=' + currentPage
			, 
			success: function(serializedHTML,textStatus){
				$('div.contents').find('h2').attr('innerHTML','검색 결과');
				$('#list_container').attr('innerHTML',serializedHTML);
			},
			error: function(){
				alert('검색결과 취득에 실패하였습니다.');
			}
		});
	}
	else{
		alert('검색 문자열을 입력해 주세요');
	}
}

function do_search_event(currentPage){
	if($('#kensaku').attr('value').length > 0){
		$.ajax({
			type: 'POST',
			url: '/customer/eventSearch.html',
			dataType: 'html',
			data:
				'title=' + $('#kensaku').attr('value') + 
				'&mode=search_by_title' + 
				'&currentPage=' + currentPage
				, 
				success: function(serializedHTML,textStatus){
					$('div.contents').find('h2').attr('innerHTML','검색 결과');
					$('#list_container').attr('innerHTML',serializedHTML);
				},
				error: function(){
					alert('검색결과 취득에 실패하였습니다.');
				}
		});
	}
	else{
		alert('검색 문자열을 입력해 주세요');
	}
}

function getCsCenterList_ByCategory(faqCd){
	location.href = location.pathname + '?faqCd=' + faqCd;
}

function getFaqList(currentPage){
	location.href = '/customer/helpFaq.html' + '?currentPage=' + currentPage + '&faqCd=' + getUrlVars().faqCd;
}

function getNoticeList(currentPage){
	location.href = '/customer/notice.html' + '?currentPage=' + currentPage;
}


function getEeventWinList(currentPage){
	location.href = '/customer/eventWin.html' + '?currentPage=' + currentPage;
}

function do_accordionAction(clickedIndex,targetID,ref_this){
	$('table.table01').find('div.detial_view').each(function(index,targetPTAG){
		var IsClosed;
		var targetTRTAG = $($($(targetPTAG).attr('parentNode')).attr('parentNode'));
		if(clickedIndex != index){
			$(targetTRTAG).hide();
		}
		else{
			if($.browser.msie){
				switch($.browser.version){
					case '6.0':
					case '7.0':
						IsClosed = $(targetTRTAG).innerHeight() == 0;
						break;
					default:
						IsClosed = $($('table.table01').find('div.detial_view').get(clickedIndex)).innerHeight() == 0;
				}
			}
			else{
				IsClosed = $($('table.table01').find('div.detial_view').get(clickedIndex)).innerHeight() == 0;
			}			
			if(IsClosed){
				update_hit(targetID);
				$(targetTRTAG).show();
			}
			else{
				close_all(ref_this);
			}						
		}
	});
}

//게시판 아코디언 모두 닫기 함수
function close_all(ref_this){
	$($($($(ref_this).attr('parentNode')).attr('parentNode')).attr('parentNode')).find('div.detial_view').each(function(index,targetPTAG){
		$($($(targetPTAG).attr('parentNode')).attr('parentNode')).hide();
	});
}

$(document).ready(function(){	

	//상단메뉴 초기화 콜백
	$('ul.cs-gnb').find('a').each(function(index,targetANCHOR){
		if($(targetANCHOR).attr('href') == location.pathname){
			$($(targetANCHOR).attr('parentNode')).addClass('select');
			$(targetANCHOR).find('img').attr('src',$(targetANCHOR).find('img').attr('src').replace('.gif','_.gif'));
		}
		else{
			$($(targetANCHOR).attr('parentNode')).removeClass('select');
			$(targetANCHOR).find('img').attr('src',$(targetANCHOR).find('img').attr('src').replace('_.gif','.gif'));
		}
	});
	
	//lnb 초기화 콜백
	$('ul.slnb01').find('li.on02').each(function(index,targetLI){
		if($(targetLI).find('a').attr('href') != '/customer/smartPhone.html'){
			$($('ul.cs-gnb').find('li').get(0)).addClass('on02');
			$($('ul.cs-gnb').find('li').get(0)).find('img').attr('src',$($('ul.cs-gnb').find('li').get(0)).find('img').attr('src').replace('txt_gnb01.gif','txt_gnb01_.gif'));
		}
	});

	
	//lnb 초기화 콜백
	$('ul.lnb02').find('li').each(function(index,targetLI){
		if($(targetLI).find('a').attr('href') != '/customer/notice.html'){
			$($('ul.cs-gnb').find('li').get(3)).addClass('on01');
			$($('ul.cs-gnb').find('li').get(3)).find('img').attr('src',$($('ul.cs-gnb').find('li').get(3)).find('img').attr('src').replace('txt_gnb04.gif','txt_gnb04_.gif'));
		}
	});
	
	//상단메뉴 호버링 기동 콜백
	$('ul.cs-gnb').find('li').hover(
	  function(){
		  if($(this).find('img').attr('src').search('_.gif') == -1){
			  $(this).addClass("select");
			  $(this).find('img').attr('src',$(this).find('img').attr('src').replace('.gif','_.gif'));
		  }
	  },
	  function(){
		  if($(this).find('a').attr('href') != location.pathname){
			  $(this).removeClass("select");
			  $(this).find('img').attr('src',$(this).find('img').attr('src').replace('_.gif','.gif'));
		  }
	  }
	);
	
	//초기에 열릴 엘리먼트 초기화
	var targetElementId = getUrlVars().showElementId;
	if(targetElementId != undefined){
		$('table.table01').find('input').each(function(index,targetINPUTTAG){
			if($(targetINPUTTAG).attr('value') == targetElementId){
				var targetTRTAG = $($($(targetINPUTTAG).attr('parentNode')).attr('parentNode'));
				update_hit(targetElementId);
				$(targetTRTAG).show();
			}
		});		
	}
});