package com.gannon.rule;

import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.data.dependency.Dependency;
import com.gannon.jvm.data.input.Input;
import com.gannon.jvm.data.input.InputCollection;
import com.gannon.jvm.instructions.BInstruction;
import com.gannon.jvm.instructions.BIAdd;

public abstract class Rule {
	// protected boolean expectedPredicateResult;
	Input inputData;
	Dependencies dependecies;
	BinNode leftNode;
	BinNode rightNode;

	InputCollection inputs = new InputCollection(1);

	public InputCollection getInputCollection() {
		return inputs;
	}

	public Rule(Input inputData, Dependencies dependecies, BinNode leftNode, BinNode rightNode, InputCollection inputs) {
		super();
		// this.expectedPredicateResult = result;
		this.inputData = inputData;
		this.dependecies = dependecies;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.inputs = inputs;
	}

	public abstract void dataGeneration() throws CloneNotSupportedException; 

	/**
	 *
	 * @param input
	 * @param increaseFlag
	 *            true increase, false decrease
	 * @param distance
	 *            TODO
	 * @param Node
	 * @return
	 *
	 *         This is a recursive function
	 * @throws CloneNotSupportedException  
	 */

	protected void updateCurrentInput(BinNode node, Input input, Boolean increaseFlag, int distance) throws CloneNotSupportedException {
		if (node.isParamter()) {
			int index = node.getVariableName();
			Input cloned = null;
			if (increaseFlag) {
				cloned = (Input)input.clone();
				BLocalVariable p=cloned.getParameterByIndex(index);
				cloned.updateParameterValue(index, (Integer)p.getValue() + Math.abs(distance));
			} else {
				cloned = (Input)input.clone();
				BLocalVariable p=cloned.getParameterByIndex(index);
				cloned.updateParameterValue(index, (Integer)p.getValue() - Math.abs(distance));
			}
			inputs.add(cloned);
		} else {
			// recursively find next node
			Dependency d = this.dependecies.findRelation(node);
			BInstruction i = d.getInst();
			if (i instanceof BIAdd) {
				RuleIAdd addObj = new RuleIAdd(increaseFlag, inputData, this.dependecies, d.getLeftNode(),
						d.getRightNode(), this.inputs, Math.abs(distance));
				addObj.dataGeneration();
			}
		}
	} 
}
