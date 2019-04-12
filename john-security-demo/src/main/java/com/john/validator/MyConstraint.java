package com.john.validator;
/**
* 
* @author john
* @version 创建时间：2019年4月11日 下午6:06:31
*/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD})//应用在方法和字段上
@Retention(RetentionPolicy.RUNTIME)//运行时执行
@Constraint(validatedBy = MyConstraintValidator.class)//由那个类来执行这个注解的逻辑
public @interface MyConstraint {
	
	String message()  ;

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
