package com.gannon.asm.classgenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BMethod;

public class BClassGeneratorTest {
	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};

	@Test
	public void testClassName() {
		BClass myclass=BClassGenerator.getBClass("Triangle.class");
		assertEquals("Triangle", myclass.getShortClassName());
	}


	@Test
	public void testMethodName() {
		BClass myclass=BClassGenerator.getBClass("Triangle.class");
		BMethod m=myclass.getMethod("triangleType");
		assertEquals("triangleType", m.getName());
	}

	@Test
	public void testMethod2() {
		BClass myclass=BClassGenerator.getBClass("Triangle.class");
		BMethod m=myclass.getMethod("triangleType");
		System.out.println(m.getLocalVariables());
		//System.out.print(m);
		assertEquals("a",m.getLocalVariables().getLocalVariableByIndex(1).name);
	}
	
	@Test
	public void testInfeasibleHasLocalVar() {
		BClass myclass=BClassGenerator.getBClass("TestInfesaible.class");
		BMethod m=myclass.getMethod("infeasibleHasLocalVar");
		//assertEquals("c",m.getLocalVariables().get(3).getName());
	}
}
