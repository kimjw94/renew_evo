<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="sellerRequest_Container">
		<div>판매자 등록 페이지</div>

		<form action="<c:url value='/seller/requestProc'/>" method="post"
			enctype="multipart/form-data">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<div>
				<label>상호명</label> <input type="text" name="businessName">
			</div>
			<div>
				<label>브랜드 로고</label> <input type="file" name="businessLogo">
			</div>
			<div>
				<label>사업자명</label> <input type="text" name="businessOwner">
			</div>
			<div>
				<label>사업자 번호</label> <input type="text" name="businessNumber">
			</div>
			<div>
				<label>연락처</label><input type="text" name="businessTelFirst"> - <input type="text" name="businessTelMiddle">
				- <input type="text" name="businessTelLast">
			</div>
			<div>
				<label>이메일</label> <input type="text" name="businessEmailId"> @ <select name="businessEmailDomain">
					<option>직접 입력</option>
					<option>naver.com</option>
					<option>gmail.com</option>
				</select>
			</div>

			<div>
				<input type=text id="zipcode" name="businessZipcode">
				<button type="button" onclick="findAddress_kakao()">주소 찾기</button>
				<input type=text id="address" name="businessAddress"> <input type="text" name="businessAddressDetail">
			</div>

		<button type="submit"> 판매자 등록 요청</button>

		</form>


	</div>

	<script 
		src="//t1.kakaocdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="<c:url value='/resources/js/daumAddress.js'/>"></script>


</body>
</html>