package businesslogicservice.marketinblservice;

import java.util.Date;
import java.util.List;

import Enum.ResultMessage;
import vo.clientVO.ClientVO;
import vo.districtVO.DistrictVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;

public interface MarketingBLControllerService {

	public ResultMessage updateLevel(List<LevelVO> vo);

	public List<LevelVO> findAllLevel();

	public ResultMessage MarketingAccountAdd(MarketingVO marketing);

	public ResultMessage MarketingAccountUpdate(MarketingVO marketing);

	public ResultMessage MarketingAccountDelete(MarketingVO marketingVO);

	public MarketingVO MarketingAccountFind(String marketingID);

	public boolean checkAccount(String marketingID, String password);

	public MarketingVO init(String id);

	public boolean setAllClientLevel(LevelVO vo);

	public boolean setCredit(String clientID, int amount);


	public OrderVO findSpecificOrder(String marketingID, String orderID);

	public List<OrderVO> findAbnormalOrderList(Date date);

	public ResultMessage saveOrderPO(OrderVO order);

	public ResultMessage deletePrivilege(PrivilegeVO vo);

	public ResultMessage updateHotelStrategy(HotelStrategyVO vo);

	public List<HotelStrategyVO> getHotelStrategy(String hotelID);

	public ClientVO getclient(String clientID);

	public ResultMessage deleteMarketingStrategy(String vo);

	public List<MarketingStrategyVO> getMarketingStrategy(String id);

	public ResultMessage addMarketingStrategy(MarketingStrategyVO vo);

	public void addLog(String log);

	public List<DistrictVO> getDistricts();

	public List<String> getDistrictNames();

}
