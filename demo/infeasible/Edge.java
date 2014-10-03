package com.gannon.infeasible;

public class Edge {
	private int id;
	private Node source;
	private Node target;
	private EdgeData data;

	public boolean isConflict() {
		return data.isConflict();
	}

}
