package com.john.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
* @author ���� john
* @version ����ʱ�䣺2019��4��29�� ����8:31:05
*/
public class ImageCode {
	//1ͼƬ
	private BufferedImage image;
	//1���ɵ������
	private String code;
	//1����ʱ��
	private LocalDateTime expireTime;
	
	public ImageCode(BufferedImage image, String code, int expireIn) {
		this.image = image;
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn);//����ʱ��
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
