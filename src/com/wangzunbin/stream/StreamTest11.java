package com.wangzunbin.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.wangzunbin.stream.data.Person;
import com.wangzunbin.stream.data.PersonSupplier;

public class StreamTest11 {

	@Test
	public void testCollect() {
		List<Integer> collect = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
	}

	@Test
	public void testGroup() {
		// 1. 按照年龄归组
/*		Stream.generate(new PersonSupplier()).limit(100)
				.collect(Collectors.groupingBy(Person::getAge))
				.forEach((k, v) -> System.out.println("Age " + k + " = " + v.size()));
				*/
		System.out.println("-----------------------华丽的分割线---------------------------------");
		// 2. 按照未成年人和成年人归组
		Stream.generate(new PersonSupplier())
		.limit(100)
		.collect(Collectors.partitioningBy(p -> p.getAge() < 18))
		.forEach((k, p) -> {
			if (k) {				
				System.out.println("Children number: " + p.size());
			} else {	
				System.out.println("Adult number: " + p.size());
				p.stream().forEach(System.out::println);
			}
		});
	}
}
