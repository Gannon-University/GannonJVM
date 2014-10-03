package com.gannon.jvm.execution.method;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.gannon.asm.classgenerator.BClassGenerator;
import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BLocalVariable;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.data.input.Input;
import com.gannon.jvm.utilities.TrianglePathBuilderUtility;

public class GannonMethodJVMTest {
	private static BClass myclass;
	private static BMethod m;

	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("===========================================");
			System.out.println("Starting test: " + description.getMethodName());

		}
	};

	@BeforeClass
	public static void oneTimeSetUp() {
		// one-time initialization code
		System.out.println("@BeforeClass - oneTimeSetUp: get Triangle class and methods");
		// get Method instructions
		myclass = BClassGenerator.getBClass("Triangle.class");
		m = myclass.getMethod("triangleType");
		System.out.print(m);
	}

	@Test
	public void testClassName() {
		BClass myclass = BClassGenerator.getBClass("Triangle.class");
		assertEquals("Triangle", myclass.getShortClassName());
	}

	@Test
	public void testMethodName() {
		BClass myclass = BClassGenerator.getBClass("Triangle.class");
		BMethod m = myclass.getMethod("triangleType");
		assertEquals("triangleType", m.getName());
	}

	@Test
	public void testMethodTriangleTypePathID_1() {
		GannonMethodJVM jvm = new GannonMethodJVM();
		Input input = TrianglePathBuilderUtility.createPathID1_input();
		// assertion
		assertEquals(new Integer(1), ((BLocalVariable)jvm.run(myclass, m, input)).getValue());
		System.out.println(jvm.getExecutedPath());


	}

	@Test
	public void testMethodTriangleTypePathID_2() {
		GannonMethodJVM jvm = new GannonMethodJVM();
		Input input = TrianglePathBuilderUtility.createPathID2_input();
		// assertion
		assertEquals(new Integer(3), ((BLocalVariable)jvm.run(myclass, m, input)).getValue());
	}

	@Test
	public void testMethodTriangleTypePathID_3() {
		GannonMethodJVM jvm = new GannonMethodJVM();
		Input input = TrianglePathBuilderUtility.createPathID3_input();
		// assertion
		assertEquals(new Integer(3),((BLocalVariable)jvm.run(myclass, m, input)).getValue());
	}

	@Test
	public void testMethodTriangleTypePathID_4() {
		GannonMethodJVM jvm = new GannonMethodJVM();
		Input input = TrianglePathBuilderUtility.createPathID4_input();
		// assertion
		assertEquals(new Integer(3),((BLocalVariable)jvm.run(myclass, m, input)).getValue());
	}

	@Test
	public void testMethodTriangleTypePathID_5() {
		GannonMethodJVM jvm = new GannonMethodJVM();
		Input input = TrianglePathBuilderUtility.createPathID5_input();
		// assertion
		assertEquals(new Integer(3),((BLocalVariable)jvm.run(myclass, m, input)).getValue());
	}

	@Test
	public void testMethodTriangleTypePathID_6() {
		GannonMethodJVM jvm = new GannonMethodJVM();
		Input input = TrianglePathBuilderUtility.createPathID6_input();
		// assertion
		assertEquals(new Integer(3),((BLocalVariable)jvm.run(myclass, m, input)).getValue());
	}

	@Test
	public void testMethodTriangleTypePathID_7() {
		GannonMethodJVM jvm = new GannonMethodJVM();
		Input input = TrianglePathBuilderUtility.createPathID7_input();
		// assertion
		assertEquals(new Integer(3),((BLocalVariable)jvm.run(myclass, m, input)).getValue());
	}

	@Test
	public void testMethodTriangleTypePathID_8() {
		GannonMethodJVM jvm = new GannonMethodJVM();
		Input input = TrianglePathBuilderUtility.createPathID8_input();
		// assertion
		assertEquals(new Integer(2),((BLocalVariable)jvm.run(myclass, m, input)).getValue());
	}

	@Test
	public void testMethodTriangleTypePathID_9() {
		GannonMethodJVM jvm = new GannonMethodJVM();
		Input input = TrianglePathBuilderUtility.createPathID9_input();
		// assertion
		assertEquals(new Integer(2),((BLocalVariable)jvm.run(myclass, m, input)).getValue());
	}

	@Test
	public void testMethodTriangleTypePathID_10() {
		GannonMethodJVM jvm = new GannonMethodJVM();
		Input input = TrianglePathBuilderUtility.createPathID10_input();
		System.out.print(jvm.getExecutedPath());
		// assertion
		assertEquals(new Integer(4),((BLocalVariable)jvm.run(myclass, m, input)).getValue());
	}

	@Test
	public void testMethodTriangleTypePathID_11() {
		GannonMethodJVM jvm = new GannonMethodJVM();
		Input input = TrianglePathBuilderUtility.createPathID11_input();
		// assertion
		assertEquals(new Integer(4),((BLocalVariable)jvm.run(myclass, m, input)).getValue());
	}

	@Test
	public void testMethodTriangleTypePathID_12() {
		GannonMethodJVM jvm = new GannonMethodJVM();
		Input input = TrianglePathBuilderUtility.createPathID12_input();
		// assertion
		assertEquals(new Integer(4),((BLocalVariable)jvm.run(myclass, m, input)).getValue());
	}

}
