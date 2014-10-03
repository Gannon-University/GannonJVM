package com.gannon.jvm.instructions;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.method.BLocalVarTable;

public class BIReturnTest {

	@Test
	public void testExecuteOneMethodOnStack() {
		BIReturn bIReturn = new BIReturn(10);

		BLocalVarTable varTable = new BLocalVarTable();
		Stack<BLocalVariable> operandStack = new Stack<BLocalVariable>();
		Integer one=new Integer(1);
		BLocalVariable var= new BLocalVariable("","I",null,null, null,1,one );
		operandStack.add(var); // add value 1 to index 0

		BFrame activeFrame = new BFrame(null,null);
		activeFrame.setTableAndStackForTesting(varTable, operandStack);
		
		// Before calling the execute method,  operand stack of active frame has 1 on its TOS. JVMStack has only one method.
		// Expectation is, BIReturn should return null
		// and unload(POP) that active method frame form JVMStack.
		
		Object returnedObject = bIReturn.execute(activeFrame);
		assertTrue(operandStack.isEmpty());
		assertEquals(1, ((BLocalVariable)returnedObject).getValue());
	}
	
	@Test
	public void testGetOpcodeCommand() {
		System.out.println("getOpcodeCommand");
		BIReturn instance = new BIReturn(10);

		String expResult = "ireturn";
		String result = instance.getOpCodeCommand();
		assertEquals(expResult, result);
	}

	@Test
	public void testExecuteBFrame() {
		System.out.println("getOpcode");
		BIReturn instance = new BIReturn(10);
		int expResult = 172;
		int result = instance.getOpcode();
		assertEquals(expResult, result);
	}

	@Test
	public void testDependency() {
//		DependencyFrame dependency = new DependencyFrame();
//		TestPath targetPath = new TestPath();
//		BMethod method = new BMethod(1, "", "(III)I");
//		targetPath.setbMethod(method);
//		dependency.setTargetPath(targetPath);
//		dependency.initParameterRelation();
//		//dependency.initInputs();
//		dependency.getIntermediateVariableNameStack().push("6");
//		dependency.getOperandStack().push("10");
//		BIReturn iReturn = new BIReturn(10);
//		iReturn.analyzing(dependency);
//		Stack<String> resultStack = dependency.getIntermediateVariableNameStack();
//		//String result = resultStack.peek();
//		assertEquals(new Stack(), resultStack);
	}
}
