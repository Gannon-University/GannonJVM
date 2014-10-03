package com.gannon.jvm.instructions;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.gannon.asm.components.BLocalVariable;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.data.dependency.DependencyFrame;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.method.BLocalVarTable;
import com.gannon.jvm.progam.path.TestPath;

public class BReturnTest {
	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};

	@Test
	public void testGetOpcode() {
		BReturn instance = new BReturn(10);
		int expResult = 177;
		int result = instance.getOpcode();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetOpcodeCommand() {
		BReturn instance = new BReturn(10);

		String expResult = "return";
		String result = instance.getOpcodeCommand();
		assertEquals(expResult, result);
	}

	@Test
	public void testExecuteOneMethodOnStack() {
		BReturn bReturn = new BReturn(10);

		BLocalVarTable varTable = new BLocalVarTable();
		Stack<BLocalVariable> operandStack = new Stack<BLocalVariable>();
		Integer one=new Integer(1);
		BLocalVariable var= new BLocalVariable("","I",null,null, null,1,one );
		operandStack.add(var); // add value 1 to index 0

		BFrame activeFrame = new BFrame(operandStack, varTable, 0);
		
		// Before calling the execute method,  operand stack of active frame has 1 on its TOS. JVMStack has only one method.
		// Expectation is, BIReturn should return null
		// and unload(POP) that active method frame form JVMStack.
		
		Object returnedObject = bReturn.execute(activeFrame);
		assertEquals(null,operandStack);
		assertEquals(1, ((BLocalVariable)returnedObject).getValue());
	}
	

	@Test
	public void testDependency() {
//		DependencyFrame dependency = new DependencyFrame();
//		TestPath targetPath = new TestPath();
//		BMethod method = new BMethod(1, "", "(III)I");
//		targetPath.setbMethod(method);
//		dependency.setTargetPath(targetPath);
//		dependency.initParameterRelation();
//		dependency.getIntermediateVariableNameStack().push("6");
//		BReturn retrn = new BReturn(10);
//		retrn.analyzing(dependency);
//		Stack<String> resultStack = dependency.getIntermediateVariableNameStack();
//		//String result = resultStack.peek();
//		assertEquals(new Stack(), resultStack);
	}
}
