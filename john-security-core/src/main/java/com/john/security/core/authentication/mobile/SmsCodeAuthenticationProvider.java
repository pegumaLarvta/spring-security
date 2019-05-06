package com.john.security.core.authentication.mobile;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
* @author 作者 john
* @version 创建时间：2019年5月6日 下午10:52:41
*/
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {
	
	private UserDetailsService userDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		SmsCodeAuthenticationToken authenticationToken = (SmsCodeAuthenticationToken)authentication;
		UserDetails user = userDetailsService.loadUserByUsername((String) authenticationToken.getPrincipal());
		
		if (user == null) {
			throw new InternalAuthenticationServiceException("无法获取用户信息");
		}
		
		SmsCodeAuthenticationToken authenticationresult = new SmsCodeAuthenticationToken(user,user.getAuthorities());
		
		authenticationresult.setDetails(authenticationToken.getDetails());
		
		return authenticationresult;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
	}

	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	

}
