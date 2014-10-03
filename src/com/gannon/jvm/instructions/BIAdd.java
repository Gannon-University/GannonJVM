package com.gannon.jvm.instructions;

import java.util.Stack;

import org.objectweb.asm.Type;

import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.data.dependency.Dependency;
import com.gannon.jvm.data.dependency.DependencyFrame;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.path.PathFrame;
import com.gannon.jvm.utilities.ConstantsUtility;
import com.gannon.jvm.utilities.OpcodeUtility;

public class BIAdd extends BInstruction {
	//protected String name=

	public BIAdd(int lineNumber) {
		super(lineNumber);
	}

	@Override
	public Object execute(BFrame activeFrame) {
		Stack<BLocalVariable> myOperandStack = activeFrame.getOperandStack();
		Integer pc = activeFrame.getLineNumber();

		if(myOperandStack.size()<2){
			System.err.println("IADD must have at least two elelement. Exit!");
			activeFrame.setLineNumber(-1);
			return null;
		}
		BLocalVariable v1 = myOperandStack.pop();
		BLocalVariable v2 = myOperandStack.pop();
		if (v1.desc.equals(Type.INT_TYPE.getDescriptor()) && v2.desc.equals(Type.INT_TYPE.getDescriptor())) {
			Integer sum = (Integer) (v1.getValue()) + (Integer) (v2.getValue());
			BLocalVariable sumVar = new BLocalVariable(
					"Return", "I", null,
					null, null, ConstantsUtility.RETURN_VAR_ID);
			sumVar.setValue(sum);
			myOperandStack.push(sumVar);
		}else{
			System.err.println("BIAdd excution method inputs are not integer type . "); 
		}
		activeFrame.setLineNumber(++pc);
		return null;
	}

	@Override
	public int getOpcode() {
		return 96;
	}

	@Override
	public void analyzing(DependencyFrame rFrame) {
		Stack<BLocalVariable> myOperandStack = rFrame.getOperandStack();
		BLocalVariable sumVar = null; 

		if(myOperandStack.size()<2){
			System.err.println("IADD must have at least two elelement. Exit!");
		}
		BLocalVariable v1 = myOperandStack.pop();
		BLocalVariable v2 = myOperandStack.pop();
		int nodeID=OpcodeUtility.getNextID();
		if (v1.desc.equals(Type.INT_TYPE.getDescriptor()) && v2.desc.equals(Type.INT_TYPE.getDescriptor())) {
			Integer sum = (Integer) (v1.getValue()) + (Integer) (v2.getValue());
			sumVar = new BLocalVariable(
					"Return", "I", null,
					null, null, nodeID);
			sumVar.setValue(sum);
			myOperandStack.push(sumVar);
		}else{
			System.err.println("BIAdd excution method inputs are not integer type . "); 
		}
		
		//build relations
		 BinNode rightNode= new BinNode(v1.index,v1);
		 BinNode leftNode= new BinNode(v2.index,v2);
		 BinNode rootNode=new BinNode(nodeID,sumVar);
		
		 Dependency relation=new Dependency(rootNode, this);
		 relation.insertToLeft(leftNode);
		 relation.insertToRight(rightNode);
		
		 Dependencies relations=rFrame.getRelations();
		 relations.expendTheRelations(relation);
		 relations.add(relation);
	}

	@Override
	public Object execute(PathFrame pathFrame) {
		Stack<BLocalVariable> myOperandStack = pathFrame.getOperandStack();

		if(myOperandStack.size()<2){
			System.err.println("IADD must have at least two elelement. Exit!");
			return null;
		}
		BLocalVariable v1 = myOperandStack.pop();
		BLocalVariable v2 = myOperandStack.pop();
		if (v1.desc.equals(Type.INT_TYPE.getDescriptor()) && v2.desc.equals(Type.INT_TYPE.getDescriptor())) {
			Integer sum = (Integer) (v1.getValue()) + (Integer) (v2.getValue());
			BLocalVariable sumVar = new BLocalVariable(
					"Return", "I", null,
					null, null, ConstantsUtility.RETURN_VAR_ID);
			sumVar.setValue(sum);
			myOperandStack.push(sumVar);
		}else{
			System.err.println("BIAdd excution method inputs are not integer type . "); 
		}
		return null;
	}
}
