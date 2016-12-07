package impl.mysql;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dataservice.marketingdataservice.MarketingDataService;
import initial.DataBaseInit;
import po.LevelPO;
import po.MarketingPO;

public class MarketingDataServiceMySqlImpl extends UnicastRemoteObject implements MarketingDataService{

	private static final long serialVersionUID = 1L;

	public MarketingDataServiceMySqlImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<LevelPO> findAllLevel() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public MarketingPO getInfo(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkAccount(String ID, String password) throws RemoteException {
		Connection conn=DataBaseInit.getConnection();
		Statement stmt;
		boolean res = false;
		try{
			stmt=conn.createStatement();
			String sql;
			sql = "SELECT * FROM MarketingProfile WHERE MarketingID='"+ID+"'";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				// 展开结果集数据库
				String passwordInDataBase  = rs.getString("password");
				if(passwordInDataBase.equals(password))
					res=true;
			}
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
		}
		return res;
	}


	public boolean updateLevel(List<LevelPO> pos) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean MarketingAccountUpdate(MarketingPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean MarketingAccountAdd(MarketingPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean MarketingAccountDelete(MarketingPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
