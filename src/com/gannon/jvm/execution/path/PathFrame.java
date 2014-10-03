package com.gannon.jvm.execution.path;

import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.progam.path.TestPath;
import com.ganon.jvm.shared.Frame;

public class PathFrame extends Frame {
	private TestPath testPath;

	public PathFrame(BClass bClass, BMethod bMethod, TestPath testPath) {
		super(bClass, bMethod);
		this.testPath=testPath;
	}

	public TestPath getTestPath() {
		return testPath;
	}
}
