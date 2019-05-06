package com.john.security.core.validate.code.sms;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import com.john.security.core.properties.SecurityProperties;
import com.john.security.core.validate.code.ValidateCode;
import com.john.security.core.validate.code.ValidateCodeGenerator;

/**
* @author 作者 john
* @version 创建时间：2019年4月29日 下午10:48:51
*/
@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {
	
	@Autowired
	private SecurityProperties securityProperties;

	@Override
	public ValidateCode generate(ServletWebRequest request) {
		String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
		return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
	}

	public SecurityProperties getSecurityProperties() {
		return securityProperties;
	}

	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}

	
	
}
