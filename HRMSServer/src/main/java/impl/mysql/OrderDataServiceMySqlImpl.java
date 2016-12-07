package impl.mysql;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Enum.OrderType;
import Enum.UserType;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;

public class OrderDataServiceMySqlImpl extends UnicastRemoteObject implements OrderDataService{

	private static final long serialVersionUID = 1L;

	public OrderDataServiceMySqlImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int lookIdValid() throws RemoteException {
		// TODO Auto-generated method stub
		
		return 0;
	}

	public boolean add(OrderPO order) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean save(OrderPO order) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean cancel(String orderId) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public OrderPO findSpecificUserOrder(String orderId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderPO> findSpecificDayClientOrderList(String clientId, String date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderPO> findUserOrderList(String userId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderPO> findClientTypeOrderList(OrderType orderType, String clientId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderPO> findHotelTypeOrderList(OrderType orderType, String hotelId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderPO> findClientInHotelAllOrderList(String clientId, String hotelId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderPO> findAbnormalOrderList(String date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void checkTimeOperateAbnormal(String orderId) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


}
