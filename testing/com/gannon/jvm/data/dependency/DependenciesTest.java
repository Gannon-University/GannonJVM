package com.gannon.jvm.data.dependency;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.gannon.asm.classgenerator.BClassGenerator;
import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BLocalVariable;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.instructions.BIAdd;
import com.gannon.jvm.utilities.TrianglePathBuilderUtility;


public class DependenciesTest {
	BClass myclass;
	BMethod m;
	
	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};
	
	@Before
	public void setUp() throws Exception{
		// get Method instructions
		myclass = BClassGenerator.getBClass("Triangle.class");
		m = myclass.getMethod("triangleType");
	}

	@Test
	public void testFindRelationByInstruction() {
		BLocalVariable p0 = new BLocalVariable(null, null, null, null, null, 1, 0);
		GannonPredicateTreeBuilderJVM jvm = new GannonPredicateTreeBuilderJVM();
		jvm.run(null, m, TrianglePathBuilderUtility.createPathID1(), TrianglePathBuilderUtility.createPathID10_input());

		ArrayList<BinNode> expectedLeaves23 = new ArrayList<BinNode>();
		expectedLeaves23.add(new BinNode(2,p0));
		expectedLeaves23.add(new BinNode(3,p0));
		// 0:first parameter
		Dependencies relations = jvm.getRelationFrame().getRelations();
		System.out.print(relations);
		ArrayList<BinNode> actualLeaves = relations.getRelation(4).getAllLeaves(); 
		assertEquals(expectedLeaves23, actualLeaves);
		assertEquals(relations.findRelation(new BIAdd(4)),relations.getRelation(4));
//		Label l=new Label();
//		BLabel blabel=new BLabel(l);
//		assertEquals(relations.getRelation(4),relations.findRelation(new BIFicmpge(blabel,11)));
	}

}
