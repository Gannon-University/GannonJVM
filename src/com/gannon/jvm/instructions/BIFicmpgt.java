/**
 *
 */
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

/**
 * @author Pratik
 *
 */
public class BIFicmpgt extends BPredicateInstruction {
	public BIFicmpgt(BLabel label, int lineNumber) {
		super(label, lineNumber);
	}

	@Override
	public Object execute(BFrame activeFrame) {
		Stack<BLocalVariable> myOperandStack = activeFrame.getOperandStack();

		// next instruction will be fetched for execution
		Integer pc = activeFrame.getLineNumber();

		BLocalVariable secondValue = (BLocalVariable) myOperandStack.pop();
		BLocalVariable  firstValue= (BLocalVariable) myOperandStack.pop();

		boolean predicateResult = false;
		if (firstValue.desc.equals("I") && secondValue.desc.equals("I")) {
			predicateResult = ((Integer) firstValue.getValue()).intValue() > ((Integer) (secondValue
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
					.println("BIFicmpge excution method inputs are not integer type. ");
		}

		return predicateResult;
	}

	@Override
	public String toString() {
		//System.out.println("tostring");
		return super.toString() + " " + getOperand();
	}

	@Override
	public int getOpcode() {
		return 163;
	}

	//
	@Override
	public void analyzing(DependencyFrame rFrame) {
		Stack<BLocalVariable> myOperandStack = rFrame.getOperandStack();
		BLocalVariable secondValue = myOperandStack.pop();
		BLocalVariable firstValue = myOperandStack.pop();
		boolean predicateResult = (Integer) firstValue.getValue() > (Integer) (secondValue.getValue());

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
		BLocalVarTable myLocalVariableTable = pathFrame.getLocalVariableTable();

		BLocalVariable secondValue = (BLocalVariable) myOperandStack.pop();
		BLocalVariable  firstValue= (BLocalVariable) myOperandStack.pop();

		boolean  predicateResult = ((Integer) firstValue.getValue()).intValue() > ((Integer) (secondValue
				.getValue())).intValue();

		return predicateResult;
	}
}
