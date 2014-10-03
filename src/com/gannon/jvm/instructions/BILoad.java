package com.gannon.jvm.instructions;

import java.util.Stack;

import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.dependency.DependencyFrame;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.method.BLocalVarTable;
import com.gannon.jvm.execution.path.PathFrame;

public class BILoad extends BInstruction {
	private int operand1;

	public BILoad(int operand1, int lineNumber) {
		super(lineNumber);
		this.operand1 = operand1;
	}

	@Override
	public String toString() {
		return super.toString() + " " + getOperand();
	}

	@Override
	public Object execute(BFrame activeFrame) {
		BLocalVarTable myLocalVariableTable = activeFrame.getLocalVariableTable();
		Stack<BLocalVariable> operandStack = activeFrame.getOperandStack();

		Integer pc = activeFrame.getLineNumber();
		// push local value to top of stack
		operandStack.push(myLocalVariableTable.getLocalVariableByIndex(operand1));

		// point to next instruction
		activeFrame.setLineNumber((++pc));
		return null;
	}

	@Override
	public int getOpcode() {
		return 21;
	}

	public Integer getOperand() {
		return operand1;
	}

	@Override
	public void analyzing(DependencyFrame rFrame) {
		BLocalVarTable myLocalVariableTable = rFrame.getLocalVariableTable();
		Stack<BLocalVariable> operandStack = rFrame.getOperandStack();

		// push local value to top of stack
		operandStack.push(myLocalVariableTable.getLocalVariableByIndex(operand1));
	}

	@Override
	public Object execute(PathFrame pathFrame) {
		BLocalVarTable myLocalVariableTable = pathFrame.getLocalVariableTable();
		Stack<BLocalVariable> operandStack = pathFrame.getOperandStack();

		// push local value to top of stack
		operandStack.push(myLocalVariableTable.getLocalVariableByIndex(operand1));
		return null;
	}
}
