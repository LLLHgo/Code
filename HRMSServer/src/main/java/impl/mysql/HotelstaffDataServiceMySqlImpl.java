/**
 * data层的数据库实现
 */
package impl.mysql;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dataservice.hotelstaffdataservice.HotelstaffDataService;
import initial.DataBaseInit;
import po.HotelstaffPO;

/**
* hotelstaff的data层实现
* @author liuyu
*负责将数据持久化保存入数据库，从数据库获取持久化信息
*/
public class HotelstaffDataServiceMySqlImpl extends UnicastRemoteObject implements HotelstaffDataService{

	private static final long serialVersionUID = 1L;

	Connection conn;

	public HotelstaffDataServiceMySqlImpl() throws RemoteException {
		super();
		init();
	}


	public void init() throws RemoteException {
		conn = DataBaseInit.getConnection();
	}

//	public void init(){
//		String driver = "com.mysql.jdbc.Driver";
//		try {
//			Class.forName(driver);
//			System.out.println("驱动加载成功");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		String url= "jdbc:mysql://127.0.0.1:3306/hrms";
//		String user = "root";
//		String password = "DNc38XPbZnD8fDQU";
//		try {
//			conn = DriverManager.getConnection(url, user, password);
//			System.out.println("连接成功");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}


	//增
	public boolean insert(HotelstaffPO po) throws RemoteException {
		try {
//			Statement st = conn.createStatement();
//			String sql = "select count(*) from hotelstaff";
//			ResultSet myRS = st.executeQuery(sql);
//			myRS.next();
//			int count = myRS.getInt(1);

			String sql = "insert into hotelstaff values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			String hotelID = po.getHotelID();
			String passwordfromUI = po.getPassword();
			String tel = po.getTel();
			ps.setString(1, hotelID);
			String passwordtoDataBase="";
			for(int i=0;i<passwordfromUI.length();i++){
				char c = (char) (passwordfromUI.charAt(i)+1);
				passwordtoDataBase +=c;
			}
			ps.setString(2, passwordtoDataBase);
			ps.setString(3, tel);
			int result = ps.executeUpdate();
			if(result>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	//酒店工作人员改
	public boolean hotelstaffUpdate(HotelstaffPO po) throws RemoteException {
		try {
			String sql = "update hotelstaff set password=? where hotelID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			String passwordfromUI = po.getPassword();
			String passwordtoDataBase="";
			for(int i=0;i<passwordfromUI.length();i++){
				char c = (char) (passwordfromUI.charAt(i)+1);
				passwordtoDataBase +=c;
			}
			ps.setString(1, passwordtoDataBase);
			ps.setString(2, po.getHotelID());
			int result = ps.executeUpdate();
			if(result>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//网站营销人员改
	public boolean sitemanagerUpdate(HotelstaffPO po) throws RemoteException {
		try {
			String sql = "update hotelstaff set password=? , tel=? where hotelID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			String passwordfromUI = po.getPassword();
			String passwordtoDataBase="";
			for(int i=0;i<passwordfromUI.length();i++){
				char c = (char) (passwordfromUI.charAt(i)+1);
				passwordtoDataBase +=c;
			}
			ps.setString(1, passwordtoDataBase);
			ps.setString(2, po.getTel());
			ps.setString(3, po.getHotelID());
			int result = ps.executeUpdate();
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
		HotelstaffPO po = null;
		try {
			Statement st = conn.createStatement();
			String sql = "select * from hotelstaff";
			ResultSet myRS = st.executeQuery(sql);
			while(myRS.next()){
				if(hotelStaffID.equals((String)myRS.getObject("hotelID"))){
					po = new HotelstaffPO();
					po.setHotelID(hotelStaffID);
					String passwordfromDataBase=(String)myRS.getObject("password");
					String passwordtoUI = "";
					for(int i=0;i<passwordfromDataBase.length();i++){
						char c = (char) (passwordfromDataBase.charAt(i)-1);
						passwordtoUI += c;
					}
					po.setPassword(passwordtoUI);
					po.setTel((String)myRS.getObject("tel"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}


	public void finish() throws RemoteException {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public String gethotelID() throws RemoteException {
		String lastID=null;
		try {
			Statement st = conn.createStatement();
			String sql = "select * from hotelstaff";
			ResultSet myRS = st.executeQuery(sql);
			while(myRS.next()){
				lastID = myRS.getString("hotelID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lastID;
	}

}
