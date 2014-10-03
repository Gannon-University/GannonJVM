package com.gannon.jvm.path.infeasible.rules;

import java.util.Map;

import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.path.infeasible.InfeasibleDetectData;
import com.gannon.jvm.path.infeasible.Trend;

public class TrendRuleIFcmpeq extends TrendRule {
	private boolean expectedPredicateResult;

	public TrendRuleIFcmpeq(boolean expectedPredicateResult,
			Dependencies dependecies, BinNode leftNode, BinNode rightNode,
			Map<BinNode, InfeasibleDetectData> detectDataCollectMap) {
		super(dependecies, leftNode, rightNode, detectDataCollectMap);
		this.expectedPredicateResult = expectedPredicateResult;
	}

	@Override
	public void updating() {
		//if equal, we really can't decide anything unless we know values
		if (expectedPredicateResult) {
			updateCurrentTrend(this.leftNode, Trend.NO_CHANGE);
			updateCurrentTrend(this.rightNode, Trend.NO_CHANGE);
		} else {
			updateCurrentTrend(this.leftNode, Trend.CHANGE);
			updateCurrentTrend(this.rightNode, Trend.CHANGE);
		}
	}
}
