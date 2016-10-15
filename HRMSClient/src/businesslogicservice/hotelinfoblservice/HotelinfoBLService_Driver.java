package businesslogicservice.hotelinfoblservice;

import java.util.ArrayList;
import java.util.List;

import Enum.ResultMessage;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class HotelinfoBLService_Driver{

	public void drive(HotelinfoBLService hotelinfoBLService){
		hotelinfoBLService.getBasicinfo("H00000000");
		hotelinfoBLService.getBasicinfoList(new ClientRequirementVO());
		hotelinfoBLService.getRoominfo("H00000000", "四人间");
		hotelinfoBLService.getRoominfoList("H00000000");
		hotelinfoBLService.updateBassicinfo(new HotelinfoVO());
		hotelinfoBLService.saveSitemanagerAdd(new HotelinfoVO());
		hotelinfoBLService.calculatePrice(new ArrayList<HotelStrategyVO>(), new ArrayList<MarketingStrategyVO>(),
				new ClientVO(), 666.6);
		
	}

}
