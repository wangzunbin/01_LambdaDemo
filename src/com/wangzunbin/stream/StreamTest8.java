package com.wangzunbin.stream;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Stream遍历
 * @author Administrator
 *
 */
public class StreamTest8 {

	
	@Test
	public void testForeach() {
		String[] strings = {"a", "b", "c", "d"};
		Stream.of(strings).forEach(System.out::print);
		System.out.println("----------------------------");
		Arrays.asList(strings).stream().forEach(System.out::print);
	}
}
