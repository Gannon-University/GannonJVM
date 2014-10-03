package com.gannon.jvm.path.infeasible.rules;

import java.util.Map;

import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.path.infeasible.InfeasibleDetectData;
import com.gannon.jvm.path.infeasible.Trend;

public class TrendRuleIAdd extends TrendRule {
	private Trend direction;

	public TrendRuleIAdd(Trend direction, Dependencies dependecies,
			BinNode leftNode, BinNode rightNode, Map<BinNode, InfeasibleDetectData> detectDataCollectMap) {
		super(dependecies, leftNode, rightNode, detectDataCollectMap);
		this.direction = direction;
	}

	@Override
	public void updating() {
		updateCurrentTrend(this.leftNode, direction);
		updateCurrentTrend(this.rightNode, direction);
	}
}
