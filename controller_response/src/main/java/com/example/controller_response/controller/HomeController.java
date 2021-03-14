package com.example.controller_response.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.InputStream;

@Slf4j
@Controller
public class HomeController {

	@GetMapping("/goHome0101")
	public void home0101() {
		log.info("home0101");
	}

	@GetMapping("/sub/goHome0102")
	public void home0102() {
		log.info("home0102");
	}

	@GetMapping("/goHome0201")
	public String home0201() {
		log.info("home0201");

		return "redirect:/sub/goHome0202";
	}

	@GetMapping("/sub/goHome0202")
	public String home0202() {
		log.info("home0202");

		return "/sub/home0202";
	}

	@ResponseBody
	@GetMapping("/goHome0301")
	public ResponseEntity<byte[]> home1101() throws Exception {
		log.info("home0301");

		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		try {
			HttpHeaders headers = new HttpHeaders();

			//in = new FileInputStream("C:\\TEMP\\sample.png");
			//in = new FileInputStream("META-INF/resources/images/docker.png");
			in = new FileInputStream("/home/oem/proj/kh/JSP-MyBatis-Spring/controller_response/src/main/resources/static/img/docker.png");

			headers.setContentType(MediaType.IMAGE_PNG);

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}

	@GetMapping("/registerForm")
	public String registerForm() {
		log.info("registerForm");

		return "registerForm";
	}

	//@GetMapping("/register")
	@GetMapping("/getRegister")
	public String registerByParameter(String userId, String password) {
		log.info("registerByParameter");

		log.info("userId = " + userId);

		log.info("password = " + password);

		return "success";
	}

	//@PostMapping("/register02")
	@PostMapping("/postRegister")
	public String register02(String userId, String password) {
		log.info("register02");

		log.info("userId = " + userId);

		log.info("password = " + password);

		return "success";
	}
}
