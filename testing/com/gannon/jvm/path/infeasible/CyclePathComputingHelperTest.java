package com.gannon.jvm.path.infeasible;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.gannon.jvm.data.dependency.Dependency;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;

public class CyclePathComputingHelperTest {

	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};

	@Test
	public void testIntNode() {
		// Graph modeled as list of edges
		/*
		 * [1,3,2] [1,4,3,2] [ 1,4,6,2] [1,3,4,6,2] [1,4,6,2,3] [1,4,3]
		 * [2,6,4,3] [7,9,8]
		 */
		int[][] graph = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 3 }, { 3, 4 },
				{ 2, 6 }, { 4, 6 }, { 7, 8 }, { 8, 9 }, { 9, 7 } };

		CyclePathComputingHelper gf = new CyclePathComputingHelper(graph);
		List<int []> cycles=gf.computingAllCycles();

		assertArrayEquals(new int[] { 1, 3, 2 }, cycles.get(0));
		assertArrayEquals(new int[] {1,4,3,2}, cycles.get(1));
		assertArrayEquals(new int[] {1,4,6,2 }, cycles.get(2));
		assertArrayEquals(new int[] { 1,3,4,6,2 }, cycles.get(3));
		assertArrayEquals(new int[] { 1,4,6,2,3 }, cycles.get(4));
		assertArrayEquals(new int[] { 1,4,3 }, cycles.get(5));
		assertArrayEquals(new int[] { 2,6,4,3 }, cycles.get(6));
		assertArrayEquals(new int[] { 7,9,8 }, cycles.get(7));
	}

	@Test
	public void testFNode() {
		// Graph modeled as list of edges
		/*
		 * int[][] graph = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 3 }, { 3, 4 }, {
		 * 2, 6 }, { 4, 6 }, { 7, 8 }, { 8, 9 }, { 9, 7 } };
		 * [1,3,2] [1,4,3,2] [1,4,6,2] [1,3,4,6,2] [1,4,6,2,3] [1,4,3] [2,6,4,3] [7,9,8]
		 */
		Graph<FNode, FEdge> prg = new UndirectedSparseGraph<FNode, FEdge>();
		prg.addVertex(new FNode(1, null));
		prg.addVertex(new FNode(2, null));
		prg.addVertex(new FNode(3, null));
		prg.addVertex(new FNode(4, null));
		prg.addVertex(new FNode(5, null));
		prg.addVertex(new FNode(6, null));
		prg.addVertex(new FNode(7, null));
		prg.addVertex(new FNode(8, null));
		prg.addVertex(new FNode(8, null));

		prg.addEdge(new FEdge(0), new FNode(1, null), new FNode(2, null));
		prg.addEdge(new FEdge(1), new FNode(1, null), new FNode(3, null));
		prg.addEdge(new FEdge(2), new FNode(1, null), new FNode(4, null));
		prg.addEdge(new FEdge(3), new FNode(2, null), new FNode(3, null));
		prg.addEdge(new FEdge(4), new FNode(3, null), new FNode(4, null));
		prg.addEdge(new FEdge(5), new FNode(2, null), new FNode(6, null));
		prg.addEdge(new FEdge(6), new FNode(4, null), new FNode(6, null));
		prg.addEdge(new FEdge(7), new FNode(7, null), new FNode(8, null));
		prg.addEdge(new FEdge(8), new FNode(8, null), new FNode(9, null));
		prg.addEdge(new FEdge(9), new FNode(9, null), new FNode(7, null));

		CyclePathComputingHelper gf = new CyclePathComputingHelper(prg);
		List<int []> cycles=gf.computingAllCycles();

		
		assertArrayEquals(new int[] { 1, 3, 2 }, cycles.get(0));
		assertArrayEquals(new int[] {1,4,3,2}, cycles.get(1));
		assertArrayEquals(new int[] {1,4,6,2 }, cycles.get(2));
		assertArrayEquals(new int[] { 1,3,4,6,2 }, cycles.get(3));
		assertArrayEquals(new int[] { 1,4,6,2,3 }, cycles.get(4));
		assertArrayEquals(new int[] { 1,4,3 }, cycles.get(5));
		assertArrayEquals(new int[] { 2,6,4,3 }, cycles.get(6));
		assertArrayEquals(new int[] { 7,9,8 }, cycles.get(7));
		
		for (int[] cy : cycles) {
			String s = "" + cy[0];

			for (int i = 1; i < cy.length; i++) {
				s += "," + cy[i];
			}

			gf.o(s);
		}
	}

}
