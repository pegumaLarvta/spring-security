package com.john.security.core;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.john.security.core.properties.SecurityProperties;

/**
* @author 作者 john
* @version 创建时间：2019年4月17日 下午11:07:26
*/
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

}
