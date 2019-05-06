package com.john.security.core.properties;

/**
* @author 作者 john
* @version 创建时间：2019年4月29日 下午10:03:06
*/
public class ImageCodeProperties extends SmsCodeProperties {

	private int width = 67;
	private int height = 23;
	
	public ImageCodeProperties() {
		setLength(4);
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
}
