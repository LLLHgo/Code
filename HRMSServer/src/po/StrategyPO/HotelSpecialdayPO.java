package po.StrategyPO;

import java.util.Calendar;

import Enum.HotelStrategy;

public class HotelSpecialdayPO extends HotelStrategyPO{

	public HotelSpecialdayPO(String name, Calendar startTime, Calendar endTime,
			String hotelID, double discount) {
		super(name, startTime, endTime, HotelStrategy.SPECIALDAY, hotelID, discount);

	}

}
