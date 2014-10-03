package com.gannon.jvm.instructions;

import com.gannon.jvm.data.dependency.DependencyFrame;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.path.PathFrame;

public class BLdc extends BInstruction {
	private Object operand;

	public BLdc(Object operand, int lineNumber) {
		super(lineNumber);
		this.operand = operand;
	}

	@Override
	public Object execute(BFrame activeFrame) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object execute(PathFrame pathFrame) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getOpcode() {
		// check book page 315: Java spec
		return 18;
	}

	@Override
	public void analyzing(DependencyFrame rFrame) {
		// TODO Auto-generated method stub

	}

	public Object getOperand() {
		return operand;
	}
}
