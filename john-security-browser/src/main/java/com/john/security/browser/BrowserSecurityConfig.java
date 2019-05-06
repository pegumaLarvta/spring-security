package com.john.security.browser;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.john.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.john.security.core.properties.SecurityProperties;
import com.john.security.core.validate.code.SmsCodeFilter;
import com.john.security.core.validate.code.ValidateCodeFilter;

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
	@Autowired
	private DataSource dataSource;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
	
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
//		tokenRepository.setCreateTableOnStartup(true);//启动时创建表
		return tokenRepository;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
		validateCodeFilter.setAuthenticationFailureHandler(johnAuthenticationFaliureHandler);
		validateCodeFilter.setSecurityProperties(securityProperties);
		validateCodeFilter.afterPropertiesSet();
		
		SmsCodeFilter smsCodeFilter = new SmsCodeFilter();
		smsCodeFilter.setAuthenticationFailureHandler(johnAuthenticationFaliureHandler);
		smsCodeFilter.setSecurityProperties(securityProperties);
		smsCodeFilter.afterPropertiesSet();
		
		http.addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class)
			.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)//在用户名密码前添加一个验证码过滤器
			.formLogin()//表单登录
			.loginPage("/authentication/require")//定义登录页面
			.loginProcessingUrl("/authentication/form")//当发起这个请求时调用security的过滤器进行处理
			.successHandler(johnAuthenticationSuccessHandler)//表单登录成功后用自己配置的处理器进行处理
			.failureHandler(johnAuthenticationFaliureHandler)//表单登录失败后用自己配置的处理器进行处理
			.and()
			.rememberMe()//开启记住我功能
			.tokenRepository(persistentTokenRepository())//设置tokenRepository实现
			.tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())//设置记住我过期秒数
			.userDetailsService(userDetailsService)//得到记住我的token后用这个方法进行登录
//		http.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers("/authentication/require",
					securityProperties.getBrowser().getLoginPage(),
					"/code/*").permitAll()//这些页面不需要身份认证
			.anyRequest()//访问其他的都需要身份认证
			.authenticated()
			.and()
			.csrf().disable()
			.apply(smsCodeAuthenticationSecurityConfig);
	}
	
}
