package po.StrategyPO;

import java.util.Calendar;

import Enum.HotelStrategy;

public class HotelSpecialdayPO extends HotelStrategyPO{

	public HotelSpecialdayPO(String name, Calendar startTime, Calendar endTime, HotelStrategy hotelStrategyType,
			String hotelID, double discount) {
		super(name, startTime, endTime, hotelStrategyType, hotelID, discount);

	}

}
