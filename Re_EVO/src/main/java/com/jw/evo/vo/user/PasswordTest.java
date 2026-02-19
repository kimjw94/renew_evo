package com.jw.evo.vo.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "admin1234";
		String encodedPassword = encoder.encode(rawPassword);
		System.out.println(encodedPassword);

	}

}
