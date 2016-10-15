package dataservice.hotelstaffdataservice;

import java.rmi.RemoteException;

import po.HotelstaffPO;

public class HotelstaffDataService_Driver {
	public void drive(HotelstaffDataService hotelstaffDataService) throws RemoteException{
		hotelstaffDataService.init();
		hotelstaffDataService.checkAccount(new HotelstaffPO());
		hotelstaffDataService.findBasicInfo("H00000000");
		hotelstaffDataService.updatePassword(new HotelstaffPO());
		hotelstaffDataService.finish();
	}
}
