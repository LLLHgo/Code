package presentation.marketing.controller;

import java.util.List;

import Enum.ResultMessage;
import Enum.VIPType;
import businesslogic.marketingbl.MarketingManage;
import businesslogic.strategybl.StrategyManage;
import presentation.marketing.view.ProcessMarketingViewControllerService;
import businesslogicservice.marketinblservice.MarketingBLService;
import businesslogicservice.strategyblservice.StrategyBLService;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;

public class ProcessMarketingViewContrller implements ProcessMarketingViewControllerService{
    private MarketingBLService MarketingBlService;
    private StrategyBLService StrategyBLService;

    public ProcessMarketingViewContrller (){
    	this.MarketingBlService=new MarketingManage();
    	this.StrategyBLService=new StrategyManage();
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
	public List<HotelStrategyVO> getHotelStrategy(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateHotelStrategy(String hotelID, HotelStrategyVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addPrivilege(PrivilegeVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PrivilegeVO> findAllPrivilege(VIPType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(PrivilegeVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
