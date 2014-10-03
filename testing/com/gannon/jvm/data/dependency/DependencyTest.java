package com.gannon.jvm.data.dependency;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.objectweb.asm.Label;

import com.gannon.asm.components.BLabel;
import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.input.Input;
import com.gannon.jvm.data.input.InputCollection;
import com.gannon.jvm.instructions.BIFicmpeq;
import com.gannon.rule.RuleIFcmpeq;

public class DependencyTest {
	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};

	
	//
	// _____100 
	// ___ /   \
	// __1     2 
	//
	//
	
	//
	// _____200 
	// ___ /   \
	// __1     2 
	//
	//
	@Test
	public void testContainsSameLeaves() {
		BLocalVariable p0 = new BLocalVariable(null, null, null, null, null, 1, 0);
		
		BinNode root1 = new BinNode(100, p0);
		BLabel lable = new BLabel(new Label());
		Dependency i4 = new Dependency(root1, new BIFicmpeq(lable, 5));
		BinNode leftNode = new BinNode(1, p0);
		leftNode.setVariableValue(  new BLocalVariable(null, null, null, null, null, 1, 3) );
		BinNode rightNode = new BinNode(2, p0);
		rightNode.setVariableValue(new BLocalVariable(null, null, null, null, null, 2, 3) );
		i4.insertToLeft(leftNode);
		i4.insertToRight(rightNode);


		BinNode root2 = new BinNode(200, p0);
		BLabel lable2 = new BLabel(new Label());
		Dependency i5 = new Dependency(root2, new BIFicmpeq(lable2, 5));
		BinNode leftNode2 = new BinNode(1, p0);
		leftNode.setVariableValue(new BLocalVariable(null, null, null, null, null, 1, 3) );
		BinNode rightNode2 = new BinNode(2, p0);
		rightNode.setVariableValue(new BLocalVariable(null, null, null, null, null, 1, 4) );
		i5.insertToLeft(leftNode2);
		i5.insertToRight(rightNode2);
		
		assertTrue(i4.containsSameLeaves(i5));
		
	}
	//
	// _____100 
	// ___ /   \
	// __1     2 
	//
	//
	
	//
	// _____200 
	// ___ /   \
	// __1     3 
	//
	@Test
	public void testContainsSameLeavesNotTrue() {
		BLocalVariable p0 = new BLocalVariable(null, null, null, null, null, 1, 0);
		BinNode root1 = new BinNode(100, p0);
		BLabel lable = new BLabel(new Label());
		Dependency i4 = new Dependency(root1, new BIFicmpeq(lable, 5));
		BinNode leftNode = new BinNode(1, p0);
		leftNode.setVariableValue(new BLocalVariable(null, null, null, null, null, 1, 3) );
		BinNode rightNode = new BinNode(2, p0);
		rightNode.setVariableValue(new BLocalVariable(null, null, null, null, null, 1, 4) );
		i4.insertToLeft(leftNode);
		i4.insertToRight(rightNode);


		BinNode root2 = new BinNode(200, p0);
		BLabel lable2 = new BLabel(new Label());
		Dependency i5 = new Dependency(root2, new BIFicmpeq(lable2, 5));
		BinNode leftNode2 = new BinNode(1, p0);
		leftNode.setVariableValue(new BLocalVariable(null, null, null, null, null, 1, 3) );
		BinNode rightNode2 = new BinNode(3, p0);
		rightNode.setVariableValue(new BLocalVariable(null, null, null, null, null, 1, 4) );
		i5.insertToLeft(leftNode2);
		i5.insertToRight(rightNode2);
		
		assertFalse(i4.containsSameLeaves(i5));
		
	}


}
