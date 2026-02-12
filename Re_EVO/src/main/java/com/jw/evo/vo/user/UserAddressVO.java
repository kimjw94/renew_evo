package com.jw.evo.vo.user;

import com.jw.evo.enums.AddressType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserAddressVO {
	private Long addrNo;
	private Long userNo;
	private AddressType addrType;
	private String addrZipcode;
	private String addrBase;
	private String addrDetail;
	private String addrDefault;
	
}
