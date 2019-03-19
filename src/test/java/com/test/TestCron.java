package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
@EnableAsync
@Configuration
public class TestCron {
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(TestCron.class, args);
		for (int i = 0; i < 3; i++) {
			String add = Person.add("linfeng"+i);
			String ha = add+"!";
			System.out.println(ha);
		}
	
	}

   static class Person{
	   
	   private int age;
	   private String sex;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Async
    public static String add(String s) throws InterruptedException{
		System.out.println(s);
    	Thread.sleep(2000);
		return s+"hello";
    	
    }
   } 
}
