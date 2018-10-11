package com.wangzunbin.stream;

import java.util.stream.Stream;

import javax.security.auth.x500.X500Principal;

import org.junit.Test;

public class StreamTest6 {

	/**
	 * limit, 限制从六中获得前N个数据
	 */
	@Test
	public void testLimit() {
		Stream.iterate(1, x -> x + 1).limit(100)
		.forEach(System.out::println);
	}
	
	/**
	 * skip: 跳过前N个数据
	 */
	@Test
	public void testSkip() {
		Stream.of(1,2,3,4,5,6).skip(3)
		.forEach(System.out::println);
	}
	
	/**
	 * concat:可以把两个Stream合并成一个Stream(合并的Stream类型必须相同)
	 */
	@Test
	public void testConcat() {
		Stream<String> stream1 = Stream.of("a", "b", "c", "d");
		Stream<String> stream2 = Stream.of("e", "f", "g", "h");
		Stream.concat(stream1, stream2).forEach(System.out::println);
	}
	
	/**
	 * peek方法
	 */
	@Test
	public void testPeek() {
		/*Stream<Integer> of = Stream.of(1, 2, 3, 4, 5, 6, 7);
		of.peek(System.out::print)
		.filter(x -> x > 3)
		.peek(System.out::print)
		.filter(x -> x < 7)
		.forEach(System.out::println);*/
		
		// 并行运行
		Stream<Integer> of1 = Stream.of(1, 2, 3, 4, 5, 6, 7).parallel();
		of1.peek(System.out::print)
		.filter(x -> x > 3)
		.peek(System.out::print)
		.filter(x -> x < 7)
		.forEach(System.out::println);
	}
}
