package com.gannon.jvm.execution.path;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
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
import com.gannon.jvm.progam.path.PredicateNode;
import com.gannon.jvm.progam.path.TestPath;
import com.gannon.jvm.utilities.TrianglePathBuilderUtility;

//testing predicates in each path match the expected predicate results
//assert hasPassed ==true
public class GannonPathJVMTest {
	BClass myclass;
	BMethod m;
	
	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};
	
	@Before
	public void setUp() throws Exception{
		// get Method instructions
		myclass = BClassGenerator.getBClass("Triangle.class");
		m = myclass.getMethod("triangleType");
	}

	@Test
	public void testMethodTriangleTypePathID_1() {
		// create input
		TestPath path = TrianglePathBuilderUtility.createPathID1();
		Input input = TrianglePathBuilderUtility.createPathID1_input();
		// assertion
		GannonPathJVM jvm = new GannonPathJVM(); 

		//System.out.print(path);
		assertEquals(new Integer(1), ((BLocalVariable)jvm.run(null,m,path, input)).getValue());
		assertTrue(((PredicateNode)path.getNode(5)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(10)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(15)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(18)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(21)).hasPassed());
	}

	@Test
	public void testMethodTriangleTypePathID_2() {
		// create input
		TestPath path = TrianglePathBuilderUtility.createPathID2();
		Input input = TrianglePathBuilderUtility.createPathID2_input();

		// assertion
		GannonPathJVM jvm = new GannonPathJVM(); 
		assertEquals(new Integer(3), ((BLocalVariable)jvm.run(null,m,path, input)).getValue());
		assertTrue(((PredicateNode)path.getNode(5)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(10)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(15)).hasPassed());
		assertFalse(((PredicateNode)path.getNode(18)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(26)).hasPassed());
	}

	@Test
	public void testMethodTriangleTypePathID_3() {
		// create input
		TestPath path = TrianglePathBuilderUtility.createPathID3();
		Input input = TrianglePathBuilderUtility.createPathID3_input();

		// assertion
		GannonPathJVM jvm = new GannonPathJVM(); 
		assertEquals(new Integer(3), ((BLocalVariable)jvm.run(null,m,path, input)).getValue());
		assertTrue(((PredicateNode)path.getNode(5)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(10)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(15)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(18)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(26)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(29)).hasPassed());
	}

	@Test
	public void testMethodTriangleTypePathID_4() {
		// create input
		TestPath path = TrianglePathBuilderUtility.createPathID4();
		Input input = TrianglePathBuilderUtility.createPathID4_input();

		// assertion
		GannonPathJVM jvm = new GannonPathJVM(); 
		assertEquals(new Integer(3), ((BLocalVariable)jvm.run(null,m,path, input)).getValue());
		assertTrue(((PredicateNode)path.getNode(5)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(10)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(15)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(18)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(26)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(29)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(32)).hasPassed());
	}

	@Test
	public void testMethodTriangleTypePathID_5() {
		// create input
		TestPath path = TrianglePathBuilderUtility.createPathID5();
		Input input = TrianglePathBuilderUtility.createPathID5_input();

		// assertion
		GannonPathJVM jvm = new GannonPathJVM(); 
		assertEquals(new Integer(3), ((BLocalVariable)jvm.run(null,m,path, input)).getValue());
		assertTrue(((PredicateNode)path.getNode(5)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(10)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(15)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(18)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(21)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(26)).hasPassed());
	}

	@Test
	public void testMethodTriangleTypePathID_6() {
		// create input
		TestPath path = TrianglePathBuilderUtility.createPathID6();
		Input input = TrianglePathBuilderUtility.createPathID6_input();

		// assertion
		GannonPathJVM jvm = new GannonPathJVM(); 
		assertEquals(new Integer(3), ((BLocalVariable)jvm.run(null,m,path, input)).getValue());
		assertTrue(((PredicateNode)path.getNode(5)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(10)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(15)).hasPassed());
		assertFalse(((PredicateNode)path.getNode(18)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(21)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(26)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(29)).hasPassed());
	}


	@Test
	public void testMethodTriangleTypePathID_7() {
		// create input
		TestPath path = TrianglePathBuilderUtility.createPathID7();
		Input input = TrianglePathBuilderUtility.createPathID7_input();

		// assertion
		GannonPathJVM jvm = new GannonPathJVM(); 
		assertEquals(new Integer(3), ((BLocalVariable)jvm.run(null,m,path, input)).getValue());
		assertTrue(((PredicateNode)path.getNode(5)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(10)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(15)).hasPassed());
		assertFalse(((PredicateNode)path.getNode(18)).hasPassed());

	}

	@Test
	public void testMethodTriangleTypePathID_8() {
		// create input
		TestPath path = TrianglePathBuilderUtility.createPathID8();
		Input input = TrianglePathBuilderUtility.createPathID8_input();

		// assertion
		GannonPathJVM jvm = new GannonPathJVM(); 
		assertEquals(new Integer(2), ((BLocalVariable)jvm.run(null,m,path, input)).getValue());
		assertTrue(((PredicateNode)path.getNode(5)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(10)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(15)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(18)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(26)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(29)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(32)).hasPassed());
	}

	@Test
	public void testMethodTriangleTypePathID_9() {
		// create input
		TestPath path = TrianglePathBuilderUtility.createPathID9();
		Input input = TrianglePathBuilderUtility.createPathID9_input();

		// assertion
		GannonPathJVM jvm = new GannonPathJVM(); 
		assertEquals(new Integer(2), ((BLocalVariable)jvm.run(null,m,path, input)).getValue());
		assertTrue(((PredicateNode)path.getNode(5)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(10)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(15)).hasPassed());
		assertFalse(((PredicateNode)path.getNode(18)).hasPassed());

	}

	@Test
	public void testMethodTriangleTypePathID_10() {
		// create input
		TestPath path = TrianglePathBuilderUtility.createPathID10();
		Input input = TrianglePathBuilderUtility.createPathID10_input();

		// assertion
		GannonPathJVM jvm = new GannonPathJVM(); 
		assertEquals(new Integer(4), ((BLocalVariable)jvm.run(null,m,path, input)).getValue());
		assertTrue(((PredicateNode)path.getNode(5)).hasPassed());
	}

	@Test
	public void testMethodTriangleTypePathID_11() {
		// create input
		TestPath path = TrianglePathBuilderUtility.createPathID11();
		Input input = TrianglePathBuilderUtility.createPathID11_input();

		// assertion
		GannonPathJVM jvm = new GannonPathJVM(); 
		assertEquals(new Integer(4), ((BLocalVariable)jvm.run(null,m,path, input)).getValue());
		assertTrue(((PredicateNode)path.getNode(5)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(10)).hasPassed());
	}

	@Test
	public void testMethodTriangleTypePathID_12() {
		// create input
		TestPath path = TrianglePathBuilderUtility.createPathID12(); 
		Input input = TrianglePathBuilderUtility.createPathID12_input();

		// assertion
		GannonPathJVM jvm = new GannonPathJVM(); 
		assertEquals(new Integer(4), ((BLocalVariable)jvm.run(null,m,path, input)).getValue());
		assertTrue(((PredicateNode)path.getNode(5)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(10)).hasPassed());
		assertTrue(((PredicateNode)path.getNode(15)).hasPassed());
	}
}
