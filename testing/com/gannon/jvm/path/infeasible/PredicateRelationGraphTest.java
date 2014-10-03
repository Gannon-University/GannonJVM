package com.gannon.jvm.path.infeasible;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.gannon.asm.classgenerator.BClassGenerator;
import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.progam.path.TestPath;
import com.gannon.jvm.utilities.TrianglePathBuilderUtility;

import edu.uci.ics.jung.graph.Graph;

public class PredicateRelationGraphTest {
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
	public void setUp() throws Exception {
		 myclass=BClassGenerator.getBClass("Triangle.class");
		 m=myclass.getMethod("triangleType");
	}


	@Test
	public void testNumberOfPredicateOfPathID_1() {
		TestPath path=TrianglePathBuilderUtility.createPathID1();
		PredicateRelationGraph g=new PredicateRelationGraph(myclass, m,path);
		assertEquals(5, g.getVertexCount());
	}
	
	@Test
	public void testNumberOfPredicateOfPathID_2() {
		TestPath path=TrianglePathBuilderUtility.createPathID2();
		PredicateRelationGraph g=new PredicateRelationGraph(myclass, m,path);
		assertEquals(5, g.getVertexCount());
	}
	
	@Test
	public void testNumberOfPredicateOfPathID_3() {
		TestPath path=TrianglePathBuilderUtility.createPathID3();
		PredicateRelationGraph g=new PredicateRelationGraph(myclass, m,path);
		assertEquals(6, g.getVertexCount());
	}

}
