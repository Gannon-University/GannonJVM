package com.gannon.jvm.execution.method;

import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.utilities.ConstantsUtility;
import com.ganon.jvm.shared.Frame;

public class BFrame extends Frame {
	private int lineNumber = ConstantsUtility.INIT_PROGRAM_LINE_NUMBER;

	public BFrame(BClass bClass, BMethod bMethod) {
		super(bClass, bMethod);
	}

	public int getLineNumber() {
		return this.lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

}
