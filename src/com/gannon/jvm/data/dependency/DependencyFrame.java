package com.gannon.jvm.data.dependency;

import java.util.Stack;

import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BLocalVariable;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.execution.method.BLocalVarTable;
import com.gannon.jvm.progam.path.TestPath;
import com.ganon.jvm.shared.Frame;

/**
 * @author Frank Xu
 * 
 *         A relation frame is similar to a BFrame, it only keeps relations
 *         during runtime analyzing. No concept of the active frame necessary
 *         because we don't need to deal with method to method calling
 * 
 */
public class DependencyFrame extends Frame {
	// a given path for analyzing predicate dependency
	private TestPath targetPath;
	private Dependencies relations = new Dependencies();;

	public DependencyFrame(BClass bClass, BMethod bMethod, TestPath testPath) {
		super(bClass, bMethod);
		this.targetPath = testPath;
	}

	// for triangle , assume tempVariableStack[1-3] are used for storing inputs
	// variables
	// we convert each variable into a relation
	public void initParameterRelation() {
		if (targetPath == null) {
			System.out.print("Add a target path to the relation frame before analyzing dependency!");
		} else {
			BLocalVarTable varTable = bMethod.getLocalVariables();
			for (BLocalVariable b : varTable.getLocalVars()) {
				//mark some variable as parameters
				if (b.index > 0 && b.index <= bMethod.getNumberOfParameter()) {
					b.setParamter(true);
				}
				relations.add(new Dependency(new BinNode(b.index, b)));
			}
		}
	}

	public TestPath getTargetPath() {
		return targetPath;
	}

	public void setTargetPath(TestPath targetPath) {
		this.targetPath = targetPath;
	}

	public Dependencies getRelations() {
		return relations;
	}

	public void setRelations(Dependencies relations) {
		this.relations = relations;
	}
}
