package com.gannon.jvm.instructions;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.objectweb.asm.Label;

import com.gannon.asm.components.BBlock;
import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BLabel;
import com.gannon.asm.components.BLocalVariable;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.BinPredicateNode;
import com.gannon.jvm.data.dependency.Dependency;
import com.gannon.jvm.data.dependency.DependencyFrame;
import com.gannon.jvm.execution.method.BFrame;
import com.gannon.jvm.execution.method.BLocalVarTable;
import com.gannon.jvm.progam.path.TestPath;

public class BIFicmpleTest {
	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};

	@Test
	public void testExecuteLessAndEqualPositive() {

		// Create a Class to hold the method
		BClass bClass = new BClass("TestClass");

		// / Create Method with blocks and instructions
		BMethod method = new BMethod();
		ArrayList<BBlock> blockList = new ArrayList<BBlock>();

		method.setName("<init>");
		BLabel label1 = new BLabel(new Label(), 1);
		label1.setGoToLineNumber(8);// block will start from line number 8, So
									// when
		// if_icmpeq executes and
		// based on the label value(newLabel1) it will
		// jump to this label
		// and it should update the PC to 8.
		BBlock block1 = new BBlock(label1);
		ArrayList<BInstruction> Instr1 = new ArrayList<BInstruction>();
		Instr1.add(new BALoad(0, 0));
		Instr1.add(new BInvokeSpecial("java/lang/Object", "init", "()V", 1));
		block1.setInstructions(Instr1);
		blockList.add(block1);

		BLabel label2 = new BLabel(new Label(), 2);
		BBlock block2 = new BBlock(label2);
		ArrayList<BInstruction> Instr2 = new ArrayList<BInstruction>();
		Instr2.add(new BIFicmpge(label1, 2));// set Label for jump
		Instr2.add(new BIConst_1(3));
		Instr2.add(new BIConst_5(4));
		block2.setInstructions(Instr2);
		blockList.add(block2);

		BLabel label3 = new BLabel(new Label(), 3);
		label3.setGoToLineNumber(5);
		BBlock block3 = new BBlock(label3); // block start from line number 8,
											// So
											// when if_icmpeq executes and
											// based on the label
											// value(newLabel1) it will jump to
											// this label
											// and it should update the PC to 8.
		ArrayList<BInstruction> Instr3 = new ArrayList<BInstruction>();
		Instr3.add(new BALoad(0, 5));
		Instr3.add(new BIConst_0(6));
		Instr3.add(new BPutStatic("com/gannon/ASM/BytecodeReader/Hello", "j", "I", 7));
		block3.setInstructions(Instr3);
		blockList.add(block3);

		method.setBlockList(blockList);

		Stack<BLocalVariable> operandStack = new Stack<BLocalVariable>();
		Integer five=new Integer(5);
		BLocalVariable var5= new BLocalVariable("","I",null,null, null,1,five );
		Integer six=new Integer(6);
		BLocalVariable var6= new BLocalVariable("","I",null,null, null,2,six );
		operandStack.add(var5); 
		operandStack.add(var6); 
		
		BLocalVarTable varTable = new BLocalVarTable();

		ArrayList<BMethod> methods = new ArrayList<BMethod>();
		methods.add(method);
		bClass.setMethods(methods);

		BFrame activeFrame = new BFrame(bClass, method);
		activeFrame.setTableAndStackForTesting(varTable, operandStack);

		BIFicmple ifLessNequal = new BIFicmple(label1, 2);
		// Before calling the execute method, operand stack will have 5 at 1th
		// position and 6 at second position.
		// Expectation is, BIFicmpge will update program counter to 5.

		ifLessNequal.execute(activeFrame);

		Integer resultedPC = activeFrame.getLineNumber();
		assertEquals((Integer) 8, resultedPC);
	}

	
	@Test
	public void testExecuteEqualPositive() {

		// Create a Class to hold the method
		BClass bClass = new BClass("TestClass");

		// / Create Method with blocks and instructions
		BMethod method = new BMethod();
		ArrayList<BBlock> blockList = new ArrayList<BBlock>();

		method.setName("<init>");
		BLabel label1 = new BLabel(new Label(), 1);
		label1.setGoToLineNumber(8);// block will start from line number 8, So
									// when
		// if_icmpeq executes and
		// based on the label value(newLabel1) it will
		// jump to this label
		// and it should update the PC to 8.
		BBlock block1 = new BBlock(label1);
		ArrayList<BInstruction> Instr1 = new ArrayList<BInstruction>();
		Instr1.add(new BALoad(0, 0));
		Instr1.add(new BInvokeSpecial("java/lang/Object", "init", "()V", 1));
		block1.setInstructions(Instr1);
		blockList.add(block1);

		BLabel label2 = new BLabel(new Label(), 2);
		BBlock block2 = new BBlock(label2);
		ArrayList<BInstruction> Instr2 = new ArrayList<BInstruction>();
		Instr2.add(new BIFicmpge(label1, 2));// set Label for jump
		Instr2.add(new BIConst_1(3));
		Instr2.add(new BIConst_5(4));
		block2.setInstructions(Instr2);
		blockList.add(block2);

		BLabel label3 = new BLabel(new Label(), 3);
		label3.setGoToLineNumber(5);
		BBlock block3 = new BBlock(label3); // block start from line number 8,
											// So
											// when if_icmpeq executes and
											// based on the label
											// value(newLabel1) it will jump to
											// this label
											// and it should update the PC to 8.
		ArrayList<BInstruction> Instr3 = new ArrayList<BInstruction>();
		Instr3.add(new BALoad(0, 5));
		Instr3.add(new BIConst_0(6));
		Instr3.add(new BPutStatic("com/gannon/ASM/BytecodeReader/Hello", "j", "I", 7));
		block3.setInstructions(Instr3);
		blockList.add(block3);

		method.setBlockList(blockList);

		Stack<BLocalVariable> operandStack = new Stack<BLocalVariable>();
		Integer five=new Integer(5);
		BLocalVariable var5= new BLocalVariable("","I",null,null, null,1,five );
		Integer five2=new Integer(5);
		BLocalVariable var6= new BLocalVariable("","I",null,null, null,2,five2 );
		operandStack.add(var5); 
		operandStack.add(var6); 
		
		BLocalVarTable varTable = new BLocalVarTable();

		ArrayList<BMethod> methods = new ArrayList<BMethod>();
		methods.add(method);
		bClass.setMethods(methods);

		BFrame activeFrame = new BFrame(bClass, method);
		activeFrame.setTableAndStackForTesting(varTable, operandStack);

		BIFicmple ifLessNequal = new BIFicmple(label1, 2);
		// Before calling the execute method, operand stack will have 5 at 1th
		// position and 6 at second position.
		// Expectation is, BIFicmpge will update program counter to 5.

		ifLessNequal.execute(activeFrame);

		Integer resultedPC = activeFrame.getLineNumber();
		assertEquals((Integer) 8, resultedPC);
	}

	@Test
	public void testExecuteLessAndEqualNegative() {
		Label newLabel1 = new Label();
		Label newLabel2 = new Label();
		Label newLabel3 = new Label();

		// Create a Class to hold the method
		BClass bClass = new BClass("TestClass");

		// / Create Method with blocks and instructions
		BMethod method = new BMethod();
		ArrayList<BBlock> blockList = new ArrayList<BBlock>();

		method.setName("<init>");
		BLabel label1 = new BLabel(newLabel1, 1);
		label1.setGoToLineNumber(8);// block will start from line number 8, So
									// when
		// if_icmpeq executes and
		// based on the label value(newLabel1) it will
		// jump to this label
		// and it should update the PC to 8.
		BBlock block1 = new BBlock(label1);
		ArrayList<BInstruction> Instr1 = new ArrayList<BInstruction>();
		Instr1.add(new BALoad(0, 0));
		Instr1.add(new BInvokeSpecial("java/lang/Object", "init", "()V", 1));
		block1.setInstructions(Instr1);
		blockList.add(block1);

		BLabel label2 = new BLabel(newLabel2, 2);
		BBlock block2 = new BBlock(label2);
		ArrayList<BInstruction> Instr2 = new ArrayList<BInstruction>();
		Instr2.add(new BIFicmpge(new BLabel(newLabel3), 2));// set Label for
															// jump
		Instr2.add(new BIConst_1(3));
		Instr2.add(new BIConst_5(4));
		block2.setInstructions(Instr2);
		blockList.add(block2);

		BLabel label3 = new BLabel(newLabel3, 3);
		label3.setGoToLineNumber(5);
		BBlock block3 = new BBlock(label3); // block start from line number 8,
											// So
											// when if_icmpeq executes and
											// based on the label
											// value(newLabel1) it will jump to
											// this label
											// and it should update the PC to 8.
		ArrayList<BInstruction> Instr3 = new ArrayList<BInstruction>();
		Instr3.add(new BALoad(0, 5));
		Instr3.add(new BIConst_0(6));
		Instr3.add(new BPutStatic("com/gannon/ASM/BytecodeReader/Hello", "j", "I", 7));
		block3.setInstructions(Instr3);
		blockList.add(block3);

		method.setBlockList(blockList);

		Stack<BLocalVariable> operandStack = new Stack<BLocalVariable>();
		Integer two=new Integer(2);
		BLocalVariable var2= new BLocalVariable("","I",null,null, null,1,two );
		Integer five=new Integer(5);
		BLocalVariable var5= new BLocalVariable("","I",null,null, null,2,five );
		operandStack.push(var5); 
		operandStack.push(var2); 

		BLocalVarTable varTable = new BLocalVarTable();

		ArrayList<BMethod> methods = new ArrayList<BMethod>();
		methods.add(method);
		bClass.setMethods(methods);

		BFrame activeFrame = new BFrame(bClass, method);
		activeFrame.setTableAndStackForTesting(varTable, operandStack);
		activeFrame.setLineNumber(2); 

		BIFicmple iflessNequal = new BIFicmple(new BLabel(newLabel3), 2);
		// Before calling the execute method, operand stack will have 5 at 0th
		// position and 6 at 1st position. Program Counter is set at 2.
		// Expectation is, BIFicmpge will update program counter to 3.

		iflessNequal.execute(activeFrame);

		Integer resultedPC = activeFrame.getLineNumber();
		assertEquals((Integer) 3, resultedPC);
	}

	@Test
	public void testExecuteNotLessThanNEqual() {
		Label label1 = new Label();
		Label label2 = new Label();
		Label label3 = new Label();

		Stack<BLocalVariable> operandStack = new Stack<BLocalVariable>();
		Integer three=new Integer(3);
		BLocalVariable var3= new BLocalVariable("","I",null,null, null,1,three );
		Integer six=new Integer(6);
		BLocalVariable var6= new BLocalVariable("","I",null,null, null,2,six );
		operandStack.push(var6); 
		operandStack.push(var3); 

		BLocalVarTable varTable = new BLocalVarTable();


		BFrame activeFrame = new BFrame(null, null);
		activeFrame.setTableAndStackForTesting(varTable, operandStack);
		activeFrame.setLineNumber(5); 	
		
		
		BIFicmple ifLessNequal = new BIFicmple(new BLabel(label1), 5);
		// activeFrame.setLabelMap(labelMapping);
		// Before calling the execute method, operand stack will have 5 at 0th
		// position and 6 at 1st position. Program counter is set to 5
		// Expectation is, BIFicmpge will update program counter to 6.

		ifLessNequal.execute(activeFrame);

		Integer resultedPC = activeFrame.getLineNumber();
		assertEquals((Integer) 6, resultedPC);
	}

	@Test
	public void testGetOpcode() {
		Label label = new Label();
		BIFicmple instance = new BIFicmple(new BLabel(label), 0);
		int expResult = 164;
		int result = instance.getOpcode();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetOpcodeCommand() {
		Label label = new Label();
		BIFicmpge instance = new BIFicmpge(new BLabel(label), 0);
		String expResult = "if_icmpge";
		String result = instance.getOpCodeCommand();
		assertEquals(expResult, result);
	}

	
}
