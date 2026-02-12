package com.jw.evo.vo.user;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UserAccountVO{
	private Long userNo;
	private String userLoginId;
	private String userPassword;
	private String userEnabled;
	private Date userLastLoginAt;
	private Date userCreatedAt;

}
