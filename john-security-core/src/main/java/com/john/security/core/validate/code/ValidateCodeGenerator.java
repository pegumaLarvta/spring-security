package com.john.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
* @author ���� john
* @version ����ʱ�䣺2019��4��29�� ����10:46:40
*/
public interface ValidateCodeGenerator {
	
	ValidateCode generate(ServletWebRequest request);

}
