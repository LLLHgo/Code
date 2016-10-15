package businesslogic.marketingbl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Enum.ResultMessage;
import Enum.marketingStrategy;
import businesslogicservice.marketingBLService.MarketingBLService;
import javafx.scene.image.Image;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;

	public class MarketingBLService_Stub implements MarketingBLService {
		double discount;
	    ArrayList<HotelinfoVO> hotels;

	    public MarketingBLService_Stub(double discount){
	       this.discount=discount;
		}

		@Override
		public ResultMessage addMarketingStrategy(MarketingStrategyVO vo) {
			if(vo.getType()==marketingStrategy.DOUBLE11)
			    return ResultMessage.FAIL;
			else
				return ResultMessage.SUCCESS;
		}


		@Override
		public List<MarketingStrategyVO> getMarketingStrategy(String id) {
	        marketingStrategy type=marketingStrategy.CRATEDE;
	        Date startTime=new Date();
	        Date endTime=new Date();
	        HotelinfoVO hotel=new HotelinfoVO();
	        hotels.add(hotel);
	        Image image=new Image(id);
	        String position="North";
	        MarketingStrategyVO vo=new MarketingStrategyVO(type,startTime,endTime,discount,hotels,image,position);
	        List<MarketingStrategyVO> msVO=new ArrayList<MarketingStrategyVO>();
	        msVO.add(vo);
			return msVO;
		}

		@Override
		public ResultMessage deleteMarketingStrategy(MarketingStrategyVO vo) {
			if(vo.getDiscount()>=0.9)
				return ResultMessage.FAIL;
			else
				return ResultMessage.SUCCESS;
		}

		@Override
		public OrderVO findSpecificAbnormalOrder(String id) {
			OrderVO vo=new OrderVO();
			return vo;
		}

		@Override
		public ResultMessage handleAbnormal(OrderVO vo) {
			if(vo.getPrice()>=200)
				return ResultMessage.FAIL;
			else
				return ResultMessage.SUCCESS;
		}

		@Override
		public ClientVO getClient(String clientID) {
	        ClientVO vo=new ClientVO();
	        return vo;
		}

		@Override
		public ResultMessage setCredit(String clientID, int recharge) {
			if(recharge>0)
				return ResultMessage.FAIL;
			else
				return ResultMessage.SUCCESS;
		}

		@Override
		public ResultMessage addLevel(LevelVO vo) {
		    if(vo.getCreditNeeded()>2000)
		    	return ResultMessage.FAIL;
		    else
		    	return ResultMessage.SUCCESS;
		}

		@Override
		public List<LevelVO> findAllLevel() {
			List<LevelVO> levels=new ArrayList<LevelVO>();
			LevelVO vo=new LevelVO(1,"铜牌",2000);
			levels.add(vo);
			return levels;
		}

		@Override
		public ResultMessage deleteLevel(LevelVO vo) {
			if(vo.getLevel()>0)
				return ResultMessage.FAIL;
		    else
		    	return ResultMessage.SUCCESS;
		}

		@Override
		public ResultMessage addPrivilege(PrivilegeVO vo) {
			if(vo.getDiscount()>0.8)
				return ResultMessage.FAIL;
		    else
		    	return ResultMessage.SUCCESS;
		}

		@Override
		public List<PrivilegeVO> findAllPrivilege(String VIPType) {
			List<PrivilegeVO> privileges=new ArrayList<PrivilegeVO>();
			privileges.add(new PrivilegeVO());
			return privileges;
		}

		@Override
		public ResultMessage deletePrivilege(PrivilegeVO vo) {
			if(vo.getDiscount()>0.8)
				return ResultMessage.FAIL;
		    else
		    	return ResultMessage.SUCCESS;
		}

		@Override
		public ResultMessage update(MarketingVO vo) {
			if(vo.getMarketingID()=="M0001")
				return ResultMessage.FAIL;
		    else
		    	return ResultMessage.SUCCESS;
		}

		@Override
		public ResultMessage siteManagerUpdate(MarketingVO vo) {
			if(vo.getMarketingID()=="M0001")
				return ResultMessage.FAIL;
		    else
		    	return ResultMessage.SUCCESS;
		}

		@Override
		public boolean saveSitemanagerAdd(MarketingVO vo) {
			if(vo.getMarketingID()=="M0001")
				return true;
		    else
		    	return false;
		}

		@Override
		public boolean saveSitemanagerDelete(MarketingVO vo) {
			if(vo.getMarketingID()=="M0001")
				return true;
		    else
		    	return false;
		}

		@Override
		public boolean checkAccount(String marketingID, String password) {
			if(marketingID==password)
				return true;
		    else
		    	return false;
		}

		@Override
		public MarketingVO init(String id) {
			MarketingVO vo=new MarketingVO("营销人员一号","1029384756","M0002","13380009000");
			return vo;
		}

		@Override
		public List<OrderVO> showAbnormal(Date date) {
			List<OrderVO> orders=new ArrayList<OrderVO>();
			OrderVO order=new OrderVO();
			orders.add(order);
			return orders;
		}

}
