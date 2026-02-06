<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header class="header">
	<div class="header-left">
		<a class="header-title" href="<c:url value='/'/>" >E V O</a>
	</div>

	<div class="header-right">
		<c:choose>
			<c:when test="${not empty loginUser }">
				<div>
					<a class="header-login" href="<c:url value='/myPage'/>">내 정보</a>
				</div>
			</c:when>
			<c:otherwise>
				<div>
					<a class="header-login" href="<c:url value='/login'/>">로 그 인</a>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

</header>
