package data.sitemanagerdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.sitemanagerdataservice.SitemanagerDataService;
import po.SitemanagerPO;

public class SiteManagerData extends UnicastRemoteObject implements SitemanagerDataService{

	public SiteManagerData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public SitemanagerPO getAccount() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean SitemanagerAccountUpdate(SitemanagerPO sitemanagerPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
