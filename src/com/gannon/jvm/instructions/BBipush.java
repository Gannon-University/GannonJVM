package com.gannon.jvm.instructions;

import java.util.Stack;

import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.data.dependency.Dependency;
import com.gannon.jvm.data.dependency.DependencyFrame;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.path.PathFrame;
import com.gannon.jvm.utilities.ConstantsUtility;
import com.gannon.jvm.utilities.OpcodeUtility;

//push one-byte signed integer
//http://www.vmth.ucdavis.edu/incoming/Jasmin/ref-_bipush.html
public class BBipush extends BInstruction {

	private int operand1;

	public BBipush(int operand1, int lineNumber) {
		super(lineNumber);
		this.operand1 = operand1;
	}

	@Override
	public Object execute(BFrame activeFrame) {
		Stack<BLocalVariable> myOperandStack = activeFrame.getOperandStack();
		Integer pc = activeFrame.getLineNumber();

		BLocalVariable var=new BLocalVariable("", "I", "", null, null, ConstantsUtility.UNDEFINED_INDEX_ID,operand1 );
		myOperandStack.push(var);
		activeFrame.setLineNumber(++pc);
		return null;
	}

	@Override
	public int getOpcode() {
		return 16;
	}

	@Override
	public String toString() {
		return super.toString() + "  " + operand1;
	}

	public Integer getOperand() {
		return operand1;
	}

	@Override
	public void analyzing(DependencyFrame rFrame) {
//		Stack<BLocalVariable> valueStack = rFrame.getOperandStack();
//		valueStack.push(this.operand1);
//		Stack<String> nameStack = rFrame.getIntermediateVariableNameStack();
//		BinNode rootNode = new BinNode(Integer.toString(OpcodeUtility
//				.getNextID()), this.operand1);
//		nameStack.push(rootNode.getVariableName());
//		Dependency relation = new Dependency(rootNode, this);
//		Dependencies relations = rFrame.getRelations();
//		relations.add(relation);
	}

	@Override
	public Object execute(PathFrame pathFrame) {
		Stack<BLocalVariable> myOperandStack = pathFrame.getOperandStack();
		BLocalVariable var=new BLocalVariable("", "", "", null, null, ConstantsUtility.UNDEFINED_INDEX_ID,operand1 );
		myOperandStack.push(var);
		return null;
	}

}
