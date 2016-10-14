package businesslogicservice.marketingBLService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Enum.ResultMessage;
import Enum.marketingStrategy;
import javafx.scene.image.Image;
import vo.hotelinfoVO.HotelinfoVO;
import vo.levelVO.LevelVO;
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
		    return ResultMessage.False;
		else
			return ResultMessage.True;
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
			return ResultMessage.False;
		else
			return ResultMessage.True;
	}





	@Override
	public OrderVO findSpecificAbnormalOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage handleAbnormal(OrderVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientVO getClient(String clientID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setCredit(String clientID, int recharge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(MarketingVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage siteManagerUpdate(MarketingVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveSitemanagerAdd(MarketingVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveSitemanagerDelete(MarketingVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkAccount(String marketingID, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MarketingVO init(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> showAbnormal(java.sql.Date date) {
		// TODO Auto-generated method stub
		return null;
	}



}
