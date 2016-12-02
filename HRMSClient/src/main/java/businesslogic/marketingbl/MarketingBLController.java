package businesslogic.marketingbl;

import java.util.Date;
import java.util.List;

import Enum.ResultMessage;
import businesslogicservice.marketinblservice.MarketingBLControllerService;
import vo.clientVO.ClientVO;
import vo.districtVO.DistrictVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;

public class MarketingBLController implements MarketingBLControllerService{

	@Override
	public ResultMessage updateLevel(List<LevelVO> vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LevelVO> findAllLevel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage MarketingAccountAdd(MarketingVO marketing) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage MarketingAccountUpdate(MarketingVO marketing) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage MarketingAccountDelete(MarketingVO marketingVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MarketingVO MarketingAccountFind(String marketingID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkAccount(String marketingID, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MarketingVO init(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setAllClientLevel(LevelVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setCredit(String clientID, int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderVO findSpecificOrder(String marketingID, String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> findAbnormalOrderList(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage saveOrderPO(OrderVO order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deletePrivilege(PrivilegeVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateHotelStrategy(HotelStrategyVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelStrategyVO> getHotelStrategy(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientVO getclient(String clientID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMarketingStrategy(String vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MarketingStrategyVO> getMarketingStrategy(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addMarketingStrategy(MarketingStrategyVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addLog(String log) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DistrictVO> getDistricts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getDistrictNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
