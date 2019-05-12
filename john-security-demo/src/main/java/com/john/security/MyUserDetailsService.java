package com.john.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
* @author 作者 john
* @version 创建时间：2019年4月17日 下午8:40:41
*/
@Component
public class MyUserDetailsService implements UserDetailsService, SocialUserDetailsService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("表单登录用户名：" + username);
		//根据用户名查找用户信息
		return buildUser(username);
	}

	@Override
	public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
		logger.info("设计登录用户Id：" + userId);
		//根据用户Id查找用户信息
		return buildUser(userId);
	}

	private SocialUserDetails buildUser(String userId) {
		//根据查找到的用户信息判断用户是否被冻结
		//user 参数：用户名，密码，账户是否可用，账户是否过期，账户密码是否过期，账户是否锁定，账户权限集合
		String password = "123456";
		logger.info("数据库密码是：" + password);
		return new SocialUser(userId, passwordEncoder.encode(password), 
				true,true,true,true,
				AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}

}
