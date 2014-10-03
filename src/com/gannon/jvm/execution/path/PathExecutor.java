package com.gannon.jvm.execution.path;

import com.gannon.jvm.progam.path.Node;
import com.gannon.jvm.progam.path.PredicateNode;
import com.gannon.jvm.progam.path.TestPath;
import com.gannon.jvm.utilities.ConstantsUtility;

public class PathExecutor {
	private PathFrame pathFrame;
	private TestPath path;

	public PathExecutor(PathFrame pathFrame) {
		this.pathFrame = pathFrame;
		this.path = pathFrame.getTestPath();
	}

	public Object execute() {
		Object result = null;
		for (Node node : path.getNodes()) {
			result = node.getInstruction().execute(pathFrame);
			if (node.isBPredicateNode()) {
				Boolean currentBoolResult = (Boolean) result.equals(true);
				((PredicateNode) node).setActualPredicateResult(currentBoolResult ? ConstantsUtility.EXPECTED_TRUE
						: ConstantsUtility.EXPECTED_FALSE);
			}
		}
		return result;
	}
}
