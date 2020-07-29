package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*打印日志*/
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public static void main(String[] args) {
	Logger logger = LoggerFactory.getLogger(HelloController.class);
	logger.info("Hello world");
}*/
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello world quick";
	}
	
	
}
