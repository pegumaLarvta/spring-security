package com.john.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
* @author 作者 john
* @version 创建时间：2019年5月12日 下午3:44:55
*/
public class JohnSpringSocialConfigurer extends SpringSocialConfigurer {
	
	private String filterProcessesUrl;
	
	public JohnSpringSocialConfigurer(String filterProcessesUrl) {
		this.filterProcessesUrl = filterProcessesUrl;
	}

	@Override
	protected <T> T postProcess(T object) {
		SocialAuthenticationFilter filter = (SocialAuthenticationFilter)super.postProcess(object);
		filter.setFilterProcessesUrl(filterProcessesUrl);
		return (T)filter;
	}

}
