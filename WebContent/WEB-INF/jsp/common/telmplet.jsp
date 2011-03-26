<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><decorator:title default="관리자 사이트" /> :: 관리자사이트</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/theme.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
<%@ include file="/WEB-INF/jsp/common/include/cssNscript.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {

	});
	$(window).load(function() {
		$.tv.showLikePd("imgList");
	});
</script>
<decorator:head />

<script>
	var StyleFile = "theme" + document.cookie.charAt(6) + ".css";
	document
			.writeln('<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/' + StyleFile + '">');
</script>
<!--[if IE]>
<link rel="stylesheet" type="text/css" href="css/ie-sucks.css" />
<![endif]-->
<style type="text/css">
<!--
.contentTable td,th {
	border: 0px solid #e8e7e1;
}
-->
</style>
</head>

<body>
	<div id="container">
		<div id="header">
			<h2>My eCommerce Admin area</h2>
			<div id="topmenu">
				<ul>
					<li class="current"><a href="${pageContext.request.contextPath}/bd/ma/BDMA010Q.do">게시판관리</a>
					</li>
					<li><a href="${pageContext.request.contextPath}/us/ma/USMA010Q.do">사용자관리</a>
					</li>
					<li><a href="${pageContext.request.contextPath}/pr/ma/PRMA010Q.do">제품</a></li>
					<li><a href="${pageContext.request.contextPath}/pr/ca/PRCA010Q.do">제품 카테고리</a></li>
					<li><a href="${pageContext.request.contextPath}/co/ma/COMA010Q.do">코드관리</a></li>
					<li><a href="${pageContext.request.contextPath}/de/ma/DEMA010Q.do">주문관리</a></li>
				</ul>
			</div>
		</div>
		<div id="top-panel">
			<div id="panel">
				<ul>
					<li><a href="#adduser" class="useradd">Add user</a>
					</li>
					<li><a href="#" class="group">User groups</a>
					</li>
					<li><a href="#" class="search">Find user</a>
					</li>
					<li><a href="#" class="online">Users online</a>
					</li>
				</ul>
			</div>
		</div>
		<div id="wrapper">
			<div id="content">
				<decorator:body />
			</div>
			<div id="sidebar">
				<ul>
					<li><h3>
							<a href="#" class="house">Dashboard</a>
						</h3>
						<ul>
							<li><a href="#" class="report">Sales Report</a>
							</li>
							<li><a href="#" class="report_seo">SEO Report</a>
							</li>
							<li><a href="#" class="search">Search</a>
							</li>
						</ul></li>
					<li><h3>
							<a href="#" class="folder_table">Orders</a>
						</h3>
						<ul>
							<li><a href="#" class="addorder">New order</a>
							</li>
							<li><a href="#" class="shipping">Shipments</a>
							</li>
							<li><a href="#" class="invoices">Invoices</a>
							</li>
						</ul></li>
					<li><h3>
							<a href="#" class="manage">Manage</a>
						</h3>
						<ul>
							<li><a href="#" class="manage_page">Pages</a>
							</li>
							<li><a href="#" class="cart">Products</a>
							</li>
							<li><a href="#" class="folder">Product categories</a>
							</li>
							<li><a href="#" class="promotions">Promotions</a>
							</li>
						</ul></li>
					<li><h3>
							<a href="#" class="user">Users</a>
						</h3>
						<ul>
							<li><a href="#" class="useradd">Add user</a>
							</li>
							<li><a href="#" class="group">User groups</a>
							</li>
							<li><a href="#" class="search">Find user</a>
							</li>
							<li><a href="#" class="online">Users online</a>
							</li>
						</ul></li>
				</ul>
			</div>
		</div>
		<div id="footer">
			<div id="credits">
				Template by <a href="http://www.bloganje.com">Bloganje</a>
			</div>
			<div id="styleswitcher">
				<ul>
					<li><a
						href="javascript: document.cookie='theme='; window.location.reload();"
						title="Default" id="defswitch">d</a>
					</li>
					<li><a
						href="javascript: document.cookie='theme=1'; window.location.reload();"
						title="Blue" id="blueswitch">b</a>
					</li>
					<li><a
						href="javascript: document.cookie='theme=2'; window.location.reload();"
						title="Green" id="greenswitch">g</a>
					</li>
					<li><a
						href="javascript: document.cookie='theme=3'; window.location.reload();"
						title="Brown" id="brownswitch">b</a>
					</li>
					<li><a
						href="javascript: document.cookie='theme=4'; window.location.reload();"
						title="Mix" id="mixswitch">m</a>
					</li>
				</ul>
			</div>
			<br />

		</div>
	</div>
</body>
</html>