package po.StrategyPO;

import java.util.Calendar;

import Enum.HotelStrategy;

public class HotelOverThreeRoomsPO extends HotelStrategyPO{
	private int minRooms;
	public HotelOverThreeRoomsPO(String name, Calendar startTime, Calendar endTime,
			String hotelID, double discount,int minRooms) {
		super(name, startTime, endTime, HotelStrategy.OVERTHREEROOMS, hotelID, discount);
		this.setMinRooms(minRooms);
	}
	public int getMinRooms() {
		return minRooms;
	}
	public void setMinRooms(int minRooms) {
		this.minRooms = minRooms;
	}



}
