package businesslogic.hoteinfobl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Enum.ResultMessage;
import businesslogicservice.hotelinfoblservice.HotelinfoAbstract;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService_Stub;
import po.RoominfoPO;
import vo.areaVO.AreaVO;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class RoominfoManage extends HotelinfoAbstract{
	
	HotelinfoDataService data;
	
	public RoominfoManage(){
		data = new HotelinfoDataService_Stub();
	}
	
	@Override
	public RoominfoVO getroominfo(String hotelID, String roomID) {
		RoominfoPO po = null;
		try {
			po = data.getRoominfo(hotelID, roomID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(po==null){
			return null;
		}
		return po2vo(po);
	}

	@Override
	public boolean updateroominfo(RoominfoVO vo,String hotelID) {
		RoominfoPO po = new RoominfoPO(
				vo.getType(),vo.getRoomNum(),vo.getPrice(),vo.getRoomState());
		try {
			data.updateroominfo(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		
		return false;
	}
	
	@Override
	public double calculatePrice(ArrayList<HotelStrategyVO> hotelStrategyList,
			ArrayList<MarketingStrategyVO> marketingStrategyList, ClientVO vo, double originalPrice) {
		//获得当前时间
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		String time = year+month+day+hour+minute+second+"";
		cal.set(year, month, day, hour, minute, second);
		
		double discount = 1;
		ArrayList<String> strategyName = new ArrayList<String>();
	
		for(HotelStrategyVO hotelStrategy:hotelStrategyList){
		//TODO
			if(vo.getType()==hotelStrategy.getViptype()&&
					cal.compareTo(hotelStrategy.getEndTime())<0&&
					cal.compareTo(hotelStrategy.getStartTime())>0&&
					(vo.getLevel()>hotelStrategy.getLevel()||vo.getLevel()==hotelStrategy.getLevel())
					){
				discount = discount*hotelStrategy.getDiscount();
				strategyName.add(hotelStrategy.getName());
			}
		}
		
		for(HotelStrategyVO hotelStrategy:hotelStrategyList){
			if(vo.getType()==hotelStrategy.getViptype()){
				discount = discount*hotelStrategy.getDiscount();
				strategyName.add(hotelStrategy.getName());
			}
		}
		return 0;
	}

	@Override
	public String[] getRoomType() {
		BufferedReader br = null;
		String data = "";
		String[] roomtypes = null;
		try {
			br = new BufferedReader(new FileReader(new File("./src/main/resource/txt/RoomType.txt")));
			while((data = br.readLine())!=null)
			{
				roomtypes = data.split(",");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return roomtypes;
	}

	@Override
	public boolean addRoomType(String type) {
		String[] roomtypes = getRoomType();
		int flag = 0;
		for(int i=0;i<roomtypes.length;i++){
			if(type.equals(roomtypes[i])){
				flag = 1;
			}
		}
		if(flag == 1){
			return false;
		}
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(
					new File("./src/main/resource/txt/RoomType.txt"),true));
			bw.write(","+type);	
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	@Override
	public ArrayList<RoominfoVO> getRoominfoList(String hotelID) {
		ArrayList<RoominfoPO> listPO;
		ArrayList<RoominfoVO> listVO = new ArrayList<RoominfoVO>();
		try {
			listPO = data.getRoominfoList(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		for(int i=0;i<listPO.size();i++){
			listVO.add(po2vo(listPO.get(i)));
		}
		return listVO;
	}


	private RoominfoVO po2vo(RoominfoPO po){
		RoominfoVO vo;
		try{
			vo = new RoominfoVO(po.getType(),po.getRoomNum(),
					po.getPrice(),po.getRoomState());
		}catch(NullPointerException e){
			e.printStackTrace();
			return null;
		}
		return vo;
	}
}
