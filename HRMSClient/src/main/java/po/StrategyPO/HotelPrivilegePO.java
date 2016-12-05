package po.StrategyPO;

import java.util.Calendar;

import Enum.HotelStrategy;
import Enum.VIPType;

public class HotelPrivilegePO extends HotelStrategyPO{

	private VIPType viptype;
	public HotelPrivilegePO(String name, Calendar startTime, Calendar endTime,
			HotelStrategy hotelStrategyType,String hotelID,double discount,VIPType viptype) {
		super(name, startTime, endTime,hotelStrategyType,hotelID,discount);
		this.setViptype(viptype);

	}

	public VIPType getViptype() {
		return viptype;
	}
	public void setViptype(VIPType viptype) {
		this.viptype = viptype;
	}


}
