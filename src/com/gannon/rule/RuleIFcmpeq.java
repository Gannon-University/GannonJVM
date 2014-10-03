package com.gannon.rule;

import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.data.input.Input;
import com.gannon.jvm.data.input.InputCollection;
import com.gannon.jvm.utilities.ConstantsUtility;
import com.gannon.jvm.utilities.Utility;

public class RuleIFcmpeq extends Rule {
	private int distance = 0;
	private boolean expectedPredicateResult;

	public RuleIFcmpeq(boolean expectedPredicateResult, Input inputData, Dependencies dependecies, BinNode leftNode, BinNode rightNode, InputCollection inputs) {
		super(inputData, dependecies, leftNode, rightNode, inputs);
		this.expectedPredicateResult = expectedPredicateResult;
		this.distance = distance();
	}

	@Override
	public void dataGeneration() {
		try {
			if (expectedPredicateResult) {
				// we want to force: left value = right values
				if (isLeftGreaterThanRight()) {
					// decrease left, true or false indicate increasing or
					// decreasing
					updateCurrentInput(this.leftNode, this.inputData, false, distance);
					// increase right
					updateCurrentInput(this.rightNode, this.inputData, true, distance);

				} else if (isRightGreaterThanLeft()) {
					// increase left
					updateCurrentInput(this.leftNode, this.inputData, true, distance);
					// decrease right
					updateCurrentInput(this.rightNode, this.inputData, false, distance);
				}
			} else {
				// Generate new data so that left value != right values
				this.distance = Utility.getRandomInt(1, ConstantsUtility.RANGE_MAX);
				// increase left
				updateCurrentInput(this.leftNode, this.inputData, true, distance);
				// decrease left
				updateCurrentInput(this.leftNode, this.inputData, false, distance);
				// increase right
				updateCurrentInput(this.rightNode, this.inputData, true, distance);
				// decrease right
				updateCurrentInput(this.rightNode, this.inputData, false, distance);
			}
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private int distance() {
		return (Integer) leftNode.getLocalVariable().getValue() - (Integer) rightNode.getLocalVariable().getValue();
	}

	private boolean isLeftGreaterThanRight() {
		return distance() > 0 ? true : false;
	}

	private boolean isRightGreaterThanLeft() {
		return distance() < 0 ? true : false;
	}

}
