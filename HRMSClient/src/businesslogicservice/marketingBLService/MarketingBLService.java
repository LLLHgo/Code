package businesslogicservice.marketingBLService;

import java.util.Date;
import java.util.List;
import Enum.ResultMessage;
import vo.clientVO.ClientVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;
<<<<<<< HEAD

=======
>>>>>>> origin/master

public interface MarketingBLService {
    //增加制定策略
	public ResultMessage addMarketingStrategy(MarketingStrategyVO  vo);
	//返回网站营销人员策略
	public List<MarketingStrategyVO> getMarketingStrategy(String id);
	//删除网站营销人员策略
	public ResultMessage deleteMarketingStrategy(MarketingStrategyVO vo);
	//增加等级信息
	public ResultMessage addLevel(LevelVO vo);
	//返回所有等级信息
    public List<LevelVO> findAllLevel();
    //删除等级信息
    public ResultMessage deleteLevel(LevelVO vo);
    //增加会员福利
    public ResultMessage addPrivilege(PrivilegeVO vo);
    //返回所有会员福利信息
    public List<PrivilegeVO> findAllPrivilege(String VIPType);
    //删除会员福利信息
    public ResultMessage deletePrivilege(PrivilegeVO vo);
    //界面显示当日未执行订单
    public List<OrderVO> showAbnormal(Date date);
    //界面返回特定订单信息
    public OrderVO findSpecificAbnormalOrder(String id);
    //处理异常订单状态
    public ResultMessage handleAbnormal(OrderVO vo);
    //界面返回客户信息
    public ClientVO getClient(String clientID);
    //设置客户信用值
    public ResultMessage setCredit(String clientID,int recharge);
    //修改网站营销人员信息
    public ResultMessage update(MarketingVO vo);
    //网站管理人员修改营销人员信息
    public ResultMessage siteManagerUpdate(MarketingVO vo);
    //网站管理人员增加营销人员信息
    public boolean saveSitemanagerAdd(MarketingVO vo);
    //网站管理人员删除营销人员信息
    public boolean saveSitemanagerDelete(MarketingVO vo);
    //网站营销人员登录验证
    public boolean checkAccount(String marketingID,String password);
    //返回网站营销人员个人信息
    public MarketingVO init(String id);
}
