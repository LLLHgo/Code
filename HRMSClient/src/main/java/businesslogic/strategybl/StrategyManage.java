package businesslogic.strategybl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Enum.HotelStrategy;
import Enum.MarketingStrategy;
import Enum.ResultMessage;
import Enum.StrategyMaker;
import Enum.VIPType;
import businesslogicservice.strategyblservice.StrategyBLService;
import dataservice.strategydataservice.StrategyDataService;
import dataservice.strategydataservice.StrategyDataService_Stub;
import po.StrategyPO.HotelCompanyPO;
import po.StrategyPO.HotelStrategyPO;
import po.StrategyPO.MarketingCreatedPO;
import po.StrategyPO.MarketingPeriodPO;
import po.StrategyPO.MarketingSpecialPO;
import po.StrategyPO.MarketingStrategyPO;
import po.StrategyPO.StrategyPO;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.priceVO.PriceVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class StrategyManage implements StrategyBLService{

	private StrategyDataService strategyDataService=new StrategyDataService_Stub();
	@Override
	public ResultMessage addMarketingStrategy(MarketingStrategyVO vo) {
		MarketingStrategyPO po=vo2po(vo);
		try {
			if(this.strategyDataService.addMarketingStrategy(po))
				return ResultMessage.SUCCESS;
			else
				return ResultMessage.FAIL;
		} catch (RemoteException e) {
			return ResultMessage.FAIL;
		}
	}

	@Override
	public List<MarketingStrategyVO> getMarketingStrategy() {
		List<StrategyPO> pos;
		try {
			pos=this.strategyDataService.getMarketingStrategy();
		} catch (RemoteException e) {
			return null;
		}
		List<MarketingStrategyVO> vos=new ArrayList<MarketingStrategyVO>();
		for(StrategyPO po:pos){
			MarketingStrategyVO vo = po2vo((MarketingStrategyPO) po);
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public ResultMessage deleteMarketingStrategy(String vo) {
		try {
			if(this.strategyDataService.deleteMarketingStrategy(vo))
				return ResultMessage.SUCCESS;//删除成功
			else
				return ResultMessage.FAIL;//删除失败
		} catch (RemoteException e) {
			return ResultMessage.FAULT;//删除出现故障
		}
	}

	@Override
	public List<HotelStrategyVO> getHotelStrategy(String hotelID) {
		List<StrategyPO> pos;
		List<HotelStrategyVO> vos = null;
		try {
			pos=this.strategyDataService.getHotelStrategy(hotelID);
		} catch (RemoteException e) {
			return null;
		}
		for(StrategyPO po:pos){
			vos.add(Hpo2vo((HotelStrategyPO) po));
		}
		return vos;
	}

	@Override
	public ResultMessage updateHotelStrategy(HotelStrategyVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public PriceVO calculatePrice(ClientVO clientVO, RoominfoVO roomInfoVO, HotelinfoVO hotelInfoVO, int num) {
		List<String> strategyUsed=new ArrayList<String>();
		List<StrategyPO> strategys=new ArrayList<StrategyPO>();
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

		double tem,price=1;
		for(StrategyPO strt:strategys){//对读出来的策略遍历
			if(strt.getMakerType().equals(StrategyMaker.MARKTING)){//该策略是网站营销人员制定的
				if(((MarketingStrategyPO) strt).getMarketingStrategyType().equals(MarketingStrategy.PERIOD)){//特定时间促销策略
					tem=((MarketingPeriod) strategy[0]).calDis(strt);
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}else if(((MarketingStrategyPO) strt).getMarketingStrategyType().equals(MarketingStrategy.VIPSPECIAL)){//专属商圈
					tem=((MarketingSpecial) strategy[1]).calDis(strt,clientVO,hotelInfoVO);
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}else if(((MarketingStrategyPO) strt).getMarketingStrategyType().equals(MarketingStrategy.CREATED)){//新增策略
					tem=((MarketingCreated) strategy[2]).calDis(strt,clientVO,hotelInfoVO.getName(),num,roomInfoVO.getPrice()*num);
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}
			}else if(strt.getMakerType().equals(StrategyMaker.HOTEL)){//该策略是酒店工作人员制定的
				if(((HotelStrategyPO) strt).getHotelStrategy().equals(HotelStrategy.BIRTHDAY)){//生日会员专属特惠
					tem=((HotelBirthday) strategy[3]).calDis(strt,clientVO,hotelInfoVO.getHotelID());
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}else if(((HotelStrategyPO) strt).getHotelStrategy().equals(HotelStrategy.COMPANY)){//企业会员专属折扣
					tem=((HotelCompany) strategy[4]).calDis(strt,clientVO,hotelInfoVO.getHotelID());
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}else if(((HotelStrategyPO) strt).getHotelStrategy().equals(HotelStrategy.SPECIALDAY)){//特定日期专属折扣
					tem=((HotelSpecialday) strategy[5]).calDis(strt,hotelInfoVO.getHotelID());
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}else if(((HotelStrategyPO) strt).getHotelStrategy().equals(HotelStrategy.OVERTHREEROOMS)){//超过或等于三间
					tem=((HotelOverThreeRooms) strategy[6]).calDis(strt,hotelInfoVO.getHotelID(),num);
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}else if(((HotelStrategyPO) strt).getHotelStrategy().equals(HotelStrategy.CREATED)){//新增促销策略
					tem=((HotelCreated) strategy[7]).calDis(strt,clientVO,hotelInfoVO,num,roomInfoVO.getPrice()*num);
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}
			}
		}

		price=price*roomInfoVO.getPrice()*num;
		return new PriceVO(price,strategyUsed);
	}

	private MarketingStrategyPO vo2po(MarketingStrategyVO vo){
		MarketingStrategyPO po = null;
		if(vo.getType().equals(MarketingStrategy.PERIOD))
			po=new MarketingPeriodPO(vo.getName(),vo.getStartTime(),vo.getEndTime(),vo.getDiscount());
		else if(vo.getType().equals(MarketingStrategy.VIPSPECIAL))
			po=new MarketingSpecialPO(vo.getName(),vo.getStartTime(),vo.getEndTime(),vo.getBusinessDistrict(),
					vo.getLevels(),vo.getDiscounts());
		else if(vo.getType().equals(MarketingStrategy.CREATED))
			po=new MarketingCreatedPO(vo.getName(),vo.getStartTime(),vo.getEndTime(),vo.getDiscount(),
					vo.getHotels(),vo.getMinSum(),vo.getMinRooms(),vo.getMinLevel(),vo.getVipKinds());
		return po;
	}

	private MarketingStrategyVO po2vo(MarketingStrategyPO po){
		MarketingStrategyVO vo = null;
		if(po.getMarketingStrategyType().equals(MarketingStrategy.PERIOD))
			vo=new MarketingStrategyVO(po.getName(),MarketingStrategy.PERIOD,po.getStartTime(),po.getEndTime(),((MarketingPeriodPO) po).getDiscount());
		else if(po.getMarketingStrategyType().equals(MarketingStrategy.VIPSPECIAL))
			vo=new MarketingStrategyVO(po.getName(),MarketingStrategy.VIPSPECIAL,po.getStartTime(),po.getEndTime(),
					((MarketingSpecialPO) po).getBusinessDistrict(),((MarketingSpecialPO) po).getLevels(),((MarketingSpecialPO) po).getDiscounts());
		else if(po.getMarketingStrategyType().equals(MarketingStrategy.CREATED))
			vo=new MarketingStrategyVO(po.getName(),MarketingStrategy.CREATED,po.getStartTime(),po.getEndTime(),((MarketingCreatedPO) po).getDiscount(),
					((MarketingCreatedPO) po).getHotels(),((MarketingCreatedPO) po).getMinSum(),((MarketingCreatedPO) po).getMinRooms(),
					((MarketingCreatedPO) po).getLevels(),((MarketingCreatedPO) po).getViptypes());
		return vo;
	}


	private HotelStrategyVO Hpo2vo(HotelStrategyPO po){
		HotelStrategyVO vo=null;
		if(po.getHotelStrategy().equals(HotelStrategy.BIRTHDAY))
			vo=new HotelStrategyVO(po.getName(),po.getHotelID(),HotelStrategy.BIRTHDAY,po.getStartTime(),po.getEndTime(),po.getDiscount());
		else if(po.getHotelStrategy().equals(HotelStrategy.COMPANY))
			//vo=new HotelStrategyVO(po.getName(),po.getHotelID(),HotelStrategy.COMPANY,po.getStartTime(),po.getEndTime(),);
		;else if(po.getHotelStrategy().equals(HotelStrategy.SPECIALDAY))
			vo=new HotelStrategyVO();
		else if(po.getHotelStrategy().equals(HotelStrategy.OVERTHREEROOMS))
			vo=new HotelStrategyVO();
		else if(po.getHotelStrategy().equals(HotelStrategy.CREATED))
			vo=new HotelStrategyVO();
		return vo;
	}

}
/*HotelStrategyVO(String name,String hotelID,HotelStrategy type,VIPType viptype,Calendar startTime,Calendar endTime,double discount)
 *(String name,String hotelID,ArrayList<String> companyList,HotelStrategy type,VIPType viptype,Calendar startTime,Calendar endTime,double discount)
 *(String name,String hotelID,HotelStrategy type,Calendar startTime,Calendar endTime,double discount){

 *(String name,String hotelID,HotelStrategy type,Calendar startTime,Calendar endTime,double discount,
    		int minRooms){
 *(String name,String hotelID,HotelStrategy type,List<VIPType> vipKinds,Calendar startTime,Calendar endTime,double discount,
    		int minRooms,int minSum,int level)
 *
 *
 *
 * MarketingStrategyVO(String name,MarketingStrategy type,Calendar startTime,
Calendar endTime,double discount)
 * (String name,MarketingStrategy type,Calendar startTime,
Calendar endTime,String businessDistrict,int[] levels,double[] discounts)
 * (String name,MarketingStrategy type,Calendar startTime,Calendar endTime,double discount,List<String> hotels,
double minSum,int minRooms,int levels,List<VIPType> viptypes)
 *
 * */
