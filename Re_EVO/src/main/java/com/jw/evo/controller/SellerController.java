package com.jw.evo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jw.evo.dto.SellerRequestDTO;
import com.jw.evo.security.CustomUserDetails;
import com.jw.evo.service.SellerService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {

	private final SellerService sellerService;

	@GetMapping("/request")
	public String goSellerRequest() {
		return "seller/sellerRequest";
	}

	@PostMapping("/requestProc")
	public String sellerRequestProc(SellerRequestDTO sellerRequestDTO, Authentication authentication) {
		// 1. Authentication 객체에서 Principal을 꺼내 CustomUserDetails로 캐스팅
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		// 2. 회원 번호 추출
		Long userNo = userDetails.getUserNo();

		sellerService.requestSeller(sellerRequestDTO, userNo);
		return "redirect:/";

	}

}
