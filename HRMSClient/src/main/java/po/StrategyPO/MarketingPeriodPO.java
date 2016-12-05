package po.StrategyPO;

import java.util.Calendar;

import Enum.MarketingStrategy;

public class MarketingPeriodPO extends MarketingStrategyPO{

	private double discount;
	public MarketingPeriodPO(String name, Calendar startTime, Calendar endTime,double discount) {
		super(name, startTime, endTime,MarketingStrategy.PERIOD);
		this.setDiscount(discount);
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
