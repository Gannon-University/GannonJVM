package com.gannon.rule;

import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.data.input.Input;
import com.gannon.jvm.data.input.InputCollection;
import com.gannon.jvm.utilities.ConstantsUtility;
import com.gannon.jvm.utilities.Utility;

public class RuleIFcmpge extends Rule {
	private int distance = 0;
	private boolean expectedPredicateResult;

	public RuleIFcmpge(boolean expectedPredicateResult, Input inputData, Dependencies dependecies, BinNode leftNode, BinNode rightNode, InputCollection inputs) {
		super(inputData, dependecies, leftNode, rightNode, inputs);
		this.expectedPredicateResult = expectedPredicateResult;
		this.distance = distance();
	}

	@Override
	public void dataGeneration() {
		// make sure left > right, we can set it as 1. Here we use a random
		// number instead
		int geDistance = Math.abs(this.distance) + Utility.getRandomInt(1, ConstantsUtility.RANGE_MAX);
		try {
			if (expectedPredicateResult) {
				// increase left
				updateCurrentInput(this.leftNode, this.inputData, true, geDistance);
				// decrease right
				updateCurrentInput(this.rightNode, this.inputData, false, geDistance);
			} else {
				// decrease left
				updateCurrentInput(this.leftNode, this.inputData, false, geDistance+1);
				// increase right
				updateCurrentInput(this.rightNode, this.inputData, true, geDistance+1);
			}
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int distance() {
		return (Integer) leftNode.getLocalVariable().getValue() - (Integer) rightNode.getLocalVariable().getValue();
	}
}
