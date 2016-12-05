package businesslogic.strategybl;

import java.util.Calendar;

import businesslogic.hoteinfobl.Hotelinfo;
import po.StrategyPO.StrategyPO;

public abstract  class Strategy {
	public boolean isavailable(Calendar startTime,Calendar endTime){
		Calendar c=Calendar.getInstance();
		if(c.compareTo(startTime)>0&&c.compareTo(endTime)<0){
			return false;
		}else {
			return true;
		}
	}


}
