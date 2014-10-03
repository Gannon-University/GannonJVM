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

public class BIFicmple extends BPredicateInstruction {

	public BIFicmple(BLabel label, int lineNumber) {
		super(label, lineNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object execute(BFrame activeFrame) {
		Stack<BLocalVariable> myOperandStack = activeFrame.getOperandStack();
		Integer pc = activeFrame.getLineNumber();

		BLocalVariable secondValue = myOperandStack.pop();
		BLocalVariable firstValue = myOperandStack.pop();

		boolean predicateResult = false;
		if (firstValue.desc.equals("I") && secondValue.desc.equals("I")) {
			predicateResult = ((Integer) firstValue.getValue()).intValue() <= ((Integer) (secondValue
					.getValue())).intValue();
			if (predicateResult) {
				pc = getOperand().getGoToLineNumber();
				activeFrame.setLineNumber(pc);
			} else {
				myOperandStack.clear();
				activeFrame.setLineNumber(++pc);
			}
		} else {
			System.err
					.println("BIFicmple excution method inputs are not integer type. ");
		}

		return predicateResult;
	}

	@Override
	public String toString() {
		return super.toString() + " " + getOperand();
	}

	@Override
	public Object execute(PathFrame pathFrame) {
		Stack<BLocalVariable> myOperandStack = pathFrame.getOperandStack();

		BLocalVariable secondValue = myOperandStack.pop();
		BLocalVariable firstValue = myOperandStack.pop();

		boolean predicateResult = false;
		if (firstValue.desc.equals("I") && secondValue.desc.equals("I")) {
			predicateResult = ((Integer) firstValue.getValue()).intValue() <= ((Integer) (secondValue
					.getValue())).intValue();
		} else {
			System.err
					.println("BIFicmple excution method inputs are not integer type. ");
		}

		return predicateResult;
	}

	@Override
	public int getOpcode() {
		// TODO Auto-generated method stub
		return 164;
	}

	@Override
	public void analyzing(DependencyFrame rFrame) {
		Stack<BLocalVariable> myOperandStack = rFrame.getOperandStack();
		BLocalVariable secondValue = myOperandStack.pop();
		BLocalVariable firstValue = myOperandStack.pop();
		boolean predicateResult = (Integer) firstValue.getValue() <= (Integer) (secondValue.getValue());

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

}
