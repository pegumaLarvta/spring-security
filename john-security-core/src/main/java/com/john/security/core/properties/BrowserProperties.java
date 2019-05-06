package com.john.security.core.properties;

/**
* @author ���� john
* @version ����ʱ�䣺2019��4��17�� ����11:04:11
*/
public class BrowserProperties {
	
	private String loginPage = "/john-signIn.html";
	
	private LoginType loginType = LoginType.JSON;
	
	private int rememberMeSeconds = 3600;

	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	public LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}

	public int getRememberMeSeconds() {
		return rememberMeSeconds;
	}

	public void setRememberMeSeconds(int rememberMeSeconds) {
		this.rememberMeSeconds = rememberMeSeconds;
	}
	
	

}
