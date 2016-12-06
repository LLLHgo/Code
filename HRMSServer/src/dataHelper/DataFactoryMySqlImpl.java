package dataHelper;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Enum.ResultMessage;
import dataservice.clientdataservice.ClientDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelstaffdataservice.HotelstaffDataService;
import dataservice.marketingdataservice.MarketingDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.sitemanagerdataservice.SitemanagerDataService;
import dataservice.strategydataservice.StrategyDataService;
import impl.mysql.ClientDataServiceMySqlImpl;
import impl.mysql.HotelinfoDataServiceImpl;
import impl.mysql.HotelinfoDataServiceMySqlImpl;
import impl.mysql.HotelstaffDataServiceMySqlImpl;
import impl.mysql.MarketingDataServiceMySqlImpl;
import impl.mysql.OrderDataServiceMySqlImpl;
import impl.mysql.SitemanagerDataServiceMySqlImpl;
import impl.mysql.StrategyDataServiceMySqlImpl;

//public class DataFactoryMySqlImpl extends UnicastRemoteObject implements DataFactory{
public class DataFactoryMySqlImpl extends AdapterSql implements DataFactory{
	
	ClientDataService clientDataService;
	HotelstaffDataService hotelstaffDataService;
	HotelinfoDataService hotelinfoDataService;
	MarketingDataService marketingDataService;
	OrderDataService orderDataService;
	SitemanagerDataService sitemanagerDataService;
	StrategyDataService strategyDataService;

	public DataFactoryMySqlImpl() throws RemoteException {
		super();
		//this.conn = DataBaseInit.getConnection();
		
		clientDataService=new ClientDataServiceMySqlImpl();
		hotelstaffDataService=new HotelstaffDataServiceMySqlImpl();
		hotelinfoDataService=new HotelinfoDataServiceImpl();
		marketingDataService=new MarketingDataServiceMySqlImpl();
		orderDataService=new OrderDataServiceMySqlImpl();
		sitemanagerDataService=new SitemanagerDataServiceMySqlImpl();
		strategyDataService=new StrategyDataServiceMySqlImpl();
		
	}
	
	/**
	 * 执行语句并返回执行结果
	 * @param tempPreState
	 * @return
	 */
	// 这里感觉用ResultSet更好诶
	public ResultMessage getDoResult(PreparedStatement tempPreState){
		try {
			if(tempPreState.execute()){
				return ResultMessage.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public ClientDataService getClientDatabase() {
		// TODO Auto-generated method stub
		return clientDataService;
	}

	public HotelinfoDataService getHotelinfoDataBase() {
		// TODO Auto-generated method stub
		return hotelinfoDataService;
	}

	public HotelstaffDataService getHotelstaffDataBase() {
		// TODO Auto-generated method stub
		return hotelstaffDataService;
	}

	public MarketingDataService getMarketingDataService() {
		// TODO Auto-generated method stub
		return marketingDataService;
	}

	public SitemanagerDataService getSitemanagerDataService() {
		// TODO Auto-generated method stub
		return sitemanagerDataService;
	}


	public OrderDataService getLogDataservice() {
		// TODO Auto-generated method stub
		return orderDataService;
	}

	public StrategyDataService getStrategyDataService() {
		// TODO Auto-generated method stub
		return strategyDataService;
	}


}
