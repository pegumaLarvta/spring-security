package com.john.security.browser;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
* 
* @author john
* @version 创建时间：2019年4月17日 下午5:42:54
*/
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
//		http.httpBasic()
			.and()
			.authorizeRequests()
			.anyRequest()
			.authenticated();
	}
	
}
