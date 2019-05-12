package com.john.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
* @author 作者 john
* @version 创建时间：2019年5月12日 下午2:56:10
*/
public class QQProperties extends SocialProperties {
	
	private String providerId = "qq";

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	
	

}
