package com.gannon.jvm.data.dependency;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.gannon.asm.classgenerator.BClassGenerator;
import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.utilities.TrianglePathBuilderUtility;

public class GannonPredicateTreeBuilderJVMTest {
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
	public void testBuildPathID_1() {
		GannonPredicateTreeBuilderJVM jvm = new GannonPredicateTreeBuilderJVM();
		jvm.run(null, m, TrianglePathBuilderUtility.createPathID1(), TrianglePathBuilderUtility.createPathID1_input());
		System.out.println(jvm.getRelationFrame().getRelations());

		ArrayList<BinNode> expectedLeaves23 = new ArrayList<BinNode>();
		expectedLeaves23.add(new BinNode(2));
		expectedLeaves23.add(new BinNode(3));
		// 0:first parameter
		assertEquals(expectedLeaves23, jvm.getRelationFrame().getRelations().getRelation(4).getAllLeaves());

		ArrayList<BinNode> expectedLeaves123 = new ArrayList<BinNode>();
		expectedLeaves123.add(new BinNode(1));
		expectedLeaves123.add(new BinNode(2));
		expectedLeaves123.add(new BinNode(3));
		assertEquals(expectedLeaves123, jvm.getRelationFrame().getRelations().getRelation(5).getAllLeaves());

		

	}
	
	@Test
	public void testBuildPathID_1_inputs() {
		GannonPredicateTreeBuilderJVM jvm = new GannonPredicateTreeBuilderJVM();
		jvm.run(null, m, TrianglePathBuilderUtility.createPathID1(),TrianglePathBuilderUtility.createPathID1_input());

		ArrayList<BinNode> expectedLeaves23 = new ArrayList<BinNode>();
		expectedLeaves23.add(new BinNode(2));
		expectedLeaves23.add(new BinNode(3));
		// 0:first parameter
		assertEquals(expectedLeaves23, jvm.getRelationFrame().getRelations().getRelation(4).getAllLeaves());

		ArrayList<BinNode> expectedLeaves123 = new ArrayList<BinNode>();
		expectedLeaves123.add(new BinNode(1));
		expectedLeaves123.add(new BinNode(2));
		expectedLeaves123.add(new BinNode(3));
		assertEquals(expectedLeaves123, jvm.getRelationFrame().getRelations().getRelation(5).getAllLeaves());

		System.out.println(jvm.getRelationFrame().getRelations());

	}

	@Test
	public void testBuildPathID3() {
		GannonPredicateTreeBuilderJVM jvm = new GannonPredicateTreeBuilderJVM();
		jvm.run(null, m, TrianglePathBuilderUtility.createPathID3(),TrianglePathBuilderUtility.createPathID3_input());
		System.out.println(jvm.getRelationFrame().getRelations());

	}

	@Test
	public void testBuildPathID_8() {
		GannonPredicateTreeBuilderJVM jvm = new GannonPredicateTreeBuilderJVM();
		jvm.run(null, m, TrianglePathBuilderUtility.createPathID8(),TrianglePathBuilderUtility.createPathID8_input());
		System.out.println(jvm.getRelationFrame().getRelations());
	}

	@Test
	public void testBuildPathID_10() {
		GannonPredicateTreeBuilderJVM jvm = new GannonPredicateTreeBuilderJVM();
		jvm.run(null, m, TrianglePathBuilderUtility.createPathID10(),TrianglePathBuilderUtility.createPathID8_input());
		System.out.println(jvm.getRelationFrame().getRelations());

	}

}
