package com.gannon.jvm.execution.method;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BLocalVariable;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.data.input.Input;
import com.gannon.jvm.progam.path.TestPath;
import com.gannon.jvm.utilities.ConstantsUtility;

public class GannonMethodJVM {
	private JVMStackSingleton jvmStack;
	private MethodExecutor executor;
	private TestPath executedPath;

	public GannonMethodJVM() {
		super();
		this.jvmStack = JVMStackSingleton.getInstance();
		this.jvmStack.clear();
		this.executor = new MethodExecutor();
	}

	public Object run(BClass bClass, BMethod method, Input inputs) {
		//System.out.println("==========="+method);
		// be sure to push the active frame to stack
		preExecution(bClass, method, inputs);
		Object result = executor.execute(jvmStack);
		executedPath = collectingExecutedPath(inputs);
		return result;
	}

	public JVMStackSingleton getJvmStack() {
		return jvmStack;
	}

	public void setJvmStack(JVMStackSingleton jvmStack) {
		this.jvmStack = jvmStack;
	}

	public MethodExecutor getExecutor() { 
		return executor;
	}

	public void setExecutor(MethodExecutor executor) {
		this.executor = executor;
	}

	// before executing push active frame to stack
	private void preExecution(BClass bClass, BMethod method, Input input) {
		// the first instruction is 1
		method.getLocalVariables().updateVarTableWithInput(input);
		BFrame activeFrame = new BFrame(bClass, method);
		// push the frame to JVM stack
		jvmStack.pushFrame(activeFrame);
	}


	private TestPath collectingExecutedPath(Input inputs) {
		TestPath executedPath = executor.getExecutedPath();
		executedPath.setInputs(inputs);
		return executedPath;
	}

	public TestPath getExecutedPath() {
		return executedPath;
	}

}
