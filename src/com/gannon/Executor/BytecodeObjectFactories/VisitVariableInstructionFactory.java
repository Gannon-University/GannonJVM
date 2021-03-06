package com.gannon.Executor.BytecodeObjectFactories;

import com.gannon.jvm.instructions.BALoad;
import com.gannon.jvm.instructions.BAStore;
import com.gannon.jvm.instructions.BArrayLength;
import com.gannon.jvm.instructions.BIALoad;
import com.gannon.jvm.instructions.BILoad;
import com.gannon.jvm.instructions.BIStore;
import com.gannon.jvm.instructions.BInstruction;
import com.gannon.jvm.utilities.OpcodeUtility;


//operation to variables
public class VisitVariableInstructionFactory{
	BInstruction instr;
    public BInstruction createInst(int opCode,int operand1, int linNumber){
    	//System.out.println("VisitVariableInstructionFactory");
        if(OpcodeUtility.getOpCodeCommand(opCode).equals("iload")){
        	//System.out.println("In VisitVariableInstructionFactory factory ILoad "+ operand1);
            instr= new BILoad(operand1, linNumber);
        }
        else if(OpcodeUtility.getOpCodeCommand(opCode).equals("istore")){
        	//System.out.println("In VisitVariableInstructionFactory factory IStore "+ operand1);
            instr= new BIStore(operand1, linNumber);
        }
        else if(OpcodeUtility.getOpCodeCommand(opCode).equals("astore")){
        	//System.out.println("In VisitVariableInstructionFactory factory astore "+ operand1);
            instr= new BAStore(operand1, linNumber);
        }
        else if(OpcodeUtility.getOpCodeCommand(opCode).equals("aload")){
        	//System.out.println("In VisitVariableInstructionFactory factory aload "+ operand1);
            instr= new BALoad(operand1, linNumber);
        }
        else if(OpcodeUtility.getOpCodeCommand(opCode).equals("aload")){
        	//System.out.println("In VisitVariableInstructionFactory factory aload "+ operand1);
            instr= new BArrayLength(operand1, linNumber);
        }
        else if(OpcodeUtility.getOpCodeCommand(opCode).equals("iaload")){
        	//System.out.println("In VisitVariableInstructionFactory factory aload "+ operand1);
            instr= new BIALoad(operand1, linNumber);
        }
        else if(OpcodeUtility.getOpCodeCommand(opCode).equals("arraylength")){
        	//System.out.println("In VisitVariableInstructionFactory factory aload "+ operand1);
            instr= new BArrayLength(operand1, linNumber);//BIALoad(operand1, linNumber);
        }
        
        
        
        //temp code for testing purpose
        if (instr == null)
        	System.out.println("instr null");
        return instr;
    }
}
