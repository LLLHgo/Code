package data.hotelstaffdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.hotelstaffdataservice.HotelstaffDataService;
import po.HotelstaffPO;

public class HotelStaffData extends UnicastRemoteObject implements HotelstaffDataService{

	public HotelStaffData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HotelstaffPO findBasicInfo(String hotelStaffID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePassword(HotelstaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkAccount(HotelstaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
