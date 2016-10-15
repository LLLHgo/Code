package dataservice.hotelstaffdataservice;

import java.rmi.RemoteException;

import dataservice.hotelinfodataservice.HotelinfoDataService;
import po.HotelinfoPO;
import po.HotelstaffPO;
import po.RoominfoPO;

public class HotelstaffDataService_Stub implements HotelstaffDataService{

	HotelstaffPO hotelstaffPO;
	
	@Override
	public void init() throws RemoteException {
		hotelstaffPO = new HotelstaffPO("H00000000","000000");
	}

	@Override
	public HotelstaffPO findBasicInfo(String hotelStaffID) {
		return hotelstaffPO;
	}

	@Override
	public void updatePassword(HotelstaffPO po) throws RemoteException {
		System.out.println("已向数据库更新密码");
	}

	@Override
	public boolean checkAccount(HotelstaffPO po) throws RemoteException {
		return true;
	}

	@Override
	public void finish() throws RemoteException {
		
	}
	
}
