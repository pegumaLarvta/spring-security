package com.john.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
* @author 作者 john
* @version 创建时间：2019年4月17日 下午8:40:41
*/
@Component
public class MyUserDetailsService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("登录用户名：" + username);
		//根据用户名查找用户信息
		//根据查找到的用户信息判断用户是否被冻结
		//user 参数：用户名，密码，账户是否可用，账户是否过期，账户密码是否过期，账户是否锁定，账户权限集合
		return new User(username, passwordEncoder.encode("123456"), 
				true,true,true,true,
				AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}

}
