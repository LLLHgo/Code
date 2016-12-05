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
	ClientDataService clientService;
	HotelstaffDataService hotelstaffService;
	HotelinfoDataService hotelinfoService;
	LogDataService logService;
	MarketingDataService marketingService;
	OrderDataService orderService;
	SitemanagerDataService siteManagerService;
	StrategyDataService strategyService;
	
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	private RemoteHelper() {
	}
	
	public void init(){
		String host = "rmi://127.0.0.1:8888/";
		try {
			clientService = (ClientDataService) Naming.lookup(host+"ClientService");
			hotelstaffService = (HotelstaffDataService) Naming.lookup(host+"HotelstaffService");
			hotelinfoService = (HotelinfoDataService) Naming.lookup(host+"HotelinfoService");
			logService = (LogDataService) Naming.lookup(host+"LogService");
			marketingService = (MarketingDataService) Naming.lookup(host+"MarketingService");
			orderService = (OrderDataService) Naming.lookup(host+"OrderService");
			siteManagerService = (SitemanagerDataService) Naming.lookup(host+"SitemanagerService");
			strategyService = (StrategyDataService) Naming.lookup(host+"StrategyService");
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
	
	public ClientDataService clientDataService(){
		return (ClientDataService)remote;
	}
	
	public HotelstaffDataService hotelstaffDataService(){
		return (HotelstaffDataService)remote;
	}
	
	public HotelinfoDataService hotelinfoDataService(){
		return (HotelinfoDataService)remote;
	}
	
	public MarketingDataService marketingDataService(){
		return (MarketingDataService)remote;
	}
	
	public StrategyDataService strategyDataService(){
		return (StrategyDataService)remote;
	}
	
	
		

}
