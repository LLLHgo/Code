package po.StrategyPO;

import java.util.ArrayList;
import java.util.Calendar;

import Enum.HotelStrategy;
import Enum.VIPType;

public class HotelCompanyPO extends HotelStrategyPO{

	private VIPType viptype;
	public HotelCompanyPO(String name, Calendar startTime, Calendar endTime,String hotelID,
			double discount,ArrayList<String> companys) {
		super(name, startTime, endTime,HotelStrategy.COMPANY,hotelID,discount);
		this.setViptype(VIPType.ENTERPRISEVIP);

	}

	public VIPType getViptype() {
		return viptype;
	}
	public void setViptype(VIPType viptype) {
		this.viptype = viptype;
	}


}
