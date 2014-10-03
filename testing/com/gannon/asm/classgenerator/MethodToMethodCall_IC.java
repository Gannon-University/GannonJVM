package com.gannon.asm.classgenerator;

public class MethodToMethodCall_IC {
	public int method_A(int i) {
		if (i>0) {
			return i;
		}
		else {
			return method_B(i);
		}
	}
	
	public int method_B(int i){
		while(i<0){
			i = i+1;
		}
			return i;
	}

}
