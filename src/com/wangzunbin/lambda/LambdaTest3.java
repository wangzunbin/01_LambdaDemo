package com.wangzunbin.lambda;

import org.junit.Test;

public class LambdaTest3 {

	public void repreatPrint(String content, int times) {
		Runnable runnable = () -> {
			for (int i = 0; i < times; i++) {
				System.out.println(content);
			}
		};
		new Thread(runnable).start();
	}
	
	@Test
	public void testVar() {
		this.repreatPrint("haha", 5);
	}
}
