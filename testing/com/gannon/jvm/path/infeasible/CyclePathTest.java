package com.gannon.jvm.path.infeasible;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.gannon.asm.classgenerator.BClassGenerator;
import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.progam.path.TestPath;
import com.gannon.jvm.utilities.InfeasiblePathUtility;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;

public class CyclePathTest {
	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};

	@Test
	public void testCycleGraphAllMarked() {
		BClass myclass=BClassGenerator.getBClass("Triangle.class");
		BMethod m=myclass.getMethod("triangleType");
		TestPath path = InfeasiblePathUtility.createPathID1();
		PredicateRelationGraph g = new PredicateRelationGraph(myclass,m,path);

		CyclePathComputingHelper gf = new CyclePathComputingHelper(g);
		List<CyclePath> gs = gf.computingCyclePaths();
		assertTrue(gs.get(0).isAllMarkedAsUsed());
		assertTrue("isConflict method true is incorrect!!" ,gs.get(0).isConflict());
	}
}
