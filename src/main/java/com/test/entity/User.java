package com.test.entity;

import java.io.Serializable;

public class User implements Serializable{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
String name;
  Integer age;

public User(String name, Integer age) {
	super();
	this.name = name;
	this.age = age;
}
@Override
public String toString() {
	return "User [name=" + name + ", age=" + age + "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}

}
