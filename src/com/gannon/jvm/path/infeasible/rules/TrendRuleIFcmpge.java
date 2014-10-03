package com.gannon.jvm.path.infeasible.rules;

import java.util.Map;

import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.path.infeasible.InfeasibleDetectData;
import com.gannon.jvm.path.infeasible.Trend;

public class TrendRuleIFcmpge extends TrendRule {
	private boolean expectedPredicateResult;

	public TrendRuleIFcmpge(boolean expectedPredicateResult,
			Dependencies dependecies, BinNode leftNode, BinNode rightNode,
			Map<BinNode, InfeasibleDetectData> detectDataCollectMap) {
		super(dependecies, leftNode, rightNode, detectDataCollectMap);
		this.expectedPredicateResult = expectedPredicateResult;
	}

	@Override
	public void updating() {
		if (expectedPredicateResult) {
			// case a>=b, True
			// increase left
			// System.out.println("RuleIFcmpgt: Expected result to fulfil: "+expectedPredicateResult);
			updateCurrentTrend(this.leftNode, Trend.INCREASE);
			// decrease right
			updateCurrentTrend(this.rightNode, Trend.DECREASE);
		} else {
			// System.out.println("RuleIFcmpgt: Expected result to fulfil: "+expectedPredicateResult);
			// case a>=b, False
			// decrease left
			updateCurrentTrend(this.leftNode, Trend.DECREASE);
			// increase right
			updateCurrentTrend(this.rightNode, Trend.INCREASE);
		}
	}
}
