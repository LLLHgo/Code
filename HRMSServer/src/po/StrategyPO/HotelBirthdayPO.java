package po.StrategyPO;

import java.util.Calendar;

import Enum.HotelStrategy;
import Enum.VIPType;

public class HotelBirthdayPO extends HotelStrategyPO{

	private VIPType viptype;
	public HotelBirthdayPO(String name, Calendar startTime, Calendar endTime,
			String hotelID,double discount) {
		super(name, startTime, endTime,HotelStrategy.BIRTHDAY,hotelID,discount);
		this.setViptype(VIPType.ORDINARYVIP);

	}

	public VIPType getViptype() {
		return viptype;
	}
	public void setViptype(VIPType viptype) {
		this.viptype = viptype;
	}


}
