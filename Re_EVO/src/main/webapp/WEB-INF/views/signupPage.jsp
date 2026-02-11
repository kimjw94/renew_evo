<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/resources/css/font.css'/>">
<link rel="stylesheet"
	href="<c:url value='/resources/css/signupPage.css'/>">

</head>

<body>
	<div class="signup">

		<header class="signup__header">
			<h2 class="signup__title">회원가입</h2>
		</header>

		<div class="signup__contents">

			<div class="signup__logoBox">
				<div class="signup__logo">EVO</div>
				<div class="signup__phrase">Everything in one</div>
			</div>


			<form class="signup__form" action="/signupProc" method="post">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

				<!-- 아이디 -->
				<div class="signup__field">
					<label class="signup__label" for="loginId">아이디</label> <input
						class="signup__input" type="text" id="loginId" name="userLoginId">
					<button class="signup__button" type="button">중복 확인</button>
				</div>

				<!-- 비밀번호 -->
				<div class="signup__field">
					<label class="signup__label" for="password">비밀번호</label> <input
						class="signup__input" type="password" id="password"
						name="userPassword">
				</div>

				<!-- 비밀번호 확인 -->
				<div class="signup__field">
					<label class="signup__label" for="passwordConfirm">비밀번호 확인</label>
					<input class="signup__input" type="password" id="passwordConfirm"
						name="userPasswordConfirm">
				</div>

				<!-- 이름 -->
				<div class="signup__field">
					<label class="signup__label" for="userName">이름</label> <input
						class="signup__input" type="text" id="userName" name="userName">
				</div>

				<!-- 이메일 -->
				<div class="signup__field signup__field--email">
					<label class="signup__label">이메일</label> <input
						class="signup__input" type="text" name="userEmailId"> <span>@</span>
					<select class="signup__select" name="userEmailDomain">
						<option value="">직접 입력</option>
						<option value="naver.com">naver.com</option>
						<option value="gmail.com">gmail.com</option>
					</select>
				</div>

				<!-- 성별 -->
				<div class="signup__field signup__field--gender">
					<label class="signup__label">성별</label> <label><input
						type="radio" name="userGender" value="M"> 남성</label> <label><input
						type="radio" name="userGender" value="F"> 여성</label>
				</div>

				<!-- 닉네임 -->
				<div class="signup__field">
					<label class="signup__label" for="nickname">닉네임</label> <input
						class="signup__input" type="text" id="nickname"
						name="userNickname">
					<button class="signup__button" type="button">중복 확인</button>
				</div>

				<!-- 전화번호 -->
				<div class="signup__field signup__field--phone">
					<label class="signup__label">전화번호</label> <input
						class="signup__input signup__input--phone" type="text"
						name="userPhoneFirst"> - <input
						class="signup__input signup__input--phone" type="text"
						name="userPhoneMiddle"> - <input
						class="signup__input signup__input--phone" type="text"
						name="userPhoneLast">
				</div>



				<!-- kakao 주소 api 활용 통한 주소 -->
				<div class="signup__field signup__field--address">
					<label class="signup__label">주소</label>
					<div class="signup__addressWrapper">
						<!-- 첫 줄: 우편번호 + 버튼 -->
						<div class="signup__addressRow">
							<input type="text" id="zipcode" name="userZipcode" placeholder="우편번호"
								class="signup__input signup__input--zipcode">
							<button type="button" onclick="findAddress_kakao()"
								class="signup__button">주소 찾기</button>
						</div>

						<!-- 둘째 줄: 메인 주소 -->
						<div class="signup__addressRow">
							<input type="text" id="address" name="userAddress" placeholder="주소"
								class="signup__input signup__input--fullwidth">
						</div>

						<!-- 셋째 줄: 상세주소 + 타입 (8:2 비율) -->
						<div class="signup__addressRow">
							<input type="text" id="address_detail" name="userAddressDetail"
								placeholder="상세주소" class="signup__input signup__input--detail">
						</div>
					</div>
				</div>

				<button type="submit" class="signup__submit_button">회원 가입하기</button>
			</form>
		</div>
	</div>


	<script
		src="//t1.kakaocdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="<c:url value='/resources/js/daumAddress.js'/>"></script>



</body>
</html>