package com.john.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * У���봦��������װ��ͬУ����Ĵ����߼�
* @author ���� john
* @version ����ʱ�䣺2019��5��6�� ����5:13:39
*/
public interface ValidateCodeProcessor {
	
	//��֤�����sessionʱ��ǰ׺
	String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";
	
	/**
	 * ����У����
	 * @param request
	 * @throws Exception
	 */
	void create(ServletWebRequest request) throws Exception;
	
	/**
	 * У����֤��
	 * 
	 * @param servletWebRequest
	 * @throws Exception
	 */
	void validate(ServletWebRequest servletWebRequest);

}
