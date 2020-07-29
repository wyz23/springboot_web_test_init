package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.bean.Person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * RunWith(SpringRunner.class) 使用sping的运行环境
 * 类和方法必须要是public 修饰，否则运行会报initializationError错误
例：
 class DemoApplicationTests {
	@Autowired
	Person person;
	@Test
	 void contextLoads() {
		System.out.println(person);
	}
}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
//	@Autowired
//	Person person;
	Logger logger =LoggerFactory.getLogger(getClass());
	@Test
	public void contextLoads() {
//		System.out.println(person);
		//日志级别由低到高，trace < debug < info < warn < error
		//可以调整输出的日志级别，日志就只会在这个级别以后的高级别生效 ，springboot默认是info级别
		/*在application.yml文件里配置级别，
		logging:
		  level:
			    com.example.demo: trace*/
		logger.trace("这是trace日志。。。。");
		logger.debug("这是debug日志。。。。");
		logger.info("这是info日志。。。。");
		logger.warn("这是warn日志。。。。");
		logger.error("这是error日志。。。。");
		
	}

}
