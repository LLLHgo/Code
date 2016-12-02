package businesslogic.orderbl;

import java.util.Date;

import businesslogicservice.orderblservice.OrderCheckTimeBLService;
import vo.orderVO.OrderVO;

public class OrderCheck implements OrderCheckTimeBLService{

	@Override
	public boolean checkTimeOperateAbnormal(OrderVO order, Date date) {
		// TODO Auto-generated method stub
		return false;
	}

}
