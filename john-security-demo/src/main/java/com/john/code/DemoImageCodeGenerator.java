package com.john.code;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import com.john.security.core.validate.code.ImageCode;
import com.john.security.core.validate.code.ValidateCodeGenerator;

/**
* @author 作者 john
* @version 创建时间：2019年4月29日 下午11:01:51
*/
@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

	@Override
	public ImageCode generate(ServletWebRequest request) {
		System.out.println("更高级的图形验证码生成代码");
		return null;
	}

}
