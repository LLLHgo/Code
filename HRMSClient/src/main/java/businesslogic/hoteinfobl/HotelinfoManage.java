/**
 *hotelinfo的逻辑层包 
 */
package businesslogic.hoteinfobl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Enum.HotelStrategy;
import Enum.ResultMessage;
import Enum.RoomState;
import Enum.Star;
import Enum.VIPType;
import businesslogic.hotelstaffbl.HotelstaffManage;
import businesslogic.strategybl.StrategyManage;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import businesslogicservice.strategyblservice.StrategyBLService;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService_Stub;
import po.HotelinfoPO;
import rmi.RemoteHelper;
import vo.areaVO.AreaVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.strategyVO.HotelStrategyVO;
/**
 * 酒店信息管理类
 * @author liuyu
 *负责处理hotelinfodata层传来的信息,持久化保存信息到hoteldata层，将酒店的信息分发到其他模块
 */
public class HotelinfoManage{

//	//桩测试
//	HotelinfoDataService data = new HotelinfoDataService_Stub();
	HotelinfoDataService data = RemoteHelper.getInstance().hotelinfoDataService();
	HotelinfoPO po;
	HotelinfoVO vo;

	//客户进行评价
	public boolean SetEvaluate(int star,String str,String clientID,String hotelID){
		String remark = star+" "+str+" "+clientID;
		try {
			return data.clientUpdatehotelinfo(remark,hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	//获得酒店信息
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
		vo = new HotelinfoVO(po.getName(),po.getAddress(),po.getArea(),po.getIntroduction(),
				po.getFacility(),po.getTel(),po.getStar(),po.getHotelID(),po.getCompanyList());
		return vo;
	}

	//获得酒店信息列表
	public ArrayList<HotelinfoVO> getBasicinfoList(String area,String hotelname,int hotelstar,String roomType) {
		int roomtypeinflag = 0;
		ArrayList<HotelinfoPO> listPO;
		ArrayList<HotelinfoVO> listVO = new ArrayList<HotelinfoVO>();
		RoominfoManage roominfoManage = new RoominfoManage();
		try {
			listPO = data.clientfindhotelinfo(area,hotelname,hotelstar);
			if(listPO == null){
				return null;
			}
			for(int i=0;i<listPO.size();i++){
				vo = PO2VO(listPO.get(i));
				//每次循环都先将Roomtypeinflag置为0
				roomtypeinflag = 0;

				ArrayList<RoominfoVO> roominfoList = roominfoManage.getRoominfoList(listPO.get(i).getHotelID());
				String[] roomtype = roominfoManage.getRoomType();
				//availablenum里存的是可用房间数
				int[] availablenum = new int[roomtype.length];
				for(int m=0;m<availablenum.length;m++){
					availablenum[m]=0;
				}
				if(roominfoList!=null){
					ArrayList<RoominfoVO> selected = new ArrayList<RoominfoVO>();
					for(int m=0;m<roomtype.length;m++){
						for(int n=0;n<roominfoList.size();n++){
							RoominfoVO roominfovo = roominfoList.get(n);
							//房间类型与所要的房间一致且房间状态是可用的
							if(roominfovo.getType().equals(roomtype[m])&&
								roominfovo.getRoomState()==RoomState.Usable){
								availablenum[m]++;
								if(availablenum[m]==1){
									selected.add(roominfovo);
								}
							}
						}
					}
					ArrayList<Integer> selectedArray = new ArrayList<Integer>();
					for(int p=0;p<availablenum.length;p++){
						int tempnum = availablenum[p];
						if(tempnum>0){
							selectedArray.add(tempnum);
						}
					}
					vo.setAvailableNum(selectedArray);
					vo.setRoominfoList(selected);
					// 传null表示界面没有要求
					if(roomType==null){
						roomtypeinflag = 1;
					}else{
						for(int q=0;q<selected.size();q++){
							if(roomType.equals(selected.get(q).getType())){
								roomtypeinflag=1;
							}
						}
					}
				}
				if(roomtypeinflag==1){
					listVO.add(vo);
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		return listVO;
	}


	//客户获得酒店基本信息（比getBasicinfo多传房间信息ArrayList）
	public HotelinfoVO clientgetBasicinfo(String hotelID){
		try {
			po = data.findhotelinfo(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		if(po == null){
			return null;
		}
		vo = new HotelinfoVO(po.getName(),po.getAddress(),po.getArea(),po.getIntroduction(),
				po.getFacility(),po.getTel(),po.getStar(),po.getHotelID(),po.getCompanyList());
		ArrayList<String> remark = po.getRemark();
		if(remark!=null){
			vo.setRemark(remark);
		}
		ArrayList<RoominfoVO> roominfoList = new RoominfoManage().getRoominfoList(po.getHotelID());
		if(roominfoList!=null){
			vo.setRoominfoList(roominfoList);
		}
		return vo;
	}

	//将酒店信息的PO包转成VO包
	private HotelinfoVO PO2VO(HotelinfoPO po){
			HotelinfoVO vo = new HotelinfoVO(po.getName(),po.getAddress(),po.getArea(),
			po.getTel(),null,po.getStar(),po.getRemark(),po.getIntroduction(),
			po.getHotelID());
//			HotelinfoVO vo = new HotelinfoVO();
//			vo.setName(po.getName());
//			vo.setAddress(po.getAddress());
//			vo.setArea(po.getArea());
//			vo.setTel(po.getTel());
//			vo.setStar(po.getStar());
//			vo.setRemark(po.getRemark());
//			vo.setIntroduction(po.getIntroduction());
			vo.setFacility(po.getFacility());
//			vo.setHotelID(po.getHotelID());
			return vo;
	}
//hotelstaff update hotelinfo
	//更新酒店基本信息
	public ResultMessage updateBassicinfo(HotelinfoVO VO) {
		if(VO==null||VO.getAddress()==null||VO.getArea()==null||VO.getFacility()==null||
		VO.getHotelID()==null||VO.getIntroduction()==null||VO.getStar()==null||
		VO.getTel()==null){
			return ResultMessage.VOIDINFO;
		}

		boolean result = false;
		try {
			po = new HotelinfoPO();
			po.setHotelID(VO.getHotelID());
			po.setAddress(VO.getAddress());
			po.setArea(VO.getArea());
			po.setCompanyList(VO.getCompany());
			po.setFacility(VO.getFacility());
			po.setIntroduction(VO.getIntroduction());
			po.setName(VO.getName());
			po.setTel(VO.getTel());
			po.setStar(VO.getStar());
			result = data.hotelstaffUpdatehotelinfo(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTEEXCEPTION;
		}
		if(result == true)
			return ResultMessage.SUCCESS;
		else return ResultMessage.FAIL;

	}

	//保存网站管理人员新增酒店和酒店工作人员信息
	public ResultMessage saveSitemanagerAdd(SitemanagerAddVO sitemanagerAddVO, HotelstaffVO hotelstaffVO) {
		String hotelname = sitemanagerAddVO.getName();
		if(hotelname==null||hotelname.equals("")){
			return ResultMessage.VOIDINFO;
		}
		String hotelID = null;
		try {
			hotelID = data.inserthotelinfo(hotelname);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTEEXCEPTION;
		}
		if(hotelID.equals("R")){
			return ResultMessage.DUPLICATENAME;
		}
		HotelstaffBLService hotelstaff = new HotelstaffManage();
		hotelstaffVO.setHotelID(hotelID);
		ResultMessage result  = hotelstaff.saveSitemanagerAdd(hotelstaffVO);
		if(result==ResultMessage.SUCCESS){
			Calendar c= Calendar.getInstance();
			StrategyBLService strategy = new StrategyManage();
			HotelStrategyVO vo = new HotelStrategyVO();
			vo.setStartTime(c);
			vo.setEndTime(c);
			vo.setDiscount(1);
			vo.setHotelID(hotelID);
			vo.setName("生日特惠折扣");
			vo.setType(HotelStrategy.BIRTHDAY);
			vo.setViptype(VIPType.ORDINARYVIP);
			strategy.updateHotelStrategy(vo);
			vo.setName("合作企业客户折扣");
			vo.setType(HotelStrategy.COMPANY);
			vo.setViptype(VIPType.ENTERPRISEVIP);
			strategy.updateHotelStrategy(vo);
			vo.setName("三间及以上预订特惠");
			vo.setType(HotelStrategy.OVERTHREEROOMS);
			vo.setViptype(VIPType.NONVIP);
			vo.setMinRooms(3);
			strategy.updateHotelStrategy(vo);
			vo.setName("双十一活动折扣");
			vo.setType(HotelStrategy.SPECIALDAY);
			vo.setViptype(VIPType.NONVIP);
			strategy.updateHotelStrategy(vo);
		}
		return result;
	}

	//获得商圈
	public String[] getArea() {
		try {
			return data.getArea();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}


	//增加商圈
	public boolean addArea(String area) {
		try {
			return data.addArea(area);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}


	//获得商圈中所有酒店名称信息
	public List<AreaVO> getAreaHotels() {
		String[] areas = getArea();
		ArrayList<HotelinfoPO> hotelinfoPOList = new ArrayList<HotelinfoPO>();
		ArrayList<String> hotels;
		ArrayList<AreaVO> areaVOList= new ArrayList<AreaVO>();
		try {
			for(int i=0;i<areas.length;i++){
				hotelinfoPOList = data.findHotelinfoList(areas[i]);
				if(hotelinfoPOList!=null){
					hotels = new ArrayList<String>();
					for(int j=0;j<hotelinfoPOList.size();j++){
						hotels.add(hotelinfoPOList.get(j).getName());
					}
					if(!hotels.isEmpty()){
						AreaVO vo = new AreaVO(areas[i],hotels);
						areaVOList.add(vo);
					}
				}
			}
			} catch (RemoteException e) {
				e.printStackTrace();
				return null;
		}
		return areaVOList;
	}


	//根据酒店星级对酒店进行排序，酒店星级高的在前
	public ArrayList<HotelinfoVO> rankHotelAccordingtoHotelStar(ArrayList<HotelinfoVO> list){
		Collections.sort(list,new SortHotelStar());
		return list;
	}

	//根据评价星级对酒店进行排序，评分星级高的在前
	public ArrayList<HotelinfoVO> rankHotelAccordingtoRemarkStar(ArrayList<HotelinfoVO> list) {
		Collections.sort(list,new SortRemarkStar());
		return list;
	}

	//根据酒店最低可用房间价格对酒店进行排序，最低房间价格低的在前
	public ArrayList<HotelinfoVO> rankHotelAccordingtoMinPrice(ArrayList<HotelinfoVO> list) {
		Collections.sort(list,new SortMinPrice());
		return list;
	}
}
