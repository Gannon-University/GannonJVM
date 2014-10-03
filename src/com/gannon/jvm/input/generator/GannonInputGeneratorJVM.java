package com.gannon.jvm.input.generator;

import java.util.Set;

import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.data.input.Input;
import com.gannon.jvm.execution.method.BLocalVarTable;
import com.gannon.jvm.progam.path.TestPath;
import com.gannon.jvm.utilities.TrianglePathBuilderUtility;

public class GannonInputGeneratorJVM {
	public GannonInputGeneratorJVM() {
		super();
	}

	public Set<Input> run(BClass bClass, BMethod method, TestPath testPath, int numberOfResultsNeeded) {
		InputGenerationFrame pathFrame = new InputGenerationFrame(bClass, method, testPath, numberOfResultsNeeded); 
		InputGenerateExecutor executor= new InputGenerateExecutor(pathFrame);  
		Set<Input> result = executor.execute();
		return result;
	}
}
