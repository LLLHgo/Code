package businesslogic.hoteinfobl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService_Stub;
import po.HotelinfoPO;
import po.RoominfoPO;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class HotelinfoManage implements HotelinfoBLService{

	//桩测试
	HotelinfoDataService data = new HotelinfoDataService_Stub();
	HotelinfoPO po;
	HotelinfoVO vo;
	
	@Override
	public HotelinfoVO getBasicinfo(String hotelID) {
		try {
			po = data.findhotelinfo(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		if(po == null){
			return null;
		}
		vo = new HotelinfoVO(po.getAddress(),po.getArea(),po.getIntroduction(),
				po.getFacility(),po.getTel(),po.getStar(),po.getHotelID());
		return vo;
	}

	@Override
	public ArrayList<HotelinfoVO> getBasicinfoList(ClientRequirementVO clientvo) {
		ArrayList<HotelinfoPO> listPO;
		ArrayList<HotelinfoVO> listVO = new ArrayList<HotelinfoVO>();
		try {
			listPO = data.findHotelinfoList(clientvo.getArea());
			for(int i=0;i<listPO.size();i++){
				vo = PO2VO(listPO.get(i));
				if(vo == null){
					return null;
				}
				listVO.add(vo);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		return listVO;
		
	}

	private HotelinfoVO PO2VO(HotelinfoPO po){
		try{
			HotelinfoVO vo = new HotelinfoVO(po.getName(),po.getAddress(),po.getArea(),
			po.getTel(),null,po.getStar(),po.getRemark(),po.getIntroduction(),
			po.getHotelID());
		}catch(NullPointerException e){
			e.printStackTrace();
			return null;
		}
		return vo;
	}
	
	@Override
	public ResultMessage updateBassicinfo(HotelinfoVO VO) {
		boolean result = false;
		try {
			result = data.updatehotelinfo(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTEEXCEPTION;
		}
		if(result == true)
			return ResultMessage.SUCCESS;
		else return ResultMessage.FAIL;
			
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
	
	@Override
	public double calculatePrice(ArrayList<HotelStrategyVO> hotelStrategylist,
			ArrayList<MarketingStrategyVO> marketingStrategyList, ClientVO vo, double originalPrice) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public HotelinfoVO gethotelinfoVO(String hotelID) {
		HotelinfoPO po = null;
		try {
			po = data.findhotelinfo(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(po==null){
			return null;
		}
		return PO2VO(po);
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
	public ResultMessage saveSitemanagerAdd(SitemanagerAddVO sitemanagerAddVO, HotelstaffVO hotelstaffVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public String[] getArea() {
		BufferedReader br = null;
		String data = "";
		String[] areas = null;
		try {
			br = new BufferedReader(new FileReader(new File("./src/main/resource/txt/Area.txt")));
			while((data = br.readLine())!=null)
			{
				areas = data.split(",");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return areas;
	}

	@Override
	public boolean addArea(String area) {
		String[] areas = getArea();
		int flag = 0;
		for(int i=0;i<areas.length;i++){
			if(area.equals(areas[i])){
				flag = 1;
			}
		}
		if(flag == 1){
			return false;
		}
		BufferedWriter bw;
		String data = "";
		try {
			bw = new BufferedWriter(new FileWriter(
					new File("./src/main/resource/txt/Area.txt"),true));
			bw.write(","+area);	
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
}
