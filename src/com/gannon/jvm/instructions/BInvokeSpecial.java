package com.gannon.jvm.instructions;

import java.util.ArrayList;

import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.data.dependency.DependencyFrame;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.path.PathFrame;

public class BInvokeSpecial extends Invoke  {

	public BInvokeSpecial(String owner, String name, String desc, int lineNumber) { 
		super(owner, name, desc, lineNumber);
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void analyzing(DependencyFrame rFrame) {
		// TODO Auto-generated method stub
		
	}

}
