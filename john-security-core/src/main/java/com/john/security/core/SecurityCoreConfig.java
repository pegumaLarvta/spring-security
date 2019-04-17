package com.john.security.core;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.john.security.core.properties.SecurityProperties;

/**
* @author ���� john
* @version ����ʱ�䣺2019��4��17�� ����11:07:26
*/
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

}
