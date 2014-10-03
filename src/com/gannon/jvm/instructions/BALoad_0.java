package com.gannon.jvm.instructions;

import java.util.Stack;

import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.dependency.DependencyFrame;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.method.BLocalVarTable;
import com.gannon.jvm.execution.path.PathFrame;

//load a reference onto the stack from local variable 0
public class BALoad_0 extends BInstruction {
	public boolean debug = true;

	public BALoad_0(int lineNumber) {
		super(lineNumber);
	} 

	@Override
	public Object execute(BFrame activeFrame) {
		int operand1=0;
		Stack<BLocalVariable> myOperandStack = activeFrame.getOperandStack();
		BLocalVarTable myLocalVariableTable = activeFrame.getLocalVariableTable();
		Integer pc = activeFrame.getLineNumber();

		myOperandStack.push(myLocalVariableTable.getLocalVariableByIndex(operand1));
		activeFrame.setLineNumber(++pc);
		return null;
	}

	@Override
	public String toString() {
		return super.toString() ;
	}

	@Override
	public int getOpcode() {
		return 26;
	}

	@Override
	public void analyzing(DependencyFrame dependency) {
//		Stack<String> myOperandStack =dependency.getIntermediateVariableNameStack();
//		myOperandStack.add(new Integer(getOperand()).toString());
	}

	@Override
	public Object execute(PathFrame pathFrame) {
		int operand1=0;
		Stack<BLocalVariable> myOperandStack = pathFrame.getOperandStack();
		BLocalVarTable myLocalVariableTable = pathFrame.getLocalVariableTable();

		myOperandStack.push(myLocalVariableTable.getLocalVariableByIndex(operand1));
		return null;
	}
}
