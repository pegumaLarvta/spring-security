package com.john.security.core.validate.code.sms;

/**
* @author ���� john
* @version ����ʱ�䣺2019��5��6�� ����4:37:14
*/
public interface SmsCodeSender {
	
	void send(String mobile, String code);

}
