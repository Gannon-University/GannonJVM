package com.gannon.jvm.data.input;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BLocalVariable;
import com.gannon.asm.components.BMethod;

/* One input for a method under the testing, it may contains multiple parameters,
 * e.g., for method triangleType(a,b,c), a, b, and c are the parameters
 * (a, b, c) is one input
 * */
public class Input implements Cloneable {
	private final int id;
	private BClass c;
	private static BMethod m;
	private List<BLocalVariable> parameters = new ArrayList<BLocalVariable>();

	public Input(int id, BClass c, BMethod m) {
		super();
		this.id = id;
		this.c = c;
		this.m = m;
	}

	public void addParameter(BLocalVariable para) {
		para.setParamter(true);
		parameters.add(para);
	}

	public List<BLocalVariable> getParas() {
		return parameters;
	}

	public void setParas(List<BLocalVariable> paras) {
		for (BLocalVariable v : paras) {
			v.setParamter(true);
		}
		this.parameters = paras;
	}

	public Input generateRandomInt() {
		// parameter index starts from 1
		for (int i = 1; i <= m.getNumberOfParameter(); i++) {
			this.addParameter(BLocalVariable.getRandomParameterInt(i));
		}
		return this;
	}

	public Input generate3RandomInt(int id, int numberOfParameters) {
		// parameter index starts from 1
		for (int i = 1; i <= numberOfParameters; i++) {
			this.addParameter(BLocalVariable.getRandomParameterInt(i));
		}
		return this;
	}

	public Input generateFixed3RandomInt(int id, int numberOfParameters) {
		// parameter index starts from 1
		BLocalVariable p1 = new BLocalVariable(null, "I", null, null, null, 1, 7);
		BLocalVariable p2 = new BLocalVariable(null, "I", null, null, null, 2, 8);
		BLocalVariable p3 = new BLocalVariable(null, "I", null, null, null, 3, 9);
		this.addParameter(p1);
		this.addParameter(p2);
		this.addParameter(p3);
		return this;
	}

	public List<BLocalVariable> getParamters() {
		return parameters;
	}

	public Input updateParameterValue(int parameterIndex, Object value) {
		for (BLocalVariable p : parameters) {
			int index = p.index;
			if (index == parameterIndex) {
				p.setValue(value);
			}
		}
		return this;
	}

	public BLocalVariable getParameterByIndex(int parameterIndex) {
		for (BLocalVariable p : parameters) {
			if (p.index == parameterIndex) {
				return p;
			}
		}
		return null;
	}

	public Object clone() throws CloneNotSupportedException {
		Input inputClone = (Input) super.clone();
		// make the shallow copy of the object of type Department
		// inputClone.getParamters().clear();
		List<BLocalVariable> cloned = new ArrayList<BLocalVariable>();
		for (int i = 0; i < parameters.size(); i++) {
			BLocalVariable var = (BLocalVariable) parameters.get(i).clone();
			cloned.add(var);
		}
		inputClone.setParas(new ArrayList<BLocalVariable>());
		inputClone.getParamters().addAll(cloned);
		return (Input) inputClone;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Input [ parameters=" + parameters + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parameters == null) ? 0 : parameters.hashCode());
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
		Input other = (Input) obj;
		if (parameters == null) {
			if (other.parameters != null)
				return false;
		} else {
			List<BLocalVariable> otherParameters = ((Input) obj).getParamters();
			for (int i = 0; i < parameters.size(); i++) {
				Object value = parameters.get(i).getValue();
				Object anotherValue= otherParameters.get(i).getValue();
				if (!value.equals(anotherValue)) {
					return false;
				}

			}
			return true;
		}
		return true;
	}

	public String toNiceString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Input [id=" + id + ", (");
		for (BLocalVariable p : parameters) {
			sb.append(p);
		}
		sb.append(")]\n");
		return sb.toString();
	}

}
