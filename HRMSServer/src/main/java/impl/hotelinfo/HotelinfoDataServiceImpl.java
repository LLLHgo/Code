package impl.hotelinfo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataservice.hotelinfodataservice.HotelinfoDataService;
import impl.mysql.HotelinfoDataServiceMySqlImpl;
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
		return mysql.getRoominfoList(hotelID);
	}

	public HotelinfoPO findhotelinfo(String hotelID) throws RemoteException {
		return mysql.findhotelinfo(hotelID);
	}

	public boolean updatehotelinfo(HotelinfoPO po) throws RemoteException {
		return mysql.updatehotelinfo(po);
	}

	public boolean updateroominfo(RoominfoPO po) throws RemoteException {
		return mysql.updateroominfo(po);
	}

	public boolean delete(RoominfoPO po) throws RemoteException {
		return mysql.delete(po);
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public String[] getArea() {
		return txt.getArea();
	}


	public boolean addArea(String area) {
		return txt.addArea(area);
	}


	public String[] getRoomType() {
		return txt.getRoomType();
	}


	public boolean addRoomType(String type) {
		return txt.addRoomType(type);
	}

	
}
