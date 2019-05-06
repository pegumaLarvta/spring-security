package com.john.security.core.validate.code.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import com.john.security.core.validate.code.ValidateCode;
import com.john.security.core.validate.code.impl.AbstractValidateCodeProcessor;

/**
* @author ���� john
* @version ����ʱ�䣺2019��5��6�� ����6:19:35
*/
@Component("smsCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {
	
	/**
	 * ������֤�뷢����
	 */
	@Autowired
	private SmsCodeSender smsCodeSender;

	@Override
	protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
		String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), "mobile");
		smsCodeSender.send(mobile, validateCode.getCode());
		
	}

}
