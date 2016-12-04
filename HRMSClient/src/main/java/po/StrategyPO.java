package po;

import java.util.Calendar;

import Enum.StrategyMaker;

public abstract class StrategyPO {
	public  String name;
	public Calendar startTime;
	public Calendar endTime;
	public StrategyMaker makerType;

	public double calDiscount() {
		return 1.0;
	}

}


















