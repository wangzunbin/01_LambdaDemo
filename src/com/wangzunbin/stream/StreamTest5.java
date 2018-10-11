package com.wangzunbin.stream;

import java.util.Arrays;

import org.junit.Test;

public class StreamTest5 {

	/**
	 * map的作用: 把一种类型的流变成另外一种类型的流
	 */
	@Test
	public void testMap() {
		String[] strings = {"yes","Yes", "no", "No", "Yes"};
		
		Arrays.stream(strings).map(String::toUpperCase)
		.forEach(System.out::println);
	}
}
