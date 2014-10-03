package com.gannon.jvm.path.infeasible;

import java.util.Collection;

import com.gannon.jvm.data.dependency.BinNode;

public class FEdge {
	private final int id;
	private FEdgeData data;

	public FEdge(final int id) {
		super();
		this.id = id;
	}

	public FEdge(final int id, FEdgeData data) {
		this.id = id;
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		FEdge other = (FEdge) obj;
		if (this.id != other.id) {
			return false;
		}
		return true;
	}

	public FEdgeData getData() {
		return data;
	}

	public void setData(FEdgeData data) {
		this.data = data;
	}
	
	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	} 

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.id;
	}

	@Override
	public String toString() {
		return "[" + data + "]";
	}
	
	public boolean isConflict(){
		return data.isConflict();
	}
	
	public boolean hasCommonNodes() {
		return data.hasCommonNodes();
	}
	
	public Collection<BinNode> getCommonNodes(){
		return data.getCommonNodes();
	}
	
	public void markUsedFlags(){
		data.markUsedFlags();
	}
}
