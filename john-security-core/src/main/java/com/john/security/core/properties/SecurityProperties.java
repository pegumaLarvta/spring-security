package com.john.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
* @author ���� john
* @version ����ʱ�䣺2019��4��17�� ����11:03:23
*/
@ConfigurationProperties(prefix = "john.security")
public class SecurityProperties {

	private BrowserProperties browser = new BrowserProperties();

	public BrowserProperties getBrowser() {
		return browser;
	}

	public void setBrowser(BrowserProperties browser) {
		this.browser = browser;
	}

	
	
}
