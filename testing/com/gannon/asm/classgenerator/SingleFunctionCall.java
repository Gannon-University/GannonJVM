package com.gannon.asm.classgenerator;

public class SingleFunctionCall {
	public int Test(int i) { 
		int j = 0;
		
		if (i>0) { 
			j = 0; 
		} 
		else {
			j = i; 
		} 
		return j; 
	}
	
	public int Test_2(int i) { 
		int j = 0;
		
		if (i>0) { 
			j = 0; 
		} 
		else {
			j = i; 
		}
		MethodToMethodCall_IC callClass = new MethodToMethodCall_IC();
		return callClass.method_A(i); 
	}

}
