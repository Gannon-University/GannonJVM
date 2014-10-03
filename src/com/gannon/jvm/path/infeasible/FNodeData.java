package com.gannon.jvm.path.infeasible;

import java.util.HashMap;
import java.util.Map;

import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.data.dependency.Dependency;
import com.gannon.jvm.data.dependency.PredicateResult;
import com.gannon.jvm.instructions.BIFicmpeq;
import com.gannon.jvm.instructions.BIFicmpge;
import com.gannon.jvm.instructions.BIFicmpgt;
import com.gannon.jvm.instructions.BIFicmple;
import com.gannon.jvm.instructions.BIFicmplt;
import com.gannon.jvm.instructions.BIFicmpne;
import com.gannon.jvm.instructions.BInstruction;
import com.gannon.jvm.path.infeasible.rules.TrendRule;
import com.gannon.jvm.path.infeasible.rules.TrendRuleIFcmpeq;
import com.gannon.jvm.path.infeasible.rules.TrendRuleIFcmpge;
import com.gannon.jvm.path.infeasible.rules.TrendRuleIFcmpgt;
import com.gannon.jvm.path.infeasible.rules.TrendRuleIFcmple;
import com.gannon.jvm.path.infeasible.rules.TrendRuleIFcmplt;
import com.gannon.jvm.path.infeasible.rules.TrendRuleIFcmpne;

public class FNodeData {
	private Dependency dependency;
	private Map<BinNode, InfeasibleDetectData> detectDataCollectMap=new HashMap<BinNode, InfeasibleDetectData>();

	public FNodeData(Dependency dependency) {
		super();
		this.dependency = dependency;
	}

	public Dependency getDependency() {
		return dependency;
	}

	public void setDependency(Dependency dependency) {
		this.dependency = dependency;
	}

	public void clearIsUsedFlags() {
		if (detectDataCollectMap != null) {
			for (BinNode key : detectDataCollectMap.keySet()) {
				detectDataCollectMap.get(key).setUsed(false);
			}
		}
	}

	public boolean isAllUsed() {
		if (detectDataCollectMap != null) {
			for (BinNode key : detectDataCollectMap.keySet()) {
				if (!detectDataCollectMap.get(key).isUsed()) {
					return false;
				}
			}
		}
		return true;
	}

	// need to be tested
	public Map<BinNode, InfeasibleDetectData> applyTrendRules(Dependencies dps) {
		TrendRule rule = null;
		BInstruction instruction = dependency.getInst();
		PredicateResult result = dependency.getExpectedPredicateResult();
		BinNode leftNode = dependency.getLeftNode();
		BinNode rightNode = dependency.getRightNode();
		boolean expectedPredicateResult = result == PredicateResult.TRUE ? true
				: false;

		if (instruction instanceof BIFicmpge) {
			rule = new TrendRuleIFcmpge(expectedPredicateResult, dps, leftNode,
					rightNode, detectDataCollectMap);
		} else if (instruction instanceof BIFicmpne) {
			rule = new TrendRuleIFcmpne(expectedPredicateResult, dps, leftNode,
					rightNode, detectDataCollectMap);
		} else if (instruction instanceof BIFicmpeq) {
			rule = new TrendRuleIFcmpeq(expectedPredicateResult, dps, leftNode,
					rightNode, detectDataCollectMap);
		} else if (instruction instanceof BIFicmpgt) {
			rule = new TrendRuleIFcmpgt(expectedPredicateResult, dps, leftNode,
					rightNode, detectDataCollectMap);
		} else if (instruction instanceof BIFicmplt) {
			rule = new TrendRuleIFcmplt(expectedPredicateResult, dps, leftNode,
					rightNode, detectDataCollectMap);
		} else if (instruction instanceof BIFicmple) {
			rule = new TrendRuleIFcmple(expectedPredicateResult, dps, leftNode,
					rightNode, detectDataCollectMap);
		} else {
			System.out
					.println("No Trend Rule is found. You need to impelement more trend rules!");
		}
		rule.updating();
		return detectDataCollectMap;
	}

	public Map<BinNode, InfeasibleDetectData> getDetectDataCollectMap(
			Dependencies dps) {
		if (detectDataCollectMap == null) {
			applyTrendRules(dps);
		}
		return detectDataCollectMap;
	}

	@Override
	public String toString() {
		return " FNodeData [dependency=" + dependency + "] ";
	}

	public boolean containsSameLeaves(FNodeData data) {
		return dependency.containsSameLeaves(data.getDependency());
	}
}
