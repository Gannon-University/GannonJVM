package com.gannon.rule;

import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.data.input.Input;
import com.gannon.jvm.data.input.InputCollection;
import com.gannon.jvm.utilities.ConstantsUtility;
import com.gannon.jvm.utilities.Utility;

public class RuleIFcmpne extends Rule {
	private int distance = 0;
	boolean expectedPredicateResult;

	public RuleIFcmpne(boolean expectedPredicateResult, Input inputData, Dependencies dependecies, BinNode leftNode, BinNode rightNode, InputCollection inputs) {
		super(inputData, dependecies, leftNode, rightNode, inputs);
		this.expectedPredicateResult = expectedPredicateResult;
		this.distance = distance();
	}

	@Override
	public void dataGeneration() {
		try {
			if (expectedPredicateResult) {
				if (isLeftRightEqual()) {
					// current is == and we want to make left != right
					// increase left
					int randomNumber = Utility.getRandomInt(1, ConstantsUtility.RANGE_MAX);
					updateCurrentInput(this.leftNode, this.inputData, true, randomNumber);

					// decrease left
					randomNumber = Utility.getRandomInt(1, ConstantsUtility.RANGE_MAX);
					updateCurrentInput(this.leftNode, this.inputData, false, randomNumber);
					// increase right
					randomNumber = Utility.getRandomInt(1, ConstantsUtility.RANGE_MAX);
					updateCurrentInput(this.rightNode, this.inputData, true, randomNumber);
					// decrease right
					randomNumber = Utility.getRandomInt(1, ConstantsUtility.RANGE_MAX);
					updateCurrentInput(this.rightNode, this.inputData, false, randomNumber);
				}
			}
			// ==
			else {
				if (isLeftGreaterThanRight()) {
					// decrease left
					updateCurrentInput(this.leftNode, this.inputData, false, distance);
					// increase right
					updateCurrentInput(this.rightNode, this.inputData, true, distance);
				} else if (isRightGreaterThanLeft()) {
					// increase left
					updateCurrentInput(this.leftNode, this.inputData, true, distance);
					// decrease right
					updateCurrentInput(this.rightNode, this.inputData, false, distance);
				}
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

	private boolean isLeftRightEqual() {
		return distance() == 0 ? true : false;
	}
}
