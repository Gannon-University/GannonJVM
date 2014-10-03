package com.gannon.jvm.instructions;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

import com.gannon.asm.components.BLocalVariable;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.data.dependency.DependencyFrame;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.method.BLocalVarTable;
import com.gannon.jvm.progam.path.TestPath;

public class BIConst_2Test {

	@Test
	public void testExecute() {
		BIConst_2 iconst2 = new BIConst_2(4);
		Stack<BLocalVariable> operandStack = new  Stack<BLocalVariable>();
		BLocalVarTable varTable = new BLocalVarTable();
		BFrame activeFrame = new BFrame(null, null);
		activeFrame.setTableAndStackForTesting(varTable, operandStack);
		
		// Before calling the execute method,  LocalVariableTable and operand stack will be empty
		// Expectation is, BIConst_1 will load 1 on top of the operand stack,
		
		iconst2.execute(activeFrame);
		
		Stack<BLocalVariable> resultOprndStack = new  Stack<BLocalVariable>();
		resultOprndStack = activeFrame.getOperandStack();
		
		assertEquals(2, resultOprndStack.peek().getValue());
	}

	@Test
	public void testGetOpcodeCommand() {
		BIConst_2 instance = new BIConst_2(5);

		String expResult = "iconst_2";
		String result = instance.getOpCodeCommand();
		assertEquals(expResult, result);
	}

	@Test
	public void testExecuteBFrame() {
		BIConst_2 instance = new BIConst_2(6);
		int expResult = 5;
		int result = instance.getOpcode();
		assertEquals(expResult, result);
	}
	
	@Test
	public void testDependencyIConst_2() {
//		DependencyFrame dependency = new DependencyFrame();
//		TestPath targetPath = new TestPath();
//		BMethod method = new BMethod(1, "", "(III)I");
//		targetPath.setbMethod(method);
//		dependency.setTargetPath(targetPath);
//		dependency.initParameterRelation();
//		BIConst_2 iConst2 = new BIConst_2(0);
//		iConst2.analyzing(dependency);
//		Stack<String> resultStack = dependency.getIntermediateVariableNameStack();
//		Stack<String> expectedStack = new Stack<String>();
//		expectedStack.push("2");
//		assertEquals(expectedStack, resultStack);
	}
}
