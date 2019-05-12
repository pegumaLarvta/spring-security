package com.john.security.core.social.qq.connet;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

import com.john.security.core.social.qq.api.QQ;

/**
* @author ���� john
* @version ����ʱ�䣺2019��5��12�� ����2:14:25
*/
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

	public QQConnectionFactory(String providerId, String appId, String appSecret) {
		super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
	}

}
