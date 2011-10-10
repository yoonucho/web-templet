<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Playy</title>
	<meta name="author" content="" />
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<title>Playy</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/common/css/default.css" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/common/css/common.css" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/common/css/page.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/common/js/default.js"></script>

	<%@ include file="/WEB-INF/jsp/common/include/usr_cssNscript.jsp"%>
	<script type="text/javascript">
		$(document).ready(function() {
	
		});
		$(window).load(function() {
	
		});
	</script>
	<decorator:head />
</head>

<body id="mypage">
	<div id="wrap">		
		<div id="header"><img src="${pageContext.request.contextPath}/common/images/common/header.gif" alt="" /></div> <!-- end header -->
		
		<div id="container">
			<div class="content">
				
				<div class="mypage_tit01">
					<h3>눈깔사탕</h3>
					<span><a href="#">http://blog.naver.com/tjd960</a></span>
				</div> <!-- end mypage_tit01 -->

				<div class="my_info01">
					<div class="my_info_left">
						<div class="photo"><img src="${pageContext.request.contextPath}/common/images/mypage/photo01.gif" alt="" /></div>
						<div class="prod_info">
							<dl>
								<dt><img src="${pageContext.request.contextPath}/common/images/mypage/th01.gif" alt="이용상품" /></dt>
								<dd><strong>1개월 정액 <span class="normal">(~01/29 까지)</span></strong></dd>
							</dl>

							<dl>
								<dt><img src="${pageContext.request.contextPath}/common/images/mypage/th02.gif" alt="파란캐쉬" /></dt>
								<dd><strong>1,000원</strong><a href="#"><img src="${pageContext.request.contextPath}/common/images/common/btn/btn_cash01.gif" alt="캐쉬충전" class="btn" /></a></dd>
							</dl>
							<dl>
								<dt><img src="${pageContext.request.contextPath}/common/images/mypage/th03.gif" alt="찜 목록" /></dt>
								<dd><strong>3</strong> 편</dd>
							</dl>
							<dl>
								<dt><img src="${pageContext.request.contextPath}/common/images/mypage/th04.gif" alt="팬목록" /></dt>
								<dd><strong>5</strong> 편</dd>
							</dl>
						</div>

						<div class="info_comment">나는야 경기도 사는 인선이라네~~~ 방송, 기술, 엔지니어 사회 부적응자… (적응하며 사는 척 한다) 아마추어 목수, 아마추어 바리스타, 나는야 경기도 사는 인선이라네~~~ 방송, 기술, 엔지니어 사회 </div>

						<div class="more"><a href="#"><img src="${pageContext.request.contextPath}/common/images/mypage/icon_more01.gif" alt="more" /></a></div>
					</div>
					<div class="my_info_right">
						<p><img src="${pageContext.request.contextPath}/common/images/mypage/sstit01.gif" alt="좋아하는 장르" /></p>
						<ul class="info_like">
							<li>뮤직영화</li>
							<li>성장드라마</li>
							<li>메이드애니</li>
						</ul>

						<p><img src="${pageContext.request.contextPath}/common/images/mypage/sstit02.gif" alt="이용기기" /></p>
						<ul class="info_use"> 
							<li><span><img src="${pageContext.request.contextPath}/common/images/common/icon/ico_pc_on.gif" alt="pc" /></span> PC : 이용중</li>
							<li><span><img src="${pageContext.request.contextPath}/common/images/common/icon/ico_smart_phone_off.gif" alt="스마트폰" /></span> 스마트폰 : 미등록</li>
							<li><span><img src="${pageContext.request.contextPath}/common/images/common/icon/ico_smart_tv_off.gif" alt="스마트 TV" /></span> 스마트 TV : 미등록 <a href="#"><img src="${pageContext.request.contextPath}/common/images/common/btn/btn_use02.gif" alt="이용안내" class="btn" /></a></li>
						</ul>
					</div>
				</div> <!-- end my_info01 -->

				<decorator:body />

 
			</div><!-- content end -->

			<div class="side">
				<ul class="mypage_right_menu">
					<li><a href="#"><img src="${pageContext.request.contextPath}/common/images/mypage/right_menu01_off.gif" alt="My Playy 홈" /></a></li>
					<li><a href="#"><img src="${pageContext.request.contextPath}/common/images/mypage/right_menu02_off.gif" alt="이용/결제 내역" /></a></li>
					<li><a href="#"><img src="${pageContext.request.contextPath}/common/images/mypage/right_menu03_off.gif" alt="찜 목록" /></a></li>
					<li><a href="#"><img src="${pageContext.request.contextPath}/common/images/mypage/right_menu04_off.gif" alt="팬 목록" /></a></li>
					<li><a href="#"><img src="${pageContext.request.contextPath}/common/images/mypage/right_menu05_on.gif" alt="프로파일 관리" /></a></li>
					<li><a href="${pageContext.request.contextPath}/cm/ma/CMMA010Q.do">로그인</a></li>
					<li><a href="${pageContext.request.contextPath}/usr/bd/ma/BDMA010Q.do">게시판</a></li>
					<li><a href="${pageContext.request.contextPath}/usr/pr/ma/PRMA010Q.do">제품</a></li>
					<li><a href="${pageContext.request.contextPath}/cm/ma/CMMA030Q.do">우편번호</a></li>
					<li><a href="${pageContext.request.contextPath}/cm/ma/CMMA030Q.do">배송조회</a></li>
					<li><a href="${pageContext.request.contextPath}/cm/ma/CMMA030Q.do">구매목록조회</a></li>
				</ul>
				<div class="btn_apply"><a href="#"><img src="${pageContext.request.contextPath}/common/images/mypage/btn_aapply01.gif" alt="월정액 신청하기" /></a></div>
				
			</div><!-- side end-->
			
		</div><!-- container end -->

		<!-- footer -->
		<div id="footer">
			<h2><a href="#"><img src="${pageContext.request.contextPath}/common/images/common/footer/logo.gif" alt="" /></a></h2>
			<div class="company">
				<ul>
					<li><a href="#"><img src="${pageContext.request.contextPath}/common/images/common/footer/link01.gif" alt="회사소개" /></a></li>
					<li><a href="#"><img src="${pageContext.request.contextPath}/common/images/common/footer/link02.gif" alt="이용약관" /></a></li>
					<li><a href="#"><img src="${pageContext.request.contextPath}/common/images/common/footer/link03.gif" alt="개인정보 취급방침" /></a></li>
					<li><a href="#"><img src="${pageContext.request.contextPath}/common/images/common/footer/link04.gif" alt="청소년보호정책" /></a></li>
					<li><a href="#"><img src="${pageContext.request.contextPath}/common/images/common/footer/link05.gif" alt="이메일무단수집거부" /></a></li>
					<li><a href="#"><img src="${pageContext.request.contextPath}/common/images/common/footer/link06.gif" alt="권리침해신고" /></a></li>
					<li><a href="#"><img src="${pageContext.request.contextPath}/common/images/common/footer/link07.gif" alt="고객센터" /></a></li>
					<li class="none"><a href="#"><img src="${pageContext.request.contextPath}/common/images/common/footer/link08.gif" alt="공지사항" /></a></li>
				</ul>
				<address><img src="${pageContext.request.contextPath}/common/images/common/footer/address.gif" alt="" /></address>
				<cite><img src="${pageContext.request.contextPath}/common/images/common/footer/copyright.gif" alt="" /></cite>
				<div class="paran"><a href="#"><img src="${pageContext.request.contextPath}/common/images/common/footer/paran.gif" alt="" /></a></div>
			</div><!-- company end-->
		</div><!-- footer end-->
	</div><!-- wrap end-->
</body>
</html>
