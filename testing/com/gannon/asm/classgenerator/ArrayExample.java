package com.gannon.asm.classgenerator;

public class ArrayExample {

	public static void example(int[] arr){
		System.out.println(arr[1]);
	}
	public static void main(String args[]){
		int[] arr =  new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		example(arr);
	}
}
