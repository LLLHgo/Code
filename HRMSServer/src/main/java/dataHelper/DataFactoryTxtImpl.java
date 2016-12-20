package dataHelper;

import java.rmi.RemoteException;

import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.logdataservice.LogDataService;
import impl.hotelinfo.HotelinfoDataServiceImpl;
import impl.txt.LogDataServiceTxtImpl;

public class DataFactoryTxtImpl extends AdapterTxt implements DataFactory{

	HotelinfoDataService hotelinfoDataService;
	
	public DataFactoryTxtImpl() throws RemoteException{
		 hotelinfoDataService=new HotelinfoDataServiceImpl();
	}

	@Override
	public HotelinfoDataService getHotelinfoDataBase() {
		// TODO Auto-generated method stub
		return hotelinfoDataService;
	}

}
