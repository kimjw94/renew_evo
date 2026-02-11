package com.jw.evo.mapper;

import com.jw.evo.vo.user.UserAccountVO;
import com.jw.evo.vo.user.UserAddressVO;
import com.jw.evo.vo.user.UserProfileVO;
import com.jw.evo.vo.user.UserRoleVO;

public interface UserMapper {
	Long getNextUserNo();
	Long findRoleNoByRoleName(String roleName);
	int insertUserAccount(UserAccountVO userAccountVO);
	int insertUserProfile(UserProfileVO userProfileVO);
	int insertUserAddress(UserAddressVO userAddressVO);
	int insertUserRole(UserRoleVO userRoleVO);
}
