package com.gannon.jvm.path.infeasible;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.data.dependency.Dependency;
import com.gannon.jvm.instructions.BIFicmpeq;
import com.gannon.jvm.instructions.BIFicmpge;
import com.gannon.jvm.instructions.BIFicmpgt;
import com.gannon.jvm.instructions.BIFicmplt;
import com.gannon.jvm.instructions.BIFicmpne;
import com.gannon.jvm.instructions.BInstruction;
import com.gannon.jvm.path.infeasible.rules.*;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;



/**
 * @author Frank
 * a cycle path is a sub-graph of parent graph which start and end notes are the same
 * why need this class? 
 * The graphCycleComputingHelper only able to find a list of paths represented by integers, e.g., [1,2]
 * The class convert the path to a graph so all the edges can be checked  
 */
public class CyclePath extends UndirectedSparseGraph<FNode, FEdge> {
	private int ID = 0;
	private int[] path = new int[] {};
	private Graph<FNode, FEdge> parentGraph = new UndirectedSparseGraph<FNode, FEdge>();


	/**
	 * @param iD
	 * @param path is a sequence of IDs, e.g., [1,2]
	 * @param parentGraph the cycle path from which generated, the parent graph is an undirected-graph
	 * The generated graph is cycle path [1,2,1]
	 */
	public CyclePath(int iD, int[] path, Graph<FNode, FEdge> parentGraph) {
		super();
		ID = iD;
		this.path = path;
		this.parentGraph = parentGraph;
		constructCycleGraph();
	}


	private void constructCycleGraph() {
		int miniNumOfNodes = 2;
		if (path.length >= miniNumOfNodes) {
			addNodes();
			addEdges();
		}else{
			System.out.println("Find cycle only has w nodes!");
		}
	}

	private void addEdges() {
		List<FNode> nodes = new ArrayList<FNode>(this.getVertices());

		int i = 0;
		for (; i < this.getVertexCount() - 1; i++) {
			FNode startNode = nodes.get(i);
			FNode endNode = nodes.get(i + 1);
			FEdge edge = parentGraph.findEdge(startNode, endNode);
			addEdge(edge, startNode, endNode);
		}
		// add last one to start
		// example: [1, 4, 6], edges=[1.4][4,6][6,1]
		FNode startNode = nodes.get(i);
		FNode endNode = nodes.get(0);
		FEdge edge = parentGraph.findEdge(startNode, endNode);
		addEdge(edge, startNode, endNode);
	}

	private void addNodes() {
		for (int id : path) {
			addVertex(findNode(id));
		}
	}

	private FNode findNode(int nodeID) {
		Collection<FNode> nodes = parentGraph.getVertices();
		for (FNode node : nodes) {
			if (node.getId() == nodeID) {
				return node;
			}
		}
		return null;
	}

	private void clearAllUsedFlags() {
		Collection<FNode> nodes = this.getVertices();
		for (FNode e : nodes) {
			e.clearIsUsedFlags();
		}
	}

	private void markedAsUsed() {
		Collection <FEdge> edges = this.getEdges();
		for (FEdge e : edges) {
			e.markUsedFlags();
		}
	}

	public boolean isAllMarkedAsUsed() {
		clearAllUsedFlags();
		markedAsUsed();
		Collection<FNode> nodes = this.getVertices();
		for (FNode e : nodes) {
			//System.out.println("isAllMarkedAsUsed===="+e.getData().isAllUsed());
			if (!e.getData().isAllUsed()) {
				return false;
			}
		}
		return true;
	}

	public int getID() {
		return ID;
	}

	public int[] getPath() {
		return path;
	}

	public void setPath(int[] path) {
		this.path = path;
	}

	public Graph<FNode, FEdge> getParentGraph() {
		return parentGraph;
	}

	public void setParentGraph(Graph<FNode, FEdge> parentGraph) {
		this.parentGraph = parentGraph;
	}

	public boolean isConflict(){
		for(FEdge e:this.getEdges()){
			if(!e.getData().isConflict()){
				return false;
			}
		}
		return true;
	}
}
