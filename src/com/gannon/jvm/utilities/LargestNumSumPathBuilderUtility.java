package com.gannon.jvm.utilities;

import java.util.ArrayList;

import org.objectweb.asm.Label;

import com.gannon.asm.classgenerator.BClassGenerator;
import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BLabel;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.instructions.BGoto;
import com.gannon.jvm.instructions.BIAdd;
import com.gannon.jvm.instructions.BIConst_1;
import com.gannon.jvm.instructions.BIConst_2;
import com.gannon.jvm.instructions.BIConst_3;
import com.gannon.jvm.instructions.BIConst_4;
import com.gannon.jvm.instructions.BIFicmpeq;
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

public class LargestNumSumPathBuilderUtility {
	public static TestPath createPathID1() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(1, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIStore(7, 8));
		path.add(node8);

		BLabel lable3 = new BLabel(new Label());
		Node node9 = new NonPredicateNode(new BGoto(lable3, 9));
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 40));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 41));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(6, 42));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 43));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(4, 44));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BIStore(8, 45));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		Node node18 = new NonPredicateNode(new BGoto(lable6, 46));
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node20);
		
		Node node21 = new NonPredicateNode(new BIAdd(77));
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BIReturn(78));
		path.add(node22);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);

		return path;
	}

	public static TestPath createPathID2() {
		TestPath path = new TestPath();
		path.setPathId(2);

		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(1, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIStore(7, 8));
		path.add(node8);

		BLabel lable3 = new BLabel(new Label());
		Node node9 = new NonPredicateNode(new BGoto(lable3, 9));
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 40));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 41));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(6, 42));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 43));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(6, 47));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BILoad(5, 48));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 49));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node18);
		
		Node node20 = new NonPredicateNode(new BILoad(6, 50));
		path.add(node20);
		
		Node node21 = new NonPredicateNode(new BIStore(8, 51));
		path.add(node21);
		
		BLabel lable7 = new BLabel(new Label());
		Node node22 = new NonPredicateNode(new BGoto(lable7, 52));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node23);
		
		Node node24 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BIAdd(77));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BIReturn(78));
		path.add(node26);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID3() {
		TestPath path = new TestPath();
		path.setPathId(3);

		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(1, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIStore(7, 8));
		path.add(node8);

		BLabel lable3 = new BLabel(new Label());
		Node node9 = new NonPredicateNode(new BGoto(lable3, 9));
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 40));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 41));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(6, 42));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 43));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(6, 47));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BILoad(5, 48));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 49));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node20 = new NonPredicateNode(new BILoad(5, 53));
		path.add(node20);
		
		Node node21 = new NonPredicateNode(new BIStore(8, 54));
		path.add(node21);
		
		BLabel lable7 = new BLabel(new Label());
		Node node22 = new NonPredicateNode(new BGoto(lable7, 55));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node23);
		
		Node node24 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BIAdd(77));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BIReturn(78));
		path.add(node26);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID4() {
		TestPath path = new TestPath();
		path.setPathId(4);

		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(1, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIStore(7, 8));
		path.add(node8);

		BLabel lable3 = new BLabel(new Label());
		Node node9 = new NonPredicateNode(new BGoto(lable3, 9));
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 40));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 58));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node25 = new NonPredicateNode(new BIConst_2(59));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BIReturn(60));
		path.add(node26);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID5() {
		TestPath path = new TestPath();
		path.setPathId(5);

		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(1, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIStore(7, 8));
		path.add(node8);

		BLabel lable3 = new BLabel(new Label());
		Node node9 = new NonPredicateNode(new BGoto(lable3, 9));
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 40));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 58));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);
		
		Node node16 = new NonPredicateNode(new BILoad(5, 61));
		path.add(node16);

		Node node17 = new NonPredicateNode(new BILoad(6, 62));
		path.add(node17);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 63));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(5, 64));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIStore(8, 65));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		Node node21 = new NonPredicateNode(new BGoto(lable7, 66));
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node22);
		
		Node node23= new NonPredicateNode(new BILoad(8, 76));
		path.add(node23);

		Node node25 = new NonPredicateNode(new BIAdd(77));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BIReturn(78));
		path.add(node26);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID6() {
		TestPath path = new TestPath();
		path.setPathId(6);

		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(1, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIStore(7, 8));
		path.add(node8);

		BLabel lable3 = new BLabel(new Label());
		Node node9 = new NonPredicateNode(new BGoto(lable3, 9));
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 40));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 58));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);
		
		Node node16 = new NonPredicateNode(new BILoad(5, 61));
		path.add(node16);

		Node node17 = new NonPredicateNode(new BILoad(6, 62));
		path.add(node17);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 63));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(4, 67));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(6, 68));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 69));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(4, 70));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BIStore(8, 71));
		path.add(node23);		
		
		BLabel lable8 = new BLabel(new Label());
		Node node24 = new NonPredicateNode(new BGoto(lable8, 72));
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node25);
		
		Node node26= new NonPredicateNode(new BILoad(8, 76));
		path.add(node26);

		Node node27 = new NonPredicateNode(new BIAdd(77));
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BIReturn(78));
		path.add(node28);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);

		return path;
	}

	public static TestPath createPathID7() {
		TestPath path = new TestPath();
		path.setPathId(7);
		
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(1, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIStore(7, 8));
		path.add(node8);

		BLabel lable3 = new BLabel(new Label());
		Node node9 = new NonPredicateNode(new BGoto(lable3, 9));
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 40));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 58));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);
		
		Node node16 = new NonPredicateNode(new BILoad(5, 61));
		path.add(node16);

		Node node17 = new NonPredicateNode(new BILoad(6, 62));
		path.add(node17);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 63));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(4, 67));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(6, 68));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 69));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(6, 73));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BIStore(8, 74));
		path.add(node23);		
		
		Node node25 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node25);
		
		Node node26= new NonPredicateNode(new BILoad(8, 76));
		path.add(node26);

		Node node27 = new NonPredicateNode(new BIAdd(77));
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BIReturn(78));
		path.add(node28);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);

		
		return path;
	}
	
	public static TestPath createPathID8() {
		TestPath path = new TestPath();
		path.setPathId(8);
		
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(3, 10));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(2, 11));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 12));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(3, 13));
		path.add(node10);		

		Node node11 = new NonPredicateNode(new BIStore(7, 14));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 15));
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(4, 41));
		path.add(node16);

		Node node17 = new NonPredicateNode(new BILoad(6, 42));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 43));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(4, 44));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIStore(8, 45));
		path.add(node20);	

		BLabel lable7 = new BLabel(new Label());
		Node node21 = new NonPredicateNode(new BGoto(lable7, 46));
		path.add(node21);

		Node node22= new NonPredicateNode(new BILoad(7, 75));
		path.add(node22);
		
		Node node26= new NonPredicateNode(new BILoad(8, 76));
		path.add(node26);

		Node node27 = new NonPredicateNode(new BIAdd(77));
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BIReturn(78));
		path.add(node28);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID9() {
		TestPath path = new TestPath();
		path.setPathId(9);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(3, 10));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(2, 11));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 12));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(3, 13));
		path.add(node10);		

		Node node11 = new NonPredicateNode(new BIStore(7, 14));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 15));
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(4, 41));
		path.add(node16);

		Node node17 = new NonPredicateNode(new BILoad(6, 42));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 43));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(6, 47));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(5, 48));
		path.add(node20);	

		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 49));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);

		Node node22= new NonPredicateNode(new BILoad(6, 50));
		path.add(node22);
		
		Node node26= new NonPredicateNode(new BIStore(8, 51));
		path.add(node26);
		
		BLabel lable8 = new BLabel(new Label());
		Node node27 = new NonPredicateNode(new BGoto(lable8, 52));
		path.add(node27);
		
		Node node28= new NonPredicateNode(new BILoad(7, 75));
		path.add(node28);
		
		Node node29= new NonPredicateNode(new BILoad(8, 76));
		path.add(node29);

		Node node30 = new NonPredicateNode(new BIAdd(77));
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BIReturn(78));
		path.add(node31);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID10() {
		TestPath path = new TestPath();
		path.setPathId(10);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(3, 10));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(2, 11));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 12));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(3, 13));
		path.add(node10);		

		Node node11 = new NonPredicateNode(new BIStore(7, 14));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 15));
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(4, 41));
		path.add(node16);

		Node node17 = new NonPredicateNode(new BILoad(6, 42));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 43));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(6, 47));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(5, 48));
		path.add(node20);	

		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 49));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);

		Node node22= new NonPredicateNode(new BILoad(5, 53));
		path.add(node22);
		
		Node node26= new NonPredicateNode(new BIStore(8, 54));
		path.add(node26);
		
		BLabel lable8 = new BLabel(new Label());
		Node node27 = new NonPredicateNode(new BGoto(lable8, 55));
		path.add(node27);
		
		Node node28= new NonPredicateNode(new BILoad(7, 75));
		path.add(node28);
		
		Node node29= new NonPredicateNode(new BILoad(8, 76));
		path.add(node29);

		Node node30 = new NonPredicateNode(new BIAdd(77));
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BIReturn(78));
		path.add(node31);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID11() {
		TestPath path = new TestPath();
		path.setPathId(11);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(3, 10));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(2, 11));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 12));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(3, 13));
		path.add(node10);		

		Node node11 = new NonPredicateNode(new BIStore(7, 14));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 15));
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node16);

		Node node17 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 58));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node18);

		Node node30 = new NonPredicateNode(new BIConst_2(59));
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BIReturn(60));
		path.add(node31);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		
		return path;
	}
	
	public static TestPath createPathID12() {
		TestPath path = new TestPath();
		path.setPathId(12);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(3, 10));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(2, 11));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 12));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(3, 13));
		path.add(node10);		

		Node node11 = new NonPredicateNode(new BIStore(7, 14));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 15));
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node16);

		Node node17 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 58));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(5, 61));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(6, 62));
		path.add(node20);

		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 63));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(5, 64));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BIStore(8, 65));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		Node node24 = new NonPredicateNode(new BGoto(lable8, 66));
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node26);
		
		Node node27 = new NonPredicateNode(new BIAdd(77));
		path.add(node27);
		
		Node node31 = new NonPredicateNode(new BIReturn(78));
		path.add(node31);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID13() {
		TestPath path = new TestPath();
		path.setPathId(13);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(3, 10));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(2, 11));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 12));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(3, 13));
		path.add(node10);		

		Node node11 = new NonPredicateNode(new BIStore(7, 14));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 15));
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node16);

		Node node17 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 58));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(5, 61));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(6, 62));
		path.add(node20);

		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 63));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(4, 67));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BILoad(6, 68));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmple(lable8, 69));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(4, 70));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BIStore(8, 71));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		Node node27 = new NonPredicateNode(new BGoto(lable9, 72));
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node29);
		
		Node node30 = new NonPredicateNode(new BIAdd(77));
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BIReturn(78));
		path.add(node31);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID14() {
		TestPath path = new TestPath();
		path.setPathId(14);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(3, 10));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(2, 11));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 12));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(3, 13));
		path.add(node10);		

		Node node11 = new NonPredicateNode(new BIStore(7, 14));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 15));
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node16);

		Node node17 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 58));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(5, 61));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(6, 62));
		path.add(node20);

		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 63));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(4, 67));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BILoad(6, 68));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmple(lable8, 69));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(6, 73));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BIStore(8, 74));
		path.add(node26);
		
		Node node28 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node29);
		
		Node node30 = new NonPredicateNode(new BIAdd(77));
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BIReturn(78));
		path.add(node31);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID15() {
		TestPath path = new TestPath();
		path.setPathId(15);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(3, 10));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(2, 11));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 12));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(2, 16));
		path.add(node10);		

		Node node11 = new NonPredicateNode(new BIStore(7, 17));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 18));
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(4, 41));
		path.add(node16);

		Node node17 = new NonPredicateNode(new BILoad(6, 42));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 43));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(4, 44));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIStore(8, 45));
		path.add(node20);

		BLabel lable7 = new BLabel(new Label());
		Node node21 = new NonPredicateNode(new BGoto(lable7, 46));
		path.add(node21);
		
		Node node28 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node29);
		
		Node node30 = new NonPredicateNode(new BIAdd(77));
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BIReturn(78));
		path.add(node31);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID16() {
		TestPath path = new TestPath();
		path.setPathId(16);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(3, 10));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(2, 11));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 12));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(2, 16));
		path.add(node10);		

		Node node11 = new NonPredicateNode(new BIStore(7, 17));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 18));
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(4, 41));
		path.add(node16);

		Node node17 = new NonPredicateNode(new BILoad(6, 42));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 43));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(6, 47));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(5, 48));
		path.add(node20);

		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 49));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node28 = new NonPredicateNode(new BILoad(6, 50));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BIStore(8, 51));
		path.add(node29);
		
		BLabel lable8 = new BLabel(new Label());
		Node node30 = new NonPredicateNode(new BGoto(lable8, 52));
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node32);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID17() {
		TestPath path = new TestPath();
		path.setPathId(17);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(3, 10));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(2, 11));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 12));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(2, 16));
		path.add(node10);		

		Node node11 = new NonPredicateNode(new BIStore(7, 17));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 18));
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(4, 41));
		path.add(node16);

		Node node17 = new NonPredicateNode(new BILoad(6, 42));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 43));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(6, 47));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(5, 48));
		path.add(node20);

		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 49));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node28 = new NonPredicateNode(new BILoad(5, 53));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BIStore(8, 54));
		path.add(node29);
		
		BLabel lable8 = new BLabel(new Label());
		Node node30 = new NonPredicateNode(new BGoto(lable8, 55));
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node32);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID18() {
		TestPath path = new TestPath();
		path.setPathId(18);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(3, 10));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(2, 11));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 12));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(2, 16));
		path.add(node10);		

		Node node11 = new NonPredicateNode(new BIStore(7, 17));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 18));
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node16);

		Node node17 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 58));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node18);
		
		Node node33 = new NonPredicateNode(new BIConst_2(59));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(60));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID19() {
		TestPath path = new TestPath();
		path.setPathId(19);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(3, 10));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(2, 11));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 12));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(2, 16));
		path.add(node10);		

		Node node11 = new NonPredicateNode(new BIStore(7, 17));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 18));
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node16);

		Node node17 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 58));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(5, 61));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(6, 62));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 63));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(5, 64));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BIStore(8, 65));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		Node node24 = new NonPredicateNode(new BGoto(lable8, 66));
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node26);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID20() {
		TestPath path = new TestPath();
		path.setPathId(20);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(3, 10));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(2, 11));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 12));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(2, 16));
		path.add(node10);		

		Node node11 = new NonPredicateNode(new BIStore(7, 17));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 18));
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node16);

		Node node17 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 58));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(5, 61));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(6, 62));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 63));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(4, 67));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BILoad(6, 68));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmple(lable8, 69));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(4, 70));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BIStore(8, 71));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		Node node27 = new NonPredicateNode(new BGoto(lable9, 72));
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node29);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID21() {
		TestPath path = new TestPath();
		path.setPathId(21);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(3, 5));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(3, 10));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(2, 11));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 12));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(2, 16));
		path.add(node10);		

		Node node11 = new NonPredicateNode(new BIStore(7, 17));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 18));
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node16);

		Node node17 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 58));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(5, 61));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(6, 62));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 63));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(4, 67));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BILoad(6, 68));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmple(lable8, 69));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(6, 73));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BIStore(8, 74));
		path.add(node26);
		
		Node node27 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node28);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID22() {
		TestPath path = new TestPath();
		path.setPathId(22);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);
		
		Node node33 = new NonPredicateNode(new BIConst_1(22));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(23));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID23() {
		TestPath path = new TestPath();
		path.setPathId(23);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(2, 27));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BIStore(7, 28));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 29));
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);
		
		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);
		
		Node node16 = new NonPredicateNode(new BILoad(4, 41));
		path.add(node16);
				
		Node node17 = new NonPredicateNode(new BILoad(6, 42));
		path.add(node17);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 43));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(4, 44));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIStore(8, 45));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		Node node21 = new NonPredicateNode(new BGoto(lable7, 46));
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node23);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID24() {
		TestPath path = new TestPath();
		path.setPathId(24);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(2, 27));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BIStore(7, 28));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 29));
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);
		
		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);
		
		Node node16 = new NonPredicateNode(new BILoad(4, 41));
		path.add(node16);
				
		Node node17 = new NonPredicateNode(new BILoad(6, 42));
		path.add(node17);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 43));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(6, 47));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(5, 48));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 49));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);

		Node node22 = new NonPredicateNode(new BILoad(6, 50));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BIStore(8, 51));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		Node node24 = new NonPredicateNode(new BGoto(lable8, 52));
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node26);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID25() {
		TestPath path = new TestPath();
		path.setPathId(25);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(2, 27));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BIStore(7, 28));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 29));
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);
		
		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);
		
		Node node16 = new NonPredicateNode(new BILoad(4, 41));
		path.add(node16);
				
		Node node17 = new NonPredicateNode(new BILoad(6, 42));
		path.add(node17);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 43));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(6, 47));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(5, 48));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 49));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);

		Node node22 = new NonPredicateNode(new BILoad(5, 53));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BIStore(8, 54));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		Node node24 = new NonPredicateNode(new BGoto(lable8, 55));
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node26);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID26() {
		TestPath path = new TestPath();
		path.setPathId(26);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(2, 27));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BIStore(7, 28));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 29));
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);
		
		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);
		
		Node node16 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node16);
				
		Node node17 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node17);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 58));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node18);
		
		Node node33 = new NonPredicateNode(new BIConst_2(59));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(60));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID27() {
		TestPath path = new TestPath();
		path.setPathId(27);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(2, 27));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BIStore(7, 28));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 29));
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);
		
		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);
		
		Node node16 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node16);
				
		Node node17 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node17);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 58));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(5, 61));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(6, 62));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 63));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(5, 64));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BIStore(8, 65));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		Node node24 = new NonPredicateNode(new BGoto(lable8, 66));
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node26);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID28() {
		TestPath path = new TestPath();
		path.setPathId(28);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(2, 27));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BIStore(7, 28));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 29));
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);
		
		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);
		
		Node node16 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node16);
				
		Node node17 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node17);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 58));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(5, 61));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(6, 62));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 63));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(4, 67));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BILoad(6, 68));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmple(lable8, 69));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(4, 70));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BIStore(8, 71));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		Node node27 = new NonPredicateNode(new BGoto(lable9, 72));
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node29);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID29() {
		TestPath path = new TestPath();
		path.setPathId(29);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(2, 27));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BIStore(7, 28));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		Node node12 = new NonPredicateNode(new BGoto(lable4, 29));
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node14);
		
		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmple(lable5, 40));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);
		
		Node node16 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node16);
				
		Node node17 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node17);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 58));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(5, 61));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(6, 62));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 63));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(4, 67));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BILoad(6, 68));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmple(lable8, 69));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(6, 73));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BIStore(8, 74));
		path.add(node26);
		
		Node node28 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node29);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID30() {
		TestPath path = new TestPath();
		path.setPathId(30);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(1, 30));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BILoad(3, 31));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 32));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(1, 33));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BIStore(7, 34));
		path.add(node14);
		
		BLabel lable5 = new BLabel(new Label());
		Node node15 = new NonPredicateNode(new BGoto(lable5, 35));
		path.add(node15);
				
		Node node16 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node17);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 40));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(4, 41));
		path.add(node19);
				
		Node node20 = new NonPredicateNode(new BILoad(6, 42));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 43));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(4, 44));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BIStore(8, 45));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		Node node24 = new NonPredicateNode(new BGoto(lable8, 46));
		path.add(node24);
		
		Node node28 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node29);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID31() {
		TestPath path = new TestPath();
		path.setPathId(31);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(1, 30));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BILoad(3, 31));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 32));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(1, 33));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BIStore(7, 34));
		path.add(node14);
		
		BLabel lable5 = new BLabel(new Label());
		Node node15 = new NonPredicateNode(new BGoto(lable5, 35));
		path.add(node15);
				
		Node node16 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node17);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 40));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(4, 41));
		path.add(node19);
				
		Node node20 = new NonPredicateNode(new BILoad(6, 42));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 43));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(6, 47));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BILoad(5, 48));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmple(lable8, 49));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node28 = new NonPredicateNode(new BILoad(6, 50));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BIStore(8, 51));
		path.add(node29);
		
		BLabel lable9 = new BLabel(new Label());
		Node node30 = new NonPredicateNode(new BGoto(lable9, 52));
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node32);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID32() {
		TestPath path = new TestPath();
		path.setPathId(32);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(1, 30));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BILoad(3, 31));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 32));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(1, 33));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BIStore(7, 34));
		path.add(node14);
		
		BLabel lable5 = new BLabel(new Label());
		Node node15 = new NonPredicateNode(new BGoto(lable5, 35));
		path.add(node15);
				
		Node node16 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node17);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 40));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(4, 41));
		path.add(node19);
				
		Node node20 = new NonPredicateNode(new BILoad(6, 42));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 43));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(6, 47));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BILoad(5, 48));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmple(lable8, 49));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node24);
		
		Node node28 = new NonPredicateNode(new BILoad(5, 53));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BIStore(8, 54));
		path.add(node29);
		
		BLabel lable9 = new BLabel(new Label());
		Node node30 = new NonPredicateNode(new BGoto(lable9, 55));
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node32);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID33() {
		TestPath path = new TestPath();
		path.setPathId(33);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(1, 30));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BILoad(3, 31));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 32));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(1, 33));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BIStore(7, 34));
		path.add(node14);
		
		BLabel lable5 = new BLabel(new Label());
		Node node15 = new NonPredicateNode(new BGoto(lable5, 35));
		path.add(node15);
				
		Node node16 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node17);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 40));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node19);
				
		Node node20 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 58));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node33 = new NonPredicateNode(new BIConst_2(59));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(60));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID34() {
		TestPath path = new TestPath();
		path.setPathId(34);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(1, 30));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BILoad(3, 31));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 32));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(1, 33));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BIStore(7, 34));
		path.add(node14);
		
		BLabel lable5 = new BLabel(new Label());
		Node node15 = new NonPredicateNode(new BGoto(lable5, 35));
		path.add(node15);
				
		Node node16 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node17);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 40));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node19);
				
		Node node20 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 58));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(5, 61));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BILoad(6, 62));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmple(lable8, 63));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(5, 64));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BIStore(8, 65));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		Node node27 = new NonPredicateNode(new BGoto(lable9, 66));
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node29);
		
		Node node33 = new NonPredicateNode(new BIConst_2(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID35() {
		TestPath path = new TestPath();
		path.setPathId(35);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(1, 30));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BILoad(3, 31));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 32));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(1, 33));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BIStore(7, 34));
		path.add(node14);
		
		BLabel lable5 = new BLabel(new Label());
		Node node15 = new NonPredicateNode(new BGoto(lable5, 35));
		path.add(node15);
				
		Node node16 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node17);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 40));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node19);
				
		Node node20 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 58));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(5, 61));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BILoad(6, 62));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmple(lable8, 63));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(4, 67));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BILoad(6, 68));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmple(lable9, 69));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(4, 70));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BIStore(8, 71));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		Node node30 = new NonPredicateNode(new BGoto(lable10, 72));
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node32);
		
		Node node33 = new NonPredicateNode(new BIConst_2(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID36() {
		TestPath path = new TestPath();
		path.setPathId(36);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(1, 30));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BILoad(3, 31));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 32));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(1, 33));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BIStore(7, 34));
		path.add(node14);
		
		BLabel lable5 = new BLabel(new Label());
		Node node15 = new NonPredicateNode(new BGoto(lable5, 35));
		path.add(node15);
				
		Node node16 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node17);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 40));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node19);
				
		Node node20 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 58));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(5, 61));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BILoad(6, 62));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmple(lable8, 63));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(4, 67));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BILoad(6, 68));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmple(lable9, 69));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(6, 73));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BIStore(8, 74));
		path.add(node29);
		
		Node node31 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node32);
		
		Node node33 = new NonPredicateNode(new BIConst_2(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID37() {
		TestPath path = new TestPath();
		path.setPathId(37);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(1, 30));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BILoad(3, 31));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 32));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(3, 36));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BIStore(7, 37));
		path.add(node14);
		
		Node node15 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node15);
		
		Node node16 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node16);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 40));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(4, 41));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(6, 42));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 43));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(4, 44));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BIStore(8, 45));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		Node node24 = new NonPredicateNode(new BGoto(lable8, 46));
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node25);
		
		Node node31 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node32);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID38() {
		TestPath path = new TestPath();
		path.setPathId(38);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(1, 30));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BILoad(3, 31));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 32));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(3, 36));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BIStore(7, 37));
		path.add(node14);
		
		Node node15 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node15);
		
		Node node16 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node16);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 40));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(4, 41));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(6, 42));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 43));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(6, 47));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BILoad(5, 48));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmple(lable8, 49));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(6, 50));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BIStore(8, 51));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		Node node27 = new NonPredicateNode(new BGoto(lable9, 52));
		path.add(node27);
		
		Node node31 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node32);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID39() {
		TestPath path = new TestPath();
		path.setPathId(39);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(1, 30));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BILoad(3, 31));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 32));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(3, 36));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BIStore(7, 37));
		path.add(node14);
		
		Node node15 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node15);
		
		Node node16 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node16);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 40));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(4, 41));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(6, 42));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 43));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(6, 47));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BILoad(5, 48));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmple(lable8, 49));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(5, 53));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BIStore(8, 54));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		Node node27 = new NonPredicateNode(new BGoto(lable9, 55));
		path.add(node27);
		
		Node node31 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node32);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID40() {
		TestPath path = new TestPath();
		path.setPathId(40);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(1, 30));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BILoad(3, 31));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 32));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(3, 36));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BIStore(7, 37));
		path.add(node14);
		
		Node node15 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node15);
		
		Node node16 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node16);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 40));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 58));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node33 = new NonPredicateNode(new BIConst_2(59));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(60));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID41() {
		TestPath path = new TestPath();
		path.setPathId(41);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(1, 30));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BILoad(3, 31));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 32));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(3, 36));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BIStore(7, 37));
		path.add(node14);
		
		Node node15 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node15);
		
		Node node16 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node16);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 40));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 58));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(5, 61));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BILoad(6, 62));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmple(lable8, 63));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(5, 64));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BIStore(8, 65));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		Node node27 = new NonPredicateNode(new BGoto(lable9, 66));
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node29);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID42() {
		TestPath path = new TestPath();
		path.setPathId(42);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(1, 30));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BILoad(3, 31));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 32));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(3, 36));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BIStore(7, 37));
		path.add(node14);
		
		Node node15 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node15);
		
		Node node16 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node16);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 40));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 58));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(5, 61));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BILoad(6, 62));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmple(lable8, 63));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(4, 67));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BILoad(6, 68));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmple(lable9, 69));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(4, 70));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BIStore(8, 71));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		Node node30 = new NonPredicateNode(new BGoto(lable10, 72));
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node32);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
	public static TestPath createPathID43() {
		TestPath path = new TestPath();
		path.setPathId(43);
		Node node1 = new NonPredicateNode(new BILoad(1, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BILoad(2, 2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmple(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BILoad(2, 20));
		path.add(node5);

		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmple(lable2, 21));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);
		
		Node node7 = new NonPredicateNode(new BILoad(2, 24));
		path.add(node7);
		
		Node node8 = new NonPredicateNode(new BILoad(3, 25));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmple(lable3, 26));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);
		
		Node node10 = new NonPredicateNode(new BILoad(1, 30));
		path.add(node10);
		
		Node node11 = new NonPredicateNode(new BILoad(3, 31));
		path.add(node11);
		
		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmple(lable4, 32));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node12);
		
		Node node13 = new NonPredicateNode(new BILoad(3, 36));
		path.add(node13);
		
		Node node14 = new NonPredicateNode(new BIStore(7, 37));
		path.add(node14);
		
		Node node15 = new NonPredicateNode(new BILoad(4, 38));
		path.add(node15);
		
		Node node16 = new NonPredicateNode(new BILoad(5, 39));
		path.add(node16);
		
		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmple(lable6, 40));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(4, 56));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BILoad(5, 57));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmple(lable7, 58));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(5, 61));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BILoad(6, 62));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmple(lable8, 63));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(4, 67));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BILoad(6, 68));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmple(lable9, 69));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(6, 73));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BIStore(8, 74));
		path.add(node29);
		
		Node node31 = new NonPredicateNode(new BILoad(7, 75));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BILoad(8, 76));
		path.add(node32);
		
		Node node33 = new NonPredicateNode(new BIAdd(77));
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIReturn(78));
		path.add(node34);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("LargestNumSum.class");
		BMethod m = myclass.getMethod("largeNumSum");

		// set method in the path
		path.setbMethod(m);
		return path;
	}
	
}
