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

import Enum.ResultMessage;
import businesslogicservice.hotelinfoblservice.RoominfoBLService;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService_Stub;
import po.RoominfoPO;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class RoominfoManage implements RoominfoBLService{
	
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
	public double calculatePrice(ArrayList<HotelStrategyVO> hotelStrategylist,
			ArrayList<MarketingStrategyVO> marketingStrategyList, ClientVO vo, double originalPrice) {
		// TODO Auto-generated method stub
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
