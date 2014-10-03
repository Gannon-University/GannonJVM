package com.gannon.asm.classgenerator;

//software testing book: page 346
public class Zodiac {
	int zodiacSign(int month, int day, int year) {
		int result = 0;
		if (month == 3 && day >= 21 || month == 4 && day <= 19) {
			result = 1;
		} else if (month == 4 || month == 5 && day <= 20) {
			result = 2;
		} else if (month == 5 || month == 6 && day <= 20) {
			result = 3;
		} else {
			result = 4;
		}
		return result;
	}

	int zodiacSign2(int month, int day, int year) {
		int result = 0;
		if (month == 3 && day >= 21 || month == 4 && day <= 19) {
			result = 1;
		} else {
			result = 2;
		}
		return result;
	}

	int zodiacSign3(int month, int day, int year) {
		int result = 0;
		if (month == 3 && day >= 21) {
			result = 1;
		} else {
			result = 2;
		}
		return result;
	}

	int zodiacSign4(int month, int day, int year) {
		int result = 0;
		if (month == 3 && day >= 21) {
			result = 1;
		}
		return result;
	}
	
	int multiIf(int a, int b, int c){
		if(a>b)
			if(b>c)
				if(a>c)
					if(c>c)
						return 0;
		return 0;
	}
}
