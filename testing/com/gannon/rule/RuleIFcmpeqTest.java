package com.gannon.rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
import com.gannon.jvm.instructions.BIFicmpeq;

public class RuleIFcmpeqTest {
	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};

	//
	// _____100 (T)
	// ___ /   \
	// __1(4) 2 (3)
	//
	//
	@Test
	public void testEqualTrueLeftBigger() {
		// create an input
		int oldValue_i00=0;
		int oldValue_i1 = 4;
		int oldValue_i2 = 3;
		BLocalVariable p100 = new BLocalVariable(null, null, null, null, null, 100, oldValue_i00);
		BLocalVariable p1 = new BLocalVariable(null, null, null, null, null, 1, oldValue_i1);
		BLocalVariable p2 = new BLocalVariable(null, null, null, null, null, 2, oldValue_i2);
		Input input = new Input(1,null,null);
		input.addParameter(p1);
		input.addParameter(p2);

		// create first two dependency
		BinNode node1 = new BinNode(1, p1);
		Dependency i1 = new Dependency(node1);
		BinNode node2 = new BinNode(2, p2);
		Dependency i2 = new Dependency(node2);

		// third dependency
		BinNode root1 = new BinNode(100, p100);
		BLabel lable = new BLabel(new Label());
		Dependency i100 = new Dependency(root1, new BIFicmpeq(lable, 5));
		BinNode leftNode = new BinNode(1, p1);
		BinNode rightNode = new BinNode(2, p2);
		i100.insertToLeft(leftNode);
		i100.insertToRight(rightNode);

		// add four dependencies to Dependencies
		Dependencies dependencies = new Dependencies();
		dependencies.add(i1);
		dependencies.add(i2);
		dependencies.add(i100);

		// create input collection to collect generated inputs
		InputCollection inputs = new InputCollection(1);

		// set expected predicate result
		boolean expectedPredicateResult = true;

		// init
		RuleIFcmpeq rule = new RuleIFcmpeq(expectedPredicateResult, input, dependencies, leftNode, rightNode, inputs);
		rule.dataGeneration();
		System.out.println(inputs);
		
		assertEquals(3,inputs.getInputs().get(0).getParameterByIndex(1).getValue()); 
		assertEquals(3,inputs.getInputs().get(0).getParameterByIndex(2).getValue());  
		assertEquals(4,inputs.getInputs().get(1).getParameterByIndex(1).getValue()); 
		assertEquals(4,inputs.getInputs().get(1).getParameterByIndex(2).getValue()); 
		assertEquals(inputs.getInputs().get(0).getParameterByIndex(1).getValue(),inputs.getInputs().get(0).getParameterByIndex(2).getValue());
		assertEquals(inputs.getInputs().get(1).getParameterByIndex(1).getValue(),inputs.getInputs().get(1).getParameterByIndex(2).getValue());

	}


	//
	// _____100 (T)
	// ___ /   \
	// __1(4) 2 (3)
	//
	//
	@Test
	public void testEqualTrueRightBigger() {
		// create an input
		int oldValue_i00=0;
		int oldValue_i1 = 3;
		int oldValue_i2 = 4;
		BLocalVariable p100 = new BLocalVariable(null, null, null, null, null, 100, oldValue_i00);
		BLocalVariable p1 = new BLocalVariable(null, null, null, null, null, 1, oldValue_i1);
		BLocalVariable p2 = new BLocalVariable(null, null, null, null, null, 2, oldValue_i2);
		Input input = new Input(1,null,null);
		input.addParameter(p1);
		input.addParameter(p2);

		// create first two dependency
		BinNode node1 = new BinNode(1, p1);
		Dependency i1 = new Dependency(node1);
		BinNode node2 = new BinNode(2, p2);
		Dependency i2 = new Dependency(node2);

		// third dependency
		BinNode root1 = new BinNode(100, p100);
		BLabel lable = new BLabel(new Label());
		Dependency i100 = new Dependency(root1, new BIFicmpeq(lable, 5));
		BinNode leftNode = new BinNode(1, p1);
		BinNode rightNode = new BinNode(2, p2);
		i100.insertToLeft(leftNode);
		i100.insertToRight(rightNode);

		// add four dependencies to Dependencies
		Dependencies dependencies = new Dependencies();
		dependencies.add(i1);
		dependencies.add(i2);
		dependencies.add(i100);

		// create input collection to collect generated inputs
		InputCollection inputs = new InputCollection(1);

		// set expected predicate result
		boolean expectedPredicateResult = true;

		// init
		RuleIFcmpeq rule = new RuleIFcmpeq(expectedPredicateResult, input, dependencies, leftNode, rightNode, inputs);
		rule.dataGeneration();
		System.out.println(inputs);
		
		assertEquals(4,inputs.getInputs().get(0).getParameterByIndex(1).getValue()); 
		assertEquals(4,inputs.getInputs().get(0).getParameterByIndex(2).getValue());  
		assertEquals(3,inputs.getInputs().get(1).getParameterByIndex(1).getValue()); 
		assertEquals(3,inputs.getInputs().get(1).getParameterByIndex(2).getValue()); 
		assertEquals(inputs.getInputs().get(0).getParameterByIndex(1).getValue(),inputs.getInputs().get(0).getParameterByIndex(2).getValue());
		assertEquals(inputs.getInputs().get(1).getParameterByIndex(1).getValue(),inputs.getInputs().get(1).getParameterByIndex(2).getValue());
	}
	

	//
	// _____100 (F)
	// ___ /   \
	// __1(4) 2 (4)
	//
	//
	@Test
	public void testEqualFalse() {
		// create an input
		int oldValue_i00=0;
		int oldValue_i1 = 4;
		int oldValue_i2 = 3;
		BLocalVariable p100 = new BLocalVariable(null, null, null, null, null, 100, oldValue_i00);
		BLocalVariable p1 = new BLocalVariable(null, null, null, null, null, 1, oldValue_i1);
		BLocalVariable p2 = new BLocalVariable(null, null, null, null, null, 2, oldValue_i2);
		Input input = new Input(1,null,null);
		input.addParameter(p1);
		input.addParameter(p2);

		// create first two dependency
		BinNode node1 = new BinNode(1, p1);
		Dependency i1 = new Dependency(node1);
		BinNode node2 = new BinNode(2, p2);
		Dependency i2 = new Dependency(node2);

		// third dependency
		BinNode root1 = new BinNode(100, p100);
		BLabel lable = new BLabel(new Label());
		Dependency i100 = new Dependency(root1, new BIFicmpeq(lable, 5));
		BinNode leftNode = new BinNode(1, p1);
		BinNode rightNode = new BinNode(2, p2);
		i100.insertToLeft(leftNode);
		i100.insertToRight(rightNode);

		// add four dependencies to Dependencies
		Dependencies dependencies = new Dependencies();
		dependencies.add(i1);
		dependencies.add(i2);
		dependencies.add(i100);

		// create input collection to collect generated inputs
		InputCollection inputs = new InputCollection(1);
		// set expected predicate result
		boolean expectedPredicateResult = false;

		// init
		RuleIFcmpeq rule = new RuleIFcmpeq(expectedPredicateResult, input, dependencies, leftNode, rightNode, inputs);
		rule.dataGeneration();
		//System.out.println(inputs);
		assertTrue(inputs.getInputs().get(0).getParameterByIndex(1).getValue()!=inputs.getInputs().get(0).getParameterByIndex(2).getValue());
		assertTrue(inputs.getInputs().get(1).getParameterByIndex(1).getValue()!=inputs.getInputs().get(1).getParameterByIndex(2).getValue());

	}


}



