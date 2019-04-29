package com.john.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.john.security.core.properties.SecurityProperties;

/**
* 
* @author john
* @version 创建时间：2019年4月17日 下午5:42:54
*/
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SecurityProperties securityProperties;
	
	@Autowired
	private AuthenticationSuccessHandler johnAuthenticationSuccessHandler;
	@Autowired
	private AuthenticationFailureHandler johnAuthenticationFaliureHandler;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()//表单登录
			.loginPage("/authentication/require")//定义登录页面
			.loginProcessingUrl("/authentication/form")//当发起这个请求时调用security的过滤器进行处理
			.successHandler(johnAuthenticationSuccessHandler)//表单登录成功后用自己配置的处理器进行处理
			.failureHandler(johnAuthenticationFaliureHandler)//表单登录失败后用自己配置的处理器进行处理
//		http.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers("/authentication/require",
					securityProperties.getBrowser().getLoginPage()).permitAll()//这些页面不需要身份认证
			.anyRequest()//访问其他的都需要身份认证
			.authenticated()
			.and()
			.csrf().disable();
	}
	
}
