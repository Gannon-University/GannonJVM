package com.gannon.asm.classgenerator;

public class TaxCaculator {
	
	public int getResult(int income,int deductable){
		int realIncome = income - deductable;
		if(realIncome < 0) return -1;
		else if(realIncome == 0) return 0;
		else if(realIncome < 60000) return (int) (60000*0.15);
		else if(realIncome < 70000) return (int) (60000*0.25);
		else  return (int) (60000*0.35);
	}
}
