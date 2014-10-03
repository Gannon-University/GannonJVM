package com.gannon.jvm.utilities;

import org.objectweb.asm.Label;

import com.gannon.asm.classgenerator.BClassGenerator;
import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BLabel;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.instructions.BIAdd;
import com.gannon.jvm.instructions.BIConst_0;
import com.gannon.jvm.instructions.BIConst_1;
import com.gannon.jvm.instructions.BIConst_3;
import com.gannon.jvm.instructions.BIFicmpge;
import com.gannon.jvm.instructions.BIFicmple;
import com.gannon.jvm.instructions.BIFicmpne;
import com.gannon.jvm.instructions.BILoad;
import com.gannon.jvm.instructions.BIReturn;
import com.gannon.jvm.instructions.BIStore;
import com.gannon.jvm.progam.path.Node;
import com.gannon.jvm.progam.path.NonPredicateNode;
import com.gannon.jvm.progam.path.PredicateNode;
import com.gannon.jvm.progam.path.TestPath;

public class InfeasiblePathUtility {
	/*
	 0  iload_1 [a]
     1  iload_2 [b]
     2  if_icmple 17
     5  iload_2 [b]
     6  iload_3 [c]
     7  if_icmple 17
    10  iload_3 [c]
    11  iload_1 [a]
    12  if_icmple 17
    15  iconst_3
    16  istore_1 [a]
    17  iload_1 [a]
    18  ireturn
	 */
	public static TestPath createPathID1() {
		TestPath path = new TestPath();
		path.setPathId(1);
			
		Node node0 = new NonPredicateNode(new BILoad(1, 0));
		path.add(node0);

		Node node1 = new NonPredicateNode(new BILoad(2, 1));
		path.add(node1);

		BLabel lable = new BLabel(new Label());
		PredicateNode node2 = new PredicateNode(new BIFicmple(lable, 2));
		node2.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node2);

		Node node5 = new NonPredicateNode(new BILoad(2, 5));
		path.add(node5);

		Node node6 = new NonPredicateNode(new BILoad(3, 6));
		path.add(node6);

		BLabel lable7 = new BLabel(new Label());
		PredicateNode node7 = new PredicateNode(new BIFicmple(lable7, 7));
		node7.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node7);

////////////////////////////////////////////////
		Node node10 = new NonPredicateNode(new BILoad(3, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BILoad(1, 11));
		path.add(node11);

		BLabel lable12 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable12, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);
		
		
		Node node15 = new NonPredicateNode(new BIConst_3(15));
		path.add(node15);

		Node node16 = new NonPredicateNode(new BIStore(1, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BILoad(1, 17));
		path.add(node17);
		
		Node node18= new NonPredicateNode(new BIReturn(18));
		path.add(node18);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("TestInfesaible.class");
		BMethod m = myclass.getMethod("infeasible");

		// set method in the path
		path.setbMethod(m);

		return path;
	}

}
