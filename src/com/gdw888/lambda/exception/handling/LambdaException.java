package com.gdw888.lambda.exception.handling;

import java.util.function.BiConsumer;

public class LambdaException {
	public static void main(String argsp[]) {
		int [] someNumbers = {1,2,3,4};
		int key = 0;

		process(someNumbers, key, wrapperLambda((v,k)->{System.out.println(v/k);}));
		
		//process2(someNumbers, key, (v,k)->{System.out.println(v/k);});
		
	}
	
	private static void process(int[] someNumbers, int key, BiConsumer<Integer,Integer> c) {
		for (int number : someNumbers) {
			c.accept(number, key);
		}
	}
	
	private static void process2(int[] someNumbers, int key, BiConsumer<Integer,Integer> c) {
		for (int number : someNumbers) {
			try { 
				c.accept(number, key);
			}catch(ArithmeticException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static BiConsumer<Integer,Integer> wrapperLambda( BiConsumer<Integer,Integer> c) {
		return c;
	}
}
