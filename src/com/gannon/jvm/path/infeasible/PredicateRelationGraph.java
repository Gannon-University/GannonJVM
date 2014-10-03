package com.gannon.jvm.path.infeasible;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.data.dependency.Dependency;
import com.gannon.jvm.data.dependency.GannonPredicateTreeBuilderJVM;
import com.gannon.jvm.data.dependency.PredicateResult;
import com.gannon.jvm.instructions.BIFicmpeq;
import com.gannon.jvm.instructions.BIFicmpge;
import com.gannon.jvm.instructions.BIFicmpgt;
import com.gannon.jvm.instructions.BIFicmplt;
import com.gannon.jvm.instructions.BIFicmpne;
import com.gannon.jvm.instructions.BInstruction;
import com.gannon.jvm.path.infeasible.rules.TrendRule;
import com.gannon.jvm.path.infeasible.rules.TrendRuleIFcmpeq;
import com.gannon.jvm.path.infeasible.rules.TrendRuleIFcmpge;
import com.gannon.jvm.path.infeasible.rules.TrendRuleIFcmpgt;
import com.gannon.jvm.path.infeasible.rules.TrendRuleIFcmplt;
import com.gannon.jvm.path.infeasible.rules.TrendRuleIFcmpne;
import com.gannon.jvm.progam.path.TestPath;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;

public class PredicateRelationGraph extends UndirectedSparseGraph<FNode, FEdge> {
	private BClass bClass;
	private BMethod method;
	private TestPath testPath;
	private Dependencies dps;
	
	public PredicateRelationGraph(BClass bClass, BMethod method, TestPath testPath) {
		super();
		this.bClass = bClass;
		this.method = method;
		this.testPath = testPath;
		generatePRG();
	}

	public List<CyclePath> computingCycles() {
		CyclePathComputingHelper gf = new CyclePathComputingHelper(this);
		return gf.computingCyclePaths();
	}

	private void generatePRG() {
		List<Dependency> predicateRelations = extractPredicateRelations();
		addNodes(predicateRelations);
		addEdges();
	}

	/**
	 * @param prg
	 *            is predicate relation graph where each node of the graph
	 *            contains a dependency
	 */
	private void addEdges() {
		int edgeId = 0;// start from 0
		List<FNode> nodes = new ArrayList<FNode>(getVertices());
		for (int i = 0; i < nodes.size(); i++) {
			FNode source = nodes.get(i);
			for (int j = i + 1; j < nodes.size(); j++) {
				FNode target = nodes.get(j);
				FEdgeData edgeData=new FEdgeData(source.getTrends(dps), target.getTrends(dps));	 
				if (edgeData.hasCommonNodes()) {
					FEdge edge = new FEdge(edgeId);
					edge.setData(edgeData);
					addEdge(edge, source, target);
					edgeId++;// increase edgeID
				}
			}
		}
	}

	public List<FEdge> computingSelfLoopEdges() {
		int selfLoopEdgeNum = Integer.MAX_VALUE;
		List<FEdge> selfLoopEdges = new ArrayList<FEdge>();
		List<FNode> nodes = new ArrayList<FNode>(getVertices());
		for (int i = 0; i < nodes.size(); i++) {
			FNode source = nodes.get(i);
			for (int j = i+1; j < nodes.size(); j++) {
				FNode target = nodes.get(j);
				FEdgeData edgeData=new FEdgeData(source.getTrends(dps), target.getTrends(dps));	 
				if (source.containsSameLeaves(target)) {
					selfLoopEdges.add(new FEdge(selfLoopEdgeNum, edgeData));
				}
			}
		}
		return selfLoopEdges;
	}

	private void addNodes(List<Dependency> predicateRelations) {
		for (int i = 0; i < predicateRelations.size(); i++) {
			addVertex(new FNode(i, new FNodeData(predicateRelations.get(i))));
		}
	}

	private List<Dependency> extractPredicateRelations() {
		// Get all relations
		GannonPredicateTreeBuilderJVM jvm = new GannonPredicateTreeBuilderJVM();
		
		// we really don't care about the input here
		jvm.run(bClass, method, testPath); 
		dps = jvm.getRelationFrame().getRelations();

		// Get the relations pertaining to "if" statements
		List<Dependency> predicateRelations = dps.getPredicateDependencies();

		// Extract expected result from nodes and update predicateRelations
		dps.updateExpectedPredicateResultFromTestCase(predicateRelations,
				testPath);
		return predicateRelations;
	}

	public Dependencies getRelations() {
		return dps;
	}
}
