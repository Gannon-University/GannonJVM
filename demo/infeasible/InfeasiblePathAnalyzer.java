package com.gannon.infeasible;

import java.util.List;

import com.gannon.jvm.progam.path.TestPath;

public class InfeasiblePathAnalyzer {
	private TestPath path;

	public InfeasiblePathAnalyzer(TestPath path) {
		super();
		this.path = path;
	}

	private PRG generatePRG() {

		return null;

	}

	public boolean isFeasiblePath() {
		PRG prg = generatePRG();
		List<PRG> prgs = prg.getSubPRGs();
		for (PRG e : prgs)
			if (e.isEmpty()  && e.isContr()) {
				return true;
			}
		return false;
	}
}
