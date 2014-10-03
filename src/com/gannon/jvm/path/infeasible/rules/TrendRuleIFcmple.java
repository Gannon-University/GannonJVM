package com.gannon.jvm.path.infeasible.rules;

import java.util.Map;

import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.path.infeasible.InfeasibleDetectData;
import com.gannon.jvm.path.infeasible.Trend;

public class TrendRuleIFcmple extends TrendRule {
	private boolean expectedPredicateResult;
	
	public TrendRuleIFcmple(boolean expectedPredicateResult, Dependencies dependecies, BinNode leftNode, BinNode rightNode,Map<BinNode, InfeasibleDetectData> detectDataCollectMap){
		super(dependecies, leftNode, rightNode, detectDataCollectMap);
		this.expectedPredicateResult = expectedPredicateResult;   
	} 

	@Override
	public void updating() {
		if (expectedPredicateResult) {
			updateCurrentTrend(this.rightNode, Trend.INCREASE);
			updateCurrentTrend(this.leftNode, Trend.DECREASE);
		}else{
			updateCurrentTrend(this.leftNode, Trend.INCREASE);
			updateCurrentTrend(this.rightNode, Trend.DECREASE);
		}
	}
}
