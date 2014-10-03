package com.gannon.jvm.instructions;

import java.util.Stack;

import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.data.dependency.Dependency;
import com.gannon.jvm.data.dependency.DependencyFrame;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.method.BLocalVarTable;
import com.gannon.jvm.execution.path.PathFrame;

public class BAStore extends BInstruction {
	private int operand1;

	public BAStore(int operand1, int lineNumber) {
		super(lineNumber);
		this.operand1 = operand1;
	}

	@Override
	public Object execute(BFrame activeFrame) {
		Stack<Integer> myOperandStack = activeFrame.getOperandStack();
		BLocalVarTable myLocalVariableTable = activeFrame.getLocalVariableTable();
		Integer pc = activeFrame.getLineNumber();

		Integer value = myOperandStack.pop(); // get the top of the operand
												// stack
		myLocalVariableTable.setValueAtIndex(operand1, value);// add the value on
													// localVariableTable
													// at the position defined
													// by operand1.
		activeFrame.setLineNumber(++pc);
		return null;
	}

	@Override
	public int getOpcode() {
		return 58;
	}

	@Override
	public String toString() {
		return super.toString() + " " + operand1;
	}

	public Object getOperand() {
		return operand1;
	}
	
	@Override
	public void analyzing(DependencyFrame rFrame) {
//		Stack<String> myOperandStack = dependency.getIntermediateVariableNameStack();
//		
//		//pop TOS 
//		myOperandStack.pop();
		
		Stack<BLocalVariable> myOperandStack = rFrame.getOperandStack();
		BLocalVarTable myLocalVariableTable = rFrame.getLocalVariableTable();

		// TOS and store in frame at operand1 location
		BLocalVariable poppedValue = myOperandStack.pop();
		myLocalVariableTable.setValueAtIndex(this.operand1, poppedValue.getValue());
		
		BinNode rootNode= new BinNode(poppedValue.index,poppedValue);	
		Dependency relation=new Dependency(rootNode, this);
		Dependencies relations = rFrame.getRelations();
		relations.add(relation);
	}

	@Override
	public Object execute(PathFrame pathFrame) {
		Stack<BLocalVariable> myOperandStack = pathFrame.getOperandStack();
		BLocalVarTable myLocalVariableTable = pathFrame.getLocalVariableTable();

		BLocalVariable value = myOperandStack.pop(); // get the top of the operand
												// stack
		myLocalVariableTable.setValueAtIndex(operand1, value);// add the value on
													// localVariableTable
													// at the position defined
													// by operand1.
		return null;
		
	}

}
