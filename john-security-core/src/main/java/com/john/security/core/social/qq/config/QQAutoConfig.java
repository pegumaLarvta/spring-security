package com.john.security.core.social.qq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.social.connect.ConnectionFactory;

import com.john.security.core.properties.QQProperties;
import com.john.security.core.properties.SecurityProperties;
import com.john.security.core.social.qq.connet.QQConnectionFactory;

/**
* @author ���� john
* @version ����ʱ�䣺2019��5��12�� ����3:01:53
*/
@Configuration
@ConditionalOnProperty(prefix = "john.security.social.qq", name = "app-id")//�����������������ʱ�����config���������ò���Ч
public class QQAutoConfig extends SocialAutoConfigurerAdapter {
	
	@Autowired
	private SecurityProperties securityProperties;

	@Override
	protected ConnectionFactory<?> createConnectionFactory() {
		QQProperties qqConfig = securityProperties.getSocial().getQq();
		return new QQConnectionFactory(qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret());
	}

}
