/**
 *hotelinfo的逻辑层包 
 */
package businesslogic.hoteinfobl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.hotelinfodataservice.HotelinfoDataService;
import po.RoominfoPO;
import rmi.RemoteHelper;
import vo.hotelinfoVO.RoominfoVO;
/**
 * 房间管理信息类
 * @author liuyu
 *负责处理roominfodata层传来的信息，持久化保存信息到hoteldata层，将room的信息分发到其他模块
 */
public class RoominfoManage{

	HotelinfoDataService data = RemoteHelper.getInstance().hotelinfoDataService();

//		data = new HotelinfoDataService_Stub();

	//获得房间信息
	public RoominfoVO getroominfo(String hotelID, String roomID) {
		RoominfoPO po = null;
		try {
			po = data.findroominfo(hotelID, roomID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(po==null){
			return null;
		}
		return po2vo(po);
	}

	//新增房间
	public boolean addroominfo(RoominfoVO vo){
		RoominfoPO po = new RoominfoPO(vo.getHotelID(),
				vo.getType(),vo.getRoomNum(),vo.getPrice(),vo.getRoomState());
		boolean result = false;
		try {
			result = data.insertroominfo(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}

		return result;
	}

	//更新房间信息
	public boolean updateroominfo(RoominfoVO vo,String hotelID) {
		RoominfoPO po = new RoominfoPO(vo.getHotelID(),
				vo.getType(),vo.getRoomNum(),vo.getPrice(),vo.getRoomState());
		boolean result = false;
		try {
			result = data.updateroominfo(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}

		return result;
	}


	//获得房间种类
	public String[] getRoomType() {
		try {
			return data.getRoomType();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}


	//新增房间类型
	public boolean addRoomType(String type) {
		try {
			return data.addRoomType(type);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}


	//获得房间信息列表
	public ArrayList<RoominfoVO> getRoominfoList(String hotelID) {
		ArrayList<RoominfoPO> listPO;
		ArrayList<RoominfoVO> listVO = new ArrayList<RoominfoVO>();
		try {
			listPO = (ArrayList<RoominfoPO>) data.findRoominfoList(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		if(listPO == null){
			return null;
		}
		for(int i=0;i<listPO.size();i++){
			listVO.add(po2vo(listPO.get(i)));
		}
		return listVO;
	}

	//房间信息的po包转vo包
	private RoominfoVO po2vo(RoominfoPO po){
		RoominfoVO vo;
		try{
			vo = new RoominfoVO(po.getHotelID(),po.getType(),po.getRoomNum(),
					po.getPrice(),po.getRoomState());
		}catch(NullPointerException e){
			e.printStackTrace();
			return null;
		}
		return vo;
	}

	//删除房间信息
	public boolean deleteroom(String hotelID,String roomID){
		try {
			return data.deleteroom(hotelID,roomID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	//已合并到clientgetHotelinfo中，不排除以后会使用到这个方法
	public  ArrayList<String> getAvailableRooms(String hotelID){
//		try {
//			ArrayList<RoominfoPO> list = (ArrayList<RoominfoPO>) data.findRoominfoList(hotelID);
//
//			for(int i=0;i<list.size();i++){
//				if(list.get(i).getRoomState()== RoomState.Usable){
//
//				}
//			}
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			return null;
//		}
		return null;
	}


}
