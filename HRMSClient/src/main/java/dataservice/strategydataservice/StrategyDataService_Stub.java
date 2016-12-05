package dataservice.strategydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Enum.VIPType;
import po.StrategyPO.HotelStrategyPO;
import po.StrategyPO.MarketingStrategyPO;
import po.StrategyPO.StrategyPO;

public class StrategyDataService_Stub implements StrategyDataService{




    /**
     * 增加网站营销人员促销策略
     * @param po
     * @return 是否增加成功
     */
    public boolean addMarketingStrategy(MarketingStrategyPO po) {
    	if(po!=null)
			return true;
		else
			return false;
	}

    /**
     * 返回网站营销人员指定的额策略列表
     * @param id
     * @return 返回策略列表
     */
    public List<MarketingStrategyPO> getMarketingStrategy (String id) {
    	//MarketingStrategyPO po=new MarketingStrategyPO();
    	List<MarketingStrategyPO> list=new ArrayList<MarketingStrategyPO>();
    	//list.add(po);
		return list;
	}

    /**
     * 删除网站营销人员制定的策略
     * @param po
     * @return 返回是否删除成功
     */
    public boolean deleteMarketingStrategy (MarketingStrategyPO po) {
    	if(po!=null)
			return true;
		else
			return false;
	}

    /**
     * 根据hotelID返回该酒店制定的策略
     * @param hotelID
     * @return 返回策略列表
     */
    public List<StrategyPO> getHotelStrategy(String hotelID) {
    	//HotelStrategyPO po=new HotelStrategyPO();
    	List<StrategyPO> list=new ArrayList<StrategyPO>();
    	//list.add(po);
		return list;
	}

    /**
     * 更新酒店策略
     * @param po
     * @return 返回是否更新成功
     */
    public boolean updateHotelStrategy(HotelStrategyPO po) {
    	if(po!=null)
			return true;
		else
			return false;
	}

	@Override
	public List<StrategyPO> getMarketingStrategy() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
