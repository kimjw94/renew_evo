package com.jw.evo.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SellerRequestDTO {
	private String businessName;
	private MultipartFile businessLogo;
	private String businessOwner;
	private String businessNumber;
	
	private String businessTelFirst;
	private String businessTelMiddle;
	private String businessTelLast;
	
	private String businessEmailId;
	private String businessEmailDomain;
	
	private String businessZipcode;
	private String businessAddress;
	private String businessAddressDetail;
	
	
}
