package com.jw.evo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UserSignupDTO {
	private String userLoginId;
	private String userPassword;
	
	private String userName;
	
	private String userEmailId;
	private String userEmailDomain;
	
	private String userGender;
	
	private String userNickname;
	
	private String userPhoneFirst;
	private String userPhoneMiddle;
	private String userPhoneLast;
	
	private String userZipcode;
	private String userAddress;
	private String userAddressDetail;
}
