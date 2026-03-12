package com.jw.evo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jw.evo.mapper.AdminMapper;
import com.jw.evo.vo.seller.SellerRequestVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AdminDAO {
	
	private final AdminMapper adminMapper;
	
	 public List<SellerRequestVO> getSellerRequestListAll(int start,int end){
		 return adminMapper.getSellerRequestListAll(start,end);
		 
	 }
	 public List<SellerRequestVO> getSellerRequestByStatus(String status,int start,int end){
		 return adminMapper.getSellerRequestListByStatus(status,start,end);
	 }
	 
	 public int countSellerRequestAll() {
		 return adminMapper.countSellerRequestAll();
	 }
	 public int countSellerRequestByStatus(String status) {
		 return adminMapper.countSellerRequestByStatus(status);
	 }
	
	public int updateSellerApprove(Long sellerReqNo) {
		return adminMapper.updateSellerApprove(sellerReqNo);
	}
	
	public int updateSellerReject(Long sellerReqNo, String rejectReason) {
		return adminMapper.updateSellerReject(sellerReqNo,rejectReason);
	}
		

}
