package businesslogic.hotelstaffbl;

import java.rmi.Naming;
import java.rmi.RemoteException;

import Enum.ResultMessage;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import dataservice.hotelstaffdataservice.HotelstaffDataService;
import dataservice.hotelstaffdataservice.HotelstaffDataService_Stub;
import po.HotelstaffPO;
import vo.hotelstaffVO.HotelstaffVO;

public class HotelstaffManage implements HotelstaffBLService{
	//桩测试
	HotelstaffDataService_Stub data = new HotelstaffDataService_Stub();
	HotelstaffPO po;
	HotelstaffVO vo;
	
	@Override
	public String getBasicinfo(String hotelID) {
		if(data.findBasicInfo(hotelID)==null){
			return null;
		}
		String password = data.findBasicInfo(hotelID).getPassword();
		return password;
	}

	@Override
	public ResultMessage setPassword(String hotelID, String password) {
		po = new HotelstaffPO();
		po.setHotelID(hotelID);
		po.setPassword(password);
		boolean result = false;
		try {
			result = data.update(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTEEXCEPTION;
		}
		if(result==true){
			return ResultMessage.SUCCESS;
		}else{
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage saveSitemanagerUpdate(HotelstaffVO vo) {
		po = new HotelstaffPO(vo.getHotelID(),vo.getPassword(),vo.getTel());
		boolean result = false;
		try {
			result = data.update(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTEEXCEPTION;
		}
		if(result==true){
			return ResultMessage.SUCCESS;
		}else{
			return ResultMessage.FAIL;
		}
	}

	@Override
	public HotelstaffVO returnSitemanagerAccount(String hotelID) {
		po = data.findBasicInfo(hotelID);
		if(po == null){
			return null;
		}
		vo = new HotelstaffVO(po.getHotelID(),po.getPassword(),po.getTel());
		return vo;
	}

	//TODO
	@Override
	public boolean checkAccount(String hotelID, String password) {
		po = new HotelstaffPO(hotelID,password);
		boolean result = false;
		try {
			result = data.checkAccount(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return result;
	}

}
