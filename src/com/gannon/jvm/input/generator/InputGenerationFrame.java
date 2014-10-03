package com.gannon.jvm.input.generator;
import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.data.input.Input;
import com.gannon.jvm.execution.path.PathFrame;
import com.gannon.jvm.progam.path.TestPath;

public class InputGenerationFrame extends PathFrame{
	private int numberOfResultsNeeded=0;

	public InputGenerationFrame(BClass bClass, BMethod bMethod, TestPath testPath, int numberOfResultsNeeded) {
		super(bClass, bMethod, testPath);
		this.numberOfResultsNeeded=numberOfResultsNeeded;
	}

	public int getNumberOfResultsNeeded() {
		return numberOfResultsNeeded;
	}

	public void setNumberOfResultsNeeded(int numberOfResultsNeeded) {
		this.numberOfResultsNeeded = numberOfResultsNeeded;
	}
	
	public void updateLocalVarTableInput(Input input){
		bMethod.getLocalVariables().updateVarTableWithInput(input);
	}
}
