package com.john.security.core.validate.code.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import com.john.security.core.validate.code.ValidateCode;
import com.john.security.core.validate.code.ValidateCodeGenerator;
import com.john.security.core.validate.code.ValidateCodeProcessor;

/**
* @author ���� john
* @version ����ʱ�䣺2019��5��6�� ����5:20:12
*/
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {
	
	//����session�Ĺ�����
	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	
	//�ռ�ϵͳ�����е�  ValidateCodeGenerator  �ӿڵ�ʵ��
	@Autowired
	private Map<String, ValidateCodeGenerator> validateCodeGenerators;

	@Override
	public void create(ServletWebRequest request) throws Exception {
		C validateCode = generate(request);
		save(request, validateCode);
		send(request, validateCode);
	}
	
	/**
	 * ����У����
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private C generate(ServletWebRequest request) {
		String type = getProcessorType(request);
		ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(type + "CodeGenerator");
		return (C) validateCodeGenerator.generate(request);
	}
	
	/**
	 * ������֤��
	 * @param request
	 * @param validateCode
	 */
	private void save(ServletWebRequest request, C validateCode) {
		sessionStrategy.setAttribute(request, SESSION_KEY_PREFIX + StringUtils.upperCase(getProcessorType(request)), validateCode);
	}
	
	/**
	 * ������֤�룬������ʵ��
	 * @param request
	 * @param validateCode
	 * @throws Exception
	 */
	protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;
	
	/**
	 * ���������url��ȡУ���������
	 * @param request
	 * @return
	 */
	private String getProcessorType(ServletWebRequest request) {
		return StringUtils.substringAfter(request.getRequest().getRequestURI(), "/code/");
	}

}
