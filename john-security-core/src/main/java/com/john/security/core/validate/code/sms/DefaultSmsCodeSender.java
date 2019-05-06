package com.john.security.core.validate.code.sms;

/**
* @author 作者 john
* @version 创建时间：2019年5月6日 下午4:40:05
*/
public class DefaultSmsCodeSender implements SmsCodeSender {

	@Override
	public void send(String mobile, String code) {
		System.out.println("向手机" + mobile + "发送短信验证码" + code);
	}

}
