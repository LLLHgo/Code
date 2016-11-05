package Mock;

import java.util.ArrayList;
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
    //网站营销人员制定的策略1
	private MarketingStrategyVO ms1;
	//网站营销人员制定的策略2
	private MarketingStrategyVO ms2;
	//网站营销人员制定的会员等级1
	private LevelVO lv1;
	//网站营销人员制定的会员等级2
	private LevelVO lv2;
	//订单1
	private OrderVO ov1;
	//订单2
	private OrderVO ov2;
    //福利1
	private PrivilegeVO pv1;
	//福利2
	private PrivilegeVO pv2;
	//客户
	private ClientVO cv;
	//网站营销人员VO
	private MarketingVO mv;

	public MockMarketing(){
    }
    public MockMarketing(MarketingStrategyVO vo){
    	this.ms1=vo;
    }
    public MockMarketing(MarketingStrategyVO vo1,MarketingStrategyVO vo2){
    	this.ms1=vo1;
    	this.ms2=vo2;
    }
    public MockMarketing(LevelVO vo){
        this.lv1=vo;
    }

    public MockMarketing(LevelVO v1,LevelVO v2){
        this.lv1=v1;
        this.lv2=v2;
    }

    public MockMarketing(OrderVO vo){
        this.ov1=vo;
    }

    public MockMarketing(OrderVO v1,OrderVO v2){
        this.ov1=v1;
        this.ov2=v2;
    }
    public MockMarketing(PrivilegeVO vo){
        this.pv1=vo;
    }

    public MockMarketing(PrivilegeVO v1,PrivilegeVO v2){
        this.pv1=v1;
        this.pv2=v2;
    }
    public MockMarketing(ClientVO vo){
        this.cv=vo;
    }
	public ResultMessage addMarketingStrategy(MarketingStrategyVO vo) {
		return ResultMessage.SUCCESS;
	}


	public List<MarketingStrategyVO> getMarketingStrategy(String id) {
		List<MarketingStrategyVO> list=new ArrayList<MarketingStrategyVO>();
		list.add(ms1);
		list.add(ms2);
		return list;
	}


	public ResultMessage deleteMarketingStrategy(MarketingStrategyVO vo) {
		return ResultMessage.SUCCESS;
	}


	public ResultMessage addLevel(LevelVO vo) {
		return ResultMessage.SUCCESS;
	}


	public List<LevelVO> findAllLevel() {
		List<LevelVO> list=new ArrayList<LevelVO>();
		list.add(lv1);
		list.add(lv2);
		return list;
	}


	public ResultMessage deleteLevel(LevelVO vo) {
		return ResultMessage.SUCCESS;
	}


	public ResultMessage addPrivilege(PrivilegeVO vo) {
		return ResultMessage.SUCCESS;
	}


	public List<PrivilegeVO> findAllPrivilege(VIPType vipType) {
		List<PrivilegeVO> list=new ArrayList<PrivilegeVO>();
		list.add(pv1);
		list.add(pv2);
		return list;
	}


	public ResultMessage deletePrivilege(PrivilegeVO vo) {
		return ResultMessage.SUCCESS;
	}


	public List<OrderVO> showAbnormal(Date date) {
		List<OrderVO> list=new ArrayList<OrderVO>();
		list.add(ov1);
		list.add(ov2);
		return list;
	}


	public OrderVO findSpecificAbnormalOrder(String id) {
		return this.ov1;
	}


	public ResultMessage handleAbnormal(OrderVO vo) {
		return ResultMessage.SUCCESS;
	}


	public ClientVO getClient(String clientID) {
		return this.cv;
	}


	public ResultMessage setCredit(String clientID, int recharge) {
		return ResultMessage.SUCCESS;
	}


	public ResultMessage update(MarketingVO vo) {
		return ResultMessage.SUCCESS;
	}


	public ResultMessage siteManagerUpdate(MarketingVO vo) {
		return ResultMessage.SUCCESS;
	}


	public boolean saveSitemanagerAdd(MarketingVO vo) {

		return true;
	}


	public boolean saveSitemanagerDelete(MarketingVO vo) {
		return true;
	}


	public boolean checkAccount(String marketingID, String password) {
		return true;
	}


	public MarketingVO init(String id) {
		return this.mv;
	}


	public MarketingVO returnSitemanagerAccount(String marketingID) {
		return this.mv;
	}

}
