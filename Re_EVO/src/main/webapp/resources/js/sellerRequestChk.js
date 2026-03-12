const token = $("meta[name='_csrf']").attr("content");
const header = $("meta[name='_csrf_header']").attr("content");

function approveSeller(sellerReqNo) {
	if (!confirm("해당 요청을 승인하시겠습니까?")) return;

	$.ajax({
		url: contextPath + "/admin/approveSeller",
		type: "POST",
		data: { sellerReqNo: sellerReqNo },

		beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		},

		success: function(data) {
			if (data === "success") {
				alert("성공적으로 승인되었습니다.");
				location.reload();
			} else {
				alert("승인 처리에 실패했습니다. 이미 처리된 요청인지 확인해주세요.");
			}
		},

		error: function(xhr, status, error) {
			console.error("Status:", status, "Error:", error);
			alert("서버 통신 중 오류가 발생했습니다. 잠시 후 다시 시도해주세요.");
		}
	});
}

let currentRejectNo = null;

function rejectSeller(sellerReqNo) {
	currentRejectNo = sellerReqNo;
	openSellerRejectModal();
}

function openSellerRejectModal() {
	document.getElementById("rejectReason").value = "";
	document.getElementById("rejectModal").style.display = "block";
}

function closeSellerRejectModal() {
	document.getElementById("rejectModal").style.display = "none";
	currentRejectNo = null;
}

function submitReject() {

	const reason = document.getElementById("rejectReason").value.trim();

	if (!reason) {
		alert("거절 사유 입력해주세요.");
		return;
	}
	fetch(contextPath + "/admin/rejectSeller", {
		method: "POST",
		headers: {
			"Content-Type": "application/json",
			[header]: token
		},
		body: JSON.stringify({          // ✅ body 추가
            sellerReqNo: currentRejectNo,
            rejectReason: reason
        })
	})
 .then(res => res.text())
    .then(data => {
        if (data === "success") {
            alert("거절 처리가 완료되었습니다.");
            closeSellerRejectModal();
            location.reload();
        } else {
            alert("거절 처리에 실패했습니다.");
        }
    })
    .catch(error => {
        console.error("Error:", error);
        alert("서버 통신 중 오류가 발생했습니다.");
    });
}