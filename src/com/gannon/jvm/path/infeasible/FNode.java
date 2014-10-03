package com.gannon.jvm.path.infeasible;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;

public class FNode {
	private final int id;
	private FNodeData data;

	public FNode(final int id, FNodeData data) {
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
		FNode other = (FNode) obj;
		if (this.id != other.id) {
			return false;
		}
		return true;
	}

	
	/**
	 * @return the data
	 */
	public FNodeData getData() {
		return this.data;
	}

	
	public Map<BinNode, InfeasibleDetectData> getTrends(Dependencies dps) {
		return data.applyTrendRules(dps);
	}
	
	public void clearIsUsedFlags(){
		data.clearIsUsedFlags();
	}
	
	/**
	 * @return the id
	 */
	public final int getId() {
		return this.id;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FNode [id=" + this.id + "]" + data;
	}

	public boolean containsSameLeaves(FNode node) {
		return data.containsSameLeaves(node.getData());
	}
	
	
}
