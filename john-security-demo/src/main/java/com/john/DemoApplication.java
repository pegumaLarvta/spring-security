package com.john;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* 
* @author john
* @version 创建时间：2019年4月3日 下午9:15:13
*/
@SpringBootApplication
@RestController
@EnableSwagger2
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello spring security";
	}

}
