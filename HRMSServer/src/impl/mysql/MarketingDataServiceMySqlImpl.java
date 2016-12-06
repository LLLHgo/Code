package impl.mysql;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataservice.marketingdataservice.MarketingDataService;
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
		System.out.println(ID+"   "+password);
		return true;
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
