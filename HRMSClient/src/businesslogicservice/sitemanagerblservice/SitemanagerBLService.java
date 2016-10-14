package businesslogicservice.sitemanagerblservice;

import po.ResultMessage;
import vo.clientVO.ClientAccountVO;
import vo.clientVO.ClientVO;
import vo.MarketingVO;
import vo.HotelinfoVO;
import vo.HotelstaffBasicinfoVO;

public interface SitemanagerBLService {
	public ResultMessage clientAccountUpdate (ClientAccountVO clientId);
	public ResultMessage clientAccountDelete (String clientId);
	public ClientVO clientAccountFind (String findInfo);
	public ResultMessage MarketingAccountAdd (MarketingVO marketing);
	public ResultMessage MarketingAccountUpdate (String marketingId);
	public ResultMessage MarketingAccountDelete (String marketingId);
	public MarketingVO MarketingAccountFind (String findInfo);
	public ResultMessage MarketingAccountAdd (HotelinfoVO hotelinfo);
	public HotelstaffBasicinfoVO HotelStuffAccountFind(String hotelId);
	
	
}
