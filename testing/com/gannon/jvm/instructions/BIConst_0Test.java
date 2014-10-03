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

public class BIConst_0Test {
	
	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};

	@Test
	public void testExecute() {
		BIConst_0 iconst0 = new BIConst_0(5);
		Stack<BLocalVariable> operandStack = new  Stack<BLocalVariable>();
		BLocalVarTable varTable = new BLocalVarTable();
		BFrame activeFrame = new BFrame(null, null);
		activeFrame.setTableAndStackForTesting(varTable, operandStack);

		// Before calling the execute method,  LocalVariableTable and operand stack will be empty
		// Expectation is, BIConst_0 will load 0 on top of the operand stack,

		iconst0.execute(activeFrame);

		Stack<BLocalVariable> resultOprndStack = new  Stack<BLocalVariable>();
		resultOprndStack = activeFrame.getOperandStack();

		assertEquals(0, resultOprndStack.peek().getValue());
	}

	@Test
	public void testGetOpcodeCommand() {
		System.out.println("getOpcodeCommand");
		BIConst_0 instance = new BIConst_0(7);

		String expResult = "iconst_0";
		String result = instance.getOpCodeCommand();
		assertEquals(expResult, result);
	}

	@Test
	public void testExecuteBFrame() {
		System.out.println("getOpcode");
		BIConst_0 instance = new BIConst_0(6);
		int expResult = 3;
		int result = instance.getOpcode();
		assertEquals(expResult, result);
	}
	
	@Test
	public void testDependencyIConst_0() {
//		DependencyFrame dependency = new DependencyFrame();
//		TestPath targetPath = new TestPath();
//		BMethod method = new BMethod(1, "", "(III)I");
//		targetPath.setbMethod(method);
//		dependency.setTargetPath(targetPath);
//		dependency.initParameterRelation();
//		BIConst_0 iConst0 = new BIConst_0(0);
//		iConst0.analyzing(dependency);
//		Stack<String> resultStack = dependency.getIntermediateVariableNameStack();
//		Stack<String> expectedStack = new Stack<String>();
//		expectedStack.push("0");
//		assertEquals(expectedStack, resultStack);
	}
}
