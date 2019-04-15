package com.john.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.john.dto.User;
import com.john.dto.UserQueryCondition;
import com.john.exception.UserNotExistException;

/**
* 
* @author john
* @version 创建时间：2019年4月4日 上午10:57:03
*/
@RestController
@RequestMapping("/user")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@PostMapping
	public User create(@Valid @RequestBody User user) {
		
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		
		user.setId("1");
		return user;
	}
	
	@PutMapping("/{id:\\d+}")
	public User update(@Valid @RequestBody User user, BindingResult errors) {
		if (errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error -> {
//				FieldError fieldError = (FieldError)error;
//				String message = fieldError.getField() + " " + error.getDefaultMessage();
				System.out.println(error.getDefaultMessage());
			}
			);
		}
		
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		
		user.setId("1");
		return user;
	}
	
	@DeleteMapping("/{id:\\d+}")
	public void delete(@PathVariable String id) {
		System.out.println(id);
	}

	@GetMapping()
	@JsonView(User.UserSimpleView.class)
	public List<User> query(UserQueryCondition userQueryCondition, 
			@PageableDefault(page = 1, size = 17, sort = "username,asc") Pageable pageable) {
		
		System.out.println(ReflectionToStringBuilder.toString(userQueryCondition, ToStringStyle.MULTI_LINE_STYLE));
		
		System.out.println(ReflectionToStringBuilder.toString(pageable, ToStringStyle.MULTI_LINE_STYLE));
		
		List<User> users = new ArrayList<User>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;
	}
	
	@GetMapping("/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	public User getInfo(@PathVariable String id) {
//		throw new UserNotExistException(id);
		long start = System.currentTimeMillis();
		logger.info("进入getInfo服务" + start);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user = new User();
		user.setUsername("tom");
		logger.info("离开getInfo服务，耗时：" + (System.currentTimeMillis() - start));
		return user;
	}
	
}
