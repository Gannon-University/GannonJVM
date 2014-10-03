package com.gannon.jvm.path.infeasible;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;

import com.gannon.asm.classgenerator.BClassGenerator;
import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.data.dependency.GannonPredicateTreeBuilderJVM;
import com.gannon.jvm.progam.path.TestPath;
import com.gannon.jvm.utilities.InfeasiblePathUtility;
import com.gannon.jvm.utilities.TrianglePathBuilderUtility;

import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.algorithms.layout.SpringLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.Graphs;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class TestCyclePathComputingHelperMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// showPaths10Nodes();
		//showPathsID1Cycle0();
		showTrianglePRGCyclePath4();

	}

	// this one need more work
	private static void showPaths10Nodes() {
		UndirectedSparseGraph<FNode, FEdge> g = GraphBuilderUtil.buildGraph10Nodes();
		CyclePathComputingHelper gf = new CyclePathComputingHelper(g);
		List<CyclePath> gs = gf.computingCyclePaths();
	

		VisualizationImageServer vs = new VisualizationImageServer(
				new KKLayout(gs.get(0)), new Dimension(1000, 600));
		vs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vs.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());

		JFrame frame = new JFrame();
		frame.getContentPane().add(vs);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	// this one need more work
	private static void showPathsID1Cycle0() {
		 BClass myclass=BClassGenerator.getBClass("Triangle.class");
		 BMethod m=myclass.getMethod("triangleType");
		TestPath path = TrianglePathBuilderUtility.createPathID9();
		PredicateRelationGraph g = new PredicateRelationGraph(myclass, m, path);

		CyclePathComputingHelper gf = new CyclePathComputingHelper(g);
		List<CyclePath> gs = gf.computingCyclePaths();
		//System.out.println("ALl  marked as used" + gs.get(0).isAllMarked());

		VisualizationImageServer vs = new VisualizationImageServer(
				new KKLayout(gs.get(0)), new Dimension(1000, 600));
		vs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vs.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());

		JFrame frame = new JFrame();
		frame.getContentPane().add(vs);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	// this one need more work
	private static void showPaths1CycleABC() {
		 BClass myclass=BClassGenerator.getBClass("Triangle.class");
		 BMethod m=myclass.getMethod("triangleType");
		TestPath path = InfeasiblePathUtility.createPathID1();
		PredicateRelationGraph g = new PredicateRelationGraph(myclass, m, path);

		CyclePathComputingHelper gf = new CyclePathComputingHelper(g);
		List<CyclePath> gs = gf.computingCyclePaths();
		//System.out.println("ALl  marked as used" + gs.get(0).isAllMarked());

		VisualizationImageServer vs = new VisualizationImageServer(
				new SpringLayout(gs.get(0)), new Dimension(1000, 600));
		vs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vs.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());

		JFrame frame = new JFrame();
		frame.getContentPane().add(vs);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	// this one need more work
	private static void showTrianglePRGCyclePath4() {
		 BClass myclass=BClassGenerator.getBClass("Triangle.class");
		 BMethod m=myclass.getMethod("triangleType");
		TestPath path=TrianglePathBuilderUtility.createPathID4();
		PredicateRelationGraph g = new PredicateRelationGraph(myclass, m, path);

		CyclePathComputingHelper gf = new CyclePathComputingHelper(g);
		List<CyclePath> gs = gf.computingCyclePaths();
		//System.out.println("ALl  marked as used" + gs.get(0).isAllMarked());
		System.out.println("Size of cycle=" +gs.size());

		VisualizationImageServer vs = new VisualizationImageServer(
				new KKLayout(gs.get(0)), new Dimension(1000, 600));
		vs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vs.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());

		JFrame frame = new JFrame();
		frame.getContentPane().add(vs);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true); 
	}
}
