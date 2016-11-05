package Mock;

import java.util.Date;
import java.util.List;

import Enum.ResultMessage;
import Enum.VIPType;
import businesslogic.marketingbl.Marketingbl;
import vo.clientVO.ClientVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;

public class MockMarketing extends Marketingbl{


	public ResultMessage addMarketingStrategy(MarketingStrategyVO vo) {
		return ResultMessage.SUCCESS;
	}


	public List<MarketingStrategyVO> getMarketingStrategy(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage deleteMarketingStrategy(MarketingStrategyVO vo) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage addLevel(LevelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<LevelVO> findAllLevel() {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage deleteLevel(LevelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage addPrivilege(PrivilegeVO vo) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<PrivilegeVO> findAllPrivilege(VIPType vipType) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage deletePrivilege(PrivilegeVO vo) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<OrderVO> showAbnormal(Date date) {
		// TODO Auto-generated method stub
		return null;
	}


	public OrderVO findSpecificAbnormalOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage handleAbnormal(OrderVO vo) {
		// TODO Auto-generated method stub
		return null;
	}


	public ClientVO getClient(String clientID) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage setCredit(String clientID, int recharge) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage update(MarketingVO vo) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage siteManagerUpdate(MarketingVO vo) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean saveSitemanagerAdd(MarketingVO vo) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean saveSitemanagerDelete(MarketingVO vo) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean checkAccount(String marketingID, String password) {
		// TODO Auto-generated method stub
		return false;
	}


	public MarketingVO init(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	public MarketingVO returnSitemanagerAccount(String marketingID) {
		// TODO Auto-generated method stub
		return null;
	}

}
