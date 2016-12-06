package po.StrategyPO;

import java.util.Calendar;

import Enum.HotelStrategy;
import Enum.StrategyMaker;

public class HotelStrategyPO extends StrategyPO{
	private HotelStrategy hotelStrategy;
	private String hotelID;
	private double discount;
	public HotelStrategyPO(String name, Calendar startTime, Calendar endTime,HotelStrategy hotelStrategyType,String hotelID,double discount) {
		super(name, startTime, endTime, StrategyMaker.HOTEL);
		this.hotelStrategy=hotelStrategyType;
		this.hotelID=hotelID;
		this.discount=discount;

	}
	public HotelStrategy getHotelStrategy() {
		return hotelStrategy;
	}
	public void setHotelStrategy(HotelStrategy hotelStrategy) {
		this.hotelStrategy = hotelStrategy;
	}
	public String getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
