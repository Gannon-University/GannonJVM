package com.gannon.jvm.path.infeasible.rules;

import java.util.Map;

import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.data.dependency.Dependency;
import com.gannon.jvm.instructions.BIAdd;
import com.gannon.jvm.instructions.BInstruction;
import com.gannon.jvm.path.infeasible.InfeasibleDetectData;
import com.gannon.jvm.path.infeasible.Trend;

public abstract class TrendRule {
	BinNode leftNode;
	BinNode rightNode;
	Dependencies dependecies;
	Map<BinNode, InfeasibleDetectData> detectDataCollectMap;

	public TrendRule(Dependencies dependecies, BinNode leftNode, BinNode rightNode, Map<BinNode, InfeasibleDetectData> detectDataCollectMap) {
		super();
		this.dependecies = dependecies;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.detectDataCollectMap= detectDataCollectMap;
	}

	public abstract void updating();
	
	protected void updateCurrentTrend(BinNode node, Trend direction) {
		if (node.isParamter()) {
			detectDataCollectMap.put(node, new InfeasibleDetectData(direction));
		} else {
			// recursively find next node
			Dependency d = this.dependecies.findRelation(node);
			//System.out.println(dependecies);
			//System.out.println("node" +node.getVariableName());
			BInstruction i = d.getInst();
			if (i!=null && i instanceof BIAdd) {
				TrendRule addObj = new TrendRuleIAdd(direction, this.dependecies, d.getLeftNode(),d.getRightNode(), detectDataCollectMap );
				addObj.updating();
			}
		}
	} 
}
