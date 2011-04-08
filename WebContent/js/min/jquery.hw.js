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
	//함수들 실행.. 자주쓰이는 함수 정리
	
	//함수..
	$.fn.cut = function(len) {
		var str = this;
		var s = 0;
		for ( var i = 0; i < str.length; i++) {
			s += (str.charCodeAt(i) > 128) ? 2 : 1;
			if (s > len)
				return str.substring(0, i) + "...";
		}
		return str;
	};
	
	//콤마 추가
	$.fn.comma = function(x) {
		var txtNumber = '' + x;
		if (isNaN(txtNumber) || txtNumber == ""){
			return x;
		}else{
			var rxSplit = new RegExp('([0-9])([0-9][0-9][0-9][,.])');
			var arrNumber = txtNumber.split('.');
			arrNumber[0] += '.';
			do{
				arrNumber[0] = arrNumber[0].replace(rxSplit, '$1,$2');
			}while (rxSplit.test(arrNumber[0]));
			
			if (arrNumber.length > 1){
				return arrNumber.join('');
			}else{
				return arrNumber[0].split('.')[0];
			}
		}
	};
	
	$.tv = function() {
	    $.tv.impl.install();
	};
	
	$.tv.version = 1.0;
	
	//date
	$.tv.svrTm;
	
	$.tv.svrDiv_id="";
	
	$.tv.context="/vd";
	
	$.tv.imageDomain="";
	
	//내가본 상품 시작
	
//상품 등록
	$.tv.addLikePd = function(pd_id, pd_img){
		var cookPd = $.cookie('pdList');
		var newPd="";

		if(cookPd!=null && cookPd!=""){
			var pdList = $.cookie('pdList').split(",");
			var html ="";
			var saveChk = false;
			for(var i =0; i<=pdList.length;i++){
				
				if(pdList[i]==pd_id){
					saveChk = true;	
					break;
				}
			}
			if(saveChk){//기존있을때
				newPd =pd_id;
				for(var i =0; i<pdList.length;i++){
					if(pdList[i]!=pd_id){
						newPd +=","+pdList[i];
					}
				}
			}else{//기존에 없을때
				cookPd+=","+pd_id;
				newPd = cookPd;
			}

		}else{
			newPd = pd_id;
		}
		
		
		
		if($('#'+pd_img).html()!=null){
			var imgClon=$('#'+pd_img).clone();
			
			$("body").append("<div id='_imgShow' style=\"position: absolute;\"></div>");
			$("#_imgShow").hide();
			//$("#_imgShow").css("","")
			var imgPst = $('#'+pd_img).offset();
			$("#_imgShow").css("left",imgPst.left);
			$("#_imgShow").css("top",imgPst.top);
			$("#_imgShow").show();
			
			//alert(imgPst.left+" "+imgPst.top);
			$(imgClon).find("img").css("width","50px");
			$(imgClon).find("img").css("height","50px");
			
			$("#_imgShow").append(imgClon);
			var aPst =$("#imgList").offset();
			$("#_imgShow").animate({"left": aPst.left+"px","top":aPst.top+"px"}, 1500,function(){$("#_imgShow").remove();});
		}
		
		$.cookie('pdList', newPd, { expires: 30, path: '/'});
	}
	//내가본상품 가져오기
	$.tv.showLikePd = function(divId){
		if($.cookie('pdList')!=null){
			var pdList = $.cookie('pdList').split(",");
			
			var html ="";
			for(var i =0; i<pdList.length;i++){
				html+=pdList[i];
			}
			$("#"+divId).html(html);
			//alert($("#"+divId).html());
		}
		
		//$.cookie('pdList', pd_id, { expires: 30, path: '/'});
	}

//내가본 상품 종료

	
	//url 정보 object 리턴
//	파라미터정보
//		type : "VOD","P2P","LIVE", "DIRECT"		'타입구분
//		id : "00000060.DM4.10"		'고유번호
//	사용법 : 
//		var returnVal = $.tv.getURL({type:"VOD",id:""});
//		returnVal.xml;	'배열
//		returnVal.connectionUrl;'배열
//		returnVal.streamId;'배열
//		returnVal.type;	'string
//		returnVal.errMsg;	'배열
	$.tv.getURL = function(option) {
		return $.tv.impl.getURL(option);
	};
	
	//popup 창띄워서 새로 보기
	$.tv.popup = function(option) {
		$.tv.impl.popup(option);
	};

//	play 창을 블라인드 처리
//	파라미터정보
//		없음
//	사용법 : 
//		$.tv.blind();
	$.tv.blind = function(option) {
		$.tv.impl.blind(option);
	};

	//snsmsg 화면 띄우기
	$.tv.showSNSMsg = function(option) {
		$.tv.impl.showSNSMsg(option);
	};
	
	//snsmsg 보내기
	$.tv.sendSNSMsg = function(option) {
		$.tv.impl.showSNSMsg(option);
	};
	
	//xml 정보 가져오기
	$.tv.getXml = function(option) {
		option.dataType= "xml";
		
		$.tv.impl.getJson(option);
	};
	
	//json 정보 가져오기
	$.tv.getJson = function(option) {
		$.tv.impl.getJson(option);
	};

	//서버 시간 가져오기
	$.tv.getSvrTime = function(option) {
		$.tv.impl.getSvrTime(option);
	};

	//시간 표출
	$.tv.showTime = function() {
		$.tv.impl.showTime();
	};
	
	//moveCenter div를 화면 가운데로 이동한다
	$.tv.moveCenter = function(option) {
		$.tv.impl.moveCenter(option);
	};
	
	$.tv.comma = function(x) {
		var txtNumber = '' + x;
		if (isNaN(txtNumber) || txtNumber == ""){
			return x;
		}else{
			var rxSplit = new RegExp('([0-9])([0-9][0-9][0-9][,.])');
			var arrNumber = txtNumber.split('.');
			arrNumber[0] += '.';
			do{
				arrNumber[0] = arrNumber[0].replace(rxSplit, '$1,$2');
			}while (rxSplit.test(arrNumber[0]));
			
			if (arrNumber.length > 1){
				return arrNumber.join('');
			}else{
				return arrNumber[0].split('.')[0];
			}
		}
	};
	
	//replaceAll
	$.tv.rpall =function(val, str1,str2){
		return val.split(str1).join(str2);;
	};
	
	//문자중 숫자제거(dksehla)
	$.tv.rpall =function(val, str1,str2){
		var regExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
		
		return val.split(str1).join(str2);;
	};
	
	//반올림
	$.tv.rdp =function(val, precision){
		var p = Math.pow(10, precision);
		return Math.round(val*p)/p;
	};
	//절삭
	$.tv.frp =function(val, precision){
		var p = Math.pow(10, precision);
		return Math.floor(val*p)/p;
	};
	
	$.tv.impl = {
		install: function() {
			//alert("install");
		},
		getURL: function(option) {
			var xmlData = ["http://aa.com/dd.do","http://aa.com/dd.do"];
			var connectionURL = ["http://cds.icent.co.kr/vod/","http://www.yahoo.co.kr/"];
			var streamId = ["pc3.mp4:","pc3.mp4"];
			var errMsg = ["errmsg1:","errmsg2"];
			
			return {xml:xmlData, connectionUrl:connectionURL,streamId:streamId,type:option.type, errMsg:errMsg,id:option.id};
		},
		popup:function(option){
			window.open("http://yahoo.co.kr","pPop");
		},
		showSNSMsg:function(option){
			//window.open("http://yahoo.co.kr","pPop");
			alert("snsView");
		},
		sendSNSMsg:function(option){
			alert("sendSNSMsg");
		},
		blind:function(){
			alert("blind");
		},
		moveCenter:function(){
			this.css("top", ( $(window).height() - this.height() ) / 2+$(window).scrollTop() + "px");
			this.css("left", ( $(window).width() - this.width() ) / 2+$(window).scrollLeft() + "px");
			return this;
		},
		showTime:function(){
			/*
			//서버 설정시간을 표시한다.
			$.tv.svrTm = Date.parse($.tv.svrTm.toString("yyyy-MM-dd HH:mm:ss")).add({minutes:1});
			var AMPM="";
			
			if($.tv.svrTm.toString("HH")>12){
				AMPM ="pm";
			}else{
				AMPM ="am";
			}
			var hh = $.tv.svrTm.toString("hh");
			var mm = $.tv.svrTm.toString("mm");
			//alert(hh+","+mm);
			//alert(mm.substr(0,1));
			//alert(mm.substr(1,1));
			
			var html="<img src='"+$.tv.imageDomain+"/theme/tving_new/img/common/widget_"+AMPM+".png' alt='"+AMPM+"' class='dv' />\n"+
			"<img src='"+$.tv.imageDomain+"/theme/tving_new/img/common/widget_0"+hh.substr(0,1)+".png' alt='"+hh.substr(0,1)+"' />\n"+
			"<img src='"+$.tv.imageDomain+"/theme/tving_new/img/common/widget_0"+hh.substr(1,1)+".png' alt='"+hh.substr(1,1)+"' />\n"+
			"<img src='"+$.tv.imageDomain+"/theme/tving_new/img/common/widget_colon.png' alt=':' class='colon' />\n"+
			"<img src='"+$.tv.imageDomain+"/theme/tving_new/img/common/widget_0"+mm.substr(0,1)+".png' alt='"+mm.substr(0,1)+"' />\n"+
			"<img src='"+$.tv.imageDomain+"/theme/tving_new/img/common/widget_0"+mm.substr(1,1)+".png' alt='"+mm.substr(1,1)+"' />\n";
			
			$("#"+$.tv.svrDiv_id).html(html);
			*/
		},
		_setTimer:function(){
			//alert($.tv.svrTm	);
			//alert(2);
			/*
			$.tv.showTime();
			setInterval("$.tv.showTime()",60000);
			*/
			
		},
		getSvrTime:function(option){
			/*
			//서버 정보를 가져온다
			$.tv.svrDiv_id  = option.divId;
			
			//date.js 가 필요함
			var op = 
			{
				url:$.tv.context+"/sm/fh/FHGetServerTime.do",
				dataType:"text",
				success:function(text){
					var server_curtime = text.substr(text.indexOf("<server_curtime>")+16, 14);

					var config = {
						millisecond: 500, 
						second:		Number(server_curtime.substr(12,2)), 
						minute:		Number(server_curtime.substr(10,2)), 
						hour:		Number(server_curtime.substr(8,2)), 
						day:		Number(server_curtime.substr(6,2)), 
						month:		Number(server_curtime.substr(4,2)), 
						year:		Number(server_curtime.substr(0,4))
					};
					var _tm = (60-Number(server_curtime.substr(12,2)))+"000";
					$.tv.svrTm = Date.today().set(config).add({minutes:-1});
					//한번만 실행ㅎ
					setTimeout("$.tv.impl._setTimer();", _tm);
					$.tv.showTime();
					//setInterval("$.tv.showTime()",60000);
				},
				error:function(){
					//에러시 컴퓨터 시간을 설정한다
					//showTime에서 1분+ 하기때문에 미리 1분 뺀다.
					$.tv.svrTm = Date.today().add({minutes:-1});
					$.tv.showTime();
					setInterval("$.tv.showTime()",60000);
				}
			}
						
			$.tv.getJson(op);
			*/
		},
		getJson:function(option){

			var default1 = {
					type : "post",
					url: null,
					dataType: "json",
					data : null,
					timeout: 5000,
					success : null,
					error : function(error){
						alert('접속지연이 발생했습니다. 몇분후에 다시 확인해주세요\n'+error);
					}
				};
				
				var opt = $.extend(default1, option);
				$.ajax({
					type: opt.type,
					url:  opt.url,
					dataType: opt.dataType,
					data: opt.data,
					success: opt.success,
					error: opt.error
				});
		}
	}
	
})(jQuery);


/**  * string String::cut(int len)  * 한글도 고려하여 길이 리턴  */   
String.prototype.cut = function(len) {         var str = this;         var s = 0;         for (var i=0; i<str.length; i++) {                 s += (str.charCodeAt(i) > 128) ? 2 : 1;                 if (s > len) return str.substring(0,i) + "...";         }         return str;  }  
/**  * bool String::bytes(void)  * 해당스트링의 바이트단위 길이를 리턴  */  
//String.prototype.bytes = function() {         var str = this;         var s = 0;         for (var i=0; i<str.length; i++) s += (str.charCodeAt(i) > 128) ? 2 : 1;         return s;  }   
// 사용 방법  text = "나는 대한민국 국민이다. 우리나라 만세";  alert(text.cut(5));  alert("length: " + text.length + " : bytes : " + text.bytes());   if (text.bytes() > 5) {         alert("내용이 너무 깁니다");  } else {         alert(bbb.bytes());  }//--></script> 