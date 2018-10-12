package com.wangzunbin.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Stream的简单聚合
 * 
 * @author Administrator
 *
 */
public class StreamTest9 {

	// 求Stream里面的最大值
	@Test
	public void testMaxAndMin() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("e:\\SUService.log"));
			int asInt = br.lines() // 拿到行的Stream
					.mapToInt(String::length) // 转成长度的Stream
					.max() // 取这些Stream最大的
					.getAsInt(); // 转成int数字
			br.close(); // 关闭
			System.out.println(asInt);

			BufferedReader brForMin = new BufferedReader(new FileReader("e:\\SUService.log"));
			int asIntForMIn = brForMin.lines() // 拿到行的Stream
					.mapToInt(String::length) // 转成长度的Stream
					.min() // 取这些Stream最大的
					.getAsInt(); // 转成int数字
			br.close(); // 关闭
			System.out.println(asIntForMIn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	// 求Stream数组总数
	@Test
	public void testCount() {
		String[] strings = { "a", "b", "c" };
		long count = Stream.of(strings).count();
		System.out.println(count);
	}

	@Test
	public void testFindFirst() {
		String strA = " abcd";
		String strB = null;
		print(strA);
		print(" ");
		print(strB);
		getLengtgh(" ");
		getLengtgh(strB);
	}

	public static void print(String text) {
		/*if (text != null) {
			System.out.println(text);
		}*/
		Optional.ofNullable(text).ifPresent(System.out::println);
	}
	public static int getLengtgh(String text) {
//		return if(text != null)?text.length():-1;
		return Optional.ofNullable(text).map(String::length).orElse(-1);
		
	}
}
