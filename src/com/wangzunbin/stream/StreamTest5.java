package com.wangzunbin.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.wangzunbin.stream.data.DataProvider;
import com.wangzunbin.stream.data.Director;

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
	
	
	/**
	 * flatMap:
	 * 1. 把Stream<String[]>合并为一个Stream<String>
	 * 2. 找出票房在10亿以上的电影名称
	 * 3. 列出参加过斯皮尔伯格电影的演员名单
	 */
	@Test
	public void testFlatMap() {
		String[] arr1 = {"a", "b", "c"};
		String[] arr2 = {"d", "e", "f"};
		String[] arr3 = {"a", "g", "h"};
		
		/**
		 * Arrays.stream(arr) --> Stream<String>
		 * arr1-->Stream<String>
		 * arr2-->Stream<String>
		 * arr3-->Stream<String>
		 * flatmap --> stream1+stream2+stream3 -> Stream<String>
		 */
		Stream.of(arr1, arr2, arr3).flatMap(arr -> Arrays.stream(arr)).forEach(System.out::println);
	}
	
	
	/**
	 * 2. 找出票房在10亿以上的电影名称
	 * 
	 */
	
	@Test
	public void testFlatMap2() {
		List<Director> data = DataProvider.getInstance().getData();
		// 先把Director流->Film流(使用flatmap)
		// filter过滤film流
		data.stream().flatMap(d -> d.getFilms().stream())
		.filter(f -> f.getBoxoffice().compareTo(BigDecimal.TEN) > 0)
		.forEach(System.out::println);
		
		
	}
	
	/**
	 * 3. 列出参加过斯皮尔佰格电影的演员名单;
	 */
	@Test
	public void testFlatMap3() {
		List<Director> data = DataProvider.getInstance().getData();
		/**
		 * 1. 对导演流过滤  -> Stream<Director>
		 * 2. 得到电影刘, flatmap->Stream<Directer> ---> Stream<Film>
		 * 3. 得到演员流: flatmap--> Stream<Film> ---> Stream<String>
		 * 4. 把Stream<Actor> --> Stream<String>
		 * 5. 去重, distinct去重
		 */
		data.stream()
		.filter(d -> d.getName().equals("斯皮尔佰格"))
		.flatMap(d -> d.getFilms().stream())
		.flatMap(f -> f.getActors().stream())
		.map(a -> a.getName())
		.distinct()
		.forEach(System.out::println);
	}
}
