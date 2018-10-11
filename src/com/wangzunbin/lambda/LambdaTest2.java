package com.wangzunbin.lambda;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import org.junit.Test;

public class LambdaTest2 {

	
	@Test
	public void test1() {
		new Thread(() -> System.out.println("haha")).start();
	}
	
	
	@Test
	public void test2() {
		Frame frame = new Frame();
		frame.setSize(100, 100);
		Button button = new Button("lambda");
		button.addActionListener( event -> System.out.println("hahah"));
		frame.add(button);
		frame.setVisible(true);
		
	}
	
	@Test
	public void test3() {
		String[] strings = {"wangzunbin", "wangzunbin221", "wangzunbin1"};
		Arrays.sort(strings,  (str1, str2) -> Integer.compare(str1.length(), str2.length()));
		System.out.println(Arrays.toString(strings));
	}
	
	
	/**
	 *   一行可以不需要方法体
	 */
	@Test
	public void test4() {
		String[] strings = {"wangzunbin", "wangzunbin221", "wangzunbin1"};
		Arrays.sort(strings,  (str1, str2) -> {
			if (str1 != null && str2 != null) {
				return Integer.compare(str1.length(), str2.length());
			}
			return -1;
		});
		System.out.println(Arrays.toString(strings));
	}
}
