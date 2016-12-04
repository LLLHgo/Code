package businesslogic.strategybl;

import java.util.List;

import Enum.ResultMessage;
import businesslogic.hoteinfobl.Hotelinfo;
import businesslogic.hoteinfobl.Roominfo;
import businesslogicservice.strategyblservice.StrategyBLService;
import dataservice.strategydataservice.StrategyDataService;
import dataservice.strategydataservice.StrategyDataService_Stub;
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
		// TODO Auto-generated method stub
		return null;
	}


}
