<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<header class="header">
	<div class="header-left">
		<a class="header-title" href="<c:url value='/'/>">E V O</a>
	</div>

	<div class="header-right">
		<sec:authorize access="isAnonymous()">
			<div>
				<a class="header-login" href="<c:url value='/login'/>">로 그 인</a>
			</div>
		</sec:authorize>

		<!-- 2. 로그인 상태일 때 -->
		<sec:authorize access="isAuthenticated()">
			<div>

				<a class="header-login" href="<c:url value='/myPage'/>"> 
				<sec:authentication property="principal.username" /> 님 정보
				</a>
				<!-- 로그아웃은 보통 form으로 처리해야 하지만 편의상 링크로 둔다면 -->
				<a href="<c:url value='/logout'/>">로그아웃</a>
			</div>
		</sec:authorize>

	</div>

</header>
