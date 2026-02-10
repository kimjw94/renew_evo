package com.jw.evo.vo.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserAddressVO {
	private Long addrNo;
	private Long userNO;
	private String addrType;
	private String addrBase;
	private String addrDetail;
	private String addrDefault;
	

}
