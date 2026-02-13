package com.jw.evo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jw.evo.mapper.UserMapper;
import com.jw.evo.vo.security.UserSecurityVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	
private final UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	 UserSecurityVO user = userMapper.selectUserByLoginId(username);
	 
	 if (user == null) {
         throw new UsernameNotFoundException("해당 아이디의 사용자를 찾을 수 없습니다:" + username);
     }
	 return new CustomUserDetails(user);
	}

}
