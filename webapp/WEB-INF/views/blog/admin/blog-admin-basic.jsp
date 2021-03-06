﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="/jblog/assets/css/jblog.css">
</head>
<body>

	<div id="container">

		<!-- 블로그 해더 -->
			<c:import url="/WEB-INF/views/includes/blogheader.jsp"></c:import>
		<!-- /블로그 해더 -->


		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li class="selected"><a href="${pageContext.request.contextPath }/${sessionUser.id }/blog/adminBasic">기본설정</a></li>
					<li><a href="${pageContext.request.contextPath }/${sessionUser.id }/blog/adminCategory">카테고리</a></li>
					<li><a href="">글작성</a></li>
				</ul>

				<form action="${pageContext.request.contextPath }/${sessionUser.id }/blog/blogUpdate" method="post" enctype="multipart/form-data">
					<table class="admin-config">
						<tr>
							<td class="t">블로그 제목</td>
							<td><input type="text" size="40" name="blogTitle"></td>
						</tr>
						<tr>
							<td class="t">로고이미지</td>
							<td><img src="${pageContext.request.contextPath }/upload/${blogVo.blogFile}"></td>
						</tr>
						<tr>
							<td class="t">&nbsp;</td>
							<td><input type="file" name="blogFile"></td>
						</tr>
						<tr>
							<td class="t">&nbsp;</td>
							<td class="s"><input type="submit" value="기본설정 변경"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

		<!-- 푸터 -->
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2018
			</p>
		</div>
		<!-- 푸터 -->

	</div>
</body>
</html>