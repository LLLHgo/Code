package data.marketingdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataservice.marketingdataservice.MarketingDataService;
import po.LevelPO;
import po.MarketingPO;

public class MarketingData extends UnicastRemoteObject implements MarketingDataService{

	public MarketingData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addLevel(LevelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LevelPO> findAllLevel() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteLevel(LevelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MarketingPO getInfo(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAndAdd(MarketingPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(MarketingPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
