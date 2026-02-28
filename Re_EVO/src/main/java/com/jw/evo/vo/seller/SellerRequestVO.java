package com.jw.evo.vo.seller;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SellerRequestVO {
	private Long sellerReqNo;
	private Long userNo;
	private String businessName;
	private String businessLogo;
	private String businessOwner;
	private String businessNumber;
	private String businessTel;
	private String businessEmail;


	private String businessZipcode;
	private String businessAddress;
	private String businessAddressDetail;

	private String requestStatus;
	private Date requestDate;
	
	private Date processedDate;
	private String rejectReason;

}
