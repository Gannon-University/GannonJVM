package com.gannon.jvm.path.infeasible;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;

import org.objectweb.asm.Label;

import com.gannon.asm.components.BLabel;
import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.data.dependency.Dependency;
import com.gannon.jvm.instructions.BIFicmpgt;
import com.gannon.jvm.instructions.BIFicmplt;
import com.gannon.jvm.progam.path.TestPath;
import com.gannon.jvm.utilities.TrianglePathBuilderUtility;

import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class TestCyclePathMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		showCyclePath();
	}

	private static void showCyclePath() {
		UndirectedSparseGraph <FNode, FEdge> g = GraphBuilderUtil.buildGraph10Nodes();
		// construct a cycle path based on a graph and id of the path
		CyclePath cg=new CyclePath(0,new int[]{1,3,4},g); 
		VisualizationImageServer vs = new VisualizationImageServer(
				new KKLayout(cg), new Dimension(1000, 600));
		vs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vs.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());

		JFrame frame = new JFrame();
		frame.getContentPane().add(vs);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	

	
	private static void applyRule2GreatAndLess() {
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
		
		CyclePath cg=new CyclePath(0,new int[]{1,2},g); 
		
		VisualizationImageServer vs = new VisualizationImageServer(
				new KKLayout(cg), new Dimension(1000, 600));
		vs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vs.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());

		JFrame frame = new JFrame();
		frame.getContentPane().add(vs);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
