package com.john.security.core.validate.code.image;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

import com.john.security.core.validate.code.ValidateCode;

/**
* @author ���� john
* @version ����ʱ�䣺2019��4��29�� ����8:31:05
*/
public class ImageCode extends ValidateCode {
	//1ͼƬ
	private BufferedImage image;
	
	public ImageCode(BufferedImage image, String code, int expireIn) {
		super(code, expireIn);
		this.image = image;
	}
	
	public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
		super(code, expireTime);
		this.image = image;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
}
