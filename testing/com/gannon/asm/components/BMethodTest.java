package com.gannon.asm.components;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.gannon.asm.classgenerator.BClassGenerator;

public class BMethodTest {
	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};

	@Test
	public void testMethodName1() {
		BClass myclass=BClassGenerator.getBClass("Triangle.class");
		BMethod m=myclass.getMethod("triangleType");
		assertEquals(3, m.getNumberOfParameter());
	}
	
	@Test
	public void testMethodName2() {
		BClass myclass=BClassGenerator.getBClass("Triangle.class");
		BMethod m=myclass.getMethod("test1");
		assertEquals(1, m.getNumberOfParameter());
	}
}
