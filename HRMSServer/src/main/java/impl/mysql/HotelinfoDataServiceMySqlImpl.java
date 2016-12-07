package impl.mysql;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataservice.hotelinfodataservice.HotelinfoDataService;
import impl.hotelinfo.HotelinfoDataServiceImpl;
import initial.DataBaseInit;
import po.HotelinfoPO;
import po.HotelstaffPO;
import po.RoominfoPO;

public class HotelinfoDataServiceMySqlImpl implements HotelinfoDataService{

	private static final long serialVersionUID = 1L;
	Connection conn;
	
	
	public HotelinfoDataServiceMySqlImpl() throws RemoteException {
		super();
		init();
	}

	public void init() throws RemoteException {
		conn = DataBaseInit.getConnection();
	}

	public List<RoominfoPO> getRoominfoList(String hotelID) throws RemoteException {
		hotelID = hotelID.substring(1);
		int id = Integer.parseInt(hotelID);
		RoominfoPO po = null;
		ArrayList<RoominfoPO> list = new ArrayList<RoominfoPO>();
		try {
			Statement st = conn.createStatement();
			String sql = "select * from roominfo";
			ResultSet myRS = st.executeQuery(sql);
			while(myRS.next()){
				if(id==(Integer)myRS.getObject("hotelID")){
					po = new RoominfoPO();
					//TODO
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
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

	public String[] getArea() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addArea(String area) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public String[] getRoomType() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addRoomType(String type) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
