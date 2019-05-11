package com.john.security.core.validate.code.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import com.john.security.core.validate.code.ValidateCode;
import com.john.security.core.validate.code.ValidateCodeException;
import com.john.security.core.validate.code.ValidateCodeGenerator;
import com.john.security.core.validate.code.ValidateCodeProcessor;
import com.john.security.core.validate.code.ValidateCodeType;

/**
* @author ���� john
* @version ����ʱ�䣺2019��5��6�� ����5:20:12
*/
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {
	
	/**
	 * ����session�Ĺ�����
	 */
	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	/**
	 * �ռ�ϵͳ�����е� {@link ValidateCodeGenerator} �ӿڵ�ʵ�֡�
	 */
	@Autowired
	private Map<String, ValidateCodeGenerator> validateCodeGenerators;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imooc.security.core.validate.code.ValidateCodeProcessor#create(org.
	 * springframework.web.context.request.ServletWebRequest)
	 */
	@Override
	public void create(ServletWebRequest request) throws Exception {
		C validateCode = generate(request);
		save(request, validateCode);
		send(request, validateCode);
	}

	/**
	 * ����У����
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private C generate(ServletWebRequest request) {
		String type = getValidateCodeType(request).toString().toLowerCase();
		String generatorName = type + ValidateCodeGenerator.class.getSimpleName();
		ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(generatorName);
		if (validateCodeGenerator == null) {
			throw new ValidateCodeException("��֤��������" + generatorName + "������");
		}
		return (C) validateCodeGenerator.generate(request);
	}

	/**
	 * ����У����
	 * 
	 * @param request
	 * @param validateCode
	 */
	private void save(ServletWebRequest request, C validateCode) {
		sessionStrategy.setAttribute(request, getSessionKey(request), validateCode);
	}

	/**
	 * ������֤�����sessionʱ��key
	 * 
	 * @param request
	 * @return
	 */
	private String getSessionKey(ServletWebRequest request) {
		return SESSION_KEY_PREFIX + getValidateCodeType(request).toString().toUpperCase();
	}

	/**
	 * ����У���룬������ʵ��
	 * 
	 * @param request
	 * @param validateCode
	 * @throws Exception
	 */
	protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;

	/**
	 * ���������url��ȡУ���������
	 * 
	 * @param request
	 * @return
	 */
	private ValidateCodeType getValidateCodeType(ServletWebRequest request) {
		String type = StringUtils.substringBefore(getClass().getSimpleName(), "CodeProcessor");
		return ValidateCodeType.valueOf(type.toUpperCase());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void validate(ServletWebRequest request) {

		ValidateCodeType processorType = getValidateCodeType(request);
		String sessionKey = getSessionKey(request);

		C codeInSession = (C) sessionStrategy.getAttribute(request, sessionKey);

		String codeInRequest;
		try {
			codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(),
					processorType.getParamNameOnValidate());
		} catch (ServletRequestBindingException e) {
			throw new ValidateCodeException("��ȡ��֤���ֵʧ��");
		}

		if (StringUtils.isBlank(codeInRequest)) {
			throw new ValidateCodeException(processorType + "��֤���ֵ����Ϊ��");
		}

		if (codeInSession == null) {
			throw new ValidateCodeException(processorType + "��֤�벻����");
		}

		if (codeInSession.isExpried()) {
			sessionStrategy.removeAttribute(request, sessionKey);
			throw new ValidateCodeException(processorType + "��֤���ѹ���");
		}

		if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
			throw new ValidateCodeException(processorType + "��֤�벻ƥ��");
		}

		sessionStrategy.removeAttribute(request, sessionKey);
	}

}
