package businesslogic.hoteinfobl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import dataservice.hotelinfodataservice.HotelinfoDataService_Stub;
import po.HotelinfoPO;
import po.RoominfoPO;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class HotelinfoManage implements HotelinfoBLService{

	//桩测试
	HotelinfoDataService_Stub data;
	HotelinfoPO po;
	HotelinfoVO vo;
	
	@Override
	public HotelinfoVO getBasicinfo(String hotelID) {
		try {
			po = data.findhotelinfo(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		vo = new HotelinfoVO(po.getAddress(),po.getArea(),po.getIntroduction(),
				po.getFacility(),po.getTel(),po.getStar(),po.getHotelID());
		return vo;
	}

	@Override
	public List<HotelinfoVO> getBasicinfoList(ClientRequirementVO clientvo) {
		List<HotelinfoPO> listPO;
		List<HotelinfoVO> listVO = new ArrayList<HotelinfoVO>();
		try {
			listPO = data.findHotelinfoList(clientvo.getArea());
			for(int i=0;i<listPO.size();i++){
				vo = PO2VO(listPO.get(i));
				if(vo == null){
					return null;
				}
				listVO.add(vo);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		return listVO;
		
	}

	private HotelinfoVO PO2VO(HotelinfoPO po){
		try{
			HotelinfoVO vo = new HotelinfoVO(po.getName(),po.getAddress(),po.getArea(),
			po.getTel(),null,po.getStar(),po.getRemark(),po.getIntroduction(),
			po.getHotelID());
		}catch(NullPointerException e){
			e.printStackTrace();
			return null;
		}
		return vo;
	}
	
	@Override
	public ResultMessage updateBassicinfo(HotelinfoVO VO) {
		boolean result = false;
		try {
			result = data.updatehotelinfo(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTEEXCEPTION;
		}
		if(result == true)
			return ResultMessage.SUCCESS;
		else return ResultMessage.FAIL;
			
	}

	@Override
	public RoominfoVO getRoominfo(String hotelID, String roomID) {
		//TODO
		//增加了一个直接从数据库里找某个房间信息的方法，不知道是不是合适
//		RoominfoPO po;
//		RoominfoVO vo;
//		try {
//			po = data.getRoominfo(hotelID, roomID);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			return null;
//		}
		return null;
	}

	@Override
	public List<RoominfoVO> getRoominfoList(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculatePrice(List<HotelStrategyVO> hotelStrategylist,
			List<MarketingStrategyVO> marketingStrategyList, ClientVO vo, double originalPrice) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public HotelinfoVO gethotelinfoVO(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoominfoVO getroominfo(String hotelID, String roomID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateroominfo(RoominfoVO vo,String hotelID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultMessage saveSitemanagerAdd(SitemanagerAddVO sitemanagerAddVO, HotelstaffVO hotelstaffVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public String[] getArea() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addArea(String area) {
		//TODO 序列化保存
		return true;
	}
}
