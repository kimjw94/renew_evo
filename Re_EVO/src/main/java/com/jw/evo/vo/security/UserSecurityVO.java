package com.jw.evo.vo.security;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UserSecurityVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long userNo;
	private String userLoginId;
	private String userPassword;
	private String userEnabled;
	private Date userLastLoginAt;
	
	private String userName;
	private String userNickname;
	
	private List<String> roleList;
}
