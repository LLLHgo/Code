package businesslogicservice.hotelinfoblservice;

import java.util.ArrayList;

import Enum.ResultMessage;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public interface RoominfoBLService {
	/**
	 * 获得房间信息
	 * @param roomID
	 * @return 房间信息
	 */
	public RoominfoVO getroominfo(String hotelID,String roomID);
	/**
	 * 将房间信息持久化保存
	 * @param vo
	 * @return 是否将房间信息持久化保存
	 */
	public boolean updateroominfo(RoominfoVO vo,String hotelID);
	
	/**
	 * 获得系统内所有房间类型
	 * @return String[]
	 */
	public String[] getRoomType();
	
	/**
	 *添加房间类型
	 * @return boolean
	 */
	public boolean addRoomType(String type);
	/**
	 * 获得酒店所包含的所有房间列表
	 * @param hotelID
	 * @return
	 */
	ArrayList<RoominfoVO> getRoominfoList(String hotelID);
	/**
	 * 计算打折后的价格
	 * @return 最终价格
	 */
	public double calculatePrice(ArrayList<HotelStrategyVO> hotelStrategylist,
			ArrayList<MarketingStrategyVO> marketingStrategyList,ClientVO vo,double originalPrice);
}
