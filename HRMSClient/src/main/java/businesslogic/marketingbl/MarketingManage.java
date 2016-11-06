package businesslogic.marketingbl;

import java.util.Date;
import java.util.List;

import Enum.ResultMessage;
import businesslogicservice.marketinblservice.MarketingBLService;
import vo.clientVO.ClientVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;

public class MarketingManage implements MarketingBLService{

	@Override
	public ResultMessage addLevel(LevelVO vo) {
		return null;
	}

	@Override
	public List<LevelVO> findAllLevel() {
		return null;
	}

	@Override
	public ResultMessage deleteLevel(LevelVO vo) {
		return null;
	}

	@Override
	public List<OrderVO> showAbnormal(Date date) {
		return null;
	}

	@Override
	public OrderVO findSpecificAbnormalOrder(String id) {
		return null;
	}

	@Override
	public ResultMessage handleAbnormal(OrderVO vo) {
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

	@Override
	public MarketingVO returnSitemanagerAccount(String marketingID) {
		// TODO Auto-generated method stub
		return null;
	}

}
