package com.gannon.jvm.utilities;

import java.util.Iterator;
import java.util.Queue;
import java.util.Set;

import com.gannon.jvm.data.input.Input;

public class Utility {

	public static void displayInputQueue(Queue<Input> qe) {
		Iterator<Input>it = qe.iterator();
		while (it.hasNext()) {
			Input iteratorValue = (Input) it.next();
			System.out.println("Input Queue Next Value :" + iteratorValue);
		}
	}
	
	//don't setup max too big
	public static int getRandomInt(int minimum, int maximum) {
		return maximum + (int)(Math.random()*maximum);
	}
	
	public static String toNiceString(Set<Input> inputs){
		StringBuffer sb=new StringBuffer();
		for(Input input:inputs){
			sb.append(input.toNiceString());
		}
		return sb.toString();
		 
	}
}
