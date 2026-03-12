package com.jw.evo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jw.evo.vo.seller.SellerRequestVO;

@Mapper
public interface AdminMapper {
	List<SellerRequestVO> getSellerRequestListAll(@Param("start") int start, @Param("end") int end);

	List<SellerRequestVO> getSellerRequestListByStatus(@Param("status") String status, @Param("start") int start,
			@Param("end") int end);

	int countSellerRequestAll();

	int countSellerRequestByStatus(@Param("status") String status);

	int updateSellerApprove(@Param("sellerReqNo") Long sellerReqNo);

	int updateSellerReject(@Param("sellerReqNo") Long sellerReqNo, @Param("rejectReason") String rejectReason);
}
