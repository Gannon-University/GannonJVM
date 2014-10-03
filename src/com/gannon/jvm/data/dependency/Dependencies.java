package com.gannon.jvm.data.dependency;

import java.util.ArrayList;
import java.util.List;

import com.gannon.jvm.instructions.BGotoMarkerInterface;
import com.gannon.jvm.instructions.BInstruction;
import com.gannon.jvm.instructions.BPredicateInstruction;
import com.gannon.jvm.progam.path.Node;
import com.gannon.jvm.progam.path.PredicateNode;
import com.gannon.jvm.progam.path.TestPath;

/**
 * @author Frank
 *
 */
/**
 * @author Frank
 *
 */
/**
 * @author Frank
 *
 */
/**
 * @author Frank
 *
 */
/**
 * @author Frank
 *
 */
public class Dependencies {
	private ArrayList<Dependency> relations = new ArrayList<Dependency>();

	public Dependencies() {
		super();
	}

	public Dependencies(ArrayList<Dependency> relations) {
		super();
		this.relations = relations;
	}

	public ArrayList<Dependency> getRelations() {
		return relations;
	}

	public void setRelations(ArrayList<Dependency> relations) {
		this.relations = relations;
	}

	public Dependency findRelation(BinNode variableNode) {
		for (Dependency r : relations) {
			if (r.getTheBTRootNode().equals(variableNode)) {
				return r;
			}
		}
		return null;
	}

	public Dependency findRelation(BInstruction instr) {
		for (Dependency r : relations) {
			if (r.getInst() != null && r.getInst().equals(instr)) {
				return r;
			}
		}
		return null;
	}

	public void add(Dependency r) {
		relations.add(r);
	}

	public Dependency getRelation(int index) {
		return relations.get(index);
	}

	public void expendTheRelations(Dependency theRelation) {
		BinNode leftNode = theRelation.getLeftNode();
		BinNode rightNode = theRelation.getRightNode();
		// check previous relations
		if (!leftNode.isParamter()) {
			Dependency rLeft = findRelation(leftNode);
			theRelation.insertToLeft(rLeft.getTheBTRootNode());
		}
		if (!rightNode.isParamter()) {
			Dependency rRight = findRelation(rightNode);
			theRelation.insertToRight(rRight.getTheBTRootNode());
		}
	}


	/**
	 * @return a list of dependencies contains if statement. It used for detecting infeasible paths. Need to be tested
	 */
	public List<Dependency> getPredicateDependencies() {
		List<Dependency> predicateRelations=new ArrayList<Dependency>(); 
		for (int r = 0; r < relations.size(); r++) {
			Dependency dependency = relations.get(r);
			if (dependency.isPredicateRelation()) {
				predicateRelations.add(dependency);
			}
		}
		return predicateRelations;
	}
	
	
	//need test
	public Dependency findPredicateRelation(List<Dependency> predicateRelation, BInstruction instr) {
		for (Dependency r : predicateRelation) {
			if (r.getInst() != null && r.getInst().equals(instr)) {
				return r;
			}
		}
		return null;
	}
	
	/**
	 * @param test is a test path contains expected predicate results
	 * need to be tested.
	 */
	public void updateExpectedPredicateResultFromTestCase(List<Dependency> predicateRelations, TestPath test){
		for(Node node: test.getNodes()){
			if(node.isBPredicateNode() && !(node.getInstruction() instanceof BGotoMarkerInterface)){
				int result=((PredicateNode)node).getExpectedPredicateResult();
				BPredicateInstruction ins=(BPredicateInstruction) node.getInstruction();
				Dependency r=findPredicateRelation(predicateRelations,ins);
				r.setExpectedPredicateResult(result==1? PredicateResult.TRUE: PredicateResult.FALSE);
			}
		}
	}

	public int size() {
		return relations.size();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < relations.size(); i++) {
			sb.append("===== Relation " + i + " ===========\n");
			sb.append(relations.get(i));
		}
		return sb.toString();
	}
}
