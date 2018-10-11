package com.wangzunbin.defaultmethod;

public class Forg extends BigMouth implements IwaterAnimal, ILandAnimal {

	@Override
	public void run() {
		System.out.println("对不起, 我只会跳");
	}

	@Override
	public void swim() {
		System.out.println("对不起, 我只会蛙泳");
	}


	public static void main(String[] args) {
		Forg forg = new Forg();
		forg.swim();
		forg.breathInAir();
		forg.breathInWater();
		forg.openMouth();
		forg.breath();
	}
}
