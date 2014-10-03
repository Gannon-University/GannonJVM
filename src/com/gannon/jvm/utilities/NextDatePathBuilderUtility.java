package com.gannon.jvm.utilities;

import java.util.ArrayList;

import org.objectweb.asm.Label;

import com.gannon.asm.classgenerator.BClassGenerator;
import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BLabel;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.instructions.BBipush;
import com.gannon.jvm.instructions.BGoto;
import com.gannon.jvm.instructions.BIAdd;
import com.gannon.jvm.instructions.BIConst_1;
import com.gannon.jvm.instructions.BIConst_2;
import com.gannon.jvm.instructions.BIConst_3;
import com.gannon.jvm.instructions.BIConst_4;
import com.gannon.jvm.instructions.BIConst_5;
import com.gannon.jvm.instructions.BIFicmpeq;
import com.gannon.jvm.instructions.BIFicmpge;
import com.gannon.jvm.instructions.BIFicmple;
import com.gannon.jvm.instructions.BIFicmpne;
import com.gannon.jvm.instructions.BIFne;
import com.gannon.jvm.instructions.BILoad;
import com.gannon.jvm.instructions.BIRem;
import com.gannon.jvm.instructions.BIReturn;
import com.gannon.jvm.instructions.BIStore;
import com.gannon.jvm.instructions.BSipush;
import com.gannon.jvm.progam.path.Node;
import com.gannon.jvm.progam.path.NonPredicateNode;
import com.gannon.jvm.progam.path.PredicateNode;
import com.gannon.jvm.progam.path.TestPath;

public class NextDatePathBuilderUtility {
	public static TestPath createPathID1() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BBipush(31, 20));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpge(lable7, 21));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BIConst_1(22));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BIReturn(23));
		path.add(node23);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID2() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BBipush(31, 20));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpge(lable7, 21));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BIConst_2(24));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BIReturn(25));
		path.add(node23);

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}

	public static TestPath createPathID3() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(0, 32));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(9, 33));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpeq(lable9, 34));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(0, 35));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BBipush(11, 36));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		PredicateNode node30 = new PredicateNode(new BIFicmpne(lable10, 37));
		node30.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(1, 38));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BBipush(30, 39));
		path.add(node32);
		
		BLabel lable11 = new BLabel(new Label());
		PredicateNode node33 = new PredicateNode(new BIFicmpge(lable11, 40));
		node33.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIConst_3(41));
		path.add(node34);
		
		Node node35 = new NonPredicateNode(new BIReturn(42));
		path.add(node35);
		

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID4() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(0, 32));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(9, 33));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpeq(lable9, 34));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(0, 35));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BBipush(11, 36));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		PredicateNode node30 = new PredicateNode(new BIFicmpne(lable10, 37));
		node30.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(1, 38));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BBipush(30, 39));
		path.add(node32);
		
		BLabel lable11 = new BLabel(new Label());
		PredicateNode node33 = new PredicateNode(new BIFicmpge(lable11, 40));
		node33.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BIConst_4(43));
		path.add(node34);
		
		Node node35 = new NonPredicateNode(new BIReturn(44));
		path.add(node35);
		

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID5() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(0, 32));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(9, 33));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpeq(lable9, 34));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(0, 35));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BBipush(11, 36));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		PredicateNode node30 = new PredicateNode(new BIFicmpne(lable10, 37));
		node30.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(0, 45));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BBipush(12, 46));
		path.add(node32);
		
		BLabel lable11 = new BLabel(new Label());
		PredicateNode node33 = new PredicateNode(new BIFicmpne(lable11, 47));
		node33.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BILoad(1, 48));
		path.add(node34);
		
		Node node35 = new NonPredicateNode(new BBipush(31, 49));
		path.add(node35);
		
		BLabel lable12 = new BLabel(new Label());
		PredicateNode node36 = new PredicateNode(new BIFicmpge(lable12, 50));
		node36.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node36);
		
		Node node37 = new NonPredicateNode(new BIConst_5(51));
		path.add(node37);
		
		Node node38 = new NonPredicateNode(new BIReturn(52));
		path.add(node38);
		

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	
	public static TestPath createPathID6() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(0, 32));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(9, 33));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpeq(lable9, 34));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(0, 35));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BBipush(11, 36));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		PredicateNode node30 = new PredicateNode(new BIFicmpne(lable10, 37));
		node30.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(0, 45));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BBipush(12, 46));
		path.add(node32);
		
		BLabel lable11 = new BLabel(new Label());
		PredicateNode node33 = new PredicateNode(new BIFicmpne(lable11, 47));
		node33.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BILoad(1, 48));
		path.add(node34);
		
		Node node35 = new NonPredicateNode(new BBipush(31, 49));
		path.add(node35);
		
		BLabel lable12 = new BLabel(new Label());
		PredicateNode node36 = new PredicateNode(new BIFicmpge(lable12, 50));
		node36.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node36);
		
		Node node37 = new NonPredicateNode(new BBipush(6, 53));
		path.add(node37);
		
		Node node38 = new NonPredicateNode(new BIReturn(54));
		path.add(node38);
		

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID7() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(0, 32));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(9, 33));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpeq(lable9, 34));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(0, 35));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BBipush(11, 36));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		PredicateNode node30 = new PredicateNode(new BIFicmpne(lable10, 37));
		node30.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(0, 45));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BBipush(12, 46));
		path.add(node32);
		
		BLabel lable11 = new BLabel(new Label());
		PredicateNode node33 = new PredicateNode(new BIFicmpne(lable11, 47));
		node33.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BILoad(0, 55));
		path.add(node34);
		
		Node node35 = new NonPredicateNode(new BIConst_2(56));
		path.add(node35);
		
		BLabel lable12 = new BLabel(new Label());
		PredicateNode node36 = new PredicateNode(new BIFicmpne(lable12, 57));
		node36.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node36);
		
		Node node37 = new NonPredicateNode(new BILoad(1, 58));
		path.add(node37);
		
		Node node38 = new NonPredicateNode(new BBipush(28, 59));
		path.add(node38);
		
		BLabel lable13 = new BLabel(new Label());
		PredicateNode node39 = new PredicateNode(new BIFicmpge(lable13, 60));
		node39.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node39);
		
		Node node40 = new NonPredicateNode(new BBipush(7, 61));
		path.add(node40);
		
		Node node41 = new NonPredicateNode(new BIReturn(62));
		path.add(node41);
		

		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID8() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(0, 32));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(9, 33));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpeq(lable9, 34));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(0, 35));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BBipush(11, 36));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		PredicateNode node30 = new PredicateNode(new BIFicmpne(lable10, 37));
		node30.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(0, 45));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BBipush(12, 46));
		path.add(node32);
		
		BLabel lable11 = new BLabel(new Label());
		PredicateNode node33 = new PredicateNode(new BIFicmpne(lable11, 47));
		node33.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BILoad(0, 55));
		path.add(node34);
		
		Node node35 = new NonPredicateNode(new BIConst_2(56));
		path.add(node35);
		
		BLabel lable12 = new BLabel(new Label());
		PredicateNode node36 = new PredicateNode(new BIFicmpne(lable12, 57));
		node36.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node36);
		
		Node node37 = new NonPredicateNode(new BILoad(1, 58));
		path.add(node37);
		
		Node node38 = new NonPredicateNode(new BBipush(28, 59));
		path.add(node38);
		
		BLabel lable13 = new BLabel(new Label());
		PredicateNode node39 = new PredicateNode(new BIFicmpge(lable13, 60));
		node39.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node39);
		
		Node node40 = new NonPredicateNode(new BILoad(1, 63));
		path.add(node40);
		
		Node node41 = new NonPredicateNode(new BBipush(28, 64));
		path.add(node41);
		
		BLabel lable14 = new BLabel(new Label());
		PredicateNode node42 = new PredicateNode(new BIFicmpne(lable14, 65));
		node42.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node42);
		
		Node node43 = new NonPredicateNode(new BILoad(2, 66));
		path.add(node43);
		
		Node node44 = new NonPredicateNode(new BIConst_4(67));
		path.add(node44);
		
		Node node45 = new NonPredicateNode(new BIRem(68));
		path.add(node45);
		
		BLabel lable15 = new BLabel(new Label());
		PredicateNode node46 = new PredicateNode(new BIFne(lable15, 69));
		node46.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node46);
		
		Node node47 = new NonPredicateNode(new BILoad(2, 70));
		path.add(node47);
		
		Node node48 = new NonPredicateNode(new BBipush(100, 71));
		path.add(node48);
		
		Node node49 = new NonPredicateNode(new BIRem(72));
		path.add(node49);
		
		BLabel lable16= new BLabel(new Label());
		PredicateNode node50 = new PredicateNode(new BIFne(lable16, 73));
		node50.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node50);
		
		Node node51 = new NonPredicateNode(new BILoad(2, 74));
		path.add(node51);
		
		Node node52 = new NonPredicateNode(new BSipush(400, 75));
		path.add(node52);
		
		Node node53 = new NonPredicateNode(new BIRem(76));
		path.add(node53);
		
		BLabel lable17 = new BLabel(new Label());
		PredicateNode node54 = new PredicateNode(new BIFne(lable17, 77));
		node54.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node54);
		
		Node node55 = new NonPredicateNode(new BBipush(7, 78));
		path.add(node55);
		
		Node node56 = new NonPredicateNode(new BIReturn(79));
		path.add(node56);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID9() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(0, 32));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(9, 33));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpeq(lable9, 34));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(0, 35));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BBipush(11, 36));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		PredicateNode node30 = new PredicateNode(new BIFicmpne(lable10, 37));
		node30.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(0, 45));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BBipush(12, 46));
		path.add(node32);
		
		BLabel lable11 = new BLabel(new Label());
		PredicateNode node33 = new PredicateNode(new BIFicmpne(lable11, 47));
		node33.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BILoad(0, 55));
		path.add(node34);
		
		Node node35 = new NonPredicateNode(new BIConst_2(56));
		path.add(node35);
		
		BLabel lable12 = new BLabel(new Label());
		PredicateNode node36 = new PredicateNode(new BIFicmpne(lable12, 57));
		node36.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node36);
		
		Node node37 = new NonPredicateNode(new BILoad(1, 58));
		path.add(node37);
		
		Node node38 = new NonPredicateNode(new BBipush(28, 59));
		path.add(node38);
		
		BLabel lable13 = new BLabel(new Label());
		PredicateNode node39 = new PredicateNode(new BIFicmpge(lable13, 60));
		node39.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node39);
		
		Node node40 = new NonPredicateNode(new BILoad(1, 63));
		path.add(node40);
		
		Node node41 = new NonPredicateNode(new BBipush(28, 64));
		path.add(node41);
		
		BLabel lable14 = new BLabel(new Label());
		PredicateNode node42 = new PredicateNode(new BIFicmpne(lable14, 65));
		node42.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node42);
		
		Node node43 = new NonPredicateNode(new BILoad(2, 66));
		path.add(node43);
		
		Node node44 = new NonPredicateNode(new BIConst_4(67));
		path.add(node44);
		
		Node node45 = new NonPredicateNode(new BIRem(68));
		path.add(node45);
		
		BLabel lable15 = new BLabel(new Label());
		PredicateNode node46 = new PredicateNode(new BIFne(lable15, 69));
		node46.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node46);
		
		Node node47 = new NonPredicateNode(new BILoad(2, 70));
		path.add(node47);
		
		Node node48 = new NonPredicateNode(new BBipush(100, 71));
		path.add(node48);
		
		Node node49 = new NonPredicateNode(new BIRem(72));
		path.add(node49);
		
		BLabel lable16= new BLabel(new Label());
		PredicateNode node50 = new PredicateNode(new BIFne(lable16, 73));
		node50.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node50);
		
		Node node51 = new NonPredicateNode(new BILoad(2, 74));
		path.add(node51);
		
		Node node52 = new NonPredicateNode(new BSipush(400, 75));
		path.add(node52);
		
		Node node53 = new NonPredicateNode(new BIRem(76));
		path.add(node53);
		
		BLabel lable17 = new BLabel(new Label());
		PredicateNode node54 = new PredicateNode(new BIFne(lable17, 77));
		node54.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node54);
		
		Node node55 = new NonPredicateNode(new BBipush(9, 80));
		path.add(node55);
		
		Node node56 = new NonPredicateNode(new BIReturn(81));
		path.add(node56);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID10() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(0, 32));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(9, 33));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpeq(lable9, 34));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(0, 35));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BBipush(11, 36));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		PredicateNode node30 = new PredicateNode(new BIFicmpne(lable10, 37));
		node30.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(0, 45));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BBipush(12, 46));
		path.add(node32);
		
		BLabel lable11 = new BLabel(new Label());
		PredicateNode node33 = new PredicateNode(new BIFicmpne(lable11, 47));
		node33.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BILoad(0, 55));
		path.add(node34);
		
		Node node35 = new NonPredicateNode(new BIConst_2(56));
		path.add(node35);
		
		BLabel lable12 = new BLabel(new Label());
		PredicateNode node36 = new PredicateNode(new BIFicmpne(lable12, 57));
		node36.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node36);
		
		Node node37 = new NonPredicateNode(new BILoad(1, 58));
		path.add(node37);
		
		Node node38 = new NonPredicateNode(new BBipush(28, 59));
		path.add(node38);
		
		BLabel lable13 = new BLabel(new Label());
		PredicateNode node39 = new PredicateNode(new BIFicmpge(lable13, 60));
		node39.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node39);
		
		Node node40 = new NonPredicateNode(new BILoad(1, 63));
		path.add(node40);
		
		Node node41 = new NonPredicateNode(new BBipush(28, 64));
		path.add(node41);
		
		BLabel lable14 = new BLabel(new Label());
		PredicateNode node42 = new PredicateNode(new BIFicmpne(lable14, 65));
		node42.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node42);
		
		Node node43 = new NonPredicateNode(new BILoad(2, 66));
		path.add(node43);
		
		Node node44 = new NonPredicateNode(new BIConst_4(67));
		path.add(node44);
		
		Node node45 = new NonPredicateNode(new BIRem(68));
		path.add(node45);
		
		BLabel lable15 = new BLabel(new Label());
		PredicateNode node46 = new PredicateNode(new BIFne(lable15, 69));
		node46.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node46);
		
		Node node47 = new NonPredicateNode(new BILoad(2, 70));
		path.add(node47);
		
		Node node48 = new NonPredicateNode(new BBipush(100, 71));
		path.add(node48);
		
		Node node49 = new NonPredicateNode(new BIRem(72));
		path.add(node49);
		
		BLabel lable16= new BLabel(new Label());
		PredicateNode node50 = new PredicateNode(new BIFne(lable16, 73));
		node50.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node50);
		
		Node node55 = new NonPredicateNode(new BBipush(8, 78));
		path.add(node55);
		
		Node node56 = new NonPredicateNode(new BIReturn(79));
		path.add(node56);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID11() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(0, 32));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(9, 33));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpeq(lable9, 34));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(0, 35));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BBipush(11, 36));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		PredicateNode node30 = new PredicateNode(new BIFicmpne(lable10, 37));
		node30.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(0, 45));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BBipush(12, 46));
		path.add(node32);
		
		BLabel lable11 = new BLabel(new Label());
		PredicateNode node33 = new PredicateNode(new BIFicmpne(lable11, 47));
		node33.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BILoad(0, 55));
		path.add(node34);
		
		Node node35 = new NonPredicateNode(new BIConst_2(56));
		path.add(node35);
		
		BLabel lable12 = new BLabel(new Label());
		PredicateNode node36 = new PredicateNode(new BIFicmpne(lable12, 57));
		node36.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node36);
		
		Node node37 = new NonPredicateNode(new BILoad(1, 58));
		path.add(node37);
		
		Node node38 = new NonPredicateNode(new BBipush(28, 59));
		path.add(node38);
		
		BLabel lable13 = new BLabel(new Label());
		PredicateNode node39 = new PredicateNode(new BIFicmpge(lable13, 60));
		node39.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node39);
		
		Node node40 = new NonPredicateNode(new BILoad(1, 63));
		path.add(node40);
		
		Node node41 = new NonPredicateNode(new BBipush(28, 64));
		path.add(node41);
		
		BLabel lable14 = new BLabel(new Label());
		PredicateNode node42 = new PredicateNode(new BIFicmpne(lable14, 65));
		node42.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node42);
		
		Node node43 = new NonPredicateNode(new BILoad(2, 66));
		path.add(node43);
		
		Node node44 = new NonPredicateNode(new BIConst_4(67));
		path.add(node44);
		
		Node node45 = new NonPredicateNode(new BIRem(68));
		path.add(node45);
		
		BLabel lable15 = new BLabel(new Label());
		PredicateNode node46 = new PredicateNode(new BIFne(lable15, 69));
		node46.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node46);
		
		Node node47 = new NonPredicateNode(new BILoad(2, 74));
		path.add(node47);
		
		Node node48 = new NonPredicateNode(new BSipush(400, 75));
		path.add(node48);
		
		Node node49 = new NonPredicateNode(new BIRem(76));
		path.add(node49);
		
		BLabel lable16= new BLabel(new Label());
		PredicateNode node50 = new PredicateNode(new BIFne(lable16, 77));
		node50.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node50);
		
		Node node55 = new NonPredicateNode(new BBipush(8, 78));
		path.add(node55);
		
		Node node56 = new NonPredicateNode(new BIReturn(79));
		path.add(node56);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID12() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(0, 32));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(9, 33));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpeq(lable9, 34));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(0, 35));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BBipush(11, 36));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		PredicateNode node30 = new PredicateNode(new BIFicmpne(lable10, 37));
		node30.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(0, 45));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BBipush(12, 46));
		path.add(node32);
		
		BLabel lable11 = new BLabel(new Label());
		PredicateNode node33 = new PredicateNode(new BIFicmpne(lable11, 47));
		node33.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BILoad(0, 55));
		path.add(node34);
		
		Node node35 = new NonPredicateNode(new BIConst_2(56));
		path.add(node35);
		
		BLabel lable12 = new BLabel(new Label());
		PredicateNode node36 = new PredicateNode(new BIFicmpne(lable12, 57));
		node36.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node36);
		
		Node node37 = new NonPredicateNode(new BILoad(1, 58));
		path.add(node37);
		
		Node node38 = new NonPredicateNode(new BBipush(28, 59));
		path.add(node38);
		
		BLabel lable13 = new BLabel(new Label());
		PredicateNode node39 = new PredicateNode(new BIFicmpge(lable13, 60));
		node39.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node39);
		
		Node node40 = new NonPredicateNode(new BILoad(1, 63));
		path.add(node40);
		
		Node node41 = new NonPredicateNode(new BBipush(28, 64));
		path.add(node41);
		
		BLabel lable14 = new BLabel(new Label());
		PredicateNode node42 = new PredicateNode(new BIFicmpne(lable14, 65));
		node42.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node42);
		
		Node node43 = new NonPredicateNode(new BILoad(2, 66));
		path.add(node43);
		
		Node node44 = new NonPredicateNode(new BIConst_4(67));
		path.add(node44);
		
		Node node45 = new NonPredicateNode(new BIRem(68));
		path.add(node45);
		
		BLabel lable15 = new BLabel(new Label());
		PredicateNode node46 = new PredicateNode(new BIFne(lable15, 69));
		node46.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node46);
		
		Node node47 = new NonPredicateNode(new BILoad(2, 74));
		path.add(node47);
		
		Node node48 = new NonPredicateNode(new BSipush(400, 75));
		path.add(node48);
		
		Node node49 = new NonPredicateNode(new BIRem(76));
		path.add(node49);
		
		BLabel lable16= new BLabel(new Label());
		PredicateNode node50 = new PredicateNode(new BIFne(lable16, 77));
		node50.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node50);
		
		Node node55 = new NonPredicateNode(new BBipush(9, 80));
		path.add(node55);
		
		Node node56 = new NonPredicateNode(new BIReturn(81));
		path.add(node56);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID13() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(0, 32));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(9, 33));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpeq(lable9, 34));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(0, 35));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BBipush(11, 36));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		PredicateNode node30 = new PredicateNode(new BIFicmpne(lable10, 37));
		node30.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(0, 45));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BBipush(12, 46));
		path.add(node32);
		
		BLabel lable11 = new BLabel(new Label());
		PredicateNode node33 = new PredicateNode(new BIFicmpne(lable11, 47));
		node33.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BILoad(0, 55));
		path.add(node34);
		
		Node node35 = new NonPredicateNode(new BIConst_2(56));
		path.add(node35);
		
		BLabel lable12 = new BLabel(new Label());
		PredicateNode node36 = new PredicateNode(new BIFicmpne(lable12, 57));
		node36.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node36);
		
		Node node37 = new NonPredicateNode(new BILoad(1, 58));
		path.add(node37);
		
		Node node38 = new NonPredicateNode(new BBipush(28, 59));
		path.add(node38);
		
		BLabel lable13 = new BLabel(new Label());
		PredicateNode node39 = new PredicateNode(new BIFicmpge(lable13, 60));
		node39.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node39);
		
		Node node40 = new NonPredicateNode(new BILoad(1, 63));
		path.add(node40);
		
		Node node41 = new NonPredicateNode(new BBipush(28, 64));
		path.add(node41);
		
		BLabel lable14 = new BLabel(new Label());
		PredicateNode node42 = new PredicateNode(new BIFicmpne(lable14, 65));
		node42.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node42);
		
		Node node43 = new NonPredicateNode(new BILoad(1, 82));
		path.add(node43);
		
		Node node44 = new NonPredicateNode(new BBipush(29, 83));
		path.add(node44);
		
		BLabel lable15 = new BLabel(new Label());
		PredicateNode node46 = new PredicateNode(new BIFne(lable15, 84));
		node46.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node46);
		
		Node node47 = new NonPredicateNode(new BILoad(2, 85));
		path.add(node47);
		
		Node node48 = new NonPredicateNode(new BIConst_4(86));
		path.add(node48);
		
		Node node49 = new NonPredicateNode(new BIRem(87));
		path.add(node49);
		
		BLabel lable16= new BLabel(new Label());
		PredicateNode node50 = new PredicateNode(new BIFne(lable16, 88));
		node50.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node50);
		
		Node node51 = new NonPredicateNode(new BILoad(2, 89));
		path.add(node51);
		
		Node node52 = new NonPredicateNode(new BBipush(100, 90));
		path.add(node52);
		
		Node node53 = new NonPredicateNode(new BIRem(91));
		path.add(node53);
		
		BLabel lable17= new BLabel(new Label());
		PredicateNode node54 = new PredicateNode(new BIFne(lable17, 92));
		node54.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node54);
		
		Node node55 = new NonPredicateNode(new BILoad(2, 93));
		path.add(node55);
		
		Node node56 = new NonPredicateNode(new BSipush(400, 94));
		path.add(node56);
		
		Node node57 = new NonPredicateNode(new BIRem(95));
		path.add(node57);
		
		BLabel lable18= new BLabel(new Label());
		PredicateNode node58 = new PredicateNode(new BIFne(lable18, 96));
		node58.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node58);
		
		Node node59 = new NonPredicateNode(new BBipush(10, 97));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(98));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID14() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(0, 32));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(9, 33));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpeq(lable9, 34));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(0, 35));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BBipush(11, 36));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		PredicateNode node30 = new PredicateNode(new BIFicmpne(lable10, 37));
		node30.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(0, 45));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BBipush(12, 46));
		path.add(node32);
		
		BLabel lable11 = new BLabel(new Label());
		PredicateNode node33 = new PredicateNode(new BIFicmpne(lable11, 47));
		node33.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BILoad(0, 55));
		path.add(node34);
		
		Node node35 = new NonPredicateNode(new BIConst_2(56));
		path.add(node35);
		
		BLabel lable12 = new BLabel(new Label());
		PredicateNode node36 = new PredicateNode(new BIFicmpne(lable12, 57));
		node36.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node36);
		
		Node node37 = new NonPredicateNode(new BILoad(1, 58));
		path.add(node37);
		
		Node node38 = new NonPredicateNode(new BBipush(28, 59));
		path.add(node38);
		
		BLabel lable13 = new BLabel(new Label());
		PredicateNode node39 = new PredicateNode(new BIFicmpge(lable13, 60));
		node39.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node39);
		
		Node node40 = new NonPredicateNode(new BILoad(1, 63));
		path.add(node40);
		
		Node node41 = new NonPredicateNode(new BBipush(28, 64));
		path.add(node41);
		
		BLabel lable14 = new BLabel(new Label());
		PredicateNode node42 = new PredicateNode(new BIFicmpne(lable14, 65));
		node42.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node42);
		
		Node node43 = new NonPredicateNode(new BILoad(1, 82));
		path.add(node43);
		
		Node node44 = new NonPredicateNode(new BBipush(29, 83));
		path.add(node44);
		
		BLabel lable15 = new BLabel(new Label());
		PredicateNode node46 = new PredicateNode(new BIFne(lable15, 84));
		node46.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node46);
		
		Node node47 = new NonPredicateNode(new BILoad(2, 85));
		path.add(node47);
		
		Node node48 = new NonPredicateNode(new BIConst_4(86));
		path.add(node48);
		
		Node node49 = new NonPredicateNode(new BIRem(87));
		path.add(node49);
		
		BLabel lable16= new BLabel(new Label());
		PredicateNode node50 = new PredicateNode(new BIFne(lable16, 88));
		node50.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node50);
		
		Node node51 = new NonPredicateNode(new BILoad(2, 89));
		path.add(node51);
		
		Node node52 = new NonPredicateNode(new BBipush(100, 90));
		path.add(node52);
		
		Node node53 = new NonPredicateNode(new BIRem(91));
		path.add(node53);
		
		BLabel lable17= new BLabel(new Label());
		PredicateNode node54 = new PredicateNode(new BIFne(lable17, 92));
		node54.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node54);
		
		Node node55 = new NonPredicateNode(new BILoad(2, 93));
		path.add(node55);
		
		Node node56 = new NonPredicateNode(new BSipush(400, 94));
		path.add(node56);
		
		Node node57 = new NonPredicateNode(new BIRem(95));
		path.add(node57);
		
		BLabel lable18= new BLabel(new Label());
		PredicateNode node58 = new PredicateNode(new BIFne(lable18, 96));
		node58.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node58);
		
		Node node59 = new NonPredicateNode(new BBipush(11, 99));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(100));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID15() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(0, 32));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(9, 33));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpeq(lable9, 34));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(0, 35));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BBipush(11, 36));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		PredicateNode node30 = new PredicateNode(new BIFicmpne(lable10, 37));
		node30.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(0, 45));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BBipush(12, 46));
		path.add(node32);
		
		BLabel lable11 = new BLabel(new Label());
		PredicateNode node33 = new PredicateNode(new BIFicmpne(lable11, 47));
		node33.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BILoad(0, 55));
		path.add(node34);
		
		Node node35 = new NonPredicateNode(new BIConst_2(56));
		path.add(node35);
		
		BLabel lable12 = new BLabel(new Label());
		PredicateNode node36 = new PredicateNode(new BIFicmpne(lable12, 57));
		node36.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node36);
		
		Node node37 = new NonPredicateNode(new BILoad(1, 58));
		path.add(node37);
		
		Node node38 = new NonPredicateNode(new BBipush(28, 59));
		path.add(node38);
		
		BLabel lable13 = new BLabel(new Label());
		PredicateNode node39 = new PredicateNode(new BIFicmpge(lable13, 60));
		node39.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node39);
		
		Node node40 = new NonPredicateNode(new BILoad(1, 63));
		path.add(node40);
		
		Node node41 = new NonPredicateNode(new BBipush(28, 64));
		path.add(node41);
		
		BLabel lable14 = new BLabel(new Label());
		PredicateNode node42 = new PredicateNode(new BIFicmpne(lable14, 65));
		node42.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node42);
		
		Node node43 = new NonPredicateNode(new BILoad(1, 82));
		path.add(node43);
		
		Node node44 = new NonPredicateNode(new BBipush(29, 83));
		path.add(node44);
		
		BLabel lable15 = new BLabel(new Label());
		PredicateNode node46 = new PredicateNode(new BIFne(lable15, 84));
		node46.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node46);
		
		Node node47 = new NonPredicateNode(new BILoad(2, 85));
		path.add(node47);
		
		Node node48 = new NonPredicateNode(new BIConst_4(86));
		path.add(node48);
		
		Node node49 = new NonPredicateNode(new BIRem(87));
		path.add(node49);
		
		BLabel lable16= new BLabel(new Label());
		PredicateNode node50 = new PredicateNode(new BIFne(lable16, 88));
		node50.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node50);
		
		Node node51 = new NonPredicateNode(new BILoad(2, 89));
		path.add(node51);
		
		Node node52 = new NonPredicateNode(new BBipush(100, 90));
		path.add(node52);
		
		Node node53 = new NonPredicateNode(new BIRem(91));
		path.add(node53);
		
		BLabel lable17= new BLabel(new Label());
		PredicateNode node54 = new PredicateNode(new BIFne(lable17, 92));
		node54.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node54);
		
		Node node59 = new NonPredicateNode(new BBipush(10, 97));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(98));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID16() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(0, 32));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(9, 33));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpeq(lable9, 34));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(0, 35));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BBipush(11, 36));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		PredicateNode node30 = new PredicateNode(new BIFicmpne(lable10, 37));
		node30.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(0, 45));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BBipush(12, 46));
		path.add(node32);
		
		BLabel lable11 = new BLabel(new Label());
		PredicateNode node33 = new PredicateNode(new BIFicmpne(lable11, 47));
		node33.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BILoad(0, 55));
		path.add(node34);
		
		Node node35 = new NonPredicateNode(new BIConst_2(56));
		path.add(node35);
		
		BLabel lable12 = new BLabel(new Label());
		PredicateNode node36 = new PredicateNode(new BIFicmpne(lable12, 57));
		node36.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node36);
		
		Node node37 = new NonPredicateNode(new BILoad(1, 58));
		path.add(node37);
		
		Node node38 = new NonPredicateNode(new BBipush(28, 59));
		path.add(node38);
		
		BLabel lable13 = new BLabel(new Label());
		PredicateNode node39 = new PredicateNode(new BIFicmpge(lable13, 60));
		node39.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node39);
		
		Node node40 = new NonPredicateNode(new BILoad(1, 63));
		path.add(node40);
		
		Node node41 = new NonPredicateNode(new BBipush(28, 64));
		path.add(node41);
		
		BLabel lable14 = new BLabel(new Label());
		PredicateNode node42 = new PredicateNode(new BIFicmpne(lable14, 65));
		node42.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node42);
		
		Node node43 = new NonPredicateNode(new BILoad(1, 82));
		path.add(node43);
		
		Node node44 = new NonPredicateNode(new BBipush(29, 83));
		path.add(node44);
		
		BLabel lable15 = new BLabel(new Label());
		PredicateNode node46 = new PredicateNode(new BIFne(lable15, 84));
		node46.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node46);
		
		Node node47 = new NonPredicateNode(new BILoad(2, 85));
		path.add(node47);
		
		Node node48 = new NonPredicateNode(new BIConst_4(86));
		path.add(node48);
		
		Node node49 = new NonPredicateNode(new BIRem(87));
		path.add(node49);
		
		BLabel lable16= new BLabel(new Label());
		PredicateNode node50 = new PredicateNode(new BIFne(lable16, 88));
		node50.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node50);
		
		Node node51 = new NonPredicateNode(new BILoad(2, 93));
		path.add(node51);
		
		Node node52 = new NonPredicateNode(new BSipush(400, 94));
		path.add(node52);
		
		Node node53 = new NonPredicateNode(new BIRem(95));
		path.add(node53);
		
		BLabel lable17= new BLabel(new Label());
		PredicateNode node54 = new PredicateNode(new BIFne(lable17, 96));
		node54.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node54);
		
		Node node59 = new NonPredicateNode(new BBipush(10, 97));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(98));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID17() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(0, 32));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(9, 33));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpeq(lable9, 34));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(0, 35));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BBipush(11, 36));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		PredicateNode node30 = new PredicateNode(new BIFicmpne(lable10, 37));
		node30.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(0, 45));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BBipush(12, 46));
		path.add(node32);
		
		BLabel lable11 = new BLabel(new Label());
		PredicateNode node33 = new PredicateNode(new BIFicmpne(lable11, 47));
		node33.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BILoad(0, 55));
		path.add(node34);
		
		Node node35 = new NonPredicateNode(new BIConst_2(56));
		path.add(node35);
		
		BLabel lable12 = new BLabel(new Label());
		PredicateNode node36 = new PredicateNode(new BIFicmpne(lable12, 57));
		node36.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node36);
		
		Node node37 = new NonPredicateNode(new BILoad(1, 58));
		path.add(node37);
		
		Node node38 = new NonPredicateNode(new BBipush(28, 59));
		path.add(node38);
		
		BLabel lable13 = new BLabel(new Label());
		PredicateNode node39 = new PredicateNode(new BIFicmpge(lable13, 60));
		node39.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node39);
		
		Node node40 = new NonPredicateNode(new BILoad(1, 63));
		path.add(node40);
		
		Node node41 = new NonPredicateNode(new BBipush(28, 64));
		path.add(node41);
		
		BLabel lable14 = new BLabel(new Label());
		PredicateNode node42 = new PredicateNode(new BIFicmpne(lable14, 65));
		node42.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node42);
		
		Node node43 = new NonPredicateNode(new BILoad(1, 82));
		path.add(node43);
		
		Node node44 = new NonPredicateNode(new BBipush(29, 83));
		path.add(node44);
		
		BLabel lable15 = new BLabel(new Label());
		PredicateNode node46 = new PredicateNode(new BIFne(lable15, 84));
		node46.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node46);
		
		Node node47 = new NonPredicateNode(new BILoad(2, 85));
		path.add(node47);
		
		Node node48 = new NonPredicateNode(new BIConst_4(86));
		path.add(node48);
		
		Node node49 = new NonPredicateNode(new BIRem(87));
		path.add(node49);
		
		BLabel lable16= new BLabel(new Label());
		PredicateNode node50 = new PredicateNode(new BIFne(lable16, 88));
		node50.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node50);
		
		Node node51 = new NonPredicateNode(new BILoad(2, 93));
		path.add(node51);
		
		Node node52 = new NonPredicateNode(new BSipush(400, 94));
		path.add(node52);
		
		Node node53 = new NonPredicateNode(new BIRem(95));
		path.add(node53);
		
		BLabel lable17= new BLabel(new Label());
		PredicateNode node54 = new PredicateNode(new BIFne(lable17, 96));
		node54.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node54);
		
		Node node59 = new NonPredicateNode(new BBipush(11, 99));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(100));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID18() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(0, 32));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(9, 33));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpeq(lable9, 34));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(0, 35));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BBipush(11, 36));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		PredicateNode node30 = new PredicateNode(new BIFicmpne(lable10, 37));
		node30.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(0, 45));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BBipush(12, 46));
		path.add(node32);
		
		BLabel lable11 = new BLabel(new Label());
		PredicateNode node33 = new PredicateNode(new BIFicmpne(lable11, 47));
		node33.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BILoad(0, 55));
		path.add(node34);
		
		Node node35 = new NonPredicateNode(new BIConst_2(56));
		path.add(node35);
		
		BLabel lable12 = new BLabel(new Label());
		PredicateNode node36 = new PredicateNode(new BIFicmpne(lable12, 57));
		node36.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node36);
		
		Node node37 = new NonPredicateNode(new BILoad(1, 58));
		path.add(node37);
		
		Node node38 = new NonPredicateNode(new BBipush(28, 59));
		path.add(node38);
		
		BLabel lable13 = new BLabel(new Label());
		PredicateNode node39 = new PredicateNode(new BIFicmpge(lable13, 60));
		node39.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node39);
		
		Node node40 = new NonPredicateNode(new BILoad(1, 63));
		path.add(node40);
		
		Node node41 = new NonPredicateNode(new BBipush(28, 64));
		path.add(node41);
		
		BLabel lable14 = new BLabel(new Label());
		PredicateNode node42 = new PredicateNode(new BIFicmpne(lable14, 65));
		node42.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node42);
		
		Node node43 = new NonPredicateNode(new BILoad(1, 82));
		path.add(node43);
		
		Node node44 = new NonPredicateNode(new BBipush(29, 83));
		path.add(node44);
		
		BLabel lable15 = new BLabel(new Label());
		PredicateNode node46 = new PredicateNode(new BIFne(lable15, 84));
		node46.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node46);

		Node node59 = new NonPredicateNode(new BBipush(12, 101));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(102));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID19() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(0, 32));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(9, 33));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpeq(lable9, 34));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(0, 35));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BBipush(11, 36));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		PredicateNode node30 = new PredicateNode(new BIFicmpne(lable10, 37));
		node30.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node30);
		
		Node node31 = new NonPredicateNode(new BILoad(0, 45));
		path.add(node31);
		
		Node node32 = new NonPredicateNode(new BBipush(12, 46));
		path.add(node32);
		
		BLabel lable11 = new BLabel(new Label());
		PredicateNode node33 = new PredicateNode(new BIFicmpne(lable11, 47));
		node33.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node33);
		
		Node node34 = new NonPredicateNode(new BILoad(0, 55));
		path.add(node34);
		
		Node node35 = new NonPredicateNode(new BIConst_2(56));
		path.add(node35);
		
		BLabel lable12 = new BLabel(new Label());
		PredicateNode node36 = new PredicateNode(new BIFicmpne(lable12, 57));
		node36.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node36);

		Node node59 = new NonPredicateNode(new BBipush(13, 103));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(104));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID20() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(0, 32));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(9, 33));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpeq(lable9, 34));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(1, 38));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BBipush(30, 39));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		PredicateNode node30 = new PredicateNode(new BIFicmpge(lable10, 40));
		node30.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node30);
		

		Node node59 = new NonPredicateNode(new BIConst_3(41));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(42));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID21() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(0, 32));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(9, 33));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpeq(lable9, 34));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node27);
		
		Node node28 = new NonPredicateNode(new BILoad(1, 38));
		path.add(node28);
		
		Node node29 = new NonPredicateNode(new BBipush(30, 39));
		path.add(node29);
		
		BLabel lable10 = new BLabel(new Label());
		PredicateNode node30 = new PredicateNode(new BIFicmpge(lable10, 40));
		node30.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node30);
		

		Node node59 = new NonPredicateNode(new BIConst_4(43));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(44));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID22() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(1, 38));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(30, 39));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpge(lable9, 40));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node27);		

		Node node59 = new NonPredicateNode(new BIConst_3(41));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(42));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID23() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(0, 29));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(6, 30));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpeq(lable8, 31));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node24);
		
		Node node25 = new NonPredicateNode(new BILoad(1, 38));
		path.add(node25);
		
		Node node26 = new NonPredicateNode(new BBipush(30, 39));
		path.add(node26);
		
		BLabel lable9 = new BLabel(new Label());
		PredicateNode node27 = new PredicateNode(new BIFicmpge(lable9, 40));
		node27.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node27);		

		Node node59 = new NonPredicateNode(new BIConst_4(43));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(44));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID24() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(1, 38));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(30, 39));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpge(lable8, 40));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node24);	

		Node node59 = new NonPredicateNode(new BIConst_3(41));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(42));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID25() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(0, 16));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(10, 17));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpne(lable6, 18));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);
		
		Node node19 = new NonPredicateNode(new BILoad(0, 26));
		path.add(node19);
		
		Node node20 = new NonPredicateNode(new BIConst_4(27));
		path.add(node20);
		
		BLabel lable7 = new BLabel(new Label());
		PredicateNode node21 = new PredicateNode(new BIFicmpeq(lable7, 28));
		node21.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node21);
		
		Node node22 = new NonPredicateNode(new BILoad(1, 38));
		path.add(node22);
		
		Node node23 = new NonPredicateNode(new BBipush(30, 39));
		path.add(node23);
		
		BLabel lable8 = new BLabel(new Label());
		PredicateNode node24 = new PredicateNode(new BIFicmpge(lable8, 40));
		node24.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node24);	

		Node node59 = new NonPredicateNode(new BIConst_4(43));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(44));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID26() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(31, 20));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpge(lable6, 21));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node18);

		Node node59 = new NonPredicateNode(new BIConst_1(22));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(23));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID27() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(0, 13));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(8, 14));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpeq(lable5, 15));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);

		Node node16 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node16);
		
		Node node17 = new NonPredicateNode(new BBipush(31, 20));
		path.add(node17);

		BLabel lable6 = new BLabel(new Label());
		PredicateNode node18 = new PredicateNode(new BIFicmpge(lable6, 21));
		node18.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node18);

		Node node59 = new NonPredicateNode(new BIConst_2(24));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(25));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID28() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(31, 20));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpge(lable5, 21));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node59 = new NonPredicateNode(new BIConst_1(22));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(23));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID29() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(0, 10));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(7, 11));
		path.add(node11);

		BLabel lable4 = new BLabel(new Label());
		PredicateNode node12 = new PredicateNode(new BIFicmpeq(lable4, 12));
		node12.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node12);

		Node node13 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node13);

		Node node14 = new NonPredicateNode(new BBipush(31, 20));
		path.add(node14);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpge(lable5, 21));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);

		Node node59 = new NonPredicateNode(new BIConst_2(24));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(25));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID30() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(31, 20));
		path.add(node11);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpge(lable5, 21));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node59 = new NonPredicateNode(new BIConst_1(22));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(23));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID31() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node6);

		Node node7 = new NonPredicateNode(new BILoad(0, 7));
		path.add(node7);

		Node node8 = new NonPredicateNode(new BIConst_5(8));
		path.add(node8);
		
		BLabel lable3 = new BLabel(new Label());
		PredicateNode node9 = new PredicateNode(new BIFicmpeq(lable3, 9));
		node9.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node9);

		Node node10 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(31, 20));
		path.add(node11);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpge(lable5, 21));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);

		Node node59 = new NonPredicateNode(new BIConst_2(24));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(25));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID32() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);

		Node node10 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(31, 20));
		path.add(node11);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpge(lable5, 21));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node59 = new NonPredicateNode(new BIConst_1(22));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(23));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID33() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node3);

		Node node4 = new NonPredicateNode(new BILoad(0, 4));
		path.add(node4);

		Node node5 = new NonPredicateNode(new BIConst_3(5));
		path.add(node5);
		
		BLabel lable2 = new BLabel(new Label());
		PredicateNode node6 = new PredicateNode(new BIFicmpeq(lable2, 6));
		node6.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node6);

		Node node10 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(31, 20));
		path.add(node11);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpge(lable5, 21));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);

		Node node59 = new NonPredicateNode(new BIConst_2(24));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(25));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID34() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node10 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(31, 20));
		path.add(node11);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpge(lable5, 21));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_FALSE);
		path.add(node15);

		Node node59 = new NonPredicateNode(new BIConst_1(22));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(23));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
	
	public static TestPath createPathID35() {
		TestPath path = new TestPath();
		path.setPathId(1);

		Node node1 = new NonPredicateNode(new BILoad(0, 1));
		path.add(node1);

		Node node2 = new NonPredicateNode(new BIConst_1(2));
		path.add(node2);

		BLabel lable = new BLabel(new Label());
		PredicateNode node3 = new PredicateNode(new BIFicmpeq(lable, 3));
		node3.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node3);

		Node node10 = new NonPredicateNode(new BILoad(1, 19));
		path.add(node10);

		Node node11 = new NonPredicateNode(new BBipush(31, 20));
		path.add(node11);

		BLabel lable5 = new BLabel(new Label());
		PredicateNode node15 = new PredicateNode(new BIFicmpge(lable5, 21));
		node15.setExpectedPredicateResult(ConstantsUtility.EXPECTED_TRUE);
		path.add(node15);

		Node node59 = new NonPredicateNode(new BIConst_2(24));
		path.add(node59);
		
		Node node60 = new NonPredicateNode(new BIReturn(23));
		path.add(node60);
		
		// get Method instructions
		BClass myclass = BClassGenerator.getBClass("NextDate.class");
		BMethod m = myclass.getMethod("nextDate");

		// set method in the path
		path.setbMethod(m);

		return path;
	}
}
