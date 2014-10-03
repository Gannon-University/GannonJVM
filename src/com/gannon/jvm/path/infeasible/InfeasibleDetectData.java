package com.gannon.jvm.path.infeasible;

/**
 * @author Frank
 * 
 */
public class InfeasibleDetectData {
	private Trend trend = Trend.UNSPECIFIED;
	private boolean isUsed = false; // the value has been used

	public InfeasibleDetectData() {
		super();
	}

	public InfeasibleDetectData(Trend trend) {
		super();
		this.trend = trend;
	}

	public Trend getTrend() {
		return trend;
	}

	public void setTrend(Trend trend) {
		this.trend = trend;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	/**
	 * @param another
	 *            infeasible detect data
	 * @return
	 */
	public boolean isConflict(InfeasibleDetectData data) {
		boolean isConflict = decreaseIncreaseConflict(data) || increaseDecreaseConflict(data) || changeConflict(data);
		// System.out.println("isConfclit="+ isConflict);
		return isConflict;
	}

	private boolean changeConflict(InfeasibleDetectData data) {
		return (trend == Trend.CHANGE && data.getTrend() == Trend.NO_CHANGE) || (trend == Trend.NO_CHANGE && data.getTrend() == Trend.CHANGE);
	}

	private boolean decreaseIncreaseConflict(InfeasibleDetectData data) {
		return trend == Trend.DECREASE && data.getTrend() == Trend.INCREASE;
	}

	private boolean increaseDecreaseConflict(InfeasibleDetectData data) {
		return trend == Trend.INCREASE && data.getTrend() == Trend.DECREASE;
	}

	@Override
	public String toString() {
		return "[T=" + trend + ", U=" + isUsed + "]";
	}
}
