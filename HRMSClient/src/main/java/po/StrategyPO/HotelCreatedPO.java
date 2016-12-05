package po.StrategyPO;

import java.util.Calendar;
import java.util.List;

import Enum.HotelStrategy;
import Enum.VIPType;

public class HotelCreatedPO extends HotelStrategyPO{

	private List<VIPType> viptypes;
	private int minRooms;
	private double minSum;
	private int levels;

	public HotelCreatedPO(String name, Calendar startTime, Calendar endTime, HotelStrategy hotelStrategyType,
			String hotelID, double discount,List<VIPType> viptypes,int minRooms,double minSum,int level) {
		super(name, startTime, endTime, hotelStrategyType, hotelID, discount);
		this.setViptypes(viptypes);
		this.setMinRooms(minRooms);
		this.setMinSum(minSum);
		this.setLevels(level);
	}
	public int getMinRooms() {
		return minRooms;
	}
	public void setMinRooms(int minRooms) {
		this.minRooms = minRooms;
	}
	public double getMinSum() {
		return minSum;
	}
	public void setMinSum(double minSum) {
		this.minSum = minSum;
	}
	public List<VIPType> getViptypes() {
		return viptypes;
	}
	public void setViptypes(List<VIPType> viptypes) {
		this.viptypes = viptypes;
	}
	public int getLevels() {
		return levels;
	}
	public void setLevels(int levels) {
		this.levels = levels;
	}


}
