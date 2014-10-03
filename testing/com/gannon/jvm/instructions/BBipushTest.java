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
import com.gannon.jvm.utilities.ConstantsUtility;

public class BBipushTest {
	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};

	@Test
	public void testGetOpcode() {
		BBipush instance = new BBipush(10,16);
		int expResult = 16;
		int result = instance.getOpcode();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetOpcodeCommand() {
		BBipush instance = new BBipush(10,10);
		
		String expResult = "bipush";
		String result = instance.getOpCodeCommand();
		assertEquals(expResult, result);
	}

	@Test
	public void testExecuteBFramePosition1() {
		BBipush biPush = new BBipush(16,10);
		BLocalVarTable varTable = new BLocalVarTable();

		BFrame activeFrame = new BFrame(null, null);
		
		// Before calling the execute method,  operand stack will have 10 on its 0th position.
		// Expectation is, BBipush(16) should load 16 on the top of the operand stack. i.e. on 1st position in this case
		
		biPush.execute(activeFrame);
		
		BLocalVariable result = activeFrame.getOperandStack().peek();
		
		assertEquals(16, result.getValue());
		assertEquals("I", result.desc);
	}
	
	@Test
	public void testExecuteBFramePosition0() {
		BBipush biPush = new BBipush(8,10);

		BFrame activeFrame = new BFrame(null, null);
		
		// Before calling the execute method,  operand stack and localvariable table are empty. 
		// Expectation is, BBipush(8) should load 16 on the top of the operand stack. i.e. on 0th position in this case
		
		biPush.execute(activeFrame);
		
		BLocalVariable result = activeFrame.getOperandStack().peek();
		assertEquals(8, result.getValue());
	}
	

	@Test
	public void testDependency() {
//		DependencyFrame dependency = new DependencyFrame();
//		TestPath targetPath = new TestPath();
//		BMethod method = new BMethod(1, "", "(III)I");
//		targetPath.setbMethod(method);
//		dependency.setTargetPath(targetPath);
//		dependency.initParameterRelation();
//		BBipush bipush = new BBipush(10,0);
//		bipush.analyzing(dependency);
//		Stack<String> resultStack = dependency.getIntermediateVariableNameStack();
//		Stack<String> expectedStack = new Stack<String>();
//		expectedStack.push("10");
//		assertEquals(expectedStack, resultStack);
	}

}
