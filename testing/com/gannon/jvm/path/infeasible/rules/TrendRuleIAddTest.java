package com.gannon.jvm.path.infeasible.rules;


import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.objectweb.asm.Label;

import com.gannon.asm.components.BLabel;
import com.gannon.asm.components.BLocalVariable;
import com.gannon.jvm.data.dependency.BinNode;
import com.gannon.jvm.data.dependency.Dependencies;
import com.gannon.jvm.data.dependency.Dependency;
import com.gannon.jvm.instructions.BIAdd;
import com.gannon.jvm.instructions.BIFicmpeq;
import com.gannon.jvm.path.infeasible.InfeasibleDetectData;
import com.gannon.jvm.path.infeasible.Trend;

public class TrendRuleIAddTest {

	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};

	// _______ i4 () increase
	// __________/ \
	// _________i2() i3 ()
	//
	//
	@Test
	public void testAddIncrease() {
		BLocalVariable localVariable4 = new BLocalVariable(null, null, null, null, null, 1);
		BLocalVariable localVariable2 = new BLocalVariable(null, null, null, null, null, 1);
		localVariable2.setParamter(true);
		BLocalVariable localVariable3 = new BLocalVariable(null, null, null, null, null, 1);
		localVariable3.setParamter(true);
		BinNode i4 = new BinNode(4, localVariable4);
		BLabel lable = new BLabel(new Label());
		Dependency d4 = new Dependency(i4, new BIAdd(5));
		BinNode i2 = new BinNode(2, localVariable2);
		BinNode i3 = new BinNode(3, localVariable3);
		
		d4.insertToLeft(i2);
		d4.insertToRight(i3);

		// add four dependencies to Dependencies
		Dependencies dependencies = new Dependencies();
		dependencies.add(d4);

		// init, add node increases 10
		Map<BinNode, InfeasibleDetectData> detectDataCollectMap=new HashMap();
		TrendRuleIAdd rule = new TrendRuleIAdd(Trend.INCREASE, dependencies, i2, i3, detectDataCollectMap);
		rule.updating();
		
		assertEquals(Trend.INCREASE,detectDataCollectMap.get(i2).getTrend());
		assertEquals(Trend.INCREASE,detectDataCollectMap.get(i3).getTrend());
	}
	
	// _______ i4 () decrease
	// __________/ \
	// _________i2() i3 ()
	//
	//
	@Test
	public void testAddDecrease() {
		BLocalVariable localVariable4 = new BLocalVariable(null, null, null, null, null, 1);
		BLocalVariable localVariable2 = new BLocalVariable(null, null, null, null, null, 1);
		localVariable2.setParamter(true);
		BLocalVariable localVariable3 = new BLocalVariable(null, null, null, null, null, 1);
		localVariable3.setParamter(true);
		BinNode i4 = new BinNode(4, localVariable4);
		BLabel lable = new BLabel(new Label());
		Dependency d4 = new Dependency(i4, new BIAdd(5));
		BinNode i2 = new BinNode(2, localVariable2);
		BinNode i3 = new BinNode(3, localVariable3);

		// add four dependencies to Dependencies
		Dependencies dependencies = new Dependencies();
		dependencies.add(d4);

		// init, add node increases 10
		Map<BinNode, InfeasibleDetectData> detectDataCollectMap=new HashMap();
		TrendRuleIAdd rule = new TrendRuleIAdd(Trend.DECREASE, dependencies, i2, i3,detectDataCollectMap);
		rule.updating();
		
		assertEquals(Trend.DECREASE,detectDataCollectMap.get(i2).getTrend());
		assertEquals(Trend.DECREASE,detectDataCollectMap.get(i3).getTrend());
	}
	
	// _______ i4 () decrease
	// __________/ \
	// _________i2() i3 ()
	//
	//
	@Test
	public void testAddNoChange() {
		BLocalVariable localVariable4 = new BLocalVariable(null, null, null, null, null, 1);
		BLocalVariable localVariable2 = new BLocalVariable(null, null, null, null, null, 1);
		localVariable2.setParamter(true);
		BLocalVariable localVariable3 = new BLocalVariable(null, null, null, null, null, 1);
		localVariable3.setParamter(true);
		BinNode i4 = new BinNode(4, localVariable4);
		BLabel lable = new BLabel(new Label());
		Dependency d4 = new Dependency(i4, new BIAdd(5));
		BinNode i2 = new BinNode(2, localVariable2);
		BinNode i3 = new BinNode(3, localVariable3);

		// add four dependencies to Dependencies
		Dependencies dependencies = new Dependencies();
		dependencies.add(d4);

		// init, add node increases 10
		Map<BinNode, InfeasibleDetectData> detectDataCollectMap=new HashMap();
		TrendRuleIAdd rule = new TrendRuleIAdd(Trend.NO_CHANGE, dependencies, i2, i3,detectDataCollectMap);
		rule.updating();
		
		assertEquals(Trend.NO_CHANGE,detectDataCollectMap.get(i2).getTrend());
		assertEquals(Trend.NO_CHANGE,detectDataCollectMap.get(i2).getTrend());
	}

}
