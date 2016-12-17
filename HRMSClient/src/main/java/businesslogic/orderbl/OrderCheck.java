package businesslogic.orderbl;


import java.rmi.RemoteException;

import businesslogicservice.orderblservice.OrderCheckTimeBLService;
import dataservice.orderdataservice.OrderDataService;
import rmi.RemoteHelper;
import vo.orderVO.OrderVO;

public class OrderCheck implements OrderCheckTimeBLService{

	OrderDataService orderDateService;
	RemoteHelper remote;
	boolean result=false;
	
	public OrderCheck(){
		remote=RemoteHelper.getInstance();
		orderDateService=remote.getOrderDataService();
	}
	@Override
	public boolean checkTimeOperateAbnormal() {
		try {
			result=orderDateService.checkTimeOperateAbnormal();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

}
