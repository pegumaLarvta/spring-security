package com.john.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.john.dto.FileInfo;

/**
* @author 作者 john
* @version 创建时间：2019年4月13日 下午7:27:39
*/
@RestController
@RequestMapping("/file")
public class FileController {
	
	private String folder = "C:\\develop\\gitCode\\spring-security\\john-security-demo\\src\\main\\java\\com\\john\\web\\controller";

	@PostMapping
	public FileInfo upload(MultipartFile file) throws Exception {
		
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		File localFile = new File(folder, new Date().getTime() + ".txt");
		
		file.transferTo(localFile);
		
		return new FileInfo(localFile.getAbsolutePath());
	}
	
	@GetMapping("/{id}")
	public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try(
				InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
				OutputStream outputStream = response.getOutputStream();
				) {
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=test.txt");
			IOUtils.copy(inputStream, outputStream);
			outputStream.flush();
		} 
	}
	
}
