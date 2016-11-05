package businesslogic.strategybl;

import java.util.List;

import Enum.VIPType;
import businesslogicservice.strategyblservice.StrategyBLService;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;

public class StrategyManage implements StrategyBLService{

	@Override
	public boolean addMarketingStrategy(MarketingStrategyVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MarketingStrategyVO> getMarketingStrategy(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteMarketingStrategy(MarketingStrategyVO vo) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean updateHotelStrategy(String hotelID, HotelStrategyVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPrivilege(PrivilegeVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PrivilegeVO> findAllPrivilege(VIPType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(PrivilegeVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
