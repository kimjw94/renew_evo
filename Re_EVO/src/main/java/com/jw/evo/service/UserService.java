package com.jw.evo.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jw.evo.dao.UserDAO;
import com.jw.evo.dto.UserSignupDTO;
import com.jw.evo.enums.AddressType;
import com.jw.evo.vo.user.UserAccountVO;
import com.jw.evo.vo.user.UserAddressVO;
import com.jw.evo.vo.user.UserProfileVO;
import com.jw.evo.vo.user.UserRoleVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserDAO userDAO;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	
	//회원가입
	@Transactional
	public void signupProc(UserSignupDTO userSignupDTO) {
		// 시퀀스로 User_no 생성
		Long userNo = userDAO.getNextUserNo();

		// 비밀번호 암호화
		String encodedPw = bCryptPasswordEncoder.encode(userSignupDTO.getUserPassword());

		// UserAccountVO에 넣기
		UserAccountVO userAccount = new UserAccountVO();
		userAccount.setUserNo(userNo);
		userAccount.setUserLoginId(userSignupDTO.getUserLoginId());
		userAccount.setUserPassword(encodedPw);
	
		userDAO.insertUserAccount(userAccount);

		// UserProfileVO에 넣기
		UserProfileVO userProfile = new UserProfileVO();
		userProfile.setUserNo(userNo);
		userProfile.setUserName(userSignupDTO.getUserName());
		
		String userBirthdayStr = userSignupDTO.getUserBirthday();
		if(userBirthdayStr != null && !userBirthdayStr.isEmpty()) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				Date userBirthdayDate = sdf.parse(userBirthdayStr);
				
				userProfile.setUserBirthday(userBirthdayDate);
								
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}

		String Email = userSignupDTO.getUserEmailId() + "@" + userSignupDTO.getUserEmailDomain();
		userProfile.setUserEmail(Email);

		userProfile.setUserGender(userSignupDTO.getUserGender());
		userProfile.setUserNickname(userSignupDTO.getUserNickname());

		String Phone = userSignupDTO.getUserPhoneFirst() + "-" + userSignupDTO.getUserPhoneMiddle() + "-"
				+ userSignupDTO.getUserPhoneLast();

		userProfile.setUserPhone(Phone);

		userDAO.insertUserProfile(userProfile);

		// UserAddressVO에 넣기
		UserAddressVO userAddress = new UserAddressVO();
		userAddress.setUserNo(userNo);
		userAddress.setAddrType(AddressType.HOME);
		userAddress.setAddrZipcode(userSignupDTO.getUserZipcode());
		userAddress.setAddrBase(userSignupDTO.getUserAddress());
		userAddress.setAddrDetail(userSignupDTO.getUserAddressDetail());
		userAddress.setAddrDefault("Y");

		userDAO.insertUserAddress(userAddress);

		// Role 기초 설정 위해 role 가져오기
		Long roleNo = userDAO.findRoleNoByRoleName("ROLE_USER");
		
		UserRoleVO userRole = new UserRoleVO();
		userRole.setUserNo(userNo);
		userRole.setRoleNo(roleNo);

		userDAO.insertUserRole(userRole);

	}
	//회원가입
	@Transactional
	public void updateLastLogin(String loginId) {
		userDAO.updateLastLogin(loginId);
		
	}


}
