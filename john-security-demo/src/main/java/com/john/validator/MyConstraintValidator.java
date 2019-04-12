package com.john.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.john.service.HelloService;

/**
* 
* @author john
* @version 创建时间：2019年4月11日 下午6:24:48
*/
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {
	
	@Autowired
	private HelloService helloService;

	@Override
	public void initialize(MyConstraint constraintAnnotation) {
		System.out.println("my validator init");
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		helloService.greeting("john");
		System.out.println(value);
		return false;
	}

}
