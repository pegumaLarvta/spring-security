package com.john.exception;
/**
* 
* @author john
* @version 创建时间：2019年4月11日 下午8:41:39
*/
public class UserNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	public UserNotExistException(String id) {
		super("user not exist");
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
