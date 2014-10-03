package com.gannon.asm.classgenerator;

public class NextDate {
	public static int nextDate(int m,  int d, int y){
		if ((m == 1) || (m == 3) || (m == 5) || (m == 7) || (m == 8)
				|| (m == 10)) {
			if (d < 31) {
				return 1;
			} else {
				return 2;
			}
		} else if ((m == 4) || (m == 6) || (m == 9) || (m == 11)) {
			if (d < 30) {
				return 3;
			} 
			else{
				return 4;
			}
		} else if (m == 12) {
			if (d < 31) {
				return 5;
			} else {
				return 6;
			}
		} else if(m ==2){
			if (d < 28) {
				return 7;
			} else if (d == 28) {
				if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
					return 8;
				} else {
					return 9;
				}
			} else if(d == 29){
				if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
					return 10;
				} else {
					return 11;
				}
			}
			else{
				return 12;
			}
		}else{
			return 13;
		}
	}
}
