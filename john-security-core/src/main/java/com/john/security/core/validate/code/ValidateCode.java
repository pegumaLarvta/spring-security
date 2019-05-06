package com.john.security.core.validate.code;

import java.time.LocalDateTime;

/**
* @author ���� john
* @version ����ʱ�䣺2019��4��29�� ����8:31:05
*/
public class ValidateCode {
	//1���ɵ������
	private String code;
	//1����ʱ��
	private LocalDateTime expireTime;
	
	public ValidateCode(String code, int expireIn) {
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn);//����ʱ��
	}
	
	public ValidateCode(String code, LocalDateTime expireTime) {
		this.code = code;
		this.expireTime = expireTime;
	}
	
	public boolean isExpried() {
		return LocalDateTime.now().isAfter(expireTime);
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public LocalDateTime getExpireTime() {
		return expireTime;
	}
	
	public void setExpireTime(LocalDateTime expireTime) {
		this.expireTime = expireTime;
	}

}
