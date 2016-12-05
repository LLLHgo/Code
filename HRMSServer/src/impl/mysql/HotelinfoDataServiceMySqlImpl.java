package impl.mysql;

import java.rmi.RemoteException;
import java.util.List;

import dataservice.hotelinfodataservice.HotelinfoDataService;
import po.HotelinfoPO;
import po.RoominfoPO;

public class HotelinfoDataServiceMySqlImpl implements HotelinfoDataService{

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
