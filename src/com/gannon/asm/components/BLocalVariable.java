package com.gannon.asm.components;

import java.util.Random;

import org.objectweb.asm.Type;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LocalVariableNode;
import org.objectweb.asm.tree.analysis.BasicValue;

import com.gannon.jvm.utilities.ConstantsUtility;

/**
 * This class is a part of data structure created to organize the information
 * about the class being visited. This Class will have the information of method
 * local variables.
 * 
 * 
 * @param name
 *            Name of the Local Variable
 * @param desc
 *            Type of the variable, e.g., int, string
 * @param signature
 *            Signature of the variable
 * @param index
 *            Index of the local variable,
 * 
 *            e.g., triangleType(int a,int b,int c)
 * 
 * **/
public class BLocalVariable extends LocalVariableNode implements Cloneable {
	private Object value = new Object(); // value of this local variable
	private boolean isParamter = false;

	public BLocalVariable(String name, String desc, String signature, LabelNode start, LabelNode end, int index) {
		super(name, desc, signature, start, end, index);
		//set default value if this is a integer
		if(desc!=null && desc.equals(Type.INT_TYPE.getDescriptor())){
			value=0;
		}
	}

	public BLocalVariable(String name, String desc, String signature, LabelNode start, LabelNode end, int index, Object value) {
		super(name, desc, signature, start, end, index);
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public void setClonedValue(Object value) {
		if (value instanceof Integer) {
			int temp=((Integer) value).intValue();
			this.value = new Integer(temp);
		}
	}

	public boolean isParamter() {
		return isParamter;
	}

	public void setParamter(boolean isParamter) {
		this.isParamter = isParamter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BLocalVariable other = (BLocalVariable) obj;
		if (index != other.index)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BLocalVariable [name=" + name + ", desc=" + super.desc + ", signature=" + signature + ", index=" + index + ",value="+value+"]";
	}

	public static BLocalVariable getRandomParameterInt(int index){
	    Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(ConstantsUtility.RANGE_MAX)+1;
		BLocalVariable randomParameter= new BLocalVariable(null, "I", null, null, null, index, randomInt);
		randomParameter.setParamter(true);
		return randomParameter;
		
	}
	
	public Object clone() throws CloneNotSupportedException {
		BLocalVariable clone = (BLocalVariable) super.clone();
		if (clone.getValue() instanceof Integer) {
			clone.setClonedValue(clone.getValue());
		}
		return (BLocalVariable) clone;

	}
}
