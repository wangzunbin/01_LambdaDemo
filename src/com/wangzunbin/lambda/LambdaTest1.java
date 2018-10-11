package com.wangzunbin.lambda;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class LambdaTest1 {

	class User {
		private String name;
		private Integer age;

		public User(String name, Integer age) {
			super();
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "User [name=" + name + ", age=" + age + "]";
		}

	}

	@Test
	public void testOldUse1() {
		User[] users = new User[] { new User("张三", 90), new User("李四", 83), new User("王五", 93) };
		Arrays.sort(users, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				return Integer.compare(o1.age, o2.age);
			}
		});
		System.out.println(Arrays.toString(users));
	}

	@Test
	public void testNewUse1() {
		User[] users = new User[] {new User("张三", 90),
				new User("李四", 83),
				new User("王五", 93)};
		Arrays.sort(users, 
				(User o1, User o2) -> { 
				 return Integer.compare(o1.age, o2.age);
			 }
			);
		System.out.println(Arrays.toString(users));
	}
	
	@Test
	public void testNewUse2() {
		User[] users = new User[] {new User("张三", 90),
				new User("李四", 83),
				new User("王五", 93)};
		Arrays.sort(users, 
				(User o1, User o2) -> Integer.compare(o1.age, o2.age)
			);
		System.out.println(Arrays.toString(users));
	}
	
	@Test
	public void testThread1() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("hello lambda");
			}
		}).start();;
	}
	
	@Test
	public void testThread2() {
		new Thread(
				()->		System.out.println("hello lambda")
		).start();;
		
	}
	
	@Test
	public void testThread3() {
		Runnable runnable = ()-> System.out.println("hello lambda");
		new Thread(runnable).start();
	}
}
