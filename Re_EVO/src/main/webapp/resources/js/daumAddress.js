
function findAddress_kakao() {
	new kakao.Postcode({
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
			// 예제를 참고하여 다양한 활용법을 확인해 보세요.
			var addr = '';
			var extraAddr = '';

			if (data.userSelectedType === 'R') {
				addr = data.roadAddress;
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				if (extraAddr !== '') {
					addr += ' (' + extraAddr + ')';  // 괄호로 추가
				}


			} else {
				addr = data.jibunAddress;
			}
			document.getElementById("zipcode").value = data.zonecode;
			document.getElementById("address").value = addr;

		}
	}).open();
}