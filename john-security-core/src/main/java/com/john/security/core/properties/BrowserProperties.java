package com.john.security.core.properties;

/**
* @author ���� john
* @version ����ʱ�䣺2019��4��17�� ����11:04:11
*/
public class BrowserProperties {
	
	private String loginPage = "/john-signIn.html";
	
	private LoginType loginType = LoginType.JSON;

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
	
	

}
