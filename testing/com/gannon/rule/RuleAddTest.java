package com.gannon.rule;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.objectweb.asm.Label;

import com.gannon.asm.components.BLabel;
import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.data.dependency.Dependency;
import com.gannon.jvm.data.input.Input;
import com.gannon.jvm.data.input.InputCollection;
import com.gannon.jvm.instructions.BIAdd;
import com.gannon.jvm.instructions.BIFicmpeq;

public class RuleAddTest {

	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};

	// _______ i4 () add distance 9
	// __________/ \
	// _________i2(20) i3 (30)
	//
	//
	@Test
	public void testAddIncreaseDistance9() {
		// create an input
		int distance = 9;
		int oldValue_i2 = 20;
		int oldValue_i3 = 30;
		BLocalVariable p1 = new BLocalVariable(null, null, null, null, null, 1, 10);
		BLocalVariable p2 = new BLocalVariable(null, null, null, null, null, 2, oldValue_i2);
		BLocalVariable p3 = new BLocalVariable(null, null, null, null, null, 3, oldValue_i3);
		BLocalVariable p4 = new BLocalVariable(null, null, null, null, null, 4, 0);
		Input input = new Input(1,null,null);
		input.addParameter(p1);
		input.addParameter(p2);
		input.addParameter(p3);

		// fourth dependency
		BinNode i4 = new BinNode(4, p4);
		Dependency d4 = new Dependency(i4, new BIAdd(5));
		BinNode i2 = new BinNode(2, p2);
		i2.setVariableValue(p2);
		BinNode i3 = new BinNode(3, p3);
		i3.setVariableValue(p3);
		d4.insertToLeft(i2);
		d4.insertToRight(i3);

		// add four dependencies to Dependencies
		Dependencies dependencies = new Dependencies();
		dependencies.add(d4);

		// create input collection to collect generated inputs
		InputCollection inputs = new InputCollection(1);

		// set expected predicate result
		boolean expectedPredicateResult = true;

		// init, add node increases 10
		RuleIAdd rule = new RuleIAdd(expectedPredicateResult, input, dependencies, i2, i3, inputs, distance);
		rule.dataGeneration();

		assertEquals(oldValue_i2 + distance, inputs.getInputs().get(0).getParameterByIndex(2).getValue());
		assertEquals(oldValue_i3 + distance, inputs.getInputs().get(1).getParameterByIndex(3).getValue());

	}

	//
	// _____i1002 (T) IFcompEqual
	// ___ / \
	// __i1(10) i001 (50) add
	// __________/ \
	// _________i2(20) i3 (30)
	//
	//
	@Test
	public void testAddIFEqual() {
		// create an input
		int distance = 9;
		int oldValue_i1 = 10;
		int oldValue_i2 = 20;
		int oldValue_i3 = 30;
		int oldValue_i4 = 50;
		BLocalVariable p1 = new BLocalVariable(null, null, null, null, null, 1, oldValue_i1);
		BLocalVariable p2 = new BLocalVariable(null, null, null, null, null, 2, oldValue_i2);
		BLocalVariable p3 = new BLocalVariable(null, null, null, null, null, 3, oldValue_i3);
		BLocalVariable p4 = new BLocalVariable(null, null, null, null, null, 4, oldValue_i4);
		Input input = new Input(1,null,null);
		input.addParameter(p1);
		input.addParameter(p2);
		input.addParameter(p3);

		// fourth dependency
		BinNode i1001 = new BinNode(10001, p4);
		Dependency d4 = new Dependency(i1001, new BIAdd(5));
		BinNode i2 = new BinNode(2, p2);
		BinNode i3 = new BinNode(3, p3);
		d4.insertToLeft(i2);
		d4.insertToRight(i3);

		// add four dependencies to Dependencies
		Dependencies dependencies = new Dependencies();
		dependencies.add(d4);

		// fifth dependency
		BinNode root = new BinNode(1000, p4);
		BLabel lable = new BLabel(new Label());
		Dependency d5 = new Dependency(root, new BIFicmpeq(lable, 5));
		BinNode i1 = new BinNode(1, p1);
		d5.insertToLeft(i1);
		d5.insertToRight(d4.getTheBTRootNode());

		// add four dependencies to Dependencies
		dependencies.add(d5);

		// create input collection to collect generated inputs
		InputCollection inputs = new InputCollection(1);

		// set expected predicate result
		boolean expectedPredicateResult = true;

		// init
		RuleIFcmpeq rule = new RuleIFcmpeq(expectedPredicateResult, input, dependencies, i1, i1001, inputs);
		rule.dataGeneration();

		assertEquals(oldValue_i4, inputs.getInputs().get(0).getParameterByIndex(1).getValue());
		assertEquals(oldValue_i2, inputs.getInputs().get(0).getParameterByIndex(2).getValue());
		assertEquals(oldValue_i3, inputs.getInputs().get(0).getParameterByIndex(3).getValue());

		assertEquals(oldValue_i1, inputs.getInputs().get(1).getParameterByIndex(1).getValue());
		assertEquals(-20, inputs.getInputs().get(1).getParameterByIndex(2).getValue());
		assertEquals(oldValue_i3, inputs.getInputs().get(1).getParameterByIndex(3).getValue());

		assertEquals(oldValue_i1, inputs.getInputs().get(2).getParameterByIndex(1).getValue());
		assertEquals(20, inputs.getInputs().get(2).getParameterByIndex(2).getValue());
		assertEquals(-10, inputs.getInputs().get(2).getParameterByIndex(3).getValue());

	}

}
