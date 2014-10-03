package com.gannon.jvm.path.infeasible.rules;

import static org.junit.Assert.*;

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
import com.gannon.jvm.instructions.BIFicmpgt;
import com.gannon.jvm.path.infeasible.InfeasibleDetectData;
import com.gannon.jvm.path.infeasible.Trend;

public class TrendRuleIFcmpgtTest {

	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		protected void starting(Description description) {
			System.out.println("Starting test: " + description.getMethodName());
		}
	};

	// _______ i4 () > true
	// __________/ \
	// _________i2() i3 ()
	//
	//
	@Test
	public void testCmpgtTrue() {
		BLocalVariable localVariable4 = new BLocalVariable(null, null, null, null, null, 1);
		BLocalVariable localVariable2 = new BLocalVariable(null, null, null, null, null, 1);
		localVariable2.setParamter(true);
		BLocalVariable localVariable3 = new BLocalVariable(null, null, null, null, null, 1);
		localVariable3.setParamter(true);
		
		BinNode i4 = new BinNode(4, localVariable4);
		BLabel lable = new BLabel(new Label());
		Dependency d4 = new Dependency(i4, new BIFicmpgt( lable,2));
		BinNode i2 = new BinNode(2, localVariable2);
		BinNode i3 = new BinNode(3, localVariable3);
		d4.insertToLeft(i2);
		d4.insertToRight(i3);

		Dependencies dependencies = new Dependencies();
		dependencies.add(d4);

		boolean expectedPredicate=true;
		Map<BinNode, InfeasibleDetectData> detectDataCollectMap=new HashMap();
		TrendRuleIFcmpgt rule = new TrendRuleIFcmpgt(expectedPredicate, dependencies, i2, i3, detectDataCollectMap);
		rule.updating();
		
		assertEquals(Trend.INCREASE,detectDataCollectMap.get(i2).getTrend());
		assertEquals(Trend.DECREASE,detectDataCollectMap.get(i3).getTrend());
	}
	
	// _______ i4 () > false
	// __________/ \
	// _________i2() i3 ()
	//
	//
	@Test
	public void testCmpgtFalse() {
		BLocalVariable localVariable4 = new BLocalVariable(null, null, null, null, null, 1);
		BLocalVariable localVariable2 = new BLocalVariable(null, null, null, null, null, 1);
		localVariable2.setParamter(true);
		BLocalVariable localVariable3 = new BLocalVariable(null, null, null, null, null, 1);
		localVariable3.setParamter(true);
		
		BinNode i4 = new BinNode(4, localVariable4);
		BLabel lable = new BLabel(new Label());
		Dependency d4 = new Dependency(i4, new BIFicmpgt( lable,2));
		BinNode i2 = new BinNode(2, localVariable2);
		BinNode i3 = new BinNode(3, localVariable3);
		d4.insertToLeft(i2);
		d4.insertToRight(i3);

		Dependencies dependencies = new Dependencies();
		dependencies.add(d4);

		boolean expectedPredicate=false;
		
		Map<BinNode, InfeasibleDetectData> detectDataCollectMap=new HashMap();
		TrendRuleIFcmpgt rule = new TrendRuleIFcmpgt(expectedPredicate, dependencies, i2, i3, detectDataCollectMap);
		rule.updating();
		
		assertEquals(Trend.DECREASE,detectDataCollectMap.get(i2).getTrend());
		assertEquals(Trend.INCREASE,detectDataCollectMap.get(i3).getTrend());
	}
}
