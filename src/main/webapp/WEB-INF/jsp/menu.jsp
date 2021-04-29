<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8"%>
<nav class="navbar navbar-expand  navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="/welcome.do">Home</a>
		</div>
	</div>
	<div>
		<ul class="navbar-nav mr-auto">
			<li style="padding-top:7px; color:white">${sessionId}님 환영합니다.</li>
			<li class="nav-item"><a class="nav-link" href='<c:url value="/member/loginMember.do"/>'>로그인</a></li>
			<li class="nav-item"><a class="nav-link" href='<c:url value="/member/addMember.do"/>'>회원 가입</a></li>
			<%--<li class="nav-item">${sessionId}</li>--%>
		</ul>
	</div>
</nav>
