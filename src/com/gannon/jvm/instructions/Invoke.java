package com.gannon.jvm.instructions;


public abstract class Invoke extends BInstruction{
	protected String owner;// package?
	protected String name;// method name
	protected String desc;//

	public Invoke(String owner, String name, String desc, int lineNumber) {
		super(lineNumber);
		this.owner = owner;
		this.name = name;
		this.desc = desc;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCalleeName() {
		return name;
	}

	public void setCalleeName(String calleeName) {
		this.name = calleeName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return super.toString() +"  [owner=" + owner + ", name=" + name + ", desc=" + desc + "]";
	}
	
	
}
