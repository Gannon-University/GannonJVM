package com.gannon.jvm.instructions;

import java.util.Stack;

import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.dependency.DependencyFrame;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.path.PathFrame;

public class BIConst_0 extends BInstruction {
	
	public BIConst_0(int lineNumber) {
		super(lineNumber);
	}

	@Override
	public Object execute(BFrame activeFrame) {
		Stack<BLocalVariable> myOperandStack = activeFrame.getOperandStack();
		Integer pc = activeFrame.getLineNumber();
		
		Integer zero=new Integer(0);
		BLocalVariable locaVarWith0=new BLocalVariable("","I",null,null, null,1,zero);
		myOperandStack.push(locaVarWith0);
		activeFrame.setLineNumber(++pc);
		return null;
	}

	@Override
	public int getOpcode() {
		return 3;
	}

	public Integer getOperand() {
		return 0;
	}

	@Override
	public void analyzing(DependencyFrame fFrame) {
		Stack<BLocalVariable> myOperandStack = fFrame.getOperandStack();
		int zero=0;
		BLocalVariable locaVarWith0=new BLocalVariable("","I",null,null, null,1,zero);
		myOperandStack.push(locaVarWith0);
	}

	@Override
	public Object execute(PathFrame pathFrame) {
		Stack<BLocalVariable> myOperandStack = pathFrame.getOperandStack();
		int zero=0;
		BLocalVariable locaVarWith0=new BLocalVariable("","I",null,null, null,1,zero);
		myOperandStack.push(locaVarWith0);
		return null;
	}

}
