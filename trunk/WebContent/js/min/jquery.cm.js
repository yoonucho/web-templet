/*
 *************************************************************************
 * @source  : jquery.tv.js
 * @desc    : tving 사이트에서 사용하는 공통모듈 정의
 *----------------------------------------------------------
 * CJ제일제당 시스템
 * Copyright(c) 2010 CJ Systems,  All rights reserved.
 *----------------------------------------------------------
 * VER  DATE         AUTHOR      DESCRIPTION
 * ---  -----------  ----------  ------------------------------
 * 1.0  2011. 1. 26.       김형욱            최초 작성
 *************************************************************************
 */
(function($) {
	var commonFn = null;
	//div block
    $.hwBlock = function(str)
    {
		$('#'+str).block({ 
	        message: '<h1>Processing</h1>', 
	        css: { border: '3px solid #a00' } 
	    });
		
		$('#'+str).addClass(str+"black");
    },
    $.scrollDown = function(str)
    {
    	$("body").animate( {scrollTop: $("#"+str).offset().top}, 600);
    },
    //데이터 초기화
    $.dtInit = function(str)
    {
		$('#'+str).find("input:text").val("");
		$('#'+str).find("select").each(function (){
			$(this).find("option:eq(0)").attr("selected",true);	
		});
		
		$('#'+str).find("textarea").val("");
    },
    //div unblock
    $.hwUnBlock = function(str)
    {
    	$('#'+str).unblock();
    	$('#'+str).removeClass(str+"black");
    },
    //우편번호 가져오기 셋 시작
    //사용법	$.showZip();
    $.showZip = function(option){
    	
    	var zipHtml = 
    		"<div id=\"_divZipCodeView\" style=\"cursor: default\">"+
    		"<fieldset>"+
    		"	<input name=\"_zip_dong\" id=\"_zip_dong\" type=\"text\" value=\"\"/>"+
    		"	<input type=\"button\" onclick=\"$.getZipData();\" value=\"검색\"/>"+
    		"	<ul id=\"_ulZipDatas\">"+
    		"	</ul>"+
    		"</fieldset>"+
    		"<a href='' onclick=\"$.closeZip();return false;\">닫기</a>"
    		"</div> ";
    	$("body").append(zipHtml);
    	$.blockUI({ message: $('#_divZipCodeView') }); 
    	if(option.fn != undefined){
    		commonFn = option.fn;
    	}
    },
    $.closeZip = function(){
    	var opt = {"onUnblock":function(){$('#_divZipCodeView').remove();}};
    	$.unblockUI(opt);
    },
    $.getZipData = function(){
    	var option = {
			type : "get",
			url: ctx+"/cm/ma/CMMA040Q.do",
			data : {"dong":$("#_zip_dong").val()},
			success : function (json){
				var html="";
				if(!json){
					return false;
				}
				
				if(json.list.length>0){
					jQuery.each(json.list, function (i) {
						var addr = this.sido;
						if(null!=this.gugun && "" !=this.gugun){
							addr += " "+this.gugun;	
						}
						if(null!=this.dong && "" !=this.dong){
							addr += " "+this.dong;	
						}
						if(null!=this.bunji && "" !=this.bunji){
							addr += " "+this.bunji;	
						}
						
						
						var zipcode = this.zipcode.split("-")[0]+"-"+this.zipcode.split("-")[1];
						
						html+="<li>";
						
						
						html+="<a href='#' onclick='$.setZipcodeData(\""+this.zipcode+"\",\""+addr+"\");return false;'>"+"("+zipcode+")"+addr+"</a>";
						html+="</li>";
						
						$("#_ulZipDatas").html(html);
						
					});
				}
			}
		};
    	$.tv.getJson(option);
    },
    $.setZipcodeData = function(zip, addr){
    	if(commonFn!=null){
    		commonFn(zip,addr);
    		commonFn=null;
    	}
    	$.closeZip();
    },
    //우편번호 가져오기 셋 끝
    $.fn.removeAll_bc = function()
    {
        // jQuery에 확장 집합에서 동작하는 메서드 구현
        // 커멘드라고도 한다
        return this;// jQuety 확장집합을 돌려줘야함 
    }
	
})(jQuery);
 