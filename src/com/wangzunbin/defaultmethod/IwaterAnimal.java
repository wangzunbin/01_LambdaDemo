package com.wangzunbin.defaultmethod;

public interface IwaterAnimal {

	void swim();
	
	static void eat() {
		
	}
	
	default void breathInWater() {
		System.out.println("breath in water...");
	}
	
	default void breath() {
		System.out.println("breath in water...");
	}
}
