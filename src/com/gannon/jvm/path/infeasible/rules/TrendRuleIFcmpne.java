package com.gannon.jvm.path.infeasible.rules;

import java.util.Map;

import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.path.infeasible.InfeasibleDetectData;
import com.gannon.jvm.path.infeasible.Trend;

public class TrendRuleIFcmpne extends TrendRule {
	private boolean expectedPredicateResult;

	public TrendRuleIFcmpne(boolean expectedPredicateResult,
			Dependencies dependecies, BinNode leftNode, BinNode rightNode, Map<BinNode, InfeasibleDetectData> detectDataCollectMap) {
		super(dependecies, leftNode, rightNode, detectDataCollectMap);
		this.expectedPredicateResult = expectedPredicateResult; 
	}

	@Override
	public void updating() {
		// a!=b
		if (expectedPredicateResult) {
			//System.out.println("RuleIFcmpeq: Expected result to fulfil: " + expectedPredicateResult);
			updateCurrentTrend(this.leftNode, Trend.CHANGE);
			updateCurrentTrend(this.rightNode, Trend.CHANGE);
		} else {
			// split logic
			// System.out.println("RuleIFcmpne: Unreachable code");
			updateCurrentTrend(this.leftNode, Trend.NO_CHANGE);
			updateCurrentTrend(this.rightNode, Trend.NO_CHANGE);
		}
	}
}
