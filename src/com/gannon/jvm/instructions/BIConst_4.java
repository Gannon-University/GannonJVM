package com.gannon.jvm.instructions;

import java.util.Stack;

import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.dependency.DependencyFrame;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.path.PathFrame;

public class BIConst_4 extends BInstruction {
	public BIConst_4(int lineNumber) {
		super(lineNumber);
	}

	@Override
	public Object execute(BFrame activeFrame) {
		Stack<BLocalVariable> myOperandStack = activeFrame.getOperandStack();
		Integer pc = activeFrame.getLineNumber();
		
		Integer four=new Integer(4);
		BLocalVariable locaVarWith4=new BLocalVariable("","I",null,null, null,1,four);
		myOperandStack.push(locaVarWith4);
		activeFrame.setLineNumber(++pc);
		return null;
	}

	@Override
	public int getOpcode() {
		return 7;
	}

	public Integer getOperand() {
		return 4;
	}

	@Override
	public void analyzing(DependencyFrame fFrame) {
		Stack<BLocalVariable> myOperandStack = fFrame.getOperandStack();
		
		Integer four=new Integer(4);
		BLocalVariable locaVarWith4=new BLocalVariable("","I",null,null, null,1,four);
		myOperandStack.push(locaVarWith4);
	}
	
	@Override
	public Object execute(PathFrame pathFrame) {
		Stack<BLocalVariable> myOperandStack = pathFrame.getOperandStack();
		
		Integer four=new Integer(4);
		BLocalVariable locaVarWith4=new BLocalVariable("","I",null,null, null,1,four);
		myOperandStack.push(locaVarWith4);
		return null;
	}

}
