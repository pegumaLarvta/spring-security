package com.john.security.core.properties;

/**
* @author 作者 john
* @version 创建时间：2019年4月29日 下午10:06:44
*/
public class ValidateCodeProperties {

	private ImageCodeProperties image = new ImageCodeProperties();
	
	private SmsCodeProperties sms = new SmsCodeProperties();

	public ImageCodeProperties getImage() {
		return image;
	}

	public void setImage(ImageCodeProperties image) {
		this.image = image;
	}

	public SmsCodeProperties getSms() {
		return sms;
	}

	public void setSms(SmsCodeProperties sms) {
		this.sms = sms;
	}
	
	
	
}
