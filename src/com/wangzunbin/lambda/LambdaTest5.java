package com.wangzunbin.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


public class LambdaTest5 {

	@Test
	public void test1() {
		Integer[] arrs = {2,3,4,5,6,4,3,5};
		Arrays.sort(arrs, (x, y) -> Integer.compare(x, y));
		System.out.println(Arrays.toString(arrs));
	}
	@Test
	public void test2() {
		Integer[] arrs = {2,3,4,5,6,4,3,5};
		// 也是lambda表达式, 方法引用(类:: 静态方法)
		Arrays.sort(arrs, Integer::compare);
		// Integer:: compare
		System.out.println(Arrays.toString(arrs));
	}
	
	public int compare(int x,int y) {
		return Integer.compare(x, y);
	}
	
	@Test
	public void test3() {
		Integer[] arrs = {2,3,4,5,6,4,3,5};
		// 也是lambda表达式, 方法引用(类:: 静态方法)
		Arrays.sort(arrs, this::compare);
		// Integer:: compare
		System.out.println(Arrays.toString(arrs));
	}
	
	@Test
	public void test4() {
		Integer[] arrs = {2,3,4,5,6,4,3,5};
		List<Integer> datas = Arrays.asList(arrs);
		datas.forEach(System.out::println);
	}
	
	@Test
	public void test5() {
		List<Integer> list = Arrays.asList(2,3,4,5,6,4,3,5);
		System.out.println(list.getClass());
	}
	
	//为啥?
	@Test
	public void test6() {
		
		
		List<Integer> list2 = this.asList(new IMyCreator<List<Integer>>() {
			
			@Override
			public List<Integer> create() {
				return new ArrayList<>();
			}
		},2,3,4,5,6,4,3,5);
		List<Integer> list3 = this.asList(() -> new LinkedList<>(),2,3,4,5,6,4,3,5);	
		List<Integer> list = this.asList(LinkedList::new, new Integer[]{2,3,4,5,6,4,3,5});
	
		System.out.println(list.getClass());
	}
	
	
	public <T>  List<T> asList(IMyCreator<List<T>> creator, T... a){
		List<T> list2 = creator.create();
		for (T t : list2) {
			list2.add(t);
		}
		return list2;
	}
}
