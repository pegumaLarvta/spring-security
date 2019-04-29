package com.john.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
* @author 作者 john
* @version 创建时间：2019年4月29日 下午9:24:34
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
