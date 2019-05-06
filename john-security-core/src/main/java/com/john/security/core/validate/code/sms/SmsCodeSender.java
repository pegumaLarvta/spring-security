package com.john.security.core.validate.code.sms;

/**
* @author 作者 john
* @version 创建时间：2019年5月6日 下午4:37:14
*/
public interface SmsCodeSender {
	
	void send(String mobile, String code);

}
