package com.john.security.core.validate.code.sms;

/**
* @author ���� john
* @version ����ʱ�䣺2019��5��6�� ����4:40:05
*/
public class DefaultSmsCodeSender implements SmsCodeSender {

	@Override
	public void send(String mobile, String code) {
		System.out.println("���ֻ�" + mobile + "���Ͷ�����֤��" + code);
	}

}
