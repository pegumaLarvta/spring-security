package com.john.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
* @author ���� john
* @version ����ʱ�䣺2019��5��12�� ����2:56:10
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
