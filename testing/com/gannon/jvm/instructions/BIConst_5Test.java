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

public class BIConst_5Test {

	@Test
	public void testExecute() {
		BIConst_5 iconst5 = new BIConst_5(7);
		Stack<BLocalVariable> operandStack = new  Stack<BLocalVariable>();
		BLocalVarTable varTable = new BLocalVarTable();
		BFrame activeFrame = new BFrame(null, null);
		activeFrame.setTableAndStackForTesting(varTable, operandStack);
		
		// Before calling the execute method,  LocalVariableTable and operand stack will be empty
		// Expectation is, BIConst_1 will load 1 on top of the operand stack,
		
		iconst5.execute(activeFrame);
		
		Stack<BLocalVariable> resultOprndStack = new  Stack<BLocalVariable>();
		resultOprndStack = activeFrame.getOperandStack();
		
		assertEquals(5, resultOprndStack.peek().getValue());
	}

	@Test
	public void testGetOpcodeCommand() {
		BIConst_5 instance = new BIConst_5(8);

		String expResult = "iconst_5";
		String result = instance.getOpCodeCommand();
		assertEquals(expResult, result);
	}

	@Test
	public void testExecuteBFrame() {
		BIConst_5 instance = new BIConst_5(9);
		int expResult = 8;
		int result = instance.getOpcode();
		assertEquals(expResult, result);
	}
	
	@Test
	public void testDependencyIConst_5() {
//		DependencyFrame dependency = new DependencyFrame();
//		TestPath targetPath = new TestPath();
//		BMethod method = new BMethod(1, "", "(III)I");
//		targetPath.setbMethod(method);
//		dependency.setTargetPath(targetPath);
//		dependency.initParameterRelation();
//		BIConst_5 iConst5 = new BIConst_5(0);
//		iConst5.analyzing(dependency);
//		Stack<String> resultStack = dependency.getIntermediateVariableNameStack();
//		Stack<String> expectedStack = new Stack<String>();
//		expectedStack.push("5");
//		assertEquals(expectedStack, resultStack);
	}

}
