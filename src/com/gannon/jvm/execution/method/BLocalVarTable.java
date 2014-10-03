package com.gannon.jvm.execution.method;

import java.util.ArrayList;
import java.util.List;

import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.input.Input;

/*The array of local variables, also called the local variable table, 
 contains the parameters of the method and is also used to hold the values of the local variables.
 The parameters are stored first, beginning at index 0. If the frame is for a constructor or an instance method,
 the reference is stored at location 0. Then location 1 contains the first formal parameter, location 2 the second, and so on. 
 For a static method, the first formal method parameter is stored in location 0, the second in location 1, and so on.
 The class need to be modified.
 http://www.ibm.com/developerworks/ibm/library/it-haggar_bytecode/
 */
public class BLocalVarTable {
	List<BLocalVariable> localVars = new ArrayList<BLocalVariable>();

	public BLocalVarTable() {
		super();
	}
	
	public void updateVarTableWithInput(Input input){
		for(BLocalVariable para:input.getParas()){
			setValueAtIndex(para.index,para.getValue());
		}
	}
	
	//clear the table and add input only
	public void addInput(Input input){
		localVars.clear();
		for(BLocalVariable para:input.getParas()){
			localVars.add(para);
		}
	}

	public BLocalVarTable(ArrayList<BLocalVariable> localVar) {
		super();
		this.localVars = localVar;
	}

	public List<BLocalVariable> getLocalVars() {
		return localVars;
	}

	public void setLocalVar(ArrayList<BLocalVariable> localVar) {
		this.localVars = localVar;
	}

	public boolean add(BLocalVariable v) {
		boolean success=false;
		if (!isContainsVarIndex(v)) {
			localVars.add(v);
			success=true;
		}
		return success;
	}

	public boolean isContainsVarIndex(BLocalVariable v) {
		for (BLocalVariable var : localVars) {
			if (var != null && var.index == v.index) {
				return true;
			}
		}
		return false; 
	}

	public BLocalVariable getLocalVariableByIndex(int index) {
		for (BLocalVariable var : localVars) {
			if (var != null && var.index == index) {
				return var;
			}
		}
		return null;
	}

	public Integer size() {
		return localVars.size();
	}
	
	public BLocalVariable get(int position) {
		return localVars.get(position);
	}

	public boolean setValueAtIndex(int index, Object element) {
		boolean success=false;
		BLocalVariable var = getLocalVariableByIndex(index);
		if (var != null) {
			var.setValue(element);
			success=true;
		} else {
			System.err.println("set Value at " + index
					+ " in local variable table failed!");
		}
		return success;

	}

	public Object getValueAtIndex(int index) {
		BLocalVariable var = getLocalVariableByIndex(index);
		if (var != null) {
			return var.getValue();
		} else {
			System.err.println("set Value at " + index
					+ " in local variable table failed!");
			return null;
		}
	}

	public void clear() {
		localVars.clear();
	}

	@Override
	public String toString() {
		return "BLocalVarTable [localVars=" + localVars + "]";
	}
}
