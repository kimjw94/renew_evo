package com.jw.evo.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.jw.evo.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private final UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {

		// 로그인 시 해당 아이디
		String loginId = authentication.getName();
		userService.updateLastLogin(loginId);// TODO Auto-generated method stub

		boolean isAdmin = authentication.getAuthorities().stream()
				.anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));

		if (isAdmin) {
			getRedirectStrategy().sendRedirect(request, response, "/admin/main");
			return;
		}

		super.onAuthenticationSuccess(request, response, authentication);
	}

}
