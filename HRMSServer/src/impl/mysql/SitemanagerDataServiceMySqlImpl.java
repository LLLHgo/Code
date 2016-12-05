package impl.mysql;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dataHelper.DataFactoryMySqlImpl;
import dataservice.sitemanagerdataservice.SitemanagerDataService;
import po.SitemanagerPO;

public class SitemanagerDataServiceMySqlImpl extends UnicastRemoteObject implements SitemanagerDataService{

	private static final long serialVersionUID = 1L;
	private DataFactoryMySqlImpl mysql=new DataFactoryMySqlImpl();
	private final String tableName="";
	protected Connection conn=null;
	protected PreparedStatement preState;
	protected String query;
	protected ResultSet result;

	public SitemanagerDataServiceMySqlImpl() throws RemoteException{
		super();
		mysql=new DataFactoryMySqlImpl();
		//this.conn = DataBaseInit.getConnection();
		mysql.getDoResult(preState);
	}
	

    public SitemanagerPO getAccount() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean SitemanagerAccountUpdate(SitemanagerPO sitemanagerPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
