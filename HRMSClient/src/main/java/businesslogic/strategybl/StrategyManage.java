package businesslogic.strategybl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Enum.ResultMessage;
import businesslogic.hoteinfobl.Hotelinfo;
import businesslogic.hoteinfobl.Roominfo;
import businesslogicservice.strategyblservice.StrategyBLService;
import dataservice.strategydataservice.StrategyDataService;
import dataservice.strategydataservice.StrategyDataService_Stub;
import po.StrategyPO.StrategyPO;
import vo.clientVO.ClientVO;
import vo.priceVO.PriceVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class StrategyManage implements StrategyBLService{

	private StrategyDataService strategyDataService=new StrategyDataService_Stub();
	@Override
	public ResultMessage addMarketingStrategy(MarketingStrategyVO vo) {

		return null;//null、、this.strategyDataService.addMarketingStrategy(po);
	}

	@Override
	public List<MarketingStrategyVO> getMarketingStrategy(String id) {
		return null;
	}

	@Override
	public ResultMessage deleteMarketingStrategy(String vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public boolean deletehotelStrategy(HotelStrategyVO vo) {
		return false;
	}

	@Override
	public List<HotelStrategyVO> getHotelStrategy(String hotelID) {
		return null;
	}

	@Override
	public ResultMessage updateHotelStrategy(HotelStrategyVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public PriceVO calculatePrice(ClientVO clientVO, Roominfo roomInfoVO, Hotelinfo hotelInfoVO, int num) {
		List<String> strategyUsed=new ArrayList<String>();
		List<StrategyPO> strategys=new ArrayList<StrategyPO>();
		Strategy[] strategy=new Strategy[8];
		strategy[0]=new MarketingPeriod();
		strategy[1]=new MarketingSpecial();
		strategy[2]=new MarketingCreated();
		strategy[3]=new HotelBirthday();
		strategy[4]=new HotelCompany();
		strategy[5]=new HotelSpecialday();
		strategy[6]=new HotelOverThreeRooms();
		strategy[7]=new HotelCreated();
		try {
			strategys.addAll(this.strategyDataService.getHotelStrategy(hotelInfoVO.getHotelID()));
			strategys.addAll(this.strategyDataService.getMarketingStrategy());
		} catch (RemoteException e) {
			return null;//从数据库中调策略的时候出现故障
		}

		for(StrategyPO strt:strategys){

		}

		return null;
	}


}
