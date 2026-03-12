package com.jw.evo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jw.evo.dto.PageDTO;
import com.jw.evo.dto.RejectRequestDTO;
import com.jw.evo.service.AdminService;
import com.jw.evo.vo.seller.SellerRequestVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

	private final AdminService adminService;

	@GetMapping("/main")
	public String goAdminMain(Model model) {
		model.addAttribute("cp", "adminMain.jsp");
		return "admin/adminIndex";
	}

	@GetMapping("/requestSellerChk")
	public String goRequestSellerChk(@RequestParam(defaultValue = "all") String status,
			@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int amount, Model model) {
		// 1. 해당 조건(status)에 맞는 전체 데이터 개수 조회 (페이징 계산의 핵심)
		int total = adminService.getSellerRequestTotalCount(status);

		// 2. 페이징 처리된 목록 조회
		List<SellerRequestVO> requestList = adminService.getSellerRequestList(status, page, amount);

		// 3. PageDTO 생성
		PageDTO pageDTO = new PageDTO(page, amount, total);

		model.addAttribute("list", requestList);
		model.addAttribute("pageMaker", pageDTO); // JSP에서 사용
		model.addAttribute("status", status); // 현재 선택된 필터 유지용
		model.addAttribute("cp", "adminRequestSellerChk.jsp");

		return "admin/adminIndex";

	}

	@PostMapping("/approveSeller")
	@ResponseBody
	public String approveSeller(@RequestParam Long sellerReqNo) {
		boolean result = adminService.approveSeller(sellerReqNo);
	    return result ? "success" : "error";
	}
	
	@PostMapping("/rejectSeller")
	@ResponseBody
	public String rejectSeller(@RequestBody RejectRequestDTO rejectRequestDTO) {
		adminService.rejectSeller(rejectRequestDTO.getSellerReqNo(), rejectRequestDTO.getRejectReason());
		return "success";
	}

}
