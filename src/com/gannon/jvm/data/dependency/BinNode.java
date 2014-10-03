package com.gannon.jvm.data.dependency;

import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.utilities.OpcodeUtility;

//binary tree node
public class BinNode {
	private int localVariableName;// same as local variable index
	private BLocalVariable localVariable;
	private BinNode leftBNode, rightBNode;

	public BinNode(int localVariableName) {
		super();
		this.localVariableName = localVariableName;
		localVariable = new BLocalVariable("", "", "", null, null, 0);
		this.leftBNode = null;
		this.rightBNode = null;
	}

	public BinNode(int localVariableName, BLocalVariable localVariable) {
		super();
		this.localVariableName = localVariableName;
		this.localVariable = localVariable;
		this.leftBNode = null;
		this.rightBNode = null;
	}

	public void setVariableName(int localVariableName) {
		this.localVariableName = localVariableName;
	}

	public int getVariableName() {
		return localVariableName;
	}

	public BLocalVariable getLocalVariable() {
		return localVariable;
	}

	public void setVariableValue(BLocalVariable localVariableValue) {
		this.localVariable = localVariableValue;
	}

	public BinNode getLeftBNode() {
		return leftBNode;
	}

	public void setLeftBNode(BinNode leftBNode) {
		this.leftBNode = leftBNode;
	}

	public BinNode getRightBNode() {
		return rightBNode;
	}

	public void setRightBNode(BinNode rightBNode) {
		this.rightBNode = rightBNode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + localVariableName;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BinNode other = (BinNode) obj;
		if (localVariableName != other.localVariableName)
			return false;
		return true;
	}

	public boolean isParamter() {
		return localVariableName < OpcodeUtility.MAX_PARAMETER_ID_ALLOWED && localVariable.isParamter();
	}

	public void show() {
		// calls the show method of the AnyClass
		System.out.print("i" + localVariableName + "\n");
	}

	public void showIndent(String indent) {
		System.out.print(indent + "i" + localVariableName + "\n");
	}

	public String showIndentString(String indent) {
		return indent + "i" + localVariableName + " value=" + localVariable + "]" + "\n";
	}

	@Override
	public String toString() {
		return "[i" + localVariableName + "]\n]";
	}
}
