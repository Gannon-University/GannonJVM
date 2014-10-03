package com.gannon.jvm.instructions;

import java.util.Stack;

import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.dependency.DependencyFrame;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.path.PathFrame;

public class BIConst_3 extends BInstruction {

	public BIConst_3(int lineNumber) {
		super(lineNumber);
	}

	@Override
	public Object execute(BFrame activeFrame) {
		Stack<BLocalVariable> myOperandStack = activeFrame.getOperandStack();
		Integer pc = activeFrame.getLineNumber();
		
		Integer three=new Integer(3);
		BLocalVariable locaVarWith3=new BLocalVariable("","I",null,null, null,1,three);
		myOperandStack.push(locaVarWith3);
		activeFrame.setLineNumber(++pc);
		return null;
	}

	@Override
	public int getOpcode() {
		return 6;
	}

	public Integer getOperand() {
		return 3;
	}

	@Override
	public void analyzing(DependencyFrame fFrame) {
		Stack<BLocalVariable> myOperandStack = fFrame.getOperandStack();
		Integer three=new Integer(3);
		BLocalVariable locaVarWith3=new BLocalVariable("","I",null,null, null,1,three);
		myOperandStack.push(locaVarWith3);
	}

	@Override
	public Object execute(PathFrame pathFrame) {
		Stack<BLocalVariable> myOperandStack = pathFrame.getOperandStack();
		Integer three=new Integer(3);
		BLocalVariable locaVarWith3=new BLocalVariable("","I",null,null, null,1,three);
		myOperandStack.push(locaVarWith3);
		return null;
	}

}
