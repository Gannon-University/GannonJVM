package com.gannon.jvm.execution.path;

import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.data.input.Input;
import com.gannon.jvm.progam.path.TestPath;

public class GannonPathJVM {
	private PathFrame pathFrame;
	private PathExecutor executor;

	public GannonPathJVM() {
		
	}

	public Object run(BClass bClass, BMethod method, TestPath testPath, Input input) {
		pathFrame = new PathFrame(bClass, method ,	 testPath);
		// update method input
		if(method==null){
			//in case of null, create a new contains local variable table
			System.err.println("Method is null, only for testing purpose!");
		}
		method.addInput(input);
		// init pathExecutor
		executor = new PathExecutor(pathFrame);
		Object result = executor.execute();
		return result;
	}

	public PathFrame getPathFrame() {
		return pathFrame;
	}

	public void setPathFrame(PathFrame pathFrame) {
		this.pathFrame = pathFrame;
	}

	public PathExecutor getExecutor() {
		return executor;
	}

	public void setExecutor(PathExecutor executor) {
		this.executor = executor;
	}
}
