package com.gannon.jvm.input.generator;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.gannon.asm.components.BMethod;
import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.data.dependency.Dependency;
import com.gannon.jvm.data.dependency.GannonPredicateTreeBuilderJVM;
import com.gannon.jvm.data.input.Input;
import com.gannon.jvm.data.input.InputCollection;
import com.gannon.jvm.execution.method.GannonMethodJVM;
import com.gannon.jvm.instructions.BIFicmpeq;
import com.gannon.jvm.instructions.BIFicmpge;
import com.gannon.jvm.instructions.BIFicmple;
import com.gannon.jvm.instructions.BIFicmpne;
import com.gannon.jvm.instructions.BInstruction;
import com.gannon.jvm.progam.path.Node;
import com.gannon.jvm.progam.path.PredicateNode;
import com.gannon.jvm.progam.path.TestPath;
import com.gannon.jvm.utilities.ConstantsUtility;
import com.gannon.rule.Rule;
import com.gannon.rule.RuleIFcmpeq;
import com.gannon.rule.RuleIFcmpge;
import com.gannon.rule.RuleIFcmple;
import com.gannon.rule.RuleIFcmpne;

public class InputGenerateExecutor {
	private InputGenerationFrame inputGenerationFrame;
	private TestPath path;
	private int numberOfGenInputsNeeded;

	public InputGenerateExecutor(InputGenerationFrame inputGenerationFrame) {
		super();
		this.inputGenerationFrame = inputGenerationFrame;
		this.numberOfGenInputsNeeded = inputGenerationFrame.getNumberOfResultsNeeded();
		this.path=inputGenerationFrame.getTestPath();
	}

	public Set<Input> execute() {
		BMethod currentMethod=inputGenerationFrame.getbMethod();
		// inputs pass all IF statements
		Queue<Input> potentialGoodReusltQueue = new LinkedList<Input>();

		// store final generated input for a given path
		Set<Input> results = new HashSet<Input>();

		// random generate input
		Input ramdonInput=new Input(1,null,currentMethod);
		potentialGoodReusltQueue.add(ramdonInput.generateRandomInt());
		
		while (path.canGenerateInputs() && !potentialGoodReusltQueue.isEmpty() && results.size() < numberOfGenInputsNeeded) {
			// clear all ignore flag
			path.clearIgnoreFlags();

			// pop the new input from queue to Path Frame
			Input input = potentialGoodReusltQueue.poll();

			// get dependency tree
			GannonPredicateTreeBuilderJVM pathjvm = new GannonPredicateTreeBuilderJVM();
			pathjvm.run(null, inputGenerationFrame.getbMethod(), path, input);
			Dependencies dps = pathjvm.getRelationFrame().getRelations();

			boolean endOfPathFlag = false;

			while (!endOfPathFlag) {
				// for each predicate node, i.e., the node contains a predicate
				// instruction (a>b), if the run-time predicate result does not
				// equal to the expected results, the program re-executes the
				// program, however, the predicate will be skipped to avoid
				// localized search

				for (Node node : path.getNodes()) {
					Object result = node.getInstruction().execute(inputGenerationFrame);
					// if reaching the end of the program, we have a potential
					// good input, the program stops and push the input to a
					// "potential good" input queue
					if (node.hasReturnInstruction()) {
						endOfPathFlag = true;
						break;
					} else if (node.isBPredicateNode() && !((PredicateNode) node).isIgnore()) {
						((PredicateNode) node).setActualPredicateResult((Boolean) result.equals(true) ? ConstantsUtility.EXPECTED_TRUE
								: ConstantsUtility.EXPECTED_FALSE);
						// System.out.println("If instruction" + node);
						// if the actual predicate result is not equal to
						// expected results , we need to generate a new value to
						// pass the node and the predicate as ignored for next
						// time execution
						if (!((PredicateNode) node).hasPassed() && ((PredicateNode) node).isIgnore() != true) {
							InputCollection newGeneratedInputs = adjustInput(dps, node, input);
							// put new generated results to queue
							potentialGoodReusltQueue.addAll(newGeneratedInputs.getInputs());
							//System.out.println("potential good inputs="+newGeneratedInputs.getInputs());
							// force to ignore this IF statement during next
							// execution
							((PredicateNode) node).setIgnore(true);
							break;
						}
					}
				}
			}

			// execute the methodJVM to see if get the same path, if so save the
			// result
			GannonMethodJVM jvm = new GannonMethodJVM();
			// note that var and input should be the same value but different
			// format
			jvm.run(inputGenerationFrame.getTestPath().getbClass(), inputGenerationFrame.getTestPath().getbMethod(), input);
			TestPath resultPath = jvm.getExecutedPath();

			if (resultPath.equals(path)) {
				results.add(input);
				System.out.println("Generate input size="+results.size()+ " "+input);
			}

			if (potentialGoodReusltQueue.isEmpty()) {
				Input generatedRandomInput = new Input(1,null,currentMethod); 
				Input generateRandomInt = generatedRandomInput.generateRandomInt();
				potentialGoodReusltQueue.add(generateRandomInt);
			}
		}
		return results;
	}

	private InputCollection adjustInput(Dependencies dps, Node node, Input input) {
		// Apply rules to dependency to change input values. The root of the
		// dependency is BinNode. We need to find the BinNode from the node
		// comes from test path.
		BInstruction instruction = node.getInstruction();
		Dependency dp = dps.findRelation(instruction);

		BinNode leftNode = dp.getLeftNode();
		BinNode rightNode = dp.getRightNode();

		boolean expectedPredicateResult = ((PredicateNode) node).getExpectedPredicateResult() > 0 ? true : false;

		// a collection to collect new generated data
		InputCollection newDataList = new InputCollection(1);
		Rule rule = null;

		if (instruction instanceof BIFicmpge) {
			rule = new RuleIFcmpge(expectedPredicateResult, input, dps, leftNode, rightNode, newDataList);
		} else if (instruction instanceof BIFicmpne) {
			rule = new RuleIFcmpne(expectedPredicateResult, input, dps, leftNode, rightNode, newDataList);
		} else if (instruction instanceof BIFicmpeq) {
			rule = new RuleIFcmpeq(expectedPredicateResult, input, dps, leftNode, rightNode, newDataList);
		} else if (instruction instanceof BIFicmple) {
			rule = new RuleIFcmple(expectedPredicateResult, input, dps, leftNode, rightNode, newDataList);
		} else {
			System.out.println(" you need to implement BIF instructions in Input Generator!!!!!!");
		}
		try {
			rule.dataGeneration();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("potential good inputs="+newDataList.getInputs());
		return newDataList;
	}

}
