package com.gannon.jvm.instructions;

import java.util.Stack;

import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.dependency.DependencyFrame;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.path.PathFrame;
import com.gannon.jvm.utilities.ConstantsUtility;

public class BIConst_1 extends BInstruction {

	public BIConst_1(int lineNumber) {
		super(lineNumber);
	}

	@Override
	public Object execute(BFrame activeFrame) {
		Stack<BLocalVariable> myOperandStack = activeFrame.getOperandStack();
		Integer pc = activeFrame.getLineNumber();
		
		Integer one=new Integer(1);
		BLocalVariable locaVarWithOne=new BLocalVariable("","I",null,null, null,ConstantsUtility.UNDEFINED_VAR_ID,one);
		myOperandStack.push(locaVarWithOne);
		activeFrame.setLineNumber(++pc);
		return null;
	}

	@Override
	public int getOpcode() {
		return 04;
	}

	public Integer getOperand() {
		return 1;
	}

	@Override
	public void analyzing(DependencyFrame fFrame) {
		Stack<BLocalVariable> myOperandStack = fFrame.getOperandStack(); 
		Integer one=new Integer(1);
		BLocalVariable locaVarWithOne=new BLocalVariable("","I",null,null, null,1,one);
		myOperandStack.push(locaVarWithOne);
	}

	@Override
	public Object execute(PathFrame pathFrame) {
		Stack<BLocalVariable> myOperandStack = pathFrame.getOperandStack();
		Integer one=new Integer(1);
		BLocalVariable locaVarWithOne=new BLocalVariable("","I",null,null, null,1,one);
		myOperandStack.push(locaVarWithOne);
		return null;
	}

}
