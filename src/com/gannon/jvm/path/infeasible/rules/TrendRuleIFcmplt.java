package com.gannon.jvm.path.infeasible.rules;
import java.util.Map;

import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.path.infeasible.InfeasibleDetectData;
import com.gannon.jvm.path.infeasible.Trend;

public class TrendRuleIFcmplt extends TrendRule {
	private boolean expectedPredicateResult;
	
	public TrendRuleIFcmplt(boolean expectedPredicateResult, Dependencies dependecies, BinNode leftNode, BinNode rightNode, Map<BinNode, InfeasibleDetectData> detectDataCollectMap) {
		super(dependecies, leftNode, rightNode,detectDataCollectMap);
		this.expectedPredicateResult = expectedPredicateResult;
	} 

	@Override
	public void updating() {
		if (expectedPredicateResult) {
			//System.out.println("RuleIFcmplt: Expected result to fulfil: "+expectedPredicateResult);
			//case a<b, True
			// decrease left
			updateCurrentTrend(this.leftNode, Trend.DECREASE);
			// increase right
			updateCurrentTrend(this.rightNode, Trend.INCREASE);
		} else {
			//System.out.println("RuleIFcmplt: Expected result to fulfil: "+expectedPredicateResult);
			//case a<b, False
			// increase left
			updateCurrentTrend(this.leftNode, Trend.INCREASE);
			// decrease right
			updateCurrentTrend(this.rightNode, Trend.DECREASE);
		}
	}
}
