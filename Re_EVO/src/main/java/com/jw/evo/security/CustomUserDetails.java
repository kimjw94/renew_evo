package com.jw.evo.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jw.evo.vo.security.UserSecurityVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private final UserSecurityVO user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return user.getRoleList().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return user.getUserPassword();
	}

	@Override
	public String getUsername() {
		// springsecurity 는 username 을 loginid 로 인식하지만
		// db에서는 userLoginId를 로그인아이디 userName을 유저 이름으로 설정했음을 인지 필요
		return user.getUserLoginId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return "Y".equals(user.getUserEnabled());
	}

}