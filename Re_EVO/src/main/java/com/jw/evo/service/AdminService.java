package com.jw.evo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jw.evo.dao.AdminDAO;
import com.jw.evo.vo.seller.SellerRequestVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {
	private final AdminDAO adminDAO;

	@Transactional
	public List<SellerRequestVO> getSellerRequestList(String status, int page, int amount) {
		// 페이징 처리
		int start = (page - 1) * amount + 1;
		int end = page * amount;

		if ("all".equals(status)) {
			return adminDAO.getSellerRequestListAll(start, end);

		} else {
			return adminDAO.getSellerRequestByStatus(status, start, end);

		}

	}

	@Transactional
	public int getSellerRequestTotalCount(String status) {
		if ("all".equals(status)) {
			return adminDAO.countSellerRequestAll();
		} else {
			return adminDAO.countSellerRequestByStatus(status);
		}

	}

	@Transactional
	public boolean approveSeller(Long sellerReqNo) {
		int result = adminDAO.updateSellerApprove(sellerReqNo);
		if (result > 0) {
			return true;
		} else {
			return false;
		}

	}
	
	@Transactional
	public int rejectSeller(Long sellerReqNo,String rejectReason) {
		return adminDAO.updateSellerReject(sellerReqNo,rejectReason);
	}
}