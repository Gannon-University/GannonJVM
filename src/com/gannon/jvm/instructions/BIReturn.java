package com.gannon.jvm.instructions;

import java.util.Stack;

import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.dependency.DependencyFrame;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.path.PathFrame;
import com.gannon.jvm.utilities.OpcodeUtility;

public class BIReturn extends Return {

	public BIReturn(int lineNumber) {
		super(lineNumber);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public BLocalVariable execute(BFrame activeFrame) {
		Stack<BLocalVariable> myOperandStack = activeFrame.getOperandStack();
		//-1 means the end of the instructions??
		activeFrame.setLineNumber(OpcodeUtility.END_INSTRUCTION_FLAG);
		BLocalVariable returnedValue = myOperandStack.pop();
		return returnedValue;
	}

	@Override
	public int getOpcode() {
		return 172;
	}

	@Override
	public void analyzing(DependencyFrame rFrame) {
		//System.out.println(rFrame.getIntermediateVariableStack());
//		Stack<String> intermediateStack = rFrame.getIntermediateVariableNameStack();
//		intermediateStack.pop();
//
//		Stack<Object> myOperandStack = rFrame.getOperandStack();
//		myOperandStack.pop();
	}

	@Override
	public Object execute(PathFrame pathFrame) {
		Stack<BLocalVariable> myOperandStack = pathFrame.getOperandStack();

		return myOperandStack.pop();
	}
}
