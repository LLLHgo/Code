package impl.mysql;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Enum.MarketingStrategy;
import Enum.VIPType;
import dataservice.strategydataservice.StrategyDataService;
import initial.DataBaseInit;
import po.LevelPO;
import po.StrategyPO.HotelStrategyPO;
import po.StrategyPO.MarketingCreatedPO;
import po.StrategyPO.MarketingPeriodPO;
import po.StrategyPO.MarketingSpecialPO;
import po.StrategyPO.MarketingStrategyPO;
import po.StrategyPO.StrategyPO;

public class StrategyDataServiceMySqlImpl extends UnicastRemoteObject implements StrategyDataService{
	public StrategyDataServiceMySqlImpl() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	public boolean addMarketingStrategy(MarketingStrategyPO po) throws RemoteException {
		Connection conn=DataBaseInit.getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String start=sdf.format(po.getStartTime().getTime());
		String end=sdf.format(po.getEndTime().getTime());
		Statement stmt;
		try{
			stmt=conn.createStatement();
			String sql="";
			if(po.getMarketingStrategyType().equals(MarketingStrategy.PERIOD))
				sql="INSERT INTO MarketingStrategy(name,type,starttime,endtime,discount)VALUES('"+po.getName()+"','"+po.getMarketingStrategyType()+"','"+start+"','"+end+"','"+((MarketingPeriodPO)po).getDiscount()+"')";
			else if(po.getMarketingStrategyType().equals(MarketingStrategy.VIPSPECIAL)){
				MarketingSpecialPO sp=(MarketingSpecialPO)po;
				String levels="";
				String discounts="";
				for(int l:sp.getLevels()){
					levels=levels+l+"-";
				}
				for(double d:sp.getDiscounts()){
					discounts=discounts+d+"-";
				}
				sql="INSERT INTO MarketingStrategy(name,type,starttime,endtime,area,levels,discounts)VALUES('"+po.getName()+"','"+po.getMarketingStrategyType()+"','"+start+"','"+end+"','"+sp.getBusinessDistrict()+"','"+levels+"','"+discounts+"')";

			}else if(po.getMarketingStrategyType().equals(MarketingStrategy.CREATED)){
				MarketingCreatedPO cp=(MarketingCreatedPO)po;
				String hotels="";
				for(String h:cp.getHotels()){
					hotels=hotels+h+"-";
				}
				String viptypes="";
				for(VIPType v:cp.getViptypes()){
					viptypes=viptypes+v+"-";
				}
				sql="INSERT INTO MarketingStrategy(name,type,starttime,endtime,discount,hotels,minSum,minRooms,minLevel,viptypes)VALUES('"+po.getName()+"','"+po.getMarketingStrategyType()+"','"+start+"','"+end+"','"+cp.getDiscount()+"','"+hotels+"','"+cp.getMinSum()+"','"+cp.getMinRooms()+"','"+cp.getLevels()+"','"+viptypes+"')";
			}else
				return false;
			int rs = stmt.executeUpdate(sql);
			if(rs>0)
				return true;
			else
				return false;

		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			return false;
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			return false;
		}
	}

	public List<StrategyPO> getMarketingStrategy() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteMarketingStrategy(String marketingStrategy) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public List<StrategyPO> getHotelStrategy(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateHotelStrategy(HotelStrategyPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}























