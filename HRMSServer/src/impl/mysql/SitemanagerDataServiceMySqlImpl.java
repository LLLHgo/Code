package impl.mysql;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dataHelper.DataFactoryMySqlImpl;
import dataservice.sitemanagerdataservice.SitemanagerDataService;
import initial.DataBaseInit;
import po.SitemanagerPO;

public class SitemanagerDataServiceMySqlImpl extends UnicastRemoteObject implements SitemanagerDataService{
	
	private static final long serialVersionUID = 1L;
	//DataFactoryMySqlImpl mysql = new DataFactoryMySqlImpl();;
	SitemanagerPO sitemanagerPO;
	String sql;
	ResultSet resultSet;
	
	String id;
	String tel;
	String password;
	
	Connection conn;
	Statement stmt;

	public SitemanagerDataServiceMySqlImpl() throws RemoteException{
		super();
		this.conn = DataBaseInit.getConnection();
	}
	

    public SitemanagerPO getAccount() throws RemoteException {
		// TODO Auto-generated method stub
    	
    	sql="SELECT id, tel, password FROM sitemanager_account";
    	try {
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(sql);
			if(resultSet!=null){
				id  = resultSet.getString("id");
				tel = resultSet.getString("tel");
				password = resultSet.getString("password");
				sitemanagerPO=new SitemanagerPO(id,tel,password);
	    		return sitemanagerPO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    		return null;
	}


	public boolean SitemanagerAccountUpdate(SitemanagerPO sitemanagerPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
