package com.gannon.infeasible;

public class Parameter {
	private String name;
	private Trends trend1=Trends.NONE;
	private Trends trend2=Trends.NONE;
	
	public boolean isConflict(){
		return trend1.equals(Trends.DEC) &&trend2.equals(Trends.INC);//add more
	}

}
