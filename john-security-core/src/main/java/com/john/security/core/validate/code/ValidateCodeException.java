package com.john.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
* @author ���� john
* @version ����ʱ�䣺2019��4��29�� ����9:24:34
*/
public class ValidateCodeException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6059285400824929219L;

	public ValidateCodeException(String msg) {
		super(msg);
	}

}
