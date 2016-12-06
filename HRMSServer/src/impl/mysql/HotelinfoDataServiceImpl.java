package impl.mysql;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataservice.hotelinfodataservice.HotelinfoDataService;
import impl.txt.HotelinfoDataServiceTxtImpl;
import po.HotelinfoPO;
import po.RoominfoPO;

public  class HotelinfoDataServiceImpl extends UnicastRemoteObject implements HotelinfoDataService{
	
	private static final long serialVersionUID = 1L;
	HotelinfoDataServiceMySqlImpl mysql = new HotelinfoDataServiceMySqlImpl();
	HotelinfoDataServiceTxtImpl txt = new HotelinfoDataServiceTxtImpl();

	public HotelinfoDataServiceImpl() throws RemoteException {
		super();
	}

	
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public List<RoominfoPO> getRoominfoList(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public HotelinfoPO findhotelinfo(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updatehotelinfo(HotelinfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateroominfo(RoominfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(RoominfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
}
