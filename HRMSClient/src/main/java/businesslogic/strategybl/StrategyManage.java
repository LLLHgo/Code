package businesslogic.strategybl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Enum.HotelStrategy;
import Enum.MarketingStrategy;
import Enum.ResultMessage;
import Enum.StrategyMaker;
import businesslogic.hoteinfobl.Hotelinfo;
import businesslogic.hoteinfobl.Roominfo;
import businesslogicservice.strategyblservice.StrategyBLService;
import dataservice.strategydataservice.StrategyDataService;
import dataservice.strategydataservice.StrategyDataService_Stub;
import po.StrategyPO.HotelStrategyPO;
import po.StrategyPO.MarketingStrategyPO;
import po.StrategyPO.StrategyPO;
import vo.clientVO.ClientVO;
import vo.priceVO.PriceVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class StrategyManage implements StrategyBLService{

	private StrategyDataService strategyDataService=new StrategyDataService_Stub();
	@Override
	public ResultMessage addMarketingStrategy(MarketingStrategyVO vo) {

		return null;//null、、this.strategyDataService.addMarketingStrategy(po);
	}

	@Override
	public List<MarketingStrategyVO> getMarketingStrategy(String id) {
		return null;
	}

	@Override
	public ResultMessage deleteMarketingStrategy(String vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public boolean deletehotelStrategy(HotelStrategyVO vo) {
		return false;
	}

	@Override
	public List<HotelStrategyVO> getHotelStrategy(String hotelID) {
		return null;
	}

	@Override
	public ResultMessage updateHotelStrategy(HotelStrategyVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public PriceVO calculatePrice(ClientVO clientVO, Roominfo roomInfoVO, Hotelinfo hotelInfoVO, int num) {
		List<String> strategyUsed=new ArrayList<String>();
		List<StrategyPO> strategys=new ArrayList<StrategyPO>();
		double price=1;
		Strategy[] strategy=new Strategy[8];
		strategy[0]=new MarketingPeriod();
		strategy[1]=new MarketingSpecial();
		strategy[2]=new MarketingCreated();
		strategy[3]=new HotelBirthday();
		strategy[4]=new HotelCompany();
		strategy[5]=new HotelSpecialday();
		strategy[6]=new HotelOverThreeRooms();
		strategy[7]=new HotelCreated();
		try {
			strategys.addAll(this.strategyDataService.getHotelStrategy(hotelInfoVO.getHotelID()));
			strategys.addAll(this.strategyDataService.getMarketingStrategy());
		} catch (RemoteException e) {
			return null;//从数据库中调策略的时候出现故障
		}

		double tem;
		/*for(StrategyPO strt:strategys){//对读出来的策略遍历
			if(strt.getMakerType().equals(StrategyMaker.MARKTING)){//该策略是网站营销人员制定的
				if(((MarketingStrategyPO) strt).getMarketingStrategyType().equals(MarketingStrategy.PERIOD)){//特定时间促销策略
					tem=((MarketingPeriod) strategy[0]).calDis(strt);
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}else if(((MarketingStrategyPO) strt).getMarketingStrategyType().equals(MarketingStrategy.VIPSPECIAL)){
					tem=((MarketingSpecial) strategy[1]).calDis(strt,clientVO,hotelInfoVO);
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}else if(((MarketingStrategyPO) strt).getMarketingStrategyType().equals(MarketingStrategy.CREATED)){
					tem=((MarketingCreated) strategy[2]).calDis(strt,clientVO,hotelInfoVO.getName(),num,roomInfoVO.getPrice()*num);
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}
			}else if(strt.getMakerType().equals(StrategyMaker.HOTEL)){//该策略是酒店工作人员制定的
				if(((HotelStrategyPO) strt).getHotelStrategy().equals(HotelStrategy.BIRTHDAY)){//生日会员专属特惠
					tem=((HotelBirthday) strategy[3]).calDis(strt,clientVO,hotelInfoVO.getName());
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}else if(((HotelStrategyPO) strt).getHotelStrategy().equals(HotelStrategy.COMPANY)){//企业会员专属折扣
					tem=((HotelCompany) strategy[4]).calDis(strt,clientVO,hotelInfoVO.getName(),hotelInfoVO.getCompanyList());
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}else if(((HotelStrategyPO) strt).getHotelStrategy().equals(HotelStrategy.SPECIALDAY)){
					tem=strategy[5].calDis(strt,clientVO,hotelInfoVO.getName());
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}else if(((HotelStrategyPO) strt).getHotelStrategy().equals(HotelStrategy.OVERTHREEROOMS)){
					tem=strategy[6].calDis(strt,clientVO,hotelInfoVO.getName());
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}else if(((HotelStrategyPO) strt).getHotelStrategy().equals(HotelStrategy.CREATED)){
					tem=strategy[7].calDis(strt,clientVO,hotelInfoVO,num);
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}
			}
		}
*/
		price=price*roomInfoVO.getPrice()*num;
		return new PriceVO(price,strategyUsed);
	}



}
