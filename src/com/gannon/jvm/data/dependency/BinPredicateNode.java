package com.gannon.jvm.data.dependency;

import com.gannon.asm.components.BLocalVariable;

public class BinPredicateNode extends BinNode {
	
	public BinPredicateNode(int nodeId) {
		super(nodeId);// use node id as temp variable names
	}

	public BinPredicateNode(int localVariableName, BLocalVariable localVariable) {
		super(localVariableName, localVariable);
		// TODO Auto-generated constructor stub
	}
}
