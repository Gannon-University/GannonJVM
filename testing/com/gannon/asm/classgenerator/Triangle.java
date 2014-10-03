package com.gannon.asm.classgenerator;

public class Triangle {
	
	//infeasible path 2,3,4,9
	public int triangleType(int a, int b, int c) {
		if ((a < b + c) && (b < a + c) && (c < a + b)) {
			if ((a == b) && (b == c))
				return 1;
			else if (a != b && a != c && b != c)
				return 2;
			else
				return 3;
		} else {
			return 4;
		}
	}
	
	
	public int triangleTypeHasTempVars(int a, int b, int c) {
		int k;
		if ((a < b + c) && (b < a + c) && (c < a + b)) {
			if ((a == b) && (b == c))
			{
				k = a+b;
				c=k;
				return 1;
			}
			else if (a != b && a != c && b != c)
				return 2;
			else{
				k = a+b;
				b=k+2;
				return 3;
			}
		} else {
			return 4;
		}
	}
	
	
	

	public int hasInfeasiblepath(int a) {
		int b = 1;
		int c = 2;
		int d = 3;
		if(b>c){
			d = a + b;
		}
		d = a + c;
		return d;
	}
	
	public int test2(int a,int b, int c) {
		int d = 3;
		int e=3;
		if(b>c){
			d = a + b;
		}
		d = a + c;
		return d;
	}
	
	public int test3(int a,int b, int c,int f) {
		int d = 3;
		int e=3;
		if(b>c){
			d = a + b;
		}
		d = a + c;
		return d;
	}

//	public int test(int score) {
//		int result=0;
//		if (score >= 300) {
//			result=1;
//		} else if (score >= 200) {
//			result=2;
//		} else if (score >= 50) {
//			result=3;
//		} else {
//			result=4;
//		}
//		return result;
//	}

}
