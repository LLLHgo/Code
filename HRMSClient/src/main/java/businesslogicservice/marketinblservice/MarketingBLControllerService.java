package businesslogicservice.marketinblservice;

import java.util.List;

import Enum.ResultMessage;
import vo.areaVO.AreaVO;
import vo.clientVO.ClientVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.MarketingStrategyVO;
/**
 * interface MarketingBLControllerService的接口
 * @author huangpiao
 *
 */
public interface MarketingBLControllerService {

	/**
	 * 更新等级信息
	 * @param vo
	 * @return 更新的结果
	 */
	public ResultMessage updateLevel(List<LevelVO> vo);

	/**
	 * 得到所有等级信息
	 * @return 等级信息列表
	 */
	public List<LevelVO> findAllLevel();

	/**
	 * 增加网站营销人员账号信息
	 * @param marketing
	 * @return 增加的结果
	 */
	public ResultMessage MarketingAccountAdd(MarketingVO marketing);

	/**
	 * 更新网站营销人员账号信息
	 * @param marketing
	 * @return 更新的结果
	 */
	public ResultMessage MarketingAccountUpdate(MarketingVO marketing);

	/**
	 * 删除网站营销人员账号信息
	 * @param marketingVO
	 * @return 删除的结果
	 */
	public ResultMessage MarketingAccountDelete(MarketingVO marketingVO);

	/**
	 * 查找网站营销人员账号信息
	 * @param marketingID
	 * @return 返回信息
	 */
	public MarketingVO MarketingAccountFind(String marketingID);

	/**
	 * 查看账号是否匹配密码
	 * @param marketingID
	 * @param password
	 * @return 返回结果
	 */
	public boolean checkAccount(String marketingID, String password);

	/***
	 * 得到个人信息
	 * @param id
	 * @return 返回信息VO
	 */
	public MarketingVO init(String id);

	/**
	 * 设置信用值
	 * @param clientID
	 * @param amount
	 * @param reason
	 * @return 是否设置成功
	 */
	public boolean setCredit(String clientID, int amount,String reason);


	/**
	 * 找到具体订单
	 * @param marketingID
	 * @param orderID
	 * @return 返回订单VO
	 */
	public OrderVO findSpecificOrder(String marketingID, String orderID);

	/**
	 * 得到某日异常订单list
	 * @param date
	 * @return 订单list
	 */
	public List<OrderVO> findAbnormalOrderList(String date);


	/**
	 * 得到客户信息
	 * @param clientID
	 * @return 客户信息
	 */
	public ClientVO getclient(String clientID);

	/***
	 * 删除网站营销人员制定的策略
	 * @param vo
	 * @return 删除的结果
	 */
	public ResultMessage deleteMarketingStrategy(String vo);

	/**
	 * 得到所有网站营销人员制定的策略
	 * @return 所有网站营销人员制定的策略列表
	 */
	public List<MarketingStrategyVO> getMarketingStrategy();

	/**
	 * 增加网站营销人员制定的策略
	 * @param vo
	 * @return 增加的结果
	 */
	public ResultMessage addMarketingStrategy(MarketingStrategyVO vo);

	/**
	 * 得到商圈和所属酒店的列表信息
	 * @return  商圈和所属酒店的列表信息
	 */
	public List<AreaVO> getDistricts();

	/**
	 * 得到商圈列表
	 * @return 商圈列表
	 */
	public String[] getDistrictNames();

	/**
	 * 对订单进行一系列操作
	 * @param order
	 * @param price
	 * @param log
	 * @param reason
	 * @return 操作的结果
	 */
	public ResultMessage operateOnAbnormalOrder(OrderVO order, double price, StringBuilder log,String reason);

	/**
	 * 得到最近新增的网站营销人员的账号
	 * @return 账号
	 */
	public String getMarketingID();

}
