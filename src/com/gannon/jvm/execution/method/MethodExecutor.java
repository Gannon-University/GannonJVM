package com.gannon.jvm.execution.method;

import java.util.ArrayList;
import java.util.List;

import com.gannon.asm.components.BLocalVariable;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.instructions.BInstruction;
import com.gannon.jvm.instructions.BPredicateInstruction;
import com.gannon.jvm.progam.path.NonPredicateNode;
import com.gannon.jvm.progam.path.PredicateNode;
import com.gannon.jvm.progam.path.TestPath;
import com.gannon.jvm.utilities.ConstantsUtility;
import com.gannon.jvm.utilities.OpcodeUtility;

public class MethodExecutor {
	// save execution path
	private TestPath executedPath = new TestPath();

	public MethodExecutor() {
		super();
	}

	// assume activeFrame is saved in JVM stack
	public Object execute(JVMStackSingleton jvmStack) {
		Object runTimePredicateResult = null;
		BFrame activeFrame = jvmStack.peekActiveFrame();
		BMethod method = activeFrame.getbMethod();
		ArrayList<BInstruction> instructions = method.getInstructions();

		while (activeFrame.getLineNumber() != OpcodeUtility.END_INSTRUCTION_FLAG) {
			BInstruction bInstruction = instructions.get(activeFrame.getLineNumber() - 1);
			//System.out.println(bInstruction);
			runTimePredicateResult = bInstruction.execute(activeFrame);

			// save runtime execution results for predicate statements to node
			saveRuntimePredicateResult(runTimePredicateResult, bInstruction);
		}
		// post execution job, needed for method to method calling
		if (activeFrame.getLineNumber() == OpcodeUtility.END_INSTRUCTION_FLAG) {
			postExecution(jvmStack, runTimePredicateResult);
		}

		// ideally, only predicate statements will results, e.g., true or false;
		return runTimePredicateResult;
	}

	// save path with predicate results if the instruction is
	// predicateInstruction
	private void saveRuntimePredicateResult(Object result, BInstruction bInstruction) {
		if (bInstruction instanceof BPredicateInstruction) {
			PredicateNode pNode = new PredicateNode(bInstruction);
			executedPath.add(pNode);
			pNode.setActualPredicateResult((Boolean) result.equals(true) ? ConstantsUtility.EXPECTED_TRUE : ConstantsUtility.EXPECTED_FALSE);
		} else {
			executedPath.add(new NonPredicateNode(bInstruction));
		}
	}

	// after execution, be sure to push the result to the caller
	private void postExecution(JVMStackSingleton jvmStack, Object result) {
		jvmStack.popActivekFrame();
		if (jvmStack.size() != 0) {
			jvmStack.peekActiveFrame().getOperandStack().push((BLocalVariable) result);
		}
	}

	public TestPath getExecutedPath() {
		return executedPath;
	}

	// don't call this method, it is only used by writing test cases
	public ArrayList<Integer> getExecutedInsIDs() {
		return getExecutedPath().getExecutedInsIDs();
	}

}
