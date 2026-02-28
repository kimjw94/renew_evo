package com.jw.evo.dao;

import org.springframework.stereotype.Repository;

import com.jw.evo.mapper.SellerMapper;
import com.jw.evo.vo.seller.SellerRequestVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SellerDAO {
	
	private final SellerMapper sellerMapper;
	
	public int insertSellerRequest(SellerRequestVO sellerRequestVO) {
		return sellerMapper.insertSellerRequest(sellerRequestVO);
	}

}
