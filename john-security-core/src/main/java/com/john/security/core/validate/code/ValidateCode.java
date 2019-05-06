package com.john.security.core.validate.code;

import java.time.LocalDateTime;

/**
* @author 作者 john
* @version 创建时间：2019年4月29日 下午8:31:05
*/
public class ValidateCode {
	//1生成的随机数
	private String code;
	//1过期时间
	private LocalDateTime expireTime;
	
	public ValidateCode(String code, int expireIn) {
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn);//过期时间
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
