package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.bean.Person;

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
	@Autowired
	Person person;
	@Test
	public void contextLoads() {
		System.out.println(person);
	}

}
