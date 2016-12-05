package businesslogicservice.strategyblservice;

import java.util.List;

import Enum.ResultMessage;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class StrategyBLService_Driver {
    public void drive(StrategyBLService strategyBLService){
    	//增加网站营销人员促销策略信息
    	MarketingStrategyVO Mvo=new MarketingStrategyVO();
    	ResultMessage  addMarketingStrategyBool=strategyBLService.addMarketingStrategy(Mvo);
    	if(addMarketingStrategyBool==ResultMessage.SUCCESS)System.out.println("增加网站营销人员促销策略信息成功。");

    	//返回网站营销人员制定的促销策略信息列表
    	List<MarketingStrategyVO> marketingStrategyList=strategyBLService.getMarketingStrategy("M00010001");
    	if(marketingStrategyList.size()>0)System.out.println("返回网站营销人员制定的促销策略信息列表成功。");

    	//删除网站营销人员促销策略信息
    	ResultMessage deleteMarketingStrategy=strategyBLService.deleteMarketingStrategy("双11促销");
    	if(deleteMarketingStrategy==ResultMessage.SUCCESS)System.out.println("删除网站营销人员促销策略信息成功。");

    	//返回酒店工作人员制定的促销策略信息列表
    	List<HotelStrategyVO> hotelStrategyList=strategyBLService.getHotelStrategy("凯撒饭店");
    	if(hotelStrategyList.size()>0)System.out.println("返回酒店工作人员制定的促销策略信息列表成功。");

    	//更新酒店工作人员促销策略信息
    	HotelStrategyVO Hvo=new HotelStrategyVO();
    	ResultMessage updateHotelStrategyBool=strategyBLService.updateHotelStrategy(Hvo);
    	if(updateHotelStrategyBool==ResultMessage.SUCCESS)System.out.println("更新酒店工作人员促销策略信息成功。");


    }
}
