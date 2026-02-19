package com.jw.evo.dao;

import org.springframework.stereotype.Repository;

import com.jw.evo.mapper.UserMapper;
import com.jw.evo.vo.user.UserAccountVO;
import com.jw.evo.vo.user.UserAddressVO;
import com.jw.evo.vo.user.UserProfileVO;
import com.jw.evo.vo.user.UserRoleVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserDAO {

	private final UserMapper userMapper;

	public Long getNextUserNo() {
		return userMapper.getNextUserNo();
	}
	public Long findRoleNoByRoleName(String roleName) {
	    return userMapper.findRoleNoByRoleName(roleName);
	}

	public int insertUserAccount(UserAccountVO userAccountVO) {
		return userMapper.insertUserAccount(userAccountVO);
	}
	
	public int insertUserProfile(UserProfileVO userProfileVO) {
		return userMapper.insertUserProfile(userProfileVO);
	}
	
	public int insertUserAddress(UserAddressVO userAddressVO) {
		return userMapper.insertUserAddress(userAddressVO);
	}
	public int insertUserRole(UserRoleVO userRoleVO) {
		return userMapper.insertUserRole(userRoleVO);
	}
	public int updateLastLogin(String loginId) {
		return userMapper.updateLastLogin(loginId);
	}
}
