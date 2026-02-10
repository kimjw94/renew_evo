package com.jw.evo.vo.user;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserProfileVO {
	private Long userNo;
	private String userName;
	private String userEmail;
	private String userGender;
	private String userNickname;
	private String userPhone;
	private Date userCreatedAt;
	

}
