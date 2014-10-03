package com.gannon.jvm.path.infeasible;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gannon.jvm.data.dependency.BinNode;

public class FEdgeData {
	private Map<BinNode, InfeasibleDetectData> leftMap;
	private Map<BinNode, InfeasibleDetectData> rightMap;

	public FEdgeData(Map<BinNode, InfeasibleDetectData> leftMap,
			Map<BinNode, InfeasibleDetectData> rightMap) {
		super();
		this.leftMap = leftMap;
		this.rightMap = rightMap;
	}

	public boolean hasCommonNodes() {
		Collection<BinNode> insectionSet = new HashSet<BinNode>(
				leftMap.keySet());
		insectionSet.containsAll(rightMap.keySet());
		return !insectionSet.isEmpty() && (!leftMap.isEmpty())
				&& (!rightMap.isEmpty());
	}

	public boolean hasSameBinNodes() {
		return leftMap.keySet().equals(rightMap.keySet())
				&& (!leftMap.isEmpty()) && (!rightMap.isEmpty());
	}

	//get intersection of left and right sets
	public Collection<BinNode> getCommonNodes() {
		Collection<BinNode> insectionSet = new HashSet<BinNode>(
				leftMap.keySet());
		insectionSet.retainAll(rightMap.keySet());
		return insectionSet;
	}

	// mark both maps of left and right flags
	public void markUsedFlags() {
		Collection<BinNode> commonNodes = getCommonNodes();
		for (BinNode key : commonNodes) {
			leftMap.get(key).setUsed(true);
			rightMap.get(key).setUsed(true);
		}
	}

	public boolean isConflict() {
		if (!hasCommonNodes()) {
			return false;
		}
		for (BinNode node : getCommonNodes()) {
			InfeasibleDetectData leftData = leftMap.get(node);
			InfeasibleDetectData rightData = rightMap.get(node);
			if (!leftData.isConflict(rightData)) {
				return false;
			}

		}
		return true;
	}

	@Override
	public String toString() {
		return "FEdgeData [leftMap=" + leftMap + ", rightMap=" + rightMap + "]";
	}
}
