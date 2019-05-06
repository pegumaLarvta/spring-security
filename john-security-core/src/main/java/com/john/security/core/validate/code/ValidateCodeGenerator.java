package com.john.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
* @author 作者 john
* @version 创建时间：2019年4月29日 下午10:46:40
*/
public interface ValidateCodeGenerator {
	
	ValidateCode generate(ServletWebRequest request);

}
