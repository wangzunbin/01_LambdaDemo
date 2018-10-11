package com.wangzunbin.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.wangzunbin.stream.data.User;

public class StreamTest1 {

	/**
	 * 加速度
	 */
	private List<User> users = new ArrayList<>();

	@Before
	public void prepared() {
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			users.add(new User("user" + i, random.nextInt(50) + 50));
		}
	}

	/**
	 * 1. 需求: 列出班上超过85分的学生姓名, 并且按照分数的降序输出用户名字
	 * 
	 */
	@Test
	public void test1() {
		ArrayList<String> list = new ArrayList<>();
		List<User> temp = new ArrayList<>();
		for (User user : users) {
			if (user.getScore() > 85) {
				temp.add(user);

			}
		}
		temp.sort(new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				return Integer.compare(o1.getScore(), o2.getScore());
			}
		});
		for (User user : temp) {
			list.add(user.getName());
		}
		System.out.println(list);
		// 使用stream
		/*
		 * 1. 得到集合的流对象 2. 使用filter方法完成了过滤 3. 使用sorted方法完成了排序 4.
		 * 使用map方法把user的流变成了String的流 5. 使用colloect把String的流变成了一个List<String>
		 */
		List<String> ret = users.stream().filter(user -> user.getScore() > 85)
				.sorted((u1, u2) -> Integer.compare(u1.getScore(), u2.getScore())).map(u -> u.getName())
				.collect(Collectors.toList());
		System.out.println("---------------------------");
		System.out.println(ret);

		List<String> ret1 = users.stream().filter(user -> user.getScore() > 85)
				.sorted(Comparator.comparing(User::getScore).reversed()).map(u -> u.getName())
				.collect(Collectors.toList());
		System.out.println("---------------------------");
		System.out.println(ret1);
		/**
		 * 上面的总结:  先执行collect方法之后, 才执行filter,sorted,map等这些延迟执行方法
		 */
	}

	/**
	 * 
	 * 2.统计出平均分数
	 */
	@Test
	public void test2() {
		double totalScore = 0D;
		for (User user : users) {
			totalScore += user.getScore();
		}
		if (users.size() > 0) {
			double avg = totalScore / users.size();
			System.out.println(avg);
		}
		/*
		 * 使用stream 1. 变成一个int的流 2. 使用average求这个流的平均值
		 */
		users.stream().mapToInt(User::getScore).average().ifPresent(System.out::println);

	}
}
