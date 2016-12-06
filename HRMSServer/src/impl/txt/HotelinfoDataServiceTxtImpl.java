package impl.txt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataservice.hotelinfodataservice.HotelinfoDataService;
import po.HotelinfoPO;
import po.RoominfoPO;

public class HotelinfoDataServiceTxtImpl{

	public HotelinfoDataServiceTxtImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public String[] getArea() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addArea(String area) {
		// TODO Auto-generated method stub
		return false;
	}

	public String[] getRoomType() {
		// TODO Auto-generated method stub
		return null;
	}
	

	public boolean addRoomType(String type) {
		// TODO Auto-generated method stub
		return false;
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
