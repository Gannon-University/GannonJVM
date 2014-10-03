package com.gannon.jvm.instructions;

import java.util.Stack;

import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.data.dependency.Dependency;
import com.gannon.jvm.data.dependency.DependencyFrame;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.path.PathFrame;
import com.gannon.jvm.utilities.OpcodeUtility;

public class BIConst_5 extends BInstruction {

	public BIConst_5(int lineNumber) {
		super(lineNumber);
    }

    @Override
	public Object execute(BFrame activeFrame) {
		Stack<BLocalVariable> myOperandStack = activeFrame.getOperandStack();
		Integer pc = activeFrame.getLineNumber();
		
		Integer five=new Integer(5);
		BLocalVariable locaVarWith5=new BLocalVariable("","I",null,null, null,1,five);
		myOperandStack.push(locaVarWith5);
		activeFrame.setLineNumber(++pc);
		return null;
    }

    @Override
	public int getOpcode() {
        return 8;
    }

    public Integer getOperand(){
		return 5;
	}

	@Override
	public void analyzing(DependencyFrame fFrame) {
		Stack<BLocalVariable> myOperandStack = fFrame.getOperandStack();
		
		Integer five=new Integer(5);
		BLocalVariable locaVarWith5=new BLocalVariable("","I",null,null, null,1,five);
		myOperandStack.push(locaVarWith5);
	}
	
	@Override
	public Object execute(PathFrame pathFrame) {
		Stack<BLocalVariable> myOperandStack = pathFrame.getOperandStack();
		
		Integer five=new Integer(5);
		BLocalVariable locaVarWith5=new BLocalVariable("","I",null,null, null,1,five);
		myOperandStack.push(locaVarWith5);
		return null;
	}

}
