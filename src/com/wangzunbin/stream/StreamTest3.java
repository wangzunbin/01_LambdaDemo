package com.wangzunbin.stream;

import java.nio.file.Path;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import com.wangzunbin.stream.data.User;

/**
 * 创建Stream的几种方法
 * @author Administrator
 *
 */
public class StreamTest3 {

	
	@Test
	public void testArraryStream() {
		int[] ints = new int[] {1, 2, 3, 4, 5};
		IntStream intStream = Arrays.stream(ints);
		
		User[] users = {new User("hahah", 1), new User("hhe", 2)};
		Stream<User> stream = Arrays.stream(users);
	}
	
	/**
	 * 使用Stream.of()来完成
	 */
	@Test
	public void testArrayStreams() {
		int[] ints = new int[] {1, 2, 3, 4, 5};
		// 注意, 不能直接把简单类型的数据作为Stream.of的参数(返回的Stream<int[]>)
		Stream<int[]> intputStream = Stream.of(ints);
		
		// 得到一个Stream<Integer>, 这个Stream里面的操作会涉及到autobox/unbox
		// 一定要注意, Stream<Integer>和intStream是不一样的对象
		Stream<Integer> of = Stream.of(1,2,3,4,5);
		
	}
	
	/**
	 * 集合类型-> Stream
	 */
	@Test
	public void TestColStream() {
		// 对于集合, 直接调用对应的Stream方法
		List<String> asList = Arrays.asList(new String[] {"a", "b", "c"});
		Stream<String> stream = asList.stream();
		
		// 得到并行执行的Stream
		Stream<String> parallelStream = asList.parallelStream();
		
	}
	
	@Test
	public void testEmptyStream() {
		//  创建一个空的Stream
		Stream<Object> empty = Stream.empty();
		
	}
	
	/**
	 * 如果可以在遍历Stream元素的时候, 才去生成要处理的下个元素
	 * 就有可能创建一个无限大的Stream; 延迟
	 * 可以创建大量的数据
	 */
	@Test
	public void testUnlimitStream() {
//		Stream.generate(() -> "haha").forEach(System.out::println);
		// limit() , 截取limit  个数据
//		Stream.generate(() -> "hahah").limit(100).forEach(System.out :: println);
		Stream.generate(() -> new User("wangzunbin", 100)).limit(100).forEach(System.out::println);
		Stream.generate(Math::random).limit(10000).forEach(System.out::println);
	}
	
	/**
	 * 创建有规律的数据
	 * 使用Stream.iterate
	 */
	@Test
	public void testUnlimitStream2() {
//		Stream.iterate(0, x -> x).limit(10).forEach(System.out::println);
		// 上面的例子可以使用下面的写法
//		Stream.iterate(0, UnaryOperator.identity()).limit(10).forEach(System.out::println);
//		Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::println);
	}
}
