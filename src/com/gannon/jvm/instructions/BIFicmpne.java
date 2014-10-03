package com.gannon.jvm.instructions;

import java.util.Stack;

import org.objectweb.asm.Type;

import com.gannon.asm.components.BLabel;
import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.BinPredicateNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.data.dependency.Dependency;
import com.gannon.jvm.data.dependency.DependencyFrame;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.method.BLocalVarTable;
import com.gannon.jvm.execution.path.PathFrame;
import com.gannon.jvm.utilities.OpcodeUtility;

public class BIFicmpne extends BPredicateInstruction {
	public BIFicmpne(BLabel label, int lineNumber) {
		super(label, lineNumber);
	}

	@Override
	public Object execute(BFrame activeFrame) {
		Stack<BLocalVariable> myOperandStack = activeFrame.getOperandStack();
		Integer programCounter = activeFrame.getLineNumber();

		BLocalVariable secondValue =  myOperandStack.pop();
		BLocalVariable firstValue =  myOperandStack.pop();

		boolean predicateResult =((Integer) firstValue.getValue()).intValue() != ((Integer) (secondValue
				.getValue())).intValue();
		if (predicateResult) {
			programCounter = getOperand().getGoToLineNumber();
			activeFrame.setLineNumber(programCounter);
		} else {
			myOperandStack.clear();
			++programCounter;
		}

		activeFrame.setLineNumber(programCounter);
		return predicateResult;
	}

	@Override
	public String toString() {
		return super.toString() + " " + getOperand();
	}

	@Override
	public int getOpcode() {
		return 160;
	}

	@Override
	public void analyzing(DependencyFrame rFrame) {
		Stack<BLocalVariable> myOperandStack = rFrame.getOperandStack();
		BLocalVariable secondValue = myOperandStack.pop();
		BLocalVariable firstValue = myOperandStack.pop();
		boolean predicateResult =((Integer) firstValue.getValue()).intValue() != ((Integer) (secondValue
				.getValue())).intValue();

		// build relations
		BinNode rightNode = new BinNode(secondValue.index, secondValue);
		BinNode leftNode = new BinNode(firstValue.index, firstValue);

		//need to create a unique ID
		int nodeID = OpcodeUtility.getNextID();
		BLocalVariable result = new BLocalVariable("Return", Type.BOOLEAN_TYPE.getDescriptor(), null, null, null, nodeID, predicateResult);
		BinNode rootNode = new BinPredicateNode(nodeID, result);
		Dependency relation = new Dependency(rootNode, this);
		relation.insertToLeft(leftNode);
		relation.insertToRight(rightNode);

		// Dr. Xu: expend the relation to a complete VDT
		Dependencies relations = rFrame.getRelations();
		relations.expendTheRelations(relation);
		// after expending, add the VDT to the relations
		relations.add(relation);
	}

	@Override
	public Object execute(PathFrame pathFrame) {
		Stack<BLocalVariable> myOperandStack = pathFrame.getOperandStack();

		BLocalVariable secondValue =  myOperandStack.pop();
		BLocalVariable firstValue =  myOperandStack.pop();

		boolean predicateResult =((Integer) firstValue.getValue()).intValue() != ((Integer) (secondValue
				.getValue())).intValue();

		return predicateResult;
	}

}
