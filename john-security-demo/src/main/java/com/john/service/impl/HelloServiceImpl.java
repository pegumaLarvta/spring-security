package com.john.service.impl;

import org.springframework.stereotype.Service;

import com.john.service.HelloService;

/**
* 
* @author john
* @version 创建时间：2019年4月11日 下午7:09:46
*/
@Service
public class HelloServiceImpl implements HelloService {

	@Override
	public String greeting(String name) {
		System.out.println("greeting");
		return "hello " + name;
	}

}
