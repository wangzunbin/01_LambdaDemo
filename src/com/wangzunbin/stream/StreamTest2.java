package com.wangzunbin.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest2 {

	public boolean compare(int x) {
		System.out.println("执行比较.....");
		return x > 5;
	}
	
	@Test
	public void test1() {
		Integer[] integers = {1,2,3,4, 5,6,7,8};
		List<Integer> ret = new ArrayList<>();
		// 内部循环: 循环的代码和业务处理的代码混淆;
		for (Integer data : integers) {
			if (data > 5) {
				ret.add(data);
			}
		}
		System.out.println(ret);
		// Stream:内部循环, 代码里面不需要写循环的操作
		/*
		 * * 调用了一个方法, 马上执行, 我们叫做迫切执行方法;如果调用了一个方法, 并不会立刻执行, 叫做延迟执行方法;
		 * * 1. 只要Stream的方法返回的是Stream, 那么这些方法就是延迟执行的方法;
		 * * 2. 延迟执行的方法一定要等到一个迫切执行方法执行的时候, 才回执行;(在Stream里面, 返回的不是一个Stream
		 *      的基本都是迫切执行方法)
		 */
		Stream<Integer> stream = Stream.of(integers).filter(this::compare);
		System.out.println("====================================");
		stream.collect(Collectors.toList()).forEach(System.out::println);
	}
}
