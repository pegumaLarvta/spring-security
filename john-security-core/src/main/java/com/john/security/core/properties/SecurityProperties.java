package com.john.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
* @author 作者 john
* @version 创建时间：2019年4月17日 下午11:03:23
*/
@ConfigurationProperties(prefix = "john.security")
public class SecurityProperties {

	private BrowserProperties browser = new BrowserProperties();
	
	private ValidateCodeProperties code = new ValidateCodeProperties();
	
	private SocialProperties social = new SocialProperties();

	public BrowserProperties getBrowser() {
		return browser;
	}

	public void setBrowser(BrowserProperties browser) {
		this.browser = browser;
	}

	public ValidateCodeProperties getCode() {
		return code;
	}

	public void setCode(ValidateCodeProperties code) {
		this.code = code;
	}

	public SocialProperties getSocial() {
		return social;
	}

	public void setSocial(SocialProperties social) {
		this.social = social;
	}
	
	

}
