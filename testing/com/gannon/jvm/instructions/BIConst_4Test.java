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

public class BIConst_4Test {

	@Test
	public void testExecute() {
		BIConst_4 iconst4 = new BIConst_4(6);
		Stack<BLocalVariable> operandStack = new  Stack<BLocalVariable>();
		BLocalVarTable varTable = new BLocalVarTable();
		BFrame activeFrame = new BFrame(null, null);
		activeFrame.setTableAndStackForTesting(varTable, operandStack);
		
		// Before calling the execute method,  LocalVariableTable and operand stack will be empty
		// Expectation is, BIConst_1 will load 1 on top of the operand stack,
		
		iconst4.execute(activeFrame);
		
		Stack<BLocalVariable> resultOprndStack = new  Stack<BLocalVariable>();
		resultOprndStack = activeFrame.getOperandStack();
		
		assertEquals(4, resultOprndStack.peek().getValue());
	}

	@Test
	public void testGetOpcodeCommand() {
		System.out.println("getOpcodeCommand");
		BIConst_4 instance = new BIConst_4(7);

		String expResult = "iconst_4";
		String result = instance.getOpCodeCommand();
		assertEquals(expResult, result);
	}

	@Test
	public void testExecuteBFrame() {
		System.out.println("getOpcode");
		BIConst_4 instance = new BIConst_4(4);
		int expResult = 7;
		int result = instance.getOpcode();
		assertEquals(expResult, result);
	}

	@Test
	public void testDependencyIConst_4() {
//		DependencyFrame dependency = new DependencyFrame();
//		TestPath targetPath = new TestPath();
//		BMethod method = new BMethod(1, "", "(III)I");
//		targetPath.setbMethod(method);
//		dependency.setTargetPath(targetPath);
//		dependency.initParameterRelation();
//		BIConst_4 iConst4 = new BIConst_4(0);
//		iConst4.analyzing(dependency);
//		Stack<String> resultStack = dependency.getIntermediateVariableNameStack();
//		Stack<String> expectedStack = new Stack<String>();
//		expectedStack.push("4");
//		assertEquals(expectedStack, resultStack);
	}
}
