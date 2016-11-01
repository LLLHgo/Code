package data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import Enum.OrderType;
import Enum.UserType;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;

public class OrderData extends UnicastRemoteObject implements OrderDataService{

	public OrderData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(OrderPO order) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(OrderPO order) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancel(String orderId) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderPO findSpecificUserOrder(UserType userType, String orderId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderPO> findUserOrderList(String userId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderPO> findClientTypeOrder(OrderType orderType, String clientId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderPO> findAbnormalOrderList(Date date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkTime(String orderId) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
