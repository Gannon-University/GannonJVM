package com.gannon.jvm.instructions;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

import com.gannon.asm.classgenerator.BClassGenerator;
import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BLocalVariable;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.data.input.Input;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.method.BLocalVarTable;
import com.gannon.jvm.execution.method.GannonMethodJVM;
import com.gannon.jvm.execution.method.JVMStackSingleton;
import com.gannon.jvm.execution.method.MethodExecutor;

public class BInvokeVirtualTest {

	// caller(a,b)
	// stack Top to bottom=[b, a, reference]
	// after operation: localVarTable from left to right =[reference,a
	// (index1),b (index2)]

	@Test
	public void testCopyCallerOpstackToCalleeLocal() {
		BClass myclass = BClassGenerator.getBClass("Hello.class");
		BMethod nextMethod = myclass.getMethod("callee");
		// add values to caller stack
		Stack<BLocalVariable> callerStack = new Stack<BLocalVariable>();
		BLocalVariable bLocalVariable0 = new BLocalVariable(null, null, null, null, null, 0);
		callerStack.add(bLocalVariable0);
		BLocalVariable bLocalVariable1 = new BLocalVariable("a", "I", null, null, null, 1);
		bLocalVariable1.setValue(new Integer(11));
		callerStack.add(bLocalVariable1);
		BLocalVariable bLocalVariable2 = new BLocalVariable("b", "I", null, null, null, 2);
		bLocalVariable2.setValue(new Integer(12));
		callerStack.add(bLocalVariable2);
		// invoke
		BInvokeVirtual invoke = new BInvokeVirtual(null, null, null, 0);
		invoke.copyCallerOpstackToCalleeLocal(callerStack, nextMethod);

		// assert
		Integer value1 = (Integer) (nextMethod.getLocalVariables().getLocalVariableByIndex(1).getValue());
		assertEquals((Integer) 11, value1);
		assertEquals((Integer) 12, (Integer) nextMethod.getLocalVariables().getLocalVariableByIndex(2).getValue());

	}



	@Test
	public void test() {
		//get Method instructions
		BClass myclass = BClassGenerator.getBClass("Hello.class");
		BMethod m = myclass.getMethod("callee");

		// create local variable table
		// varTable index starts from 0
		// three sides
		BLocalVariable v1= new BLocalVariable("a","I",null,null, null,1);
		v1.setValue(5);
		BLocalVariable v2= new BLocalVariable("b","I",null,null, null,2);
		v2.setValue(15);
		
		Input input=new Input(0, myclass, m); 
		input.addParameter(v1);
		input.addParameter(v2);
		
		GannonMethodJVM jvm = new GannonMethodJVM();
		BLocalVariable var=(BLocalVariable) jvm.run(myclass, m, input);
		//assertion
		assertEquals(new Integer(20), var.getValue());
	}
	
	@Test
	public void testWithMulTempCallerVars() {
		//get Method instructions
		BClass myclass = BClassGenerator.getBClass("Hello.class");
		BMethod m = myclass.getMethod("withMulTempCallerVars");

		// create local variable table
		// varTable index starts from 0
		// three sides
		BLocalVariable v1= new BLocalVariable("a","I",null,null, null,1);
		v1.setValue(5);
		
		Input input=new Input(0, myclass, m); 
		input.addParameter(v1);
		
		GannonMethodJVM jvm = new GannonMethodJVM();
		BLocalVariable var=(BLocalVariable) jvm.run(myclass, m, input);
		//assertion
		assertEquals(new Integer(6), var.getValue());
	}
	
	@Test
	public void testAdd2() {
		//get Method instructions
		BClass myclass = BClassGenerator.getBClass("Hello.class");
		BMethod m = myclass.getMethod("add2");

		// create local variable table
		// varTable index starts from 0
		// three sides
		BLocalVariable v1= new BLocalVariable("a","I",null,null, null,1);
		v1.setValue(15);
		
		Input input=new Input(0, myclass, m); 
		input.addParameter(v1);
		
		GannonMethodJVM jvm = new GannonMethodJVM();
		BLocalVariable var=(BLocalVariable) jvm.run(myclass, m, input);
		//assertion
		assertEquals(new Integer(17), var.getValue());
	}
	
	
	@Test
	public void testInvkoeCallee() {
		//get Method instructions
		BClass myclass = BClassGenerator.getBClass("Hello.class");
		BMethod m = myclass.getMethod("plusFive");

		// create local variable table
		// varTable index starts from 0
		// three sides
		BLocalVariable v1= new BLocalVariable("a","I",null,null, null,1);
		v1.setValue(5);
		
		Input input=new Input(0, myclass, m); 
		input.addParameter(v1);
		
		GannonMethodJVM jvm = new GannonMethodJVM();
		BLocalVariable var=(BLocalVariable) jvm.run(myclass, m, input);
		//assertion
		assertEquals(new Integer(25), var.getValue());
	}
	
	@Test
	public void testInvkoeTripleCaller() {
		//get Method instructions
		BClass myclass = BClassGenerator.getBClass("Hello.class");
		BMethod m = myclass.getMethod("tripleCaller");

		// create local variable table
		// varTable index starts from 0
		// three sides
		BLocalVariable v1= new BLocalVariable("a","I",null,null, null,1);
		v1.setValue(5);
		
		Input input=new Input(0, myclass, m); 
		input.addParameter(v1);
		
		GannonMethodJVM jvm = new GannonMethodJVM();
		BLocalVariable var=(BLocalVariable) jvm.run(myclass, m, input);
		//assertion
		assertEquals(new Integer(7), var.getValue());
	}
	
}
