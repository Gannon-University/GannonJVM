package com.gannon.asm.classgenerator;

public class TestInfesaible {

	public int infeasible(int a, int b, int c) {
		if (a > b) {
			if (b > c) {
				if (c > a) {
					a = 3;
				}
			}
		}
		return a; 
	}
	
	public int infeasibleHasLocalVar(int a, int b, int c) {
		int d=0;
		if (a > b) {
			if (b > c) {
				if (c > a) {
					d = 3;
				}
			}
		}
		return d; 
	}
}
