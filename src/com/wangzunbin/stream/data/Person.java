package com.wangzunbin.stream.data;

public class Person {

	private Integer index; // 游标
	private String name; // 哪个
	private Integer age;	// 多少年纪
	
	
	

	public Person(Integer index, String name, Integer age) {
		super();
		this.index = index;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [index=" + index + ", name=" + name + ", age=" + age + "]";
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
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
	
	 
}
