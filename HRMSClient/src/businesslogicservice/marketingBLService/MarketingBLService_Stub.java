package businesslogicservice.marketingBLService;

import java.sql.Date;
import java.util.List;

import Enum.ResultMessage;
import vo.*;
import vo.clientVO.ClientVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.MarketingStrategyVO;

public class MarketingBLService_Stub implements MarketingBLService {

	@Override
	public ResultMessage addMarketingStrategy(MarketingStrategyVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MarketingStrategyVO> getMarketingStrategy(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMarketingStrategy(MarketingStrategyVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addLevel(LevelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LevelVO> findAllLevel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteLevel(LevelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addPrivilege(PrivilegeVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PrivilegeVO> findAllPrivilege(String VIPType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deletePrivilege(PrivilegeVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> showAbnormal(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO findSpecificAbnormalOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage handleAbnormal(OrderVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientVO getClient(String clientID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setCredit(String clientID, int recharge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(MarketingVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage siteManagerUpdate(MarketingVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveSitemanagerAdd(MarketingVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveSitemanagerDelete(MarketingVO vo) {
		// TODO Auto-generated method stub
		return false;
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



}
