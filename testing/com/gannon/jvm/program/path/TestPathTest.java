package com.gannon.jvm.program.path;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.objectweb.asm.Label;

import com.gannon.asm.classgenerator.BClassGenerator;
import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BLabel;
import com.gannon.asm.components.BMethod;
import com.gannon.bytecode.controlflowgraph.CBlock;
import com.gannon.bytecode.controlflowgraph.CEdge;
import com.gannon.bytecode.controlflowgraph.CGraph;
import com.gannon.bytecode.controlflowgraph.CNode;
import com.gannon.bytecode.controlflowgraph.CPath;
import com.gannon.jvm.instructions.BIAdd;
import com.gannon.jvm.instructions.BIConst_2;
import com.gannon.jvm.instructions.BIFicmpeq;
import com.gannon.jvm.instructions.BIFicmpge;
import com.gannon.jvm.instructions.BIFicmpne;
import com.gannon.jvm.instructions.BILoad;
import com.gannon.jvm.instructions.BIReturn;
import com.gannon.jvm.progam.path.Node;
import com.gannon.jvm.progam.path.NonPredicateNode;
import com.gannon.jvm.progam.path.PredicateNode;
import com.gannon.jvm.progam.path.TestPath;
import com.gannon.jvm.utilities.ConstantsUtility;
import com.gannon.jvm.utilities.InfeasiblePathUtility;
import com.gannon.jvm.utilities.LargestNumSumPathBuilderUtility;
import com.gannon.jvm.utilities.NextDatePathBuilderUtility;
import com.gannon.jvm.utilities.TrianglePathBuilderUtility;

public class TestPathTest {
	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};

	@Test
	public void testEquals() {
		assertEquals(TrianglePathBuilderUtility.createPathID1(), TrianglePathBuilderUtility.createPathID1());
	}

	@Test
	public void testEqualsNotEqual() {
		// use Unit 4.11 version
		assertNotEquals(TrianglePathBuilderUtility.createPathID1(), TrianglePathBuilderUtility.createPathID2());
	}

	@Test
	public void testEqualsNotEqualTwoVersion() {
		// use Unit 4.11 version
		assertNotEquals(createPathID8_V1(), createPathID8_V2());
	}

	private TestPath createPathID8_V1() {
		TestPath path = new TestPath();
		path.setPathId(8);

		Node node1 = new NonPredicateNode(new BILoad(1, 0));// 0 vs 1
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		Node node3 = new NonPredicateNode(new BILoad(3, 3));
		path.add(node3);

		Node node4 = new NonPredicateNode(new BIAdd(4));
		path.add(node4);

		BLabel lable = new BLabel(new Label());
		PredicateNode node5 = new PredicateNode(new BIFicmpge(lable, 5));
		node5.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node5);

		Node node6 = new NonPredicateNode(new BILoad(2, 6));
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(1, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BILoad(3, 8));
		path.add(node8);

		Node node9 = new NonPredicateNode(new BIAdd(9));
		path.add(node9);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node10 = new PredicateNode(new BIFicmpge(lable2, 10));
		node10.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node10);

		Node node11 = new NonPredicateNode(new BILoad(3, 11));
		path.add(node11);

		Node node12 = new NonPredicateNode(new BILoad(1, 12));
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(2, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BIAdd(14));
		path.add(node14);

		BLabel lable3 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpge(lable3, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(1, 16));
		path.add(node16);

		Node node17 = new NonPredicateNode(new BILoad(2, 17));
		path.add(node17);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable4, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);

		Node node24 = new NonPredicateNode(new BILoad(1, 24));
		path.add(node24);

		Node node25 = new NonPredicateNode(new BILoad(2, 25));
		path.add(node25);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node26 = new PredicateNode(new BIFicmpeq(lable5, 26));
		node26.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node26);

		Node node27 = new NonPredicateNode(new BILoad(1, 27));
		path.add(node27);

		Node node28 = new NonPredicateNode(new BILoad(3, 22));
		path.add(node28);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node29 = new PredicateNode(new BIFicmpeq(lable6, 23));
		node29.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node29);

		Node node30 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node30);

		Node node31 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node31);

		BLabel lable7 = new BLabel(new Label());
		PredicateNode node32 = new PredicateNode(new BIFicmpeq(lable7, 26));
		node32.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node32);

		Node node33 = new NonPredicateNode(new BIConst_2(27));
		path.add(node33);

		Node node34 = new NonPredicateNode(new BIReturn(28));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("Triangle.class");
		BMethod m = myclass.getMethod("triangleType");

		// set method in the path
		path.setbMethod(m);

		return path;
	}

	private TestPath createPathID8_V2() {
		TestPath path = new TestPath();
		path.setPathId(8);

		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		Node node3 = new NonPredicateNode(new BILoad(3, 3));
		path.add(node3);

		Node node4 = new NonPredicateNode(new BIAdd(4));
		path.add(node4);

		BLabel lable = new BLabel(new Label());
		PredicateNode node5 = new PredicateNode(new BIFicmpge(lable, 5));
		node5.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node5);

		Node node6 = new NonPredicateNode(new BILoad(2, 6));
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(1, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BILoad(3, 8));
		path.add(node8);

		Node node9 = new NonPredicateNode(new BIAdd(9));
		path.add(node9);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node10 = new PredicateNode(new BIFicmpge(lable2, 10));
		node10.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node10);

		Node node11 = new NonPredicateNode(new BILoad(3, 11));
		path.add(node11);

		Node node12 = new NonPredicateNode(new BILoad(1, 12));
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(2, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BIAdd(14));
		path.add(node14);

		BLabel lable3 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpge(lable3, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(1, 16));
		path.add(node16);

		Node node17 = new NonPredicateNode(new BILoad(2, 17));
		path.add(node17);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable4, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);

		Node node24 = new NonPredicateNode(new BILoad(1, 24));
		path.add(node24);

		Node node25 = new NonPredicateNode(new BILoad(2, 25));
		path.add(node25);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node26 = new PredicateNode(new BIFicmpeq(lable5, 26));
		node26.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node26);

		Node node27 = new NonPredicateNode(new BILoad(1, 27));
		path.add(node27);

		Node node28 = new NonPredicateNode(new BILoad(3, 22));
		path.add(node28);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node29 = new PredicateNode(new BIFicmpeq(lable6, 23));
		node29.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node29);

		Node node30 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node30);

		Node node31 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node31);

		BLabel lable7 = new BLabel(new Label());
		PredicateNode node32 = new PredicateNode(new BIFicmpeq(lable7, 26));
		node32.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node32);

		Node node33 = new NonPredicateNode(new BIConst_2(27));
		path.add(node33);

		Node node34 = new NonPredicateNode(new BIReturn(28));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("Triangle.class");
		BMethod m = myclass.getMethod("triangleType");

		// set method in the path
		path.setbMethod(m);

		return path;
	}


	@Test
	public void testIsInFeasiblePathTriangle() {
		assertFalse(" is feasible triangle path 1", TrianglePathBuilderUtility.createPathID1().isInfeasible());
		assertTrue(" is feasible triangle path 2", TrianglePathBuilderUtility.createPathID2().isInfeasible());
		assertFalse(" is feasible triangle path 3", TrianglePathBuilderUtility.createPathID3().isInfeasible());
		assertFalse(" is feasible triangle path 4", TrianglePathBuilderUtility.createPathID4().isInfeasible());
		assertFalse(" is feasible triangle path 5", TrianglePathBuilderUtility.createPathID5().isInfeasible());
		assertTrue(" is feasible triangle path 6", TrianglePathBuilderUtility.createPathID6().isInfeasible());
		assertTrue(" is feasible triangle path 7", TrianglePathBuilderUtility.createPathID7().isInfeasible());
		assertFalse(" is feasible triangle path 8", TrianglePathBuilderUtility.createPathID8().isInfeasible());
		assertTrue(" is feasible triangle path 9", TrianglePathBuilderUtility.createPathID9().isInfeasible());
		assertFalse(" is feasible triangle path 10", TrianglePathBuilderUtility.createPathID10().isInfeasible());
		assertFalse(" is feasible triangle path 11", TrianglePathBuilderUtility.createPathID11().isInfeasible());
		assertFalse(" is feasible triangle path 12", TrianglePathBuilderUtility.createPathID12().isInfeasible());		
	}
	
	@Test
	public void testIsInFeasiblePathCycleABC() {
		assertTrue(" is feasible triangle path 1", InfeasiblePathUtility.createPathID1().isInfeasible());
	}
	
	
	@Test
	public void testIsInFeasiblePathLargestNumbeSum() {
		System.out.println("LargestNumSum path 1");
		assertFalse(" is feasible LargestNumSum path 1", LargestNumSumPathBuilderUtility.createPathID1().isInfeasible());
		System.out.println("LargestNumSum path 2");
		assertFalse(" is feasible LargestNumSum path 2", LargestNumSumPathBuilderUtility.createPathID2().isInfeasible());
		System.out.println("LargestNumSum path 3");
		assertTrue(" is feasible LargestNumSum path 3", LargestNumSumPathBuilderUtility.createPathID3().isInfeasible());
		System.out.println("LargestNumSum path 4");
		assertTrue(" is feasible LargestNumSum path 4", LargestNumSumPathBuilderUtility.createPathID4().isInfeasible());
		System.out.println("LargestNumSum path 5");
		assertFalse(" is feasible LargestNumSum path 5", LargestNumSumPathBuilderUtility.createPathID5().isInfeasible());
		System.out.println("LargestNumSum path 6");
		assertTrue(" is feasible LargestNumSum path 6", LargestNumSumPathBuilderUtility.createPathID6().isInfeasible());
		System.out.println("LargestNumSum path 7");
		assertFalse(" is feasible LargestNumSum path 7", LargestNumSumPathBuilderUtility.createPathID7().isInfeasible());
		System.out.println("LargestNumSum path 8");
		assertFalse(" is feasible LargestNumSum path 8", LargestNumSumPathBuilderUtility.createPathID8().isInfeasible());
		System.out.println("LargestNumSum path 9");
		assertFalse(" is feasible LargestNumSum path 9", LargestNumSumPathBuilderUtility.createPathID9().isInfeasible());
		System.out.println("LargestNumSum path 10");
		assertTrue(" is feasible LargestNumSum path 10", LargestNumSumPathBuilderUtility.createPathID10().isInfeasible());
		System.out.println("LargestNumSum path 11");
		assertTrue(" is feasible LargestNumSum path 11", LargestNumSumPathBuilderUtility.createPathID11().isInfeasible());
		System.out.println("LargestNumSum path 12");
		assertFalse(" is feasible LargestNumSum path 12", LargestNumSumPathBuilderUtility.createPathID12().isInfeasible());
		System.out.println("LargestNumSum path 13");
		assertTrue(" is feasible LargestNumSum path 13", LargestNumSumPathBuilderUtility.createPathID13().isInfeasible());
		System.out.println("LargestNumSum path 14");
		assertFalse(" is feasible LargestNumSum path 14", LargestNumSumPathBuilderUtility.createPathID14().isInfeasible());
		System.out.println("LargestNumSum path 15");
		assertTrue(" is feasible LargestNumSum path 15", LargestNumSumPathBuilderUtility.createPathID15().isInfeasible());
		System.out.println("LargestNumSum path 16");
		assertTrue(" is feasible LargestNumSum path 16", LargestNumSumPathBuilderUtility.createPathID16().isInfeasible());
		System.out.println("LargestNumSum path 17");
		assertTrue(" is feasible LargestNumSum path 17", LargestNumSumPathBuilderUtility.createPathID17().isInfeasible());
		System.out.println("LargestNumSum path 18");
		assertTrue(" is feasible LargestNumSum path 18", LargestNumSumPathBuilderUtility.createPathID18().isInfeasible());
		System.out.println("LargestNumSum path 19");
		assertTrue(" is feasible LargestNumSum path 19", LargestNumSumPathBuilderUtility.createPathID19().isInfeasible());
		System.out.println("LargestNumSum path 20");
		assertTrue(" is feasible LargestNumSum path 20", LargestNumSumPathBuilderUtility.createPathID20().isInfeasible());
		System.out.println("LargestNumSum path 21");
		assertTrue(" is feasible LargestNumSum path 21", LargestNumSumPathBuilderUtility.createPathID21().isInfeasible());
		System.out.println("LargestNumSum path 22");
		assertTrue(" is feasible LargestNumSum path 22", LargestNumSumPathBuilderUtility.createPathID22().isInfeasible());
		System.out.println("LargestNumSum path 23");
		assertFalse(" is feasible LargestNumSum path 23", LargestNumSumPathBuilderUtility.createPathID23().isInfeasible());
		System.out.println("LargestNumSum path 24");
		assertFalse(" is feasible LargestNumSum path 24", LargestNumSumPathBuilderUtility.createPathID24().isInfeasible());
		System.out.println("LargestNumSum path 25");
		assertTrue(" is feasible LargestNumSum path 25", LargestNumSumPathBuilderUtility.createPathID25().isInfeasible());
		System.out.println("LargestNumSum path 26");
		assertTrue(" is feasible LargestNumSum path 26", LargestNumSumPathBuilderUtility.createPathID26().isInfeasible());
		System.out.println("LargestNumSum path 27");
		assertFalse(" is feasible LargestNumSum path 27", LargestNumSumPathBuilderUtility.createPathID27().isInfeasible());
		System.out.println("LargestNumSum path 28");
		assertTrue(" is feasible LargestNumSum path 28", LargestNumSumPathBuilderUtility.createPathID28().isInfeasible());
		System.out.println("LargestNumSum path 29");
		assertFalse(" is feasible LargestNumSum path 29", LargestNumSumPathBuilderUtility.createPathID29().isInfeasible());
		System.out.println("LargestNumSum path 30");
		assertTrue(" is feasible LargestNumSum path 30", LargestNumSumPathBuilderUtility.createPathID30().isInfeasible());
		System.out.println("LargestNumSum path 31");
		assertTrue(" is feasible LargestNumSum path 31", LargestNumSumPathBuilderUtility.createPathID31().isInfeasible());
		System.out.println("LargestNumSum path 32");
		assertTrue(" is feasible LargestNumSum path 32", LargestNumSumPathBuilderUtility.createPathID32().isInfeasible());
		System.out.println("LargestNumSum path 33");
		assertTrue(" is feasible LargestNumSum path 33", LargestNumSumPathBuilderUtility.createPathID33().isInfeasible());
		System.out.println("LargestNumSum path 34");
		assertTrue(" is feasible LargestNumSum path 34", LargestNumSumPathBuilderUtility.createPathID34().isInfeasible());
		System.out.println("LargestNumSum path 35");
		assertTrue(" is feasible LargestNumSum path 35", LargestNumSumPathBuilderUtility.createPathID35().isInfeasible());
		System.out.println("LargestNumSum path 36");
		assertTrue(" is feasible LargestNumSum path 36", LargestNumSumPathBuilderUtility.createPathID36().isInfeasible());
		System.out.println("LargestNumSum path 37");
		assertFalse(" is feasible LargestNumSum path 37", LargestNumSumPathBuilderUtility.createPathID37().isInfeasible());
		System.out.println("LargestNumSum path 38");
		assertFalse(" is feasible LargestNumSum path 38", LargestNumSumPathBuilderUtility.createPathID38().isInfeasible());
		System.out.println("LargestNumSum path 39");
		assertTrue(" is feasible LargestNumSum path 39", LargestNumSumPathBuilderUtility.createPathID39().isInfeasible());
		System.out.println("LargestNumSum path 40");
		assertTrue(" is feasible LargestNumSum path 40", LargestNumSumPathBuilderUtility.createPathID40().isInfeasible());
		System.out.println("LargestNumSum path 41");
		assertFalse(" is feasible LargestNumSum path 41", LargestNumSumPathBuilderUtility.createPathID41().isInfeasible());
		System.out.println("LargestNumSum path 42");
		assertTrue(" is feasible LargestNumSum path 42", LargestNumSumPathBuilderUtility.createPathID42().isInfeasible());
		System.out.println("LargestNumSum path 43");
		assertFalse(" is feasible LargestNumSum path 43", LargestNumSumPathBuilderUtility.createPathID43().isInfeasible());

	}
	
	
	
	
//	@Test
//	public void testIsInFeasiblePathNextDate() {
//		System.out.println("NextDate path 1");
//		assertFalse(" is feasible NextDate path 1", NextDatePathBuilderUtility.createPathID1().isInfeasible());
//		System.out.println("NextDate path 2");
//		assertFalse(" is feasible NextDate path 2", NextDatePathBuilderUtility.createPathID2().isInfeasible());
//		System.out.println("NextDate path 3");
//		assertFalse(" is feasible NextDate path 3", NextDatePathBuilderUtility.createPathID3().isInfeasible());
//		System.out.println("NextDate path 4");
//		assertFalse(" is feasible NextDate path 4", NextDatePathBuilderUtility.createPathID4().isInfeasible());
//		System.out.println("NextDate path 5");
//		assertFalse(" is feasible NextDate path 5", NextDatePathBuilderUtility.createPathID5().isInfeasible());
//		System.out.println("NextDate path 6");
//		assertFalse(" is feasible NextDate path 6", NextDatePathBuilderUtility.createPathID6().isInfeasible());
//		System.out.println("NextDate path 7");
//		assertFalse(" is feasible NextDate path 7", NextDatePathBuilderUtility.createPathID7().isInfeasible());
//		System.out.println("NextDate path 8");
//		assertFalse(" is feasible NextDate path 8", NextDatePathBuilderUtility.createPathID8().isInfeasible());
//		System.out.println("NextDate path 9");
//		assertFalse(" is feasible NextDate path 9", NextDatePathBuilderUtility.createPathID9().isInfeasible());
//		System.out.println("NextDate path 10");
//		assertFalse(" is feasible NextDate path 10", NextDatePathBuilderUtility.createPathID10().isInfeasible());
//		System.out.println("NextDate path 11");
//		assertFalse(" is feasible NextDate path 11", NextDatePathBuilderUtility.createPathID11().isInfeasible());
//		System.out.println("NextDate path 12");
//		assertFalse(" is feasible NextDate path 12", NextDatePathBuilderUtility.createPathID12().isInfeasible());
//		System.out.println("NextDate path 13");
//		assertFalse(" is feasible NextDate path 13", NextDatePathBuilderUtility.createPathID13().isInfeasible());
//		System.out.println("NextDate path 14");
//		assertFalse(" is feasible NextDate path 14", NextDatePathBuilderUtility.createPathID14().isInfeasible());
//		System.out.println("NextDate path 15");
//		assertFalse(" is feasible NextDate path 15", NextDatePathBuilderUtility.createPathID15().isInfeasible());
//		System.out.println("NextDate path 16");
//		assertFalse(" is feasible NextDate path 16", NextDatePathBuilderUtility.createPathID16().isInfeasible());
//		System.out.println("NextDate path 17");
//		assertFalse(" is feasible NextDate path 17", NextDatePathBuilderUtility.createPathID17().isInfeasible());
//		System.out.println("NextDate path 18");
//		assertFalse(" is feasible NextDate path 18", NextDatePathBuilderUtility.createPathID18().isInfeasible());
//		System.out.println("NextDate path 19");
//		assertFalse(" is feasible NextDate path 19", NextDatePathBuilderUtility.createPathID19().isInfeasible());
//		System.out.println("NextDate path 20");
//		assertFalse(" is feasible NextDate path 20", NextDatePathBuilderUtility.createPathID20().isInfeasible());
//		System.out.println("NextDate path 21");
//		assertFalse(" is feasible NextDate path 21", NextDatePathBuilderUtility.createPathID21().isInfeasible());
//		System.out.println("NextDate path 22");
//		assertFalse(" is feasible NextDate path 22", NextDatePathBuilderUtility.createPathID22().isInfeasible());
//		System.out.println("NextDate path 23");
//		assertFalse(" is feasible NextDate path 23", NextDatePathBuilderUtility.createPathID23().isInfeasible());
//		System.out.println("NextDate path 24");
//		assertFalse(" is feasible NextDate path 24", NextDatePathBuilderUtility.createPathID24().isInfeasible());
//		System.out.println("NextDate path 25");
//		assertFalse(" is feasible NextDate path 25", NextDatePathBuilderUtility.createPathID25().isInfeasible());
//		System.out.println("NextDate path 26");
//		assertFalse(" is feasible NextDate path 26", NextDatePathBuilderUtility.createPathID26().isInfeasible());
//		System.out.println("NextDate path 27");
//		assertFalse(" is feasible NextDate path 27", NextDatePathBuilderUtility.createPathID27().isInfeasible());
//		System.out.println("NextDate path 28");
//		assertFalse(" is feasible NextDate path 28", NextDatePathBuilderUtility.createPathID28().isInfeasible());
//		System.out.println("NextDate path 29");
//		assertFalse(" is feasible NextDate path 29", NextDatePathBuilderUtility.createPathID29().isInfeasible());
//		System.out.println("NextDate path 30");
//		assertFalse(" is feasible NextDate path 30", NextDatePathBuilderUtility.createPathID30().isInfeasible());
//		System.out.println("NextDate path 31");
//		assertFalse(" is feasible NextDate path 31", NextDatePathBuilderUtility.createPathID31().isInfeasible());
//		System.out.println("NextDate path 32");
//		assertFalse(" is feasible NextDate path 32", NextDatePathBuilderUtility.createPathID32().isInfeasible());
//		System.out.println("NextDate path 33");
//		assertFalse(" is feasible NextDate path 33", NextDatePathBuilderUtility.createPathID33().isInfeasible());
//		System.out.println("NextDate path 34");
//		assertFalse(" is feasible NextDate path 34", NextDatePathBuilderUtility.createPathID34().isInfeasible());
//		System.out.println("NextDate path 35");
//		assertFalse(" is feasible NextDate path 35", NextDatePathBuilderUtility.createPathID35().isInfeasible());
//
//		
//	}
	
	
}
