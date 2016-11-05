package businesslogic.strategybl;

import java.util.List;

import Enum.ResultMessage;
import Enum.VIPType;
import businesslogicservice.strategyblservice.StrategyBLService;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;

public class StrategyManage implements StrategyBLService{

	@Override
	public ResultMessage addMarketingStrategy(MarketingStrategyVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public List<MarketingStrategyVO> getMarketingStrategy(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMarketingStrategy(MarketingStrategyVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public boolean deletehotelStrategy(HotelStrategyVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<HotelStrategyVO> getHotelStrategy(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateHotelStrategy(String hotelID, HotelStrategyVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addPrivilege(PrivilegeVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public List<PrivilegeVO> findAllPrivilege(VIPType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(PrivilegeVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
