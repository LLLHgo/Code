package impl.mysql;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import dataservice.hotelstaffdataservice.HotelstaffDataService;
import initial.DataBaseInit;
import po.HotelstaffPO;

public class HotelstaffDataServiceMySqlImpl extends UnicastRemoteObject implements HotelstaffDataService{

	private static final long serialVersionUID = 1L;

	Connection conn;
	
	public HotelstaffDataServiceMySqlImpl() throws RemoteException {
		super();
		init();
	}

	
//	public void init() throws RemoteException {
//		conn = DataBaseInit.getConnection();
//	}

	public void init(){
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			System.out.println("驱动加载成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url= "jdbc:mysql://127.0.0.1:3306/test_xampp";
		String user = "root";
		String password = "DNc38XPbZnD8fDQU";
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("连接成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	

	public boolean insert(HotelstaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean update(HotelstaffPO po) throws RemoteException {
		String hotelStaffID = po.getHotelID().substring(1);
		int id = Integer.parseInt(hotelStaffID);
		try {
			String sql = "update hotelstaff set password=? where hotelID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, po.getPassword());
			ps.setInt(2, id);
			int result = ps.executeUpdate();
			System.out.println(result);
			if(result>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//查
	public HotelstaffPO find(String hotelStaffID) {
		hotelStaffID = hotelStaffID.substring(1);
		int id = Integer.parseInt(hotelStaffID);
		HotelstaffPO po = null;
		try {
			Statement st = conn.createStatement();
			String sql = "select * from hotelstaff";
			ResultSet myRS = st.executeQuery(sql);
			while(myRS.next()){
				if(id==(Integer)myRS.getObject("hotelID")){
					po = new HotelstaffPO();
					po.setHotelID(hotelStaffID);
					po.setPassword((String)myRS.getObject("password"));
					po.setTel((String)myRS.getObject("tel"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}


	public boolean checkAccount(HotelstaffPO po) throws RemoteException {
		int id = Integer.parseInt(po.getHotelID().substring(1));
		String password = po.getPassword();
		try {
			Statement st = conn.createStatement();
			String sql = "select * from hotelstaff";
			ResultSet myRS = st.executeQuery(sql);
			while(myRS.next()){
				if(id==(Integer)myRS.getObject("hotelID")&&password.equals(myRS.getObject("password"))){
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}



}
