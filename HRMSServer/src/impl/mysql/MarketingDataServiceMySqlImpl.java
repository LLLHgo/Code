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


	public boolean addLevel(LevelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	
	public List<LevelPO> findAllLevel() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean deleteLevel(LevelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	
	public MarketingPO getInfo(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean updateAndAdd(MarketingPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean delete(MarketingPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
