package com.jw.evo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jw.evo.dao.SellerDAO;
import com.jw.evo.dto.SellerRequestDTO;
import com.jw.evo.vo.seller.SellerRequestVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SellerService {

	private final SellerDAO sellerDAO;
	private final FileUploadService fileUploadService;

	@Transactional
	public void requestSeller(SellerRequestDTO sellerRequestDTO, Long userNo) {

		SellerRequestVO sellerRequestVO = new SellerRequestVO();
		sellerRequestVO.setUserNo(userNo);

		sellerRequestVO.setBusinessName(sellerRequestDTO.getBusinessName());
		sellerRequestVO.setBusinessOwner(sellerRequestDTO.getBusinessOwner());
		sellerRequestVO.setBusinessNumber(sellerRequestDTO.getBusinessNumber());
		
		String businessTel = sellerRequestDTO.getBusinessTelFirst() + "-" + 
							sellerRequestDTO.getBusinessTelMiddle() +"-" +
							sellerRequestDTO.getBusinessTelLast();
		sellerRequestVO.setBusinessTel(businessTel);
		
		String businessEmail = sellerRequestDTO.getBusinessEmailId() + "@"+sellerRequestDTO.getBusinessEmailDomain();
		sellerRequestVO.setBusinessEmail(businessEmail);
		
		sellerRequestVO.setBusinessZipcode(sellerRequestDTO.getBusinessZipcode());
		sellerRequestVO.setBusinessAddress(sellerRequestDTO.getBusinessAddress());
		sellerRequestVO.setBusinessAddressDetail(sellerRequestDTO.getBusinessAddressDetail());

		// 로고 multipartFIle 이용
		String savedLogoName = fileUploadService.upload(sellerRequestDTO.getBusinessLogo(), "seller_logo");
		
		sellerRequestVO.setBusinessLogo(savedLogoName);
		
		sellerRequestVO.setRequestStatus("Request");
		
		sellerDAO.insertSellerRequest(sellerRequestVO);
	}

}
