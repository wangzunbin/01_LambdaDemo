package com.wangzunbin.lambda;

import org.junit.Test;


public class LambdaTest4 {

	public void wrapWork(IMywork mywork) {
		System.out.println("do some wrap work ....");
		mywork.work();
	}
	
	@Test
	public void test() {
		this.wrapWork(() ->	
				System.out.println("do real work ...")
		);
	}
	
	@Test
	public void test1() {
		IMywork mywork = () ->	System.out.println("do real work ...");
		// 说明编译器的反推回来
		Runnable mywork1 = () ->	System.out.println("do real work ...");
		this.wrapWork(mywork);
	}
}
