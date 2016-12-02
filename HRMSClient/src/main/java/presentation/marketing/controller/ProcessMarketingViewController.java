package presentation.marketing.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Enum.ResultMessage;
import Enum.VIPType;
import Enum.UserType;
import businesslogic.logbl.LogManage;
import presentation.marketing.view.ProcessMarketingAbnormalView;
import presentation.marketing.view.ProcessMarketingCreditView;
import presentation.marketing.view.ProcessMarketingProfileView;
import presentation.marketing.view.ProcessMarketingStrategyView;
import presentation.marketing.view.ProcessMarketingVIPView;
import presentation.marketing.view.ProcessMarketingView;
import presentation.marketing.view.*;
import presentation.marketing.view.ProcessMarketingViewControllerService;
import businesslogicservice.marketinblservice.MarketingBLService;
import businesslogicservice.marketinblservice.MarketingBLService_Stub;
import businesslogicservice.orderblservice.OrderOperatorBLService;
import businesslogicservice.orderblservice.OrderBLService_Stub;
import businesslogicservice.orderblservice.OrderFindBLService;
import businesslogicservice.clientblservice.ClientBLService;
import businesslogicservice.clientblservice.ClientBLService_Stub;
import businesslogicservice.logblservice.*;
import businesslogicservice.strategyblservice.StrategyBLService;
import businesslogicservice.strategyblservice.StrategyBLService_Stub;
import datatool.DistrictDataTool;
import vo.clientVO.ClientVO;
import vo.districtVO.DistrictVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;

public class ProcessMarketingViewController implements ProcessMarketingViewControllerService{
    private LogBLService LogBLService;//bl层的logManage未实现blservice
	private MarketingBLService MarketingBlService;
    private StrategyBLService StrategyBLService;
    private OrderOperatorBLService OrderBLOperatorService;
    private OrderFindBLService OrderBLFindService;
    private ClientBLService ClientBLService;
    private String marketingID;
    private ProcessMarketingView view;
    private ProcessMarketingProfileView profileView;
    private ProcessMarketingAbnormalView abnormalView;
    private ProcessMarketingStrategyView strategyView;
    private ProcessMarketingVIPView VIPView;
    private ProcessMarketingCreditView creditView;

    public ProcessMarketingViewController (String marketingID){
    	this.marketingID=marketingID;
    	this.MarketingBlService=new MarketingBLService_Stub();
    	this.StrategyBLService=new StrategyBLService_Stub();
    	this.OrderBLOperatorService=new OrderBLService_Stub();
    	this.OrderBLFindService=new OrderBLService_Stub();
    	this.LogBLService=new LogBLService_Stub();
        this.ClientBLService=new ClientBLService_Stub();
    }
    @Override
    public String getMarketingID(){
    	return this.marketingID;
    }
    @Override
	public ResultMessage updateLevel(List<LevelVO> vo) {
		return this.MarketingBlService.updateLevel(vo);
	}

	@Override
	public List<LevelVO> findAllLevel() {
		return this.MarketingBlService.findAllLevel();
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
	public ResultMessage MarketingAccountDelete(MarketingVO marketingVO) {
		return this.MarketingBlService.MarketingAccountDelete(marketingVO);
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
	public ResultMessage deleteMarketingStrategy(String vo) {
		return this.StrategyBLService.deleteMarketingStrategy(vo);
	}

	@Override
	public List<HotelStrategyVO> getHotelStrategy(String hotelID) {
		return this.StrategyBLService.getHotelStrategy(hotelID);
	}

	@Override
	public ResultMessage updateHotelStrategy(String hotelID, HotelStrategyVO vo) {
		return this.StrategyBLService.updateHotelStrategy(vo);
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
		return this.OrderBLOperatorService.saveOrderPO(order);
	}

	@Override
	public List<OrderVO> findAbnormalOrderList(Date date) {
		return this.OrderBLFindService.findAbnormalOrderList(date);
	}

	@Override
	public OrderVO findSpecificOrder(String orderID) {
		return this.OrderBLFindService.findSpecificOrder(marketingID,orderID);//删掉List
	}

	@Override
	public ClientVO getclient(String clientID) {
		return this.ClientBLService.getclient(clientID);
	}

	@Override
	public boolean setCredit(String clientID, double recharge) {//改为double
		return this.ClientBLService.setCredit(clientID, (int)recharge);
	}

	@Override
	public boolean setAllClientLevel(LevelVO vo) {
		return this.ClientBLService.setAllClientLevel(vo);
	}

	@Override
	public void setView(ProcessMarketingView view) {
		this.view=view;
	}
	@Override
	public void profileButtonClicked() {
		view.hideWelcome();
		hide();
		profileView=new ProcessMarketingProfileView(this,view);
	}
	@Override
	public void abnormalButtonClicked() {
		hide();
		abnormalView=new ProcessMarketingAbnormalView(this,view);
	}
	@Override
	public void addLog(String log) {
		this.LogBLService.addLog(log);

	}
	@Override
	public void strategyButtonClicked() {
		view.hideWelcome();
		hide();
		strategyView=new ProcessMarketingStrategyView(this,view);

	}
	@Override
	public List<DistrictVO> getDistricts() {
		List<DistrictVO> list=new ArrayList<DistrictVO>();
	    list.add(DistrictDataTool.dis1);
	    list.add(DistrictDataTool.dis2);
	    return list;
	}
	@Override
	public List<String> getDistrictNames() {
		List<String> list=new ArrayList<String>();
	    list=(DistrictDataTool.list1);
	    return list;
	}
	@Override
	public void creditButtonClicked() {
		view.hideWelcome();
		hide();
		creditView=new ProcessMarketingCreditView(this,view);
	}
	@Override
	public void VIPButtonClicked() {
		view.hideWelcome();
		hide();

		VIPView=new ProcessMarketingVIPView(this,view);
	}


	private void hide(){
		if(abnormalView!=null)
			abnormalView.hideAbnormal();
		abnormalView=null;

		if(profileView!=null)
			profileView.hideProfile();
		profileView=null;

		if(strategyView!=null)
			strategyView.hideStrategy();
		strategyView=null;

		if(VIPView!=null)
			VIPView.hideVIP();
		VIPView=null;

		if(creditView!=null)
			creditView.hideCredit();
		creditView=null;
	}


}
