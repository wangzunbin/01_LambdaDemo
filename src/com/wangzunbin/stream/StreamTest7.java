package com.wangzunbin.stream;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.junit.Test;

import com.wangzunbin.stream.data.DataProvider;
import com.wangzunbin.stream.data.Director;
import com.wangzunbin.stream.data.Film;

/**
 * 排序
 * @author Administrator
 *
 */
public class StreamTest7 {

	/**
	 * 无参数, 默认是按照自然排序
	 */
	@Test
	public void testSorted() {
		Stream.of(5, 4, 3, 2, 1).sorted()
		.forEach(System.out::println);
	}
	
	/**
	 * sorted方法: 传入一个自定义的比较器
	 */
	@Test
	public void testSorted2() {
		Stream.of(5, 4, 3, 2, 1).sorted(Integer::compare)
		.forEach(System.out::println);
	}
	
	/**
	 * 自定义排序
	 * 需求如下:
	 * 3. 根据导演执导的电影的总票房排序, 从高到低
	 * 4. 根据导演执导的电影总数量从多到少排序, 如果数量相同, 再按照票房从高到底排序
	 */
	@Test
	public void testSorted3() {
		List<Director> data = DataProvider.getInstance().getData();
		data.stream().sorted((x, y) -> {
			BigDecimal xTotal = x.getTotalBoxOffice();
		
			BigDecimal yTotal = y.getTotalBoxOffice();
			
			return yTotal.compareTo(xTotal);
		}).forEach(d -> System.out.println(d.toString() + "  导演总票房" + d.getTotalBoxOffice()));
	}
}
