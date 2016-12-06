package impl.mysql;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataservice.strategydataservice.StrategyDataService;
import po.StrategyPO.HotelStrategyPO;
import po.StrategyPO.MarketingStrategyPO;
import po.StrategyPO.StrategyPO;

public class StrategyDataServiceMySqlImpl extends UnicastRemoteObject implements StrategyDataService{
	private static final long serialVersionUID = 1L;

	public StrategyDataServiceMySqlImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean addMarketingStrategy(MarketingStrategyPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public List<StrategyPO> getMarketingStrategy() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteMarketingStrategy(MarketingStrategyPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public List<StrategyPO> getHotelStrategy(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateHotelStrategy(HotelStrategyPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


}
