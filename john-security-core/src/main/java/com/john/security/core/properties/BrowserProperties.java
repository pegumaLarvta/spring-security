package com.john.security.core.properties;

/**
* @author 作者 john
* @version 创建时间：2019年4月17日 下午11:04:11
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
