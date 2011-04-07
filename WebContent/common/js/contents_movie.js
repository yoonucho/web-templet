function set_order_btn(){
	var current_page = window.location.pathname.replace('.html', '').split('/')[2];
	switch(current_page){
		case 'topMovie':
			$($('#btn_orderBy_update').attr('parentNode')).hide();
			$($('#btn_orderBy_open').attr('parentNode')).hide();
			$($('#btn_orderBy_ganada').attr('parentNode')).hide();
			$($('#btn_orderBy_3month').attr('parentNode')).show();
			$($('#btn_orderBy_month').attr('parentNode')).show();
			$($('#btn_orderBy_heart').attr('parentNode')).show();
			$($('#btn_orderBy_week').attr('parentNode')).show();
			break;
		case 'openningMovie': 
			$($('#btn_orderBy_update').attr('parentNode')).hide();
			$($('#btn_orderBy_open').attr('parentNode')).show();
			$($('#btn_orderBy_ganada').attr('parentNode')).hide();
			$($('#btn_orderBy_heart').attr('parentNode')).show();
			$($('#btn_orderBy_week').attr('parentNode')).hide();
			$($('#btn_orderBy_3month').attr('parentNode')).hide();
			$($('#btn_orderBy_month').attr('parentNode')).hide();			
			break;
		case 'freeMovie':			
		case 'flatRateMovie':			
		case 'flatRateNewMovie':			
		case 'genreMovie':
			$($('#btn_orderBy_update').attr('parentNode')).show();
			$($('#btn_orderBy_open').attr('parentNode')).show();
			$($('#btn_orderBy_ganada').attr('parentNode')).show();
			$($('#btn_orderBy_heart').attr('parentNode')).show();
			$($('#btn_orderBy_week').attr('parentNode')).hide();
			$($('#btn_orderBy_3month').attr('parentNode')).hide();
			$($('#btn_orderBy_month').attr('parentNode')).hide();			
			break;
		default:
		case 'newUpdateMovie':
			$($('#btn_orderBy_update').attr('parentNode')).show();
			$($('#btn_orderBy_open').attr('parentNode')).show();
			$($('#btn_orderBy_ganada').attr('parentNode')).show();
			$($('#btn_orderBy_heart').attr('parentNode')).hide();
			$($('#btn_orderBy_week').attr('parentNode')).hide();
			$($('#btn_orderBy_3month').attr('parentNode')).hide();
			$($('#btn_orderBy_month').attr('parentNode')).hide();			
			break;		
	}	
}

function set_order_to_zero(){
	$(document.getElementsByName('orderBtn')).each(function(index,targetIMGTAG){
		//$(targetIMGTAG).attr('src',$(targetIMGTAG).attr('src').replace('_.gif','.gif'));
		$(targetIMGTAG).attr('src',$(targetIMGTAG).attr('src').replace('on.gif','off.gif'));
	});
//	jQuery(".orderBtn").attr("src", jQuery(".orderBtn").attr("src").replace("_.gif", ".gif"));
}

function set_order_condition(){
	var current_order_condition = $('#current_order_condition').val();

	switch(current_order_condition){
		case 'RECENT_MOVIE_BY_UPDATE':
		case 'GENRE_MOVIE_BY_UPDATE':
			$('#btn_orderBy_update').attr('src',$('#btn_orderBy_update').attr('src').replace('off.gif','on.gif'));
			break;
		case 'RECENT_MOVIE_BY_RELEASED_DATE':
		case 'NEW_RELEASE_MOVIE_BY_RELEASED_DATE':
		case 'GENRE_MOVIE_BY_RELEASED_DATE':
			$('#btn_orderBy_open').attr('src',$('#btn_orderBy_open').attr('src').replace('off.gif','on.gif'));
			break;
		case 'RECENT_MOVIE_BY_GANADA':
		case 'GENRE_MOVIE_BY_GANADA':
			$('#btn_orderBy_ganada').attr('src',$('#btn_orderBy_ganada').attr('src').replace('off.gif','on.gif'));
			break;
		case 'TOP30_MOVIE_BY_UTILIZATION':
			$('#btn_orderBy_week').attr('src',$('#btn_orderBy_week').attr('src').replace('off.gif','on.gif'));
			break;
		case 'GENRE_MOVIE_BY_FANTOTAL':
		case 'NEW_RELEASE_MOVIE_BY_FANTOTAL':
		case 'TOP30_MOVIE_BY_FANTOTAL':
			$('#btn_orderBy_heart').attr('src',$('#btn_orderBy_heart').attr('src').replace('off.gif','on.gif'));
			break;
		case 'TOP30_MOVIE_BY_MONTH':
			$('#btn_orderBy_month').attr('src',$('#btn_orderBy_month').attr('src').replace('off.gif','on.gif'));
			break;
		case 'TOP30_MOVIE_BY_3MONTH':
			$('#btn_orderBy_3month').attr('src',$('#btn_orderBy_3month').attr('src').replace('off.gif','on.gif'));
			break;
	}
	var str_DESC = 'ORDER_BY_DESC';
	var str_ASC = 'ORDER_BY_ASC';
	switch(current_order_condition){
		case 'RECENT_MOVIE_BY_UPDATE':
			$('#current_order_direction').attr('value',str_ASC);
			break;
		case 'RECENT_MOVIE_BY_GANADA':
			$('#current_order_direction').attr('value',str_ASC);
			break;
		case 'RECENT_MOVIE_BY_RELEASED_DATE':
			$('#current_order_direction').attr('value',str_DESC);
			break;
		case 'TOP30_MOVIE_BY_MONTH':
		case 'TOP30_MOVIE_BY_3MONTH':
		case 'TOP30_MOVIE_BY_UTILIZATION':
			$('#current_order_direction').attr('value',str_ASC);
			break;
		case 'TOP30_MOVIE_BY_FANTOTAL':
			$('#current_order_direction').attr('value',str_DESC);
			break;
		case 'GENRE_MOVIE_BY_UPDATE':
			$('#current_order_direction').attr('value',str_DESC);
			break;
		case 'GENRE_MOVIE_BY_RELEASED_DATE':
			$('#current_order_direction').attr('value',str_DESC);
			break;
		case 'GENRE_MOVIE_BY_GANADA':
			$('#current_order_direction').attr('value',str_ASC);
			break;
		case 'GENRE_MOVIE_BY_FANTOTAL':
			$('#current_order_direction').attr('value',str_DESC);
			break;
		case 'NEW_RELEASE_MOVIE_BY_RELEASED_DATE':
			$('#current_order_direction').attr('value',str_DESC);
			break;
		case 'NEW_RELEASE_MOVIE_BY_FANTOTAL':
			$('#current_order_direction').attr('value',str_DESC);
			break;
	}
}

function do_ordering_init(){
	var current_page = window.location.pathname.replace('.html', '').split('/')[2];
	var ord = "";
	if(current_page == "newUpdateMovie"){
		ord = "RECENT_MOVIE_BY_UPDATE";
	} else if(current_page == "topMovie"){
		ord = "TOP30_MOVIE_BY_UTILIZATION";
	} else if(current_page == "openningMovie") {
		ord = "NEW_RELEASE_MOVIE_BY_RELEASED_DATE";
	} else {
		ord = "GENRE_MOVIE_BY_UPDATE";
		genre_filter_init_first();
	}
	
	$('#current_order_condition').val(ord);
	set_order_to_zero();
	set_order_condition();
	
	getMoiveList(1);
}

function do_ordering(currentOrderName,backToFirst){
	$('#current_order_condition').attr('value',currentOrderName);
	set_order_to_zero();
	set_order_condition();

	if(backToFirst){
		preMovieList(1);
	}
	else{
		getMoiveList($('div.paging').find('strong').attr('innerHTML'));
	}
}

function init_order_btn(){
	set_order_btn();
	set_order_condition();	
}
function preMovieList(currentPage){
	var sort = jQuery("#current_order_condition").val();
	var genre = jQuery("#current_genre_condition").val();
	var nation = jQuery("#current_nation_condition").val();
	var pay = jQuery("#current_pay_condition").val();
	var url = "#"+currentPage+","+sort;

	if(genre != "존재하지않는코드입니다" && genre != null && genre != ""){
		url += ","+genre;
	}else{
		url += ",";
	}
	if(nation != "존재하지않는코드입니다" && nation != null && nation != ""){
		url += ","+nation;
	}else{
		url += ",";
	}
	if(pay != "존재하지않는코드입니다" && pay != null && pay != ""){
		url += ","+pay;
	}else{
		url += ",";
	}
    url = url.replace(/^.*#/, '');

    jQuery.history.load(url);

    getMoiveList(currentPage);
	
}
function getMoiveList(currentPage){
	window.scroll(0,0);
	var currentOrderModeName = $('#current_order_condition').attr('value');
	var currentOrderDirectionName = $('#current_order_direction').attr('value');
	var currentGenreConditionName = $('#current_genre_condition').attr('value');
	var currentNationConditionName = $('#current_nation_condition').attr('value');
	var currentPayConditionName = $('#current_pay_condition').attr('value');
	var pathName = location.pathname.replace('.html','List.html');

	var URL;
	if(pathName == '/'){
		URL = location.href.replace(location.search,'') + 'movie/newUpdateMovie.html';
	}
	else{
		URL = location.pathname.replace('.html','List.html');
	}

	$.ajax({
		type: 'GET',
		url: URL,
		dataType: 'html',
		data:
		'currentPage=' + currentPage + 
		'&currentOrderModeName=' + currentOrderModeName + 
		'&currentOrderDirectionName=' + currentOrderDirectionName +
		'&currentGenreConditionName=' + currentGenreConditionName +
		'&currentNationConditionName=' + currentNationConditionName +
		'&currentPayConditionName=' + currentPayConditionName,
		success: function(serializedHTML,textStatus){
				$('#movie_list').attr('innerHTML',serializedHTML);
		},
		error: function(){
			alert('영화 데이터 일람 취득에 실패하였습니다.');
		}
	});
	
	document.title  = "Playy";
}

function update_my_favorite(ref_this,contentId){
	var IsREGIST = $(ref_this).attr('src').search('_off') != -1;
	var IsZZIM = $(ref_this).attr('name').search('ZZIM') != -1;
	if(IsREGIST){
		if(IsZZIM){
			insertFanZzim('insertMovieZzim',contentId);
		}
		else{
			insertFanZzim('insertMovieFan',contentId);
		}
	}
	else{
		if(IsZZIM){
			deleteFanZzim('deleteMovieZzim',contentId);
		}
		else{
			deleteFanZzim('deleteMovieFan',contentId);
		}		
	}
}

function request_FAN(ref_this,contentId){
	if(isLogin == 'false'){
		var answer = confirm("로그인이 필요한 기능입니다.\n 로그인 하시겠습니까?");
		if(answer){
			loginPop();
		}
	}
	else{
		update_my_favorite(ref_this,contentId);
	}
}

function request_ZZIM(ref_this,contentId){
	if(isLogin == 'false'){
		var answer = confirm("로그인이 필요한 기능입니다.\n 로그인 하시겠습니까?");
		if(answer){
			loginPop();
		}
	}
	else{
		update_my_favorite(ref_this,contentId);
	}
}

function insertFanZzim(select,contentId){
	var alert_message = "팬 등록을 하시겠습니까?";
	var success_message = "팬 등록에 성공하였습니다.";
	var fail_message = "팬 등록에 실패하였습니다.";

	if (select.search("Zzim") != -1) {
		/*
		var isZzim = "$!{res.contents.zzimRegisted}";
		if (isZzim == "Y") {
			alert("�깅줉��李쒖엯�덈떎.");
			return;
		}
		*/
		alert_message = "찜 등록을 하시겠습니까?";
		success_message = "찜 등록에 성공하였습니다.";
		fail_message = "찜 등록에 실패하였습니다.";
	}
	//var answer = confirm(alert_message);
	//if(answer){
	if(true){
		jQuery.ajax({
			type:'POST',
			url:'/content/movieInsertFanZzim.html',
			data:{section : select, contentId : contentId},
			contentType:'application/x-www-form-urlencoded;charset=euc-kr',
			async:false,
			success: function(msg){
		    	var result = msg;
		    	if (result == "success") {
		    		//alert(success_message);
		    	} else if (result == "insertFail") {
		    		alert(fail_message);
		    	} else {
		    		var answer = confirm("로그인이 필요한 기능입니다.\n 로그인 하시겠습니까?");
		    		if(answer){
		    			loginPop();
		    		}
		    	}
		    },
		    error : function(data, status, err){
		    	alert("error forward : " + data);
		    },
		    complete : function(){
		    	//choice_menu('$!{contentMovieRequest.section}');
		    	do_ordering($('#current_order_condition').attr('value'),false);
		    	refreshMyPlayyBanner();
		    }
		});
	}
}
function deleteFanZzim(select,contentId){
	var alert_message = "팬 해제를 하시겠습니까?";
	var success_message = "팬 해제에 성공하였습니다.";
	var fail_message = "팬 해제에 실패하였습니다.";

	if (select.search("Zzim") != -1) {
		/*
		var isZzim = "$!{res.contents.zzimRegisted}";
		if (isZzim == "Y") {
			alert("�깅줉��李쒖엯�덈떎.");
			return;
		}
		*/
		alert_message = "찜 해제를 하시겠습니까?";
		success_message = "찜 해제에 성공하였습니다.";
		fail_message = "찜 해제에 실패하였습니다.";
	}
	
	//var answer = confirm(alert_message);
	//if(answer){
	if(true){
		jQuery.ajax({
			type:'POST',
			url:'/content/movieDeleteFanZzim.html',
			data:{section : select, contentId : contentId},
			contentType:'application/x-www-form-urlencoded;charset=euc-kr',
			async:false,
			success: function(msg){
		    	var result = msg;
		    	if (result == "success") {
		    		//alert(success_message);
		    	} else if (result == "deleteFail") {
		    		alert(fail_message);
		    	} else {
		    		var answer = confirm("로그인이 필요한 기능입니다.\n 로그인 하시겠습니까?");
		    		if(answer){
		    			loginPop();
		    		}
		    	}
		    },
		    error : function(data, status, err){
		    	alert("error forward : " + data);
		    },
		    complete : function(){
		    	//choice_menu('$!{contentMovieRequest.section}');
		    	do_ordering($('#current_order_condition').attr('value'),false);
		    	refreshMyPlayyBanner();
		    }
		});
	}
}

function pagerFactory_roller(idx, slide) {	
    var tagblock_pager = '<li><a><img src="/common/pc/img/common/btn/btn_circle_off.gif" alt="" style="cursor:pointer;" /></a></li>'; 
    if(idx == 0){
    	tagblock_pager = '<li><a><img src="/common/pc/img/common/btn/btn_circle_on.gif" alt="" style="cursor:pointer;" /></a></li>';  
    }
	return tagblock_pager;
}

function pager_imageChanger(zeroBasedSlideIndex, slideElement){
	var beforeIndex;
	$('div.wid682').find('li').each(function(liINDEX,targetLI){
		if($(targetLI).find('img').attr('src').search('on.gif') != -1){
			beforeIndex = liINDEX;
		}
	});
	$($('.movie-r').get(beforeIndex)).attr('innerHTML',$($('.movie-r').get(beforeIndex)).attr('innerHTML'));
	
	$('#nav').find('img').each(function(index,imgTAG){
		if(zeroBasedSlideIndex == index){
			$(imgTAG).attr('src','/common/pc/img/common/btn/btn_circle_on.gif');
		}
		else{
			$(imgTAG).attr('src','/common/pc/img/common/btn/btn_circle_off.gif');
		}		
	});	
	
	$($('.movie-r').get(zeroBasedSlideIndex)).attr('innerHTML',$($('.movie-r').get(zeroBasedSlideIndex)).attr('innerHTML'));
	
}

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

function init_fillter_btn(){
	//?currentGenreConditionName=ACTION_SF&currentNationConditionName=ALL_NATIONS&currentPayConditionName=ALL_PRICES
	if(location.search == ''){
		//do nothing
	}
	else{
		var genreFillters = getUrlVars();
		if(genreFillters.currentGenreConditionName == undefined){
			//do_nothing
		}
		else{
			var FoundMatchedCondition = false;
			$('#Container_genreFillter').find('input').each(function(targetFillterIndex,inputTag){
				if($(inputTag).attr('value') == genreFillters.currentGenreConditionName){
					$($('#Container_genreFillter').find('a').get(targetFillterIndex)).addClass("on");
					FoundMatchedCondition = true;
				}
				else{
					$($('#Container_genreFillter').find('a').get(targetFillterIndex)).removeClass("on");
				}
			});
			if(!FoundMatchedCondition){
				$($('#Container_genreFillter').find('a').get(0)).addClass("on");
			}
			else{
				//do_nothing
			}
		}
		if(genreFillters.currentNationConditionName == undefined){
			//do_nothing
		}
		else{
			var FoundMatchedCondition = false;
			$('#Container_nationFillter').find('input').each(function(targetFillterIndex,inputTag){
				if($(inputTag).attr('value') == genreFillters.currentNationConditionName){
					$($('#Container_nationFillter').find('a').get(targetFillterIndex)).addClass("on");
					FoundMatchedCondition = true;
				}
				else{
					$($('#Container_nationFillter').find('a').get(targetFillterIndex)).removeClass("on");
				}
			});
			if(!FoundMatchedCondition){
				$($('#Container_nationFillter').find('a').get(0)).addClass("on");
			}
			else{
				//do_nothing
			}
		}
		if(genreFillters.currentPayConditionName == undefined){
			//do_nothing
		}
		else{
			var FoundMatchedCondition = false;
			$('#Container_paymentFillter').find('input').each(function(targetFillterIndex,inputTag){
				if($(inputTag).attr('value') == genreFillters.currentPayConditionName){
					$($('#Container_paymentFillter').find('a').get(targetFillterIndex)).addClass("on");
					FoundMatchedCondition = true;
				}
				else{
					$($('#Container_paymentFillter').find('a').get(targetFillterIndex)).removeClass("on");
				}
			});
			if(!FoundMatchedCondition){
				$($('#Container_paymentFillter').find('a').get(0)).addClass("on");
			}
			else{
				//do_nothing
			}
		}
	}	
}

function init_freeViewRegion(){
	$('div.movie-info').find('div.fl').css('display','block');
	$('div.movie-info').find('div.movie-r').css('display','block');
}

$(document).ready(function(){
	init_order_btn();
	
	if($('.s-tab').length > 0){
		init_fillter_btn();
	}

	if($('#container_rolling').length>0){
		$('#container_rolling').cycle({
		    fx:      'fade',
		    speed:   10,
		    timeout:  0,
		    pager:   '#nav',
		    pagerAnchorBuilder: pagerFactory_roller,
		    pagerClick:  pager_imageChanger 
		});
	}

	$('.s-tab').find('a').hover(
			function(){
				$(this).css({'background':'url(http://www.playy.co.kr/common/pc/img/newmovie/bg_btn_right.gif) right top no-repeat'});
				if($.browser.msie){
					switch($.browser.version){
						case '6.0':
						case '7.0':
							$(this).css({'padding':'0px'});
							break;
						default:
							$(this).css({'padding':'3px 0'});
					}
				}
				else{
					$(this).css({'padding':'3px 0'});
				}				
			}
			,
			function(){
				if($(this).hasClass('on')){
					//do_nothing				
				}
				else{
					$(this).css('background','none');
				}
			}
		);

	$('.s-tab').find('a > span').hover(
		function(){
			$(this).css({'background':'url(http://www.playy.co.kr/common/pc/img/newmovie/bg_btn_left.gif) left top no-repeat'});
			$(this).css('color','#ccc');
			$(this).css('padding','3px 8px');
		}
		,
		function(){
			if($($(this).attr('parentNode')).hasClass('on')){
				//do_nothing
			}
			else{
				$(this).css('background','none');
				$(this).css('color','#333');
			}
		}
	);

	$(document.getElementsByName('fillter')).click(function(){
		var target_innerHTML = $(this).attr('innerHTML');
		var target_index = 0;
		$($(this).attr('parentNode')).find('a').each(function(index,targetANCHOR){
			if($(targetANCHOR).attr('innerHTML') == target_innerHTML){
				target_index = index;
			}
			$(targetANCHOR).removeClass('on');
			$(targetANCHOR).css('background','none');
			$(targetANCHOR).find('span').css('background','none');
			$(targetANCHOR).find('span').css('color','#333');
			if($(targetANCHOR).find('span.ico-19').length == 1){
				$(targetANCHOR).find('span.ico-19').css('background-image','none');
				$(targetANCHOR).find('span.ico-19').css('padding','0px');
				$(targetANCHOR).find('span.ico-19').css('font-size','11px');
				$(targetANCHOR).find('span.ico-19').css('color','red');
				$(targetANCHOR).find('span.ico-19').css('font-weight','bold');
			}
		});
		$(this).addClass('on');	
		$(this).css({'background':'url(http://www.playy.co.kr/common/pc/img/newmovie/bg_btn_right.gif) right top no-repeat'});
		$(this).find('span').css({'background':'url(http://www.playy.co.kr/common/pc/img/newmovie/bg_btn_left.gif) left top no-repeat'});
		$(this).find('span').css('color','#ccc');
		$(this).find('span.ico-19').css('color','red');
		$(this).find('span.ico-19').css('padding','0px');
		$(this).find('span.ico-19').css('background-image','none');
		var targetID_suffix = $($($($(this).attr('parentNode')).attr('parentNode')).attr('parentNode')).attr('id').replace('fillter_','');
		var selectedValue = $($($(this).attr('parentNode')).find('input').get(target_index)).attr('value');
		switch(targetID_suffix){
			case "genre":
				$('#current_genre_condition').attr('value',selectedValue);
				break;
			case "nation":
				$('#current_nation_condition').attr('value',selectedValue);
				break;
			case "pay":
				$('#current_pay_condition').attr('value',selectedValue);
				break;
		}
		do_ordering($('#current_order_condition').attr('value'),true);
	});
		
	init_freeViewRegion();
	
	function loadContent(hash) {
		var href = location.href;
		var iLen = String(href).length;
		
		if(hash != "" && (String(href).substring(iLen, iLen-4) != "html")) {
			var pages = hash.split(",");
			
			jQuery('#current_order_condition').val(pages[1]);
			jQuery("#current_genre_condition").val(pages[2]);
			jQuery("#current_nation_condition").val(pages[3]);
			jQuery("#current_pay_condition").val(pages[4]);
			
			set_order_to_zero();
			set_order_condition();
			
			if((pages[2].length > 2) && (pages[3].length > 2) && (pages[4].length > 2)){
				genre_filter_init();
				genre_filter_set();
			}
			
			getMoiveList(pages[0]);
		} else {
			do_ordering_init();
		}
	};
	jQuery.history.init(loadContent);
	document.title = "Playy";
});

function genre_filter_init(){
	jQuery(".s-tab li dd").find("a").removeClass("on");
	jQuery(".s-tab li dd").find("a").removeAttr("style");
	jQuery(".s-tab li dd").find("a span").removeAttr("style");
}

function genre_filter_init_first(){
	jQuery(".s-tab li dd").find("a").removeClass("on");
	jQuery(".s-tab li dd").find("a").removeAttr("style");
	jQuery(".s-tab li dd").find("a span").removeAttr("style");
	
	//jQuery("#current_genre_condition").val("ALL");
	//jQuery("#current_nation_condition").val("ALL_NATIONS");
	//jQuery("#current_pay_condition").val("ALL_PRICES");
	
	genre_filter_set();
}


function genre_filter_set(){
	var genre = jQuery("#current_genre_condition").val();
	var nation = jQuery("#current_nation_condition").val();
	var pay = jQuery("#current_pay_condition").val();
	
	if(genre == "ALL"){
		genre = "ALL_GENRE";
	}
	
	jQuery(".s-tab li dd #"+genre).addClass("on");
	jQuery(".s-tab li dd #"+genre).attr("style", "padding-top: 3px; padding-right: 0px; padding-bottom: 3px; padding-left: 0px; background-image: url(http://www.playy.co.kr/common/pc/img/newmovie/bg_btn_right.gif); background-attachment: initial; background-origin: initial; background-clip: initial; background-color: initial; background-position: 100% 0%; background-repeat: no-repeat no-repeat;");
	jQuery(".s-tab li dd #"+genre+" span").attr("style", "padding-top: 3px; padding-right: 8px; padding-bottom: 3px; padding-left: 8px; background-image: url(http://www.playy.co.kr/common/pc/img/newmovie/bg_btn_left.gif); background-attachment: initial; background-origin: initial; background-clip: initial; background-color: initial; color: rgb(204, 204, 204); background-position: 0% 0%; background-repeat: no-repeat no-repeat;");
	
	jQuery(".s-tab li dd #"+nation).addClass("on");
	jQuery(".s-tab li dd #"+nation).attr("style", "padding-top: 3px; padding-right: 0px; padding-bottom: 3px; padding-left: 0px; background-image: url(http://www.playy.co.kr/common/pc/img/newmovie/bg_btn_right.gif); background-attachment: initial; background-origin: initial; background-clip: initial; background-color: initial; background-position: 100% 0%; background-repeat: no-repeat no-repeat;");
	jQuery(".s-tab li dd #"+genre+" span").attr("style", "padding-top: 3px; padding-right: 8px; padding-bottom: 3px; padding-left: 8px; background-image: url(http://www.playy.co.kr/common/pc/img/newmovie/bg_btn_left.gif); background-attachment: initial; background-origin: initial; background-clip: initial; background-color: initial; color: rgb(204, 204, 204); background-position: 0% 0%; background-repeat: no-repeat no-repeat;");
	
	jQuery(".s-tab li dd #"+pay).addClass("on");
	jQuery(".s-tab li dd #"+pay).attr("style", "padding-top: 3px; padding-right: 0px; padding-bottom: 3px; padding-left: 0px; background-image: url(http://www.playy.co.kr/common/pc/img/newmovie/bg_btn_right.gif); background-attachment: initial; background-origin: initial; background-clip: initial; background-color: initial; background-position: 100% 0%; background-repeat: no-repeat no-repeat;");
	jQuery(".s-tab li dd #"+genre+" span").attr("style", "padding-top: 3px; padding-right: 8px; padding-bottom: 3px; padding-left: 8px; background-image: url(http://www.playy.co.kr/common/pc/img/newmovie/bg_btn_left.gif); background-attachment: initial; background-origin: initial; background-clip: initial; background-color: initial; color: rgb(204, 204, 204); background-position: 0% 0%; background-repeat: no-repeat no-repeat;");
	
}

function fireEvent(src, type){
	if(document.createEventObject){
    	var evt = document.createEventObject();
        return src.fireEvent('on'+type, evt);
	}else{
            var evt = document.createEvent("HTMLEvents");
            evt.initEvent(type, true, true);
            return !src.dispatchEvent(evt);
        }
};
