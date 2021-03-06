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
			<c:choose>
				<c:when test="${empty sessionId}">
					<li class="nav-item"><a class="nav-link" href='<c:url value="/member/loginMember.do"/>'>로그인</a></li>
					<li class="nav-item"><a class="nav-link" href='<c:url value="/member/addMember.do"/>'>회원 가입</a></li>
				</c:when>
				<c:otherwise>
					<li style="padding-top:7px; color:white">${sessionId}님 환영합니다.</li>
					<li class="nav-item"><a class="nav-link" href='<c:url value="/member/logoutMember.do"/>'>로그아웃</a></li>
					<li class="nav-item"><a class="nav-link" href='<c:url value="/member/updateMember.do"/>'>회원 수정</a></li>
				</c:otherwise>
			</c:choose>
			<li class="nav-item"><a class="nav-link" href="<c:url value="/products.do"/>">상품 목록</a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value="/addProduct.do"/>">상품 등록</a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value="/editProduct.do?edit=update"/>">상품 수정</a></li>
<%--			<li class="nav-item"><a class="nav-link" href="<c:url value="/editProduct.do?edit=delete"/>">상품 삭제</a></li>--%>
		</ul>
	</div>
</nav>
