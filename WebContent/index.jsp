<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<script type="text/javascript" src="/tvingmanager/scripts/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="/tvingmanager/js/jquery.cookie.js"></script>
	<script type="text/javascript" src="/tvingmanager/js/jquery.hotkeys.js"></script>
	<script type="text/javascript" src="/tvingmanager/js/jquery.metadata.js"></script>
	<script type="text/javascript" src="/tvingmanager/js/sarissa.js"></script>
	<script type="text/javascript" src="/tvingmanager/js/hwtree.js"></script>
	<script type="text/javascript" src="/tvingmanager/js/jquery.tree.js"></script>
	<script type="text/javascript" src="/tvingmanager/plugins/jquery.tree.checkbox.js"></script>
	<script type="text/javascript" src="/tvingmanager/plugins/jquery.tree.contextmenu.js"></script>
	<script type="text/javascript" src="/tvingmanager/plugins/jquery.tree.cookie.js"></script>
	<script type="text/javascript" src="/tvingmanager/plugins/jquery.tree.hotkeys.js"></script>
	<script type="text/javascript" src="/tvingmanager/plugins/jquery.tree.metadata.js"></script>
	<script type="text/javascript" src="/tvingmanager/plugins/jquery.tree.themeroller.js"></script>
	<script type="text/javascript" src="/tvingmanager/plugins/jquery.tree.xml_flat.js"></script>
	<script type="text/javascript" src="/tvingmanager/plugins/jquery.tree.xml_nested.js"></script>

	<style type="text/css">
	html, body { margin:0; padding:0; }
	body, td, th, pre, code, select, option, input, textarea { font-family:"Trebuchet MS", Sans-serif; font-size:10pt; }
	#container { width:800px; margin:10px auto; overflow:hidden; }
	.demo { height:200px; width:300px; float:left; margin:0; border:1px solid gray; font-family:Verdana; font-size:10px; background:white; }
	.code { width:490px; float:right; margin:0 0 10px 0; border:1px solid gray; }
	pre { display:block; }
	.syntaxhighlighter { margin:0 0 0 0 !important; padding:0 !important; }
	</style>
<script type="text/JavaScript">

if('${param.msgCode}'!=''){

	var msg = "";
	if('${param.msgCode}'=='1'){
		msg='등록';
	}else if('${param.msgCode}'=='2'){
		msg='수정';
	}else if('${param.msgCode}'=='3'){
		msg='삭제';
	}
	if('${param.udtCnt}' =='' || '${param.udtCnt}' =='0'){
		msg +="실패";
	}
	alert(msg+"되었습니다");
}

</script>
<style type="text/css">
	#wrapper{width:900px;border:1px solid #eee; margin:20px auto;}
	#sub,#body,#sidebar{float:left;}
	#sub,#sidebar{width:150px;}
	#body{width:600px;height:450px;}
	#head{height:80px;background:#eee;}
	#foot{clear:both;height:30px;background:#eee;}
</style>

<body>


<div id="wrapper">
	
	

		<script type="text/javascript" class="source">

		$(function () { 
			$("#demo_1").tree({
				plugins : { 
					contextmenu : { }
				},
				callback:{
					onselect : function(NODE,TREE_OBJ){	getData($(NODE).attr("id"));return false;}
				}
			});
		});
		</script>
		<div class="demo" id="demo_1">
			<ul>
				<li id="phtml_1" class="open"><input name="value" type="hidden" value="{sId:'124',sNum:'',sNm:'ㅁㄴㅇㄹ',sState:'',sMenuNm:'124',sTitle:'',url:'ㅁㄴㅇ124',ssUrl:'',type:'ㄴㅇㄹ',eventNm:'',param:'124',desc:''}"/><a href="#"><ins>&nbsp;</ins>Root node 1</a>
					<ul>
						<li id="phtml_2"><a href="#"><ins>&nbsp;</ins>Child node 1</a><input name="value" type="hidden" value="{sId:'124',sNum:'',sNm:'ㅁㄴㅇㄹ',sState:'',sMenuNm:'124',sTitle:'',url:'ㅁㄴㅇ124',ssUrl:'',type:'ㄴㅇㄹ',eventNm:'',param:'124',desc:''}"/></li>
						<li id="phtml_3"><a href="#"><ins>&nbsp;</ins>Child node 2</a><input name="value" type="hidden" value="{sId:'124',sNum:'',sNm:'ㅁㄴㅇㄹ',sState:'',sMenuNm:'124',sTitle:'',url:'ㅁㄴㅇ124',ssUrl:'',type:'ㄴㅇㄹ',eventNm:'',param:'124',desc:''}"/></li>
						<li id="phtml_4"><a href="#"><ins>&nbsp;</ins>Some other child node with longer text</a><input name="value" type="hidden" value="{sId:'124',sNum:'',sNm:'ㅁㄴㅇㄹ',sState:'',sMenuNm:'124',sTitle:'',url:'ㅁㄴㅇ124',ssUrl:'',type:'ㄴㅇㄹ',eventNm:'',param:'124',desc:''}"/></li>
					</ul>
				</li>
				<li id="phtml_5"><a href="#"><ins>&nbsp;</ins>Root node 2</a><input name="value" type="hidden" value="{sId:'124',sNum:'',sNm:'ㅁㄴㅇㄹ',sState:'',sMenuNm:'124',sTitle:'',url:'ㅁㄴㅇ124',ssUrl:'',type:'ㄴㅇㄹ',eventNm:'',param:'124',desc:''}"/></li>
			</ul>
		</div>
	
		<div class="demo" id="demo_2" style="width: 500px;">
			서비스 아이디<input name="sId" id="sId" value="" type="text" />
			서비스 순서<input name="sNum" id="sNum" value="" type="text" />
			<br/>
			서비스명<input name="sNm" id="sNm" value="" type="text" />
			상태<input name="sState" id="sState" value="" type="text" />
			<br/>
			메뉴표시명<input name="sMenuNm" id="sMenuNm" value="" type="text" />
			타이틀명<input name="sTitle" id="sTitle" value="" type="text" />
			<br/>
			url<input name="url" id="url" value="" type="text" />
			서비스 suburl<input name="ssUrl" id="ssUrl" value="" type="text" />
			<br/>
			유형<input name="type" id="type" value="" type="text" />
			이벤트명<input name="eventNm" id="eventNm" value="" type="text" />
			<br/>
			파라미터<input name="param" id="param" value="" type="text" />
			설명<input name="desc" id="desc" value="" type="text" />
			<br/>
			<input type="button" onclick="save();" value="저장">
			<input type="button" onclick="cancel();" value="취소">
		</div>
	
	</div>
</div>
<script type="text/JavaScript">



</script>

</body>
</html>
