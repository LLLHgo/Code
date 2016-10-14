package businesslogicservice;

import java.sql.Date;
import java.util.List;

import po.ResultMessage;

public interface MarketingBLService {
    //增加制定策略
	public ResultMessage addMarketingStrategy(marketingStrategyVO  vo);
	//
	public List<StrategyVO> getMarketingStrategy(String id);
	public ResultMessage deleteStrategy(StrategyVO vo);
	public ResultMessage addLevel(LevelVO vo);
    public List<LevelVO> findAllLevel();
    public ResultMessage deleteLevel(LevelVO vo);
    public ResultMessage addPrivilege(PrivilegeVO vo);
    public List<PrivilegeVO> findAllPrivilege(String VIPType);
    public ResultMessage deletePrivilege(PrivilegeVO vo);
    public List<OrderVO> showAbnormal(Date date);
    public OrderVO findSpecificAbnormalOrder(String id);
    public ResultMessage handleAbnormal(OrderVO vo);
    public ClientVO getClient(String clientID);
    public ResultMessage setCredit(String clientID,int recharge);
    public ResultMessage update(MarketingVO vo);
    public ResultMessage siteManagerUpdate(MarketingVO vo);

}
