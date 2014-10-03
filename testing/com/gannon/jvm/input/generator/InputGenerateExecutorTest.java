package com.gannon.jvm.input.generator;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.gannon.asm.classgenerator.BClassGenerator;
import com.gannon.asm.components.BClass;
import com.gannon.asm.components.BMethod;
import com.gannon.jvm.data.input.Input;
import com.gannon.jvm.execution.method.BLocalVarTable;
import com.gannon.jvm.progam.path.TestPath;
import com.gannon.jvm.utilities.TrianglePathBuilderUtility;

public class InputGenerateExecutorTest {
	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};

	@Test
	public void testPathID1UsingInputObj() {
		BClass myclass = BClassGenerator.getBClass("Triangle.class");
		BMethod m = myclass.getMethod("triangleType");
		
		TestPath testPath = TrianglePathBuilderUtility.createPathID1();
		InputGenerationFrame pathFrame = new InputGenerationFrame(myclass, m, testPath, 5); 

		InputGenerateExecutor executor= new InputGenerateExecutor(pathFrame);  
		Set<Input> result = executor.execute();
		
		for(Input input: result){
			System.out.println(input);
		}
	}
}
