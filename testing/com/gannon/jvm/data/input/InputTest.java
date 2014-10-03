package com.gannon.jvm.data.input;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.input.Input;

public class InputTest {
	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};
	
	@Test
	public void testClone() {
		BLocalVariable v1 = new BLocalVariable(null, null, null, null, null, 1, 1);
		BLocalVariable v2 = new BLocalVariable(null, null, null, null, null, 2, 2);
		Input original=new Input(1,null,null);
		original.addParameter(v1);
		original.addParameter(v2);
		
		
		Input cloned=null;
		try {
			cloned=(Input)original.clone();
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
        //we need to override equals method in Input class.
        assertEquals(1, original.getParameterByIndex(1).getValue()); 
        assertEquals(1, cloned.getParameterByIndex(1).getValue()); 
        assertFalse(original.getParameterByIndex(1).getValue()==cloned.getParameterByIndex(1).getValue());
        
	}

}
