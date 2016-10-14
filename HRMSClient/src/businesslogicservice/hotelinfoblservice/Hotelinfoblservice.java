package businesslogicservice.hotelinfoblservice;

import java.util.List;

import Enum.ResultMessage;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public interface Hotelinfoblservice {
	/**
	 * 请求获得hotelID对应的酒店信息
	 * @param hotelID
	 * @return
	 */
	public HotelinfoVO getBasicinfo(String hotelID);
	/**
	 * 获得符合客户条件的酒店列表信息
	 * @param vo
	 * @return
	 */
	public List<HotelinfoVO> getBasicinfoList(ClientRequirementVO vo);
	/**
	 * 持久化保存酒店信息
	 * @param VO
	 * @return
	 */
	public ResultMessage updateBassicinfo(HotelinfoVO VO);
	/**
	 * 获得某酒店某类型的房间信息
	 * @param hotelID
	 * @param roomtype
	 * @return
	 */
	public RoominfoVO getRoominfo(String hotelID,String roomtype);
	/**
	 * 获得酒店的房间信息列表
	 * @param hotelID
	 * @return
	 */
	public List<RoominfoVO> getRoominfoList(String hotelID);
	/**
	 * 计算打折后的价格
	 * @return
	 */
	public double calculatePrice(List<HotelStrategyVO> hotelStrategylist,
			List<MarketingStrategyVO> marketingStrategyList,ClientVO vo,double originalPrice);
	/**
	 * 请求持久化保存网站管理人员添加的酒店信息
	 * @param vo
	 * @return
	 */
	public boolean saveSitemanagerAdd(HotelinfoVO vo);
}
