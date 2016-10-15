package dataservice.hotelinfodataservice;

import java.rmi.RemoteException;

import po.HotelinfoPO;
import po.HotelstaffPO;
import po.RoominfoPO;

public class HotelinfoDataService_Driver {
	public void drive(HotelinfoDataService hotelstaffDataService){
		try {
			hotelstaffDataService.init();
			hotelstaffDataService.delete(new RoominfoPO());
			hotelstaffDataService.findhotelinfo("H0000000");
			hotelstaffDataService.getRoominfoList("H0000000");
			hotelstaffDataService.updatehotelinfo(new HotelinfoPO());
			hotelstaffDataService.updateroominfo(new RoominfoPO());
			hotelstaffDataService.finish();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
}
