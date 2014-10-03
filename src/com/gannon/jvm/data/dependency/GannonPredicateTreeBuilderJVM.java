package com.gannon.jvm.data.dependency;

import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.data.input.Input;
import com.gannon.jvm.execution.path.PathFrame;
import com.gannon.jvm.progam.path.TestPath;

public class GannonPredicateTreeBuilderJVM {
	private DependencyFrame relationFrame;
	private DependencyAnalyzer analyzer = new DependencyAnalyzer();

	public GannonPredicateTreeBuilderJVM() {
	}

	public void run(BClass bClass, BMethod method, TestPath testPath, Input input) {
		relationFrame = new DependencyFrame(bClass, method, testPath);
		// update method input
		if (method == null || input == null) {
			System.err.println("Method or input are null, only for testing purpose!");
			System.err.println("in case of null, create a new contains local variable table!");
		}
		// if we don't care about input value
		if (input != null) {
			method.addInput(input);
		}
		analyzer = new DependencyAnalyzer();
		relationFrame.initParameterRelation();
		analyzer.execute(relationFrame);
	}
	
	public void run(BClass bClass, BMethod method, TestPath testPath) {
		relationFrame = new DependencyFrame(bClass, method, testPath);
		// update method input
		if (method == null ) {
			System.err.println("Method or input are null, only for testing purpose!");
		}
		analyzer = new DependencyAnalyzer();
		relationFrame.initParameterRelation();
		analyzer.execute(relationFrame);
	}

	public DependencyFrame getRelationFrame() {
		return relationFrame;
	}

	public void setRelationFrame(DependencyFrame relationFrame) {
		this.relationFrame = relationFrame;
	}

	public DependencyAnalyzer getAnalyzer() {
		return analyzer;
	}

	public void setAnalyzer(DependencyAnalyzer analyzer) {
		this.analyzer = analyzer;
	}
}
