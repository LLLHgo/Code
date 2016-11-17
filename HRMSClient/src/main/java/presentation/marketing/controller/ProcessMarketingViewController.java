package presentation.marketing.controller;

import java.util.Date;
import java.util.List;

import Enum.ResultMessage;
import Enum.VIPType;
import businesslogic.marketingbl.MarketingManage;
import businesslogic.orderbl.OrderManage;
import businesslogic.strategybl.StrategyManage;
import presentation.marketing.view.ProcessMarketingView;
import presentation.marketing.view.ProcessMarketingViewControllerService;
import businesslogicservice.marketinblservice.MarketingBLService;
import businesslogicservice.orderblservice.OrderBLService;
import businesslogicservice.clientblservice.ClientBLService;
import businesslogicservice.strategyblservice.StrategyBLService;
import vo.clientVO.ClientVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;

public class ProcessMarketingViewController implements ProcessMarketingViewControllerService{
    private MarketingBLService MarketingBlService;
    private StrategyBLService StrategyBLService;
    private OrderBLService OrderBLService;
    private ClientBLService ClientBLService;
    private String marketingID;
    private ProcessMarketingView view;
    public ProcessMarketingViewController (String marketingID){
    	this.marketingID=marketingID;
    	this.MarketingBlService=new MarketingManage();
    	this.StrategyBLService=new StrategyManage();
    	this.OrderBLService=new OrderManage();
        //this.ClientBLService=new ClientManage();
    }
    @Override
    public String getMarketingID(){
    	return this.marketingID;
    }
    @Override
	public ResultMessage addLevel(LevelVO vo) {
		return this.MarketingBlService.addLevel(vo);
	}

	@Override
	public List<LevelVO> findAllLevel() {
		return this.MarketingBlService.findAllLevel();
	}

	@Override
	public ResultMessage deleteLevel(LevelVO vo) {
		return this.MarketingBlService.deleteLevel(vo);
	}

	@Override
	public ResultMessage MarketingAccountAdd(MarketingVO marketing) {
		return this.MarketingBlService.MarketingAccountAdd(marketing);
	}

	@Override
	public ResultMessage MarketingAccountUpdate(MarketingVO marketing) {
		return this.MarketingBlService.MarketingAccountUpdate(marketing);
	}

	@Override
	public ResultMessage MarketingAccountDelete(MarketingVO marketing) {
		return this.MarketingBlService.MarketingAccountDelete(marketing);
	}

	@Override
	public MarketingVO MarketingAccountFind(String marketingID) {
		return this.MarketingBlService.MarketingAccountFind(marketingID);
	}

	@Override
	public boolean checkAccount(String marketingID, String password) {
		return this.MarketingBlService.checkAccount(marketingID, password);
	}

	@Override
	public MarketingVO init(String id) {
		return this.MarketingBlService.init(id);
	}

	@Override
	public ResultMessage addMarketingStrategy(MarketingStrategyVO vo) {
		return this.StrategyBLService.addMarketingStrategy(vo);
	}

	@Override
	public List<MarketingStrategyVO> getMarketingStrategy(String id) {
		return this.StrategyBLService.getMarketingStrategy(id);
	}

	@Override
	public ResultMessage deleteMarketingStrategy(MarketingStrategyVO vo) {
		return this.StrategyBLService.deleteMarketingStrategy(vo);
	}

	@Override
	public List<HotelStrategyVO> getHotelStrategy(String hotelID) {
		return this.StrategyBLService.getHotelStrategy(hotelID);
	}

	@Override
	public ResultMessage updateHotelStrategy(String hotelID, HotelStrategyVO vo) {
		return this.StrategyBLService.updateHotelStrategy(hotelID, vo);
	}

	@Override
	public ResultMessage addPrivilege(PrivilegeVO vo) {
		return this.StrategyBLService.addPrivilege(vo);
	}

	@Override
	public List<PrivilegeVO> findAllPrivilege(VIPType type) {
		return  this.StrategyBLService.findAllPrivilege(type);
	}

	@Override
	public ResultMessage deletePrivilege(PrivilegeVO vo) {
		return this.StrategyBLService.deletePrivilege(vo);
	}

	@Override
	public ResultMessage saveOrder(OrderVO order) {
		return this.OrderBLService.saveOrder(order);
	}

	@Override
	public List<OrderVO> findAbnormalOrderList(Date date) {
		return this.OrderBLService.findAbnormalOrderList(date);
	}

	@Override
	public OrderVO findSpecificOrderList(String orderID) {
		return this.OrderBLService.findSpecificOrderList(orderID);
	}

	@Override
	public ClientVO getclient(String clientID) {
		return this.ClientBLService.getclient(clientID);
	}

	@Override
	public boolean setCredit(String clientID, int recharge) {
		return this.ClientBLService.setCredit(clientID, recharge);
	}

	@Override
	public boolean setAllClientLevel(LevelVO vo) {
		return this.ClientBLService.setAllClientLevel(vo);
	}

	@Override
	public void setView(ProcessMarketingView view) {
		this.view=view;
	}

}
