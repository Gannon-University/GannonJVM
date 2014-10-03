package com.gannon.bytecode.controlflowgraph;

import java.util.ArrayList;
import java.util.Stack;

import com.gannon.asm.classgenerator.BClassGenerator;
import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.instructions.BInstruction;
import com.gannon.jvm.instructions.BInvokeVirtual;
import com.gannon.jvm.instructions.Invoke;

// the class has not been tested.
public class BuildCFG {
	private BClass bClass;
	BMethod startMethod = new BMethod();

	public BuildCFG(BClass bClass, BMethod startMethod) {
		this.bClass = bClass;
		this.startMethod = startMethod;
	}

	public CGraph getResultGraph() {
		CFGMethod cfgMethod = new CFGMethod(startMethod, bClass);
		CGraph resultGraph = cfgMethod.buildGraph();

		Frame currentFrame = new Frame(startMethod, 0);
		Stack<Frame> stack = new Stack<Frame>();

		if (cfgMethod != null) {
			stack.push(currentFrame);
		}

		while (!stack.empty()) {
			CFGMethod currentMGI = new CFGMethod(currentFrame.getMethod(), bClass);
			CGraph currentGraph = currentMGI.buildGraph();
			ArrayList<CNode> currentBlocks = new ArrayList<CNode>(currentGraph.getCNodes());
			int blockId = currentFrame.getBlockId();

			for (int i = blockId; i < currentBlocks.size(); i++) {
				// always point to next block
				CNode b = currentBlocks.get(i);

				if (b.hasInvoke()) {
					currentFrame.setBlockId(i + 1);
					BInstruction ivInstruction = b.getBlock().getFirstInstruction();

					// It will give the name including MethodNAme, Desc etc.
					BMethod calleeMethod = null;
					// This is for method call inside class
					if (ivInstruction.getOpCodeCommand().equals("invokevirtual")
							&& ((BInvokeVirtual) ivInstruction).getOwner().contains(this.bClass.getClassName())) {
						// This condition is for avoiding recursive call (do
						// nothing)
						String calleeName = ((BInvokeVirtual) ivInstruction).getCalleeName();
						if (calleeName.equals(this.startMethod.getName()) == false) {
							// calleeMethod =
							// ivInstruction.getNextMethod(this.bClass);
							calleeMethod = bClass.getMethod(((BInvokeVirtual) ivInstruction).getCalleeName());
							// To avoid calling java library function
							if (calleeMethod != null) {
								Frame calleeFrame = new Frame(calleeMethod, 0);
								stack.push(calleeFrame);
								CFGMethod calleeCfgMethod = new CFGMethod(calleeMethod, this.bClass);

								CGraph calleeMethodGraph = calleeCfgMethod.buildGraph();
								resultGraph.mergeCallingGraph(calleeMethodGraph, b);
								currentFrame = calleeFrame;
							}
						}
						break;
					}// This is for method call between classes
					else if (ivInstruction.getOpCodeCommand().equals("invokespecial") || ivInstruction.getOpCodeCommand().equals("invokevirtual")) {
						String calleeName = ((Invoke) ivInstruction).getCalleeName();
						if (calleeName.equals(this.startMethod.getName()) == false) {
							// Avoid multiple constructor (need to be fix)
							if (this.startMethod.getName().equals("<init>") && calleeName.equals("<init>")) {

							} else {
								// To create the Class object once we find out
								// its from different class
								String[] classStr = ((Invoke) ivInstruction).getOwner().split("/");
								BClass nextClass = BClassGenerator.getBClass(classStr[classStr.length - 1] + ".class");
								// To avoid library function call
								if (nextClass != null) {
									// BInvokeSpecial isInstruction =
									// (BInvokeSpecial)ivInstruction;
									calleeMethod = bClass.getMethod(((Invoke) ivInstruction).getCalleeName());
									if (calleeMethod != null) {
										Frame calleeFrame = new Frame(calleeMethod, 0);
										stack.push(calleeFrame);
										System.out.println("***** " + startMethod.getName() + " " + b.toString());
										// b.setMethodName(startMethod.getName());
										BuildCFG calleeCfgGraph = new BuildCFG(nextClass, calleeMethod);

										CGraph calleeMethodGraph = calleeCfgGraph.getResultGraph();
										System.out.println("&&&&&& " + startMethod.getName() + " " + b.toString());
										resultGraph.mergeCallingGraph(calleeMethodGraph, b);

									}
								}
							}

						}

					}

				}
				if (i == currentBlocks.size() - 1) {
					stack.pop();
					if (!stack.empty()) {
						currentFrame = stack.peek();
					}
				}
			}
		}
		return resultGraph;
	}
}
