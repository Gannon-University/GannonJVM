package com.gannon.jvm.instructions;

import java.util.Stack;

import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BLocalVariable;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.data.dependency.DependencyFrame;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.method.BLocalVarTable;
import com.gannon.jvm.execution.method.JVMStackSingleton;
import com.gannon.jvm.execution.method.MethodExecutor;
import com.gannon.jvm.execution.path.PathFrame;

public class BInvokeVirtual extends Invoke {

	
	public BInvokeVirtual(String owner, String name, String desc, int lineNumber) { 
		super(owner, name, desc, lineNumber);
	}

	@Override
	public Integer execute(BFrame activeFrame) {
		Stack<BLocalVariable> activeOperandStack = activeFrame.getOperandStack();
		Integer pc = activeFrame.getLineNumber();
		activeFrame.setLineNumber(++pc);
		// increment pc before invoking virtual, so as to avoid re-entering this
		// instruction

		BClass bClass = activeFrame.getbClass();
		BMethod calleeMethod = bClass.getMethod(name);

		copyCallerOpstackToCalleeLocal(activeOperandStack, calleeMethod);
		
		BFrame calleeFrame = new BFrame(bClass, calleeMethod);
		JVMStackSingleton.getInstance().pushFrame(calleeFrame);
		MethodExecutor invokedmethodExecutor=new MethodExecutor();
		invokedmethodExecutor.execute(JVMStackSingleton.getInstance()); 

		return null;

	}

	// caller(a,b)
	// stack Top to bottom=[b, a, reference]
	// after operation: localVarTable from left to right =[reference,a
	// (index1),b (index2)]
	public void copyCallerOpstackToCalleeLocal(Stack<BLocalVariable> activeOperandStack, BMethod nextMethod) {
		int myStackSize = activeOperandStack.size();
		BLocalVarTable vars = nextMethod.getLocalVariables();
		for (int i = myStackSize - 1; i >=0; i--) {
			vars.setValueAtIndex(i, activeOperandStack.pop().getValue());
		}
	}

	@Override
	public int getOpcode() {
		return 182;
	}

	@Override
	public void analyzing(DependencyFrame dependency) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object execute(PathFrame pathFrame) {
		// TODO Auto-generated method stub
		return null;
	}

}
