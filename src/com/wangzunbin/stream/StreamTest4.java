package com.wangzunbin.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import javax.security.auth.x500.X500Principal;

import org.junit.Test;

import com.wangzunbin.stream.data.DataProvider;
import com.wangzunbin.stream.data.Director;

/**
 * 过滤
 * 
 * @author Administrator
 *
 *         1.筛选出所有以数字开头的字符串 2. 选择出录入了3部以上电影的导演信息
 */
public class StreamTest4 {

	@Test
	public void testFilter1() {
		String[] strings = new String[] { "a", "abc", "dc", "ge", "gdate" };
		// 1.转换成Stream
		// 2. 调用filter方法
		Arrays.stream(strings).filter(x -> x.length() > 3).forEach(System.out::println);

	}

	@Test
	public void testFilter2() {
		String[] strings = { "1a", "2b", "3c", "dc" };
		Arrays.stream(strings).filter(X -> Character.isDigit(X.charAt(0))).forEach(System.out::println);
	}

	@Test
	public void testFilter3() {
		List<Director> datas = DataProvider.getInstance().getData();
//		System.out.println(datas);
		datas.stream().filter(d -> d.getFilms().size() > 2).forEach(d -> System.out.println(d.toString() + "  电影数量: " + d.getFilms().size()) );
	}
	
	/**
	 * distinct: 把流中的重复对象合并
	 */
	@Test
	public void testDistinct() {
		Stream.of("a", "b", "c", "d", "a", "b").distinct().forEach(System.out::println);
		
		
	}
}
