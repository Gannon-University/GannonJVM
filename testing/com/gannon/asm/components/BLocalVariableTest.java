package com.gannon.asm.components;

import static org.junit.Assert.*;

import org.junit.Test;

public class BLocalVariableTest {

	@Test
	public void testClone() {
		BLocalVariable original = new BLocalVariable(null, null, null, null, null, 1, 1);
		BLocalVariable cloned=null;
		try {
			cloned=(BLocalVariable) original.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Verify JDK's rules
		 
        //Must be true and objects must have different memory addresses
        assertTrue(original != cloned);
 
        //As we are returning same class; so it should be true
        assertTrue(original.getClass() == cloned.getClass());
 
        //Default equals method checks for refernces so it should be false. If we want to make it true,
        //we need to override equals method in Employee class.
        assertTrue(original.equals(cloned));
	}
	
	@Test
	public void testClone2() {
		Integer originalValue=new Integer(1);
		BLocalVariable original = new BLocalVariable(null, null, null, null, null, 1, originalValue);
		BLocalVariable cloned=null;
		try {
			cloned=(BLocalVariable) original.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Verify JDK's rules
		 
        //Must be true and objects must have different memory addresses
        assertTrue(original != cloned);
 
        //As we are returning same class; so it should be true
        assertTrue(original.getClass() == cloned.getClass());
 
        //Default equals method checks for refernces so it should be false. If we want to make it true,
        //we need to override equals method in Employee class.
        assertTrue(original.equals(cloned));
        
        assertEquals(1, original.getValue());
        
        cloned.setClonedValue(original.getValue());
        assertTrue(original.getValue().equals(cloned.getValue()));
        assertFalse(original.getValue()==cloned.getValue());
        
        cloned.setClonedValue(2);
        assertFalse(original.getValue().equals(cloned.getValue()));
	}

}
