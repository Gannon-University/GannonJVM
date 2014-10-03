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

public class BILoadTest {
	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};

	@Test
	public void testGetOpcode() {
		BAStore instance = new BAStore(1,10);
		int expResult = 58;
		int result = instance.getOpcode();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetOpcodeCommand() {
		BAStore instance = new BAStore(1,12);

		String expResult = "astore";
		String result = instance.getOpCodeCommand();
		assertEquals(expResult, result);
	}

	@Test
	public void testExecuteBFramePostion2() {
		BILoad bILoad = new BILoad(2,5);// Initialize BILoad, pass 0 as operand value
		// init local Variable table
		BLocalVarTable varTable = new BLocalVarTable();
		Stack<BLocalVariable> operandStack = new Stack<BLocalVariable>();
		BLocalVariable l1= new BLocalVariable("","I",null,null, null,1);
		l1.setValue(10);
		BLocalVariable l2= new BLocalVariable("","I",null,null, null,2);
		l2.setValue(1);
		BLocalVariable l3= new BLocalVariable("","I",null,null, null,3);
		l3.setValue(9);
		operandStack.add(l1); // add value 10 to index 0 of operand stack
		operandStack.add(l2);
		operandStack.add(l3);
		
		BLocalVariable v1= new BLocalVariable("a","I",null,null, null,1);
		v1.setValue(7);
		BLocalVariable v2= new BLocalVariable("b","I",null,null, null,2);
		v2.setValue(2);
		BLocalVariable v3= new BLocalVariable("c","I",null,null, null,3);
		v3.setValue(5);
		varTable.add(v1);
		varTable.add(v2);
		varTable.add(v3);

		BFrame activeFrame = new BFrame(null,null);
		activeFrame.setTableAndStackForTesting(varTable, operandStack);
		activeFrame.setLineNumber(0); 

		// Before calling the execute method,  LocalVariableTable will have 7 on its 0th position, 2 on 1st and 5 on 2nd.
		// Expectation is, BILoad(2) should load what ever is there on 2nd position of local variable table,
		// to the TOP of the stack of operand.

		bILoad.execute(activeFrame);

		Stack<BLocalVariable> resultOperandStack = activeFrame.getOperandStack();

		BLocalVariable result = resultOperandStack.lastElement();

		assertEquals(result.getValue(), new Integer(2));
	}

	@Test
	public void testExecuteBFramePostion1() {
		BILoad bILoad = new BILoad(1,5);// Initialize BILoad, pass 0 as operand value
		// init local Variable table
		BLocalVarTable varTable = new BLocalVarTable();
		Stack<BLocalVariable> operandStack = new Stack<BLocalVariable>();
		BLocalVariable l1= new BLocalVariable("","I",null,null, null,1);
		l1.setValue(10);
		BLocalVariable l2= new BLocalVariable("","I",null,null, null,2);
		l2.setValue(1);
		BLocalVariable l3= new BLocalVariable("","I",null,null, null,3);
		l3.setValue(9);
		operandStack.add(l1); // add value 10 to index 0 of operand stack
		operandStack.add(l2);
		operandStack.add(l3);
		
		BLocalVariable v1= new BLocalVariable("a","I",null,null, null,1);
		v1.setValue(7);
		BLocalVariable v2= new BLocalVariable("b","I",null,null, null,2);
		v2.setValue(2);
		BLocalVariable v3= new BLocalVariable("c","I",null,null, null,3);
		v3.setValue(5);
		varTable.add(v1);
		varTable.add(v2);
		varTable.add(v3);

		BFrame activeFrame = new BFrame(null, null);
		activeFrame.setTableAndStackForTesting(varTable, operandStack);

		// Before calling the execute method,  LocalVariableTable will have 7 on its 0th position, 2 on 1st and 5 on 2nd.
		// Expectation is, BILoad(1) should load what ever is there on 1st position of local variable table,
		// to the TOP of the stack of operand.

		bILoad.execute(activeFrame);

		Stack<BLocalVariable> resultOperandStack = activeFrame.getOperandStack();

		BLocalVariable result = resultOperandStack.lastElement();

		assertEquals(new Integer(7),result.getValue());
	}

	@Test
	public void testExecuteBFramePostion3() {
		// create local variable table
		// varTable index starts from 0
		BLocalVarTable varTable = new BLocalVarTable();
		BLocalVariable v1= new BLocalVariable("a","I",null,null, null,1);
		v1.setValue(7);
		BLocalVariable v2= new BLocalVariable("b","I",null,null, null,2);
		v2.setValue(2);
		BLocalVariable v3= new BLocalVariable("c","I",null,null, null,3);
		v3.setValue(5);
		BLocalVariable v4= new BLocalVariable("d","I",null,null, null,4);
		v4.setValue(9);
		varTable.add(v1);
		varTable.add(v2);
		varTable.add(v3);
		varTable.add(v4);

		// create a stack
		Stack<BLocalVariable> operandStack = new Stack<BLocalVariable>();

		//create a frame
		BFrame activeFrame = new BFrame(null,null);
		activeFrame.setTableAndStackForTesting(varTable, operandStack);

		//invoke iload 3
		BILoad bILoad = new BILoad(3,6);
		bILoad.execute(activeFrame);

		//check the stack after execution
		Stack<BLocalVariable> resultOperandStack = activeFrame.getOperandStack();
		Object actualResult = resultOperandStack.peek().getValue();

		//compare results
		assertEquals(actualResult, new Integer(5));
	}
	
	@Test
	public void testDependency() {
//		DependencyFrame dependency = new DependencyFrame();
//		TestPath targetPath = new TestPath();
//		BMethod method = new BMethod(1, "", "(III)I");
//		targetPath.setbMethod(method);
//		dependency.setTargetPath(targetPath);
//		dependency.initParameterRelation();
//		BILoad iLoad = new BILoad(2,0); 
//		iLoad.analyzing(dependency);
//		Stack<String> resultStack = dependency.getIntermediateVariableNameStack();
//		Stack<String> expectedStack = new Stack<String>();
//		expectedStack.push("2");
//		assertEquals(expectedStack, resultStack);
	}
}
