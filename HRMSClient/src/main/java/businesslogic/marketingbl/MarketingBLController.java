package businesslogic.marketingbl;

import java.util.Date;
import java.util.List;

import Enum.ResultMessage;
import businesslogicservice.clientblservice.ClientBLService;
import businesslogicservice.clientblservice.ClientBLService_Stub;
import businesslogicservice.logblservice.LogBLService;
import businesslogicservice.logblservice.LogBLService_Stub;
import businesslogicservice.marketinblservice.MarketingBLControllerService;
import businesslogicservice.marketinblservice.MarketingBLService;
import businesslogicservice.marketinblservice.MarketingBLService_Stub;
import businesslogicservice.orderblservice.*;
import businesslogicservice.strategyblservice.StrategyBLService;
import businesslogicservice.strategyblservice.StrategyBLService_Stub;
import datatool.AreaDataTool;
import vo.areaVO.AreaVO;
import vo.clientVO.ClientVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.MarketingStrategyVO;

public class MarketingBLController implements MarketingBLControllerService{

	private MarketingBLService marketingBL=new MarketingBLService_Stub();
	private ClientBLService clientBL=new ClientBLService_Stub();
	private StrategyBLService strategyBL=new StrategyBLService_Stub();
	private OrderBLService_Stub orderBL=new OrderBLService_Stub();
	private LogBLService logBL=new LogBLService_Stub();

	@Override
	public ResultMessage updateLevel(List<LevelVO> vo) {
		return this.marketingBL.updateLevel(vo);
	}

	@Override
	public List<LevelVO> findAllLevel() {
		return this.marketingBL.findAllLevel();
	}

	@Override
	public ResultMessage MarketingAccountAdd(MarketingVO marketing) {
		return this.marketingBL.MarketingAccountAdd(marketing);
	}

	@Override
	public ResultMessage MarketingAccountUpdate(MarketingVO marketing) {
		return this.marketingBL.MarketingAccountUpdate(marketing);
	}

	@Override
	public ResultMessage MarketingAccountDelete(MarketingVO marketingVO) {
		return this.marketingBL.MarketingAccountDelete(marketingVO);
	}

	@Override
	public MarketingVO MarketingAccountFind(String marketingID) {
		return this.marketingBL.MarketingAccountFind(marketingID);
	}

	@Override
	public boolean checkAccount(String marketingID, String password) {
		return this.marketingBL.checkAccount(marketingID, password);
	}

	@Override
	public MarketingVO init(String id) {
		return this.marketingBL.init(id);
	}

	@Override
	public boolean setAllClientLevel(LevelVO vo) {
		return this.clientBL.setAllClientLevel(vo);
	}

	@Override
	public boolean setCredit(String clientID, int amount) {
		return this.clientBL.setCredit(clientID,amount);
	}

	@Override
	public OrderVO findSpecificOrder(String marketingID, String orderID) {
		return this.orderBL.findSpecificOrder(marketingID, orderID);
	}

	@Override
	public List<OrderVO> findAbnormalOrderList(Date date) {
		return this.orderBL.findAbnormalOrderList(date);
	}

	@Override
	public ResultMessage saveOrderPO(OrderVO order) {
		return this.orderBL.saveOrderPO(order);
	}



	@Override
	public ClientVO getclient(String clientID) {
		return this.clientBL.getclient(clientID);
	}

	@Override
	public ResultMessage deleteMarketingStrategy(String vo) {
		return this.strategyBL.deleteMarketingStrategy(vo);
	}

	@Override
	public List<MarketingStrategyVO> getMarketingStrategy(String id) {
		return this.strategyBL.getMarketingStrategy(id);
	}

	@Override
	public ResultMessage addMarketingStrategy(MarketingStrategyVO vo) {
		return this.strategyBL.addMarketingStrategy(vo);
	}

	@Override
	public void addLog(String log) {
		this.logBL.addLog(log);
	}

	@Override
	public List<AreaVO> getDistricts() {
		return AreaDataTool.vos;
	}

	@Override
	public List<String> getDistrictNames() {
		return AreaDataTool.list1;
	}

}
