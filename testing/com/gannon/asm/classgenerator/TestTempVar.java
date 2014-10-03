package com.gannon.asm.classgenerator;

public class TestTempVar {

	public int test1(int a) {
		int v1 = 1;
		int v2 = 2;
		int v3 = 3;
		int v4 = 4;
		if(v1>v2){
			v3 = a + v1;
		}
		v3 = v1 + v2;
		return v3;
	}

}
