package com.john.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
* @author 作者 john
* @version 创建时间：2019年4月29日 下午8:31:05
*/
public class ImageCode {
	//1图片
	private BufferedImage image;
	//1生成的随机数
	private String code;
	//1过期时间
	private LocalDateTime expireTime;
	
	public ImageCode(BufferedImage image, String code, int expireIn) {
		this.image = image;
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn);//过期时间
	}
	
	public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
		this.image = image;
		this.code = code;
		this.expireTime = expireTime;
	}
	
	public boolean isExpried() {
		return LocalDateTime.now().isAfter(expireTime);
	}

	public BufferedImage getImage() {
		return image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
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
