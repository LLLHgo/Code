package data.hotelinfodata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataservice.hotelinfodataservice.HotelinfoDataService;
import po.HotelinfoPO;
import po.RoominfoPO;

public class HotelinfoData extends UnicastRemoteObject implements HotelinfoDataService{

	public HotelinfoData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RoominfoPO> getRoominfoList(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelinfoPO findhotelinfo(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatehotelinfo(HotelinfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateroominfo(RoominfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(RoominfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
