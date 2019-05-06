package com.john.security.core.properties;

/**
* @author 作者 john
* @version 创建时间：2019年5月6日 下午5:02:32
*/
public class SmsCodeProperties {
	
	private int length = 6;
	private int expireIn = 60;
	private String url;
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public int getExpireIn() {
		return expireIn;
	}
	
	public void setExpireIn(int expireIn) {
		this.expireIn = expireIn;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
