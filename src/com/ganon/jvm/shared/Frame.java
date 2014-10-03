package com.ganon.jvm.shared;

import java.util.Stack;

import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BLocalVariable;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.execution.method.BLocalVarTable;

public class Frame {
	protected BClass bClass;
	protected BMethod bMethod;
	protected Stack<BLocalVariable> operandStack;
	protected BLocalVarTable localVariableTable;

	/**
	 * BMethod has localVariableTable already
	 * if BMethod is null, we need to create a new localVariableTable
	 * @param bClass
	 * @param bMethod
	 */
	public Frame(BClass bClass, BMethod bMethod) {
		super();
		this.bClass = bClass;
		this.bMethod = bMethod;
		if (bMethod == null) {
			this.localVariableTable = new BLocalVarTable();
		} else {
			this.localVariableTable = bMethod.getLocalVariables();
		}
		this.operandStack = new Stack<BLocalVariable>();
	}

	public BClass getbClass() {
		return bClass;
	}

	public void setbClass(BClass bClass) {
		this.bClass = bClass;
	}

	public BMethod getbMethod() {
		return bMethod;
	}

	public void setbMethod(BMethod bMethod) {
		this.bMethod = bMethod;
	}

	public Stack<BLocalVariable> getOperandStack() {
		return operandStack;
	}

	public void setOperandStack(Stack<BLocalVariable> operandStack) {
		this.operandStack = operandStack;
	}

	public BLocalVarTable getLocalVariableTable() {
		return localVariableTable;
	}

	public void setLocalVariableTable(BLocalVarTable localVariableTable) {
		this.localVariableTable = localVariableTable;
	}
	
	public void setTableAndStackForTesting(BLocalVarTable localVariableTable, Stack<BLocalVariable> operandStack){
		setLocalVariableTable(localVariableTable);
		setOperandStack(operandStack);
	}

}
