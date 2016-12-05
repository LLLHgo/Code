package data.sitemanagerdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.sitemanagerdataservice.SitemanagerDataService;
import po.SitemanagerPO;

public class SitemanagerDataServiceMySqlImpl extends UnicastRemoteObject implements SitemanagerDataService{

	private static final long serialVersionUID = 1L;


	public SitemanagerDataServiceMySqlImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
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
