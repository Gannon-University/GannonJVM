package com.gannon.jvm.path.infeasible;

import org.objectweb.asm.Label;

import com.gannon.asm.components.BLabel;
import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.data.dependency.Dependency;
import com.gannon.jvm.instructions.BIFicmpgt;
import com.gannon.jvm.instructions.BIFicmplt;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;


//http://stackoverflow.com/questions/12367801/finding-all-cycles-in-undirected-graphs
public class GraphBuilderUtil {

	public static UndirectedSparseGraph buildGraph10Nodes() {
		// Graph modeled as list of edges
		/*
		 * [1,3,2] [1,4,3,2] [ 1,4,6,2] [1,3,4,6,2] [1,4,6,2,3] [1,4,3]
		 * [2,6,4,3] [7,9,8]
		 */
		int[][] graph = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 3 }, { 3, 4 },
				{ 2, 6 }, { 4, 6 }, { 7, 8 }, { 8, 9 }, { 9, 7 } };
		UndirectedSparseGraph<FNode, FEdge> g = new UndirectedSparseGraph<FNode, FEdge>();

		FNode fNode1 = new FNode(1, null);
		g.addVertex(fNode1);
		FNode fNode2 = new FNode(2, null);
		g.addVertex(fNode2);
		FNode fNode3 = new FNode(3, null);
		g.addVertex(fNode3);
		FNode fNode4 = new FNode(4, null);
		g.addVertex(fNode4);
		FNode fNode5 = new FNode(5, null);
		g.addVertex(fNode5);
		FNode fNode6 = new FNode(6, null);
		g.addVertex(fNode6);
		FNode fNode7 = new FNode(7, null);
		g.addVertex(fNode7);
		FNode fNode8 = new FNode(8, null);
		g.addVertex(fNode8);
		FNode fNode9 = new FNode(9, null);
		g.addVertex(fNode9);

		g.addEdge(new FEdge(0), fNode1, fNode2);
		g.addEdge(new FEdge(1), fNode1, fNode3);
		g.addEdge(new FEdge(2), fNode1, fNode4);
		g.addEdge(new FEdge(3), fNode2, fNode3);
		g.addEdge(new FEdge(4), fNode3, fNode4);
		g.addEdge(new FEdge(5), fNode2, fNode6);
		g.addEdge(new FEdge(6), fNode4, fNode6);
		g.addEdge(new FEdge(7), fNode7, fNode8);
		g.addEdge(new FEdge(8), fNode8, fNode9);
		g.addEdge(new FEdge(9), fNode9, fNode7);
		return g;
	}
	
	
	public static UndirectedSparseGraph buildGraphWithNodesAB() {
		// Graph modeled as list of edges
		/*
		 * a>b and  b>a
		 */

		BinNode i4 = new BinNode(4, new BLocalVariable(null, null, null, null, null, 1));
		BLabel lable = new BLabel(new Label());
		BinNode i1_left = new BinNode(1, new BLocalVariable(null, null, null, null, null, 1));
		BinNode i2_left = new BinNode(2, new BLocalVariable(null, null, null, null, null, 1));

		Dependency d4 = new Dependency(i4, new BIFicmpgt(lable,22));
		d4.insertToLeft(i1_left);
		d4.insertToRight(i2_left);
		Dependencies dependencies = new Dependencies();
		dependencies.add(d4);
		
		FNodeData data_left=new FNodeData(d4);
				
	
		BinNode i5 = new BinNode(5, new BLocalVariable(null, null, null, null, null, 1));
		BinNode i1_right = new BinNode(1, new BLocalVariable(null, null, null, null, null, 1));
		BinNode i2_right = new BinNode(2, new BLocalVariable(null, null, null, null, null, 1));

		Dependency d5 = new Dependency(i5, new BIFicmplt(lable,44));
		d5.insertToLeft(i1_right);
		d5.insertToRight(i2_right);
		dependencies.add(d5);
		
		FNodeData data_right=new FNodeData(d5);
		
		UndirectedSparseGraph<FNode, FEdge> g = new UndirectedSparseGraph<FNode, FEdge>();
		FNode fNode1 = new FNode(1, data_left);
		g.addVertex(fNode1);
		FNode fNode2 = new FNode(2, data_right);
		g.addVertex(fNode2);
	

		g.addEdge(new FEdge(0), fNode1, fNode2);

		return g;
	}
}
