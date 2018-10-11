package com.wangzunbin.defaultmethod;

public interface ILandAnimal {

	void run();
	default void breathInAir() {
		System.out.println("breath in air ....");
	}
	
	default void breath() {
		System.out.println("breath in air ....");
	}
}
