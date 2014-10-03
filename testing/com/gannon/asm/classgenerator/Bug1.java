package com.gannon.asm.classgenerator;

public class Bug1 {

	
	public int test1(int i){
		int k=1;
		if(k>5){
			k=2;
		}else{
			k=3;
		}
		return k;
	}

}
