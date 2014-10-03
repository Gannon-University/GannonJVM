/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class BIStoreTest {
	
	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};


	/**
	 * Test of execute method, of class BIStore.
	 */
	@Test
	public void testExecutePosition2() {
		System.out.println("execute");
		BIStore bIStore = new BIStore(2,0);// Initialize BIStore, pass 02 as operand value
		// init local Variable table
	
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
		
		BLocalVarTable varTable = new BLocalVarTable();
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
		
		// Before calling the execute method, LocalVariableTable will have 7 on its 0th, 
		// 2 on its first and 5 on its 2nd position. OperandStack will have 10,1 and 9. 9 will be the top of the stack.
		// Expectation is, BIStore(2) should load what ever is there on top of operand stack to the 2nd position of ,
		// LocalVariableTable. 

		bIStore.execute(activeFrame);

		BLocalVarTable resultVarTable = activeFrame.getLocalVariableTable();
		
		Object result = resultVarTable.getLocalVariableByIndex(2).getValue();
		
		assertEquals(result, new Integer(9));
	}

	@Test
	public void testExecutePosition1() {
		int index1=1;
		BIStore bIStore = new BIStore(index1,0);// Initialize BIStore, pass 1 as operand value
		
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
		
		// init local Variable table
		BLocalVarTable varTable = new BLocalVarTable();
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
		
		// Before calling the execute method, LocalVariableTable will have 7 on its 1th, 
		// 2 on its 2rd and 5 on its 2rd position. OperandStack will have 10,1 and 9. 9 will be the top of the stack.
		// Expectation is, BIStore(1) should load what ever is there on top of operand stack to the 1st position of ,
		// LocalVariableTable. 

		bIStore.execute(activeFrame);

		BLocalVarTable resultVarTable = activeFrame.getLocalVariableTable();
		
		Object result = resultVarTable.getLocalVariableByIndex(index1).getValue();
		
		assertEquals(new Integer(9),result );
	}
	
	/**
	 * Test of getOpcode method, of class BIStore.
	 */
	@Test
	public void testGetOpcode() {
		System.out.println("getOpcode");
		BIStore instance = new BIStore(1,0);
		int expResult = 54;
		int result = instance.getOpcode();
		assertEquals(expResult, result);
		
	}

	/**
	 * Test of getOpcodeCommand method, of class BIStore.
	 */
	@Test
	public void testGetOpcodeCommand() {
		System.out.println("getOpcodeCommand");
		BIStore instance = new BIStore(1,0);
				
		String result = instance.getOpCodeCommand();

		String expResult = "istore";
		System.out.println(expResult);
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
//		dependency.getIntermediateVariableNameStack().push("6");
//		BIStore iStore = new BIStore(10,10);
//		iStore.analyzing(dependency);
//		Stack<String> resultStack = dependency.getIntermediateVariableNameStack();
//		//String result = resultStack.peek();
//		assertEquals(new Stack(), resultStack);
	}
}