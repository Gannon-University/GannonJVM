package com.gannon.jvm.path.infeasible;

import java.awt.Dimension;

import javax.swing.JFrame;

import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class TesPredicateRelationGraphMain {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph g = GraphBuilderUtil.buildGraph10Nodes();
		VisualizationImageServer vs = new VisualizationImageServer(
				new KKLayout(g), new Dimension(1000, 600));
		vs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vs.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());

		JFrame frame = new JFrame();
		frame.getContentPane().add(vs);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}



}
