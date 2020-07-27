package com.example.demo.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * 
 * Component: 把Person对象注入到容器中
 * ConfigurationProperties(prefix="person")：绑定配置文件属性。扫描配置文件application.yml前缀为person的内容
 
 不用@ConfigurationProperties(prefix="person")批量注入注解，也可以用@Value单个注入注解注入值
 */
//@PropertySource(value={"classpath:person.properties"})
@Component
@ConfigurationProperties(prefix="person")
public class Person {

	/*
	 * 以前xml的写法
	 * <bean class="Person">
	 * 		<property name="lastName" value="字面量/${key}从环境变量、配置文件中获取值或者#{SpEL}"></property>
	 * </bean>
	 */
//${key}从环境变量、配置文件中获取值
//	@Value("${person.last-name}")
	
	private String lastName;
//#{11*2} spring的表达式   #{SpEL}
//	@Value("#{11*2}")
	private Integer age;
//	@Value("true")
	private Boolean boss;
	private Date birth;
	
	private Map<String, Object> maps;
	private List<?> list;
	private Dog dog;
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Boolean getBoss() {
		return boss;
	}
	public void setBoss(Boolean boss) {
		this.boss = boss;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Map<String, Object> getMaps() {
		return maps;
	}
	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	@Override
	public String toString() {
		return "Person [lastName=" + lastName + ", age=" + age + ", boss=" + boss + ", birth=" + birth + ", maps="
				+ maps + ", list=" + list + ", dog=" + dog + "]";
	}
	
	
}
