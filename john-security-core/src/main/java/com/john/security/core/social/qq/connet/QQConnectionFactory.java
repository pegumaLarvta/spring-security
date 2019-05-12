package com.john.security.core.social.qq.connet;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

import com.john.security.core.social.qq.api.QQ;

/**
* @author 作者 john
* @version 创建时间：2019年5月12日 下午2:14:25
*/
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

	public QQConnectionFactory(String providerId, String appId, String appSecret) {
		super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
	}

}
