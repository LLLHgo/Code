package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.clientdataservice.ClientDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelstaffdataservice.HotelstaffDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.marketingdataservice.MarketingDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.sitemanagerdataservice.SitemanagerDataService;
import dataservice.strategydataservice.StrategyDataService;

public class RemoteHelper {
	private Remote remote;
	private static RemoteHelper remoteHelper = new RemoteHelper();
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	private RemoteHelper() {
	}
	
	public void init(){
		String host = "rmi://127.0.0.1:8888/";
		try {
			ClientDataService clientService = (ClientDataService) Naming.lookup(host+"ClientService");
			HotelstaffDataService hotelstaffService = (HotelstaffDataService) Naming.lookup(host+"HotelstaffService");
			HotelinfoDataService hotelinfoService = (HotelinfoDataService) Naming.lookup(host+"HotelinfoService");
			LogDataService logService = (LogDataService) Naming.lookup(host+"LogService");
			MarketingDataService marketingService = (MarketingDataService) Naming.lookup(host+"MarketingService");
			OrderDataService orderService = (OrderDataService) Naming.lookup(host+"OrderService");
			SitemanagerDataService siteManagerService = (SitemanagerDataService) Naming.lookup(host+"SitemanagerService");
			StrategyDataService strategyService = (StrategyDataService) Naming.lookup(host+"StrategyService");
			//TODO
			System.out.println("Client is running...");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public SitemanagerDataService getSitemanagerDataService(){
		return (SitemanagerDataService)remote;
	}
	
	public OrderDataService getOrderDataService(){
		return (OrderDataService)remote;
	}
	
	public LogDataService logDataService(){
		return (LogDataService)remote;
	} 
		

}
